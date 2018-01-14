package inheritancePolimorfismInterfaces;
public class Class2 extends Class1{
    private final String field4;
    
    public Class2(String s1, String s2, String s3, String s4) {
        super(s1, s2, s3);
        this.field4=s4;
    }
    @Override
    public Class2 doSomething(){
        return new Class2("s1", "s2", "s3","s4");
    }
    
    public String polimorphicMethod(Class1 c){
        return c.toString();
    }
    
    public String getField4() {
        return field4;
    }
    
    @Override
    public String toString() {
        return "Class2: "+super.getField1()+" "+super.getField2()+" "+super.getField3()+" "+field4;
    }
    
    public static Class2 getInstance(){
        return new Class2("s1", "s2", "s3", "s4");
    }
}
