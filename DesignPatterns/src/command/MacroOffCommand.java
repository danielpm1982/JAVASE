package command;
import java.util.stream.Stream;

public class MacroOffCommand implements Command{
    private final Command[] commandArray;
    private boolean macroExecuted;
    public MacroOffCommand(Command... commandsMacroOff) {
        this.commandArray=commandsMacroOff;
        this.macroExecuted=false;
    }
    @Override
    public void execute() {
        Stream.of(commandArray).forEach(x->x.execute());
        macroExecuted=true;
    }
    @Override
    public void undo() {
        if(macroExecuted){
            Stream.of(commandArray).forEach(x->x.undo());
        }
        macroExecuted=false;
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
