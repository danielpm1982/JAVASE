package adapter1;

public class Main {
    public static void main(String[] args) {
        callInterface(new RealTarget());
        callInterface(new Adapter1(new Adaptee1())); //Adapter simulating Target objects and delegating the call to the Adaptee
        callInterface(new Adapter1(new Adaptee1Son())); //Including Adaptee derived classes
        callInterface(new Adapter2(new Adaptee2())); //And with multiple Adapters possibility
        
//        TargetInterface target=new Adapter2(new Adaptee2());
//        Out.write(target.targetMethod()); //when the Client calls the TargetInterface it doesn't know about Adapters or Adaptees
    }
    public static void callInterface(TargetInterface target){
        Out.write(target.targetMethod()); //when the Client calls the TargetInterface it doesn't know about Adapters or Adaptees
    }
}

/*
An Object Adapter example, based on the UML Components of the Pattern, where the
two (assumed) incompatible interfaces (TargetInterface and Adaptee classes) are 
adapted by an Adapter classes, which takes, by composition, an instance of the Adaptee 
in order to delegate to it the request ordered by the Client (Main, here), even
the Client only being able to see the TargetInterface as expected. This decouples
the Client from the calls on the Adaptee and avoids any changes on Client code. 
The changing parts keep encapsulated at Adapter and Adaptee classes, whose existence 
the Client doesn't even suspect, because it thinks it is dealing with a real concrete 
Target class (RealTarget, here), and not an Adapter that implements the TargetInterface 
only to delegate to the Adaptee object the real processing and response.
In this way of implementation, using composition, the Adapter can be changed by
any other Adapter that implements the TargetInterface (including dynamically), and, 
also, the Adapter can deal with the Adaptee or any of its subclasses without virtually 
any changes on the Adapter code, except if the signature of the methods to be called
on the Adaptee derived classes change in respect of the base class' ones. The Adapter, 
on the other hand, cannot directly inherit any Adaptee method, and must implement 
some little more code to make the delegation method work and call the methods on the 
composed Adaptee. 
A class Adapter, differently, is semantically similar, but uses multiple inheritance
and not composition to unite the Target and Adaptee classes on the Adapter to be called.
The Adapter inherits from both. The disadvantage is obvious in terms of languages that 
do not really have multiple inheritance available, like Java, as well as the loss of 
flexibility, as no subclasses of the Adaptee can be managed by the Adapter, which will
inherit only from the base Adaptee class (not from its derived classes). The advantage,
although weak, would be that the Adapter would not have to reimplement code to call
the Adaptee object, as the method of the Adaptee will already have been inherited and 
available automatically, and called through dynamic linking from the TargetInterface 
instance variable.
In both cases of Adapters, an Interface the Client knows is the type of the instance
variable and the instance (concrete) will be the Adapter class chosen (with the Adaptee
encapsulated or inherited).
The Adapter transforms one interface into another, at least at the Client level...
whereas the Decorator also composes different interfaces but to add new behaviors
to the original one. One Pattern dissembles one interface with another. The other
uses one and only one interface, but different components composed, to add behavior.

The Adapter Pattern converts the interface of a class into another interface the clients 
expect.  Adapter lets classes work together that couldn’t otherwise because of incompatible 
interfaces.
(Head First, Design Patterns, 2004)
*/
