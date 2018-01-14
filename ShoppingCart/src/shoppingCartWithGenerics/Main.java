package shoppingCartWithGenerics;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //List implemented Cart
        System.err.println("List implemented cart test:");
        MyShoppingCartList<Product,Item> cart = new MyShoppingCartList<>();
        //P and I parameter types of MyShoppingCartList<P,I>(above) must be a supertypes of ALL products and items added, in order to internal generics casts to work.
        //P and I could be <Product, Item> or any subtype of these, so that they're compatible with the types of products and items allowed to be added. If parameter-type field is not used, Object will be the chosen type. And the results (returning values), as the entrances (added values), will not be type-specific (manual castings would be necessary for any specific manipulation of any returning value).
        //For <Product, ?>, all two Product types are allowed. For <ProductChild, ?>, only ProductChild types will work.
        //For <?, Item>, all three Item types are allowed. For <?, ItemChild>, only ItemChild and ItemGrandChild are allowed. And for <?, ItemGrandChild>, only ItemGrandChild type items will work.
        //The outest class (in this case, the Main) must decide the types. Inner (used) generic classes must support any type chosen, as long as the interface signatures contracts are obeyed - in this case, <P extends Product, I extends Item> constrains all possible P and I types.
        System.err.println("List created!");
        //creating multiple-type products
        System.err.println("Creating products test:");
        Product p1 = new Product(Integer.MAX_VALUE, "prod1", 50.00); //adds a Product type
        ProductChild p2 = new ProductChild(Integer.MAX_VALUE-1, "prod2", 250.00,"supplier2"); //adds a ProductChild type
        ProductChild p3 = new ProductChild(Integer.MAX_VALUE-2, "prod3", 20.00,"supplier3"); //adds a ProductChild type
        System.err.println("Products created!");
        //creating and adding multiple-type items (with above products embedded)
        System.err.println("Creating and adding items to list (addItem()) test:");
        System.out.println(cart.addItem(p3, 1)+" added!"); //internally adds a Item type
        System.out.println(cart.addItem(p3, 3, ItemPriority.HIGH)+" added!"); //internally adds a ItemChild type
        System.out.println(cart.addItem(p3, 2, ItemPriority.HIGH, new Client("client1", 123L))+" added!"); //internally adds a ItemGrandChild type
        System.out.println(cart.addItem(p1, 10)+" added!");
        System.out.println(cart.addItem(p1, 3, ItemPriority.LOW)+" added!");
        System.out.println(cart.addItem(p1, 8, ItemPriority.HIGH, new Client("client2", 456L))+" added!");
        System.out.println(cart.addItem(p2, 7)+" added!");
        System.out.println(cart.addItem(p2, 1, ItemPriority.HIGH)+" added!");
        System.out.println(cart.addItem(p2, 4, ItemPriority.LOW, new Client("client3", 789L))+" added!");
        Thread.sleep(500);
        System.err.println("Getting items (getItems()) test:");
        cart.getItems().forEachRemaining(System.out::println);
        Thread.sleep(500);
        System.err.println("Getting distinct products ordered by name ascending (getProductsOrderByNameAsc()) test:");
        cart.getProductsOrderByNameAsc().forEach(System.out::println);
        Thread.sleep(500);
        System.err.println("Getting total cart items price (getTotal()) test:");
        System.out.println("Total price for all items in the cart: $"+cart.getTotal());
        Thread.sleep(500);
        System.err.println("Removing item (removeItemByProductId()) test:");
        cart.removeItemByProductId(p3.getId());
        System.out.println(p3+" removed!");
        cart.removeItemByProductId(p2.getId());
        System.out.println(p2+" removed!");
        Thread.sleep(500);
        System.err.println("Getting items (getItems()) test:");
        cart.getItems().forEachRemaining(System.out::println);
        Thread.sleep(500);
        System.err.println("Getting total cart items price (getTotal()) test:");
        System.out.println("Total price for all items in the cart: "+cart.getTotal());
        System.out.println("\n");
    }
}
