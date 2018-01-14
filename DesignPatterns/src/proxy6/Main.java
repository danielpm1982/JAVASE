package proxy6;
public class Main {
    public static void main(String[] args) {
        SubjectInterface proxy = new Proxy();
        proxy.doSomething();
    }
}

/*
Simplest example of a VirtualProxy: while the Proxy instantiates an expensive to create Subject,
it offers a temporary response for the user, and when that Subject instance is created, another
response is obtained from the Subject object itself by delegation.
The VirtualProxy, here, may collaterally add behavior to the wrapped Subject, appearing to be
a Decorator Pattern, but it's not, as there is no Subject object at the first Proxy call, and
also because there's no composition (aggregation) as there is with Decorator Pattern. The Subject
is created, not received from outside, and only after the first temp response has already been
given by the proxy to the client, not before. Actually, the whole concept is different, as the Proxy Pattern
intends to offer a way of controlling client access to the subject (either a remote Subject, or an expensive
instantiating Subject, or a Subject needing to be secured), and not simply add behavior.
*/
