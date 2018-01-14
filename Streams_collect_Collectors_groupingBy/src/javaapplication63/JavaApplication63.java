package javaapplication63;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaApplication63 {
    public static void main(String... args) {
        Worker[] workerArray = {
            new Worker("Daniel", "P", new BigDecimal(5000), "Dep1"),
            new Worker("Juliana", "P", new BigDecimal(2000), "Dep2"),
            new Worker("Bosco", "P", new BigDecimal(3000), "Dep3"),
            new Worker("Tina", "P", new BigDecimal(4000), "Dep1"),
            new Worker("E", "P", new BigDecimal(7000), "Dep2"),
            new Worker("Z", "P", new BigDecimal(1500), "Dep3"),
            new Worker("A", "P", new BigDecimal(4300), "Dep3"),
            new Worker("J", "P", new BigDecimal(2300), "Dep1"),
            new Worker("G", "P", new BigDecimal(6300), "Dep1"),
            new Worker("F", "M", new BigDecimal(2000), "Dep2"),
            new Worker("Daniel", "M", new BigDecimal(20500), "Dep1")
        };
        //just showing array
        Arrays.stream(workerArray).forEach(System.out::println);System.out.println("");
        /*grouping through Collectors.groupingBy(Function<? super T,? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,A,D> downstream)
        where the first parameter is a classifier function that selects by what field to group by;
        the second parameter is the constructor reference of the resulting Collection (e.g. a TreeMap), where the key will be the classifier above;
        and the third parameter is another Collectors that might be a single number (a sum, an average or such) or another Collection with the classified 
        objects - Worker objects in this case... either way, being this parameter the value(s) element(s) of each Map entry grouped by each classifier key.
        */
        //having a long count as the value for the map, with the number of employees for each department. And statistics by department.
        TreeMap<String,Long> treeMap1 = Stream.of(workerArray).collect(Collectors.groupingBy(Worker::getDepartment, TreeMap::new, Collectors.counting()));
        treeMap1.forEach((dep,numberOfWorkers)->System.out.print(dep+" - "+numberOfWorkers+" workers; "));System.out.println("");
        treeMap1.entrySet().forEach(entry->System.out.print(entry.getKey()+" - "+entry.getValue()+" workers; ")); System.out.println("");
        
        TreeMap<String,HashSet<Worker>> treeMapStatics = Stream.of(workerArray).collect(Collectors.groupingBy(Worker::getDepartment, TreeMap::new, Collectors.toCollection(HashSet::new)));
        treeMapStatics.forEach((dep,workerSet)->System.out.println(dep+" - "+workerSet.stream().mapToDouble(x->x.getSalary().doubleValue()).summaryStatistics().toString()));
        //having a HashSet<Worker> Collection as the value for the map, with the worker objects of each department. Showing first by
        //the first name/last name comparing order, and later by the opposite.
        TreeMap<String,Set<Worker>> treeMap2 = Stream.of(workerArray).collect(Collectors.groupingBy(Worker::getDepartment, TreeMap::new, Collectors.toCollection(HashSet<Worker>::new)));
        treeMap2.forEach((dep,workerSet)->{System.out.println("\nDepartment "+dep);workerSet.stream().sorted(Comparator.comparing(Worker::getFirstName).thenComparing(Worker::getLastName)).forEach(worker->System.out.println(worker));}); System.out.println("");
        treeMap2.forEach((dep,workerSet)->{System.out.println("\nDepartment "+dep);workerSet.stream().sorted(Comparator.comparing(Worker::getLastName).thenComparing(Worker::getFirstName)).forEach(worker->System.out.println(String.format("%-11s", worker.getLastName())+String.format("%-9s", worker.getFirstName())+String.format("%.2f", worker.getSalary())));}); System.out.println("");
        
        //For Maps, the specialized forEach method receives an implementation of a BiConsumer, corresponding to the two Objects of each Map entry as the arguments of the accept functional and abstract method of this interface.
        //While for Streams, the forEach method receives an implementation of a Consumer, with only one argument at the accept funcional method.
        
        /*
        When Collectors.groupBy method is used only with the classifier Function parameter, and not the other two parameters, the return 
        is a Map in which the key of each entry is the classifier and the value is a List whose parameter type is the same as the 
        type of the Objects being classified. The default, thus, is a Map Collection with a List<Classified-type> as its second 
        parameter type. The first parameter type is always the same as the classifier's, declared explicitly.
        */
    }
}

class Worker implements Comparable<Worker>{
    private final String firstName;
    private final String lastName;
    private final BigDecimal salary;
    private final String department;

    public Worker(String firstName, String lastName, BigDecimal salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return String.format("%-10s",firstName)+String.format(" %-10s",lastName)+String.format(" %3s","$")+String.format("%-11.2f", salary)+String.format(" %s",department);
    }

    @Override
    public int compareTo(Worker o) {
        return this.firstName.compareTo(o.firstName);
    }
}