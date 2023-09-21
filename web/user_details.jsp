<%@ page import="domain.user.User" %><%--
  Created by IntelliJ IDEA.
  User: eldos
  Date: 21.09.2023
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) request.getAttribute("userDetails");
%>
<html>
<head>
    <title>User Details</title>
    <%@ include file="/import/frontend-libs.jsp"%>
</head>
<body>
    <div class="container">
        <div class="row mt-5">
            <h3 class="display-1">Hello,<%=user.getFullName()%></h3>
        </div>
    </div>
</body>
</html>
