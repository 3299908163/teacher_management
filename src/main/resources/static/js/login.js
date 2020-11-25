$(function(){
    var vm = new Vue({
        el: '#app',
        data: {
            userIdentity: '', // 输入的身份证号
            userName: '', // 输入的姓名
            identityMsg: '', // 验证身份证号的信息
            nameMsg: '', // 验证姓名的信息
            popMessage: '', // 弹出层显示信息
        },
        methods: {
            /**
             * 弹出层弹出方法
             */
            popUp(message) {
                this.popMessage = message
                $(".pop-up").slideDown(300);
            },
            /**
             * 弹出层隐藏方法
             */
            popDown() {
                this.popMessage = ''
                $(".pop-up").slideUp(300);
            },
            /**
             * 验证失去焦点方法
             * 数据为空 return 0
             * 数据验证成功 return 1
             * 数据验证失败 return -1
             * @param {Object} e 当前元素
             * @param {Object} reg 正则表达式
             * @param {Object} data 输入数据
             */
            blurCheck(e, reg, data) {
                var e = $(e);
                e.removeClass("is-valid")
                e.removeClass("is-invalid")
                if (data == "") { //数据为空
                    e.addClass("is-invalid")
                    return 0
                } else if (reg.test(data)) { // 数据验证成功
                    e.addClass("is-valid")
                    return 1;
                } else { // 数据验证失败
                    e.addClass("is-invalid")
                    return -1;
                }
            },
            /**
             * 身份证文本框失去焦点执行
             * @param {Object} e
             */
            identityBlur(e) {
                var event = e.target
                var reg = /^\d{17}[\d|x|X]$|^\d{15}$/; // 验证身份证的正则表达式
                var flag = this.blurCheck(event, reg, this.userIdentity);
                if (flag == 0) {
                    this.identityMsg = '身份证号不可以为空'
                } else if (flag == 1) {
                    this.identityMsg = ''
                } else if (flag == -1) {
                    this.identityMsg = '身份证格式有误，请确认'
                }
            },
            /**
             * 文本改变时取消错误样式
             */
            inputChange(e){
                var event = e.target
                if(this.userIdentity.length > 1){
                    return true
                }
                $(event).removeClass("is-invalid")
            },
            /**
             * 姓名文本框失去焦点执行
             * @param {Object} e
             */
            nameBlur(e) {
                var event = e.target
                var reg = new RegExp("[\\u4E00-\\u9FFF]+","g")
                var flag = this.blurCheck(event, reg, this.userName);
                if (flag == 0) {
                    this.nameMsg = '姓名不可以为空'
                } else if (flag == 1) {
                    this.nameMsg = ''
                } else if (flag == -1) {
                    this.nameMsg = '姓名格式有误，请确认'
                }
            },
            /**
             * 登陆方法
             */
            login() {
                // 判断输入是否全部合法
                var flag = true;
                // 若所有的input输入框中都有is-valid样式 则flag = true
                if ($('form').find('.is-invalid').length > 0 || this.userName == '' || this.userIdentity == '') {
                    flag = false;
                }
                if(flag){
                    //发送登陆请求
                    this.$http.get('user/login?userIdentity=' + this.userIdentity + "&userName=" + this.userName).then(result => {
                        var result = result.body;
                    // 登陆成功
                    if (result.Code == 200) {
                        if (result.Data == "1") {
                            this.popUp('登陆成功,即将跳往主页面...')
                            setTimeout(function () {
                                location.href = 'intoindex'
                            }, 2000);
                        } else if (result.Data == "0") {
                            alert("您不是管理员！")
                        }
                    }
                        else if (result.Code == 5002) { // 身份证号尚未保存
                        // 清空input输入框并添加提示信息与错误样式
                        this.userIdentity = ''
                        this.identityMsg = '身份证号尚未保存'
                        $(this.$refs.userIdentity).removeClass('is-valid').addClass('is-invalid').focus()
                    } else if (result.Code == 5003) { // 身份证号与姓名不匹配
                        // 清空input输入框并添加提示信息与错误样式
                        this.userName = ''
                        this.nameMsg = '身份证号与姓名不匹配'
                        $(this.$refs.userName).removeClass('is-valid').addClass('is-invalid').focus()
                    }
                })
                }
            }
        },
        created() {
            var _this = this;
            /**
             * 全局监听键盘事件: 敲击回车执行login()
             */
            document.onkeydown = function(e) {
                var key = window.event.keyCode;
                if (key == 13) {
                    _this.login()
                }
            }
        }
    })
})