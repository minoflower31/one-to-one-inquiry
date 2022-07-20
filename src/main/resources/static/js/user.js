let userObject = {

    init: function () {
        let _this = this;

        $("#btn-insert").on("click", () => {
            _this.insertUser();
        });
    },

    insertUser: function () {
        alert("회원 가입 요청됨");

        let user = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        }

        $.ajax({
            type: "POST",
            url: "/auth/sign-up",
            data: JSON.stringify(user),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            alert(response);
            location = "/";
        });
    },
}

userObject.init();