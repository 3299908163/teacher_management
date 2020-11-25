$(function(){

    var vm = new Vue({
        el: '#app',
        data: {
            userIdentity: '',   // 身份证号
            userName: '',       // 姓名
            identityMsg: '',    // 验证身份证号的信息
            nameMsg: '',        // 验证姓名的信息
            popMessage: '',     // 弹出层显示信息
            subjectList: [],    //学科集合
            titleList:[],       //职称资格证集合
            positionList:[],    //专业技术职务
            qualificationList:[],   //教师资格种类
            contractList:[],    //合同编号
            degreeList:[],      //学位
            userAddress: '',    //地址
            userPhone:''  ,     //电话
            userBirthday:'',    //出生年月
            userWorkhours:'',   //参与工作时间
            userJoinparty:'',   //入党时间
            userEmail:'',        //邮箱
            titleTime:'',
            contractStarttime:'',
            contractEndtime:'',
            educationFirstName:'',
            educationFirstSchool:'',
            educationFirstProfessionalName:'',
            educationFirstGraduationtime:'',
            educationHighestName:'',
            educationHighestSchool:'',
            educationHighestProfessionalName:'',
            educationHighestGraduationtime:'',
            remarks:''
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
            getSubjectOnList(){
                this.$http.get('/subject/getSubjectListByCreate').then(result => {
                    var result = result.body
                    if(result.Code == 200){
                    this.subjectList = result.Data
                }else{
                    alert("获取学科列表失败")
                }
            });
            },
            getTitleOnList(){
                this.$http.get('/title/getTitleListByCreate').then(result => {
                    var result = result.body
                    if(result.Code == 200){
                    this.titleList = result.Data
                }else{
                    alert("获取职称资格列表失败")
                }
            });
            },
            getPositionOnList(){
                this.$http.get('/position/getPositionListByCreate').then(result => {
                    var result = result.body
                    if(result.Code == 200){
                    this.positionList = result.Data
                }else{
                    alert("获取专业技术职务列表失败")
                }
            });
            },
            getQualificationOnList(){
                this.$http.get('/qualification/getQualificationListByCreate').then(result => {
                    var result = result.body
                    if(result.Code == 200){
                    this.qualificationList = result.Data
                }else{
                    alert("获取教师资格种类列表失败")
                }
            });
            },
            getContractOnList(){
                this.$http.get('/contract/getContractListByCreate').then(result => {
                    var result = result.body
                    if(result.Code == 200){
                    this.contractList = result.Data
                }else{
                    alert("获取合同列表失败")
                }
            });
            },
            getDegreeOnList(){
                this.$http.get('/degree/getDegreeListByCreate').then(result => {
                    var result = result.body
                    if(result.Code == 200){
                    this.degreeList = result.Data
                }else{
                    alert("获取学位列表失败")
                }
            });
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
             * 添加方法
             */
            addTeacher() {
                // 验证手机格式
                var pattern = /^1[34578]\d{9}$/;
                //验证邮箱格式
                var emailStr = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
                if(!pattern.test(this.userPhone.trim())){
                    alert("你的手机格式不正确");
                    return false;
                }
                if(!emailStr.test(this.userEmail.trim())){
                    alert("你的邮箱格式不正确")
                    return false;
                }
                if(this.$refs.subject.value==0){
                    alert("请选择学科");
                    return;
                }
                if(this.$refs.userSex.value<0){
                    alert("请选择性别");
                    return;
                }
                if(this.$refs.isAdmin.value<0){
                    alert("请选择身份");
                    return;
                }
                if(this.$refs.title.value==0){
                    alert("请选择职称资格证");
                    return;
                }
                if(this.$refs.qualification.value<0){
                    alert("请选择教师资格种类");
                    return;
                }
                if(this.$refs.position.value<0){
                    alert("请选择专业技术职务");
                    return;
                }
                if(this.$refs.degree.value==0){
                    alert("请选择学位");
                    return;
                }
                if(this.$refs.contract.value<0){
                    alert("请选择合同");
                    return;
                }
                // 判断输入是否全部合法
                var flag = true;
                // 若所有的input输入框中都有is-valid样式 则flag = true
                if ($('form').find('.is-invalid').length > 0 || this.userName == '' || this.userIdentity == '') {
                    flag = false;
                }
                if(flag){
                    //发送登陆请求
                    this.$http.get("teacher/addTeacher?userName=" + this.userName + "&userIdentity=" + this.userIdentity + "&userAddress=" + this.userAddress
                        + "&userSex=" + this.$refs.userSex.value + "&userBirthday=" + this.userBirthday +"&userWorkhours=" + this.userWorkhours
                        + "&userJoinparty=" + this.userJoinparty + "&userPhone=" + this.userPhone + "&userEmail=" + this.userEmail + "&titleId=" + this.$refs.title.value
                        + "&titleTime=" + this.titleTime + "&positionId=" + this.$refs.position.value + "&qualificationId=" + this.$refs.qualification.value
                        + "&subjectId=" + this.$refs.subject.value + "&contractId=" + this.$refs.contract.value + "&contractStarttime=" + this.contractStarttime
                        + "&contractEndtime=" + this.contractEndtime + "&educationFirstName=" + this.educationFirstName + "&educationFirstSchool=" + this.educationFirstSchool
                        + "&educationFirstProfessionalName=" + this.educationFirstProfessionalName + "&educationFirstGraduationtime=" + this.educationFirstGraduationtime
                        + "&degreeId=" + this.$refs.degree.value + "&educationHighestName=" + this.educationHighestName + "&educationHighestSchool=" + this.educationHighestSchool
                        + "&educationHighestProfessionalName=" + this.educationHighestProfessionalName + "&educationHighestGraduationtime=" + this.educationHighestGraduationtime
                        + "&remarks=" + this.remarks + "&isAdmin=" + this.$refs.isAdmin.value).then(result => {
                        var result = result.body;
                    if(result.Code==600){
                        alert("此用户已存在")
                        return;
                    }
                    // 注册成功
                    if (result.Code == 200) {
                        layer.alert("添加成功！！");
                        $("#content").load("/intoTeacherInfo", function (data) {
                            if (eval('(' + data + ')').Code.toString() == "600") {
                                window.location = "/user/toErrorLogin";
                                return;
                            }
                            layui.use('element', function () {
                                var element = layui.element;
                            });
                        });
                    } else if (result.Code == 5002) { // 身份证号尚未保存
                        // 清空input输入框并添加提示信息与错误样式
                        this.userIdentity = ''
                        this.identityMsg = '身份证号尚未保存'
                        $(this.$refs.userIdentity).removeClass('is-valid').addClass('is-invalid').focus()
                    }
                })
                }
            }
        },

        created() {
            this.getDegreeOnList();
            this.getContractOnList();
            this.getPositionOnList();
            this.getQualificationOnList();
            this.getTitleOnList();
            this.getSubjectOnList();
            var _this = this;
            /**
             * 全局监听键盘事件: 敲击回车执行login()
             */
            document.onkeydown = function(e) {
                var key = window.event.keyCode;
                if (key == 13) {
                    _this.registerUser()
                }
            }
        }
    })
})