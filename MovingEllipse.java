/*
 *      Amri Arshad, aars120
 *      ========================
 *      Creates an Ellipse shape
 *      ========================
 */

import java.awt.*;
public class MovingEllipse extends MovingShape{
    // Constructor with default values
    public MovingEllipse(){
        super();
    }
    
    // Constructor with given size
    public MovingEllipse(int size){
        super(size);
    }

    // Constructor with given values
    public MovingEllipse(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType){
        super(x, y, w, h, mw, mh, bc, fc, pathType);
    }

    // Check if a point lies within the circle
    public boolean contains(Point p) {
        double dx, dy;
        Point EndPt = new Point(x + width, y + height);
        dx = (2 * p.x - x - EndPt.x) / (double) width;
        dy = (2 * p.y - y - EndPt.y) / (double) height;
        return dx * dx + dy * dy < 1.0; 
    }

    // Draw the circle
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(fillColor);
        g2d.fillOval(x, y, width, height);
        g2d.setPaint(borderColor);
        g2d.drawOval(x, y, width, height);
    }

    // Get area of the cirle
    public double getArea() {
        return Math.PI * (width/2) * (height/2);
    }
}