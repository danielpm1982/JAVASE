package shoppingcart;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MyShoppingCartMap implements ShoppingCart{
    private final Map<Integer,Item> itemMap;
    private Integer itemKey;
    public MyShoppingCartMap() {
            itemMap=new HashMap<>();
            itemKey=-1;
    }
    @Override
    public Item addItem(Product product, Integer amount) {
            Item item = new Item(product, amount);
            itemMap.put(++itemKey, item);
            return item;
    }
    @Override
    public Collection<Product> getProductsOrderByNameAsc() {
        TreeSet<Product> orderedProductSet = new TreeSet<>(Comparator.comparing(Product::getName));
        orderedProductSet.addAll(itemMap.values().stream().map(Item::getProduct).collect(Collectors.toSet()));
        return Collections.unmodifiableSet(orderedProductSet);
    }
    @Override
    public Iterator<Item> getItems() {
            return itemMap.values().iterator();
    }
    @Override
    public void removeItemByProductId(Integer productId) {
        Set<Item> itemSetToRemove = itemMap.values().stream().parallel().filter(x->x.getProduct().getId().equals(productId)).collect(Collectors.toSet());
        itemMap.forEach((key,value)->{
            if(itemSetToRemove.contains(value)){
                itemMap.remove(key);
            }
        });
    }
    @Override
    public Double getTotal() {
//            return itemMap.values().stream().map(x->x.getAmount()*x.getProduct().getPrice()).mapToDouble(Double::doubleValue).sum();
        return itemMap.values().stream().map(x->x.getAmount()*x.getProduct().getPrice()).reduce(0.0, (a,b)->a+b);
    }
}
