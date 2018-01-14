package templateMethod1;
public class ConcreteClass2 extends TemplateClass{
    @Override
    public void method1(){
        System.out.println("Method1() running through ConcreteClass2 object...");
    }
    @Override
    public void method2(){
        System.out.println("Method2() running through ConcreteClass2 object...");
    }
}
