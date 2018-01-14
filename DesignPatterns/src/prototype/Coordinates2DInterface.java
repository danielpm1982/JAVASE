package prototype;
public interface Coordinates2DInterface extends CoordinatesGenericInterface{
    public abstract int[] getCoordinates();
    public abstract void setCoordinates(int x, int y);
    public abstract void setCoordinateX(int x);
    public abstract void setCoordinateY(int y);
    public abstract Coordinates2DInterface getClone();
}
