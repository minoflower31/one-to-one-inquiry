<%@ page language="java" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
    <form action="/auth/login" method="post">
        <div class="mb-3">
            <label for="username">Username:</label>
            <input type="text" class="form-control" id="username" name="username"
                   placeholder="Enter username">
        </div>
        <div class="mb-3">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password"
                   placeholder="Enter password">
        </div>

        <button id="btn-login" class="btn btn-secondary">로그인</button>
    </form>
</div>

<%--<script src="/js/login.js"></script>--%>

<%@ include file="../layout/footer.jsp"%>

