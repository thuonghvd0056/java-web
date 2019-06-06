<%@ page import="entity.Product" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: hathu
  Date: 2019-06-04
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("list");
%>
<html>
<head>
    <title>List prduct</title>
</head>
<body>
<h1>List Prduct</h1>
<ul>
    <% for(int i = 0; i < list.size(); i++){%>
    <li><%= list.get(i).getId()%> - <%= list.get(i).getPrice()%> - <%= list.get(i).getFrame()%></li>
    <%}%>
</ul>
</body>
</html>
