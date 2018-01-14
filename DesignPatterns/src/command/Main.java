package command;

public class Main {
    public static void main(String[] args) {
        //creating invoker
        RemoteControl remoteControl = new RemoteControl(4,4);
        
        //creating receivers and commands
        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);
        GarageDoor garageDoor = new GarageDoor();
        Command garageDoorOpenCommand = new GarageOpenCommand(garageDoor);
        Command garageDoorCloseCommand = new GarageCloseCommand(garageDoor);
        Stereo stereo = new Stereo();
        Command stereoOnCommand = new StereoOnCommand(stereo);
        Command stereoOffCommand = new StereoOffCommand(stereo);
        Command stereoSwitchMediaCommand = new StereoSwitchMediaCommand(stereo);
        Command stereoMuteCommand = new StereoMuteCommand(stereo);
        Command macroOnCommand = new MacroOnCommand(lightOnCommand,garageDoorOpenCommand,stereoOnCommand);
        Command macroOffCommand = new MacroOffCommand(lightOffCommand,garageDoorCloseCommand,stereoOffCommand);
        
        //setting On and Off commands on invoker - remoteControl slots (commandLines)
        remoteControl.setCommand(0,lightOnCommand,lightOffCommand);
        remoteControl.setCommand(1,garageDoorOpenCommand,garageDoorCloseCommand);
        remoteControl.setCommand(2, stereoOnCommand, stereoOffCommand, stereoSwitchMediaCommand, stereoMuteCommand);
        remoteControl.setCommand(3, macroOnCommand, macroOffCommand);
        
        //pressing control buttons and checking state changing (each commandLine has two or more buttons - On and Off, at least, for each receiver)
        System.out.println(remoteControl.pressButtonOne(0));
        System.out.println("Light is: "+light.getState()+"!");
        System.out.println(remoteControl.pressButtonTwo(0));
        System.out.println("Light is: "+light.getState()+"!");
        System.out.println(remoteControl.pressUndoButton());
        System.out.println("Light is: "+light.getState()+"!");
        System.out.println(remoteControl.pressUndoButton());
        System.out.println("Light is: "+light.getState()+"!");
        System.out.println(remoteControl.pressUndoButton());
        System.out.println("");
        System.out.println(remoteControl.pressButtonOne(1));
        System.out.println("GarageDoor is: "+garageDoor.getState()+"!");
        System.out.println(remoteControl.pressButtonTwo(1));
        System.out.println("GarageDoor is: "+garageDoor.getState()+"!");
        System.out.println(remoteControl.pressUndoButton());
        System.out.println("GarageDoor is: "+garageDoor.getState()+"!");
        System.out.println(remoteControl.pressUndoButton());
        System.out.println("GarageDoor is: "+garageDoor.getState()+"!");
        System.out.println(remoteControl.pressUndoButton());
        System.out.println("");
        System.out.println(remoteControl.pressButtonOne(2));
        System.out.println("Stereo is: "+stereo.getState()+"!");
        System.out.println(stereo.getLastMediaInside());
        System.out.println(((StereoSwitchMediaCommand)stereoSwitchMediaCommand).getSwitchedMediaStack().toString());
        System.out.println(remoteControl.pressButtonThree(2));
        System.out.println("Stereo is: "+stereo.getState()+"!");
        System.out.println(stereo.getLastMediaInside());
        System.out.println(((StereoSwitchMediaCommand)stereoSwitchMediaCommand).getSwitchedMediaStack().toString());
        System.out.println(remoteControl.pressButtonThree(2));
        System.out.println("Stereo is: "+stereo.getState()+"!");
        System.out.println(stereo.getLastMediaInside());
        System.out.println(((StereoSwitchMediaCommand)stereoSwitchMediaCommand).getSwitchedMediaStack().toString());
        System.out.println(remoteControl.pressButtonThree(2));
        System.out.println("Stereo is: "+stereo.getState()+"!");
        System.out.println(stereo.getLastMediaInside());
        System.out.println(((StereoSwitchMediaCommand)stereoSwitchMediaCommand).getSwitchedMediaStack().toString());
        System.out.println(remoteControl.pressButtonTwo(2));
        System.out.println("Stereo is: "+stereo.getState()+"!");
        System.out.println(stereo.getLastMediaInside());
        System.out.println(((StereoSwitchMediaCommand)stereoSwitchMediaCommand).getSwitchedMediaStack().toString());
        System.out.println(remoteControl.pressButtonOne(2));
        System.out.println("Stereo is: "+stereo.getState()+"!");
        System.out.println(stereo.getLastMediaInside());
        System.out.println(((StereoSwitchMediaCommand)stereoSwitchMediaCommand).getSwitchedMediaStack().toString());
        for(int i=0;i<6;i++){
            System.out.println(remoteControl.pressUndoButton());
            System.out.println("Stereo is: "+stereo.getState()+"!");
            System.out.println(stereo.getLastMediaInside());
            System.out.println(((StereoSwitchMediaCommand)stereoSwitchMediaCommand).getSwitchedMediaStack().toString());
        }
        System.out.println(remoteControl.pressButtonOne(2));
        System.out.println("Stereo is: "+stereo.getState()+"!");
        System.out.println(remoteControl.pressButtonTwo(2));
        System.out.println("Stereo is: "+stereo.getState()+"!");
        System.out.println(remoteControl.pressButtonFour(2));
        System.out.println("Stereo is: "+stereo.getState()+"!");
        System.out.println(remoteControl.pressButtonFour(2));
        System.out.println("Stereo is: "+stereo.getState()+"!");
        for (int i=0;i<4;i++){
            System.out.println(remoteControl.pressUndoButton());
            System.out.println("Stereo is: "+stereo.getState()+"!");
        }
        System.out.println(remoteControl.pressUndoButton());
        System.out.println("");
        
        System.out.println(remoteControl.pressButtonOne(3));
        System.out.println("Light is: "+light.getState()+" GarageDoor is: "+garageDoor.getState()+" Stereo is: "+stereo.getState());
        System.out.println(remoteControl.pressButtonTwo(3));
        System.out.println("Light is: "+light.getState()+" GarageDoor is: "+garageDoor.getState()+" Stereo is: "+stereo.getState());
        System.out.println(remoteControl.pressUndoButton());
        System.out.println("Light is: "+light.getState()+" GarageDoor is: "+garageDoor.getState()+" Stereo is: "+stereo.getState());
        System.out.println(remoteControl.pressUndoButton());
        System.out.println("Light is: "+light.getState()+" GarageDoor is: "+garageDoor.getState()+" Stereo is: "+stereo.getState());
        System.out.println(remoteControl.pressUndoButton());
        
        //viewing remoteControl layout with each set command at each commandLine
        System.out.println("\nRemoteControl:\n"+remoteControl.getRemoteControlView());
    }
}

/*
Client: Main class.
Receivers: Light and GarageDoor.
Commands: LightOnCommand(Light), LightOffCommand(Light), GarageOpenCommand(GarageDoor), GarageCloseCommand(GarageDoor).
Invoker: RemoteControl.

Using Command Pattern, one can decouple the Client (the original invoker) and the Invoker from the Receiver, by creating Command 
objects that encapsulate the call to the receiver (and the Receiver itself), and are passed to a generic and multi-purpose Invoker 
(RemoteControl, here), which can have set any type of Command (that implements Command interface). Later, this same Invoker 
can have called it's executor method (pressButton(), here) to call the Command's execute() method. The Command method will be 
implemented at each concrete Command class and will, in turn, and when it is time, call one or more methods on the encapsulated 
Receiver, which will eventually produce the final and expected result. Commands can be switched any time for others, without modifying 
any Invoker code. And, as the Receiver is encapsulated in the Command, there should be no code change after Commands are coded. 
The generic Invoker does not know anything about the Receiver nor the Receiver API, as well as the Client, and both are decoupled from 
the Receiver by the Generic Invoker and the Command (with the Receiver within it). That way one can, generically, each Command interface, 
for example for an array of Commands, directing the calls to the signature and not to the concrete Command or to the Receiver interface 
(eventually, vendor classes). Each Command has only one execute() method, that will be called blindly by the Invoker. Therefore, if a 
system has more functions, it will have as much Commands as functions. In this example, only two functions (Commands) per system were 
initially adopted, although it could have been more... as long as there was a separate Command for each. Later, for Stereo, it was added 
two more buttons (4 functions in total)... Each Command then was set at the Invoker, along with its Receiver encapsulated, which will 
have methods called at the end, according to each Command executed by the Invoker. The Invoker can store all Commands for every system 
in arrays or matrixes, like in this example, and have set and called each Command according to the matrix coordinates... or any other 
data structure. This way, the API being developed can keep independent from any present or future vendor classes regarding the systems 
functions, with minimal or no maintenance needed. UndoButton was added to the Invoker (RemoteControl) and to the Command Interface
(therefore, for all Commands) in order to exemplify a way of implementing this another objective of this Pattern, which is to offer
a way of not only executing methods, uncoupled the invoker from the receiver, but to make possible to undo one or more (a stack, here)
of these last commands. The invoker keeps registry of the commands called, in order to undo them, but keeps ignoring which Receiver or 
undoing algorithm will actually be executed. That is, the decoupling persists with the undoing service. Only the concrete Command knows 
the receiver and the undoing algorithm to undo that command function. Another feature the Pattern sustains is the possibility for
implementing macro Commands, which receive not a Receiver in the Constructor, on which they would call the executing algorithm, 
but arrays of other Commands (with their own receivers) that may have their own execution called together, by the one and only call 
of the macro executing method. In this case, the Invoker does not have called the final Commands, but a general macro Command, 
in whose executing method all other registered Commands are executed, inside the macro command itself. A Command with other Commands
(and not a unique Receiver) inside. As any other Command, the macro command can also be undone. It could also be used with job queues, 
which would act like the blind Invoker and direct Commands to different threads, for example, without knowing what or how they would 
do and with what receiver. Another context would be to add two other methods to the Command Interface, store and load, e.g., so that 
some Commands could be stored for later call (logged), including in cases of a crash, or any other systemic failure, as with critical 
or transactional systems. The Invoker would manage not only the execution attempt or undo actions, but would store the Commands (requests) 
on disk and, if execution fails, load again later that requests, in order, for batching processing. The Invoker can, in all cases, decouple 
and parameterize different calls (client requests), provided that they implement Command Interface, and manage these calls generically, 
delegating to the Command and its Receiver the actual execution for each client request.

Command - Encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, 
and support undoable operations.
(Head First, Design Patterns, 2004)
*/
