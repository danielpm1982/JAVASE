package swingtest;
public class ObtainStringException extends Exception{
    private String s;
    public ObtainStringException(String s){
        this.s=s;
    }
    public String getString(){
        return this.s;
    }
}
