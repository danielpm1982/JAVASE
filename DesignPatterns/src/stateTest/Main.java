package stateTest;
import state.Context;

public class Main {
    public static void main(String[] args) {
        Context context = Context.getInstance();
        context.printCurrentState();
        context.actionTurnOff();
        context.actionTurnOn(); //go to state A
        context.printCurrentState();
        context.actionTurnOn(); //does nothing
        context.actionChangeToNextState(); //go to state B
        context.printCurrentState();
        context.actionTurnOff(); //go to state Off
        context.actionChangeToNextState(); //go to state A
        context.actionChangeToNextState(); //go to state B
        context.actionChangeToNextState(); //go to state C
        context.printCurrentState();
        context.actionTurnOff(); //go to state Off
        context.printCurrentState();
    }
}

/*
State Pattern is similar to Strategy Pattern, having the same UML structure but different semantic meaning.
Both have a main Context class that composes with other classes (State or Strategy interfaced ones) that 
encapsulate the changeable behavior and algorithms, favoring the open closed principle in regard to the main
Context class. At the Context class, the composed classes are referred by an instance variable of the type
of the interface (State or Strategy), and the calls to the actions are done by delegating to the composed
instances the same call... each instance then, whether a State type or Strategy type, assumes the responsibility
of executing each action according to each specific algorithm, and, at the Context class level (as the instance
variable is oriented to the interface) these different behaviors are interchangeable as the instances of one same
interface type. 

In the case of the Strategy Pattern, there is the Strategy specific classes that are composed
with one or more Context classes, with one or more instances of each, and it is expected some configured correspondence
between the specific behavior and each respective Context class (e.g. a Context Dog with a certain Communication 
Strategy type - Bark, for instance), although changes can be done in order to change the Strategy instance composed 
to one certain Context so that that Context would change its behavior to another one (according to the new instance). 
It's kind of an alternative for delegating the behavior implementation to other classes without using inheritance 
(as done with TemplateMethod Pattern), but composition instead. It's not the rule though that these Strategy instances,
associated to the Strategy instance variable at the Context class, would change over time, although it is possible.
Also, at the Strategy Pattern, the client knows the Stratgy classes and generally it is the client who creates them and
offer them for the Context to make use.

With the State Pattern, on the other hand, the intention changes. That is, there is usually a single Context class
(with on or more instances) that composes with multiple states represented by State interfaced classes, whose objects 
are referred by a State single instance variable at the Context class, for instance, "state" variable. The actions
the user calls on the Context object are, as expected, delegated to the same action methods at the state objects, 
according to each current state (instance) associated to the instance state variable at each time. Each State class 
takes the responsibility of implementing its action methods, as well as, if it is the case, the logic for the flux 
of state change: each method executes its own algorithm and changes the state at the Context instance state variable to
another state (instance). On the next user call, the calling will be delegated then to this last state class (object) 
and so on. The State objects can be shared with the multiple Context instances, provided that no state is kept inside 
each State object (only the behavior and state flux logic), only at each Context. If the State, itself, should be one 
for all Contexts, it should be referred by an static variable of that Context, and the access from each Context instance 
should be synchronized.

With State Pattern we're dealing with one thing (Context class) that has multiple states, and these states will
certainly change over time, along with the algorithmic cycle, so that each different behaviour, for each different action,
at each different state class, takes place. The client knows very little or nothing of the states and transitions, or
the logic associated to the state changing. The client only calls the actions and the Context class, along with the State
classes, decide and elaborate the response.

The flux control for the state changing can be done at the State classes (inside the algorithm for each action call) or
it can reside as a responsibility of the Context class, leaving to the State classes only the action algorithm implementation
but not the decision about the changing of state. For more flexibility and extensibility this flux control should be
where the changeable code would be, at the State classes, but, if it is not supposed to change, and is a fixed flux,
then it could be left as a responsibility of Context class itself.

The tradeoff of augmenting on the number of classes, compared to procedural implementations (one only class with all states, 
actions and state transitions together), could be managed by turning the methods at the Context (gets and sets of the states)
to package visibility, so that every internal method, state and various State classes would be transparent to the user, except
the public action calls.
Extensibility and maintainability would be greatly improved with the State Pattern. For adding a new State and state changing
logic, a new State class would be called and, at the Context level, only a new field, for that new instance type, would have
to be added, its object instantiated and the respective get method be added. The rest of the Context code would remain unchanged.
The maintaining for the action algorithms, as well as the state flux logic, would be restricted to the each State class where
they're encapsulated, nothing would have to be changed at the Context.

Strategy Pattern
"Encapsulate interchangeable behaviors and use delegation to decide which behavior to use."
"The Strategy Pattern deﬁnes a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy 
lets the algorithm vary independently from clients that use it."

State Pattern
"Encapsulate state-based behavior and delegate behavior to the current state."
"The State Pattern allows an object to alter its behavior when its internal state changes. The object will appear to 
change its class."
*/
