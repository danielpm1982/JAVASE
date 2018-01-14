package templateMethod2;
public class TemplateClass {
    ComposedClass composedClass;
    public TemplateClass(ComposedClass composedClass) {
        this.composedClass = composedClass;
    }
    public final void templateMethod(){
        method1();
        composedClass.composedMethod();
    }
    public final void method1(){ //concrete final method
        System.out.println("Method1() running through TemplateClass object...");
    }
}
