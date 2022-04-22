


function getdataProductNews(result) {

          $(".imgs").attr("src",result.productIMGurl);       //图片
          $(".user-name").append(result.productBelongName);  //商家
          $(".uio").append(result.productDescribe);         //描述
          $(".pricespan").append(result.productPrice);     //价格
}
