/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda1;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 *
 * @author Daniel
 */
public class MapRangeExample {
    public static void execute(){
        int[] intArray = {2,5,10,25,4,8};
        double result = IntStream.of(intArray)
                .asDoubleStream()
                .sorted()
                .map(new DoubleUnaryOperator() {
                    @Override
                    public double applyAsDouble(double operand) {
                        return operand*10;
                    }
                })
                .distinct()
                .reduce(0, new DoubleBinaryOperator() {
                    @Override
                    public double applyAsDouble(double left, double right) {
                        return left+right*5;
                    }
                });
        
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        DoubleStream.of(result).forEach(x->System.out.println("["+numberFormat.format(x)+"]"));
        
        result = IntStream.of(intArray).asDoubleStream().sorted().map(x->x*10).distinct().reduce(0, (x,y)->(x+y*5));
        
        DoubleStream.of(result).forEach(x->System.out.println("["+numberFormat.format(x)+"]"));
        
        System.out.println("RangeClosed: "+numberFormat.format(IntStream.rangeClosed(1, 10).asDoubleStream().reduce(1, (x,y)->x+y*10))+".");
    }
}
