


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
                    type:"post",
                    url:"serchN",
                    data:"NewsWord="+world,
                    dataType:"json",
                    success:function (data){
                        $(".ulshow").empty();
                        $.each(data, function (i, item) {
                            //从后台获取数据

                            CreadNews(item)
                        });
                    }
                })
        }
    }
});



function CreadNews(data) {
    let li=$("<li class='cardli'></li>");
    let ap=$("<a style='color: black'></a>");
    let sapnsell = $("<span class='sellName'>用户："+data.userName+"</span>");
    let spanTitle1 = $("<span class='cardTitle'>"+data.txtTile+"</span>")
    let divimg = $("<div class='divImg' STYLE='height: 80%'></div>");
    let txtAre = $("<textarea name='textfield' readonly='readonly' id='txtshow' class='txtshow' style='resize: none;width: 100%;height:99%;overflow-x:hidden;overflow-y:scroll; font-size: 20px; padding: 15px'>"+data.txtAre+"</textarea>")
    let pQQ    = $("<p>QQ:"+data.phon+"</p>");
    let PCLASS = $("<P>"+data.txtclass+"</P>")
    let divNew=$("<div class='DivNews'></div>");
    let time  =$("<span style='font-size:10px; margin-left: 5px'>发布时间:"+data.txtTime+"</span>")
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
      key=6;
    $(".ulshow").empty();
    $.ajax({
        type:"POST",
        url:"getAllNews",
        cache:false,
        data:"NCLASS="+6,
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
    key=3;
    $(".ulshow").empty();
    getClassNews(3)

})
$("#pbt4").click(function (){
    $("#pbt1").css( "background","white");
    $("#pbt2").css( "background","white");
    $("#pbt3").css( "background","white");
    $("#pbt4").css( "background","rgb(87, 219, 219)");
    $("#pbt5").css( "background","white");
    $("#pbt6").css( "background","white");
    key=4;
    $(".ulshow").empty();
    getClassNews(4)
})
$("#pbt1").click(function (){
    $("#pbt1").css( "background","rgb(87, 219, 219)");
    $("#pbt2").css( "background","white");
    $("#pbt3").css( "background","white");
    $("#pbt4").css( "background","white");
    $("#pbt5").css( "background","white");
    $("#pbt6").css( "background","white");
    key=1;
    $(".ulshow").empty();
    getClassNews(1)
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
    getClassNews(2)

})

function getClassNews(PCLASS){

    $.ajax({
        type:"POST",
        url:"getAllNews",
        cache:false,
        data:"NCLASS="+PCLASS,
        dataType:"json",
        success:function (data){

            $(".ulshow").empty();
            $.each(data, function (i, item) {                  //从后台获取数据
                CreadNews(item);
            });

        }

    })

}
function getNews(){

    $.ajax({
        type:"POST",
        url:"getAllNews",
        cache:false,
        dataType:"json",
        success:function (data){
            $(".ulshow").empty();

            $.each(data, function (i, item) {                  //从后台获取数据
                CreadNews(item);
            });

        }

    })

}

/*$(window).scroll(function(){
    var htmlHeight=document.body.scrollHeight||document.documentElement.scrollHeight;
    var clientHeight=document.body.clientHeight||document.documentElement.clientHeight;
    var scrollTop=document.body.scrollTop||document.documentElement.scrollTop;
    if(scrollTop+clientHeight==htmlHeight){
        if (key===4 ||key===1 || key ===6  ||key===2 ||key===3){
           if(key===1){
                getClassNews(1)
            }
            else if (key ===6){
                $.ajax({
                    type:"POST",
                    url:"getNewsM",
                    cache:false,

                    dataType:"json",
                    success:function (data){

                        $(".ulshow").empty();
                        $.each(data, function (i, item) {                  //从后台获取数据
                            CreadNewsCart(item);
                        });

                    }

                })
            }
            else if (key ===2){
                getClassNews(2)
            }
            else if (key ===3)
            {
                getClassNews(key)
            }else if (key ===4)
            {
                getClassNews(key)
            }
        }
        else {
            return
        }

    }
})*/

function CreadNewsCart(data) {
    let li=$("<li class='cardli'></li>");
    let ap=$("<a style='color: black'></a>");
    let sapnsell = $("<span class='sellName'>用户："+data.userName+"</span>");
    let spanTitle1 = $("<span class='cardTitle'>"+data.txtTile+"</span>")
    let divimg = $("<div class='divImg' STYLE='height: 80%'></div>");
    let divNew=$("<div class='DivNews'></div>");
    let txtAre = $("<textarea name='textfield' readonly='readonly' id='txtshow' class='txtshow' style='resize: none;width: 100%;height:99%;overflow-x:hidden;overflow-y:scroll; font-size: 20px; padding: 15px'>"+data.txtAre+"</textarea>")
    divimg.append(txtAre);
    let divT = $("<div></div>")
    let button= $("<button id='button1'>编辑</button>");
    let button2=$("<button id='button2'>删除</button> ")
    button.click(function (){

        $.ajax({
            type: "POST",
            url: "alterPageN",
            data:"NewsID="+data.newsID,
            success:function () {

                window.open("alterNews.html");
            }
        })
    })
    button2.click(function (){

        $.ajax({
            type: "POST",
            url: "DelectN",
            data:"NewsID="+data.newsID,
            success:function (data) {

           alert(data);
                $(".ulshow").empty();
                getClassNews(6);
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
    li.append(button2)
    $(".ulshow").append(li);
}
