package interpreter;
import java.util.Map;

public class Plus implements Expression{
    private final Expression leftOperand;
    private final Expression rightOperand;
    public Plus(final Expression left, final Expression right) {
        this.leftOperand = left;
        this.rightOperand = right;
    }
    @Override
    public int interpret(final Map<String, Expression> variables) {
        return leftOperand.interpret(variables) + rightOperand.interpret(variables);
    }
}
