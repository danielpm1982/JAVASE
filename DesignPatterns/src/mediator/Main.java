package mediator;
public class Main {
    public static void main(String[] args) {
        MediatorInterface mediator = new Mediator();
        ColleagueInterface colleague1 = new Colleague1(mediator);
        ColleagueInterface colleague2 = new Colleague2(mediator);
        ColleagueInterface colleague3 = new Colleague3(mediator);
        mediator.addColleagueArray(colleague3,colleague1,colleague2);
        System.out.println("Calling mediator from a Colleague1 command:");
        colleague1.showYourself();
        System.out.println("Calling mediator from a Colleague2 command:");
        colleague2.showYourself();
        System.out.println("Calling mediator from a Colleague3 command:");
        colleague3.showYourself();
    }
}

/*
Mediator Pattern has already been exemplified at the Controller MVC class (Compound Pattern package), 
but essentially is used when you want to centralize the complex communication and control of multiple 
objects, putting all the controlling logic on the Mediator Class, and decoupling every other object 
from each other. The other objects keep communicating only with the Mediator Class, and not with each 
other anymore.
The advantages are that this Pattern turns the supported objects more reusable, independent from the
system logic; it also simplifies the maintenance of the system, then centralized in one only class; also
it centralizes and reduces the number of messages between objects.
This is a very, very simplistic example of how eliminating object calls and centralizing the logic in
one single mediator component can turn the design better.

"Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by 
keeping objects from referring to each other explicitly, and it lets you vary their interaction 
independently."
(Design Patterns: Elements of Reusable Object-Oriented Software, 1994)
*/
