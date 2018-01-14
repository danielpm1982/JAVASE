/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda1;

import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 *
 * @author Daniel
 */
public class ForEachExample {
    
    public static void execute(){
        /*Using interface IntStream static method "of" to obtain a Stream from the data source (int x=100), 
        modifying this value to another Stream using the IntStream overridden instance method map (intermediate operation that expects to receive an object
        of IntUnaryOperator interface type through anonynous class declaration or equivalent lambda expression), and, then, using IntStream overridden instance 
        method forEach to execute an action (terminal operation) over the later Stream data, also receiving, as a parameter, an object of a class that 
        implements a specific functional interface, in the case of "forEach" an IntConsumer interface.
        Every Stream operation takes, as parameter, a functional interface with a single abstract method (SAM) to be implemented directly, using inner classes,
        or undirectly, through lambda expressions.
        The instantiation of the object may be through anonymous inner nested classes, or, more conveniently, by using an equivalent lambda expression, whose
        variable type is inferred from the type of the anonymous object class declared or expected according to the operation parameter type.
        */
        
        //intermediate and terminal operations over expected object types using anonymous inner classes declarations
        IntStream.of(100).
            map(new IntUnaryOperator() {
                @Override
                public int applyAsInt(int operand) {
                    return (operand+=100);
                }
            }).
            forEach(new IntConsumer() {
                @Override
                public void accept(int value) {
                    System.out.println("X = "+value+".");
                }
            });
        
        //terinal operation over an object using 
        IntStream.of(100).map((int value)->{return value+=100;}).forEach(value->System.out.println("X = "+value));
        
        //or
        IntStream.of(100).map(value->value+=100).forEach(value->System.out.println("X = "+value));
    }
}
