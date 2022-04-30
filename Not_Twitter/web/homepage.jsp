
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/views/header.jsp" />
<body>
    <jsp:include page="/views/sidebar.jsp" />

    <jsp:include page="/views/search.jsp"/>
    <br/>
    <%--This is for posting tweets  --%>
    <c:choose>
        <c:when test="${logged_in == true}">
             <jsp:include page="/views/make_tweet.jsp"/>
        </c:when>
    </c:choose>
    <jsp:include page="/views/tweetView.jsp"/>
    
    

<jsp:include page="/views/footer.jsp" />