package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Rio;

public class Serv extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int RIO_ARRAY_LENGTH=Integer.valueOf(request.getParameter("rioSize"));
        double RIO_ARRAY_PERCENT_NOT_NULL=Double.valueOf(request.getParameter("propNotNull"));
        Rio rio;
        System.out.println("------------Instanciando--Rio:------------");
        rio = new Rio(RIO_ARRAY_LENGTH);
        System.out.println("Rio instanciado!");
        System.out.println("-------------Populando--Rio:--------------");
        rio.popularRio(RIO_ARRAY_PERCENT_NOT_NULL);
        System.out.println("Rio populado!");
        System.out.println("---------Iniciando--Movimentação:---------");
        rio.iniciarMovimentacaoDeElementos();
        System.out.println("------------------------------------------");
        System.out.println("--------------------FIM-------------------");
        System.out.println("");
        System.out.println("Histórico de arranjos do array rio a cada ciclo de movimentação do conjunto de seus elementos:");
        System.out.println("******************************************");
        rio.getSaidaRioArray().stream().forEach(System.out::println);
        System.out.println("******************************************");
        System.out.println("");
        
        request.setAttribute("saidaRioArray", rio.getSaidaRioArray());
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
