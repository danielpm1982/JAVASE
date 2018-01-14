package shoppingcart;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MyShoppingCartSet implements ShoppingCart{
    private final Set<Item> itemSet;
    public MyShoppingCartSet() {
        itemSet=new HashSet<>();
    }
    @Override
    public Item addItem(Product product, Integer amount) {
        Item item = new Item(product, amount);
        itemSet.add(item);
        return item;
    }
    @Override
    public Collection<Product> getProductsOrderByNameAsc() {
        TreeSet<Product> orderedProductSet = new TreeSet<>(Comparator.comparing(Product::getName));
        orderedProductSet.addAll(itemSet.stream().map(Item::getProduct).collect(Collectors.toSet()));
        return Collections.unmodifiableSet(orderedProductSet);
    }
    @Override
    public Iterator<Item> getItems() {
        return itemSet.iterator();
    }
    @Override
    public void removeItemByProductId(Integer productId) {
        Set<Item> itemSetToRemove = itemSet.stream().parallel().filter(x->x.getProduct().getId().equals(productId)).collect(Collectors.toSet());
        itemSet.removeAll(itemSetToRemove);
    }
    @Override
    public Double getTotal() {
//            return itemSet.stream().map(x->x.getAmount()*x.getProduct().getPrice()).mapToDouble(Double::doubleValue).sum();
        return itemSet.stream().map(x->x.getAmount()*x.getProduct().getPrice()).reduce(0.0, (a,b)->a+b);
    }
}
