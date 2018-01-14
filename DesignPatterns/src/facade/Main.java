package facade;
public class Main {
    public static void main(String[] args) {
//        IlluminationAlarmFacade illuminationAlarmFacade = new IlluminationAlarmFacade(new LampsLivingRoom(), new LampsKitchen(), new LampsBedRoom(), new LampsOuterSide(), new Alarm());
//        illuminationAlarmFacade.turnOn();
//        System.out.println(illuminationAlarmFacade);
//        illuminationAlarmFacade.turnOff();
//        System.out.println(illuminationAlarmFacade);
//        
//        AudioVisualFacade audioVisualFacade = new AudioVisualFacade(new TV(), new BlueRay(), new HomeTheater(), new VideoGameConsole());
//        audioVisualFacade.turnOn();
//        System.out.println(audioVisualFacade);
//        audioVisualFacade.turnOff();
//        System.out.println(audioVisualFacade);
        
        AllObjectsFacade allObjectsFacade = new AllObjectsFacade(new IlluminationAlarmFacade(),new AudioVisualFacade());
        allObjectsFacade.turnOn();
        System.out.println(allObjectsFacade);
        allObjectsFacade.turnOff();
        System.out.println(allObjectsFacade);
    }    
}

/*
Facade Pattern is used, by composition, similar to the Adapter and Decorator Patterns, but with a different intent, which
is to simplify or unite sets of other interfaces or subsystems, in order to leave to the final user class the simplest
and most decoupled way of calling a function. In this example, turnOn or turnOff all mapped devices in a house.
In order to use the Least Knowledge (or Law of Demeter) Principle, in which the fewest objects the client interface deals with,
the better (less coupling and less maintenance), Facade Pattern is especially useful, as you can not only simplify interfaces 
but also reduce a lot the number of objects the client code knows, although not really encapsulating the innumerous individual 
objects, so that if the client needs, he can work at a lower level with them too. The Pattern and extra "wrapper" classes can
also, on the other hand, increase complexity and development time, as well as reduce runtime performance.
Good practices that follow the Least Knowledge Principle:
-> do not call methods on objects returned from other objects' methods;
-> invoke methods that belong to the object itself, to objects passed 
as arguments to that method, or objects instantiated at that object and associated to local or field variables.

The Facade Pattern provides a unified interface to a set of interfaces in a subsystem. 
Facade deﬁnes a higher level interface that makes the subsystem easier to use.
(Head First, Design Patterns, 2004)
*/
