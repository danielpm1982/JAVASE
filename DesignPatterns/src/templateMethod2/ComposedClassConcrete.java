package templateMethod2;
public class ComposedClassConcrete implements ComposedClass{
    @Override
    public void composedMethod() {
        System.out.println("ComposedMethod() running through ComposedClassConcrete object...");
    }
}
