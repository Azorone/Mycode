


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
                    url:"getProductClass",
                    data:"keyWorld="+world,
                    dataType:"json",
                    success:function (data){
                        $.each(data, function (i, item) {
                            //从后台获取数据
                            $(".ulshow").empty();
                            CreadProductCartP(item)
                        });
                    }
                })
        }
    }
});