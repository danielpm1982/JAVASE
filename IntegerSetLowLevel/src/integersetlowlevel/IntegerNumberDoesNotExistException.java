package integersetlowlevel;
public class IntegerNumberDoesNotExistException extends Exception{
    private final int number;
    public IntegerNumberDoesNotExistException(String message, Throwable cause, int number) {
        super(message, cause);
        this.number=number;
    }
    @Override
    public String getMessage() {
        return "O número 'n' NÃO existe! Você está tentando usar um número inexistente: "+number+", e, portanto, inválido!";
    }
}
