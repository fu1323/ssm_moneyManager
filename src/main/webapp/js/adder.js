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