package javaapplication60;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Stream;
import java.nio.file.Path;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaApplication60 {
    public static void main(String[] args) {
        //testCollections();
        //testStack();
        //testPriorityQueue();
        //testTreeSet();
        //testTreeMap();
        //testProperties();
        //testSynchonizedCollections();
        testUnmodifiableCollections();
    }
    public static void testCollections(){
        //List<LocalDateTime> list = new ArrayList<>(Arrays.asList(LocalDateTime.now(),LocalDateTime.now(),LocalDateTime.now(),LocalDateTime.now(),LocalDateTime.now(),LocalDateTime.now(),LocalDateTime.now(),LocalDateTime.now(),LocalDateTime.now(),LocalDateTime.now()));
        List<LocalDateTime> list = new ArrayList<>(Collections.nCopies(10, LocalDateTime.now()));
        list.stream().forEach(System.out::print); System.out.println("");
        System.out.println("List size: "+list.size());
        LocalDateTime ldt = LocalDateTime.now();
        Collections.fill(list, ldt);
        list.stream().forEach(System.out::print); System.out.println("");
        Collections.addAll(list, list.toArray(new LocalDateTime[0]));
        System.out.println("List size: "+list.size());
        System.out.println(Collections.frequency(list, ldt));
        list.stream().forEach(System.out::print); System.out.println("");
        System.out.println(Collections.disjoint(list, list));
        List<LocalDateTime> list2 = new ArrayList<>(Arrays.asList(LocalDateTime.of(1982, Month.APRIL, 22, 0, 0, 0)));
        System.out.println(Collections.disjoint(list, list2));
        Collections.copy(list, list2);
        System.out.println(Collections.disjoint(list, list2));
        System.out.println(Collections.binarySearch(list, LocalDateTime.of(1982, Month.APRIL, 22, 0, 0, 0)));
        System.out.println(Collections.min(list).format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println(Collections.max(list).format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println(Collections.binarySearch(list, LocalDateTime.of(1982, Month.APRIL, 22, 0, 0, 1)));
        Collections.shuffle(list,new SecureRandom());
        Collections.reverse(list);
        Collections.sort(list);
        list.stream().forEach(x->System.out.print(x.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))+"-"+x.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM))+" ")); System.out.println("");
        Collections.swap(list, 0, 1);
        list.stream().forEach(x->System.out.print(x.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))+"-"+x.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM))+" ")); System.out.println("");
        list2 = Collections.unmodifiableList(list);
        try{
            list2.add(ldt);
        } catch(UnsupportedOperationException e){
            System.out.println("UnsupportedOperationException: Unmodifiable List! No operations permitted!!");
        }
    }
    
    public static void testStack(){
        Stack<String> stack = new Stack();
        String[] stringArray = {"S1","S2","S3","S4","S5"};
        for (int i=0;i<5;i++){
            stack.push(stringArray[i]);
            System.out.println("Pushed: "+stringArray[i]);
        }
        System.out.println("Peek: "+stack.peek());
        System.out.println("S1 is "+stack.search("S1")+"th position from top to bottom - First In Last Out - FILO");
        while (!stack.empty()){
            System.out.println(stack.pop() +" popped!");
        }
        System.out.println(stack.empty()?"Stack Empty!":"Not Empty Yet!");
    }
    
    public static void testPriorityQueue(){
        PriorityQueue<String> pQueue = new PriorityQueue<>();
        //PriorityQueue<String> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
        String[] stringArray = {"S5","S2","S1","S4","S3"};
        for (int i=0;i<5;i++){
            pQueue.offer(stringArray[i]);
            System.out.println("Offered: "+stringArray[i]);
        }
        //Iterator DOES NOT return the ordered Queue, but a crazy-ordered one...
        Iterator<String> it = pQueue.iterator();
        System.out.print("Iterating: ");
        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println("");
        //Peek and Pooling are ordered!
        System.out.println("Peek: "+pQueue.peek());
        while (!(pQueue.size()==0)){
            System.out.println(pQueue.poll() +" polled!");
        }
        System.out.println(pQueue.size()==0?"Queue Empty!":"Not Empty Yet!");
        System.out.println("NOT First In First Out - FIFO, as in a normal Queue, but according to ordering priority: first order priority, first out!");
        System.out.println("A different Comparator can be passed at construction.");
    }
    
    public static void testTreeSet(){
        TreeSet<String> treeSet = new TreeSet<>(Arrays.asList("S5","S3","S2","S4","S1"));
        Iterator<String> it = treeSet.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println("");
        for (String s:treeSet){
            System.out.print(s+" ");
        }
        System.out.println("");
        //treeSet.stream().forEach(System.out::print);
        System.out.println(treeSet.headSet("S3",true));
        System.out.println(treeSet.tailSet("S3",false));
        System.out.println(treeSet.subSet("S2", true, "S4",true));        
        //ceiling and floor are higer/lower than OR EQUAL, whereas higher and lower do not retrieves EQUAL elements.
        System.out.println(treeSet.ceiling("S1"));
        System.out.println(treeSet.floor("S5"));
        System.out.println(treeSet.higher("S0"));
        System.out.println(treeSet.lower("S6"));
        System.out.println(treeSet.size()+" elements.");
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        while (treeSet.size()!=0){
            System.out.println("Polling: "+treeSet.pollFirst());
        }
        System.out.println(treeSet.isEmpty()?"TreeSet Empty!":"TreeSet Not Empty Yet!");
    }
    
    public static void testTreeMap(){
        TreeMap<String,Integer> treeMap = new TreeMap<>();
        String[] stringArray = {"S5","S2","S1","S4","S3","S4","S3","S4","S3","S1"};
        for(String s:stringArray){
            if(treeMap.containsKey(s)){
                treeMap.put(s, treeMap.get(s)+1);
            } else{
                treeMap.put(s, 1);
            }
        }
        treeMap.keySet().stream().forEach(x->System.out.println("\""+x+"\": "+treeMap.get(x)+" occurence(s)."));
        System.out.println("or:");
        treeMap.entrySet().stream().forEach(entry->System.out.println("\""+entry.getKey()+"\": "+entry.getValue()+" occurence(s)."));
        System.out.println("or");
        Set<String> keys = treeMap.keySet();
        Integer[] values = treeMap.values().toArray(new Integer[0]);
        Iterator<String> it = keys.iterator();
        for(int i=0;i<keys.size();i++){
            System.out.println("\""+it.next()+"\": "+values[i]+" occurence(s)");
        }
        System.out.println("or");
        treeMap.entrySet().stream().flatMap(x->Stream.of("\""+x.getKey()+"\": "+x.getValue()+" occurrance(s)")).forEach(System.out::println);
    }
    public static void testProperties(){
        Properties properties = new Properties();
        properties.setProperty("Prop1", "ValueProp1");
        properties.setProperty("Prop2", "ValueProp2");
        properties.setProperty("Prop3", "ValueProp3");
        properties.setProperty("Prop4", "ValueProp4");
        properties.setProperty("Prop5", "ValueProp5");
        //properties.list(System.out);
        //properties.entrySet().stream().forEach(x->System.out.println(x.getKey()+"="+x.getValue()));
        properties.keySet().forEach(x->System.out.println(x+"="+properties.getProperty((String)x)));
        properties.stringPropertyNames().forEach(System.out::print); System.out.println("");
        Path path = Paths.get("properties.dat");
        if(Files.notExists(path)){
            try {
                Files.createFile(path);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //enable to write at dat file
//        try (OutputStream out = Files.newOutputStream(path)){
//            properties.store(out,"Property list - "+LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
        System.out.println("\nBefore reading dat file:");
        properties.keySet().forEach(x->System.out.println(x+"="+properties.getProperty((String)x)));
        try (InputStream in = Files.newInputStream(path)){
            properties.load(in);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("\nAfter loading dat file with stored data:");
        properties.keySet().forEach(x->System.out.println(x+"="+properties.getProperty((String)x)));
    }
    public static void testSynchonizedCollections(){
        List<String> syncList = Collections.synchronizedList(Arrays.asList("1","2","3"));
        System.out.println(syncList.getClass().getName());
        SortedSet<String> syncSortedSet = Collections.synchronizedSortedSet(new TreeSet<String>(Arrays.asList("1","2","3")));
        System.out.println(syncSortedSet.getClass().getName());
        SortedMap<String,String> syncSortedMap = Collections.synchronizedSortedMap(new TreeMap<String,String>());
        System.out.println(syncSortedMap.getClass().getName());
    }
    public static void testUnmodifiableCollections(){
        List<MyModifiableObject> unmodifiableList = Collections.unmodifiableList(Arrays.asList(new MyModifiableObject("1"),new MyModifiableObject("2"),new MyModifiableObject("3")));
        System.out.println(unmodifiableList.getClass().getName());
        SortedSet<String> unmodifiableSortedSet = Collections.unmodifiableSortedSet(new TreeSet<String>(Arrays.asList("1","2","3")));
        System.out.println(unmodifiableSortedSet.getClass().getName());
        SortedMap<String,String> unmodifiableSortedMap = Collections.unmodifiableSortedMap(new TreeMap<String,String>());
        System.out.println(unmodifiableSortedMap.getClass().getName());
        try{
            unmodifiableList.add(new MyModifiableObject("5"));
            unmodifiableSortedSet.add("5");
            unmodifiableSortedMap.put("5", "5");
        } catch (UnsupportedOperationException ex){
            System.out.println("RuntimeException: "+ex.getClass().getName()+" while trying to modify the unmodifiable!");
            ex.printStackTrace(System.out);
        }
        System.out.println(unmodifiableList);
        try{
            unmodifiableList.get(0).setField("100");
        } catch (UnsupportedOperationException ex){
            System.out.println("RuntimeException: "+ex.getClass().getName()+" while trying to modify the unmodifiable!");
            ex.printStackTrace(System.out);
        }
        System.out.println(unmodifiableList);
        
        /*the references of unmodifiable Collections are immodifiable, but the objects appointed, if modifiable, can be
        modified, so that the original reference will appoint to the same objects but with values updated. If the Object
        types are also unmodifiable, as the references that appoint to them, then no change can be done at all.
        */
    }
}
