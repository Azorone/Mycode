

let key=1;
$("#search_icon").click(function serchProduct(){

    let world = $("#search").val();
    if (world.length<=0)
    {
        alert("请输入查询关键字！")
        return ;
    }
    else {
        let flag1 =  /[""?？“”|{：;；<>，。，、/_—=+&*%$#!~`@￥||]/.test(world);
        if (flag1)
        {
            alert("请勿包含特殊字符！")

            return ;
        }
        else {
                $.post({
                    url:"getProductClass",
                    data:"keyWorld="+world,
                    dataType:"json",
                    success:function (data){
                        $.each(data, function (i, item) {
                            //从后台获取数据
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
    let sapnsell = $("<span class='sellName'>用户："+"小明"+"</span>");
    let spanTitle1 = $("<span class='cardTitle'>"+"收二手书"+"</span>")
    let divimg = $("<div class='divImg' STYLE='height: 80%'></div>");
    let txtAre = $("<textarea name='textfield' readonly='readonly' id='txtshow' class='txtshow' style='resize: none;width: 100%;height:99%;overflow-x:hidden;overflow-y:scroll; font-size: 20px; padding: 15px'></textarea>")
    let pQQ    = $("<p>QQ:123456798</p>");
    let PCLASS = $("<P>寻物招领</P>")
    let divNew=$("<div class='DivNews'></div>");
    let time  =$("<span style='font-size:10px; margin-left: 5px'>发布时间:1200/12/11t12:54:11</span>")
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



/*********按钮***** */
$("#pbt6").click(function (){          //获取上架的商品
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
            $.each(data, function (i, item) {                  //从后台获取数据
                CreadNewsCart(item);
            });

        }

    })

})
$("#pbt5").click(function (){          //获取上架的商品
    $("#pbt1").css( "background","white");
    $("#pbt2").css( "background","white");
    $("#pbt3").css( "background","white");
    $("#pbt4").css( "background","white");
    $("#pbt5").css( "background","rgb(87, 219, 219)")
    $("#pbt6").css( "background","white");
    window.open("addNews.html");
})

$("#pbt3").click(function (){              //获取购物车中的商品
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
            $.each(data, function (i, item) {                  //从后台获取数据
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

            $.each(data, function (i, item) {                  //从后台获取数据
                CreadProductCartP(item)
            });

        }

    })

}

$(window).scroll(function(){
    //下面这句主要是获取网页的总高度，主要是考虑兼容性所以把Ie支持的documentElement也写了，这个方法至少支持IE8
    var htmlHeight=document.body.scrollHeight||document.documentElement.scrollHeight;
    //clientHeight是网页在浏览器中的可视高度，
    var clientHeight=document.body.clientHeight||document.documentElement.clientHeight;
    //scrollTop是浏览器滚动条的top位置，
    var scrollTop=document.body.scrollTop||document.documentElement.scrollTop;
    //通过判断滚动条的top位置与可视网页之和与整个网页的高度是否相等来决定是否加载内容；
    if(scrollTop+clientHeight==htmlHeight){
        if (key===4){

        }

    }
})

function CreadNewsCart() {
    let li=$("<li class='cardli'></li>");
    let ap=$("<a style='color: black'></a>");
    let sapnsell = $("<span class='sellName'>用户："+"小明"+"</span>");
    let spanTitle1 = $("<span class='cardTitle'>"+"收二手书"+"</span>")
    let divimg = $("<div class='divImg' STYLE='height: 80%'></div>");
    let txtAre = $("<textarea name='textfield' readonly='readonly' id='txtshow' class='txtshow' style='resize: none;width: 100%;height:99%;overflow-x:hidden;overflow-y:scroll; font-size: 20px; padding: 15px'></textarea>")
    divimg.append(txtAre);
    let divT = $("<div></div>")
    let button= $("<button id='button1'>编辑</button>");
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
