
function showTime(div,time) {
    setInterval(function() {
        var nowTime = new Date();//获取当前时间
        //创建目标日期
        var endTime = new Date(time);
        var seconds = parseInt((endTime.getTime() - nowTime.getTime()) / 1000);//两个时间点的时间差(秒)
        var d = parseInt(seconds / 3600 / 24);//得到天数
        var h = parseInt(seconds / 3600 % 24);//小时
        var m = parseInt(seconds / 60 % 60);//分钟
        var s = parseInt(seconds % 60);//秒
        div.innerHTML = "距离活动结束还有" + d +"天" + h + "小时" + m + "分钟" + s + "秒";
    }, 1000);
}
