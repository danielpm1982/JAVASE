package bingo;
import java.util.ArrayList;

public class Bingo {
    private static final ArrayList<Cartela> cartelasList=new ArrayList<>();
    private static final int NUMERO_CARTELAS = 10000; //qualquer número inteiro não nulo, testado até 1 milhão de cartelas
    private static final int NUMERO_MINIMO=1; //número mínimo a ser sorteado (inclusivo!)
    private static final int NUMERO_MAX=98; //número máximo a ser sorteado (inclusivo!)
    private static final int QTDE_NUMEROS_CARTELA=15; //qtde máxima equivalente ao máximo de números exclusivos sorteáveis, ou seja, até (NUMERO_MAX-NUMERO_MINIMO)+1
    public static void main(String[] args) {
        System.out.println("**************Criando "+NUMERO_CARTELAS+" Cartelas:**************");
        criarCartelas();
        System.out.println("\n**************Iniciado Sorteio:**************");
        iniciarSorteio();
        System.out.println("\n**************FIM DO BINGO !! Cartela(s) contemplada(s):**************");
        cartelasList.stream().filter(Cartela::verificarCartelaContemplada).forEach(System.out::println);
        System.out.println(cartelasList.stream().filter(Cartela::verificarCartelaContemplada).count()+" cartelas sorteadas !!");
        System.out.println("Total de cartelas: "+cartelasList.size()+".");
        System.out.println("Percentual de cartelas sorteadas: "+cartelasList.stream().filter(Cartela::verificarCartelaContemplada).count()*1.0/cartelasList.size()*100+"%.");
        System.out.println("\n**************Todos os números sorteados no Globo:**************");
        Globo.getNumeroSorteadoList().forEach(x->System.out.print(x+" "));
        System.out.println("\n"+Globo.getNumeroSorteadoList().size()+" numeros.\n");
    }
    private static void criarCartelas(){
        for (long i=0;i<NUMERO_CARTELAS;i++){
            cartelasList.add(new Cartela(QTDE_NUMEROS_CARTELA,NUMERO_CARTELAS+i,NUMERO_MINIMO,NUMERO_MAX+1)); //classes internas trabalham com numero max exclusivo!
        }
    }
    private static void iniciarSorteio(){
        do{
            int numeroSorteado = Globo.sortearNumero(NUMERO_MINIMO,NUMERO_MAX+1); //classes internas trabalham com numero max exclusivo!
            System.out.println("numeroSorteado: "+numeroSorteado);
            cartelasList.stream().forEach(x->x.marcarNumeroSorteado(numeroSorteado));
        }while(!verificarFim());
    }
    private static boolean verificarFim(){
        return cartelasList.stream().anyMatch(Cartela::verificarCartelaContemplada);
    }
}
