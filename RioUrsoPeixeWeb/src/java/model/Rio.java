package model;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rio {
    private final int RIO_ARRAY_LENGTH;
    private final Animal[] rioArray;
    private int ciclosMovimentacao=0;
    private final ArrayList<String> saidaRioArray; //array apenas para output (visão) no console
    public Rio(int rio_array_length) {
        this.RIO_ARRAY_LENGTH=rio_array_length;
        rioArray = new Animal[RIO_ARRAY_LENGTH];
        saidaRioArray = new ArrayList<>();
    }
    public void popularRio(final double RIO_ARRAY_PERCENT_NOT_NULL){
        saidaRioArray.add(this.toString());
        while(contarElementosNaoNulos()<1){ //adiciona ao menos 1 urso, para evitar que todos sejam peixe e entre em looping por falta de quem "coma" o peixe
            adicionarElementoNoRio(new Urso(), NumeroAleatorio.getNumeroAleatorio(0, RIO_ARRAY_LENGTH));
        }
        if(RIO_ARRAY_LENGTH>1){ //se o length do array for maior que 1, adiciona outro urso, para dar chance (não garantida - depende da posição) à "reprodução" por 2 ursos de mesmo tipo, a fim de evitar que fique apenas 1 único urso e o resto tudo null após o urso comer todos os peixes
            while(contarElementosNaoNulos()<2){
                adicionarElementoNoRio(new Urso(), NumeroAleatorio.getNumeroAleatorio(0, RIO_ARRAY_LENGTH));
            }
        }
        while(contarElementosNaoNulos()<RIO_ARRAY_PERCENT_NOT_NULL*RIO_ARRAY_LENGTH){ //do terceiro elemento em diante, adiciona na proporção abaixo (por ex., 2 peixes para 1 urso, além dos 2 ursos mínimos iniciais e pré-existentes - estes dois ursos ou o único urso podem não corresponder à proporção)... de acordo com quanto espaço null ainda haja disponível no vetor, verificado a cada iteração da adição (+3, ou +2 ou +1 elemento)
            if(contarElementosNaoNulos()<RIO_ARRAY_LENGTH-3){
                adicionarElementoNoRio(new Peixe(), NumeroAleatorio.getNumeroAleatorio(0, RIO_ARRAY_LENGTH)); //limite inferior inclusivo, limite superior exclusivo
                adicionarElementoNoRio(new Peixe(), NumeroAleatorio.getNumeroAleatorio(0, RIO_ARRAY_LENGTH));
                adicionarElementoNoRio(new Urso(), NumeroAleatorio.getNumeroAleatorio(0, RIO_ARRAY_LENGTH));
            } else if(contarElementosNaoNulos()<RIO_ARRAY_LENGTH-2){
                adicionarElementoNoRio(new Peixe(), NumeroAleatorio.getNumeroAleatorio(0, RIO_ARRAY_LENGTH)); //limite inferior inclusivo, limite superior exclusivo
                adicionarElementoNoRio(new Urso(), NumeroAleatorio.getNumeroAleatorio(0, RIO_ARRAY_LENGTH));
            }
            else if(contarElementosNaoNulos()<=RIO_ARRAY_LENGTH-1){
                adicionarElementoNoRio(new Peixe(), NumeroAleatorio.getNumeroAleatorio(0, RIO_ARRAY_LENGTH));
            }
        }
        try {
            Thread.sleep(1000); //atraso apenas para organizar o output (visão) no console
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        saidaRioArray.add(this.toString());
        System.out.println(this);
        System.out.println(contarElementosNaoNulos()+" elementos não nulos! "+contarElementosPeixe()+" peixe(s); "+contarElementosUrso()+" urso(s) e "+contarElementosNulos()+" null(s).");
    }
    private boolean adicionarElementoNoRio(Animal a, int posicao){ //no populamento do rio (ao contrário da movimentação no rio) basta que haja espaço null disponível (em processarInsercao()) e que a posição seja válida
        if(posicao>=0&&posicao<RIO_ARRAY_LENGTH){
            if(processarInsercao(a,posicao)){
                System.out.println("Elemento "+a+" inserido com sucesso!");
                return true;
            } else{
                System.err.println("ERRO: Elemento "+a+" não inserido!");
                return false;
            }
        } else{
            System.err.println("ERRO: Número de posição inválida para inserção! Elemento "+a+" não inserido!");
            return false;
        }
    }
    private boolean processarInsercao(Animal a, int posicao){
        if(rioArray[posicao]==null){
            rioArray[posicao]=a;
            return true;
        }
        return false;
    }
    public void iniciarMovimentacaoDeElementos(){
        while (contarElementosPeixe()!=0){
            movimentarElementos();
            ciclosMovimentacao++;
            saidaRioArray.add(this.toString());
            System.out.println(this);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Movimentação Finalizada! Não há mais peixes no rio.");
        System.out.println("Peixes: "+contarElementosPeixe()+"; Ursos: "+contarElementosUrso()+"; nulls: "+contarElementosNulos()+".");
        System.out.println("Houve "+ciclosMovimentacao+" ciclos de movimentação.");
        System.out.println(this);
    }
    private void movimentarElementos(){ //a cada ciclo, tenta movimentar todos os elementos não nulos do vetor para a direita
        Animal[] elementosAMover = Stream.of(rioArray).filter(x->x!=null).toArray(Animal[]::new);
        Stream.of(elementosAMover).forEach(x->moverElementoNoRio(x,buscarElementoIndex(x)+1));
    }
    private void moverElementoNoRio(Animal a, int posicao){ //move CADA elemento solicitado conforme condições testadas
        boolean moverA = NumeroAleatorio.getBooleanAleatorio(); //boolean para tornar aleatório o movimento ou não do elemento
        if(moverA&&posicao<RIO_ARRAY_LENGTH){
            if(rioArray[posicao]==null){
                moverElementoNoRioDestinoVazio(a, posicao);
            } else{
                if(a.getClass().getSimpleName().equals(rioArray[posicao].getClass().getSimpleName())){ //checa se são do mesmo tipo
                    moverElementoNoRioDestinoMesmoTipo(a);
                }
                if(!a.getClass().getSimpleName().equals(rioArray[posicao].getClass().getSimpleName())){ //checa se são de tipos diferentes
                    moverElementoNoRioDestinoTipoDiferente(a,posicao);
                }
            }
        }
    }
    private void moverElementoNoRioDestinoVazio(Animal a, int posicao){
        int index = buscarElementoIndex(a);
        if(index!=-1){
            rioArray[posicao]=a;
            rioArray[index]=null;
        }
    }
    private void moverElementoNoRioDestinoMesmoTipo(Animal a){
        try {
            Animal x = a.getClass().newInstance();
            for (int i=0;i<3;i++){
                boolean adicionado = adicionarElementoNoRio(x, NumeroAleatorio.getNumeroAleatorio(0, RIO_ARRAY_LENGTH)); //limite inferior inclusivo, limite superior exclusivo
                if(adicionado){
                    break;
                }
            }
        } catch (InstantiationException|IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
    private void moverElementoNoRioDestinoTipoDiferente(Animal a, int posicao){
        int indexA = buscarElementoIndex(a);
        if(indexA!=-1){
            if(a.getClass().getSimpleName().equals("Urso")){
                rioArray[posicao]=a;
                rioArray[indexA]=null;
            } else if(a.getClass().getSimpleName().equals("Peixe")){
                rioArray[indexA]=null;
            }
        }
    }
    private int buscarElementoIndex(Animal a){
        for (int i=0;i<rioArray.length;i++){
            if(rioArray[i]==a){
                return i;
            }
        }
        return -1;
    }
    private long contarElementosNaoNulos(){
        return Stream.of(rioArray).filter(x->x!=null).count();
    }
    private long contarElementosNulos(){
        return Stream.of(rioArray).filter(x->x==null).count();
    }
    private long contarElementosPeixe(){
        return Stream.of(rioArray).filter(x->x!=null&&x.toString().startsWith("peixe")).count();
    }
    private long contarElementosUrso(){
        return Stream.of(rioArray).filter(x->x!=null&&x.toString().startsWith("urso")).count();
    }
    public ArrayList<String> getSaidaRioArray() {
        return saidaRioArray;
    }
    @Override
    public String toString() {
        return Stream.of(rioArray).collect(Collectors.toList()).toString();
    }
}
