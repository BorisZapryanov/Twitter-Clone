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
            <li>
                <form action="Not_Twitter" method="post">
                    <input type="hidden" id="action" name="action" value="Home"/>
               
                    <button class="navbutton" type="submit">Home</button>
                
                </form>
            </li>
            <li>
                <form action="Not_Twitter" method="post">
                    <input type="hidden" id="action" name="action" value="Explore"/>

                    <button class="navbutton" type="submit">Explore</button>
                </form>
            </li>
            <li>
                <form action="Not_Twitter" method="post">
                    <input type="hidden" id="action" name="action" value="All_Users"/>
                
                    <button class="navbutton" type="submit">All Users</button>
                
                </form>  
            </li>
  <!-- check if user is logged in or not
  -->
            <c:choose>
                <c:when test="${logged_in == true}">
                 <%-- User Profile --%>
                    <li>
                       <div >
                           <c:choose>
                               <c:when test="${hasImage == true}">
                                   <img src="RequestImage?userName=${username}" width ="100" height="100" alt ="alt"/>
                               </c:when>
                               <c:otherwise>
                                   <img src="assets/default.png" alt="alt"/>
                               </c:otherwise>
                           </c:choose>
                           
                           
                           <p >${username}</p>
                       <form action="UploadImage" method="post" enctype="multipart/form-data">
                           
                                   
                                    <input type="file" accept="image/*" name="file">
                                    <button type="submit" >Upload</button>                                        
                                   
                               
                       </form>
                                
                       <form action="Not_Twitter" method="post">
                           <input type="hidden" id="action" name="action" value="Logout"/>
                           <button class="button" type="submit">Logout</button>
                       </form>
                       </div>
                   </li>
                </c:when>
                <c:otherwise> 
                    <li>
                        <form action="Not_Twitter" method="post">
                            <input type="hidden" id="action" name="action" value="Login"/>
                            <button class="navbutton" type="submit">Login</button>
                        </form>  
                    </li>     
                </c:otherwise> 
            </c:choose>
        </ul>
    </div>     
</div>
