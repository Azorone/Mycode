


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
                    url:"getProductClass",
                    data:"keyWorld="+world,
                    dataType:"json",
                    success:function (data){
                        $.each(data, function (i, item) {
                            //�Ӻ�̨��ȡ����
                            $(".ulshow").empty();
                            CreadProductCartP(item)
                        });
                    }
                })
        }
    }
});