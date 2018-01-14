package model;

public class Urso implements Animal{
    private final String ID;
    public Urso() {
        this.ID="urso"+NumeroAleatorio.getNumeroAleatorio(100000, 999999);
    }
    @Override
    public String toString() {
        return ID;
    }
}
