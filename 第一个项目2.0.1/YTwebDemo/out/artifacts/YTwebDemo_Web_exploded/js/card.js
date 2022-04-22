
function getDataP(){
  $.getJSON("getProduct", function (data) {
      $(".showUL").empty();
    $.each(data, function (i, item) {                  //从后台获取数据

        CreadProductCartP(item);
    });
});
}
/**
 * 创建新的CardNode
 */
function createCard(item){
  let linode = $("<li class='lip'></li>");
  let divnode = $("<div class='imgconter'></div>");
  let anode = $("<a></a>");
  let divimgNode = $("<div></div>");
  let imgNode    = $("<img class='imgp'>")
  let divnodeP = $("<div></div>");
  let divnodeT =$("<div></div>");
  let divnodeNews =$("<div></div>")
    anode.attr({"href":"getAProduct?pid="+item.productID+"&PTAG=News","target":"_blank"})

        imgNode.attr("src",item.productIMGurl);
        divnode.append(anode);
        anode.append(divimgNode);
            divimgNode.append(imgNode);
            divnodeP.text(item.productPrice+"元");               //商品的价格
            divnodeT.text(item.productName);                     //商品的名字
             divnodeNews.text("商家："+item.productBelongName);  //获取商品的所有人
    linode.append(divnode);
    linode.append(divnodeP);
    linode.append(divnodeT);
    linode.append(divnodeNews);
    $(".showUL").append(linode);
}
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
    imgPrduct.attr("width","100%");

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
    $(".showUL").append(li);
}

