package templateMethod1;
import java.util.Scanner;

public class ConcreteClass1 extends TemplateClass{
    @Override
    public void method1(){ //abstract method implementation
        System.out.println("Method1() running through ConcreteClass1 object...");
    }
    @Override
    public void method2(){ //abstract method implementation
        System.out.println("Method2() running through ConcreteClass1 object...");
    }
    @Override
    public void method4(){ //hook method overriding
        System.out.println("HOOK Method4() running through ConcreteClass1 object...");
    }
    @Override
    public boolean method5() { //hook method overriding
        String userInput = getUserInput();
        if(userInput!=null&&!userInput.equals("")){
            char c = userInput.toLowerCase().charAt(0);
            return c=='y';
        }
        return false;
    }
    private String getUserInput(){ //auxiliar method, not related to the pattern
        System.out.println("Show HOOK method4() ? Y/N");
        String charSequence;
        Scanner s = new Scanner(System.in);
        charSequence = s.nextLine();
        return charSequence;
    }
}
