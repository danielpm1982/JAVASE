package builder;

public class Main {
    public static void main(String[] args) {
        RequestControl requestControl = new RequestControl();
        // passing invalid parameter arguments for testing exception handling
//        try{
//            requestControl.constructProduct();
//        } catch(InstantiationException ex){
//            ex.printStackTrace(System.out);
//        }
        // passing valid parameter arguments for creating and storing Products
        try{
            requestControl.constructProduct("abc", "0", "10");
            requestControl.constructProduct("abc", "0");
            requestControl.constructProduct("abc");
            requestControl.constructProduct("def", "1", "1");
            requestControl.constructProduct("def");
            requestControl.constructProduct("ghi", "10", "0");
            requestControl.changeBuilder(new ConcreteBuilderAnother());
            requestControl.constructProduct("50", "100", "200");
        } catch(InstantiationException ex){
            ex.printStackTrace(System.out);
        }
        // showing (requestNumber + Product) Map
        requestControl.getProductMap().forEach((x,y)->System.out.println("Request: "+x+" "+y));
        System.out.println("Application Ended!");
        System.out.println();
    }
}

/*
Builder Pattern is a creational Pattern that, similar to the others, encapsulate inside an Object
the creation of a requested Product, decoupling it from the client classes, but, differently from 
the other Patterns in this category, and before the creation takes place, other methods at the Builder 
class are called to, in a multistep way, set all parameter values (or component objects) that will be 
used to create the final Product, allowing the process of creation to vary, depending on the intermediate 
methods called. And, as the Builder has an interface, different concrete Builders can be changed without
affecting the rest of the code. Specially used for the creation of complex and composite Objects.
In this example, the ConcreteBuilder encapsulates the creation of 3 different Products of the same 
interface, depending on the number of valid parameter values passed. Before the method of the builder
that actually instantiates the Product is called, though, each of the 3 types of attributes are built, 
separately, and then passed as parameter values at the getFinalProduct() method. If the 3 attributes
are successfully built, Product1 is instantiated; if only the first two attributes are successfully built,
Product2 is built; if only the first attribute is successfully built, Product3 is created; and if no
valid attributes combination is passed, an InstantiationException is thrown. The type of the values
passed by the final user are all String, that are transformed to the real Object (or primitive) correct
types at the attribute building phase. The RequestControl class (the UML Director class), other than 
returning the single Product each time its constructProduct() method is called, stores a Map with all 
created and not created Products, together with the respective requesting number (automatically generated), 
as the key. The final user can, this way, after creating all Products, get a Map with all Products created 
(and not created) and list them. Or using them individually at each construct request.
Later, another Builder was created for building the Product4, and a method at the RequestControl was added
for changing the Builder being used (by default, the ConcreteBuilder). After changing the Builder to 
ConcreteBuilderAnother one can create thus the Product4, with totally different parameter values and intermediate
object types, through the same method at the RequestControl class - constructProduct(String att1, String att2, 
String att3) and Main class call - with completed different Products returned. If the Product4 demanded another 
creating method signature, one that could not be reused from the methods within original RequestControl, the 
new method could be added or another RequestControl could be created especifically for the new Products (with 
that new method signature). 
None of the 4 Products had nulls allowed as their Constructor parameter values.
The fact is the final Product can be iteratively constructed, by the separate construction of each of its
components (partial objects or primitives), and this intermediate construction may vary according to any criteria 
defined at the concrete Builder code, without affecting the rest of the app (if the signatures of the creation 
methods are the same). And it is possible to have more than one concrete Builder composed with the RequestControl 
class, or a dynamic change on the builder being used, at runtime. This Pattern demands more client domain knowledge, 
because he does have to know that some component attributes (components) have to be created before he calls the 
creation method itself. Although it can be minimized using controlling intermediate classes (intermediate client 
classes), as RequestControl, in this example.

"Separate the construction of a complex object from its representation so that the same construction process can 
create different representations."
(Design Patterns: Elements of Reusable Object-Oriented Software, 1994)
*/
