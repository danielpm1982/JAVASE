package interpreter;
import java.util.Map;
import java.util.Stack;

public class Evaluator implements Expression{
    private final Expression syntaxTree;
    public Evaluator(final String expression) {
        final Stack<Expression> expressionStack = new Stack<>();
        Expression subExpression;
        for (final String token : expression.split(" ")) {
            switch (token) {
                case "+":
                    subExpression = new Plus(expressionStack.pop(), expressionStack.pop());
                    expressionStack.push(subExpression);
                    break;
                case "-":
                    // it's necessary to remove first the right operand from the stack
                    final Expression right = expressionStack.pop();
                    // ... and after the left one
                    final Expression left = expressionStack.pop();
                    subExpression = new Minus(left, right);
                    expressionStack.push(subExpression);
                    break;
                default:
                    expressionStack.push(new Variable(token));
                    break;
            }
        }
        syntaxTree = expressionStack.pop();
    }
    @Override
    public int interpret(final Map<String, Expression> context) {
        return syntaxTree.interpret(context);
    }
}
