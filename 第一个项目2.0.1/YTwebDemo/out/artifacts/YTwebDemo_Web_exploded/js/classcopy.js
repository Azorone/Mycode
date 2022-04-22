
function CreadProductCartP(item) {
    let li=$("<li class='cardli'></li>");
    let ap=$("<a style='color: black'></a>");
    let sapnsell = $("<span class='sellName'>卖家："+item.productBelongName+"</span>");
    let spanTitle1 = $("<span class='cardTitle'>"+item.productName+"</span>")
    let divimg = $("<div class='divImg'></div>");
    let imgPrduct =$("<img class='ProductImg'></img>");
    let divNew=$("<div class='DivNews'></div>");
    let pPrice1 = $("<p id='pPrice'>价格："+item.productPrice+"元</P>");
    let pSta    =$("<p id='PstaOrder'>种类："+item.productClass+"</p>");
    imgPrduct.attr("src",item.productIMGurl);
    imgPrduct.attr("width","350px");

    ap.attr({"href":"getAProduct?pid="+item.productID,"target":"_blank"})
    ap.css( "text-decoration","none");
    divimg.append(imgPrduct);
    divNew.append(pPrice1);
    divNew.append(pSta);
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
    $(".ulshow").empty();
    getClass(6)
})
$("#pbt5").click(function (){          //获取上架的商品
  $("#pbt1").css( "background","white");
  $("#pbt2").css( "background","white");
  $("#pbt3").css( "background","white");
  $("#pbt4").css( "background","white");
  $("#pbt5").css( "background","rgb(87, 219, 219)")
    $("#pbt6").css( "background","white");
    $(".ulshow").empty();
    getClass(5)
})

$("#pbt3").click(function (){              //获取购物车中的商品
  $("#pbt1").css( "background","white");
  $("#pbt2").css( "background","white");
  $("#pbt3").css( "background","rgb(87, 219, 219)");
  $("#pbt4").css( "background","white");
  $("#pbt5").css( "background","white");
    $("#pbt6").css( "background","white");
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

  $(".ulshow").empty();
    getClass(2)

})

function getClass(PCLASS){

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
function getClassp(){

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