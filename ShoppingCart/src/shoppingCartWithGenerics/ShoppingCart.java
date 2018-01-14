package shoppingCartWithGenerics;
import java.util.Collection;
import java.util.Iterator;

public interface ShoppingCart <P extends Product, I extends Item>{
	public abstract I addItem(P product, Integer amount);
        public default I addItem(P product, Integer amount, ItemPriority itemPriority){return null;};
        public default I addItem(P product, Integer amount, ItemPriority itemPriority, Client client){return null;};
	public abstract Collection<P> getProductsOrderByNameAsc();
	public abstract Iterator<I> getItems();
	public abstract void removeItemByProductId(Integer productId);
	public abstract Double getTotal();
}
