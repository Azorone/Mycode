

let key=1;
$("#search_icon").click(function serchProduct(){

    let world = $("#search").val();
    if (world.length<=0)
    {
        alert("�������ѯ�ؼ��֣�")
        return ;
    }
    else {
        let flag1 =  /[""?������|{��;��<>��������/_��=+&*%$#!~`@��||]/.test(world);
        if (flag1)
        {
            alert("������������ַ���")

            return ;
        }
        else {
                $.post({
                    url:"getProductClass",
                    data:"keyWorld="+world,
                    dataType:"json",
                    success:function (data){
                        $.each(data, function (i, item) {
                            //�Ӻ�̨��ȡ����
                            $(".ulshow").empty();
                            CreadProductCartP(item)
                        });
                    }
                })
        }
    }
});



function CreadNews() {
    let li=$("<li class='cardli'></li>");
    let ap=$("<a style='color: black'></a>");
    let sapnsell = $("<span class='sellName'>�û���"+"С��"+"</span>");
    let spanTitle1 = $("<span class='cardTitle'>"+"�ն�����"+"</span>")
    let divimg = $("<div class='divImg' STYLE='height: 80%'></div>");
    let txtAre = $("<textarea name='textfield' readonly='readonly' id='txtshow' class='txtshow' style='resize: none;width: 100%;height:99%;overflow-x:hidden;overflow-y:scroll; font-size: 20px; padding: 15px'></textarea>")
    let pQQ    = $("<p>QQ:123456798</p>");
    let PCLASS = $("<P>Ѱ������</P>")
    let divNew=$("<div class='DivNews'></div>");
    let time  =$("<span style='font-size:10px; margin-left: 5px'>����ʱ��:1200/12/11t12:54:11</span>")
    PCLASS.append(time);
    divimg.append(txtAre);
    divNew.append(pQQ);
    divNew.append(PCLASS);
    let divT = $("<div></div>")
    divT.append(sapnsell);
    divT.append(spanTitle1);
    ap.append(divT);
    ap.append(divimg);
    ap.append(divNew);
    li.append(ap);
    $(".ulshow").append(li);
}



/*********��ť***** */
$("#pbt6").click(function (){          //��ȡ�ϼܵ���Ʒ
    $("#pbt1").css( "background","white")
    $("#pbt2").css( "background","white")
    $("#pbt3").css( "background","white")
    $("#pbt4").css( "background","white")
    $("#pbt6").css( "background","rgb(87, 219, 219)")
    $("#pbt5").css( "background","white")
    key=2;


    $(".ulshow").empty();
    $.ajax({
        type:"POST",
        url:"getProductClass",
        cache:false,
        data:"Pclass="+PCLASS,
        dataType:"json",
        success:function (data){

            $(".ulshow").empty();
            $.each(data, function (i, item) {                  //�Ӻ�̨��ȡ����
                CreadNewsCart(item);
            });

        }

    })

})
$("#pbt5").click(function (){          //��ȡ�ϼܵ���Ʒ
    $("#pbt1").css( "background","white");
    $("#pbt2").css( "background","white");
    $("#pbt3").css( "background","white");
    $("#pbt4").css( "background","white");
    $("#pbt5").css( "background","rgb(87, 219, 219)")
    $("#pbt6").css( "background","white");
    window.open("addNews.html");
})

$("#pbt3").click(function (){              //��ȡ���ﳵ�е���Ʒ
    $("#pbt1").css( "background","white");
    $("#pbt2").css( "background","white");
    $("#pbt3").css( "background","rgb(87, 219, 219)");
    $("#pbt4").css( "background","white");
    $("#pbt5").css( "background","white");
    $("#pbt6").css( "background","white");
    key=2;
    $(".ulshow").empty();
    getClass(3)

})
$("#pbt4").click(function (){
    $("#pbt1").css( "background","white");
    $("#pbt2").css( "background","white");
    $("#pbt3").css( "background","white");
    $("#pbt4").css( "background","rgb(87, 219, 219)");
    $("#pbt5").css( "background","white");
    $("#pbt6").css( "background","white");
    key=2;
    $(".ulshow").empty();
    getClass(4)
})
$("#pbt1").click(function (){
    $("#pbt1").css( "background","rgb(87, 219, 219)");
    $("#pbt2").css( "background","white");
    $("#pbt3").css( "background","white");
    $("#pbt4").css( "background","white");
    $("#pbt5").css( "background","white");
    $("#pbt6").css( "background","white");
    key=2;
    $(".ulshow").empty();
    getClass(1)
})
$("#pbt2").click(function (){
    $("#pbt1").css( "background","white")
    $("#pbt2").css( "background","rgb(87, 219, 219)")
    $("#pbt3").css( "background","white")
    $("#pbt4").css( "background","white")
    $("#pbt5").css( "background","white")
    $("#pbt6").css( "background","white");
    key=2;
    $(".ulshow").empty();
    getClass(2)

})

function getClassNews(PCLASS){

    $.ajax({
        type:"POST",
        url:"getProductClass",
        cache:false,
        data:"Pclass="+PCLASS,
        dataType:"json",
        success:function (data){

            $(".ulshow").empty();
            $.each(data, function (i, item) {                  //�Ӻ�̨��ȡ����
                CreadProductCartP(item)
            });

        }

    })

}
function getClassNews(){

    $.ajax({
        type:"POST",
        url:"getProductClass",
        cache:false,
        dataType:"json",
        success:function (data){
            $(".ulshow").empty();

            $.each(data, function (i, item) {                  //�Ӻ�̨��ȡ����
                CreadProductCartP(item)
            });

        }

    })

}

$(window).scroll(function(){
    //���������Ҫ�ǻ�ȡ��ҳ���ܸ߶ȣ���Ҫ�ǿ��Ǽ��������԰�Ie֧�ֵ�documentElementҲд�ˣ������������֧��IE8
    var htmlHeight=document.body.scrollHeight||document.documentElement.scrollHeight;
    //clientHeight����ҳ��������еĿ��Ӹ߶ȣ�
    var clientHeight=document.body.clientHeight||document.documentElement.clientHeight;
    //scrollTop���������������topλ�ã�
    var scrollTop=document.body.scrollTop||document.documentElement.scrollTop;
    //ͨ���жϹ�������topλ���������ҳ֮����������ҳ�ĸ߶��Ƿ�����������Ƿ�������ݣ�
    if(scrollTop+clientHeight==htmlHeight){
        if (key===4){

        }

    }
})

function CreadNewsCart() {
    let li=$("<li class='cardli'></li>");
    let ap=$("<a style='color: black'></a>");
    let sapnsell = $("<span class='sellName'>�û���"+"С��"+"</span>");
    let spanTitle1 = $("<span class='cardTitle'>"+"�ն�����"+"</span>")
    let divimg = $("<div class='divImg' STYLE='height: 80%'></div>");
    let txtAre = $("<textarea name='textfield' readonly='readonly' id='txtshow' class='txtshow' style='resize: none;width: 100%;height:99%;overflow-x:hidden;overflow-y:scroll; font-size: 20px; padding: 15px'></textarea>")
    divimg.append(txtAre);
    let divT = $("<div></div>")
    let button= $("<button id='button1'>�༭</button>");
    button1.click(function (){

        $.ajax({
            type: "POST",
            url: "alterNewsPage",
            data:"ID="+Product.productID,
            success:function () {
                window.open("alterNews.html");
            }
        })
    })
    divT.append(sapnsell);
    divT.append(spanTitle1);
    ap.append(divT);
    ap.append(divimg);
    ap.append(divNew);
    li.append(ap);
    li.append(button);
    $(".ulshow").append(li);
}
