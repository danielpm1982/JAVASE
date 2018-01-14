package integersetlowlevel;
public class IntegerNumberAlreadyExistsException extends Exception{
    private final int number;
    public IntegerNumberAlreadyExistsException(String message, Throwable cause, int number) {
        super(message, cause);
        this.number=number;
    }
    @Override
    public String getMessage() {
        return "O número 'n' deve ser um número único e não repetido no array. Você está tentando usar um número já existente: "+number+", e, portanto, inválido!";
    }
}
