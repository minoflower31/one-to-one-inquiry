let postObject = {

    init: function () {
        let _this = this;

        $("#btn-insert-post").on("click", () => {
            _this.insertPost();
        });
    },

    insertPost: function () {
        alert("1:1 문의 등록 요청됨");

        let post = {
            title: $("#title").val(),
            content: $("#content").val(),
        }

        $.ajax({
            type: "POST",
            url: "/post/insert-post",
            data: JSON.stringify(post),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            alert(response);
            location = "/";
        });
    },

    updatePost: function (postId) {
        alert("1:1 문의 수정 요청됨");

        console.log(postId)
        let post = {
            title: $("#title").val(),
            content: $("#content").val(),
        }

        $.ajax({
            type: "PUT",
            url: `/post/${postId}`,
            data: JSON.stringify(post),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            alert(response);
            location = "/";
        });
    },

    deletePost: function (postId) {
        alert("1:1 문의 삭제 요청됨");

        $.ajax({
            type: "DELETE",
            url: `/post/${postId}`,
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            alert(response);
            location = "/";
        });
    },
}

postObject.init();