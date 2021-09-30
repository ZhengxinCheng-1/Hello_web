var lis = document.querySelectorAll('.show-ioc li');

showImg=document.getElementById("show-img");
for (var i = 0; i < lis.length; i++) {

    lis[i].onclick = function() {
        showImg.src=this.getElementsByTagName("img")[0].src;
    }};
