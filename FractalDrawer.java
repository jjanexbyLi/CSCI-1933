// FractalDrawer class draws a fractal of a shape indicated by user i
import java.awt.*;
import java.util.Scanner;

public class FractalDrawer {
    private double totalArea=0 ;
    private Color[] colorsByLevel = new Color[] {Color.GREEN,Color.BLACK,Color.darkGray,Color.ORANGE,Color.PINK,Color.RED,Color.WHITE};
    public FractalDrawer(){}     // constructor
    //TODO:
    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the frac
    public double drawFractal(String type) {
        Canvas can = new Canvas();
        if (type .equals("triangle")){
            drawTriangleFractal(400,400,400,400,Color.BLUE,can,1);
        }
        else if (type.equals("circle")){
            drawCircleFractal(400,400,400,Color.lightGray,can,1);

        } else{
            drawRectangleFractal(500,400,200,200,Color.DARK_GRAY,can,1);
        }
        return totalArea;
    }
    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques.
    public void drawTriangleFractal(double width, double height, double x, double
            y, Color c, Canvas can, int level){
        Triangle myTriangle = new Triangle(x,y,width,height);
        myTriangle.setColor(c);
        can.drawShape(myTriangle);
        totalArea += myTriangle.calculateArea();
        if (level > 7){
            return;
        } else{
            drawTriangleFractal(width*0.5,height*0.5,x,y,colorsByLevel[level-1],can,level+1);
            drawTriangleFractal(width*0.5,height*0.5,x+(width*0.5),y,colorsByLevel[level-1],can,level+1);
            drawTriangleFractal(width*0.5,height*0.5,x+(width*0.25),y+(height*0.5),colorsByLevel[level-1],can,level+1);
            level+=1;
        }
    }
    public void drawCircleFractal(double radius, double x, double y, Color c,
                                  Canvas can, int level) {
        Circle myCircle = new Circle(x,y,radius);
        myCircle.setColor(c);
        can.drawShape(myCircle);
        totalArea+=myCircle.calculateArea();
        if (level > 7) {
            return;
        } else {
            drawCircleFractal(radius*0.47,x,y+radius*0.4,colorsByLevel[level-1],can,level+1);
            drawCircleFractal(radius*0.47,x,y-radius*0.4,colorsByLevel[level-1],can,level+1);
            drawCircleFractal(radius*0.47,x+radius*0.4,y,colorsByLevel[level-1],can,level+1);
            drawCircleFractal(radius*0.47,x-radius*0.4,y,colorsByLevel[level-1],can,level+1);
            level+=1;
        }
    }
    public void drawRectangleFractal(double width, double height, double x, double
            y, Color c, Canvas can, int level) {
        Rectangle myRectangle = new Rectangle(x,y,width,height);
        myRectangle.setColor(c);
        can.drawShape(myRectangle);
        totalArea+=myRectangle.calculateArea();
        if(level > 7) {
            return;
        } else {
            drawRectangleFractal(width*0.4,height*0.4,x,y,colorsByLevel[level-1],can,level+1);
            drawRectangleFractal(width*0.4,height*0.4,x+width*0.5,y,colorsByLevel[level-1],can,level+1);
            drawRectangleFractal(width*0.4,height*0.4,x,y+height*0.5,colorsByLevel[level-1],can,level+1);
            drawRectangleFractal(width*0.4,height*0.4,x+width*0.5,y+height*0.5,colorsByLevel[level-1],can,level+1);
            level+=1;
        }
    }
    //TODO:
    // main should ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal.
    public static void main(String[] args){
        System.out.println("choices: circle, triangle, or rectangle");
        Scanner myScanner = new Scanner(System.in);
        String input = myScanner.nextLine();
        FractalDrawer Draw = new FractalDrawer();
        System.out.println(Draw.drawFractal(input));
    }
}