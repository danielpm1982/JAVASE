package polinomio;

public class GrauNegativoException extends Exception{
    private final int grau;
    public GrauNegativoException(String message, Throwable cause, int grau) {
        super(message, cause);
        this.grau=grau;
    }

    @Override
    public String getMessage() {
        return "O grau do polinômio deve ser um número inteiro não negativo. Você está tentando usar um polínômio de grau: "+grau+".";
    }
}
