/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.math.BigInteger;
/**
 *
 * @author Daniel
 */
public class Recursion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BigInteger fatorial = Fatorial.calculateIteratively(new BigInteger("9999"));
            System.out.println(fatorial);
            System.out.println("Ordem de 1*10^"+(fatorial.toString().length()-1));
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        
        try {
            BigInteger fatorial = Fatorial.calculateRecursively(new BigInteger("0"));
            System.out.println(fatorial);
            System.out.println("Ordem de 1*10^"+(fatorial.toString().length()-1));
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        System.out.println("");
        
//        System.out.println("\nFibonacci 20 = "+Fibonacci.calculateRecursively(new BigInteger("20"))+".\n");
    }
}
