/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication20;

import java.util.Comparator;

/**
 *
 * @author Daniel
 */
public class ClientComparator implements Comparator<Client>{

    @Override
    public int compare(Client c1, Client c2) {
        if(c1.getCpf().equals(c2.getCpf())){
            return 0;
        } else if(c1.getCpf()>c2.getCpf()){
            return 1;
        } else{
            return -1;
        }
    }
}
