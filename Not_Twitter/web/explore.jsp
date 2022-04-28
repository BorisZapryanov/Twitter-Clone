
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/views/header.jsp" />
<body>
    <jsp:include page="/views/sidebar.jsp" />

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
    <br/>
    <%--This is for posting tweets  --%>
    <c:choose>
        <c:when test="${logged_in == true}">
             <jsp:include page="/views/make_tweet.jsp"/>
        </c:when>
    </c:choose>
    
    <c:forEach var="tweet" items="${allTweets}">
        <c:choose>
            <c:when test="${tweet.filename != null}">
                <div class="imgTweet">
                    <%----%>
                    <table class="textTable">
                        <tr>
                            <td colspan="4">
                                <img width="300" src="RequestImage?tweetID=${tweet.id}" alt="alt"/>
                            </td>
                        </tr>
                        <tr>

                            <td colspan="4">
                                <p class="tweetP">${tweet.text}</p>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">${tweet.timestamp}</td>
                        </tr>
                        <tr>
                            <td>user</td>
                            <td>
                                <form action="Not_Twitter">
                                    <input type ="hidden" name="page" id="page" value="explore.jsp"/>
                                    <input type="hidden" id="tweetId" name="tweetId" value="${tweet.id}"/>
                                    <input type="hidden" name="action" id="action" value="like"/>
                                    <button class="button" type="submit">like</button>
                                </form>
                            </td>
                            <td>
                                <form action="Not_Twitter">
                                    <input type ="hidden" name="page" id="page" value="explore.jsp"/>
                                    <input type="hidden" id="tweetId" name="tweetId" value="${tweet.userid}"/>
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
                                <p class="tweetP">${tweet.text}</p>
                            </td>
                        </tr>
                        <tr>    
                            <td colspan="4">
                                ${tweet.timestamp}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                user
                            </td>
                            <td>
                                <p>${likes}</p>
                            </td>
                            <td>
                                <form action="Not_Twitter">
                                    <input type ="hidden" name="page" id="page" value="explore.jsp"/>
                                    <input type="hidden" id="tweetId" name="tweetId" value="${tweet.id}"/>
                                    <input type="hidden" name="action" id="action" value="like"/>
                                    <button class="button" type="submit">like</button>
                                </form>
                                
                            </td>
                            <td>    
                                <form action="Not_Twitter">
                                    <input type ="hidden" name="page" id="page" value="explore.jsp"/>
                                    <input type="hidden" id="tweetId" name="tweetId" value="${tweet.userid}"/>
                                    <input type="hidden" name="action" id="action" value="follow"/>
                                    <button class="button" type="submit">follow</button>
                                </form>
                                
                            </td>
                        </tr>
                    </table>
                </div>
                            <br/>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    
    

<jsp:include page="/views/footer.jsp" />
