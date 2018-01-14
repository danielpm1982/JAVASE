import java.util.stream.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class SupplyStreamClass {
    public static Stream<String> getPersonNameStream(){
        Person[] personArray = {new Person("daniel@"),new Person("Juliana"),new Person("Tina"),new Person("bosco"),new Person("luke")};
        return Stream.of(personArray).map(Person::getName);
    }
}
