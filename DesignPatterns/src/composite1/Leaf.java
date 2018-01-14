package composite1;

public class Leaf implements Component{
    private final String description;
    private final String name;
    private final int code;
    public Leaf() {
        this("no description!");
    }
    public Leaf(String description) {
        this(-1,null,description);
    }    
    public Leaf(int code, String name, String description) {
        if(code!=-1 && name!=null){
            this.code=code;
            this.name=name;
        } else{
            this.code=this.getHashCode();
            this.name=this.getClassName();
        }
        this.description=description;
    }
    @Override
    public String getDescription() {
        return String.format("%-19s %-4s %-13s %-4s %s", "code: "+this.code+";", "┋┋","name: "+this.name+";","┋┋","description: "+this.description);
    }
    public int getCode() {
        return code;
    }
    @Override
    public String toString() {
        return getDescription();
    }
    @Override
    public void list() {
        System.out.println(getDescription());
    }
}
