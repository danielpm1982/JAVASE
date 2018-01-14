package builder;
import java.math.BigInteger;

public class ConcreteBuilderAnother implements AbstractBuilder{
    private Double att1;
    private Float att2;
    private BigInteger att3;
    public ConcreteBuilderAnother() {
    }
    @Override
    public void buildAttribute1(String att1) {
        if(att1!=null){
            this.att1=Double.parseDouble(att1);
        }
    }
    @Override
    public void buildAttribute2(String att2) {
        if(att2!=null){
            this.att2=Float.parseFloat(att2);
        }
    }
    @Override
    public void buildAttribute3(String att3) {
        if(att3!=null){
            this.att3=new BigInteger(att3);
        }
    }
    @Override
    public ProductInterface getFinalProduct() throws InstantiationException{
        if(att1!=null&&att2!=null&&att3!=null){
            return new Product4(att1, att2, att3);
        } else {
            throw new InstantiationException("Invalid constructor parameter arguments! Product NOT created!");
        }
    }
    @Override
    public void clearPreviousValues(){
        att1=null;
        att2=null;
        att3=null;
    }
}
