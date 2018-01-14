package inheritancePolimorfismInterfaces;
public class ConstructorsChainCall {

    public ConstructorsChainCall() {
        this("abc");
        System.out.println("1st ConstructorsChainCall called.");
    }
    
    public ConstructorsChainCall(String s) {
        this(0);
        System.out.println("2nd ConstructorsChainCall called.");
    }
    
    public ConstructorsChainCall(int i) {
        //super();
        System.out.println("Object() constructor called implicitly (super()).");
        System.out.println("3rd ConstructorsChainCall called.");
    }
    
    public static void main(String[] args) {
        new ConstructorsChainCall();
    }
}

/*
Either this() or super(), with arguments or not, may be called at the first line of
a constructor. If neither is explicitly called at a specific constructor, the compiler
implicitly call for the super() constructor at a custom parent class or the Object parent 
class, from which every class inherits (other than the Object class itself).
In a chain of constructor calls, the super() will be called (implicitly of explicitly) at
the last called constructor (the one that doesn't call any other this() constructor, in the
case above, at the 3rd constructor... as the super() (inclusive implicitly) must be the first
line, as this() call must also be (can't have both in one same constructor!).
Regarding the super constructor, if the super class has any subclass, it must provide
a non argument constructor (implicitly or explicitly), so that the constructors of the
child first call it before their own. In the case the parent doesn't have a non argument
constructor, all child classes are obliged to call the "with arguments" super constructor
before any own constructor, what is not done implicitly. Either the super class provide
a no argument constructor, or the child class must call any argument constructor the super
class has before any own initialization... always the super classes must be initialized first!
*/
