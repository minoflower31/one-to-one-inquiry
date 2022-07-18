<%@ page language="java" pageEncoding="UTF-8" %>

<%@ include file="layout/header.jsp" %>

<div class="container-fluid mt-3">

    <c:if test="${!empty postList}">
        <div class="card">
            <c:forEach var="post" items="${postList.content}">
                <div class="card-body">
                    <h4 class="card-title">${post.title}</h4>
                    <a href="/post/${post.id}" class="btn btn-secondary">상세 보기</a>
                </div>
            </c:forEach>
            <ul class="pagination pagination-lg justify-content-between">
                <li class="page-item <c:if test="${postList.first}">disabled </c:if>"> <a class="page-link" href="?page=${postList.number - 1}">이전</a></li>
                <li class="page-item <c:if test="${postList.last}">disabled </c:if>"> <a class="page-link" href="?page=${postList.number + 1}">다음</a></li>
            </ul>
        </div>
    </c:if>
</div>

<%@ include file="layout/footer.jsp" %>
