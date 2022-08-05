$(document).ready(function () {

    $("#log_in_btn").click(function () {

        let user = {
            userid: "",
            nickname: "",
            username: $.trim($("#username").val()),
            password: $.trim($("#password").val()),
            userrole: $.trim($("#identity > input:checked").val()),
            introduce: ""
        };

        $.ajax({
            url: "/login",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(user),
            dataType: "json",
            success: function (AjaxResult) {
                let httpCode = AjaxResult.code;
                let msg = AjaxResult.msg;
                if (httpCode === 200) {
                    user = AjaxResult.data;
                    sessionStorage.setItem(user.userid, JSON.stringify(user));
                    console.log(JSON.parse(sessionStorage.getItem(user.userid)));
                    window.location.href = "/html/" + user.userrole + "Home.html";
                } else {
                    alert(msg);
                }
            },
            error: function () {
                alert("请求错误");
            }
        });
    });
});