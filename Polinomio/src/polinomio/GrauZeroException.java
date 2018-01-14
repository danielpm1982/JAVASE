package polinomio;

public class GrauZeroException extends Exception{
    private final int grau;
    public GrauZeroException(String message, Throwable cause, int grau) {
        super(message, cause);
        this.grau=grau;
    }

    @Override
    public String getMessage() {
        return "A derivada de todo polinômio de grau zero (função constante) é ZERO. Você está tentando usar um polínômio de grau: "+grau+".";
    }
}
