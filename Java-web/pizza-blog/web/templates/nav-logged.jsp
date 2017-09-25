<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar-wrapper">
    <div class="container">
        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div id="navbar">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/home/topics">Topics</a></li>
                        <li><a href="${pageContext.request.contextPath}/home/categories">Categories</a></li>
                        <c:choose>
                            <c:when test="${user.isAdmin() == true}">
                                <li class="dropdown">
                                    <a href="${pageContext.request.contextPath}/categories" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li class=""><a href="${pageContext.request.contextPath}/categories">Categories</a></li>
                                    </ul>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="dropdown">
                                    <a href="/" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin <span class="caret"></span></a>
                                </li>
                            </c:otherwise>
                        </c:choose>

                    </ul>
                    <ul class="signmenu nav navbar-nav">
                        <li><span class="navbar-text">Hello, <a href="#">${user.getUsername()}</a></span></li>
                        <li><span class="navbar-text"><a href="${pageContext.request.contextPath}/forum/logout">Log out</a></span></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
