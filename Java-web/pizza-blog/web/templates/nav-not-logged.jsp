<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar-wrapper">
    <div class="container">
        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div id="navbar">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/home/topics">Topics</a></li>
                        <li><a href="${pageContext.request.contextPath}/home/categories">Categories</a></li>
                    </ul>
                    <ul class="signmenu nav navbar-nav">
                        <li><span class="navbar-text">Hello, <a href="${pageContext.request.contextPath}/forum/login">Log in</a></span></li>
                        <li><span class="navbar-text"><a href="${pageContext.request.contextPath}/forum/register">Register</a></span></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>