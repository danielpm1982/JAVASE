package command;
import java.util.Stack;

public class RemoteControl {
    private final Command[][] commandArray;
    private final int COMMAND_LINES;
    private final int COMMAND_COLUMNS;
    private final Stack<Command> lastCommandStack;
    public RemoteControl(int commandLines, int commandColumns) {
        this.COMMAND_LINES=commandLines;
        this.COMMAND_COLUMNS=commandColumns;
        commandArray = new Command[COMMAND_LINES][COMMAND_COLUMNS];
        Command noCommand = new NoCommand(); //empty Object that does nothing: for not having to test each button (command) against null before pressing them.
        for (int i=0;i<COMMAND_LINES;i++){
            for (int j=0;j<COMMAND_COLUMNS;j++){
                commandArray[i][j] = noCommand;
            }
        }
        lastCommandStack=new Stack<>();
    }
    public String getRemoteControlView(){
        StringBuilder response = new StringBuilder();
        response.append(String.format("%-26s%-26s%-26s%-26s%n", "****ButtonOne****", "****ButtonTwo****", "******ButtonThree******", "****ButtonFour****"));
        for (int i=0;i<COMMAND_LINES;i++){
            for (int j=0;j<COMMAND_COLUMNS;j++){
                response.append(String.format("%-26s", commandArray[i][j]));
            }
            response.append("\n");
        }
        return response.toString();
    }
    public void setCommand(int commandLine, Command... commandsArray) {
        for(int j=0;j<commandsArray.length;j++){
            commandArray[commandLine][j]=commandsArray[j];
        }
    }
    public String pressButtonOne(int commandLine){
        commandArray[commandLine][0].execute();
        lastCommandStack.push(commandArray[commandLine][0]);
        return commandArray[commandLine][0]+":";
    }
    public String pressButtonTwo(int commandLine){
        commandArray[commandLine][1].execute();
        lastCommandStack.push(commandArray[commandLine][1]);
        return commandArray[commandLine][1]+":";
    }
    public String pressButtonThree(int commandLine){
        commandArray[commandLine][2].execute();
        lastCommandStack.push(commandArray[commandLine][2]);
        return commandArray[commandLine][2]+":";
    }
    public String pressButtonFour(int commandLine){
        commandArray[commandLine][3].execute();
        lastCommandStack.push(commandArray[commandLine][3]);
        return commandArray[commandLine][3]+":";
    }
    public String pressUndoButton(){
        if(!lastCommandStack.empty()){
            Command lastCommand = lastCommandStack.pop();
            lastCommand.undo();
            return lastCommand+" undone!";
        }
        return "Nothing to undo!";
    }
    //expand the matrix if more functions are necessary for any of the systems.
}
