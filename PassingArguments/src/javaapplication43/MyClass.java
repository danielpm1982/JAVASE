package javaapplication43;

public class MyClass {
    public static void main(String[] args) {
           int i = 0;
           Integer i2 = new Integer(0);
           //Integer i2 = 0;
           MyInteger myInteger = new MyInteger(0);
           
           System.out.println("Field int i before addOne: "+i);
           addOne(i);
           System.out.println("Field int i after addOne: "+i);
           System.out.println("Field Integer i2 before addOne: "+i2);
           addOne(i2);
           System.out.println("Field Integer i2 after addOne: "+i2);
           System.out.println("Field MyInteger myInteger value before addOne: "+myInteger.getI());
           addOne(myInteger);
           System.out.println("Field MyInteger myInteger value after addOne: "+myInteger.getI());
    }
    private static void addOne(int i){
        //local variable alterations will not change the original variable, 'cause only the local 
        //copy will be changed, as the passing was by value (as every passing in Java).
        System.out.print("addOne("+i+"), result=");
        i++;
        System.out.println(i);
    }
    private static void addOne(Integer i2){
        /*Integer and other number built-in Object reference types have final internal values that 
        cannot be changed, and the object has no method for doing so either. Any of the 4 below local 
        variable manipulations will assign a different object, as a different reference, to the 
        variable, and of course the original variable value will not be changed either, nor its original 
        reference.*/
        System.out.print("addOne("+i2+"), result=");
        i2=new Integer(i2+1);
        i2++;
        i2=Integer.sum(i2, 1);
        i2=1;
        System.out.println(i2);
    }
    private static void addOne(MyInteger myInteger){
        /*In case of other reference Types, including custom number reference types with not final 
        internal variables and methods to change these values, the reference of the original variable
        is also copied to the new local method variable, but in this case it's possible to manipulate
        and change the object, so that the external (original) variable will be
        appointing to the changed same object without any reassignments, thus keeping the changes at
        the external scope level.
        If the program makes any local reassignment on the local variable that once had a copy to the
        same external Object reference, the local reference will obvious change and any changes of value
        will not be made to the original Object, still referenced by the external original reference kept
        by the external original reference variable.
        */
        System.out.print("addOne("+myInteger.getI()+"), result=");
        myInteger.setI(myInteger.getI()+1);
        System.out.println(myInteger.getI());
    }
}
