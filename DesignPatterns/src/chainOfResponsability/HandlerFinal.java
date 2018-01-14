package chainOfResponsability;
import java.util.stream.Stream;

public class HandlerFinal implements HandlerInterface{
    String[] handlerTypes;
    public HandlerFinal() {
        handlerTypes = Stream.of(RequestType.values()).map(x->x.name()).toArray(String[]::new);
    }
    @Override
    public void handleRequest(RequestInterface request) {
        if(Stream.of(handlerTypes).filter(x->x.equals(request.getType())).findAny().isPresent()){
            System.out.println("Congratulations! Your request has been successfully handled by "+this.getClass().getSimpleName());
        } else{
            System.out.println("Sorry! "+this.getClass().getSimpleName()+" unable to handle the request. No handlers remaining. Request denied!");
        }
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
