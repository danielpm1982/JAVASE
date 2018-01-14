package command;
public class StereoOffCommand implements Command{
    private final Stereo stereo;
    private boolean wasTurnedOff;
    public StereoOffCommand(Stereo stereo) {
        this.stereo=stereo;
        wasTurnedOff=false;
    }
    @Override
    public void execute() {
        if(stereo.hasMedia()){
            stereo.setLastMediaInside(stereo.getMedia());
            stereo.ejectMedia();
        }
        stereo.setLastVolume(stereo.getVolume());
        stereo.setVolume(0);
        stereo.turnOff();
        wasTurnedOff=true;
    }
    @Override
    public void undo() {
        if(wasTurnedOff){
            if(!stereo.hasMedia()){
                String lastMediaInside=stereo.getLastMediaInside();
                if(lastMediaInside!=null)
                    stereo.insertMedia(lastMediaInside);
                else
                    stereo.insertMedia(StereoMediaList.getRandomMediaName());
            }
            if(stereo.getLastVolume()!=0){
                stereo.setVolume(stereo.getLastVolume());
            } else{
                stereo.setVolume(10);
            }
            stereo.turnOn();
        }
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
