package shoppingCartWithGenerics;

public class ItemGrandChild extends ItemChild{
    private Client client;
    public ItemGrandChild(Product product, Integer amount) {
        super(product, amount);
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Client getClient() {
        return client;
    }
    @Override
    public String toString() {
        return "ItemDescription: "+getProduct()+" Amount: "+getAmount()+" ItemPriority: "+getItemPriority()+" Client: "+client;
    }
}
