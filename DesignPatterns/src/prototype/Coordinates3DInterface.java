package prototype;
public interface Coordinates3DInterface extends CoordinatesGenericInterface{
    public abstract int[] getCoordinates();
    public abstract void setCoordinates(int x, int y, int z);
    public abstract void setCoordinateX(int x);
    public abstract void setCoordinateY(int y);
    public abstract void setCoordinateZ(int z);
    public abstract Coordinates3DInterface getClone();
}
