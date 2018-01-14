package javaapplication61;

import java.util.Arrays;
import java.util.List;

public class JavaApplication61{
    public static void main(String[] args) {
        method1("hi");
        method2(Arrays.asList("hi"));
        method3(Arrays.asList("hi"));
        method4(Arrays.asList("hi"),"hello");
        method5(Arrays.asList("hi"),"hello");
    }
    public static <T extends String> void method1(T t){
        T r=t;
        System.out.println(r);
    }
    public static <T extends String> List<T> method2(List<T> t){
        t.stream().forEach(System.out::print);System.out.println("");
        return t;
    }
    public static void method3(List<? extends String> t){
        t.stream().forEach(System.out::print);System.out.println("");
    }
//    public static <T extends String> void method4(List<? extends String> t, T t2){
//        t.add(t2);
//        t.stream().forEach(System.out::print);System.out.println("");
//    }
    public static <T extends String> void method4(List<T> t, T t2){
        t.add(t2);
        t.stream().forEach(System.out::print);System.out.println("");
    }
    public static <T extends String> void method5(List<? super String> t, T t2){
        t.add(t2);
        t.stream().forEach(System.out::print);System.out.println("");
    }
//    public static <T extends String> List<? super String> method5(List<? super String> t, T t2){
//        t.add(t2);
//        t.stream().forEach(System.out::print);System.out.println("");
//        return t;
//    }

}

/*
-> wildcards (?) cannot be used as a direct parameter type or return type or variable type,
only as a generic class unknown type (within <>) with or without bounds. So at method1() 
only the parameter type (or parameter variable) of generics would work.

-> wildcards (?), even when viable (within <>) in a type session of a generic class, should
never be used to return that generic class type. The caller should not deal with wildcards
results. Generic reference types should be used as in method2().

-> in some cases, as in method3(), a wildcard would be preferred, as there's no need for
further specification, as no other generic parameters are declared, nor any return generic
types are expected, nor the generic type is necessary within the method scope. Also there's 
no need for multiple upper bounds, which would not be possible with wildcards, only with 
generic reference types. There's no need, also, for lower bounds, which only exists for 
wildcards. Thus, in this case, both wildcard and reference type would work.

-> at the first attempt of declaring method4() - line 25, a compilation error will display, because
the data structure generic type is declared as a wildcard upperbounded to String class, and the
second parameter is declared as a type parameter upperbounded to String, also, but there's no
guarantee that the second parameter element would not be of a superclass while the wildcard
type would be of a subclass, or even not related classes (although both could be a String), 
which obviously would not work. Suppose Strings could have subclasses, and ? was of class
A, whereas T was of class B, and B was not of class A, B could never be added to A type data 
structure. Although the opposite would work. As there's no way to know it, it does not compile
this way, and wildcards can't be used.

-> at the second attempt of declaring method4() - line 29, all works OK, as both the data type
and the second parameter are of the same type T. So that no mismatch could occur. When more
than one generic parameter types are used, and specially when they must not mismatch in order
to some internal code to work, a type parameter is preferred over unknown wildcard types.

-> a third attempt to make the 1st method4() to work is to use a wildcard as the data structure
type but with a lowerbound, instead of upperbound... as in method5(). The upperbound, as mentioned,
would not exclude a mismatch regarding the second parameter to be added at the data structure. The
data structure could be of any class until String, including subclasses of T. So it would not compile.
If a lower bound is used, otherwise, the data structure would accept objects from String classes and up
(in the hypothethical hierarchy), whereas the second parameter would ever be a String in any case... so
it would always be guaranteed that the second parameter type would be compatible with the type of the
data structure, considering it being any superclass of the hierarchy which would always include T as 
a subtype, never as a supertype or unrelated type. T would always be a String, and the data structure
type would be a super type of String... which would always accept a String as a String would also be
that supertype. With lower bounds (super) unrelateness problem is resolved, as the cases where T
could be a supertype and not a type of the data structure.
**********************************************************************************************************
For wildcard Producer methods always use upper bounds, while for Consumer methods always use lower bounds. 
PECS -> Producer-Extends/Consumer-Super.
**********************************************************************************************************
Method5() is a consumer, so a super (lower bound) must be chosen if it is for wildcards to be used.

-> the second version of method5() is only to remember that, although possible, generic return types using
wildcards should never be used, avoinding caller classes to having to handle it. Wildcards should always
be transparent to user classes, as reference type classes or methods are (the caller defines the type
and the casting is done implicity returning the correct type - no need to work the generic type at user
classes as with wildcards returns it would be necessary.

*/

