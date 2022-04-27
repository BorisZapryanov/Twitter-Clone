<%-- 
    Document   : homepage
    Created on : Apr 12, 2022, 1:39:59 PM
    Author     : icoza
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/views/header.jsp" />
<body>
    <jsp:include page="/views/sidebar.jsp" />
    <c:choose>
        <c:when test="${logged_in == true}">
            <jsp:include page="/views/make_tweet.jsp" />
        </c:when>
    </c:choose>
    <div class="search">
        <h1>Home</h1>
        <form action="/action_page.php">
      <input type="text" placeholder="Search.." name="search">
      <button type="submit">Submit</button>
    </form>
    </div>
<jsp:include page="/views/footer.jsp" />


<jsp:include page="/views/footer.jsp" />