package observer;

public class Main {
    public static void main(String[] args) {
        Observable weatherStation = new Observable();
        Observer observer1 = new Observer1(weatherStation);
        Observer observer2 = new Observer2(weatherStation);
        Observer observer3 = new Observer3(weatherStation);
        weatherStation.setData(25, 50, 80, "30 SE", "Cloudy"); System.out.println("");
        weatherStation.unregisterObserver(observer2);
        weatherStation.unregisterObserver(observer3);
        weatherStation.setData(32, 150, 75, "12 NE", "Rainy");  System.out.println("");
        weatherStation.registerObserver(observer2);
        weatherStation.registerObserver(observer3);
        weatherStation.setData(7, 120, 45, "10 NNE", "Clear");  System.out.println("");
    }
}

/*
Each Observer is registered to a Observable automatically as created, and can be unregistered later if necessary.
For those Observers registered, the Observable notifies (updates) their data, by PUSH or PULL, each time this
data is altered (set) at the Observable at wihch each Observer is registered.
PUSH or PULL options are selected according to the notifying/update method called (with or without a not null DataObject).

"The Observer Pattern deﬁnes a one-to-many dependency between objects so that when one object changes state, 
all of its dependents are notiﬁed and updated automatically." 
(Head First, Design Patterns, 2004)
*/
