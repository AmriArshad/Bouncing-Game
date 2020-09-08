/*
 *      Amri Arshad, aars120
 *      ===================================
 *      Creates an overlapping square shape
 *      ===================================
 */

import java.awt.*;
import java.util.*;
public class MovingOverlappedSquare extends MovingRectangle{
    private boolean isOverlapped;   // if both squares overlap
    private Random rand;    // used to generate a random integer
    private Rectangle square1;  // mini-square object
    private Rectangle square2;  // mini-square object
    public static int SIZE = 30;    //constant size of mini-squares

    // Constructor with default values
    public MovingOverlappedSquare(Random rand){
        super();
        this.rand = rand;
        setUp();
    }

    // Constructor with given size
    public MovingOverlappedSquare(int size, Random rand){
        super(size);
        this.rand = rand;
        if (size < SIZE){
            width = 2*SIZE + 1;
            height = SIZE + 1;
        }
        else if (size < 2*SIZE){
            width = 2*SIZE + 1;
        }
        setUp();
    }

    // Constructor with given values
    public MovingOverlappedSquare(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType, Random rand){
        super(x, y, w, h, mw, mh, bc, fc, pathType);
        this.rand = rand;
        if (w < 2*SIZE){
            width = 2*SIZE + 1;
        }
        if (h < SIZE){
            height = SIZE + 1;
        }
        setUp();
    }

    // checks if random object is not null
    public boolean isRandomReady(){
        return (rand != null);
    }

    // draws the two squares inside a rectangular boundary region
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        if  (getIsOverlapped() == false){
            g2d.setPaint(borderColor);
            g2d.drawRect(square1.x, square1.y, square1.width, square1.height);

            g2d.setPaint(borderColor);
            g2d.drawRect(square2.x, square2.y, square2.width, square2.height);
        }
        else{
            g2d.setPaint(fillColor);
            g2d.fillRect(square1.x, square1.y, square1.width, square1.height);

            g2d.setPaint(fillColor);
            g2d.fillRect(square2.x, square2.y, square2.width, square2.height);

        }
       
        g2d.setPaint(borderColor);
        g2d.drawRect(x, y, width, height);
    }

    // sets up dimensions of the squares and indicates if they overlap or not
    private void setUp(){
        int x1 = rand.nextInt(getWidth()-SIZE) + x;
        int y1 = rand.nextInt(getHeight()-SIZE) + y;
        square1 = new Rectangle(x1, y1, SIZE, SIZE);

        int x2 = rand.nextInt(getWidth()-SIZE) + x;
        int y2 = rand.nextInt(getHeight()-SIZE) + y;
        square2 = new Rectangle(x2, y2, SIZE, SIZE);

        isOverlapped = square1.intersects(square2);
    }

    // returns overlap value
    public boolean getIsOverlapped(){
        return isOverlapped;
    }

    // returns first square object
    public Rectangle getSquare1(){
        return square1;
    }
    
    // returns second square object
    public Rectangle getSquare2(){
        return square2;
    }

    // moves the squares with the boundary
    public void move(){
        super.move();

        // if selected path is BouncingPath
        if (path instanceof BouncingPath){
            square1.x += path.deltaX;
            square1.y += path.deltaY;
    
            square2.x += path.deltaX;
            square2.y += path.deltaY;
        }

        // if selected path is FallingPath
        else if (path instanceof FallingPath){
            square1.y += path.deltaY;
            square2.y += path.deltaY;

            // resets position of squares if rectangle goes to top
            if (y == 0){
                square1.y = square1.y - y - marginHeight + height;
                square2.y = square2.y - y - marginHeight + height;
            }
        }
    }

    // sets width if its greater than 2*SIZE
    public void setWidth(int width){
        if (width >= 2*SIZE){
            this.width = width;
            setUp();
        }
    }

    // sets height if its greater than SIZE
    public void setHeight(int height){
        if (height >= SIZE){
            this.height = height;
            setUp();
        }
    }
}