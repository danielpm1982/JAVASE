<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Page</title>
        <style>
            body{
                color: blanchedalmond;
                background-color: black;
                text-align: center;
                font-size: 3em;
                margin-top: 1.5em;
                margin-bottom: 2em;
            }
            p.p1{
                font-family: serif;
                font-weight: 500;
                font-size: 0.9em;
                border: 0.05em dashed aqua;
                width: 70%;
                margin: auto;
                padding: 0.5em 0.5em 0.5em 0.5em;
                margin-bottom: 1em;
            }
            p.p0{
                font-family: serif;
                font-weight: 200;
                font-size: 1.2em;
                color: chartreuse;
                text-decoration-style: wavy;
                text-decoration-line: underline;
            }
            img#image1{
                width: 10%;
                position: fixed;
                left: 2%;
                bottom: 27%;
            }
            img#image2{
                width: 10%;
                position: fixed;
                right: 2%;
                bottom: 5.45%;
            }
            img#image3{
                width: 10%;
                position: fixed;
                left: 2%;
                bottom: 4%;
            }
            footer{
                font-size: 0.5em;
                font-style: italic;
            }
        </style>
    </head>
    <body>
        <p class="p0">Polinômio:</p>
        <img id="image1" src="images/java.png" alt="javaImage">
        <img id="image2" src="images/uni7.jpg" alt="uni7Image">
        <img id="image3" src="images/duke.png" alt="dukeImage">
        <p class="p1">${requestScope.polinomio}</p>
        <c:if test="${requestScope.primeiraDerivada!=null}">
            <p class="p0">Primeira Derivada:</p>
            <p class="p1">${requestScope.primeiraDerivada}</p>
        </c:if>
        <c:if test="${requestScope.segundaDerivada!=null}">
            <p class="p0">Segunda Derivada:</p>
            <p class="p1">${requestScope.segundaDerivada}</p>
        </c:if>
        <c:if test="${requestScope.terceiraDerivada!=null}">
            <p class="p0">Terceira Derivada:</p>
            <p class="p1">${requestScope.terceiraDerivada}</p>
        </c:if>
        <footer>
            Daniel Pinheiro Maia<br>
            Todos os direitos reservados ®<br>
            Pós-Graduação em Arquitetura de Sistemas para Internet
        </footer>
    </body>
</html>
