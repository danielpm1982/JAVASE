package proxy6;
public class Proxy implements SubjectInterface{
    SubjectInterface subject;
    public Proxy() {
    }
    @Override
    public void doSomething() {
        if(subject!=null){
            subject.doSomething();
        } else{
            System.out.println(this.getClass().getSimpleName()+" says hello!!");
            System.out.println("⇈⇈⇈ Temporary response while instantiating the expensive to create Subject! ⇈⇈⇈");
            subject = new RealSubject();
            System.out.println("RealSubject successfully created!");
            this.doSomething();
        }
    }
}
