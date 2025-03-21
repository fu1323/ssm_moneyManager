<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <script src="js/color-modes.js"></script>
    <%
        if (request.getSession().getAttribute("user") == null) {


            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }

    %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.118.2">
    <title>小金库</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/headers/">


    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">

    <link href="css/bootstrap.min.css" rel="stylesheet">

    <style>
        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        .nav-scroller .nav {
            display: flex;
            flex-wrap: nowrap;
            padding-bottom: 1rem;
            margin-top: -1px;
            overflow-x: auto;
            text-align: center;
            white-space: nowrap;
            -webkit-overflow-scrolling: touch;
        }

        .bd-mode-toggle .dropdown-menu .active .bi {
            display: block /* !important;*/

        }
    </style>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.2.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- Custom styles for this template -->
    <link href="css/headers.css" rel="stylesheet">
</head>
<%--<body>--%>

<svg xmlns="http://www.w3.org/2000/svg" class="d-none">
    <symbol id="check2" viewBox="0 0 16 16">
        <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>
    </symbol>
    <symbol id="circle-half" viewBox="0 0 16 16">
        <path d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z"/>
    </symbol>
    <symbol id="moon-stars-fill" viewBox="0 0 16 16">
        <path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z"/>
        <path d="M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z"/>
    </symbol>
    <symbol id="sun-fill" viewBox="0 0 16 16">
        <path d="M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z"/>
    </symbol>
</svg>


<svg xmlns="http://www.w3.org/2000/svg" class="d-none">
    <symbol id="bootstrap" viewBox="0 0 118 94">
        <title>Bootstrap</title>
        <path fill-rule="evenodd" clip-rule="evenodd"
              d="M24.509 0c-6.733 0-11.715 5.893-11.492 12.284.214 6.14-.064 14.092-2.066 20.577C8.943 39.365 5.547 43.485 0 44.014v5.972c5.547.529 8.943 4.649 10.951 11.153 2.002 6.485 2.28 14.437 2.066 20.577C12.794 88.106 17.776 94 24.51 94H93.5c6.733 0 11.714-5.893 11.491-12.284-.214-6.14.064-14.092 2.066-20.577 2.009-6.504 5.396-10.624 10.943-11.153v-5.972c-5.547-.529-8.934-4.649-10.943-11.153-2.002-6.484-2.28-14.437-2.066-20.577C105.214 5.894 100.233 0 93.5 0H24.508zM80 57.863C80 66.663 73.436 72 62.543 72H44a2 2 0 01-2-2V24a2 2 0 012-2h18.437c9.083 0 15.044 4.92 15.044 12.474 0 5.302-4.01 10.049-9.119 10.88v.277C75.317 46.394 80 51.21 80 57.863zM60.521 28.34H49.948v14.934h8.905c6.884 0 10.68-2.772 10.68-7.727 0-4.643-3.264-7.207-9.012-7.207zM49.948 49.2v16.458H60.91c7.167 0 10.964-2.876 10.964-8.281 0-5.406-3.903-8.178-11.425-8.178H49.948z"></path>
    </symbol>
    <symbol id="home" viewBox="0 0 16 16">
        <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5z"/>
    </symbol>
    <symbol id="speedometer2" viewBox="0 0 16 16">
        <path d="M8 4a.5.5 0 0 1 .5.5V6a.5.5 0 0 1-1 0V4.5A.5.5 0 0 1 8 4zM3.732 5.732a.5.5 0 0 1 .707 0l.915.914a.5.5 0 1 1-.708.708l-.914-.915a.5.5 0 0 1 0-.707zM2 10a.5.5 0 0 1 .5-.5h1.586a.5.5 0 0 1 0 1H2.5A.5.5 0 0 1 2 10zm9.5 0a.5.5 0 0 1 .5-.5h1.5a.5.5 0 0 1 0 1H12a.5.5 0 0 1-.5-.5zm.754-4.246a.389.389 0 0 0-.527-.02L7.547 9.31a.91.91 0 1 0 1.302 1.258l3.434-4.297a.389.389 0 0 0-.029-.518z"/>
        <path fill-rule="evenodd"
              d="M0 10a8 8 0 1 1 15.547 2.661c-.442 1.253-1.845 1.602-2.932 1.25C11.309 13.488 9.475 13 8 13c-1.474 0-3.31.488-4.615.911-1.087.352-2.49.003-2.932-1.25A7.988 7.988 0 0 1 0 10zm8-7a7 7 0 0 0-6.603 9.329c.203.575.923.876 1.68.63C4.397 12.533 6.358 12 8 12s3.604.532 4.923.96c.757.245 1.477-.056 1.68-.631A7 7 0 0 0 8 3z"/>
    </symbol>
    <symbol id="table" viewBox="0 0 16 16">
        <path d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm15 2h-4v3h4V4zm0 4h-4v3h4V8zm0 4h-4v3h3a1 1 0 0 0 1-1v-2zm-5 3v-3H6v3h4zm-5 0v-3H1v2a1 1 0 0 0 1 1h3zm-4-4h4V8H1v3zm0-4h4V4H1v3zm5-3v3h4V4H6zm4 4H6v3h4V8z"/>
    </symbol>
    <symbol id="people-circle" viewBox="0 0 16 16">
        <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
        <path fill-rule="evenodd"
              d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
    </symbol>
    <symbol id="grid" viewBox="0 0 16 16">
        <path d="M1 2.5A1.5 1.5 0 0 1 2.5 1h3A1.5 1.5 0 0 1 7 2.5v3A1.5 1.5 0 0 1 5.5 7h-3A1.5 1.5 0 0 1 1 5.5v-3zM2.5 2a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3zm6.5.5A1.5 1.5 0 0 1 10.5 1h3A1.5 1.5 0 0 1 15 2.5v3A1.5 1.5 0 0 1 13.5 7h-3A1.5 1.5 0 0 1 9 5.5v-3zm1.5-.5a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3zM1 10.5A1.5 1.5 0 0 1 2.5 9h3A1.5 1.5 0 0 1 7 10.5v3A1.5 1.5 0 0 1 5.5 15h-3A1.5 1.5 0 0 1 1 13.5v-3zm1.5-.5a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3zm6.5.5A1.5 1.5 0 0 1 10.5 9h3a1.5 1.5 0 0 1 1.5 1.5v3a1.5 1.5 0 0 1-1.5 1.5h-3A1.5 1.5 0 0 1 9 13.5v-3zm1.5-.5a.5.5 0 0 0-.5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 0-.5-.5h-3z"/>
    </symbol>
</svg>
<main>
    <div class="container">
        <header class="d-flex justify-content-center py-3">
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="${pageContext.request.contextPath}/list.jsp?a=1" class="nav-link active"
                                        aria-current="page" id="mainp">返回</a></li>
            </ul>
        </header>
    </div>
</main>
<style>
    #draggable {
        width: 50px;
        height: 55px;
        background-color: lightskyblue;
        position: absolute;
        top: 150px;
        left: 50px;
        /*cursor: move;*/
        touch-action: none;

    }
</style>
<script></script>

<div id="draggable">
    <table class="table-bordered">
        <thead>
        <tr>
            <th>
                小金库
            </th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td id="all">
                1
            </td>
        </tr>
        </tbody>

        <tbody>

        </tbody>

    </table>

    <%--    <input type="button" value="修改" id="dragsub" style="margin-left: 40px">--%>
</div>


<script src="js/bootstrap.bundle.min.js"></script>
<script>
    $(function () {

        $.ajax({
            url: "${pageContext.request.contextPath}/gold/price",
            type: "get",
            success: function (a0) {
                $("#all").text(a0.price)
            }

        })


        draggable = document.getElementById("draggable");
        $("#fu").click(function () {
            fu(this)
        })
        $("#create").hide()
        $("#monetPX").hide()
        draggable.addEventListener("pointerdown", (event) => {
            // event.preventDefault()
            isDragging = true;
            offsetX = event.clientX - draggable.offsetLeft;
            offsetY = event.clientY - draggable.offsetTop;
        });

        // 拖动时更新位置
        document.addEventListener("pointermove", (event) => {
            // event.preventDefault();
            let ae = event.clientX - offsetX > 0 ? event.clientX - offsetX : 0;
            let be = event.clientY - offsetY > 0 ? event.clientY - offsetY : 0;
            if (isDragging) {
                draggable.style.left = ae + "px"
                draggable.style.top = be + "px"
            }
        });

        // 停止拖动
        document.addEventListener("pointerup", (event) => {
            // event.preventDefault()
            isDragging = false;
        });
    })
    $.ajax({
        url: "${pageContext.request.contextPath}/gold/query",
        type: "get",
        success: function (a) {
            loading(a)
        }
    })
    let loading = function (b) {
        let a = 1;
        for (let i = 0; i < b.length; i++) {
            var htmlTableRowElement1 = document.createElement("tr");
            $(htmlTableRowElement1).addClass("addCell")
            var ele = document.createElement("td");
            $(ele).text(a)
            a++;
            $(htmlTableRowElement1).append(ele)

            var htmlTableRowElement0 = document.createElement("td");
            $(htmlTableRowElement0).id = "idA"
            $(htmlTableRowElement0).text(b[i].id)
            $(htmlTableRowElement0).hide()
            $(htmlTableRowElement1).append(htmlTableRowElement0)


            var htmlTableRowElementb = document.createElement("td");
            $(htmlTableRowElementb).text(b[i].price)
            $(htmlTableRowElement1).append(htmlTableRowElementb)


            var htmlTableRowElementbb = document.createElement("td");
            $(htmlTableRowElementbb).text(b[i].name)
            $(htmlTableRowElement1).append(htmlTableRowElementbb)


            var htmlTableRowElementa = document.createElement("td");
            // alert(b[i].date)
            $(htmlTableRowElementa).text(new Date(b[i].date).toLocaleDateString())
            $(htmlTableRowElement1).append(htmlTableRowElementa)
            /*if (main) {*/
            var htmlTableRowElementc = document.createElement("td");
            $(htmlTableRowElementc).text(b[i].comment)

            // $(htmlTableRowElementc).hide()
            $(htmlTableRowElement1).append(htmlTableRowElementc)
            /* }*/
            var htmlInputElement = document.createElement("input");

            htmlInputElement.type = "button";
            $(htmlInputElement).css("border", "none")
            htmlInputElement.value = "修改"
            htmlInputElement.className = "modify"
            htmlInputElement.name = "modify";
            if (b[i].editable) {
                htmlInputElement.style.color = "blue"
                $(htmlInputElement).click(function () {
                    modify(this)
                })
            } else {
                $(htmlInputElement).attr("disabled", "disabled")
                $(htmlInputElement).val("不可修改")
            }
            $(htmlTableRowElement1).append(htmlInputElement)

            if (b[i].price < 0) {
                $(htmlTableRowElement1).children().each(function (index, ele) {
                    $(ele).css("background", "pink")
                    /*b[i].conbinationId*/
                })
                $(htmlTableRowElement1).css("background", "pink")
            }
            if (String(b[i].comment).includes("高亮")) {
                $(htmlTableRowElement1).children().each(function (index, ele) {
                    $(ele).css("background", "yellow")
                    /*b[i].conbinationId*/
                })
                $(htmlTableRowElement1).css("background", "yellow")
            }


            $("#trbtn").before(htmlTableRowElement1)
        }

    }
    let update = function () {
        $(document).off("keydown");

        $.ajax({
            url: "${pageContext.request.contextPath}/gold/update",
            type: "post",
            data: {
                "name": $("#nameupd").val(),
                "date": $("#dateupd").val(),
                "id": $("#idupd").text(),
                "comment": $("#commentupd").val(),

                "price": $("#priceupd").val()
            }, success: function (a0) {
                if (a0.code === "200") {
                    alert("成功")
                    window.location.reload(true)
                }
            }, error: function () {
                alert("操作失败")
            }
        })


    }
    let del = function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/gold/delete?id=" + $("#idupd").text(),
            type: "delete", success: function (a0) {

                if (a0.code === "200") {
                    alert("成功")
                    window.location.reload(true)

                }
            }, error: function () {
            }
        })

    }
    let modify = function (a) {

        let lst = a.parentNode.children;
        $(lst[0]).empty()
        var htmlInputElement = document.createElement("input");
        htmlInputElement.type = "button";
        htmlInputElement.name = "bton";
        htmlInputElement.value = "删除"
        $(htmlInputElement).click(function () {
            del()
        })
        $(lst[0]).append(htmlInputElement)
        x($(lst[2]), "text", "priceupd")
        $(lst[1]).attr("id", "idupd")
        x($(lst[3]), "text", "nameupd")
        x($(lst[5]), "text", "commentupd")

        x($(lst[4]), "date", "dateupd")
        $(lst[6]).val("提交")
        $(lst[6]).removeClass("modify")
        $(".modify").attr("disabled", "disabled")
        $(lst[6]).css("color", "red")
        $(lst[6]).off("click")
        $(lst[6]).click(update)
        $(document).on("keydown", function (event) {
            if (event.key === "Enter") {
                $(lst[6]).click(); // 触发按钮点击
            }
        });

        // $("#commentupd").attr("disabled", "disabled")

    }

    function x(lst, type, id) {
        // alert(num)
        var htmlInputElement = document.createElement("input");
        htmlInputElement.type = type;
        if (type === "date") {
            // alert(dateTool(lst.text()))
            htmlInputElement.value = dateTool(lst.text())
        } else {
            let num = $(lst).text()

            htmlInputElement.value = num
        }
        htmlInputElement.id = id;

        $(lst).empty();
        $(lst).append(htmlInputElement)
        $("input[type='text']").css('width', '100px');
    }

    let dateTool = function (a) {
        let mon = String(a).split("/")[1].length === 2 ? String(a).split("/")[1] : '0' + String(a).split("/")[1]
        let day = String(a).split("/")[2].length === 2 ? String(a).split("/")[2] : '0' + String(a).split("/")[2]
        return String(a).split("/")[0] + "-" + mon + "-" + day

    }
</script>
<div class="container" class="text-center mx-auto justify-content-center table-responsive ">
    <h3 style="display: inline-block;margin-left: 370px ;text-align: center" id="titled"> 总表</h3>

    <form id="form" method="post">
        <table border="1" class="table table-bordered table-hover" style="float: left;margin: 8px;" id="abc"
               width="500px">
            <thead class="row-cols-lg-5">
            <tr class="table-bordered" id="table">
                <th id="id">编号</th>
                <%--                    <th>名称</th>--%>
                <th>价格表达式</th>
                <th width="200px">名称</th>
                <th>时间</th>
                <th>备注</th>

                <th>操作</th>
            </tr>
            </thead>
            <tbody id="tbd">
            <tr id="trbtn">
                <td colspan="6" align="center" id="addbtn"><input name="add" type="button" value="添加"
                                                                  onclick="adder(this)"></td>
            </tr>
            </tbody>
            <script>
                let adder = function (a) {

                    // a.disabled = true
                    $("#trbtn").hide()
                    var attr1 = document.createElement("tr");
                    attr1.className = "add4btn"
                    let b = a.parentNode.colSpan;
                    for (let i = 0; i < b; i++) {
                        // alert(i)
                        var htmlTableCellElement = document.createElement("td");
                        var attr = document.createElement("input");


                        switch (i) {
                            case 1: {
                                attr.type = 'text';
                                attr.id = "priceB"
                                break;
                            }
                            case 0: {
                                attr.type = 'checkbox';
                                attr.id = "zhichucheck";
                                // attr.hidden = true;
                                break;
                            }
                            case 3: {
                                attr.type = 'date';
                                attr.name = 'date';
                                attr.id = 'dateB';
                                break;
                            }
                            case 2: {
                                attr.type = 'text';


                                attr.id = "nameB";
                                break;
                            }

                            case 4: {
                                attr.type = 'text';

                                // attr.type = 'date';
                                attr.name = 'comment';
                                attr.id = 'commentB';
                                break;

                            }

                        }


                        if (i === b - 1) {
                            attr.type = 'button';
                            attr.value = "提交"
                            let a = attr;
                            $(document).on("keydown", function (event) {
                                if (event.key === "Enter") {
                                    $(a).click(); // 触发按钮点击
                                }
                            });
                            attr.onclick = function () {

                                addsubmit(this)

                            }
                        }

                        if (i === 0) {
                            let element = document.createElement("span");
                            $(element).text("记作支出")
                            htmlTableCellElement.appendChild(element)
                        }
                        htmlTableCellElement.appendChild(attr);
                        attr1.appendChild(htmlTableCellElement)

                    }
                    $("#tbd").append(attr1);


                    $("input[type='text']").css('width', '100px');

                }
                let addsubmit = function (a) {
                    $(document).off("keydown");
                    /*副表*/
                    if ($("#zhichucheck").prop("checked") && !($("#priceB").val().startsWith("-"))) {
                        let a = $("#priceB").val()
                        $("#priceB").val("-" + a)
                    }

                    if (($("#priceB").val().startsWith("-")) && (!$("#zhichucheck").prop('checked'))) {
                        alert("本页价格负值为支出!支出请打勾")

                    } else {


                        $.ajax({
                            url: "${pageContext.request.contextPath}/gold/insert",
                            type: "post",
                            data: {
                                "price": $("#priceB").val(),
                                "date": $("#dateB").val(),
                                "comment": $("#commentB").val(),
                                "name": $("#nameB").val(),
                            }, success: function (a0) {
                                // alert(a0.code)
                                if (a0.code === "200") {
                                    alert("成功")
                                    window.location.reload(true)

                                    $(".add4btn").remove();
                                    $("#trbtn").show()
                                    $("#addbtn").show()
                                }
                            }, error: function () {
                                alert("失败! 时间不允许为空")

                            }
                        })
                    }

                }
            </script>
        </table>

    </form>
</div>

</head>

</div>
</div>
</html>