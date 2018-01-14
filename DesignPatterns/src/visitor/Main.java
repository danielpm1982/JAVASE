package visitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> log = new ArrayList<>();
        VisitorInterface visitor1 = new Visitor1(log);
        VisitorInterface visitor2 = new Visitor2(log);
        ElementInterface elementA = new ElementA("ElementAOriginalStateString!");
        ElementInterface elementB = new ElementB("ElementBOriginalStateString!");
        ElementInterface elementC = new ElementC("ElementCOriginalStateString!");
        List<ElementInterface> elementList = new ArrayList<>(Arrays.asList(new ElementInterface[]{elementA,elementB,elementC}));
        System.out.println("Original State:");
        elementList.forEach(System.out::println);
        elementList.forEach(x->x.accept(visitor1));
        elementList.forEach(x->x.accept(visitor2));
        System.out.println("Log of State Change:");
        log.forEach(System.out::println);
    }
}

/*
For using the Visitor Pattern, you must add a method (accept(VisitorInterface visitor)) to the interface of a data structure.
Through that method, in each concrete node, you pass a concrete instance of the Visitor Class to the concrete Element, 
polymorphically, and the Element, in return, and through dynamic link, can call, on the Visitor, a method (e.g. 
visitElementA(ElementA element)) asking for the Element node to be visited by that Visitor. After, that Visitor, which
was notified by the Element that would like to be visited, receiving the concrete instance of the Element, can call any
method (e.g. operationA(String string)) at, or get any state from, this Element, not depending more on the limitations of generic 
interfaces for access. These methods of the individual Element, that may ultimately be called by the Visitor, do not belong 
to the Element interface, thus, any number of Element methods can be added, or have its interface changed, without affecting 
the other nodes (Elements)... and the Visitor, as said, does not depend more on the methods declared at the Element's Interface 
and may call the specific methods of that specific Element directly (or get or change the state of only that Element), whose
specific instance it now possess.
That way, this Pattern is useful when dealing with complex structures, composed of many heterogeneous interfaces or methods,
and you want to perform operations not on common methods they might have, but on the methods from which they differ, through
a reference to each concrete node you want to call a method on (for reading or changing its state). If generalization had to
be used alone, every different method would have to be added to the interface and to all nodes (for the client - that deals only 
with the interface - to be able to call them), not only to the ones you wanted to call those new methods on. This pattern turns
possible to someone to add specific new methods to only one or another node of the structure and the Visitor still be able to 
call them (despite not declared on the interface), altering the structure only minimally (adding the new method at the specific 
node), but having to add a respective new method for all Visitors (which might be traumatic, also). 
Other than that, and as the main advantage of this Pattern, the Visitor also can add part of an algorithm on its own class, inside, 
for example, the method visitElementA(ElementA element), and only the part of the algorithm that is inside the operationA(String string) 
would be fixed for all Visitors. This way, even when considering the Elements' operations as fixed (at the Nodes), these could 
still have functionality added, and this changeable behavior would be encapsulated at each concrete Visitor class alone, instead of 
propagated unnecessarily to one or, much worse, for all nodes. In the best scenario, if no new method should be added for any Element, 
the Structure wouldn't change at all. Only one or more Visitors. A change on their own customized implementations of the methods that 
call the Elements' final operation methods (unchanged, in this case). More than one method could also be called at the Element.
With Visitor Pattern, for adding behavior, and that behavior be specific for each Visitor when calling certain Node method, only a 
new Visitor would be needed to the VisitorInterface hierarchy. Therefore, the Pattern is most appropriate when the Structure you're 
working on has few or no change necessity and only the Visitor hierarchy should vary for adding behavior to the each Element's call 
(at the Visitor side). If the nodes structure would have to change a lot, it probably would be better to put all the changeable
algorithm inside each node methods, and not more, partially, at the Visitor.
In this example, only a very simple List structure with 3 nodes (Elements) and a VisitorInterface with 3 Visitors have been used, 
but complex structure trees and complex Visitor hierarquies could have been used as well. And that is when this Patterns shows
its utility. The methods' algorithms, either in the Visitor or in each Node classes, also could be much complex than only setting
a String as a new Element state. And, as it was done here (with the log), generally there is an accumulation of states, while the 
Visitors traverse the Element's structure. And the biggest disadvantage of the Pattern is the eventual breaking of the encapsulation 
of the Structure, as the Elements have to return an instance of them to an outside class (Visitor) in order to have an internal state 
altered, and the operation method of that Element should care enough to avoid security or protection breaches.

"So the key consideration in applying the Visitor pattern is whether you are mostly likely to change the algorithm applied over an 
object structure or the classes of objects that make up the structure. The Visitor class hierarchy can be difficult to maintain when 
new ConcreteElement classes are added frequently. In such cases, it's probably easier just to define operations on the classes that 
make up the structure. If the Element class hierarchy is stable, but you are continually adding operations or changing algorithms, 
then the Visitor pattern will help you manage the changes."

"Represent an operation to be performed on the elements of an object structure. Visitor lets you define a new operation without changing 
the classes of the elements on which it operates."
(Design Patterns: Elements of Reusable Object-Oriented Software, 1994)
*/
