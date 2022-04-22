const display = document.getElementById("display");
const page = document.getElementById("num");
const increase = document.getElementById("pageNum").querySelectorAll("button")[1];
const reduce = document.getElementById("pageNum").querySelectorAll("button")[0];
const btns = document.getElementById("menu").querySelectorAll("button")
var list = [
    { url: "Image/test.jpg", name: "商品名", status: "已售出", money: "100"},
    { url: "Image/test.jpg", name: "商品名", status: "已售出", money: "200"},
    { url: "Image/test.jpg", name: "商品名", status: "已售出", money: "300"},
    { url: "Image/test.jpg", name: "商品名", status: "已售出", money: "400"},
    { url: "Image/test.jpg", name: "商品名", status: "已售出", money: "500"}
];
function create(index) {
    let img = document.createElement("img");
    let p = document.createElement("p");
    let b = document.createElement("b");
    let box = document.createElement("div");
    p.innerText = list[index].name + "状态：" + list[index].status;
    img.src = list[index].url;
    b.innerHTML = list[index].money+"￥";
    box.appendChild(img);
    box.appendChild(p);
    box.appendChild(b);
    display.appendChild(box);
}
function creatediv() {
    let n = parseInt(page.innerText);
    display.innerHTML="";
    list.forEach(function (value, index) {
        if (index >= (n - 1) * 4 && index < n * 4) {
            create(index);
            if(index%2==1){
                let br= document.createElement("br");
                display.appendChild(br);
            }
        }
    });
}
window.onload = function () {
    creatediv();
};
function changelist(text){
    if(text=="已售出"){

    }
}
btns.forEach(function(btn){
    btn.addEventListener("click",function(){
        btns.forEach(function(btn){
            btn.classList.remove("btn");
            btn.classList.add("btn2");
        })
        this.classList.add("btn");
        this.classList.remove("btn2");
        changelist(this.innerText);//后台重新获取list的值
        page.innerText="1";//初始化页码
        creatediv();//初始化订单
    })
})
increase.addEventListener("click",function(){
    let pagen=parseInt(page.innerText);
    if(pagen<(list.length+4-1)/4){
        pagen=pagen+1;
        page.innerText=pagen.toString();
        creatediv();
    }
})
reduce.addEventListener("click",function(){
    let pagen=parseInt(page.innerText);
    if(pagen>1){
        pagen=pagen-1;
        page.innerText=pagen.toString();
        creatediv();
    }
})