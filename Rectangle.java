// Written by Khoi Phan (phan0216) and Anvaya Shiney-Ajay (ajayx006)
import java.awt.Color;

public class Rectangle { // member variables
    double x_coord;
    double y_coord;
    double width;
    double height;
    Color recColor;

    public Rectangle( double initWidth, double initHeight, double initX, double initY) {
        x_coord = initX;
        y_coord = initY;
        width = initWidth;
        height = initHeight;
    }
    // setters and getters for perimeter, area, dimensions, and position
    public double calculatePerimeter() {
        return 2 * width + 2 * height;
    }

    public double calculateArea() {
        return width * height;
    }

    public void setColor(Color newColor) {
        recColor = newColor;
    }

    public void setPos(double new_X, double new_Y) {
        x_coord = new_X;
        y_coord = new_Y;
    }

    public void setHeight(double new_Height) {
        height = new_Height;
    }

    public void setWidth(double new_Width) {
        width = new_Width;
    }

    public Color getColor() {
        return recColor;
    }

    public double getXPos() {
        return x_coord;
    }

    public double getYPos() {
        return y_coord;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public static void main(String[] args) {
        Rectangle rec = new Rectangle(74,33, 3,4);
        System.out.println(rec.calculateArea());
    }
} // Rectangle.java