$(document).ready(function () {

    $("#log_in_btn").click(function () {
        let role = $("#identity > input:checked").val();
        let requestURL = "/login";

        if (role === "0") {
            requestURL += "/admin";
        } else if (role === "1") {
            requestURL += "/teacher";
        } else if (role === "2") {
            requestURL += "/student";
        }

        let logInModel = {username: $.trim($("#username").val()), password: $.trim($("#password").val())};

        let params = "?username=" + logInModel.username + "&password=" + logInModel.password;

        $.ajax({
            url: requestURL,
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(logInModel),
            dataType: "json",
            success: function (AjaxResult) {
                let httpCode = AjaxResult.code;
                let msg = AjaxResult.msg;
                if (httpCode === 200) {
                    window.location.href = "/html/" + requestURL.slice(7, requestURL.length) + "Home.html";
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