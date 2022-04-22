$("#submit").click(function (){
    let pass = $("#userPass").val();
    let pass2 = $("#userPass1").val();
    let emil  = $("#userMail").val();
    let username = $("#username").val();
    let adress   = $("#userAdress").val();
    let id       =$("#userID").val();


    if (id.length<10)
    {
        alert("账号过短！");
        return ;
    }
  let key = isNaN(id);
  if (key){
      alert("请使用纯数字！")
      return ;
  }
  if (pass.length<6){
      alert("请输入密码")
      return ;
  }
  if (emil.length===0)
  {
      alert("请输入邮箱")
      return ;
  }
  if (username.length===0)
  {
      alert("请输昵称")
      return ;
  }
  if (adress.length===0){
      alert("请输入地址")
      return ;
  }
  let flag1 =  /[""?？“”|{：;；<>，。，、/_—=+&*%$#!]/.test(pass);
  let flage2 =/[""?？“”|{：;；<>，。，、/_—=+&*%$#!]/.test(emil);
  let flage3 = /[""?？“”|{：;；<>，。，、/_—=+&*%$#!]/.test(username);
  let flage4  = /[""?？“”|{：;；<>，。，、/_—=+&*%$#!]/.test(adress);

  if (flag1 || flage2 || flage3 || flage4 ){
      alert("请不要使用特殊字符")


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
                               alert("注册成功！")
                               window.open("Login.html")
                           }else{
                               alert("账号被注册！")
                           }

               }

          })


          }
          else {

              alert("请输入正确的QQ邮箱格式!")
              $("#register").submit(function (e){


                  return ;
              });

          }

      }
      else {

              alert("两次密码输入不相同！")

              return ;


      }

}




    
})