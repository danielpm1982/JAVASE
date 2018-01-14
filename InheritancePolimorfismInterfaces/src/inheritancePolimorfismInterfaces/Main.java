package inheritancePolimorfismInterfaces;
public class Main {
    public static void main(String[] args) {
        Class1 class1 = new Class1("s1", "s2", "s3");
        System.out.println(class1.getField1()+" "+class1.getField2()+" "+class1.getField3()+" "+class1.doSomething());
        
        Class2 class2 = new Class2("s1", "s2", "s3", "s4");
        System.out.println(class2.getField1()+" "+class2.getField2()+" "+class2.getField3()+" "+class2.getField4()+" "+class2.doSomething());
        
        /*Although not visible directly in the child class, super private variables and methods do exist
        in the hierarchical lower level classes, in a way that these can use (set/read) the value or 
        behavior of those by calling public methods or super constructors, without having any access to
        the private variables or methods themselves, but to the values and behavior of them, undirectly.*/
        
        System.out.println(class1.doSomething());
        System.out.println(class2.doSomething());
        
        /* Overriden methods can have different return types, provided that the return is a subtype (covariant) of the
        original one (assignment compatible with). Of course not in the case of primitive or void returns, 
        which can't have subtypes. The overriding method also can't have modifying accessibility more 
        restrictive than the super method. And must have equal name and list of types of arguments identical
        to the super method. The parameter names may vary, as long as their types are the same and in the 
        same order. The overriding method can be final, but not static (unless the super also is). Can be 
        abstract (if the subclass also is), but not final abstract (which wouldn't make any sense).
        The overriding method also must "throws" the same checked Exceptions or subtype ones of the parent
        class, and must not "throws" different new checked exceptions by its own. Or could "throws" none.
	Other than normal overriding, there are two other cases to pay attention on, these are:
	- private methods on the parent can't be overriden, as they're not accessible at the child, what
	makes possible for the child class to declare any method inclusive the with the same signature of
	the parent's without having to comply with any rule above, as the method at the child turns out to
	be a completely unrelated one.
	- static methods can be hidden, if both parent and child classes declare them both static. And
	they must also comply with the overriden rules, adding the rule of being declared both static.
	Additionaly, the behaviour between overriden and hidden methods are different, in the fact that,
	from two hidden methods (parent/child classes), the method chosen at runtime is the one in the class
	where the call of the method was made (inclusive indirectly by other overriden methods). If called from
	a "place" at the parent, the hidden parent method is chosen, and vice-versa. As for overriden methods,
	the choice of which method to use is always done according to the object reference type, and regardless
	of where the call is made from (if from the super ou sub classes). If the object is a sub class object,
	and the method is overriden, the sub method will always be chosed, whether called from the parent or
	from the child class.
	Neither overriden or hidden methods can be final at the parent in order to be overriden or hidden at
	the child class.
        */
        
	/*
	Regarding variables (or fields), there is no such thing as overriding (so that the variable would
	always be taken as the child variable if overriden, no matter where it was called from). With variables
	there might be hiding, as with static methods. Either for instance or static variables. If called
	from the parent, the parent variable will always be chosen. If called from the child class, the child
	variable will be chosen, unless the type of the reference (and not the object) is of the parent type.
	*/

        System.out.println(class2.polimorphicMethod(class1));
        System.out.println(class2.polimorphicMethod(class2));
        
        /*Polimorphism is simply when some method syntax behaves differently (overrided) in a context
        where a superclass reference is used (generalization), so that, for one same reference type 
        variable the method behaves according to the Object type that the reference appoints to, and 
        not according to the general type of the variable itself. It means the code may be mostly
        written considering the general reference (either at the parameter list or the body itself), 
        regardless of what other subclass references will be used with the code (reusability), 
        even for not yet existing Object types (extensibility). At execution time the reference will
        be identified as of that specialized object and the polimorphic methods will execute accordingly.
        */
        
        System.out.println("superClassName: \t"+class1.getClass().getSuperclass().getName()+"\t\tclassName: "+class1.getClass().getName());
        System.out.println("superClassName: \t"+class2.getClass().getSuperclass().getName()+"\tclassName: "+class2.getClass().getName());
        System.out.println("class1 instanceof Class1 ? "+(class2 instanceof Class1));
        System.out.println("class2 instanceof Class1 ? "+(class2 instanceof Class1));
        System.out.println("class1 instanceof Class2 ? "+(class1 instanceof Class2));
        System.out.println("class2 instanceof Class2 ? "+(class2 instanceof Class2));
        
        /*Being an instanceof a Class means the variable can be casted to that Class type, generally
        a more general type reference when it's gonna check if a downcasting can be made to a
        subclass type reference. It depends on the intantiation Object type, and not on the reference
        type of the variable.*/
        
        // static interface methods can only be called statically from the Interface where they're declared,
        // not from concrete instances that eventually implement that interface nor from other subinterfaces.
        System.out.println(InterfaceA.staticMethod(0).getClass().getName()+": \t"+InterfaceA.staticMethod(0));
        System.out.println(InterfaceA.staticMethod(1).getClass().getName()+": \t"+InterfaceA.staticMethod(1));
        
        /* default interface methods can be called only through instance concrete objects that implement
        the interface, or subclass objects, not from the static context of any interface or subinterface.
        Default interface methods are inherited by all subinterfaces and concrete classes and its subclasses. 
        The difference to the abstract ones is that the default methods are already implemented, would not
        oblige the implementing class of that interface to implement it, although it could override it.
        In case of collision of same method names, Java considers the most near method implemented,
        and not the default ones eventually inherited from interfaces. And as default are not obliged to be
        implemented at subclasses it's not supposed to break any old codes.
        */
        InterfaceA ia = new FakeClass();
        InterfaceB ib = new FakeSubclass();
        System.out.println(ia.defaultMethod(0).getClass().getName()+": \t"+ia.defaultMethod(0));
        System.out.println(ib.defaultMethod(1).getClass().getName()+": \t"+ia.defaultMethod(1));
        
        // abstract interface methods can be, as default ones, called from the instances whose classes
        // have implemented that interface (or subclasses), the difference is that they're primarily 
        // not implemented and the concrete class is forced to implement it in order to be instanciated 
        // (or be left abstract - the method and the class. As any other public instance methods, the
        // abstract interface methods are inherited at subclasses, as default ones also are.
        System.out.println(ia.abstractMethod());
        System.out.println(ib.abstractMethod());
        
        
    }
}
