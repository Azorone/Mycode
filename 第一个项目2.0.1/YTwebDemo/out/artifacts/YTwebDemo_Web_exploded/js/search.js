
$("#search_icon").click(function serchProduct(){
    let world = $("#search").val();
    if (world.length<=0)
    {
        alert("ÇëÊäÈë²éÑ¯¹Ø¼ü×Ö£¡")
        return ;
    }
    else {
        let flag1 =  /[""?£¿¡°¡±|{£º;£»<>£¬¡££¬¡¢/_¡ª=+&*%$#!~`@£¤||]/.test(world);
        if (flag1)
        {
            alert("ÇëÎð°üº¬ÌØÊâ×Ö·û£¡")

            return ;
        }
        else {
                $.post({
                    url:"searchPage",
                    data:"keyWorld="+world,
                    success:function (){
                        window.open("ProductClass.html")
                    }
                })
        }
    }
});