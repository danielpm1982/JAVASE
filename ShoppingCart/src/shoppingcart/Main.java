package shoppingcart;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //creating Products
        Product p1 = new Product(Integer.MAX_VALUE, "prod1", 50.00);
        Product p2 = new Product(Integer.MAX_VALUE-1, "prod2", 250.00);
        Product p3 = new Product(Integer.MAX_VALUE-2, "prod3", 20.00);
        
        //List implemented Cart
        System.err.println("List implemented Cart test:");
        ShoppingCart cart = new MyShoppingCartList();
        System.err.println("addItem() test:");
        System.out.println(cart.addItem(p3, 1)+" added!");
        System.out.println(cart.addItem(p1, 10)+" added!");
        System.out.println(cart.addItem(p2, 5)+" added!");
        Thread.sleep(500);
        System.err.println("getItems() test:");
        cart.getItems().forEachRemaining(System.out::println);
        Thread.sleep(500);
        System.err.println("getProductsOrderByNameAsc() test:");
        cart.getProductsOrderByNameAsc().forEach(System.out::println);
        Thread.sleep(500);
        System.err.println("getTotal() test:");
        System.out.println("Total price for all items in the cart: $"+cart.getTotal());
        Thread.sleep(500);
        System.err.println("removeItemByProductId() test:");
        cart.removeItemByProductId(p3.getId());
        System.out.println(p3+" removed!");
        cart.removeItemByProductId(p2.getId());
        System.out.println(p2+" removed!");
        Thread.sleep(500);
        System.err.println("getItems() test:");
        cart.getItems().forEachRemaining(System.out::println);
        Thread.sleep(500);
        System.err.println("getTotal() test:");
        System.out.println("Total price for all items in the cart: "+cart.getTotal());
        System.out.println("\n");
        
        //Set implemented Cart
        System.err.println("Set implemented Cart2 test:");
        ShoppingCart cart2 = new MyShoppingCartSet();
        System.err.println("addItem() test:");
        System.out.println(cart2.addItem(p3, 1)+" added!");
        System.out.println(cart2.addItem(p1, 10)+" added!");
        System.out.println(cart2.addItem(p2, 5)+" added!");
        Thread.sleep(500);
        System.err.println("getItems() test:");
        cart2.getItems().forEachRemaining(System.out::println);
        Thread.sleep(500);
        System.err.println("getProductsOrderByNameAsc() test:");
        cart2.getProductsOrderByNameAsc().forEach(System.out::println);
        Thread.sleep(500);
        System.err.println("getTotal() test:");
        System.out.println("Total price for all items in the cart: $"+cart2.getTotal());
        Thread.sleep(500);
        System.err.println("removeItemByProductId() test:");
        cart2.removeItemByProductId(p3.getId());
        System.out.println(p3+" removed!");
        cart2.removeItemByProductId(p2.getId());
        System.out.println(p2+" removed!");
        Thread.sleep(500);
        System.err.println("getItems() test:");
        cart2.getItems().forEachRemaining(System.out::println);
        Thread.sleep(500);
        System.err.println("getTotal() test:");
        System.out.println("Total price for all items in the cart: "+cart2.getTotal());
        System.out.println("\n");
        
        //Map implemented Cart
        System.err.println("Map implemented Cart3 test:");
        ShoppingCart cart3 = new MyShoppingCartSet();
        System.err.println("addItem() test:");
        System.out.println(cart3.addItem(p3, 1)+" added!");
        System.out.println(cart3.addItem(p1, 10)+" added!");
        System.out.println(cart3.addItem(p2, 5)+" added!");
        Thread.sleep(500);
        System.err.println("getItems() test:");
        cart3.getItems().forEachRemaining(System.out::println);
        Thread.sleep(500);
        System.err.println("getProductsOrderByNameAsc() test:");
        cart3.getProductsOrderByNameAsc().forEach(System.out::println);
        Thread.sleep(500);
        System.err.println("getTotal() test:");
        System.out.println("Total price for all items in the cart: $"+cart3.getTotal());
        Thread.sleep(500);
        System.err.println("removeItemByProductId() test:");
        cart3.removeItemByProductId(p3.getId());
        System.out.println(p3+" removed!");
        cart3.removeItemByProductId(p2.getId());
        System.out.println(p2+" removed!");
        Thread.sleep(500);
        System.err.println("getItems() test:");
        cart3.getItems().forEachRemaining(System.out::println);
        Thread.sleep(500);
        System.err.println("getTotal() test:");
        System.out.println("Total price for all items in the cart: "+cart3.getTotal());
        System.out.println("\n");
    }
}
