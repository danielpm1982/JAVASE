package singleton;
public class Main {
    public static void main(String[] args) {
        System.out.println(SingletonClassLazy.getInstance());
        System.out.println(SingletonClassEager.getInstance());
    }
}

/*
Singleton Pattern Classes are implemented using a private Constructor that
is called by an static public method in the same class, and the instance 
associated with a private static variable that is returned to the client.
For thread safe protection, three forms are presented:
- the most simple one is to make the class generate an eager instance,
which is garanteed to be created before any class method call can be done, by
one or by more threads - and after instantiation no thread problems would arise;
- another way is to make the public static getInstance() method synchronized,
which is simple but produces an unecessary cost from the second to the rest of
the lifecycle calls, as the instantiation will be done only once at the first 
successful calling, and no thread issues would be possible, and no thread treament
would be necessary, after the instantiation is done;
- the other and third way would be to make a two-step check, and make only the
inner block synchronized if the instantiation is really to be done, but not
at other times.

Obs1.: multiple classloaders can break the thread safeness;
obs2.: JVMs before version 1.5 do not garantee thread safeness for the double 
check implementation;
obs3.: JVMs before version 1.2 may have garbage collector problems, and collect
the singleton instance away, as false garbage.
*/