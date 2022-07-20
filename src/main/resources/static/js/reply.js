let replyObject = {

    insertReply: function (postId) {
        alert("덧글 등록 요청됨");

        let reply = {
            postId: postId,
            comment: $("#comment").val(),
        }

        $.ajax({
            type: "POST",
            url: "/post/reply/insertReply",
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            alert(response);
            location = `/post/${reply.postId}`;
        });
    },

    deleteReply: function (postId, replyId) {
        alert("덧글 삭제 요청됨");

        $.ajax({
            type: "DELETE",
            url: `/post/reply/${replyId}`,
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            alert(response);
            location = `/post/${postId}`;
        });
    },
}

replyObject.init();