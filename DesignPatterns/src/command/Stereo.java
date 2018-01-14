package command;

public class Stereo {
    private boolean isOn;
    private int volume;
    private int lastVolume;
    private String mediaInside;
    private String lastMediaInside;
    public Stereo() {
        isOn=false;
        volume=0;
        mediaInside=null;
        lastVolume=0;
    }
    public void turnOn(){
        isOn=true;
    }
    public void turnOff(){
        isOn=false;
    }
    public void setVolume(int volume){
        this.volume=volume;
    }
    public int getVolume(){
        return this.volume;
    }
    public int getLastVolume() {
        return lastVolume;
    }
    public void insertMedia(String mediaName){
        this.mediaInside=mediaName;
    }
    public void ejectMedia(){
        this.mediaInside=null;
    }
    public boolean hasMedia(){
        if(mediaInside!=null){
            return true;
        } else{
            return false;
        }
    }
    public String getMedia(){
        return mediaInside;
    }
    public void setLastVolume(int lastVolume) {
        this.lastVolume = lastVolume;
    }
    public void setLastMediaInside(String lastMediaInside) {
        this.lastMediaInside=lastMediaInside;
    }
    public String getLastMediaInside() {
        return lastMediaInside;
    }
    public String getState(){
        StringBuilder sb = new StringBuilder();
        if(isOn){
            sb.append(String.format("%-5s", "ON"));
        } else{
            sb.append(String.format("%-5s", "OFF"));
        }
        sb.append(String.format("%-8s", "Volume:")).append(String.format("%-4s", volume));
        sb.append(hasMedia() ? String.format("%-14s", "Media Inside:")+mediaInside : String.format("%-14s", "Media Inside:")+"None");
        return sb.toString();
    }
}
