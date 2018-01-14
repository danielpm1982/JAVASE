package facade;
public class AudioVisualFacade {
    private final TV tv;
    private final BlueRay blueRay;
    private final HomeTheater homeTheater;
    private final VideoGameConsole videoGameConsole;
    public AudioVisualFacade(TV tv, BlueRay blueRay, HomeTheater homeTheater, VideoGameConsole videoGameConsole) {
        this.tv = tv;
        this.blueRay = blueRay;
        this.homeTheater = homeTheater;
        this.videoGameConsole = videoGameConsole;
    }
    public AudioVisualFacade() {
        this.tv = new TV();
        this.blueRay = new BlueRay();
        this.homeTheater = new HomeTheater();
        this.videoGameConsole = new VideoGameConsole();
    }
    public void turnOn(){
        tv.turnOn();
        blueRay.turnOn();
        homeTheater.turnOn();
        videoGameConsole.turnOn();
    }
    public void turnOff(){
        tv.turnOff();
        blueRay.turnOff();
        homeTheater.turnOff();
        videoGameConsole.turnOff();
    }
    @Override
    public String toString() {
        return tv+" "+blueRay+" "+homeTheater+" "+videoGameConsole;
    }
}
