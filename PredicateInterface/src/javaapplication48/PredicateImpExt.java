/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication48;

import java.util.function.Predicate;

/**
 *
 * @author Daniel
 */
public class PredicateImpExt implements Predicate<String>{
    @Override
    public boolean test(String t) {
        return t.startsWith((t.toUpperCase()).substring(0, 1));
    }
}
