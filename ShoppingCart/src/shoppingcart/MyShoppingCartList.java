package shoppingcart;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class MyShoppingCartList implements ShoppingCart{
    private final List<Item> itemList;
    public MyShoppingCartList() {
        itemList=new ArrayList<>();
    }
    @Override
    public Item addItem(Product product, Integer amount) {
        Item item = new Item(product, amount);
        itemList.add(item);
        return item;
    }
    @Override
    public Collection<Product> getProductsOrderByNameAsc() {
        return Collections.unmodifiableList(itemList.stream().map(Item::getProduct).parallel().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList()));
    }
    @Override
    public Iterator<Item> getItems() {
        return itemList.iterator();
    }
    @Override
    public void removeItemByProductId(Integer productId) {
        List<Item> itemListToRemove = itemList.stream().parallel().filter(x->x.getProduct().getId().equals(productId)).collect(Collectors.toList());
        itemList.removeAll(itemListToRemove);
    }
    @Override
    public Double getTotal() {
//        return itemList.stream().map(x->x.getAmount()*x.getProduct().getPrice()).mapToDouble(Double::doubleValue).sum();
        return itemList.stream().map(x->x.getAmount()*x.getProduct().getPrice()).reduce(0.0, (a,b)->a+b);
    }
}
