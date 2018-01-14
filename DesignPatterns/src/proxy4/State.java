package proxy4;
import java.io.Serializable;

public interface State extends Serializable{
    public abstract void changeState();
}
