/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import jdk.nashorn.internal.runtime.Version;
import sun.misc.JavaAWTAccess;

/**
 *
 * @author Daniel
 */
public class JavaApplication20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Client client1 = new Client("Daniel", "009");
        Client client2 = new Client("Juliana", "015");
        Client client3 = new Client("Bosco", "060");
        Client client4 = new Client("Tina", "150");
        Client client5 = new Client("Eneida", "000");
        Client client6 = new Client("Daniel", "010");
        Client client7 = new Client("Juliana", "014");
        Client client8 = new Client("Bosco", "059");
        Client client9 = new Client("Tina", "151");
        Client client10 = new Client("Eneida", "000");
        Client[] arrayClient = {client1, client2, client3, client4, client5, client6, client7, client8, client9, client10};
        List<Client> list = new ArrayList<>();
        list.addAll(Arrays.asList(arrayClient));
        printListClient(list); //unordered list
        Collections.sort(list);
        printListClient(list); //Comparable ordered list (name)
        Collections.sort(list,new ClientComparator());
        printListClient(list); //Comparator ordered list (cpf) (ignores Comparable!!)
    }
    private static void printListClient(List<Client> list){
        Iterator<Client> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"\t");
        }
        System.out.println("");
    }
}
