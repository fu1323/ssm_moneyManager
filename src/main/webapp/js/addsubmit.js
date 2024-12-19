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