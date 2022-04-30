<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <div class="search">
        <%-- This is the header  --%>
        <img src="assets/output-onlinepngtools.png" alt="alt">
        
        <form action="Not_Twitter" method="post">
            <div class="search-container">
                <input class="search-input" type="text" placeholder="Search.." name="search" required>
                <input type="hidden" name="action" value="User"/>
            </div>
            <button class="button" type="submit">Submit</button><br>
        </form> 
        
</div>
