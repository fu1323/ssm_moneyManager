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
    <input type="file" name="file"/>
    <button type="submit">上传文件</button>
</form>

<button type="button" id="b">ovpn_Conf</button>
<button type="button" id="c">xray_api</button>


<button type="button" id="a">返回</button>
<ul id="resultList">
</ul>
<script>$(function () {
    // 1. 获取 xray 状态
    $("#c").click(function () {
        $.ajax({
            url: "/xray",
            type: "get",
            success: function (a0) {
                // 如果后端返回的是 JSON 字符串，取消下一行的注释解析一下：
                 if (typeof a0 === "string") a0 = JSON.parse(a0);

                    $('#resultList').empty();

                    var statList = a0.stat || [];

                    $.each(statList, function (index, item) {
                        var mbVal = ((item.value || 0) / 1024 / 1024).toFixed(2) + " MB";

                        $('#resultList').append(
                            '<li>' +
                            '<strong>' + item.name + '</strong> ' +
                            '<span>' + mbVal + '</span> ' +
                            // '<button class="cls">清零</button>' +
                            '</li>'
                        );
                    });

            },
            error: function (xhr, status, error) {
                console.error("请求失败:", error);
            }
        });
    });

    // 2. 返回按钮
    $("#a").click(function () {
        window.location.href = "/list.jsp";
    });

    // 3. 动态元素的事件绑定（使用事件委托机制）
    $(document).on("click", ".cls", function () {
        let parent = this.parentNode.children;
        let name = parent[0].textContent;

        $.ajax({
            url: "/xrayreset",
            type: "get",
            data: {
                "name": name
            },
            success: function (a0) {

                    alert("成功");
                    $("#c").click(); // 重新加载列表

            }
        });
    });

    // 4. ovpn 配置
    $("#b").click(function () {
        var tmp = prompt("输入url:");
        if (!tmp) return;

        $.ajax({
            url: "/vpn",
            type: "post",
            data: {
                "url": tmp
            },
            success: function (a0) {
                if (a0.code === "200" || a0.code === 200) {
                    alert("成功");
                    location.reload();
                }
            }
        });
    });
});
</script>
</body>
</html>
