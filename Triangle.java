// Written by Khoi Phan (phan0216) and Anvaya Shiney-Ajay (ajayx006)
import java.awt.Color;

public class Triangle { // member variables
    double x_coord;
    double y_coord;
    double width;
    double height;
    Color triColor;

    public Triangle(double initX, double initY, double initWidth, double initHeight) {
        x_coord = initX;
        y_coord = initY;
        width = initWidth;
        height = initHeight;

    }
    // setters and getters for perimeter, area, color, and dimensions
    public double calculatePerimeter() {
        return 2 * Math.sqrt(Math.pow(width / 2,2) + Math.pow(height, 2)) + width;
    }

    public double calculateArea() {
        return (width * height) / 2;
    }

    public void setColor(Color givenColor) {
        triColor = givenColor;
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
        return triColor;
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
} // Triangle.java
