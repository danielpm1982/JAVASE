package chainOfResponsability;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RequestInterface request1 = createRequest(RequestType.Type5);
        System.out.println("Sending request1 ("+request1.getType()+")...");
        sendRequest(request1);
        RequestInterface request2 = createRequest(RequestType.Type3);
        System.out.println("\nSending request2 ("+request2.getType()+")...");
        sendRequest(request2);
        RequestInterface request3 = createRequest(RequestType.Type0);
        System.out.println("\nSending request3 ("+request3.getType()+")...");
        sendRequest(request3);
        System.out.println("");
    }
    private static List<HandlerInterface> createChain(){
        List<HandlerInterface> chainList = new ArrayList<>();
        HandlerInterface handlerFinal = new HandlerFinal();
        chainList.add(handlerFinal);
        HandlerInterface handler3 = new Handler3(handlerFinal);
        chainList.add(handler3);
        HandlerInterface handler2 = new Handler2(handler3);
        chainList.add(handler2);
        HandlerInterface handler1 = new Handler1(handler2);
        chainList.add(handler1);
        HandlerInterface handlerInitial = new HandlerInitial(handler1);
        chainList.add(handlerInitial);
        return chainList;
    }
    private static RequestInterface createRequest(RequestType requestType){
        return new Request(requestType);
    }
    private static void sendRequest(RequestInterface request){
        List<HandlerInterface> chainList = createChain();
        HandlerInterface handlerInitial = chainList.stream().filter(x->x.toString().equals("HandlerInitial")).findAny().get();
        handlerInitial.handleRequest(request); //must start from the first node of the linked Object chain
    }
}

/*
ChainOfResponsability is a behavioral pattern that offers a chain of Handling objects that might
answer to a request the Client sends, after each Object analyzing and deciding to answer or to
pass on to the next registered and chained Object. All Handlers must make a contract with the
Handler interface in order to offer the handleRequest() method for the Client to call on a
generalized variable that will always refer to the first node Object of the chain. The Client
will never know (at least explicitly) which Handler has actually answered his call, and a final
Handler can be added to treat the requests that were not answered by any of the previous Handlers,
so that the request doesn't end up with any response at all. Decouples the sender and the receivers;
the sender doesn't have to know anything about the structure of the Chain, or even its existence;
the chain can be dynamically modified; specially useful with filtering requests to be answered by
some Object of the app (GUIs, http requests, etc).
In this example, Request types from 0 to 3 are answered respectively by the Initial, 1, 2 or 3 
Handlers, while HandlerFinal answers any type contained at the enum RequestType (0 through 5).

"Avoid coupling the sender of a request to its receiver by giving more than one object a chance to 
handle the request. Chain the receiving objects and pass the request along the chain until an object 
handles it."
(Design Patterns: Elements of Reusable Object-Oriented Software, 1994)
*/
