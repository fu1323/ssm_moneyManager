<%--
  Created by IntelliJ IDEA.
  User: fuchunming
  Date: 2025/3/9
  Time: 下午1:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<head>
    <title>upload</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">
   <center><h3 style="color: red"> ${message}</h3></center>
    <input type="file" name="file" />
    <button type="submit">上传文件</button>
</form>

    <button type="button" id="b">ovpn_Conf</button>





    <button type="button" id="a">返回</button>
<script>$(function(){

    $("#a").click(function(){
        window.location.href="${pageContext.request.contextPath}/list.jsp"

    })

     $("#b").click(function(){
            var tmp = prompt("输入url:")

                                                $.ajax({
                                                    url: "/vpn",
                                                    type: "post",
                                                    data: {
                                                        "url": tmp

                                                    }, success: function (a0) {
                                                        // alert(a0.code)
                                                        if (a0.code === "200") {
                                                            alert("成功")
                                                            reload()
                                                        }

        }

                          })})})</script>
</body>
</html>
