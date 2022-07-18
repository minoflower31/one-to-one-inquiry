<%@ page language="java" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<div class="container-fluid mt-3">

    <c:if test="${!empty post}">
        <form>
            <input type="hidden" id="postId" value="${post.id}">
        </form>

        <div class="card" style="margin: 50px 100px 0 100px">
            <div class="card-body">
                <h4 class="card-title">${post.title}</h4>

                <div style="margin: 20px 0 30px 0">${post.content}</div>

                <div>
                    포스트 번호: <i>${post.id}</i> <br>
                    작성자: <i>${post.user.username}</i>
                </div>

                <hr>

                <button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
                <a href="/post/${post.id}/updatePost" class="btn btn-warning"
                   <c:if test="${post.user.username != user.username}">hidden</c:if>>수정하기</a>
                <button id="btn-delete-post" class="btn btn-danger"
                   <c:if test="${post.user.username != user.username}">hidden</c:if>>삭제하기</button>
            </div>

            <div style="margin: 40px 30px 10px 30px">
                <table cellpadding="10px" border="0" width="100%">

                    <colgroup>
                        <col style="width: 80%">
                        <col style="width: 10%">
                        <col style="width: 20%">
                    </colgroup>
                    <tr style="border-bottom: 2px solid black">
                        <th>내용</th>
                        <th style="text-align: center">작성자</th>
                        <th style="text-align: center">삭제</th>
                    </tr>

                    <c:forEach var="reply" items="${replyList}">
                        <tr style="border-bottom: 1px solid lightgray">
                            <td>${reply.comment}</td>
                            <td style="text-align: center">${reply.writer}</td>
                            <td style="text-align: center">
                                <input type="hidden" id="replyId" value="${reply.id}">
                                <button id="btn-delete-reply" class="btn btn-light pull-right"
                                        <c:if test="${reply.writer != user.username}">style="visibility: hidden"</c:if>>삭제
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

                <br>

                <form>
                    <textarea id="comment" rows="1" style="width: 100%"></textarea>
                </form>
                <button id="btn-insert-reply" class="btn btn-secondary" style="float: right; ">덧글등록</button>
            </div>
        </div>
    </c:if>
</div>

<script src="/js/post.js"></script>
<script src="/js/reply.js"></script>

<%@ include file="../layout/footer.jsp" %>

