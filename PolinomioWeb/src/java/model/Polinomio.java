package model;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Polinomio {
    
    private final double[] arrayCoeficiente;
    private final int[] arrayExpoente;
    private final int COEFICIENTE_LENGTH;
    private final int EXPOENTE_LENGTH;
    private final int GRAU;
    
    public Polinomio(double... arrayCoeficiente){
        this.arrayCoeficiente=arrayCoeficiente;
        COEFICIENTE_LENGTH=arrayCoeficiente.length;
        this.arrayExpoente=getArrayExpoente(COEFICIENTE_LENGTH-1);
        EXPOENTE_LENGTH=arrayExpoente.length;
        GRAU=COEFICIENTE_LENGTH-1;
    }
    
    private int[] getArrayExpoente(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=n;i>0;i--){
            list.add(i);
        }
        return Stream.of(list.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
    }
    
    public String getPolinomio(){
        return getPolinomioString(arrayCoeficiente, arrayExpoente);
    }
    
    private String getPolinomioString(double[] arrayCoeficienteGenerico, int[] arrayExpoenteGenerico){
        int COEFICIENTE_GENERICO_LENGTH=arrayCoeficienteGenerico.length;
        String polinomioString = "";
        for (int i=0;i<COEFICIENTE_GENERICO_LENGTH-1;i++){
            polinomioString+="("+arrayCoeficienteGenerico[i]+")x^"+arrayExpoenteGenerico[i]+" + ";
        }
        polinomioString+="("+arrayCoeficienteGenerico[COEFICIENTE_GENERICO_LENGTH-1]+")";
        return polinomioString;
    }
    
    public String getPolinomioPrimeiraDerivada(){
        double[] arrayCoeficientePrimeiraDerivada=new double[COEFICIENTE_LENGTH-1];
        int[] arrayExpoentePrimeiraDerivada=new int[EXPOENTE_LENGTH-1];
        derivar(arrayCoeficiente, arrayExpoente, arrayCoeficientePrimeiraDerivada, arrayExpoentePrimeiraDerivada);
        return getPolinomioString(arrayCoeficientePrimeiraDerivada, arrayExpoentePrimeiraDerivada);
    }
    
    private void derivar(double[] arrayCoeficienteGenerico, int[] arrayExpoenteGenerico, double[] arrayCoeficientePrimeiraDerivadaGenerico, int[] arrayExpoentePrimeiraDerivadaGenerico){
        int COEFICIENTE_GENERICO_LENGTH=arrayCoeficienteGenerico.length;
        int EXPOENTE_GENERICO_LENGTH=arrayExpoenteGenerico.length;
        for (int i=0;i<COEFICIENTE_GENERICO_LENGTH-1;i++){
            arrayCoeficientePrimeiraDerivadaGenerico[i]=arrayExpoenteGenerico[i]*arrayCoeficienteGenerico[i];
        }
        for (int i=0;i<EXPOENTE_GENERICO_LENGTH-1;i++){
            arrayExpoentePrimeiraDerivadaGenerico[i]=(arrayExpoenteGenerico[i]-1);
        }
    }
    
    public String getPolinomioSegundaDerivada(){
        double[] arrayCoeficientePrimeiraDerivada=new double[COEFICIENTE_LENGTH-1];
        int[] arrayExpoentePrimeiraDerivada=new int[EXPOENTE_LENGTH-1];
        derivar(arrayCoeficiente, arrayExpoente, arrayCoeficientePrimeiraDerivada, arrayExpoentePrimeiraDerivada);
        double[] arrayCoeficienteSegundaDerivada=new double[COEFICIENTE_LENGTH-2];
        int[] arrayExpoenteSegundaDerivada=new int[EXPOENTE_LENGTH-2];
        derivar(arrayCoeficientePrimeiraDerivada, arrayExpoentePrimeiraDerivada, arrayCoeficienteSegundaDerivada, arrayExpoenteSegundaDerivada);
        return getPolinomioString(arrayCoeficienteSegundaDerivada, arrayExpoenteSegundaDerivada);
    }
    
    public String getPolinomioTerceiraDerivada(){
        double[] arrayCoeficientePrimeiraDerivada=new double[COEFICIENTE_LENGTH-1];
        int[] arrayExpoentePrimeiraDerivada=new int[EXPOENTE_LENGTH-1];
        derivar(arrayCoeficiente, arrayExpoente, arrayCoeficientePrimeiraDerivada, arrayExpoentePrimeiraDerivada);
        double[] arrayCoeficienteSegundaDerivada=new double[COEFICIENTE_LENGTH-2];
        int[] arrayExpoenteSegundaDerivada=new int[EXPOENTE_LENGTH-2];
        derivar(arrayCoeficientePrimeiraDerivada, arrayExpoentePrimeiraDerivada, arrayCoeficienteSegundaDerivada, arrayExpoenteSegundaDerivada);
        double[] arrayCoeficienteTerceiraDerivada=new double[COEFICIENTE_LENGTH-3];
        int[] arrayExpoenteTerceiraDerivada=new int[EXPOENTE_LENGTH-3];
        derivar(arrayCoeficienteSegundaDerivada, arrayExpoenteSegundaDerivada, arrayCoeficienteTerceiraDerivada, arrayExpoenteTerceiraDerivada);
        return getPolinomioString(arrayCoeficienteTerceiraDerivada, arrayExpoenteTerceiraDerivada);
    }

    public int getGRAU() {
        return GRAU;
    }
}
