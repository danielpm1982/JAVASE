package javaapplication59;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaApplication59 {
    public static void main(String[] args) throws InterruptedException {
        int[] arrayInt1 = {1,2,3,4,5,6,7,8,9};
        Integer[] array1 = Arrays.stream(arrayInt1).boxed().toArray(Integer[]::new);
        //Integer[] array1 = Arrays.stream(arrayInt1).boxed().toArray(size->new Integer[size]);
        List<Integer> list = new ArrayList<>(Arrays.asList(array1));
        list=list.subList(0, 5);
        Integer[] array2 = list.toArray(new Integer[0]);
        int[] arrayInt2 = Arrays.stream(array2).mapToInt(Integer::intValue).toArray();
        //int[] arrayInt2 = Arrays.stream(array2).mapToInt(x->x.intValue()).toArray();
        
        System.out.println("int array1:");
        Arrays.stream(arrayInt1).forEach(System.out::print); System.out.println("");
        System.out.println("Integer array1:");
        Arrays.stream(array1).forEach(System.out::print); System.out.println("");
        System.out.println("Integer array2:");
        Arrays.stream(array2).forEach(System.out::print); System.out.println("");
        System.out.println("int array2:");
        Arrays.stream(arrayInt2).forEach(System.out::print); System.out.println("");
    }
}
