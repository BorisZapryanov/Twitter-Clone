<%-- 
    Document   : user
    Created on : Apr 26, 2022, 7:42:36 PM
    Author     : bgebo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/views/header.jsp" />
<body>
    <jsp:include page="/views/sidebar.jsp" />
    <jsp:include page="/views/search.jsp"/>
    <div class ="defaultProfile">
        <div class="flexContainer">
            <c:choose>
                <c:when test="${displayUser.hasImage()}">
                    <img src="RequestImage?userName=${displayUser.getUsername()}" width ="100" height="100" alt ="alt"/>
                </c:when>
                <c:otherwise>
                    <img src="assets/default.png" alt="alt"/>
                </c:otherwise>
            </c:choose>
                    <p class="mid">${displayUser.getUsername()}</p>
            <c:choose>
                <c:when test="${displayUser.followedByUserTest()}">
                    <form action="Not_Twitter" method="post">
                        <input type="hidden" name="currentUser" value="${displayUser.getLoggedInUser()}"/>
                        <input type="hidden" name="folowee" value="${displayUser.getUsername()}"/>
                        <input type="hidden" name="action" value="unFollow"/>
                        <button class="button" type="submit">Unfollow</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <form action="Not_Twitter" method="post">
                        <input type="hidden" name="currentUser" value="${displayUser.getLoggedInUser()}"/>
                        <input type="hidden" name="folowee" value="${displayUser.getUsername()}"/>
                        <input type="hidden" name="action" value="follow"/>
                        <button class="button" type="submit">follow</button>
                   </form>
                </c:otherwise>
            </c:choose>
            
            
            
        </div>   
    <hr>
    </div>

 <jsp:include page="/views/tweetView.jsp"/>
    
    

<jsp:include page="/views/footer.jsp" />