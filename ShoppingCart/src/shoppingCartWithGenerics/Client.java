package shoppingCartWithGenerics;
public class Client {
    private final String name;
    private final Long ssn;
    public Client(String name, Long ssn) {
        this.name = name;
        this.ssn=ssn;
    }
    @Override
    public String toString() {
        return name+" ssn: "+ssn;
    }
}
