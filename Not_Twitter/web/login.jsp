<%-- 
    Document   : login
    Created on : Apr 26, 2022, 7:41:43 PM
    Author     : bgebo

    pop up login/register window
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/views/header.jsp" />
<div class ="search">
    <jsp:include page="/views/sidebar.jsp" />
        <h2>Login</h2>
        <form action="Login" method="post">
            <label for="username/email">Username/Email</label>
            <input type="text" id="username/email" name="username_email" required/><br/>
            <label for="password1">Password</label>
            <input type="password" id="password1" name="password" required/><br/>
            
            <input type="hidden" name="action" value="Login"/>

            <input type="submit" value="Login"/>
        </form>
        <h2>Register New Account</h2>
        <form action="Login" method="post">
            <label>Username</label>
            <input type="text" id="username" name="username" required/><br/>
            <label for="email">Email</label>
            <input type="email" id="email" name="email" required/><br/>
            <label for="password2">Password</label>
            <input type="password" id="password2" name="password" required/><br>
           
            <input type="hidden" name="action" value="Make_New"/>

            <input type="submit" value="Make_New"/>
        </form>
</div>
<jsp:include page="/views/footer.jsp" />
