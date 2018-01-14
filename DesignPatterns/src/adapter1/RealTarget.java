package adapter1;
public class RealTarget implements TargetInterface{
    @Override
    public String targetMethod() {
        return "RealTarget was called!";
    }
}
