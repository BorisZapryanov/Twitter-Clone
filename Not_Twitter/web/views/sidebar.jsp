<%-- 
    Document   : sidebar
    Created on : Apr 26, 2022, 6:20:30 PM
    Author     : bgebo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="sidenav">
    <!-- Send request to the main controller -->
    <form action="Not_Twitter" method="post">
        <input type="hidden" id="action" name="action" value="Home"/>
        <button type="submit">Home</button>
    </form>
  <form action="Not_Twitter" method="post">
        <input type="hidden" id="action" name="action" value="Explore"/>
        <button type="submit">Explore</button>
  </form>
  <form action="Not_Twitter" method="post">
        <input type="hidden" id="action" name="action" value="All_Users"/>
        <button type="submit">All Users</button>
  </form>
  <br/>
  <!-- check if user is logged in or not
       
  
  -->
  <c:choose>
      <c:when test="${logged_in == true}">
        <form action="Not_Twitter" method="post">
            <input type="hidden" id="action" name="action" value="Logout"/>
            <button type="submit">Logout</button>
        </form>
      </c:when>
      <c:otherwise> 
        <form action="Not_Twitter" method="post">
            <input type="hidden" id="action" name="action" value="Login"/>
            <button type="submit">Login</button>
        </form>
    </c:otherwise> 
  </c:choose>
  <div>User thing</div>
</div>
