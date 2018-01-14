package interpreter;
import java.util.Map;

public class Minus implements Expression{
    private final Expression leftOperand;
    private final Expression rightOperand;
    public Minus(final Expression left, final Expression right) {
        leftOperand = left;
        rightOperand = right;
    }
    @Override
    public int interpret(final Map<String, Expression> variables) {
        return leftOperand.interpret(variables) - rightOperand.interpret(variables);
    }
}
