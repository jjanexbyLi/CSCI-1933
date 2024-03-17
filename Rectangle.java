import java.awt.Color;
public class Rectangle {
    double x_position;
    double y_position;
    double height;
    double width;
    Color R_color;
    public Rectangle(double x, double y, double w, double h) {
        x_position = x;
        y_position = y;
        width = w;
        height = h;
    }
    public double calculatePerimeter(){
        return 2*(width+height);
    }
    public double calculateArea() {
        return width*height;
    }
    public void setColor(Color cNew){
        R_color = cNew;
    }
    public void setPos(double xNew,double yNew){
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
        return R_color;
    }
    public double getXPos() {
        return x_position;
    }
    public double getYPos() {
        return y_position;
    }
    public double getHeight(){
        return height;
    }
    public double getWidth() {
        return width;
    }
}
