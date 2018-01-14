package memento;
public class Main {
    public static void main(String[] args) {
        OriginatorInterface originator = new Originator();
        System.out.println("User is setting a new state at the Originator...");
        originator.setStateFromUserInput(new State("State1")); //setting a first state from user input
        System.out.println("State successfully set! "+originator);
        CareTaker careTaker = new CareTaker();
        System.out.println("Saving Originator state in Memento...");
        careTaker.saveStateInMementoFromOriginator(originator); //saving the current Originator state in a Memento (not in the Originator)
        System.out.println("Originator state successfully saved!");
        System.out.println("User is setting a new state at the Originator...");
        originator.setStateFromUserInput(new State("State2")); //setting a second state from user input
        System.out.println("State successfully set! "+originator);
        System.out.println("Undoing last setting... retrieving old state from Memento to Originator...");
        careTaker.loadStateInOriginatorFromMemento(originator); //undoing the setting, by retrieving the old state, from the Memento, into the Originator object
        System.out.println("State successfully restored! "+originator);
    }
}
/*
Memento Pattern is a way of saving state from an Originator object into a Memento Object in order to let the Originator restore
this state when it needs to be reconstructed or undo any of its operations (related to that state). The state of the Originator 
is saved in a Memento Object, instead of at the Originator itself, but without breaking the encapsulation of the state, that is, 
without letting other objects, different from the respective Originator, manipulate it (especially alter it). The Memento, thus, 
can only have its state altered from the Originator it came from, not from any other object. For decoupling the Originator class
from the Memento Class, it is proposed a CareTaker Class, whose object role is to notify the Originator to create the Memento 
from its current state, passing it for the CareTaker object to store, and, when and if the Originator asks, to send this old state 
back to the Originator for this to get its state back and set as the current one, undoing any previous existing state. The saving 
and restoring processes can be executed manually or automatedly, from some conditions at the Originator or from outside it that 
would notify the CareTaker to save or restore these states. With Java, though, there's no way for avoiding other objects from 
calling the public getState() of the Memento, a method that is needed to be publicly called from the Originator during the restoring 
process, but is also accessible from other objects, as the CareTaker itself or any other. There is no way to set this method public 
only for a certain user class (Originator) and not to others. That's why the encapsulation through this Pattern is not perfect when 
implemented with some languages, but it can protect the Memento state at least from being altered (by not turning available a setState()
method (only a getState() one). In some languages, as in C++, it would be possible to set a "friendly class" at the Memento class 
whose object would be the only one to be able to see the public getState() method at the Memento class, but that does not exist in Java 
- all objects can see and access all public methods of any imported class. Because of that, the setting of the State at the Memento
must be done only through its constructor, when it is created at the Originator. Every time some Originator state has to be saved, a
new Memento object must be created, and temporarily stored at the CareTaker. It could be saved only the last or a defined number of 
previous multiple states, and there could also be a link to some DBMS, for storing the states in a database.

"Without violating encapsulation, capture and externalize an object's internal state so that the object can be restored to this 
state later."
"A memento is an object that stores a snapshot of the internal state of another object — the memento's originator. The undo mechanism 
will request a memento from the originator when it needs to checkpoint the originator's state. The originator initializes the memento 
with information that characterizes its current state. Only the originator can store and retrieve information from the memento — the 
memento is "opaque" to other objects."
(Design Patterns: Elements of Reusable Object-Oriented Software, 1994)
*/
