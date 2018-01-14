package interpreter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String expression = "w x z - +";
        final Evaluator sentence = new Evaluator(expression);
        final Map<String, Expression> variables = new HashMap<>();
        variables.put("w", new Number(5));
        variables.put("x", new Number(10));
        variables.put("z", new Number(42));
        final int result = sentence.interpret(variables);
        System.out.println(result);
    }
}

/*
Interpreter Pattern is useful for creating simple-grammar languages, with its interpreter method inbuilt 
in the interface and in every derived class, which models and process terminal (e.g. a character or number) 
and non-terminal expressions (Sequence, Repetition, Alternation, Operations, etc) recursively over that input
user context (syntaxTree) that must be translated. The Class Modeling for the basic grammar makes it easy to
change and extend it, adding new ways to interpret expressions, as well as facilitates the implementation.
On the other hand, it is difficult for modeling and maintaining languages with complex-grammar, for which 
parser/compiler generators should be more appropriate.

"Given a language, define a representation for its grammar along with an interpreter 
that uses the representation to interpret sentences in the language."
"The Interpreter pattern describes how to define a grammar for simple languages, 
represent sentences in the language, and interpret these sentences."
(Design Patterns: Elements of Reusable Object-Oriented Software, 1994)

Exceptionally, the example for this Pattern had to be taken and adapted from elsewhere:
https://en.wikipedia.org/wiki/Interpreter_pattern .

Grammar for reverse Polish Notation:
expression ::= plus | minus | variable | number
plus ::= expression expression '+'
minus ::= expression expression '-'
variable ::= 'a' | 'b' | 'c' | ... | 'z'
digit = '0' | '1' | ... | '9'
number ::= digit | digit number

The Evaluator class takes in the input the user types and transforms it in a syntaxTree
of Expression nodes that correspond to either of the components of the grammar, and, on,
this syntaxTree, the interpret method is initially called, passed the variables values map
as the argument. The result is the numeric number that corresponds to the arithmetic result
for the reversed Polish Notation expression used as the expression here, after being interpreted
by each node class (terminal and non-terminal recursive operations).
*/
