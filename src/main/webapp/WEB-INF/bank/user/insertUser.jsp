<%@ page language="java" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>
<br>
<div class="container-fluid mt-3">
    <form>
        <div class="mb-3">
            <label for="username">Username:</label>
            <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
        </div>
        <div class="mb-3">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
        </div>
        <div class="mb-3 mt-3">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
        </div>
    </form>
    <button id="btn-insert" class="btn btn-secondary">회원가입</button>

</div>
<script type="text/javascript" src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>
