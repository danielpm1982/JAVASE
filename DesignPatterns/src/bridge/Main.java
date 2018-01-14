package bridge;
public class Main {
    public static void main(String[] args) {
        TVInterface tvA = new TVA();
        TVInterface tvB = new TVB();
        RemoteControlIntreface remote1 = new Remote1Son(tvA);
        RemoteControlIntreface remote2 = new Remote2(tvB);
        remote1.on();
        remote1.setChannel(180);
        remote1.setChannel(50);
        remote1.nextChannel();
        remote1.previousChannel();
        ((Remote1Son)remote1).nextChannelMulti();
        ((Remote1Son)remote1).nextChannelMulti();
        ((Remote1Son)remote1).nextChannelMulti();
        remote1.off();
        remote2.on();
        remote2.setChannel(100);
        remote2.setChannel(10);
        remote2.nextChannel();
        remote2.previousChannel();
        remote2.off();
    }
}

/*
Related to Strategy and Adapter Patterns, the Bridge Pattern has a different intent, which is to
separate and decouple the implementation core of an API from its interface accessed by the client,
so that both hierarchies can change and evolve independently and with no need for the client to
know anything about the core implementation. The "bridge" is the composed bond between an instance
of the concrete implementation hierarchy and the abstract user interface hierarchy (referring the 
instance through an instance variable - field).
In this case, the TV hierarchy is the implementation core, that may change independently, according
to each concrete TV implementation; whereas the Remote hierarchy is the abstraction part, the part
the client has access to, and that can also change independently according to different remote control
interface, provided that ALL functional methods the abstraction hierarchy implements is delegated to
the instance of the TV passed, including new methods (that should always rely on the methods implemented
by the TV implementation). That way, the implementation is separated and decoupled from the abstraction, 
the user interface. Any subclasses of the abstraction should use the abstraction implementation (that 
delegates the call to the TV instance variable), as in the nextChannelMulti() method of the Remote1Son 
class.

"Decouple an abstraction from its implementation so that the two can vary independently."
(Design Patterns: Elements of Reusable Object-Oriented Software, 1994)

*/
