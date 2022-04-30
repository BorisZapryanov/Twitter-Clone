<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/views/header.jsp" />
<body>
    <jsp:include page="/views/sidebar.jsp" />

   <jsp:include page="/views/search.jsp"/>
    <br/>
    <div class="search">
        <h2>${Error}</h2><br><!--  -->
    <h2>${error}</h2>
    </div>
    
<jsp:include page="/views/footer.jsp" />