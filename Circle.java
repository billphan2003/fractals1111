// Written by Khoi Phan (phan0216) and Anvaya Shiney-Ajay (ajayx006)
import java.awt.Color;

public class Circle { // member variables
    double x_coord;
    double y_coord;
    double radius;
    Color circColor;

    public Circle(double initX, double initY, double initRadius) {
        x_coord = initX;
        y_coord = initY;
        radius = initRadius;
    }
    // setters and getters for color, perimeter, area, and position
    public double calculatePerimeter(){
        return 2 * radius * Math.PI;
    }

    public double calculateArea(){
        return Math.PI * Math.pow(radius, 2);
    }

    public void setColor(Color givenColor) {
        circColor = givenColor;
    }

    public void setPos(double new_X, double new_Y) {
        x_coord = new_X;
        y_coord = new_Y;
    }

    public void setRadius(double new_Radius) {
        radius = new_Radius;
    }

    public Color getColor() {
        return circColor;
    }

    public double getXPos() {
        return x_coord;
    }

    public double getYPos() {
        return y_coord;
    }

    public double getRadius() {
        return radius;
    }
} // Circle.java