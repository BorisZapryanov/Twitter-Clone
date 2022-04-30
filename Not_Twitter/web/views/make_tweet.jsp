<%-- 
    Document   : make_tweet
    Created on : Apr 26, 2022, 7:44:27 PM
    Author     : bgebo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="makeTweet">
       
            <form action="Not_Twitter" method="post">
                <table >
                    <tr>
                        <td colspan="2">
                            <textarea id="postTweet" name="search" placeholder="Whats on your mind..." cols="30" rows="5" ></textarea>
                        </td>
                    </tr>
                    <tr>
                    
                        <td>
                            <input type="hidden" name="action" value="Tweet"/>
                             <button class="button" type="submit">Tweet</button>
                        </td>
                        <td>
                            
                        </td>
                    </tr>
                </table>  
            </form>
    <br/><!--  -->
       <form>
                <table>
                    <tr>
                        <td colspan="2">
                            <textarea id="postTweet" name="search" placeholder="Whats on your mind..." cols="30" rows="5" ></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>
                             <button class="button" type="submit">Tweet</button>
                        </td>
                        <td>
                            
                        </td>
                    </tr>
                </table>  
            </form>
    </div>
        <br/>