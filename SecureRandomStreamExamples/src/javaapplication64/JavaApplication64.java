package javaapplication64;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaApplication64 {
    static long count1=0;
    static long count2=0;
    static long count3=0;
    static long count4=0;
    static long count5=0;
    static long count6=0;
    public static void main(String[] args) {
        //a dice trown x times
        int times=1000000;
        
        //the thrown dice results are grouped into 6 categories, represented by classifying keys of the same number of the results themselves, and counted the total results for each category.
        //each category total results are devided by the times the dice was thrown to get each relative percentage, for each of the 6 types of results.
        //inner Stream scope variables have their values saved at static outer variables for later use.
        //the total number of times are confirmed by the sum of every result category frequence.
        System.out.println("First example:");
        Map<Integer,Long> map = new SecureRandom().ints(times, 1, 7).parallel().boxed().collect(Collectors.groupingBy(Function.identity(),TreeMap::new,Collectors.counting()));
        map.forEach((key,count)->{System.out.println("groupKey: "+key+" count: "+count+" TotalPercentage: "+count*100.0/times+"%");saveCounts(key, count);});
        System.out.println("Counts: 1/2/3/4/5/6: "+count1+"/"+count2+"/"+count3+"/"+count4+"/"+count5+"/"+count6+".");
        System.out.println("Total count: "+(count1+count2+count3+count4+count5+count6));
        
        //the dice frequences are not grouped, but simply stored at an unordered list to be displayed right after.
        System.out.println("\nSecond example:");
        List<Integer> list = new SecureRandom().ints(times, 1, 7).parallel().boxed().collect(Collectors.toCollection(LinkedList<Integer>::new));
        list.forEach((n)->System.out.print("n="+n+" "));System.out.println("");
        System.out.println(times==list.size()?"Listing complete! "+times+" entries added.":"Listing wrong!");
        
        //the dice frequences are not grouped, but simply stored at an ordered list to be displayed right after.
        System.out.println("\nThird example:");
        Queue<Integer> queue = new SecureRandom().ints(times, 1, 7).parallel().boxed().collect(Collectors.toCollection(PriorityQueue<Integer>::new));
        queue.forEach((n)->System.out.print("n="+n+" "));System.out.println("");
        System.out.println(times==queue.size()?"Queueing complete! "+times+" entries added.":"Queueing wrong!");
    }
    public static void saveCounts(Integer key,Long count){
        switch(key){
            case 1: count1=count;
                System.out.println("Count1 saved.");
                break;
            case 2: count2=count;
                System.out.println("Count2 saved.");
                break;
            case 3: count3=count;
                System.out.println("Count3 saved.");
                break;
            case 4: count4=count;
                System.out.println("Count4 saved.");
                break;
            case 5: count5=count;
                System.out.println("Count5 saved.");
                break;
            case 6: count6=count;
                System.out.println("Count6 saved.");
        }
    }
}
