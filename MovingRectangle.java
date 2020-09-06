import java.awt.*;
public class MovingRectangle extends MovingShape{

    // Constructor with default values
    public MovingRectangle(){
        super();
    }

    // Constructor with default size
    public MovingRectangle(int size){
        super(size);
    }

    // Constructor with given values
    public MovingRectangle(int x, int y, int currentWidth, int currentHeight, int marginWidth, int marginHeight, Color currentBorderColor, Color currentFillColor, int currentPath){
        super(x, y, currentWidth, currentHeight, marginWidth, marginHeight, currentBorderColor, currentFillColor, currentPath);
    }
    
    // Check if a point lies within the rectangle
    public boolean contains(Point p) {
        if (p.getX() > x && p.getX() < width && p.getY() > y && p.getY() < height){
            return true;
        }
        return false;
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