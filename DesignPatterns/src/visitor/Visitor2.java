package visitor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

public class Visitor2 implements VisitorInterface{
    private final List<String> log;
    public Visitor2(List<String> log) {
        this.log = log;
    }
    @Override
    public void visitElementA(ElementA elementA) {
        String newStateString = "new Element A State set from "+this.getClass().getSimpleName()+" ("+LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))+") !";
        log.add(newStateString);
        elementA.operationA(newStateString);
    }
    @Override
    public void visitElementB(ElementB elementB) {
        String newStateString = "new Element B State set from "+this.getClass().getSimpleName()+" ("+LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))+") !";
        log.add(newStateString);
        elementB.operationB(newStateString);
    }
    @Override
    public void visitElementC(ElementC elementC) {
        String newStateString = "new Element C State set from "+this.getClass().getSimpleName()+" ("+LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))+") !";
        log.add(newStateString);
        elementC.operationC(newStateString);
    }    
}
