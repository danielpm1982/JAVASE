
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class StreamInterfaces {
    public static void main(String[] args) {
        
        //IntBinaryOperator functional interface
        @SuppressWarnings("Convert2Lambda")
        IntBinaryOperator t = new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left+right;
            }
        };
        
        int[] intArray = {0,1,2,3,4,5,6,7,8,9};
        IntStream.of(intArray).forEach(System.out::print);
        System.out.println("");
        System.out.println(IntStream.of(intArray).reduce(0, t));
        System.out.println(IntStream.of(intArray).reduce(0,Math::addExact));
        System.out.println(IntStream.of(intArray).reduce(Math::addExact).orElse(-1));
        
        //BinaryOperator<T> functional interface
        BinaryOperator<Integer> b1 = (Integer x, Integer y) -> {return x+y;};
        BinaryOperator<Integer> b2 = (x, y) -> Math.addExact(x, y);
        BinaryOperator<Integer> b3 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer t, Integer u) {
                return t+u;
            }
        };
        Integer[] integerArray = {0,1,2,3,4,5,6,7,8,9};
        Stream.of(integerArray).parallel().forEachOrdered(System.out::print); // if parallel, must use forEachOrdered to get in stream order.
        System.out.println("");
        Stream.of(integerArray).parallel().forEach(System.out::print); // if parallel, must use forEachOrdered to get in stream order.
        System.out.println("");
        System.out.println(Stream.of(integerArray).reduce(0, b1));
        System.out.println(Stream.of(integerArray).parallel().reduce(0, b2));
        System.out.println(Stream.of(integerArray).parallel().reduce(0, Math::addExact));
        System.out.println(Stream.of(integerArray).parallel().reduce(Math::addExact).orElse(-1));
        System.out.println(Stream.of(integerArray).parallel().reduce(0, b3));
        
        //IntConsumer functional interface
        IntConsumer intConsumer1 = x->System.out.print(x+" ");
        IntConsumer intConsumer2 = new IntConsumer() {
            @Override
            public void accept(int x) {
                System.out.print(x+" ");
            }
        };
        System.out.println(IntStream.of(intArray).summaryStatistics().toString());
        IntStream.of(intArray).forEach(intConsumer1);
        System.out.println("");
        IntStream.of(intArray).forEach(x -> System.out.print(x+" "));
        System.out.println("");
        
        //Consumer<Integer> functional interface
        Consumer<Integer> consumer1 = x->System.out.print(x+" ");
        Consumer consumer2 = new Consumer() {
            @Override
            public void accept(Object x) {
                System.out.print(x+" ");
            }
        };
        Stream.of(integerArray).forEachOrdered(consumer2);
        System.out.println("");
        Stream.of(integerArray).forEachOrdered(System.out::print);
        System.out.println("");        
        Stream.of(integerArray).forEachOrdered(x->System.out.print(x+" "));
        System.out.println("");        
        
        //IntFunction<Double> functional interface
        IntFunction <Double> intFunction1 = x->Double.valueOf(String.valueOf(x));
        IntToDoubleFunction intFunction2 = new IntToDoubleFunction() {
            @Override
            public double applyAsDouble(int x) {
                return (double)x;
            }
        };
        IntStream.of(intArray).mapToObj(intFunction1).forEach(x->System.out.print(x+" "));
        System.out.println("");
        IntStream.of(intArray).mapToDouble(intFunction2).forEach(x->System.out.print(x+" "));
        System.out.println("");
        
        //Function<Integer,Double> functional interface
        Function<Integer,Double> function1 = x->x.doubleValue();
        Function<Integer,Double> function2 = new Function<Integer, Double>() {
            @Override
            public Double apply(Integer x) {
                return (x.doubleValue());
            }
        };
        ToDoubleFunction<Integer> function3 = new ToDoubleFunction<Integer>() {
            @Override
            public double applyAsDouble(Integer x) {
                return x.doubleValue();
            }
        };
        Stream.of(integerArray).map(function1).forEach(x->System.out.print(x+" "));
        System.out.println("");
        Stream.of(integerArray).map(Integer::doubleValue).forEach(System.out::print);
        System.out.println("");
        Stream.of(integerArray).map(function2).forEach(x->System.out.print(x+" "));
        System.out.println("");
        Stream.of(integerArray).mapToDouble(function3).forEach(x->System.out.print(x+" "));
        System.out.println("");
        
        //IntUnaryOperator functional interface
        IntUnaryOperator intUnaryOperator1 = x->x*=100;
        DoubleUnaryOperator doubleUnaryOperator2 = new DoubleUnaryOperator() {
            @Override
            public double applyAsDouble(double x) {
                return 100*x;
            }
        };
        IntStream.of(intArray).map(intUnaryOperator1).forEach(x->System.out.print(x+" "));
        System.out.println("");
        IntStream.of(intArray).mapToObj(Integer::toString).mapToDouble(Double::valueOf).map(doubleUnaryOperator2).forEach(x->System.out.print(x+" "));
        System.out.println("");
        
        //UnaryOperator functional interface
        UnaryOperator<Integer> unaryOperator2 = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer x) {
                return 100*x;
            }
        };
        Stream.of(integerArray).map(unaryOperator2).forEach(x->System.out.print(x+" "));
        System.out.println("");
        Stream.of(integerArray).map(Function.identity()).forEach(x->System.out.print(x+" "));
        System.out.println("");
        
        //IntSupplier functional interface
        IntSupplier intSupplier = new IntSupplier() {
            @Override
            public int getAsInt() {
                SecureRandom random = new SecureRandom();
                return random.nextInt(10000000);
            }
        };
        int[] intVector=new int[100];
        for (int i=0;i<100;i++){
            intVector[i]=intSupplier.getAsInt();
        }
        IntStream.of(intVector).forEach(x->System.out.print(x+" "));
        System.out.println("");
        
        //Supplier functional interface
        Supplier<String> stringSupplier = new Supplier<String>() {
            @Override
            public String get() {
                SecureRandom random = new SecureRandom();
                return "Nothing"+random.nextInt(10000000);
            }
        };
        String[] stringVector = new String[100];
        for (int i=0;i<100;i++){
            stringVector[i]=stringSupplier.get();
        }
        Stream.of(stringVector).forEach(x->System.out.print(x+" "));
        System.out.println("");
        
        //intPredicate functional interface
        IntPredicate intPredicateBissexto = new IntPredicate() {
            @Override
            public boolean test(int x) {
                if(x%400==0){
                    return true;
                } else if(x%4==0&&x%100!=0){
                    return true;
                } else{
                    return false;
                }
            }
        };
        int[] intYear=new int[100];
        for (int i=0;i<100;i++){
            intYear[i]=intSupplier.getAsInt();
        }
        IntStream.of(intYear).forEach(x->System.out.print(x+" "));
        System.out.println("");
        System.out.println(IntStream.of(intYear).allMatch(intPredicateBissexto)?"All leap years!":"Not All are leap years!");
        System.out.println(IntStream.of(intYear).anyMatch(intPredicateBissexto)?"There are leap years!":"There are not leap years!");
        System.out.println(IntStream.of(intYear).noneMatch(intPredicateBissexto)?"There are NO leap years!":"There ARE leap years!");
        System.out.println("There are "+IntStream.of(intYear).filter(intPredicateBissexto).count()+" Leap years from the int vector. They are:");
        IntStream.of(intYear).filter(intPredicateBissexto).sorted().forEach(x->System.out.print(x+" "));
        System.out.println("");
        
        //Predicate functional interface
        Predicate<String> predicateString = x->{
            for (EnumFamilyThatLivesTogether enumX:EnumFamilyThatLivesTogether.values()){
                if(x.equals(enumX.toString())){
                    return true;
                }
            }
            return false;
        };
        String[] names = {"Daniel","Juliana","Filipe","Tina","Bosco","Andre","Rita","Julia","Gabriel"};
        Stream.of(names).forEach(z->System.out.print(z+" "));
        System.out.println("");
        System.out.println(Stream.of(names).map(x->x.toUpperCase()).filter(predicateString).count()+" persons live together:");
        Stream.of(names).map(x->x.toUpperCase()).filter(predicateString).forEach(y->System.out.print(y+" "));
        System.out.println("");
        
        Predicate<String> predicateDaniel = x->x.toUpperCase().equals("DANIEL");
        Predicate<String> predicateTina = x->x.toUpperCase().equals("TINA");
        Predicate<String> predicateBosco = x->x.toUpperCase().equals("BOSCO");
        Predicate<String> predicateJuliana = x->x.toUpperCase().equals("JULIANA");
        Predicate<String> predicateAll = predicateDaniel.or(predicateTina.or(predicateBosco.or(predicateJuliana)));
        Predicate<String> predicateBeginsWithUpperCase = x->beginsWithUpperCase(x);
        Predicate<String> predicateBeginsWithUpperCase2 = x->Character.isUpperCase(x.charAt(0));
        String[] namesAll = {"Daniel", "juliana", "tinA", "BOSCO"};
        System.out.println(Stream.of(namesAll).allMatch(predicateAll)?"Yeah, all match composed predicate!":"Not all match composed predicate!");
        Stream.of(namesAll).filter(predicateBeginsWithUpperCase.and(predicateBosco.negate())).forEach(System.out::println);
        Stream.of(namesAll).filter(predicateBeginsWithUpperCase2.negate()).forEach(System.out::println);
        
        // Ordering Examples: using Person Instance Nested Inner Local class to be used at Function interface in order to create Comparator and sort the Stream.
        //Stream sorted method without a Comparator would use the natural order, defined by the compareTo method of Comparable interface.
        
        Function<Person,Integer> compareNameLength = Person::getNameLength;
        Function<Person,Character> compareCharAtZero = Person::getFirstLetter;
        Function<Person,Boolean> compareCharAtZeroUpperCase = Person::isFirstLetterUpperCase;
        
        Comparator<Person> comparatorPerson = Comparator.comparing(compareNameLength).thenComparing(compareCharAtZero).thenComparing(compareCharAtZeroUpperCase);
        
        Person[] personArray = {new Person("daniel@"),new Person("Juliana"),new Person("Tina"),new Person("bosco"),new Person("luke")};
        Stream.of(personArray).sorted(comparatorPerson).forEach(System.out::print);
        System.out.println("");
        
        //collect and Collectors
        
        //Creating a List of Person objects with collect(Collectors.toList) and then obtaining a stream of the List to print
        Stream.of(personArray).sorted().collect(Collectors.toList()).stream().forEach(x->System.out.print(x+" "));
        System.out.println("");
        
        /*Creating a Map<Integer,List<Person>> composed by Intenger getNameLength() key values and a List of Person objects (grouped by each key value) 
        with collect(Collectors.groupingBy(Function<Person,Integer>)) and then printing by a BiConsumer<Integer,List<Person>> forEach from 
        the Map interface. The Map forEach, with a BiConsumer two-parameters argument, IS NOT the same Stream forEach with a Consumer one-parameter argument.
        There seems to be no way of obtaining a Stream from a Map (with a key/List value pair, in this case), as there would be with a List ou Set collection.*/
        Map<Integer,List<Person>> mapPerson = Stream.of(personArray).collect(Collectors.groupingBy(Person::getNameLength));
        mapPerson.forEach((a,b)->{
            System.out.print("With "+a+" letters: ");
            b.stream().forEach(x->System.out.print(x+" "));
            System.out.println("");
        });
        
        //As there is no way of obtaining a Stream from a Map, the map can be turned into a Set, and the single Entry components of the Set iterated.
        System.out.println("");
        mapPerson.entrySet().stream().forEach(entry->{
            System.out.print("With "+entry.getKey()+" letters: ");
            entry.getValue().forEach(x->System.out.print(x+" "));
            System.out.println("");
        });
        
        //or take a Set of only the keys and then take the values through each key from the Map.
        System.out.println("");
        Set<Integer> keys = mapPerson.keySet();
        for(Integer i:keys){
            System.out.print("With "+i+" letters: ");
            mapPerson.get(i).stream().forEach(x->System.out.print(x+" "));
            System.out.println("");
        }
        
        /*Creating a Map<Integer,Long> composed by Intenger getNameLength() key values and a count() for each List of Person objects 
        (grouped by each key value) with collect(Collectors.groupingBy(Function<Person,Integer>),Collectors.count()) and then printing by a 
        BiConsumer<Integer,Long> forEach from the Map interface.*/
        Map<Integer,Long> mapCount = Stream.of(personArray).collect(Collectors.groupingBy(Person::getNameLength,Collectors.counting()));
        mapCount.forEach((x,y)->{
            System.out.print(x+" letters: "+y+" names.\n");
        });
        
        //Example of using Collectors.groupingBy with 3 arguments: Function classifier to return keys of the Map; 
        //a Supplier to return a new Map where the streaming would be collected; and a downstream Collector to count 
        //each List quantity for each key and substitute the lists of every key for the respective count.
        Supplier<TreeMap> supplierTreeMap = new Supplier<TreeMap>() {
            @Override
            public TreeMap get() {
                Function<Character,String> charIgnoreCase = x->x.toString().toUpperCase();
                Function<Character,String> charCase = x->x.toString();
                Comparator<Character> comparator1 = Comparator.comparing(charIgnoreCase).thenComparing(charCase).reversed();
                Comparator<Character> comparator2 = new Comparator<Character>() {
                    @Override
                    public int compare(Character o1, Character o2) {
                        if(o1.toString().toUpperCase().compareTo(o2.toString().toUpperCase())==0)
                            return 0;
                        if(o1.toString().toUpperCase().compareTo(o2.toString().toUpperCase())>0)
                            return 1;
                        return -1;
                    }
                };
                Comparator<Character> comparator3 = new Comparator<Character>() {
                    @Override
                    public int compare(Character o1, Character o2) {
                        if(o1.toString().compareTo(o2.toString())==0)
                            return 0;
                        if(o1.toString().compareTo(o2.toString())>0)
                            return 1;
                        return -1;
                    }
                };
                //return new TreeMap<Character, Long>(comparator2.thenComparing(comparator3).reversed());
                return new TreeMap<Character, Long>(comparator1);
            }
        };
        System.out.println("");
        Map<Character,Long> treeMapCount = Stream.of(personArray).collect(Collectors.groupingBy(Person::getFirstLetter,supplierTreeMap,Collectors.counting()));
        treeMapCount.forEach((x,y)->{
            System.out.print(x+" char: "+y+" names.\n");
        });
        
        //Using SecureRandom to obtain a Stream of dice faces thrown many times and then collecting as groups in the Map with the face as a key
        //and the count as the frequency value of each face thrown result.
        System.out.println("");
        SecureRandom random = new SecureRandom();
        Map<Integer,Long> mapRandom = random.ints(1000000, 1, 7).mapToObj(Integer::valueOf).collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
        mapRandom.entrySet().stream().forEach(new Consumer<Map.Entry<Integer, Long>>() {
            @Override
            public void accept(Map.Entry<Integer, Long> t) {
                System.out.println("Face "+t.getKey()+" :"+t.getValue()+" times.");
            }
        });
        mapRandom.forEach((key,value) -> System.out.println("Face " + key + " :" + value + " times."));
    }
    public enum EnumFamilyThatLivesTogether{
        DANIEL,JULIANA,TINA,BOSCO;
        @Override
        public String toString() {
            return this.name();
        }
    }
    public static boolean beginsWithUpperCase(String s){
        Character[] c = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        if(Stream.of(c).anyMatch(x->x.equals(s.charAt(0)))){
            return true;
        }
        return false;
    }
}
