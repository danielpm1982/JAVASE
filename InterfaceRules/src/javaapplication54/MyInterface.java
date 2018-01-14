package javaapplication54;
public abstract interface MyInterface {
    public static final int MY_CONSTANT=1;
    public abstract void myMethod();
    public default void myDefaultMethod(){}
    public static void staticMethod(){}
}
