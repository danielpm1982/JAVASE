package command;
import java.util.Stack;

public class StereoSwitchMediaCommand implements Command{
    private final Stereo stereo;
    private boolean switchedMedia;
    private final Stack<String> switchedMediaStack;
    public StereoSwitchMediaCommand(Stereo stereo) {
        this.stereo=stereo;
        switchedMedia=false;
        switchedMediaStack = new Stack<>();
    }
    @Override
    public void execute() {
        if(stereo.hasMedia()){
            stereo.setLastMediaInside(stereo.getMedia());
            switchedMediaStack.push(stereo.getMedia());
            stereo.ejectMedia();
        }
        stereo.insertMedia(StereoMediaList.getRandomMediaName());
        switchedMedia=true;
    }
    @Override
    public void undo() {
        if(switchedMedia){
            if(stereo.hasMedia()){
                stereo.ejectMedia();
            }
            if(!switchedMediaStack.empty()){
                stereo.insertMedia(switchedMediaStack.pop());
            } else{
                stereo.insertMedia(StereoMediaList.getRandomMediaName());
            }
        }
    }
    public Stack<String> getSwitchedMediaStack() {
        return switchedMediaStack;
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
