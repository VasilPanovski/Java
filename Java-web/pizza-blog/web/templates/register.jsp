<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
    <form method="POST" action="">
        <label>Username</label>
        <div class="form-group">
            <input name="username" type="text" class="form-control" placeholder="Enter username">
        </div>
        <label>Email</label>
        <div class="form-group">
            <input name="email" type="text" class="form-control" placeholder="Enter email">
        </div>
        <label>Password</label>
        <div class="form-group">
            <input name="password" type="password" class="form-control" placeholder="Enter password">
        </div>
        <label>Confirm Password</label>
        <div class="form-group">
            <input name="confirmPassword" type="password" class="form-control" placeholder="Confirm password">
        </div>
        <input type="reset" class="btn btn-danger" value="Clear"/>
        <input type="submit" class="btn btn-success" value="Register"/>
    </form>
</div>
<jsp:include page="footer.jsp"/>
