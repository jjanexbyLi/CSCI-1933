import java.awt.Color;
import java.lang.Math;
public class Triangle {
    double x_position;
    double y_position;
    double width;
    double height;
    Color T_color;
    public Triangle(double x_position,double y_position,double width,double height){
        this.x_position = x_position;
        this.y_position = y_position;
        this.width = width;
        this.height = height;
    }
    public double calculatePerimeter(){
        double half_width = width*(1.0/2.0);
        double one_side = Math.sqrt(height*height+half_width*half_width);
        return width+2*one_side;
    }
    public double calculateArea() {
        return width*height*(1.0/2.0);
    }
    public void setColor(Color colorNew) {
        T_color = colorNew;
    }
    public void setPos(double xNew,double yNew) {
        x_position = xNew;
        y_position = yNew;
    }
    public void setHeight(double hNew) {
        height = hNew;
    }
    public void setWidth(double wNew) {
        width = wNew;
    }
    public Color getColor() {
        return T_color;
    }
    public double getXPos() {
        return x_position;
    }
    public double getYPos() {
        return y_position;
    }
    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }
}
