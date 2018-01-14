package bingo;
import java.util.ArrayList;

public class Globo {
    private static final ArrayList<Integer> numeroSorteadoList=new ArrayList<>();
    public static int sortearNumero(final int MIN, final int MAX){
        boolean numeroValido=false;
        int novoNumero=-1;
        while(numeroValido==false&&numeroSorteadoList.size()<(MAX-MIN+1)){
            novoNumero = NumeroAleatorio.getNumero(MIN, MAX);
            if(!NumeroAleatorio.verificarNumeroRepetidoEmLista(novoNumero,numeroSorteadoList)){
                numeroSorteadoList.add(novoNumero);
                numeroValido=true;
            }
        }
        return novoNumero;
    }
    public static ArrayList<Integer> getNumeroSorteadoList() {
        return numeroSorteadoList;
    }
}
