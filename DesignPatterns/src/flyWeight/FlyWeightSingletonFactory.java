package flyWeight;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class FlyWeightSingletonFactory {
    private static final List<FlyWeight> FLY_WEIGHT_LIST = new ArrayList<>();
    private FlyWeightSingletonFactory() {
    }
    public static FlyWeight getFlyWeight(Class<? extends FlyWeight> type){
        FlyWeight flyWeightTemp = FLY_WEIGHT_LIST.stream().filter(x->x.getClass().getSimpleName().equals(type.getSimpleName())).findAny().orElse(null);
        if(flyWeightTemp!=null){
            System.out.print("Flyweight already exists in the pool... reusing existent instance! ");
            System.out.println(flyWeightTemp.getClass().getSimpleName()+" "+flyWeightTemp.getClass().hashCode());
        } else{
            synchronized(FlyWeightSingletonFactory.class){
                if(flyWeightTemp==null){
                    try {
                        System.out.print("Creating Flyweight: ");
                        flyWeightTemp = type.getConstructor().newInstance();
                        FLY_WEIGHT_LIST.add(flyWeightTemp);
                        System.out.println(flyWeightTemp.getClass().getSimpleName()+" "+flyWeightTemp.getClass().hashCode()+" created and added to pool!");
                    } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                        ex.printStackTrace(System.out);
                    }
                }
            }
        }
        return flyWeightTemp;
    }
}
