<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%--    <script src="js/color-modes.js"></script>--%>
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
    <title>个人收支管理系统·猫小咪软件</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/headers/">


    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">

    <link href="css/bootstrap.min.css" rel="stylesheet">

    <style>
        /*@media (min-width: 768px) {*/
        /*    .bd-placeholder-img-lg {*/
        /*        font-size: 3.5rem;*/
        /*    }*/
        /*}*/

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
        <%--        <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>--%>
    </symbol>
    <symbol id="circle-half" viewBox="0 0 16 16">
        <%--        <path d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z"/>--%>
    </symbol>
    <symbol id="moon-stars-fill" viewBox="0 0 16 16">
        <%--        <path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z"/>--%>
        <%--        <path d="M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z"/>--%>
    </symbol>
    <symbol id="sun-fill" viewBox="0 0 16 16">
        <%--        <path d="M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z"/>--%>
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

<script>
    let main = true;/*主副标志*/
    let month;
    let year;

    let draggable;
    let isDragging = false;
    let offsetX, offsetY;
    let dom = function (b) {
        $("#fu").click(function (a) {
            fu(a)
        })
        if (!main) {
            $("#titled").text(month + "月份收支统计副表")
            $("#create").show()
            $("#monetPX").show()
        } else {
            $("#titled").text(month + "月份收支统计主表")
            $("#create").hide()
            $("#monetPX").hide()
        }
        $(".addCell").empty()
        tuodongAjax();
        let a = 1;/*序号*/

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
            if (!main) {
                var htmlTableRowElement01 = document.createElement("td");

                $(htmlTableRowElement01).text(b[i].name)
                $(htmlTableRowElement01).id = ("nameB")
                // $(htmlTableRowElement01).hide()
                $(htmlTableRowElement1).append(htmlTableRowElement01)


                var htmlTableRowElement011 = document.createElement("td");

                $(htmlTableRowElement011).text(b[i].conbinationId)
                $(htmlTableRowElement011).addClass("conbination")
                $(htmlTableRowElement011).hide()
                $(htmlTableRowElement1).append(htmlTableRowElement011)

            }

            var htmlTableRowElementb = document.createElement("td");
            $(htmlTableRowElementb).text(b[i].price)
            $(htmlTableRowElement1).append(htmlTableRowElementb)
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
            if (!main) {
                var htmlTableRowElement014 = document.createElement("td");

                $(htmlTableRowElement014).text(new Date(b[i].countTo).toLocaleDateString())
                $(htmlTableRowElement014).id = "dateB"
                // $(htmlTableRowElement014).hide()
                $(htmlTableRowElement1).append(htmlTableRowElement014)
            }

            var htmlInputElement = document.createElement("input");
            htmlInputElement.style.color = "blue"
            htmlInputElement.type = "button";
            $(htmlInputElement).css("border", "none")
            htmlInputElement.value = "修改"
            htmlInputElement.className = "modify"
            htmlInputElement.name = "modify";
            $(htmlInputElement).click(function () {
                modify(this)
            })

            $(htmlTableRowElement1).append(htmlInputElement)
            $("#trbtn").before(htmlTableRowElement1)
            if ((b[i].comment === "买菜") && !main) {
                $(htmlTableRowElement1).children().each(function (index, ele) {
                    $(ele).css("background", "lawngreen")
                    /*b[i].conbinationId*/
                })
            }
            if ((b[i].comment === "超市购物") && !main) {
                $(htmlTableRowElement1).children().each(function (index, ele) {
                    $(ele).css("background", "orange")
                })
            }
            // if ((b[i].comment === "羊毛") && !main) {
            //     $(htmlTableRowElement1).children().each(function (index, ele) {
            //         $(ele).css("background", "pink")
            //     })
            // }


            if ((parseFloat(b[i].price)) < 0 && !main) {
                $(htmlTableRowElement1).children().each(function (index, ele) {
                    $(ele).css("background", "pink")
                })
            }


            // if ((b[i].conbinationId !== 0) && !main) {
            //     $(htmlTableRowElement1).children().each(function (index, ele) {
            //         $(ele).css("background", "yellow")
            //         /*b[i].conbinationId*/
            //     })
            // }
        }


    }
    let reload = function (reload) {
        if (main) {
            $.ajax({
                url: "${pageContext.request.contextPath}/day/query",
                type: "post",
                data: {"month": month, "year": year}, success: function (b) {
                    dom(b)
                }
            })

        } else {
            $.ajax({
                url: "${pageContext.request.contextPath}/monthly/query",
                type: "post",
                data: {"month": month, "year": year}, success: function (b) {
                    dom(b)
                }
            })
        }
    }
    $(function () {
            $("#clr").click(clear)
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
            $.ajax({
                url: "${pageContext.request.contextPath}/main",
                type: "get",
                success: function (a) {
                    month = a.month;
                    year = a.year;
                    let amonth = String(month).length === 2 ? month : "0" + month
                    $("#da").val(year + "-" + amonth + "-01")
                    // alert($("#date").text())
                    reload();


                }
            })
        }
    )

</script>
<main>
    <div class="container">
        <header class="d-flex justify-content-center py-3">
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="${pageContext.request.contextPath}/list.jsp" class="nav-link active"
                                        aria-current="page" id="mainp">主表</a></li>
                <li class="nav-item"><a href="#" class="nav-link" <%--onclick="fu(this)"--%> id="fu">副表</a></li>
                <li class="nav-item"><a href="#" class="nav-link">调整月份(日期随意)</a></li>

            </ul>
            <input type="date" id="da" name="da" style="display: inline-block">
            <input type="button" id="dateok" value="提交" name="dateok" style="display: inline-block"
                   onclick="set(this)">
            <input type="button" value="清除" id="clr" name="123">

        </header>
        <script>
            let clear = function () {
                $.ajax({
                    url: "${pageContext.request.contextPath}/clear",
                    type: "get",
                    success: function () {
                        window.location.reload(true)
                    }
                })
            }

        </script>
    </div>
</main>
<script src="js/bootstrap.bundle.min.js"></script>

<div class="container" class="text-center mx-auto justify-content-center table-responsive ">
    <div style=" float: left;" id="list01">
        <div style="float: left;margin: 8px;">
            <div style="white-space: nowrap">

                <a class="btn btn-primary" href="javascript:void(0)" onclick="func()">隐藏/显示</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/goldku.jsp" <%--onclick="add()--%>>金库总表</a>
                <%--                <a class="btn btn-primary" href="javascript:void(0)" id="create" onclick="createZuHe()">创建组合</a>--%>
                <a class="btn btn-primary" href="javascript:void(0)" id="monetPX" onclick="jin_e()">按金额排序</a>
                <br>

                <h3 style="display: inline-block;margin-left: 270px ;text-align: center" id="titled"> 统计</h3>
            </div>

        </div>
    </div>
    <style>
        #draggable {
            width: 150px;
            height: 150px;
            background-color: yellow;
            position: absolute;
            top: 150px;
            right: 50px;
            /*cursor: move;*/
            touch-action: none;

        }
    </style>
    </head>
    <body>
    <div id="draggable">
        <table class="table-bordered">
            <thead>
            <tr>
                <th>
                    可支配收入
                </th>
                <th>
                    保留
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td id="kezhipei">
                    2000
                </td>
                <td id="baoliu">
                    100
                </td>
            </tr>
            </tbody>
            <thead>
            <tr>
                <th>
                    总开支
                </th>
                <th>
                    余额
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td id="tuodongid" hidden="hidden"></td>
                <td id="zongkaizhi">
                    2000
                </td>
                <td id="yu_e">
                    22
                </td>
            </tr>
            </tbody>

        </table>

        <input type="button" value="修改" id="dragsub" style="margin-left: 40px">
    </div>

    <script>
        let modifytuodong = function () {
            let baoliu = $("#baoliu").text()
            let kezhipei = $("#kezhipei").text()
            var htmlInputElement = document.createElement("input");
            var htmlInputElement2 = document.createElement("input");
            htmlInputElement.value = baoliu;
            htmlInputElement.id = "baoliuinput";
            $(htmlInputElement).css("width", "50px")
            htmlInputElement2.value = kezhipei;
            htmlInputElement2.id = "kezhipeiinput";
            $(htmlInputElement2).css("width", "50px")
            $("#baoliu").empty();
            $("#kezhipei").empty();
            $("#baoliu").append(htmlInputElement)
            $("#kezhipei").append(htmlInputElement2)
            $("#dragsub").off()
            $("#dragsub").val("提交")
            $("#dragsub").click(function () {


                $.ajax({
                    url: "${pageContext.request.contextPath}/monthlyall/updins",
                    type: "post",
                    data: {
                        id: $("#tuodongid").text(),
                        month: month,
                        year: year,
                        allMoney: $("#kezhipeiinput").val(),
                        first: $("#baoliuinput").val()
                    }, success: function (a) {
                        // alert(a.code)
                        if (a.code === "200") {
                            alert("成功")
                            $("#dragsub").off()
                            tuodongAjax()

                        }
                    }

                })
                // }

            })


        }
        let tuodongview = function (a) {
            $("#dragsub").val("修改")
            $("#dragsub").off()
            $("#dragsub").click(modifytuodong)


            if (a.length != 0) {
                $("#tuodongid").text(a.id)
                $("#kezhipei").text(a.allMoney)
                $("#baoliu").text(a.first)
                $("#zongkaizhi").text(a.allKaizhi)
                $("#yu_e").text(parseInt(a.allMoney) - parseInt(a.allKaizhi) - parseInt(a.first))
                if (parseFloat($("#yu_e").text()) < 0) {
                    $("#yu_e").css("background", "red")
                } else $("#yu_e").css("background", "yellow")
            } else {
                $("#tuodongid").text("-8")
                $("#kezhipei").text("0")
                $("#baoliu").text("0")
                $("#zongkaizhi").text("0")
                $("#yu_e").text("0")
            }
        }

        let tuodongAjax = function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/monthlyall/select?year=" + year + "&month=" + month,
                type: "get",

                success: function (a) {
                    tuodongview(a)
                }
            })
        }


        const draggable = document.getElementById("draggable");
        let isDragging = false;
        let offsetX, offsetY;


    </script>

    <form id="form" method="post">
        <table border="1" class="table table-bordered table-hover" style="float: left;margin: 8px;" id="abc"
               width="500px">

            <thead class="row-cols-lg-5">
            <tr class="table-bordered" id="table">
                <th id="id">编号</th>
                <%--                    <th>名称</th>--%>
                <th>价格表达式</th>
                <th>时间</th>
                <th id="comment" width="200px">备注</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="tbd">
            <tr id="trbtn">
                <td colspan="5" align="center" id="addbtn"><input name="add" type="button" value="添加"
                                                                  onclick="adder(this)"></td>
            </tr>
            </tbody>

        </table>

    </form>
    <%--        </body>--%>
    <script src="${pageContext.request.contextPath}/js/adder.js"></script>
    <script>let addsubmit = function (a) {


        if (main) {
            $.ajax({
                url: "${pageContext.request.contextPath}/day/insert",
                type: "post",
                data: {
                    "price": $("#price").val(),
                    "date": $("#dateadd").val(),
                    "comment": $("#commentadd").val()
                }, success: function (a0) {
                    // alert(a0.code)
                    if (a0.code === "200") {
                        alert("成功")
                        reload()

                        window.location.href = "list.jsp"
/*error: function (jqxhr,status,err) {

                        if ((JSON.parse(jqxhr.responseText)).message !== undefined) {
                            alert((JSON.parse(jqxhr.responseText)).message)
                        } else alert("主表日期不允许重复  操作失败")*/
                    }
                }, error:function (jqxhr,status,err) {
                    if ((JSON.parse(jqxhr.responseText)).message !== undefined) {
                        alert((JSON.parse(jqxhr.responseText)).message)
                    } else alert("主表日期不允许重复  操作失败")
                }
            })
        } else {/*副表*/
            if ($("#shouru").prop("checked") && !($("#priceB").val().startsWith("-"))) {
                let a = $("#priceB").val()
                $("#priceB").val("-" + a)
            }

            if (($("#priceB").val().startsWith("-")) && (!$("#shouru").prop('checked'))) {
                alert("价格负值必须计做收入!")

            } else {


                $.ajax({
                    url: "${pageContext.request.contextPath}/monthly/insert",
                    type: "post",
                    data: {
                        "price": $("#priceB").val(),
                        "date": $("#dateB").val(),
                        "comment": $("#commentB").val(),
                        "name": $("#nameB").val(),
                        "countTo": $("#countToB").val()
                    }, success: function (a0) {
                        // alert(a0.code)
                        if (a0.code === "200") {
                            alert("成功")

                            reload()
                            $(".add4btn").remove();
                            $("#trbtn").show()
                            $("#addbtn").show()
                        }
                    }, error: function (jqxhr,status,err) {

                        if ((JSON.parse(jqxhr.responseText)).message !== undefined) {
                            alert((JSON.parse(jqxhr.responseText)).message)
                        }
/* error: function (jqxhr,status,err) {

                        if ((JSON.parse(jqxhr.responseText)).message !== undefined) {
                            alert((JSON.parse(jqxhr.responseText)).message)
                        } else alert("主表日期不允许重复  操作失败")
                    }*/
                    }
                })
            }
        }
    }</script>
    <script>
        let fastbtn = function (btn) {
            // alert($(btn).val())
            $(btn).click(function () {
                $("#shouru").prop("checked", false)
                if ($(this).val() === "羊毛") {
                    $("#shouru").prop("checked", true)
                }
                $("#commentB").val($(this).val())
                $("#nameB").val($(this).val())
            })
        }
        let fu = function (a) {
            main = false;
            $(".fubiao").remove()
            $(".addCell").remove();
            $(a).addClass("active")
            $("#mainp").removeClass("active")
            let htmlTableRowElement = document.createElement("th");
            let htmlTableRowElement2 = document.createElement("th");
            htmlTableRowElement.innerHTML = "计入月份"

            htmlTableRowElement2.innerHTML = "名称"
            htmlTableRowElement.className = "fubiao"
            htmlTableRowElement2.className = "fubiao"
            $("#id").after(htmlTableRowElement2)
            $("#comment").after(htmlTableRowElement)
            $("#addbtn").attr("colspan", 7)
            $.ajax({
                url: "${pageContext.request.contextPath}/monthly/query",
                type: "post",
                data: {"month": month, "year": year}, success: function (a) {
                    // dom(a)
                    reload()
                }

            })


        }
        let jin_e = function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/monthly/querybyprice",
                type: "post",
                data: {"month": month, "year": year}, success: function (b) {
                    dom(b)
                }
            })
        }


        let modifytuodong = function () {
            let baoliu = $("#baoliu").text()
            let kezhipei = $("#kezhipei").text()
            var htmlInputElement = document.createElement("input");
            var htmlInputElement2 = document.createElement("input");
            htmlInputElement.value = baoliu;
            htmlInputElement.id = "baoliuinput";
            $(htmlInputElement).css("width", "50px")
            htmlInputElement2.value = kezhipei;
            htmlInputElement2.id = "kezhipeiinput";
            $(htmlInputElement2).css("width", "50px")
            $("#baoliu").empty();
            $("#kezhipei").empty();
            $("#baoliu").append(htmlInputElement)
            $("#kezhipei").append(htmlInputElement2)
            $("#dragsub").off()
            $("#dragsub").val("提交")
            $("#dragsub").click(function () {


                $.ajax({
                    url: "${pageContext.request.contextPath}/monthlyall/updins",
                    type: "post",
                    data: {
                        id: $("#tuodongid").text(),
                        month: month,
                        year: year,
                        allMoney: $("#kezhipeiinput").val(),
                        first: $("#baoliuinput").val()
                    }, success: function (a) {
                        // alert(a.code)
                        if (a.code === "200") {
                            alert("成功")
                            $("#dragsub").off()
                            tuodongAjax()

                        }
                    }

                })
                // }

            })


        }
        let tuodongview = function (a) {
            $("#dragsub").val("修改")
            $("#dragsub").off()
            $("#dragsub").click(modifytuodong)


            if (a.length != 0) {
                $("#tuodongid").text(a.id)
                $("#kezhipei").text(a.allMoney)
                $("#baoliu").text(a.first)
                $("#zongkaizhi").text(a.allKaizhi)
                $("#yu_e").text(parseInt(a.allMoney) - parseInt(a.allKaizhi) - parseInt(a.first))
                if (parseFloat($("#yu_e").text()) < 0) {
                    $("#yu_e").css("background", "red")
                } else $("#yu_e").css("background", "yellow")
            } else {
                $("#tuodongid").text("-8")
                $("#kezhipei").text("0")
                $("#baoliu").text("0")
                $("#zongkaizhi").text("0")
                $("#yu_e").text("0")
            }
        }

        let tuodongAjax = function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/monthlyall/select?year=" + year + "&month=" + month,
                type: "get",

                success: function (a) {
                    tuodongview(a)
                }
            })
        }
        let del = function (url) {
            $.ajax({
                url: "${pageContext.request.contextPath}" + url + "?id=" + $("#idupd").text(),
                type: "delete", success: function (a0) {
                    // alert(a0.code)
                    if (a0.code === "200") {
                        alert("成功")
                        if (main) {
                            window.location.href = "list.jsp"
                        } else $("#fu").click()
                    }
                }, error: function () {
                }
            })
        }
        let modify = function (a) {
            if (main) {
                let lst = a.parentNode.children;
                $(lst[0]).empty()
                var htmlInputElement = document.createElement("input");
                htmlInputElement.type = "button";
                htmlInputElement.name = "bton";
                htmlInputElement.value = "删除"
                $(htmlInputElement).click(function () {
                    del("/day/delete")
                })
                $(lst[0]).append(htmlInputElement)
                x($(lst[2]), "text", "priceupd")
                $(lst[1]).attr("id", "idupd")
                x($(lst[4]), "text", "commentupd")

                x($(lst[3]), "date", "dateupd")
                $(lst[5]).val("提交")
                $(lst[5]).removeClass("modify")
                $(".modify").attr("disabled", "disabled")
                $(lst[5]).css("color", "red")
                $(lst[5]).off("click")
                $(lst[5]).click(update)
                $("#commentupd").attr("disabled", "disabled")


            } else {
                let lst = a.parentNode.children;
                $(lst[0]).empty()
                var htmlInputElement = document.createElement("input");
                htmlInputElement.type = "button";
                htmlInputElement.name = "bton";
                htmlInputElement.value = "删除"
                $(htmlInputElement).click(function () {
                    del("/monthly/delete")
                })

                $(lst[0]).append(htmlInputElement)
                $(lst[1]).attr("id", "idupd")
                x($(lst[2]), "text", "nameupd")
                x($(lst[5]), "date", "dateupd")
                x($(lst[7]), "date", "countToupd")
                x($(lst[4]), "text", "priceupd")
                x($(lst[6]), "text", "commentupd")
                $(lst[8]).val("提交")
                $(lst[8]).removeClass("modify")
                $(".modify").attr("disabled", "disabled")
                $(lst[8]).css("color", "red")
                $(lst[8]).off("click")
                $(lst[8]).click(function () {
                    update(1)
                })
            }
        }
        let update = function (a) {

            if (main) {
                $.ajax({
                    url: "${pageContext.request.contextPath}/day/update",
                    type: "post",
                    data: {
                        "price": $("#priceupd").val(),
                        "date": $("#dateupd").val(),
                        "id": $("#idupd").text()
                    }, success: function (abc) {
                        // alert(abc.code)
                        if (abc.code === "200") {
                            alert("成功")
                            reload()
                        }
                    }, error: function (jqxhr,status,err) {

                        if ((JSON.parse(jqxhr.responseText)).message !== undefined) {
                            alert((JSON.parse(jqxhr.responseText)).message)
                        } else alert("主表日期不允许重复  操作失败")
                    }
                })
            } else {
                $.ajax({
                    url: "${pageContext.request.contextPath}/monthly/update",
                    type: "post",
                    data: {
                        "name": $("#nameupd").val(),
                        "date": $("#dateupd").val(),
                        "id": $("#idupd").text(),
                        "comment": $("#commentupd").val(),
                        "countTo": $("#countToupd").val(),
                        "price": $("#priceupd").val()
                    }, success: function (a0) {
                        // alert(a0.code)
                        if (a0.code === "200") {
                            alert("成功")
                            reload()
                        }/*error: function (jqxhr,status,err) {

                        if ((JSON.parse(jqxhr.responseText)).message !== undefined) {
                            alert((JSON.parse(jqxhr.responseText)).message)
                        } else alert("主表日期不允许重复  操作失败")*/

                    }, error: function (jqxhr,status,err) {
                        if ((JSON.parse(jqxhr.responseText)).message !== undefined) {
                            alert((JSON.parse(jqxhr.responseText)).message)
                        }  else alert("操作失败")
                    }
                })
            }
            // if (main) {
            //     window.location.href = "list.jsp"
            // } else $("#fu").click()
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
        let set = function (a) {
            if (!($("#da").val() === "")) {
                year = $("#da").val().split("-")[0]
                month = $("#da").val().split("-")[1]
                $(".addCell").remove();
                reload()
            }
        }
        let func = function () {
            $("#draggable").toggle()
        }
    </script>


</div>
</body>
</html>
