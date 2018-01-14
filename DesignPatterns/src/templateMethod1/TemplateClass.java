package templateMethod1;
public abstract class TemplateClass {
    public final void templateMethod(){
        method1();
        method2();
        method3();
        if(method5()){
            method4();
        }
    }
    public abstract void method1(); //abstract method
    public abstract void method2(); //abstract method
    public final void method3(){ //concrete final method
        System.out.println("Method3() running through TemplateClass declaration...");
    }
    public void method4(){  //concrete not final - hook - method
        System.out.println("HOOK Method4() running through TemplateClass declaration...");
    }
    public boolean method5(){ //concrete not final - hook - method
        return true;
    }
}
