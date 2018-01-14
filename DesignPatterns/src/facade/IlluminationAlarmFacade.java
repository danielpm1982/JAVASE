package facade;
public class IlluminationAlarmFacade {
    private final LampsLivingRoom lampsLivingRoom;
    private final LampsKitchen lampsKitchen;
    private final LampsBedRoom lampsBedRoom;
    private final LampsOuterSide lampsOuterSide;
    private final Alarm alarm;
    public IlluminationAlarmFacade(LampsLivingRoom lampsLivingRoom, LampsKitchen lampsKitchen, LampsBedRoom lampsBedRoom, LampsOuterSide lampsOuterSide, Alarm alarm) {
        this.lampsLivingRoom = lampsLivingRoom;
        this.lampsKitchen = lampsKitchen;
        this.lampsBedRoom = lampsBedRoom;
        this.lampsOuterSide = lampsOuterSide;
        this.alarm = alarm;
    }

    public IlluminationAlarmFacade() {
        this.lampsLivingRoom = new LampsLivingRoom();
        this.lampsKitchen = new LampsKitchen();
        this.lampsBedRoom = new LampsBedRoom();
        this.lampsOuterSide = new LampsOuterSide();
        this.alarm = new Alarm();
    }
    
    public void turnOn(){
        lampsLivingRoom.turnOn();
        lampsKitchen.turnOn();
        lampsBedRoom.turnOn();
        lampsOuterSide.turnOn();
        alarm.turnOn();
    }
    public void turnOff(){
        lampsLivingRoom.turnOff();
        lampsKitchen.turnOff();
        lampsBedRoom.turnOff();
        lampsOuterSide.turnOff();
        alarm.turnOff();
    }
    @Override
    public String toString() {
        return lampsLivingRoom+" "+lampsKitchen+" "+lampsBedRoom+" "+lampsOuterSide+" "+alarm;
    }
}
