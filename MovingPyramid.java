/*
 *      Amri Arshad, aars120
 *      ========================
 *      Creates a Pyramid shape
 *      ========================
 */

import java.awt.*;
public class MovingPyramid extends MovingRectangle{
    private int xSize;  // width of all mini-rectangles
    private int ySize;  // height of all mini-rectangles
    public static int NUMBER_OF_ROWS;   // number of rows of the pyramid

    // Constructor with default values
    public MovingPyramid(){
        super();
        setUp();
    }

    // Constructor with given size
    public MovingPyramid(int size){
        super(size);
        setUp();
    }

    // Constructor with given values
    public MovingPyramid(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType){
        super(x, y, w, h, mw, mh, bc, fc, pathType);
        setUp();
    }

    // Draw the pyramid
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        // Set initial position of mini-rectangles
        int rectX = x;
        int rectY = y - ySize;
        
        // Draw the pyramid itself
        for (int i = 0; i <= NUMBER_OF_ROWS; i++){
            for (int j = 0; j < NUMBER_OF_ROWS - i; j++){
                rectX += xSize;
            }
            for (int k = 1; k <= 2*i-1; k++){
                if(k % 2 == 0){
                    g2d.setPaint(Color.white);
                    g2d.fillRect(rectX, rectY, xSize, ySize);
                    g2d.drawRect(rectX, rectY, xSize, ySize);
                }
                else{
                    g2d.setPaint(fillColor);
                    g2d.fillRect(rectX, rectY, xSize, ySize);
                    g2d.drawRect(rectX, rectY, xSize, ySize);
                }
                rectX += xSize;
            }
            rectX = x;
            rectY += ySize;
        }
        // Draw a rectangular border around pyramid
        g2d.setPaint(borderColor);
        g2d.drawRect(x, y, width, height);
    }

    // returns width of mini-rectangles
    public int getXSize(){
        return xSize;
    }

    // returns height of mini-rectangles
    public int getYSize(){
        return ySize;
    }

    // Calculates dimensions of mini-rectangles
    private void setUp(){
        NUMBER_OF_ROWS = 5;
        xSize = width / 9;
        ySize = height / NUMBER_OF_ROWS;
    }

    // sets total width
    public void setWidth(int width){
        super.setWidth(width);
        setUp();
    }

    // sets total height
    public void setHeight(int height){
        super.setHeight(height);
        setUp();
    }
}