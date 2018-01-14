package prototype;

public class CoordinatesPrototype2D implements Coordinates2DInterface, Cloneable{
    private int x,y;
    public CoordinatesPrototype2D() {
        x=y=-1;
    }
    @Override
    public int[] getCoordinates() {
        return new int[]{x,y};
    }
    @Override
    public void setCoordinates(int x, int y) {
        this.x=x;
        this.y=y;
    }
    @Override
    public void setCoordinateX(int x) {
        this.x=x;
    }
    @Override
    public void setCoordinateY(int y) {
        this.y=y;
    }
    @Override
    public Coordinates2DInterface getClone() {
        try {
//            return (CoordinatesPrototype2D)super.clone();
            return (Coordinates2DInterface)this.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
