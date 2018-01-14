package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Polinomio;

public class Serv extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Double c1=null, c2=null, c3=null, c4=null, c5=null;
        
        c1 = Double.valueOf(request.getParameter("coeficiente1"));
        if(checkParameterExists("coeficiente2", request)){
            c2 = Double.valueOf(request.getParameter("coeficiente2"));
        }
        if(checkParameterExists("coeficiente3", request)){
            c3 = Double.valueOf(request.getParameter("coeficiente3"));
        }
        if(checkParameterExists("coeficiente4", request)){
            c4 = Double.valueOf(request.getParameter("coeficiente4"));
        }
        if(checkParameterExists("coeficiente5", request)){
            c5 = Double.valueOf(request.getParameter("coeficiente5"));
        }
        
        if(c5!=null){
            Polinomio p = new Polinomio(c1,c2,c3,c4,c5);
            String polinomio = p.getPolinomio();
            String primeiraDerivada = p.getPolinomioPrimeiraDerivada();
            String segundaDerivada = p.getPolinomioSegundaDerivada();
            String terceiraDerivada = p.getPolinomioTerceiraDerivada();
        
            request.setAttribute("polinomio", polinomio);
            request.setAttribute("primeiraDerivada", primeiraDerivada);
            request.setAttribute("segundaDerivada", segundaDerivada);
            request.setAttribute("terceiraDerivada", terceiraDerivada);
        } else if(c4!=null){
            Polinomio p = new Polinomio(c1,c2,c3,c4);
            String polinomio = p.getPolinomio();
            String primeiraDerivada = p.getPolinomioPrimeiraDerivada();
            String segundaDerivada = p.getPolinomioSegundaDerivada();
        
            request.setAttribute("polinomio", polinomio);
            request.setAttribute("primeiraDerivada", primeiraDerivada);
            request.setAttribute("segundaDerivada", segundaDerivada);
        } else if(c3!=null){
            Polinomio p = new Polinomio(c1,c2,c3);
            String polinomio = p.getPolinomio();
            String primeiraDerivada = p.getPolinomioPrimeiraDerivada();
        
            request.setAttribute("polinomio", polinomio);
            request.setAttribute("primeiraDerivada", primeiraDerivada);
        } else if(c2!=null){
            Polinomio p = new Polinomio(c1,c2);
            String polinomio = p.getPolinomio();
            String primeiraDerivada = p.getPolinomioPrimeiraDerivada();
        
            request.setAttribute("polinomio", polinomio);
            request.setAttribute("primeiraDerivada", primeiraDerivada);
        } else if(c1!=null){
            request.setAttribute("polinomio", c1);
            request.setAttribute("primeiraDerivada", "0.0");
        }
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
    
    public static boolean checkParameterExists(String parameterName, HttpServletRequest request){
        return request.getParameterMap().containsKey(parameterName);
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
