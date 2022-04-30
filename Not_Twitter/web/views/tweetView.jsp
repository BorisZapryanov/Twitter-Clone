<%-- 
    Document   : tweetView
    Created on : Apr 29, 2022, 9:15:31 PM
    Author     : bgebo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:forEach var="tweet" items="${allTweets}">
        <c:choose>
            <c:when test="${tweet.getFilename() != null}">
                <div class="imgTweet">
                    <%----%>
                    <table class="textTable">
                        <tr>
                            <td colspan="4">
                                <img width="300" src="RequestImage?tweetID=${tweet.getId()}" alt="alt"/>
                            </td>
                        </tr>
                        <tr>

                            <td colspan="4">
                                <p class="tweetP">${tweet.getText()}</p>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">${tweet.getTimestamp()}</td>
                        </tr>
                        <tr>
                            <td>user</td>
                            <td>
                                <form action="Not_Twitter">
                                    <input type ="hidden" name="page" id="page" value="explore.jsp"/>
                                    <input type="hidden" id="tweetId" name="tweetId" value="${tweet.getId()}"/>
                                    <input type="hidden" id="username" name="username" value="${username}"/>
                                    <input type="hidden" name="action" id="action" value="Like"/>
                                    <button class="button" type="submit">like</button>
                                </form>
                            </td>
                            <td>
                                <form action="Not_Twitter">
                                    <input type ="hidden" name="page" id="page" value="explore.jsp"/>
                                    <input type="hidden" id="tweetId" name="tweetId" value="${tweet.getUserid()}"/>
                                    <input type="hidden" id="username" name="username" value="${username}"/>
                                    <input type="hidden" name="action" id="action" value="follow"/>
                                    <button class="button" type="submit">follow</button>
                                </form>
                            </td>
                        </tr>
                    </table>
                </div>
                        <br/>
            </c:when>
            <c:otherwise>
                <div class="textTweet">
                    <table class="textTable">
                        <tr>
                            <td colspan="4">
                                <p class="tweetP">${tweet.getText()}</p>
                            </td>
                        </tr>
                        <tr>    
                            <td colspan="4">
                                ${tweet.getTimestamp()}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                ${tweet.getUserName()}
                            </td>
                            <td>
                                <p>${tweet.getLikecount()}</p>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${tweet.isLikedbyuser()}">
                                        <form action="Not_Twitter">
                                            <input type ="hidden" name="page" id="page" value="explore.jsp"/>
                                            <input type="hidden" id="tweetId" name="tweetId" value="${tweet.getId()}"/>
                                            <input type="hidden" id="username" name="username" value="${username}"/>
                                            <input type="hidden" name="action" id="action" value="unLike"/>
                                            <button class="button" type="submit">Un-Like</button>
                                        </form>
                                    </c:when>
                                    <c:otherwise>
                                        <form action="Not_Twitter">
                                            <input type ="hidden" name="page" id="page" value="explore.jsp"/>
                                            <input type="hidden" id="tweetId" name="tweetId" value="${tweet.getId()}"/>
                                            <input type="hidden" id="username" name="username" value="${username}"/>
                                            <input type="hidden" name="action" id="action" value="Like"/>
                                            <button class="button" type="submit">like</button>
                                        </form>
                                    </c:otherwise>
                                </c:choose>
                                
                            </td>
                            <td>   
                                <c:choose>
                                    <c:when test="${tweet.isLikedbyuser()}">
                                        <form action="Not_Twitter">
                                            <input type ="hidden" name="page" id="page" value="explore.jsp"/>
                                            <input type="hidden" id="tweetId" name="tweetId" value="${tweet.getUserid()}"/>
                                            <input type="hidden" name="action" id="action" value="follow"/>
                                            <button class="button" type="submit">follow</button>
                                        </form>
                                    </c:when>
                                    <c:otherwise>
                                        <form action="Not_Twitter">
                                            <input type ="hidden" name="page" id="page" value="explore.jsp"/>
                                            <input type="hidden" id="tweetId" name="tweetId" value="${tweet.getUserid()}"/>
                                            <input type="hidden" name="action" id="action" value="follow"/>
                                            <button class="button" type="submit">follow</button>
                                        </form>
                                    </c:otherwise>
                                </c:choose>
                                   
                            </td>
                        </tr>
                    </table>
                </div>
                            <br/>
            </c:otherwise>
        </c:choose>
    </c:forEach>