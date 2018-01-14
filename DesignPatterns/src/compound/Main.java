package compound;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        StrategyInterface player1 = new ControllerStrategy(model, new Player("PLAYER_1", 5,1000));
        StrategyInterface player2 = new ControllerStrategy(model, new Player("PLAYER_2", 3,3));
        StrategyInterface player3 = new ControllerStrategy(model, new Player("PLAYER_3", 2,5));
        player3.unRegisterThisObserver();
//        player3.registerThisObserver();
        ViewComponentConcreteFactory.createJWindowIntro();
    }
}

/*
An example of Compound Pattern where MVC is implemented using Observer, Strategy and AbstractFactory 
Patterns combined (and Composite, implicitly and internally, when updating the frame JComponents). 
There are actually two Models, one of which is the Subject of the Observer Pattern (Model class), that 
is triggered by the Controller to notify the View (Observer) every time a number panel is clicked, so that 
the View can update itself for that action (showing the answer to the user and updating the frame, excluding
that number panel). The other Model is the Player class, that stores and manages the individual state for 
each player, while the Model class itself deals with the collective states, and communicates with the Player 
class, BUT NOT with the Controller or View classes, not being aware of any of those.
The View, instead of creating and dealing with updates or view endings, delegates these functions to the 
ViewComponentConcreteFactory. In this app there is no need for the View to communicate with the Controller
(set and get state) or Models (get state only) directly, although that would be acceptable. The ViewFactory
is also part of the View and receives a reference for communication with the Controller, through which it
can set and get Model states indirectly (it could get, but not set, Model state directly, though).
The Controller, in turn, deals with the management of the View requests, delegating to the Model class the 
the notification of the Observers, the getTime command (at the Model side - which could be a distant server with 
a Remote Proxy Pattern implemented), as well as the whole logic of the game (Model and Player model classes). 
The Controller is responsible for creating its own View and passing it a ViewComponentConcreteFactory for it to use. 
Each Controller, or each Strategy, would define its own View interface and the logic regarding requests and 
delegation to and from the models. The only logic the View manages is the logic of its own interface components, 
the logic of the user interface. The logic of the game, otherwise, is treated by the Model classes... which, 
among other things, count the number panels clicked until a maximum and predefined number, requesting the View 
to be disposed when that limit is reached. The Models also store and manage the JPanels clicked and its labelTexts,
for sending them to the View or for the console when it is needed.
A much better logic could be designed for a real game. Anyway, Models can be changed for a new game logic, and 
the Strategy or the view factory - or both - could also be changed for better View designs and new communication control,
being possible for the Model classes to be reused.
Other Patterns, as Adapter, Facade or Decorator could be used with the Controller and Models, and State Pattern with 
the Models. A better design and organization for the factory components creation could be proposed. SwingWorker could
be extended for multithreading.
More generally speaking, in MVC, a view is responsible for the View creation and design; the controller is responsible 
for the logic regarding the answers to the view requests and for calling the model accordingly, changing and getting 
the Model state; and the Model is responsible for notifying the Observers its state has changed so that the View itself 
can pull the new state from the Model (or receive a push object to use - or ask the COntroller for it). The View is not 
supposed to change Model state, only get it. Thus, a Facade model could be used with the Model to omit any methods the View could 
use to change the state of the Model, letting visible only the methods to pull the state back when the View is notified this 
state has changed. If the View can directly get Model state without Controller mediation, the Controller could not be considered 
a Mediator Pattern (in the present app it is! View, here, never calls Models directly). The purpose of this Swing MVC desktop 
app is only to show that MVC is a kind of Compound Pattern that uses Observer, Strategy and Composite Patterns (and eventually 
others) while organizing the Model, View and Controller classes separately and appropriately.
After Web popularization, the MVC Pattern has been adapted to not only design desktop (Swing) or mobile apps, but to
create Web apps using APIs with these Patterns implicitly. And MVC started being called Model2 after that adaptation.
On the Web Model2, the View is the HTML(JSP) page which sends requests to its Strategy Controller (Servlet), which
is interchangeable with other Servlets and responsible for managing View requests, delegating most of the app logic to 
the Model. The Controller makes state changes on the Model (which can be reused from desktop apps without any 
modification) and, by setting these new states at a bean, for instance, dispatches this bean with the new model states 
to the View, as a push notification. The View, on the other hand, has the Composite Pattern implicitly implemented at 
the HTML page generation and update, on the client browser, after getting the HTTP response from the Controller, at the 
Server, over the internet.
*/
