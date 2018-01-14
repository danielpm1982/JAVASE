package interpreter;
import java.util.Map;

public class Variable implements Expression{
    private final String name;
    public Variable(final String name){
        this.name = name;
    }
    @Override
    public int interpret(final Map<String, Expression> variables) {
        if (variables.get(name)==null){
            return 0;
        }
        return variables.get(name).interpret(variables);
    }
}
