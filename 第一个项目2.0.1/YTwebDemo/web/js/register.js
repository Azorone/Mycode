$("#submit").click(function (){
    let pass = $("#userPass").val();
    let pass2 = $("#userPass1").val();
    let emil  = $("#userMail").val();
    let username = $("#username").val();
    let adress   = $("#userAdress").val();
    let id       =$("#userID").val();


    if (id.length<10)
    {
        alert("�˺Ź��̣�");
        return ;
    }
  let key = isNaN(id);
  if (key){
      alert("��ʹ�ô����֣�")
      return ;
  }
  if (pass.length<6){
      alert("����������")
      return ;
  }
  if (emil.length===0)
  {
      alert("����������")
      return ;
  }
  if (username.length===0)
  {
      alert("�����ǳ�")
      return ;
  }
  if (adress.length===0){
      alert("�������ַ")
      return ;
  }
  let flag1 =  /[""?������|{��;��<>��������/_��=+&*%$#!]/.test(pass);
  let flage2 =/[""?������|{��;��<>��������/_��=+&*%$#!]/.test(emil);
  let flage3 = /[""?������|{��;��<>��������/_��=+&*%$#!]/.test(username);
  let flage4  = /[""?������|{��;��<>��������/_��=+&*%$#!]/.test(adress);

  if (flag1 || flage2 || flage3 || flage4 ){
      alert("�벻Ҫʹ�������ַ�")


  }
  else {
      if (pass===pass2)
      {
          let re = new RegExp( "@qq.com");
          let key =re.test(emil);
          if (key){
               $.ajax({
                       type:"POST",
                 url:"register",
                   data:"userPass="+pass+"&userMail="+emil+"&userName="+username+"&userAdress="+adress+"&userID="+id,
                   success:function (data){

                           if (data){
                               alert("ע��ɹ���")
                               window.open("Login.html")
                           }else{
                               alert("�˺ű�ע�ᣡ")
                           }

               }

          })


          }
          else {

              alert("��������ȷ��QQ�����ʽ!")
              $("#register").submit(function (e){


                  return ;
              });

          }

      }
      else {

              alert("�����������벻��ͬ��")

              return ;


      }

}




    
})