function TradeCreatCard(data){    //�������Ϊ

       let li=$("<li class='lip'></li>");
         let h6 = $("<h6 id='cardh6'></h6>");
       let divimg = $("<div id='divimg'></div>");
       let imgPrduct =$("<img id='imgPrduct'></img>");
       let divNew=$("<div id='divNews'></div>");
       let pUid  = $("<p id='puid'></p>");
       let pNumber = $("<p id='pNumber'></p>");
       let divButton = $("<div id='divButton'></div>");
       let a1        = $("<a id='a1'></a>");
       let a2        = $("<a id='a2'></a>");
       let button1   = $("<button id='button1'></button>");
       let button2  = $("<button id='button2'></button>");
       a1.append(button1);
       a2.append(button2);
         divButton.append(a1);
         divButton.append(a2);
         divimg.append(imgPrduct);
         divNew.append(pUid);
         divNew.append(pNumber);
         li.append(h6);
         li.append(divimg);
         li.append(divNew);
         li.append(divButton);
        $(".ulshow").append(li);          
}
function CreatProductCard(Product){  //��ȡ�ϴ�����Ʒ
         
  let li=$("<li class='lip'></li>");
  let h6 = $("<h6 id='cardh6'>"+Product.productName+"</h6>");
let divimg = $("<div id='divimg'></div>");
let imgPrduct =$("<img id='imgPrduct'></img>");
    imgPrduct.attr("width","300px");
    imgPrduct.attr("src",Product.productIMGurl);
let divNew=$("<div id='divNews'></div>");
let pUid  = $("<p id='puid'>"+Product.productID+"</p>");
let divButton = $("<div id='divButton'></div>");
let a1        = $("<a id='a1'></a>");
let a2        = $("<a id='a2'></a>");
let button1   = $("<button id='button1'>�༭</button>");
let button2  = $("<button id='button2'>ɾ��</button>");

               button1.click(function (){

                   $.ajax({
                       type: "POST",
                       url: "alterProduct",
                       data:"ID="+Product.productID,
                       success:function () {
                           window.open("alterProduct.html");
                       }
                   })
               })

               button2.click(function (){

                   $.ajax({
                       type: "POST",
                       url: "DelectrProduct",
                       data:"ID="+Product.productID,
                       success:function (data) {
                        alert(data);
                           $(".ulshow").empty();
                           getDatajson("sellProduct",5);
                       }
                   })


               });

a1.append(button1);
a2.append(button2);
  divButton.append(a1);
  divButton.append(a2);
  divimg.append(imgPrduct);
  divNew.append(pUid);

  li.append(h6);
  li.append(divimg);
  li.append(divNew);
  li.append(divButton);
 $(".ulshow").append(li);          
}
function CreatProductOrder(data){                    //��ȡ���յ��Ķ����µ�
         
  let li=$("<li class='lip'></li>");
  let sapnsell = $("<span id='buySpan'>��ң�"+data.BuyName+"</span>");
  let spanTitle1 = $("<span id='spanTitle'>"+data.Pname+"</span>")
let divimg = $("<div id='divimg'></div>");
let imgPrduct =$("<img id='imgPrduct'></img>");
    imgPrduct.attr("width","300px");
    imgPrduct.attr("src",data.Pmurl);
let divNew=$("<div id='divNews'></div>");
let pUid  = $("<p id='puid'>Id: "+data.CartID+"</p>");
let pSta    =$("<p id='PstaOrder'>״̬��δ����</p>")
let divButton = $("<div id='divButton'></div>");
let a1        = $("<a id='a1'></a>");
let a2        = $("<a id='a2'></a>");
let button1   = $("<button id='button1'>���ܶ���</button>");
let button2  = $("<button id='button2'>�ܾ�</button>");
    button1.click(function use(){
        $.ajax({
            type: "POST",
            url: "UpOrterSta",
            data:"OrderID="+data.CartID+"&OrderSta=D",
            success:function news() {
                alert("���ܳɹ���");
                $(".ulshow").empty();
                getDatajson("GETB",1);
            }


        })

    })
    button2.click(function use(){
        $.ajax({
            type: "POST",
            url: "UpOrterSta",
            data:"OrderSta="+data.CartID+"&OrderSta=A",
            success:function news() {
                alert("�ܾ��ɹ���");
                $(".ulshow").empty();
                getDatajson("GETB",1);
            }


        })

    })
a1.append(button1);
a2.append(button2);
  divButton.append(a1);
  divButton.append(a2);
  divimg.append(imgPrduct);
  divNew.append(pUid);
  divNew.append(pSta);
  li.append(sapnsell);
  li.append(spanTitle1);
  li.append(divimg);
  li.append(divNew);
  li.append(divButton);
 $(".ulshow").append(li);          
}
function getdataCardAC(data){           //my order��ҳ��

  let li=$("<li class='lip'></li>");
  let sapnsell = $("<span id='buySpan'>���ң�"+data.SellName+"</span>");
  let spanTitle1 = $("<span id='spanTitle'>"+data.Pname+"</span>")
let divimg = $("<div id='divimg'></div>");
let imgPrduct =$("<img id='imgPrduct'></img>");
    imgPrduct.attr("width","300px");
    imgPrduct.attr("src",data.Pmurl);
let divNew=$("<div id='divNews'></div>");
let pUid  = $("<p id='puid'>Id: "+data.CartID+"</p>");
let pSta    =$("<p id='PstaOrder'>״̬��δ����</p>")
let divButton = $("<div id='divButton'></div>");
let a1        = $("<a id='a1'></a>");
let a2        = $("<a id='a2'></a>");
let button1   = $("<button id='button1'>���ջ�</button>");
a1.append(button1);
  divButton.append(a1);
  divButton.append(a2);
  divimg.append(imgPrduct);
  divNew.append(pUid);
  divNew.append(pNumber);
  divNew.append(pSta);
  li.append(sapnsell);
  li.append(spanTitle1);
  li.append(divimg);
  li.append(divNew);
  li.append(divButton);
 $(".ulshow").append(li); 
}
function AcOrder(data){          //������ҳ�棬����ťҳ��
  let li=$("<li class='lip'></li>");
  let sapnsell = $("<span id='buySpan'>���ң�"+data.SellName+"</span>");
  let spanTitle1 = $("<span id='spanTitle'>"+data.Pname+"</span>")
let divimg = $("<div id='divimg'></div>");
let imgPrduct =$("<img id='imgPrduct'></img>");
    imgPrduct.attr("src",data.Pmurl);
    imgPrduct.attr("width","300px");
let divNew=$("<div id='divNews'></div>");
let PgetAdress=$("<p id='PAdress'>ȡ���ص㣺"+data.adress+"</p>");
let PgetTime = $("<p id = 'PTime'>ȡ��ʱ�䣺"+data.GetTime+"</p>")
let PgetProductNumber = $("<p id='PGPND'>ȡ����:"+data.getOrderName+"</p>");
    let PgetPhone = $("<span id='PGPND'>�̼ҵ绰:"+data.phone+"</span>");
let divButton = $("<div id='divButtonac'></div>");
let a1        = $("<a id='a1'></a>");
let a2        = $("<a id='a2'></a>");
let button2  = $("<button id='button1'>��ɶ���</button>");
let span     = $("<span></span>");
span.append(divButton);
    button2.click(function (){
        $.ajax({
            type: "POST",
            url: "delect",
            data:"OrderID="+data.CartID,
            success:function news() {
                alert("��������ɣ�");
                $(".ulshow").empty();
                getDatajson("GETCDB",4);
            }
        })
    })
a1.append(button2);
  divButton.append(a1);
  divButton.append(a2);
  divimg.append(imgPrduct);
  divNew.append(PgetAdress);
  divNew.append(PgetTime);
  divNew.append(PgetProductNumber);
  divNew.append(PgetPhone);
  li.append(sapnsell);
  li.append(spanTitle1);
  li.append(divimg); divNew.append(span);
  li.append(divNew);


 $(".ulshow").append(li); 
}
function getCarts(data){

  let li=$("<li class='lip'></li>");
  let sapnsell = $("<span id='buySpan'>���ң�"+data.SellName+"</span>");
  let spanTitle1 = $("<span id='spanTitle'>"+data.Pname+"</span>")
let divimg = $("<div id='divimg'></div>");
let imgPrduct =$("<img id='imgPrduct'>");
          imgPrduct.attr("src",data.Pmurl)
          imgPrduct.attr("width","300px");
let divNew=$("<div id='divNews'></div>");
let pUid  = $("<p id='puid'>Id: "+data.CartID+"</p>");
let pPrice1 = $("<p id='pPrice'>�۸�"+data.Ppice+"</P>")
let pSta    =$("<p id='PstaOrder'>״̬��δ�µ�</p>")
let divButton = $("<div id='divButton'></div>");
let a1        = $("<a id='a1'></a>");
let a2        = $("<a id='a2'></a>");
let button1   = $("<button id='button1'>�µ�</button>");
let button2  = $("<button id='button2'>ɾ��</button>");

    button1.click(function use(){
        $.ajax({
            type: "POST",
            url: "UpOrterSta",
            data:"OrderID="+data.CartID+"&OrderSta=B",
            success:function news() {
                alert("�ȴ��̼ҽ��ܣ�");
                $(".ulshow").empty();
                getDatajson("getCart",3);
            }


        })

    })
    button2.click(function delect(){
        $.ajax({
        type: "POST",
        url: "delect",
        data:"OrderID="+data.CartID,
        success:function setA() {
            alert("ɾ���ɹ���");
            $(".ulshow").empty();
            getDatajson("getCart",3);
        }


    })



    })

a1.append(button1);
a2.append(button2);
  divButton.append(a1);
  divButton.append(a2);
  divimg.append(imgPrduct);
  divNew.append(pUid);
  divNew.append(pPrice1);
  divNew.append(pSta);
  
  li.append(sapnsell);
  li.append(spanTitle1);
  li.append(divimg);
  li.append(divNew);
  li.append(divButton);
 $(".ulshow").append(li);
}
function  getRefuseOrder(data){

  let li=$("<li class='lip'></li>");
  let sapnsell = $("<span id='buySpan'>���ң�"+data.SellName+"</span>");
  let spanTitle1 = $("<span id='spanTitle'>"+data.Pname+"</span>")
let divimg = $("<div id='divimg'></div>");
let imgPrduct =$("<img id='imgPrduct'></img>");
    imgPrduct.attr("src",data.Pmurl)
    imgPrduct.attr("width","300px");
let divNew=$("<div id='divNews'></div>");
let pUid  = $("<p id='puid'>"+data.CartID+"</p>");
let pPrice1 = $("<p id='pPrice'>�۸�"+data.Pprice+"</P>")
let pSta    =$("<p id='PstaOrder'>״̬���̼Ҿܾ�</p>")
let divButton = $("<div id='divButton'></div>");
let a1        = $("<a id='a1'></a>");
let a2        = $("<a id='a2'></a>");
let button1   = $("<button id='button1'>ȷ��</button>");
let button2  = $("<button id='button2'>ɾ��</button>");
    button1.click(function use(){
        $.ajax({
            type: "POST",
            url: "UpOrterSta",
            data:"OrderID="+data.CartID+"&OrderSta=A",
            success:function news() {
                alert("�Իص����ﳵ��");
                $(".ulshow").empty();
                getDatajson("GETCDB",4);
            }


        })

    })
    button2.click(function delect(){
        $.ajax({
            type: "POST",
            url: "delect",
            data:"OrderID="+data.CartID,
            success:function setA() {
                alert("ɾ���ɹ���");
                $(".ulshow").empty();
                getDatajson("GETCDB",4);
            }
        })
    })
a1.append(button1);
a2.append(button2);
  divButton.append(a1);
  divButton.append(a2);
  divimg.append(imgPrduct);
  divNew.append(pUid);
  divNew.append(pPrice1);
  divNew.append(pSta);
  li.append(sapnsell);
  li.append(spanTitle1);
  li.append(divimg);
  li.append(divNew);
  li.append(divButton);
 $(".ulshow").append(li);
}
function getWrite(data) {
  
  let li=$("<li class='lip'></li>");
  let sapnsell = $("<span id='buySpan'>���ң�"+data.SellName+"</span>");
  let spanTitle1 = $("<span id='spanTitle'>"+data.Pname+"</span>")
let divimg = $("<div id='divimg'></div>");
let imgPrduct =$("<img id='imgPrduct'></img>");
    imgPrduct.attr("src",data.Pmurl)
    imgPrduct.attr("width","300px");
let divNew=$("<div id='divNews'></div>");
let pUid  = $("<p id='puid'>"+data.CartID+"</p>");
let pPrice1 = $("<p id='pPrice'>�۸�"+data.Ppice+"</P>")
let pSta    =$("<p id='PstaOrder'>״̬���̼�δ����</p>")
let divButton = $("<div id='divButton'></div>");
let a1        = $("<a id='a1'></a>");
let button1   = $("<button id='button1'>ȡ��</button>");
    button1.click(function use(){
        $.ajax({
            type: "POST",
            url: "UpOrterSta",
            data:"OrderID="+data.CartID+"&OrderSta=A",
            success:function news() {
                alert("ȡ���ɹ���");
                $(".ulshow").empty();
                getDatajson("GETCDB",4);
            }


        })

    })

imgPrduct.attr("src",data.Pmurl);
a1.append(button1);
  divButton.append(a1);
  divimg.append(imgPrduct);
  divNew.append(pUid);
  divNew.append(pPrice1);
  divNew.append(pSta);
  li.append(sapnsell);
  li.append(spanTitle1);
  li.append(divimg);
  li.append(divNew);
  li.append(divButton);
 $(".ulshow").append(li);
}
function getNotsent(data) {

let li=$("<li class='lip'></li>");
  let sapnsell = $("<span id='buySpan'> ��ң�"+data.BuyName+"</span>");
  let spanTitle1 = $("<span id='spanTitle'>"+data.Pname+"</span>")
let divimg = $("<div id='divimg'></div>");
let imgPrduct =$("<img id='imgPrduct'></img>");
    imgPrduct.attr("src",data.Pmurl)
    imgPrduct.attr("width","300px");
let divNew=$("<div id='divNews'></div>");
let PgetAdress=$("<p id='PAdress'>�ͻ��ص㣺"+data.adress+"</p>");
let PgetTime = $("<p id = 'PTime'>�ͻ�ʱ�䣺"+data.GetTime+"</p>")
let PgetProductNumber = $("<p id='PGPND'>�ͻ���:"+data.getOrderName+"</p>");

let divButton = $("<div id='divButton'></div>");
let a1        = $("<a id='a1'></a>");
let a2        = $("<a id='a2'></a>");
let button1   = $("<button id='button1'>�ȴ��û�ȷ���ջ�</button>");
  divButton.append(a1);
  divButton.append(a2);
  divimg.append(imgPrduct);
  divNew.append(PgetAdress);
  divNew.append(PgetTime);
  divNew.append(PgetProductNumber);
  li.append(sapnsell);
  li.append(spanTitle1);
  li.append(divimg);
  li.append(divNew);
  li.append(divButton);
 $(".ulshow").append(li); 


  
}
/*********��ť***** */
$("#pbt5").click(function getdataProducts(){          //��ȡ�ϼܵ���Ʒ
  $("#pbt1").css( "background","white")
  $("#pbt2").css( "background","white")
  $("#pbt3").css( "background","white")
  $("#pbt4").css( "background","white")
  $("#pbt5").css( "background","rgb(87, 219, 219)")
   $(".ulshow").empty();
    getDatajson("sellProduct",5);

  
})
$("#pbt3").click(function getdataCard(){              //��ȡ���ﳵ�е���Ʒ
  $("#pbt1").css( "background","white")
  $("#pbt2").css( "background","white")
  $("#pbt3").css( "background","rgb(87, 219, 219)")
  $("#pbt4").css( "background","white")
  $("#pbt5").css( "background","white")
         $(".ulshow").empty();
    getDatajson("getCart",3);

         
})
$("#pbt4").click(function getdataPlaceAnOrder(){     //��ȡ���µ�����Ʒ
  $("#pbt1").css( "background","white")
  $("#pbt2").css( "background","white")
  $("#pbt3").css( "background","white")
  $("#pbt4").css( "background","rgb(87, 219, 219)")
  $("#pbt5").css( "background","white")

           $(".ulshow").empty();
    getDatajson("GETCDB",4);
       /* if(key==="B")
        {
          getWrite();
          
        }
        else if(key2==="C"){
          getRefuseOrder();
        }
        else if(key3==="D"){
          AcOrder();
        }*/
})
$("#pbt1").click(function getdataOrder(){            //��ȡ�յ�����
      $("#pbt1").css( "background","rgb(87, 219, 219)")
      $("#pbt2").css( "background","white")
      $("#pbt3").css( "background","white")
      $("#pbt4").css( "background","white")
      $("#pbt5").css( "background","white")

      $(".ulshow").empty();
    getDatajson("GETB",1);
        //CreatProductOrder();
      
})
$("#pbt2").click(function getWiteOrder(){    
  $("#pbt1").css( "background","white")
  $("#pbt2").css( "background","rgb(87, 219, 219)")
  $("#pbt3").css( "background","white")
  $("#pbt4").css( "background","white")
  $("#pbt5").css( "background","white")
//��ȡ�����Ķ���
  $(".ulshow").empty();
    getDatajson("GETD",2);
  //getNotsent();
})
$("#pbt6").click(function (){
    window.open("upPrduct2.html");
})

function getDatajson(tag,sta){
    let json;
    $.ajax({
             type:"POST",
             url:tag,
           cache:false,
        dataType:"json",
           success:function (data){

               if (sta===1)
               {
                   $.each(data, function (i, data) {                  //�Ӻ�̨��ȡ����
                       CreatProductOrder(data);
                   });
               }
               else if (sta===2)
               {
                   $.each(data, function (i, data) {                  //�Ӻ�̨��ȡ����
                       getNotsent(data);
                   });
               }
               else if (sta===3)
               {
                   $.each(data, function (i, data) {                  //�Ӻ�̨��ȡ����
                       getCarts(data);
                   });
               }
               else if(sta===4)
               {
                   $.each(data, function (i, data) {                  //�Ӻ�̨��ȡ����

                       if (data.Psta==="B")
                       {
                           getWrite(data);
                       }
                       else if(data.Psta==="C"){

                           getRefuseOrder(data);

                       }
                       else if(data.Psta==="D"){
                           AcOrder(data);
                       }

                   });
               }
               else if (sta===5)
               {
                   $.each(data,function (i,data){
                       CreatProductCard(data);
                   })
               }
           }

    })

}