<%-- 
    Document   : sidebar
    Created on : Apr 26, 2022, 6:20:30 PM
    Author     : bgebo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="sidenav">
    <!-- Send request to the main controller -->
    <div class="menu">
    <ul>
    <form action="Not_Twitter" method="post">
        <input type="hidden" id="action" name="action" value="Home"/>
        <li><button class="navbutton" type="submit">Home</button></li>
    </form>
  <form action="Not_Twitter" method="post">
        <input type="hidden" id="action" name="action" value="Explore"/>
        <li><button class="navbutton" type="submit">Explore</button></li>
  </form>
  <form action="Not_Twitter" method="post">
        <input type="hidden" id="action" name="action" value="All_Users"/>
        <li><button class="navbutton" type="submit">All Users</button></li>
  </form>
    
    
  
  <!-- check if user is logged in or not
       
  
  -->
  <c:choose>
      <c:when test="${logged_in == true}">
          <%-- User Profile --%>
           <div class ="userProfile">
                <img src="assets/default.png" alt="alt"/>
                <p class="mid">Username</p>
                <button class="button" type="submit">Log Out</button>
          </div>
          
          
        <form action="Not_Twitter" method="post">
            <input type="hidden" id="action" name="action" value="Logout"/>
            <li><button class="navbutton" type="submit">Logout</button></li>
        </form>
      </c:when>
      <c:otherwise> 
        <form action="Not_Twitter" method="post">
            <input type="hidden" id="action" name="action" value="Login"/>
            <li><button class="navbutton" type="submit">Login</button></li>
        </form></ul></div>
        
        
        
        
          
        
    </c:otherwise> 
  </c:choose>
        
</div>
