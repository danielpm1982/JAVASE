package prototype;
public class CoordinatesPrototype3D implements Coordinates3DInterface, Cloneable{
    private int x,y,z;
    public CoordinatesPrototype3D() {
        x=y=z=-1;
    }
    @Override
    public int[] getCoordinates() {
        return new int[]{x,y,z};
    }
    @Override
    public void setCoordinates(int x, int y, int z) {
        this.x=x;
        this.y=y;
        this.z=z;
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
    public void setCoordinateZ(int z) {
        this.z=z;
    }
    @Override
    public Coordinates3DInterface getClone() {
        try {
//            return (CoordinatesPrototype3D)super.clone();
            return (Coordinates3DInterface)this.clone();
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
