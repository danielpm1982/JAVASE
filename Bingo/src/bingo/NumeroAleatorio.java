package bingo;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class NumeroAleatorio {
    public static int getNumero(int min, int max){
        return new SecureRandom().ints(min, max).findAny().getAsInt();
    }
    public static int[] getArrayIntPreenchido(int size, int min, int max){
        List<Integer> arrayList = new ArrayList<>(size);
        while(arrayList.stream().filter(x->x!=null).count()<size){
            int numero = NumeroAleatorio.getNumero(min, max);
            if(!verificarNumeroRepetidoEmLista(numero, arrayList)){
                arrayList.add(numero);
            }
        }
        return arrayList.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    public static boolean verificarNumeroRepetidoEmLista(int n, List<Integer> list){
        if(list.isEmpty()){
            return false;
        } else{
            return list.contains(n);
        }
    }
}
