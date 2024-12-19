<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>管理员登录</title>
    <link href="${pageContext.request.contextPath}/css/login/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript">

    </script>
</head>

<body class="loginbody">
<form method="post" action="./" id="form1">
    <div class="aspNetHidden">
        <input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE"
               value="/wEPDwUJODk3NzU1NTEyZGTOa1hvJdWhl7zOacxtwPVCzy4Ez2WsLMQaooX/mhhTww=="/>
    </div>
    <script type="text/javascript">
        $(function () {
            $("#btnSubmit").click(function () {
                if(($("#txtUserName").val().length > 1)&&(($("#txtPassword").val().length > 1))){


                    $.ajax({
                        url: "${pageContext.request.contextPath}/tologin",
                        type: "post",
                        data: {
                            name: $("#txtUserName").val(),
                            password: $("#txtPassword").val()
                        }, success: function (a) {
                            location.href = "${pageContext.request.contextPath}/list.jsp"
                        }, error: function (jqxhr, status, err) {
                            if ((JSON.parse(jqxhr.responseText)).message !== undefined) {
                                alert((JSON.parse(jqxhr.responseText)).message)
                            }


                        }
                    })
                } else alert("用户名密码为空!")
            })
        })

    </script>
    <div class="aspNetHidden">

        <input type="hidden" name="__VIEWSTATEGENERATOR" id="__VIEWSTATEGENERATOR" value="C2EE9ABB"/>
        <input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION"
               value="/wEdAATtZYZGQirfi5jO5FDCpF1MY3plgk0YBAefRz3MyBlTcHY2+Mc6SrnAqio3oCKbxYY85pbWlDO2hADfoPXD/5tdfsoFQgztrK/PvxlQHKfGKw6b16sB4IcAXUI+R2tKTEg="/>
    </div>
    <div class="login-screen">

        <div class="login-form">
            <h1>系统管理登录</h1>
            <div class="control-group">
                <input name="txtUserName" type="text" id="txtUserName" class="login-field" placeholder="用户名"
                       title="用户名"/>
                <label class="login-field-icon user" for="txtUserName"></label>
            </div>
            <div class="control-group">
                <input name="txtPassword" type="password" id="txtPassword" class="login-field" placeholder="密码"
                       title="密码"/>
                <label class="login-field-icon pwd" for="txtPassword"></label>
            </div>
            <div><input type="button" name="btnSubmit" value="登 录" id="btnSubmit" class="btn-login"/></div>
            <span class="login-tips"><i></i><b id="msgtip">请输入用户名和密码</b></span>
        </div>


    </div>
</form>
</body>
</html>
