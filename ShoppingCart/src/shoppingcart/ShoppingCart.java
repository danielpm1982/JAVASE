package shoppingcart;
import java.util.Collection;
import java.util.Iterator;

public interface ShoppingCart{
	public abstract Item addItem(Product product, Integer amount);
	public abstract Collection getProductsOrderByNameAsc();
	public abstract Iterator getItems();
	public abstract void removeItemByProductId(Integer productId);
	public abstract Double getTotal();
}