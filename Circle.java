import java.awt.Color;
public class Circle {
    double x;
    double y;
    double radius;
    Color C_color;
    public Circle(double x_position ,double y_position,double radius){
        x = x_position;
        y = y_position;
        this.radius = radius;
    }
    public double calculatePerimeter(){
        return Math.PI * (2 * radius);
    }
    public double calculateArea(){
        return 2*Math.PI*radius*radius;
    }
    public void setColor(Color colorNew){
        C_color = colorNew;
    }
    public void setPos(double xNew,double yNew){
        x = xNew;
        y = yNew;
    }
    public void setRadius(double radiusNew){
        radius = radiusNew;
    }
    public Color getColor() {
        return C_color;
    }
    public double getXPos(){
        return x;
    }
    public double getYPos(){
        return y;
    }
    public double getRadius() {
        return radius;
    }
}
