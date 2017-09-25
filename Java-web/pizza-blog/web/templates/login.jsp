<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<jsp:include page="nav-not-logged.jsp"/>
<div class="container">
    <form method="POST">
        <label>Username</label>
        <div class="form-group">
            <input name="username" type="text" class="form-control" placeholder="Enter username or email" required/>
        </div>
        <label>Password</label>
        <div class="form-group">
            <input name="password" type="password" class="form-control" placeholder="Enter password" required/>
        </div>
        <a href="${pageContext.request.contextPath}/register" class="btn btn-primary">Register</a>
        <input type="submit" class="btn btn-success" value="Log In"/>
    </form>
</div>
<jsp:include page="footer.jsp"/>
