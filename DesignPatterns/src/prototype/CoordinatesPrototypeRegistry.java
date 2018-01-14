package prototype;
import java.security.SecureRandom;

public class CoordinatesPrototypeRegistry {
    private final Coordinates2DInterface prototype2D;
    private final Coordinates3DInterface prototype3D;
    public CoordinatesPrototypeRegistry(Coordinates2DInterface prototype2D, Coordinates3DInterface prototype3D) {
        this.prototype2D=prototype2D;
        this.prototype3D=prototype3D;
    }
    public CoordinatesGenericInterface getGenericCoordinates(){
        int coordinateTypeToCreate = selectRandom2D3D();
        if(coordinateTypeToCreate==2){
            return prototype2D.getClone();
        } else if(coordinateTypeToCreate==3){
            return prototype3D.getClone();
        }
        return null;
    }
    private static int selectRandom2D3D(){
        return new SecureRandom().ints(2, 4).findFirst().getAsInt();
    }
    public static CoordinatesPrototypeRegistry getInstance(){
        return new CoordinatesPrototypeRegistry(new CoordinatesPrototype2D(), new CoordinatesPrototype3D());
    }
}
