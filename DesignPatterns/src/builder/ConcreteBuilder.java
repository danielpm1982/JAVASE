package builder;
import java.math.BigDecimal;

public class ConcreteBuilder implements AbstractBuilder{
    private String att1;
    private int att2;
    private BigDecimal att3;
    public ConcreteBuilder() {
        att1=null;
        att2=-1;
        att3=null;
    }
    @Override
    public void buildAttribute1(String att1) {
        if(att1!=null){
            this.att1=att1;
        }
    }
    @Override
    public void buildAttribute2(String att2) {
        if(att2!=null){
            this.att2=Integer.parseInt(att2);
        }
    }
    @Override
    public void buildAttribute3(String att3) {
        if(att3!=null){
            this.att3=new BigDecimal(att3);
        }
    }
    @Override
    public ProductInterface getFinalProduct() throws InstantiationException{
        if(att1!=null&&att2!=-1&&att3!=null){
            return new Product1(att1, att2, att3);
        } else if(att1!=null&&att2!=-1&&att3==null){
            return new Product2(att1, att2);
        } else if(att1!=null&&att2==-1&&att3==null){
            return new Product3(att1);
        } else{
            throw new InstantiationException("Invalid constructor parameter arguments! Product NOT created!");
        }
    }
    @Override
    public void clearPreviousValues(){
        att1=null;
        att2=-1;
        att3=null;
    }
}
