<%-- 
    Document   : make_tweet
    Created on : Apr 26, 2022, 7:44:27 PM
    Author     : bgebo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="makeTweet">
       
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
                            <button class="button" type="submit">Upload Photo</button><br/>
                        </td>
                    </tr>
                </table>  
            </form>
       
    </div>
        <br/>