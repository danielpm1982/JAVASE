package inheritancePolimorfismInterfaces;
public class Class1 {
    private final String field1;
    private final String field2;
    private final String field3;

    public Class1(String s1, String s2, String s3) {
        field1=s1;
        field2=s2;
        field3=s3;
    }

    public Class1 doSomething(){
        return new Class1("s1", "s2", "s3");
    }
    
    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    @Override
    public String toString() {
        return "Class1: "+field1+" "+field2+" "+field3;
    }
    
}
