


function getdataProductNews(result) {

          $(".imgs").attr("src",result.productIMGurl);       //ͼƬ
          $(".user-name").append(result.productBelongName);  //�̼�
          $(".uio").append(result.productDescribe);         //����
          $(".pricespan").append(result.productPrice);     //�۸�
}
