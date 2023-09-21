<%--
  Created by IntelliJ IDEA.
  User: eldos
  Date: 21.09.2023
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@ include file="/import/frontend-libs.jsp"%>
</head>
<body>
    <div class="container">
        <div class="row mt-5">
            <%if (request.getParameter("errorFlag")!=null && request.getParameter("errorFlag").equals("true")){%>

            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Incorrect email and password</strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
                <%
                    }
                %>
        </div>
        <div class="row mt-5">
            <form action="/login" method="post">
                <div class="form-group">
                    <label for="email_input">Email: </label>
                    <input type="text" id="email_input" class="form-control" name="email" required>
                </div>

                <div class="form-group">
                    <label for="password_input">Password: </label>
                    <input type="text" id="password_input" class="form-control" name="password" required>
                </div>

                <div class="form-control">
                    <button class="btn btn-success w-50" type="submit">LOGIN</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
