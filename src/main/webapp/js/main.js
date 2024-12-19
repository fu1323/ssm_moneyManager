

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
let dom = function (b) {
    $("#fu").click(function (a) {
        fu(a)
    })
    if (!main) {
        $("#titled").text(month+"月份收支统计副表")
        $("#create").show()
        $("#monetPX").show()
    } else {
        $("#titled").text(month+"月份收支统计主表")
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
        if ((b[i].comment === "羊毛") && !main) {
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
let fu = function (a) {
    main = false;
    $(".fubiao").remove()
    $(".addCell").remove();
    $(a).addClass("active")
    $("#mainp").removeClass("active")
    var htmlTableRowElement = document.createElement("th");
    var htmlTableRowElement2 = document.createElement("th");
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
        }else $("#yu_e").css("background", "yellow")
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
            }, error: function () {
                // alert(123)
                alert("主表日期不允许重复  操作失败")
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
                }
            }, error: function () {
                alert("操作失败")
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
let adder = function (a) {
    $("#fu").off()

    // a.disabled = true
    $("#trbtn").hide()
    var attr1 = document.createElement("tr");
    attr1.className = "add4btn"
    let b = a.parentNode.colSpan;
    for (let i = 0; i < b; i++) {
        // alert(i)
        var htmlTableCellElement = document.createElement("td");
        var attr = document.createElement("input");

        if (main) {

            switch (i) {
                case 1: {
                    attr.type = 'text';

                    attr.id = "price";
                    break;
                }
                case 0: {
                    attr.type = 'text';

                    attr.hidden = true;
                    break;
                }
                case 2: {
                    attr.type = 'date';
                    attr.name = 'date';
                    attr.id = "dateadd"
                    break;
                }
                case 3: {
                    attr.type = 'text';
                    attr.hidden = true;
                    attr.id = "commentadd"

                    break;
                }

            }


        } else {


            switch (i) {
                case 1: {
                    attr.type = 'text';
                    attr.id = "nameB";
                    break;
                }
                case 0: {
                    attr.type = 'text';

                    attr.hidden = true;
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

                    attr.id = "priceB"
                    break;
                }
                case 5: {
                    attr.type = 'date';
                    attr.name = 'countTo';
                    attr.id = 'countToB';
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

        }

        if (i === b - 1) {
            attr.type = 'button';
            attr.value = "提交"
            attr.onclick = function () {

                addsubmit(this)

            }
        }


        htmlTableCellElement.appendChild(attr);
        attr1.appendChild(htmlTableCellElement)

    }
    $("#tbd").append(attr1);
    if (!main) {
        var htmlInputElement01 = document.createElement("span");
        htmlInputElement01.innerHTML = "快捷备注:"

        var htmlInputElement0 = document.createElement("input");
        htmlInputElement0.type = 'button'
        htmlInputElement0.value = "买菜"
        fastbtn($(htmlInputElement0))
        htmlInputElement0.style.background = "green"


        var htmlInputElement1 = document.createElement("input");
        htmlInputElement1.type = 'button'
        htmlInputElement1.value = "超市购物"
        htmlInputElement1.style.background = "orange"
        fastbtn($(htmlInputElement1))
        var htmlInputElement2 = document.createElement("input");
        htmlInputElement2.type = 'button'
        htmlInputElement2.value = "羊毛"
        htmlInputElement2.style.background = "pink"
        fastbtn($(htmlInputElement2))
        var htmlInputElement3 = document.createElement("input");
        htmlInputElement3.type = 'checkbox'
        htmlInputElement3.name = "shouru"
        htmlInputElement3.id = "shouru"
        var htmlInputElement42 = document.createElement("br");
        var htmlInputElement4 = document.createElement("span");
        htmlInputElement4.innerHTML = "计做收入"


        var htmlTableRowElement = document.createElement("tr");
        var htmlTableCellElement1 = document.createElement("td");
        htmlTableCellElement1.appendChild(htmlInputElement3)

        htmlTableCellElement1.appendChild(htmlInputElement4)
        htmlTableCellElement1.appendChild(htmlInputElement42)
        htmlTableCellElement1.appendChild(htmlInputElement01)
        htmlTableCellElement1.appendChild(htmlInputElement0)
        htmlTableCellElement1.appendChild(htmlInputElement1)
        htmlTableCellElement1.appendChild(htmlInputElement2)

        htmlTableRowElement.appendChild(htmlTableCellElement1)
        htmlTableCellElement1.colSpan = 7
        htmlTableCellElement1.className = "add4btn"
        htmlTableCellElement1.style.textAlign = "center"
        $("#tbd").append(htmlTableRowElement)
    }

    $("input[type='text']").css('width', '100px');

}

let addsubmit = function (a) {


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

                }
            }, error: function () {
                alert("主表日期不允许重复  操作失败")
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
                }, error: function () {
                    alert("失败! 时间不允许为空,\n计入月份为空将默认与时间相同!")

                }
            })
        }
    }
}

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



let func = function () {
    $("#draggable").toggle()
}