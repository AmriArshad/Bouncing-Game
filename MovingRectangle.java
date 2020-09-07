/*
 *      Amri Arshad, aars120
 *      =========================
 *      Creates a rectangle shape
 *      =========================
 */

import java.awt.*;
public class MovingRectangle extends MovingShape{
    // Constructor with default values
    public MovingRectangle(){
        super();
    }

    // Constructor with given size
    public MovingRectangle(int size){
        super(size);
    }

    // Constructor with given values
    public MovingRectangle(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType){
        super(x, y, w, h, mw, mh, bc, fc, pathType);
    }
    
    // Check if a point lies within the rectangle
    public boolean contains(Point p) {
        Rectangle r = new Rectangle(x, y, width, height);
        return r.contains(p);
    }

    // Draw the rectangle
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(fillColor);
        g2d.fillRect(x, y, width, height);
        g2d.setPaint(borderColor);
        g2d.drawRect(x, y, width, height);
    }

    // Get area of the rectangle
    public double getArea() {
        return width * height;
    }
}