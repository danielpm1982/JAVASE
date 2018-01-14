package bingo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cartela {
    private final int[] numerosCartelaArray;
    private final ArrayList<Integer> numerosCartelaSorteadosArray;
    private boolean cartelaContemplada=false;
    private final long ID_CARTELA;
    private final int QTDE_NUMEROS_CARTELA;
    public Cartela(int qtdeNumerosCartela, long idCartela, int numeroMinimo, int numeroMaximo) {
        this.QTDE_NUMEROS_CARTELA=qtdeNumerosCartela;
        this.ID_CARTELA=idCartela;
        numerosCartelaArray=NumeroAleatorio.getArrayIntPreenchido(QTDE_NUMEROS_CARTELA,numeroMinimo,numeroMaximo);
        numerosCartelaSorteadosArray=new ArrayList<>();
        System.out.println("Cartela Criada: "+this);
    }
    public void marcarNumeroSorteado(int n){
        if(cartelaContemplada==false&&getNumerosCartelaList().contains(n)){
            numerosCartelaSorteadosArray.add(n);
            if(numerosCartelaSorteadosArray.size()==QTDE_NUMEROS_CARTELA){
                cartelaContemplada=true;
            }
        }
    }
    public boolean verificarCartelaContemplada(){
        return cartelaContemplada;
    }
    public long getIdCartela(){
        return ID_CARTELA;
    }
    private List<Integer> getNumerosCartelaList(){
        return IntStream.of(numerosCartelaArray).boxed().collect(Collectors.toList());
    }
    @Override
    public String toString() {
        return "IdCartela: "+ID_CARTELA+" NumerosDaCartela: "+Arrays.toString(numerosCartelaArray)+" NumerosSorteadosDaCartela: "+numerosCartelaSorteadosArray+" CartelaContemplada ?: "+(verificarCartelaContemplada()?"SIM":"Não")+".";
    }
}
