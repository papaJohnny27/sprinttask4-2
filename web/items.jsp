<%@ page import="java.util.List" %>
<%@ page import="domain.Item" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: eldos
  Date: 21.09.2023
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Items</title>
    <%@ include file="/import/frontend-libs.jsp"%>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">BITLAB SHOP</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">TOP SALES</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">NEW SALES</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">BY CATEGORY</a>
                </li>
            </ul>
            <span class="navbar-text">
        SIGN IN
      </span>
        </div>
    </div>
</nav>
    <div class="container">
       <div class="row">
           <%
               List<Item> items = (List<Item>) request.getAttribute("items");
               for (Item item : items){

           %>
               <div class="col-sm-6 mb-3 mb-sm-0 mt-5">
                   <div class="card">
                       <div class="card-body">
                           <h5 class="card-title"><%=item.getName()%></h5>
                           <h6 class="card-subtitle">$<%=item.getPrice()%></h6>
                           <p class="card-text">ID: <%=item.getId()%><br><%=item.getDescription()%></p>
                           <a href="#" class="btn btn-primary">Go somewhere</a>
                       </div>
                   </div>
               </div>


           <%
               }
           %>
       </div>
    </div>
</body>
</html>
