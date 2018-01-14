package integersetlowlevel;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(500);
        System.err.println("Instantiating set1...");
        IntegerSet set1 = new MyIntegerSet(1,2,3,4,5,6,7,8,9);
        System.out.println(set1);
        System.err.println("set1 instantiated!");
        Thread.sleep(500); System.out.println("");
        System.err.println("Adding Integer 10...");
        set1.add(10);
        System.out.println(set1);
        System.err.println("Integer 10 added!");
        Thread.sleep(500); System.out.println("");
        System.err.println("Removing Integer 10...");
        set1.remove(10);
        System.out.println(set1);
        System.err.println("Integer 10 removed!");
        Thread.sleep(500); System.out.println("");
        System.err.println("Instantiating set2...");
        IntegerSet set2 = new MyIntegerSet(9,10,11,12);
        System.out.println(set2);
        System.err.println("set2 instantiated!");
        Thread.sleep(500); System.out.println("");
        System.err.println("Getting a new Set of the Union of Set1 with set2...");
        System.out.println(set1.union(set2));
        System.err.println("Union obtained! Set1 and Set2 unaltered!");
        Thread.sleep(500); System.out.println("");
        System.err.println("Getting a new Set of the Intersection of Set1 with set2...");
        System.out.println(set1.interSection(set2));
        System.err.println("Intersection obtained! Set1 and Set2 unaltered!");
        Thread.sleep(500); System.out.println("");
        System.err.println("Getting a new Set of the Difference between Set1 and set2...");
        System.out.println(set1.diff(set2));
        System.err.println("Difference obtained! Set1 and Set2 unaltered!");
        Thread.sleep(500); System.out.println("");
        System.err.println("Set1 remains the same:");
        System.out.println(set1);
        Thread.sleep(500); System.out.println("");
        System.err.println("Set2 doesn't change either:");
        System.out.println(set2);
    }
}
