<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<c:choose>
    <c:when test="${sessionScope.user == null}">
        <jsp:include page="nav-not-logged.jsp"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="nav-logged.jsp"/>
        <jsp:include page="topic-new-button.jsp"/>
    </c:otherwise>
</c:choose>
<c:forEach var="topic" items="${topics.getTopics()}">
    <jsp:include page="topic-details-content.jsp"/>
</c:forEach>
<jsp:include page="footer.jsp"/>
