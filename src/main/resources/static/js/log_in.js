$(document).ready(function () {

    $("#log_in_btn").click(function () {
        let role = $("#identity > input:checked").val();
        let requestURL = "/login";

        if (role === "0") {
            requestURL = requestURL + "/admin";
        } else if (role === "1") {
            requestURL = requestURL + "/teacher";
        } else if (role === "2") {
            requestURL = requestURL + "/student";
        }

        let username = $.trim($("#username").val());
        let password = $.trim($("#password").val());

        let jsonData = {"username": username, "password": password};

        console.log(jsonData);

        $.ajax({
            url: requestURL,
            type: "POST",
            contentType: "application/json;charset=utf-8",
            data: jsonData,
            success: function (AjaxResult) {
                let httpCode = AjaxResult.code;
                let msg = AjaxResult.msg;
                if (httpCode === 200) {
                    window.location.href = requestURL.slice(7, requestURL.length - 7) + "Home.html？username=" + username + "&password=" + password;
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