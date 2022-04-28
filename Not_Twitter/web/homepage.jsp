
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/views/header.jsp" />
<body>
    <jsp:include page="/views/sidebar.jsp" />
    <%-- c:choose> --%><
       <%-- <c:when test="${logged_in == true}"> --%> 
            <jsp:include page="/views/make_tweet.jsp" />
       <%--</c:when>  --%> 
   <%--</c:choose>  --%> 
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
    <br>
    <%--This is for posting tweets  --%>
    <div class="makeTweet">
        <div class="search-container">
        <textarea id="postTweet" name="search" placeholder="Whats on your mind" class="search-input"></textarea>
        <button class="button" type="submit">Tweet</button><br>
    </div>
        <button class="button" type="submit">Upload Photo</button><br>
    </div><br><br>
    
    <%--profiles  --%>
    <div class ="defaultProfile">
        <div class="flexContainer">
                <img src="assets/default.png" alt="alt"/>
                <p class="mid">Username</p>
                <button class="button" type="submit">Follow</button>  </div>   
                <hr>
                <p>User's tweets go here</p>
    </div>
    
    
    <%--Tweet views  --%>
    
    <div class="textTweet">
        <table class="textTable">
        <tr><textarea id="Tweet" name="search" placeholder="text"></textarea></tr>
        <td>date&time</td>
        <tr>
        <td>user</td>
        <td><button class="button" type="submit">like</button></td>
        <td><button class="button" type="submit">follow</button></td>
        </tr>
        </table>
    </div><br> <br>
    
    <div class="imgTweet">
        <%----%>
         <table class="textTable">
        <tr><img src="assets/der.jpg" alt="alt"/></tr>
        <td>date&time</td>
        <tr>
        <td>user</td>
        <td><button class="button" type="submit">like</button></td>
        <td><button class="button" type="submit">follow</button></td>
        </tr>
        </table>
    </div>
        <br> <br>
        
        <%-- User Profile --%>
          <div class ="userProfile">
                <img src="assets/default.png" alt="alt"/>
                <p class="mid">Username</p>
                <button class="button" type="submit">Log Out</button>
          </div>
    
<jsp:include page="/views/footer.jsp" />


<jsp:include page="/views/footer.jsp" />