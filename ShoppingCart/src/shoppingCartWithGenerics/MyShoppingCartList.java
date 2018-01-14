package shoppingCartWithGenerics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class MyShoppingCartList<P extends Product, I extends Item> implements ShoppingCart<P, I>{
    private final List<I> itemList;
    public MyShoppingCartList() {
        itemList=new ArrayList<>();
    }
    @Override
    public I addItem(P product, Integer amount) {
        Item item = new Item(product, amount);
        itemList.add((I)item);
        return (I)item;
    }
    @Override
    public I addItem(P product, Integer amount, ItemPriority itemPriority) {
        ItemChild itemChild = new ItemChild(product, amount);
        itemChild.setItemPriority(itemPriority);
        itemList.add((I)itemChild);
        return (I)itemChild;
    }
    @Override
    public I addItem(P product, Integer amount, ItemPriority itemPriority, Client client) {
        ItemGrandChild itemGrandChild = new ItemGrandChild(product, amount);
        itemGrandChild.setItemPriority(itemPriority);
        itemGrandChild.setClient(client);
        itemList.add((I)itemGrandChild);
        return (I)itemGrandChild;
    }
    @Override
    public Collection<P> getProductsOrderByNameAsc() {
        return (List<P>)Collections.unmodifiableList(itemList.stream().map(Item::getProduct).parallel().sorted(Comparator.comparing(Product::getName)).distinct().collect(Collectors.toList()));
    }
    @Override
    public Iterator<I> getItems() {
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
