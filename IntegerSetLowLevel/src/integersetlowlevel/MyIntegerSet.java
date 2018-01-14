package integersetlowlevel;
import java.util.stream.Stream;

public class MyIntegerSet implements IntegerSet{
    private Integer[] integerArray;
    public MyIntegerSet(Integer... integerArray){
        this.integerArray = integerArray;
        try {
            validateIntegerArray(this.integerArray);
        } catch (InvalidIntegerNumberException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void add(Integer n){
        try{
            validateIntegerNumber(n);
            if(Stream.of(integerArray).parallel().filter(x->x.equals(n)).findAny().isPresent()){
                throw new IntegerNumberAlreadyExistsException(null, null, n);
            } else{
                Integer[] tempArray = new Integer[integerArray.length+1];
                for(int i=0;i<tempArray.length-1;i++){
                    tempArray[i]=integerArray[i];
                }
                tempArray[tempArray.length-1]=n;
                integerArray=tempArray;
            }
        } catch (InvalidIntegerNumberException|IntegerNumberAlreadyExistsException ex){
            ex.printStackTrace();
        }
    }
    @Override
    public void remove(Integer n) {
        try{
            validateIntegerNumber(n);
            if(Stream.of(integerArray).parallel().filter(x->x.equals(n)).findAny().isPresent()){
                Integer[] tempArray = new Integer[integerArray.length-1];
                for(int i=0;i<tempArray.length;i++){
                    tempArray[i]=integerArray[i];
                }
                integerArray=tempArray;
            } else{
                throw new IntegerNumberDoesNotExistException(null, null, n);
            }
        } catch (InvalidIntegerNumberException|IntegerNumberDoesNotExistException ex){
            ex.printStackTrace();
        }
    }
    @Override
    public IntegerSet union(IntegerSet set) {
        if(set instanceof MyIntegerSet){
            Integer[] setToAdd = Stream.of(((MyIntegerSet)set).getIntegerArray()).parallel().filter(x->!containsIntegerInArray(integerArray, x)).distinct().toArray(Integer[]::new);
            MyIntegerSet resultSet = new MyIntegerSet(cloneArray(integerArray));
            Stream.of(setToAdd).forEach(x->resultSet.add(x));
            return resultSet;
        }
        return null;
    }
    @Override
    public IntegerSet interSection(IntegerSet set) {
        if(set instanceof MyIntegerSet){
            Integer[] setIntersection = Stream.of(((MyIntegerSet)set).getIntegerArray()).parallel().filter(x->containsIntegerInArray(integerArray, x)).toArray(Integer[]::new);
            return new MyIntegerSet(setIntersection);
        }
        return null;
    }
    @Override
    public IntegerSet diff(IntegerSet set) {
        if(set instanceof MyIntegerSet){
            Integer[] setDiff = Stream.of(integerArray).parallel().filter(x->!containsIntegerInArray(((MyIntegerSet)set).getIntegerArray(), x)).toArray(Integer[]::new);
            return new MyIntegerSet(setDiff);
        }
        return null;
    }
    private boolean validateIntegerArray(Integer[] integerArray) throws InvalidIntegerNumberException{
        for(Integer i:integerArray){
            if(i<0||i>=100){
                throw new InvalidIntegerNumberException(null, null, i);
            }
        }
        return true;
    }
    private boolean validateIntegerNumber(Integer n) throws InvalidIntegerNumberException{
        if(n<0||n>=100){
            throw new InvalidIntegerNumberException(null, null, n);
        }
        return true;
    }
    private boolean containsIntegerInArray(Integer[] array, Integer n){
        if(Stream.of(array).filter(x->x.equals(n)).count()>0){
            return true;
        } else{
            return false;
        }
    }
    private Integer[] cloneArray(Integer[] array){
        Integer[] cloned = new Integer[array.length];
        System.arraycopy(array, 0, cloned, 0, cloned.length);
        return cloned;
    }
    public Integer[] getIntegerArray() {
        return integerArray;
    }
    
    private String getIntegerArrayString(){
        return Stream.of(integerArray).map(x->x.toString()).reduce(" ",(a,b)->a+b+" ");
    }
    @Override
    public String toString() {
        return "["+getIntegerArrayString()+"]";
    }
}
