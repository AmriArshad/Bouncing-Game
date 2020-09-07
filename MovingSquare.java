import java.awt.*;
public class MovingSquare extends MovingRectangle {
    // Constructor with default values
    public MovingSquare(){
        super(Math.min(DEFAULTWIDTH, DEFAULTHEIGHT));
    }

    // Constructor with default size
    public MovingSquare(int size){
        super(size);
    }

    // Constructor with given values
    public MovingSquare(int x, int y, int size, int mw, int mh, Color bc, Color fc, int pathType){
        super(x, y, size, size, mw, mh, bc, fc, pathType);
    }
}
