/*
 *      Amri Arshad, aars120
 *      ======================
 *      Creates a square shape
 *      ======================
 */

import java.awt.*;
public class MovingSquare extends MovingRectangle {
    // Constructor with default values
    public MovingSquare(){
        super(Math.min(DEFAULTWIDTH, DEFAULTHEIGHT));
    }

    // Constructor with given size
    public MovingSquare(int size){
        super(size);
    }

    // Constructor with given values
    public MovingSquare(int x, int y, int size, int mw, int mh, Color bc, Color fc, int pathType){
        super(x, y, size, size, mw, mh, bc, fc, pathType);
    }

    public void setWidth(int width){
        this.width = width;
        this.height = width;
    }

    public void setHeight(int height){
        this.width = height;
        this.height = height;
    }
}