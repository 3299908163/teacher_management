
layui.use(['form','table','layer'],function () {
     var  table = layui.table
        , form = layui.form
        ,layer=layui.layer
        , $ = layui.jquery;

    //点击加载教师信息页面
    $("#TeacherList").click(function () {
        $("#content").load("intoTeacherInfo", function (data) {
            if(eval('(' + data + ')').Code.toString()=="600"){
                window.location = "user/toErrorLogin"
                return;
            }
            layui.use('element', function () {
                var element = layui.element;
            });
        });
    });
    //点击加载添加页面
    $("#TeacgerAdd").click(function () {
        $("#content").load("intoTeacherAdd", function (data) {
            if(eval('(' + data + ')').Code.toString()=="600"){
                window.location = "user/toErrorLogin"
                return;
            }
            layui.use('element', function () {
                var element = layui.element;
            });
        });
    });
    //点击加载学科页面
    $("#userList").click(function () {
        $("#content").load("intoSubjectInfo", function (data) {
            if(eval('(' + data + ')').Code.toString()=="600"){
                window.location = "user/toErrorLogin"
                return;
            }
            layui.use('element', function () {
                var element = layui.element;
            });
        });
    });
    //点击加载职称资格页面
    $("#TitleList").click(function () {
        $("#content").load("intoTitleInfo", function (data) {
            if(eval('(' + data + ')').Code.toString()=="600"){
                window.location = "user/toErrorLogin"
                return;
            }
            layui.use('element', function () {
                var element = layui.element;
            });
        });
    });
    //点击加载合同页面
    $("#ContractList").click(function () {
        $("#content").load("intoContractInfo", function (data) {
            if(eval('(' + data + ')').Code.toString()=="600"){
                window.location = "user/toErrorLogin"
                return;
            }
            layui.use('element', function () {
                var element = layui.element;
            });
        });
    });
    //点击加载教师资格种类页面
    $("#QualificationList").click(function () {
        $("#content").load("intoQualificationInfo", function (data) {
            if(eval('(' + data + ')').Code.toString()=="600"){
                window.location = "user/toErrorLogin"
                return;
            }
            layui.use('element', function () {
                var element = layui.element;
            });
        });
    });
    //点击加载专业页面
    $("#ProfessionalList").click(function () {
        $("#content").load("intoProfessionalInfo", function (data) {
            if(eval('(' + data + ')').Code.toString()=="600"){
                window.location = "user/toErrorLogin"
                return;
            }
            layui.use('element', function () {
                var element = layui.element;
            });
        });
    });
    //点击加载专业技术职务页面
    $("#PositionList").click(function () {
        $("#content").load("intoPositionInfo", function (data) {
            if(eval('(' + data + ')').Code.toString()=="600"){
                window.location = "user/toErrorLogin"
                return;
            }
            layui.use('element', function () {
                var element = layui.element;
            });
        });
    });
    //点击加载学历页面
    $("#EducationList").click(function () {
        $("#content").load("intoEducationInfo", function (data) {
            if(eval('(' + data + ')').Code.toString()=="600"){
                window.location = "user/toErrorLogin"
                return;
            }
            layui.use('element', function () {
                var element = layui.element;
            });
        });
    });
    //点击加载学位页面
    $("#DegreeList").click(function () {
        $("#content").load("intoDegreeInfo", function (data) {
            if(eval('(' + data + ')').Code.toString()=="600"){
                window.location = "user/toErrorLogin"
                return;
            }
            layui.use('element', function () {
                var element = layui.element;
            });
        });
    });

    //点击退出
    $("#out").click(function () {
        $.getJSON("/user/sessionCancellation",function (data) {
            if(data.toString()=="true"){       //退出
                location.href = "intoLogin";
            }
        })
    });
});


