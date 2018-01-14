package model;

public class Peixe implements Animal{
    private final String ID;
    public Peixe() {
        this.ID="peixe"+NumeroAleatorio.getNumeroAleatorio(100000, 999999);
    }
    @Override
    public String toString() {
        return ID;
    }
}
