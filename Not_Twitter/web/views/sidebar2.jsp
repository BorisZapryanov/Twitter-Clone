<%-- 
    Document   : sidebar2
    Created on : Apr 28, 2022, 9:22:11 AM
    Author     : icoza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
<%--profiles  --%>
    <div class ="defaultProfile">
        <div class="flexContainer">
            <img src="assets/default.png" alt="alt"/>
            <p class="mid">Username</p>
            <button class="button" type="submit">Follow</button>
        </div>   
    <hr>
    </div>
    <%--Tweet views  --%>
    <div class="textTweet">
        <table class="textTable">
            <tr>
                <td colspan="3">
                    <p class="tweetP">Sample Tweet</p>
                </td>
            </tr>
            <tr>    
                <td colspan="3">
                    date&time
                </td>
            </tr>
            <tr>
                <td>
                    user
                </td>
                <td>
                    <button class="button" type="submit">like</button>
                </td>
                <td>    
                    <button class="button" type="submit">follow</button>
                </td>
            </tr>
        </table>
    </div>
    <br/>
    <br/>
    
    <div class="imgTweet">
        <%----%>
        <table class="textTable">
            <tr>
                <td colspan="3">
                    <img width="300" src="assets/der.jpg" alt="alt"/>
                </td>
            </tr>
            <tr>
       
                <td colspan="3">
                    <p class="tweetP">Sample Tweet</p>
                </td>
            </tr>
            <tr>
                <td colspan="3">date&time</td>
            </tr>
            <tr>
                <td>user</td>
                <td>
                    <button class="button" type="submit">like</button>
                </td>
                <td>
                    <button class="button" type="submit">follow</button>
                </td>
            </tr>
        </table>
    </div>
    <br/>
    <br/>