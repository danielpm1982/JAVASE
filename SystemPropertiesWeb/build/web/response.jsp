<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                background-color: black;
                color: white;
                margin: 3em;
                text-align: center;
            }
            div.table{
                width: 90%;
                margin: auto;
                margin-top: 3em;
                margin-bottom: 5em;
                display: table;
                font-size: 0.8em;
                border: dashed bisque medium;
                padding: 1em;
            }
            div.row{
                display: table-row;
            }
            div.cell1, div.cell2{
                display: table-cell;
            }
            div.cell1{
                text-align: right;
                color: bisque;
                padding-right: 0.5em;
            }
            div.cell2{
                text-align: left;
                color: aquamarine;
                padding-left: 0.5em;
            }
        </style>
    </head>
    <body>
        <h1>Netbeans System.properties:</h1>
        <div class="table">
            <c:forEach var="item" items="${requestScope.propMap}" varStatus="count">
                <div class="row">
                    <div class="cell1">${item.key}</div>
                    <div class="cell2">${item.value}</div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
