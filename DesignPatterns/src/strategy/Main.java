package strategy;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Dog(LocalDate.now(),"dogA2","ownerA2","Canis lupus","Retriever","yellowish", "a2@gmail.com","999-A2");
        
        Animal a3 = new Cat();
        Animal a4 = new Cat(LocalDate.now(),"catA4","ownerA4","Felis catus","Brazilian Shorthair","whiteAndGrey", "a4@hotmail.com","555-A4");

        a2.communicateGeneric();
        a2.moveGeneric();
        a2.eatDrinkGeneric();
        a2.setCommunicate(new Communicate1());
        a2.setMove(new Move3());
        a2.setEatDrink(new EatDrink2());
        a2.communicateGeneric();
        a2.moveGeneric();
        a2.eatDrinkGeneric();
        a2.setMove(new Move2());
        a2.setEatDrink(new EatDrink1());
        a2.communicateGeneric();
        a2.moveGeneric();
        a2.eatDrinkGeneric();
        
        System.out.println("");
        
        a4.communicateGeneric();
        a4.moveGeneric();
        a4.eatDrinkGeneric();
        a4.setCommunicate(new Communicate2());
        a4.setMove(new Move1());
        a4.setEatDrink(new EatDrink1());
        a4.communicateGeneric();
        a4.moveGeneric();
        a4.eatDrinkGeneric();
        a4.setCommunicate(new Communicate2());
        a4.setMove(new Move5());
        a4.setEatDrink(new EatDrink2());
        a4.communicateGeneric();
        a4.moveGeneric();
        a4.eatDrinkGeneric();
        
        System.out.println("");

        /*
        Strategy Pattern has been used in order to uncouple the changeable behavior of the animals 
        from the entity classes, with two main advantages: 1) the complete separate algorithmic hierarchy 
        can be modified in its implementation without a single change in the entity classes, as the 
        behavior implementation is delegated completely to these other separate classes using aggregation 
        and polymorphism; 2) the entity classes can dynamically change the actual behavior to another existing one 
        (of the same interface), only by changing the type of the instance to which the interface instance variable 
        refers to.
        
        "The Strategy Pattern deﬁnes a family of algorithms, encapsulates each one, and makes them interchangeable. 
        Strategy lets the algorithm vary independently from clients that use it." 
        (Head First, Design Patterns, 2004)
        */
    }    
}
