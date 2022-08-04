$(function () {
    //没有登录就跳转到登录页面
    $.ajax({
        url: "/judgeIfLogin",
        type: "post",
        data: {"null": "null"},
        success: function (resultStr) {
            if (resultStr === "NO") {
                let path = window.location.href.split("/");
                if (top.location !== self.location) {
                    window.parent.location = path[0] + "/index.html";
                }else{
                    window.location.href = path[0] + "/index.html";
                }
            }
        }
    });
});