package shoppingCartWithGenerics;

public class ItemChild extends Item{
    private ItemPriority itemPriority;
    public ItemChild(Product product, Integer amount) {
        super(product, amount);
    }
    public void setItemPriority(ItemPriority itemPriority) {
        this.itemPriority = itemPriority;
    }

    public ItemPriority getItemPriority() {
        return itemPriority;
    }
    @Override
    public String toString() {
        return "ItemDescription: "+getProduct()+" Amount: "+getAmount()+" ItemPriority: "+itemPriority;
    }
}
