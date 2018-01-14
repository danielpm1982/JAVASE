/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication;

import java.util.Vector;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Daniel
 */
public class VisualMIDlet extends MIDlet implements CommandListener {
    
    private boolean midletPaused = false;
    private DAO_RMS dao = new DAO_RMS();
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Form form;
    private TextField textField;
    private TextField textField1;
    private TextBox textBox;
    private Command okCommand;
    private Command backCommand;
    private Command backCommand1;
    private Image image1;
//</editor-fold>//GEN-END:|fields|0|
    /**
     * The VisualMIDlet constructor.
     */
    public VisualMIDlet() {
    }

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initializes the application. It is called only once when the MIDlet is
     * started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {
//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
}//GEN-BEGIN:|0-initialize|2|
//</editor-fold>//GEN-END:|0-initialize|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {
//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
switchDisplayable(null, getForm());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
}//GEN-BEGIN:|3-startMIDlet|2|
//</editor-fold>//GEN-END:|3-startMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {
//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
}//GEN-BEGIN:|4-resumeMIDlet|2|
//</editor-fold>//GEN-END:|4-resumeMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code>
     * instance is taken from <code>getDisplay</code> method. This method is
     * used by all actions in the design for switching displayable.
     *
     * @param alert the Alert which is temporarily set to the display; if
     * <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {
//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
}//GEN-BEGIN:|5-switchDisplayable|2|
//</editor-fold>//GEN-END:|5-switchDisplayable|2|
//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField ">//GEN-BEGIN:|16-getter|0|16-preInit
    /**
     * Returns an initialized instance of textField component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {
//GEN-END:|16-getter|0|16-preInit
 // write pre-init user code here
textField = new TextField("Name", null, 32, TextField.ANY);//GEN-LINE:|16-getter|1|16-postInit
 // write post-init user code here
}//GEN-BEGIN:|16-getter|2|
        return textField;
    }
//</editor-fold>//GEN-END:|16-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a
     * particular displayable.
     *
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {
//GEN-END:|7-commandAction|0|7-preCommandAction
 // write pre-action user code here
if (displayable == form) {//GEN-BEGIN:|7-commandAction|1|18-preAction
            if (command == okCommand) {//GEN-END:|7-commandAction|1|18-preAction
 // write pre-action user code here
                DAO_RMS dao = new DAO_RMS();
                dao.addRegistry(textField1.getString(), textField.getString());
                switchDisplayable(null, getTextBox());//GEN-LINE:|7-commandAction|2|18-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|3|32-preAction
} else if (displayable == textBox) {
    if (command == backCommand1) {//GEN-END:|7-commandAction|3|32-preAction
 // write pre-action user code here
switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|4|32-postAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|5|7-postCommandAction
        }//GEN-END:|7-commandAction|5|7-postCommandAction
 // write post-action user code here
}//GEN-BEGIN:|7-commandAction|6|
//</editor-fold>//GEN-END:|7-commandAction|6|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|17-getter|0|17-preInit
    /**
     * Returns an initialized instance of okCommand component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {
//GEN-END:|17-getter|0|17-preInit
 // write pre-init user code here
okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|17-getter|1|17-postInit
 // write post-init user code here
}//GEN-BEGIN:|17-getter|2|
        return okCommand;
    }
//</editor-fold>//GEN-END:|17-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField1 ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initialized instance of textField1 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField1() {
        if (textField1 == null) {
//GEN-END:|22-getter|0|22-preInit
 // write pre-init user code here
textField1 = new TextField("Key", null, 32, TextField.ANY);//GEN-LINE:|22-getter|1|22-postInit
 // write post-init user code here
}//GEN-BEGIN:|22-getter|2|
        return textField1;
    }
//</editor-fold>//GEN-END:|22-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|25-getter|0|25-preInit
    /**
     * Returns an initialized instance of backCommand component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {
//GEN-END:|25-getter|0|25-preInit
 // write pre-init user code here
backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|25-getter|1|25-postInit
 // write post-init user code here
}//GEN-BEGIN:|25-getter|2|
        return backCommand;
    }
//</editor-fold>//GEN-END:|25-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image1 ">//GEN-BEGIN:|24-getter|0|24-preInit
    /**
     * Returns an initialized instance of image1 component.
     *
     * @return the initialized component instance
     */
    public Image getImage1() {
        if (image1 == null) {
//GEN-END:|24-getter|0|24-preInit
 // write pre-init user code here
try {//GEN-BEGIN:|24-getter|1|24-@java.io.IOException
                image1 = Image.createImage("/mobileapplication/added.jpg");
            } catch (java.io.IOException e) {//GEN-END:|24-getter|1|24-@java.io.IOException
    e.printStackTrace();}//GEN-LINE:|24-getter|2|24-postInit
 // write post-init user code here
}//GEN-BEGIN:|24-getter|3|
        return image1;
    }
//</editor-fold>//GEN-END:|24-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textBox ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initialized instance of textBox component.
     *
     * @return the initialized component instance
     */
    public TextBox getTextBox() {
        if (textBox == null) {
//GEN-END:|28-getter|0|28-preInit
 // write pre-init user code here
textBox = new TextBox("textBox", "", 2000, TextField.ANY);//GEN-BEGIN:|28-getter|1|28-postInit
            textBox.addCommand(getBackCommand1());
            textBox.setCommandListener(this);//GEN-END:|28-getter|1|28-postInit
 // write post-init user code here
Vector clientsVector = dao.getAllRegistries();
String stringClients = new String();
for (int i=0; i<clientsVector.size();i++){
    stringClients+=clientsVector.elementAt(i).toString()+";\n";
}
stringClients+="\nTOTAL: "+clientsVector.size()+" clients.";
stringClients+="Obs.: Lista somente clientes antes desta sessão. Os adicionados nesta, só são exibidos na sessão seguinte.";
textBox.setString(stringClients);            

        }//GEN-BEGIN:|28-getter|2|
        return textBox;
    }
//</editor-fold>//GEN-END:|28-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|31-getter|0|31-preInit
    /**
     * Returns an initialized instance of backCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand1() {
        if (backCommand1 == null) {
//GEN-END:|31-getter|0|31-preInit
 // write pre-init user code here
backCommand1 = new Command("Back", Command.BACK, 0);//GEN-LINE:|31-getter|1|31-postInit
 // write post-init user code here
}//GEN-BEGIN:|31-getter|2|
        return backCommand1;
    }
//</editor-fold>//GEN-END:|31-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initialized instance of form component.
     *
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {
//GEN-END:|14-getter|0|14-preInit
 // write pre-init user code here
form = new Form("form", new Item[]{getTextField(), getTextField1()});//GEN-BEGIN:|14-getter|1|14-postInit
            form.addCommand(getOkCommand());
            form.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
 // write post-init user code here
}//GEN-BEGIN:|14-getter|2|
        return form;
    }
//</editor-fold>//GEN-END:|14-getter|2|

    /**
     * Returns a display instance.
     *
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started. Checks whether the MIDlet have been
     * already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
    
}
