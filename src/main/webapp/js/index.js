var lis = document.querySelectorAll('.box-nav li');

for (var i = 0; i < lis.length; i++) {
    lis[i].setAttribute('index', i);
    lis[i].onclick = function() {
        for (var i = 0; i < lis.length; i++) {
            lis[i].className = '';
        }
        this.className = 'choose-box';
        var index = this.getAttribute('index'); // 用于判断当前点到哪个东西
        if (index==0){
            document.getElementById("key").style.display="block"
        }else {
            document.getElementById("key").style.display="none"
        }
    }};
