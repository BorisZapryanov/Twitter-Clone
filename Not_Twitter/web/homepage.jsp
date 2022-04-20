<%-- 
    Document   : homepage
    Created on : Apr 12, 2022, 1:39:59 PM
    Author     : icoza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/views/header.jsp" />
<body>
    <div class="search">
        <h1>Home</h1>
        <form action="/action_page.php">
      <input type="text" placeholder="Search.." name="search">
      <button type="submit">Submit</button>
    </form>
    </div>

<c:import url="/views/footer.jsp" />