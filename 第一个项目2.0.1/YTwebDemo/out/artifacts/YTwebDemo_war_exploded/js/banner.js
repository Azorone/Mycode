            window.onload = function () {
                var banner = document.getElementById("banner"),
                    pic = document
                        .getElementById("pic")
                        .getElementsByTagName("li"),
                    list = document
                        .getElementById("list")
                        .getElementsByTagName("li"),
                    index = -1,
                    timer = null;
                for(let i=1;i<5;i++){
                    pic[i].style.visibility="visible";
                }
                // ���岢�����Զ����ź���
                timer = setInterval(autoPlay, 2000);
                autoPlay();
                // ��껮����������ʱֹͣ�Զ�����
                wrap.onmouseover = function () {
                    clearInterval(timer);
                };

                // ����뿪��������ʱ������������һ��
                wrap.onmouseout = function () {
                    timer = setInterval(autoPlay, 2000);
                };
                // �����������ֵ���ʵ�ֻ����л�����Ӧ��ͼƬ
                for (var i = 0; i < list.length; i++) {
                    list[i].onmouseover = function () {
                        clearInterval(timer);
                        index = this.innerText - 1;
                        changePic(index);
                    };
                }

                function autoPlay() {
                    if (++index >= pic.length) index = 0;
                    changePic(index);
                }

                // ����ͼƬ�л�����
                function changePic(curIndex) {
                    for (var i = 0; i < pic.length; ++i) {
                        pic[i].style.display = "none";
                        list[i].className = "";
                    }
                    pic[curIndex].style.display = "block";
                    list[curIndex].className = "on";
                }
            };