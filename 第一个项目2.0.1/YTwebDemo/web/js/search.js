
$("#search_icon").click(function serchProduct(){
    let world = $("#search").val();
    if (world.length<=0)
    {
        alert("�������ѯ�ؼ��֣�")
        return ;
    }
    else {
        let flag1 =  /[""?������|{��;��<>��������/_��=+&*%$#!~`@��||]/.test(world);
        if (flag1)
        {
            alert("������������ַ���")

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