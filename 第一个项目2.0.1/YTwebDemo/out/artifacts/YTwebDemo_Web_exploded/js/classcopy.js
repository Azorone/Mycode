
function CreadProductCartP(item) {
    let li=$("<li class='cardli'></li>");
    let ap=$("<a style='color: black'></a>");
    let sapnsell = $("<span class='sellName'>���ң�"+item.productBelongName+"</span>");
    let spanTitle1 = $("<span class='cardTitle'>"+item.productName+"</span>")
    let divimg = $("<div class='divImg'></div>");
    let imgPrduct =$("<img class='ProductImg'></img>");
    let divNew=$("<div class='DivNews'></div>");
    let pPrice1 = $("<p id='pPrice'>�۸�"+item.productPrice+"Ԫ</P>");
    let pSta    =$("<p id='PstaOrder'>���ࣺ"+item.productClass+"</p>");
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



/*********��ť***** */
$("#pbt6").click(function (){          //��ȡ�ϼܵ���Ʒ
    $("#pbt1").css( "background","white")
    $("#pbt2").css( "background","white")
    $("#pbt3").css( "background","white")
    $("#pbt4").css( "background","white")
    $("#pbt6").css( "background","rgb(87, 219, 219)")
    $("#pbt5").css( "background","white")
    $(".ulshow").empty();
    getClass(6)
})
$("#pbt5").click(function (){          //��ȡ�ϼܵ���Ʒ
  $("#pbt1").css( "background","white");
  $("#pbt2").css( "background","white");
  $("#pbt3").css( "background","white");
  $("#pbt4").css( "background","white");
  $("#pbt5").css( "background","rgb(87, 219, 219)")
    $("#pbt6").css( "background","white");
    $(".ulshow").empty();
    getClass(5)
})

$("#pbt3").click(function (){              //��ȡ���ﳵ�е���Ʒ
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
                $.each(data, function (i, item) {                  //�Ӻ�̨��ȡ����
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

            $.each(data, function (i, item) {                  //�Ӻ�̨��ȡ����
                CreadProductCartP(item)
            });

        }

    })

}