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
            p.p2{
                font-family: cursive;
                font-weight: 200;
                font-size: 0.7em;
                color: blanchedalmond;
            }
            p.p1{
                font-family: serif;
                font-weight: 500;
                font-size: 0.4em;
                border: 0.05em dashed aqua;
                width: 70%;
                margin: auto;
                padding: 0.5em 0.5em 0.5em 0.5em;
                margin-bottom: 1em;
                text-align: justify;
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
                margin-top: 3em;
                font-size: 0.5em;
                font-style: italic;
            }
        </style>
    </head>
    <body>
        <p class="p0">Histórico de arranjos do array rio:</p>
        <img id="image1" src="images/java.png" alt="javaImage">
        <img id="image2" src="images/uni7.jpg" alt="uni7Image">
        <img id="image3" src="images/duke.png" alt="dukeImage">
        <p class="p2">Rio Instanciado:</p>
        <p class="p1">${requestScope.saidaRioArray[0]}<br></p>
        <p class="p2">Rio Populado:</p>
        <p class="p1">${requestScope.saidaRioArray[1]}<br></p>
        <c:forEach items="${requestScope.saidaRioArray}" var="rio" begin="2" varStatus="index">
        <p class="p2">Após Ciclo ${pageScope.index.index-1}:</p>
            <p class="p1">${pageScope.rio}<br></p>
        </c:forEach>
        <p class="p2">Requisitos (adaptados):</p>
        <p class="p1">
            - modelagem de ecossistema em um array rio, com Urso, Peixe e null como elementos de interface Animal (a fim de se usar polimorfismo e ligação dinâmica na declaração da variável do animal em relação à instância específica (Urso ou Peixe) associada;<br>
            - o tamanho do array é fixo e pode ser definido no construtor do objeto rio pela classe cliente (neste caso o próprio servlet de controle), assim como a percentagem de posições a serem ocupadas, ou seja, não nulas após populagem (ocupadas por algum animal);<br>
            - para efeito de otimização, além do tamaho do array e da percentagem de posições não vazias pós-populagem, a proporção de ursos x peixes na populagem pode ser definida na própria classe rio (método popularRio()). Quanto mais peixes para cada urso, mais lento a execução do algoritmo, e dependendo do tamanho do array isso precisa ser otimizado;<br>
            - a cada intervalo de tempo, de duração não especificada, os elementos não nulos podem se mover ou não, aleatoriamente, para posição adjacente, no caso deste programa sempre à direita;<br>
            - a cada ciclo de movimento todos os animais do vetor ou se movem ou ficam onde estão, e é mostrado o resultado do ciclo inteiro, e não de cada movimento de cada animal;<br>
            - os animais são selecionados da esquerda para a direita, sequencialmente, para que se movam ou não se movam. Logo o resultado final do array, a cada final de ciclo, deve ser analisado da esquerda para a direita, não apenas quanto ao movimento em si mas quanto à seleção dos elementos antes do movimento a cada ciclo;<br>
            - para os casos de animais que se moverem (sempre para a direita), à esquerda (posição anterior) será atribuído null, porém, quando for mostrado o resultado do ciclo, provavelmente outro novo objeto já terá tomado este lugar (null), o que demanda atenção para uma análise correta da funcionalidade quanto ao que é mostrado a cada ciclo;<br>
            - há 3 casos relativos ao movimento;<br>
            - se a posição à direita do animal que for se mover estiver vazia (null), este animal simplesmente ocupa o espaço à direita e atribui null à posição anterior;<br>
            - se a posição à direita contiver um animal de mesmo tipo (classe), ambos permanecem onde estão e é gerado uma nova instância, de mesmo tipo, a ser adicionada em uma posição nula aleatória do array, aumentando em 1 elemento aquele tipo de animal dentro do vetor;<br>
            - neste segundo caso, para que não se torne o algoritmo demasiadamente lento, e para se evitar ciclos indefinidos, tenta-se adicionar o novo animal numa posição livre do vetor por no máximo 3 vezes (ou outro número definível), e, se nas 3 tentativas não houver posição livre, simplesmente não se adiciona e se descarta este novo elemento;<br>
            - já se a posição à direita contiver um animal de tipo diferente, há duas possibilidades: se o à esquerda for um urso, este comerá o peixe à direita, assumindo sua posição, e sendo atribuído null à posição à esquerda; já se o à esquerda for um peixe, este será comido pelo urso à direita, cujo efeito é simplesmente ser atribuído null à sua posição original, não alterando a posição à direita, nem o elemento desta;<br>
            - neste terceiro caso, ocorre uma diminuição de peixes e aumento de ursos no vetor, até que não haja mais peixes e o algoritmo finalize sob esta condição. Com todas ou quase todas as posições ocupadas por ursos, mas, eventualmente, com algumas ainda ocupadas por null.
        </p>
        <footer>
            Daniel Pinheiro Maia<br>
            Todos os direitos reservados ®<br>
            Pós-Graduação em Arquitetura de Sistemas para Internet
        </footer>
    </body>
</html>
