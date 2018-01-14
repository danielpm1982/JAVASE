package javaapplication54;

public abstract class JavaApplication54 implements MyInterface,MyInterface2{
    
    public void myDefaultMethod(){}
    
    //@Override
    public static void staticMethod(){} //does not override static interface methods
    
    public static void main(String[] args) {}
}

/*
    With Interfaces, the variables always will be assumed public static final.
    The methods can be: abstract, default or static. Always public.
    
    Public abstract methods cannot be final, static, private or protected. And
    the multiple inheritance problem occurs if two different interface abstract
    methods are inherited at another interface or class with the same method name
    and parameter list, but with different return types, as the concrete class
    or (or the concrete that would implement the last interface) would have to
    implement both abstract methods with one same name and parameter list but with
    different return type what is not allowed in any class. Other than this case,
    if two inherited abstract methods are equal in signature, inclusive with the
    same return type, there would be no problem, as only one version of the redudance
    would have to be implemented at a class. Also, if the methods have different
    signatures, there would be no problem, as they would be completely unrelated or
    overloaded ones (not overriden).
    
    Public default methods are always public and concrete (with a body), and cannot be 
    abstract, final or static, as they have a concrete implementation, they may be
    overriden at extended interfaces or classes (not obliged, though), and they're always 
    instance ones.
    Multiple inheritance also occurs and the problem, differently from abstract cases,
    would be if a interface or class receives two identical signature concrete default
    methods, as it would not know which one to use, unless the child class or interface
    implements its own concrete version overriding both super versions. If the two versions
    are of different return types, it will not be possible to do so and it will never compile 
    (one only method at the child would not override both parent methods, and it would not
    be possible to declare two different return type methods at the child one single class).
    
    Public static methods are the same as static class methods except that they're not
    inherited, and thus do not cause any multiple inheritance problems, differently from
    abstract or default methods. And cannot be called through an instance variable, only
    through the class name of the class where it is declared. Any static methods, with
    the same signature, at children classes or interfaces will have nothing to do with each
    static method of each interface. They're completely unrelated.

*/
