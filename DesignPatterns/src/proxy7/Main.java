package proxy7;

public class Main {
    public static void main(String[] args) {
        SubjectInterface proxy = new Proxy(MyJFrame.getInstance("VirtualProxy"));
        proxy.doSomething();
    }
}

/*
In this VirtualProxy, a temporary message is returned to the user while he waits the image to load.
At the Proxy class, if the image is not ready to display (i.e., Subject not instantiated, with a null 
reference), the algorithm sets a temporary message telling that to the user. And instantiates the Subject.
When it finishes instantiating, the same interface method is called again, recursively, and now the 
algorithm detects that the reference to the Subject is not null anymore, so, instead of calling the same 
block called before, now it calls the block of the condition that delegates the call to the instantiated 
Subject. At the Subject class, the interface method updates the frame and substitutes the temporary message 
with the desired image.
So, the first interface method call is for the Proxy (at the Main class), but the second, after the
Proxy creates the Subject, is delegated to the same method but at this other class, the RealSubject one.
In this example, most time is expended at the instantiation of the Subject, when, at its Constructor, 
the VERY BIG image (74MP; 30MB) is loaded and resized to the initial size of the frame. After this critical time, 
the delegation only happens to call the update of the frame contentpane with that image label already created. 
It's also been added a WindowState listener that recreates (for the new size) and updates the frame contentpane 
with a new image and label after maximizing or restoring the frame size. But here, the temporary message has 
not been set to appear as at the beginning of the program.
A 10s time was added to the Constructor of the Subject to simulate a longer loading time (an internet loading, 
for instance).
*/
