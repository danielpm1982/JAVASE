package model;
import java.util.HashMap;
import java.util.Map;

public class MySystemProperties {
    public static Map<String,String> getProperties(){
        System.getProperties().forEach((x,y)->System.out.println(x+" "+y));
        Map<String,String> map = new HashMap<>();
        System.getProperties().forEach((x,y)->map.put(x.toString(), y.toString()));
        return map;
    }
}
