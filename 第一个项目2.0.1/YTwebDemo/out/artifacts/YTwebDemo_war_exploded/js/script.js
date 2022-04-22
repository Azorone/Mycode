const display = document.getElementById("display");
const page = document.getElementById("num");
const increase = document
    .getElementById("pageNum")
    .querySelectorAll("button")[1];
const reduce = document.getElementById("pageNum").querySelectorAll("button")[0];
const btns = document.getElementById("menu").querySelectorAll("button");
var list;
var user = {name:"",pic:""};
//user元组为用户信息.
function changeuser() {
    //后台获取用户的属性
    user.name="打工人"
    user.pic="Portrait\\default.jpg"
}
function disinfo() {
    let info= document.getElementById("info");
    let img=document.createElement("img")
    let p =document.createElement("p");
    img.src = user.pic;
    p.innerText = user.name;
    info.appendChild(img)
    info.appendChild(p)
}
function create(index) {
    let img = document.createElement("img");
    let p = document.createElement("p");
    let b = document.createElement("b");
    let box = document.createElement("div");
    let btn = document.createElement("button");
    btn.innerText = "编辑";
    btn.classList.add("edit");
    p.innerText = list[index].name + "状态：" + list[index].status;
    img.src = list[index].url;
    b.innerHTML = list[index].money + "￥";
    btn.addEventListener("click", function () {

        /**打开商品删除页面 */
        window.open("test.html");
        nowindex = index; //指定nowindex下标的订单，共用一个js中的数据
    });
    box.appendChild(img);
    box.appendChild(p);
    box.appendChild(b);
    box.appendChild(btn);
    display.appendChild(box);
}
function creatediv() {
    let n = parseInt(page.innerText);
    display.innerHTML = "";
    list.forEach(function (value, index) {
        if (index >= (n - 1) * 4 && index < n * 4) {
            create(index);
            if (index % 2 == 1) {
                let br = document.createElement("br");
                display.appendChild(br);
            }
        }
    });
}
window.onload = function () {
    changelist();
    creatediv();
    changeuser();
    disinfo();
};
function changelist(text) {
    if (text == "已售出") {
        $(document).ready(function () {
            $.getJSON("getCart", function (data) {

                list = data;
            });
        });

    }
}
btns.forEach(function (btn) {
    btn.classList.add("btn2");
});
btns.forEach(function (btn) {
    btn.addEventListener("click", function () {
        btns.forEach(function (btn) {
            btn.style.backgroundColor = "white";
        });
        this.style.backgroundColor = "steelblue";
        changelist(this.innerText); //后台重新获取list的值
        page.innerText = "1"; //初始化页码
        creatediv(); //初始化订单
    });
});




/***s上一页下一页函数 */
increase.addEventListener("click", function () {
    let pagen = parseInt(page.innerText);
    if (pagen < (list.length + 4 - 1) / 4) {
        pagen = pagen + 1;
        page.innerText = pagen.toString();
        creatediv();
    }
});
reduce.addEventListener("click", function () {
    let pagen = parseInt(page.innerText);
    if (pagen > 1) {
        pagen = pagen - 1;
        page.innerText = pagen.toString();
        creatediv();
    }
});
