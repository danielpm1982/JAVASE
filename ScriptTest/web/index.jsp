<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Javascript Test</title>
        <script>
            function valida(){
                var texto = document.forms.meuFormulario.texto;
                if(texto.value=='Digite seu nome'||texto.value==""){
                    texto.style.backgroundColor='#FF0000';
                    window.alert('Digite algo !!!!!!!!');
                    texto.focus();
                    return false;
                }
                else{
                    window.confirm('Olá '+texto.value+' !! Mensagem Enviada !!');
                    return true;
                }
            }
        </script>
    </head>
    <body>
        <form name="meuFormulario" action="result.jsp">
            <input type="text" id="texto" name="texto" value="Digite seu nome" onmousemove="this.style.backgroundColor='#b0e2ff'" onmouseout="this.style.backgroundColor='#ffffff'"/>
            <br><br>
            <textarea cols="30" rows="10" name="textoArea"></textarea>
            <br><br>
            <input type="submit" value="OK" onclick="return valida()"/>
        </form>
    </body>
</html>