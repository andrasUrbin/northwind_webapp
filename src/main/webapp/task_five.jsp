<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Northwind Webapp</title>
</head>

<body>

<div class="wrapper">
    <div class="container">

        <h3>Task Five Results</h3>
        <form action="TaskFiveServlet" method="POST">
            <p>Enter a company name: </p>
            <input type="text" name="company">
            <br>
            <input type="submit" value="Filter results">
        </form>

         <table>
         <tr>
         <th>Company</th>
         <th>Product name</th>
         <th>Unit Price</th>
         <c:forEach var="item" items="${data}">
         <tr>
         <td>${item.getCompanyName()}</td>
         <td>${item.getProductName()}</td>
         <td>${item.getUnitPrice()}</td>

         </tr>
         </c:forEach>
         </table>
    </div>
    <a href="index.html">Back to the main menu!</a>

</div>
</body>
</html>
