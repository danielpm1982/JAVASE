package prototype;
public class Main {
    public static void main(String[] args) {
        CoordinatesPrototypeRegistry registry = CoordinatesPrototypeRegistry.getInstance();
        int type2D=0;
        int type3D=0;
        for (int i=0;i<100;i++){
            CoordinatesGenericInterface tempCoordinate = registry.getGenericCoordinates();
            if(tempCoordinate instanceof Coordinates2DInterface){
                type2D++;
            } else if(tempCoordinate instanceof Coordinates3DInterface){
                type3D++;
            }
            System.out.println(tempCoordinate);
        }
        System.out.println("TOTAL 2D cloned coordinates: "+type2D);
        System.out.println("TOTAL 3D cloned coordinates: "+type3D);
        System.out.println("TOTAL cloned coordinates: "+(type2D+type3D));
    }
}

/*
Prototype is a Creational Pattern where new objects are not instantiated, but cloned from Prototype classes
stored in a Registry (with Object method super.clone()). Each Prototype class must implement Cloneable interface 
and turn available a method GenericInterface getClone() for a Registry method to call, returning a generic cloned 
object to the Client, who will not easily know which class type that clone is from. At the prototype getClone() method,
one should call super.clone() or this.clone() method and then cast it back to the type the clone is supposed to be 
returned. This Pattern hides the complexities of creating new instances from the Client, allows the Client to get not 
known type instances in eventually a big number, and can be more efficient than creating instances with Constructors. It 
is especially useful for creating a big number of object types with complex class hierarchies, or when classes have to be 
created at runtime, dynamically, based on changing prototype structure or values, or when the new instances are very 
similar to existing ones, etc. But care should be taken when deciding to consider a shallow copy or a deep copy.
The example here takes as prototypes two types of coordinates (2D and 3D), aggregate them at the Registry class and
gets from the Registry getGenericCoordinates() method the cloned instances, produced from one of the two prototypes
randomly. The type returned is a GenericInterface so that the Client doesn't have to know easily which type his
new object has been cloned from, decoupling most of the complexicity from the Client layer. The Client just creates
a Registry and get Generic Coordinates from it, knowing nothing about its creation or real type. Then, if he has to
change any state on that object, or call any specific method, he can use instanceof operator and make a downcast to 
the correct concrete type and use its set and get methods. If the GenericInterface has the methods he may need, no casting 
should be necessary, though.

"Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype."
(Design Patterns: Elements of Reusable Object-Oriented Software, 1994)
*/
