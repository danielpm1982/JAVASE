package Others;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {0,1,2,3,4,5,6,7,8,9};
        System.out.println("ParallelPrefix:");
        Arrays.parallelPrefix(array, (x,y)->x+y);
        Arrays.stream(array).forEach(x->System.out.print(x+" ")); System.out.println("");
        System.out.println("ParallelSort:");
        Arrays.parallelSort(array,Comparator.reverseOrder());
        Arrays.stream(array).forEach(x->System.out.print(x+" ")); System.out.println("");
        Arrays.parallelSort(array,Comparator.naturalOrder());
        Arrays.stream(array).forEach(x->System.out.print(x+" ")); System.out.println("");
        System.out.println("ParallelSetAll:");
        Arrays.parallelSetAll(array, x->x*10);
        Arrays.stream(array).forEach(x->System.out.print(x+" ")); System.out.println("");
        System.out.println("Streams Parallel:");
        Stream.of(array).parallel().map(x->x*10).collect(Collectors.toList()).stream().forEach(y->System.out.print(y+" "));
    }
}
