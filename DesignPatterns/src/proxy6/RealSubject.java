package proxy6;

public class RealSubject implements SubjectInterface{
    public RealSubject() {
        try {
            System.out.println("Waiting 10 seconds...");
            Thread.sleep(10000); //simulating an expensive to create object
        } catch (InterruptedException ex) {
            ex.printStackTrace(System.out);
        }
    }
    @Override
    public void doSomething() {
        System.out.println(this.getClass().getSimpleName()+" says hello!!");
    }
}
