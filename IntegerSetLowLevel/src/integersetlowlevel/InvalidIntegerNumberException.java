package integersetlowlevel;
public class InvalidIntegerNumberException extends Exception{
    private final int number;
    public InvalidIntegerNumberException(String message, Throwable cause, int number) {
        super(message, cause);
        this.number=number;
    }
    @Override
    public String getMessage() {
        return "O número 'n' deve ser um número inteiro não negativo, entre 0 e 100. Você está tentando usar o número: "+number+", inválido!";
    }
}
