<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Olá <%=request.getParameter("texto")%> !</h1>
        <h1>
            <p>Você escreveu:</p>
            <textarea><%=request.getParameter("textoArea")%></textarea>
        </h1>
    </body>
</html>
