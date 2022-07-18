<%@ page language="java" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
    <form>
        <input id="postId" hidden value="${post.id}"/>
        <div class="mb-3">
            <label for="title">Title:</label>
            <input type="text" class="form-control" id="title" placeholder="Enter title" value="${post.title}">
        </div>
        <div class="mb-3">
            <label for="content">Content:</label>
            <textarea class="form-control" rows="5" id="content">${post.content}</textarea>
        </div>
    </form>

    <button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
    <button id="btn-update-post" class="btn btn-secondary btn-warning">포스트수정</button>
</div>

<script>
    $(document).ready(function () {
        $("#content").summernote({
            height: 300
        });
    });
</script>

<script src="/js/post.js"></script>

<%@ include file="../layout/footer.jsp"%>

