package command;
public class StereoMuteCommand implements Command{
    private final Stereo stereo;
    public StereoMuteCommand(Stereo stereo) {
        this.stereo=stereo;
    }
    @Override
    public void execute() {
        if(stereo.getVolume()!=0){
            stereo.setLastVolume(stereo.getVolume());
            stereo.setVolume(0);
        } else{
            stereo.setVolume(stereo.getLastVolume());
        }
    }
    @Override
    public void undo() {
        execute();
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
