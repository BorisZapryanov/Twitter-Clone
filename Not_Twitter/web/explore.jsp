
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/views/header.jsp" />
<body>
    <jsp:include page="/views/sidebar.jsp" />

    <div class="search">
        <%-- This is the header  --%>
        <img src="assets/output-onlinepngtools.png" alt="alt">
        
        <form action="/action_page.php">
            <div class="search-container">
                <input class="search-input" type="text" placeholder="Search.." name="search">
            </div>
            <button class="button" type="submit">Submit</button><br>
        </form> 
        
    </div>
    <br/>
    <%--This is for posting tweets  --%>
    <c:choose>
        <c:when test="${logged_in == true}">
             <jsp:include page="/views/make_tweet.jsp"/>
        </c:when>
    </c:choose>
    <jsp:include page="/views/tweetView.jsp"/>
<jsp:include page="/views/footer.jsp" />
