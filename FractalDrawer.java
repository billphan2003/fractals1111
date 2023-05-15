// Khoi Phan, phan0216
// Anvaya Shiney-Ajay, ajayx006
// FractalDrawer class draws a level 7 fractal of a shape indicated by user input, whereby each recursive level has one
// randomized color
import java.awt.Color;
import java.lang.Math;          // for positions
import java.util.Random;        // for later random color generation
import java.util.Scanner;       // for user input

public class FractalDrawer {
    private double totalArea=0;  // member variable for tracking the total area

    public FractalDrawer() {

    }  // (empty) constructor


    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {
        Random rand = new Random(); // color for n-level shape
        Color[] r_colors = new Color[7];
        for (int i = 0; i<7; i++){
            r_colors[i] = new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat());
        } // creates a random seven-color list; unfortunately, only ≤ 7 levels can be drawn
        //if desired, r_colors does not need to be used, and could be substituted below for a different Color[] object
        Canvas cv = new Canvas(900,1440);
        switch (type) { // calls respective 7-level fractal-drawing methods, or error message if invalid output
            case "triangle" ->
                    drawTriangleFractal(250, 250, cv.getWidth() / 2.0 - 250 / 4.0,
                            cv.getHeight() / 2.0 - 250 / 4.0, r_colors, cv, 7);
            case "circle" ->
                    drawCircleFractal(250, cv.getWidth() / 2.0 - 250 / 4.0,
                            cv.getHeight() / 2.0 - 250 / 4.0, r_colors, 0.0, cv, 7);
            case "rectangle" ->
                    drawRectangleFractal(200, 200,cv.getWidth() / 2.0 - 250 / 2.0,
                            cv.getHeight() / 2.0 - 250 / 2.0,  r_colors, 0.25, cv, 7);
            default -> System.out.println("Sorry, I can't draw that.");
        }

        return totalArea; // each recursive call will += the shape's calculateArea() getter to totalArea
    } // drawFractal


    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color[] color_list, Canvas can,
    int level){
        Triangle n_Tri = new Triangle(x, y, width, height); // code for drawing the base triangle
        totalArea += n_Tri.calculateArea();
        n_Tri.setColor(color_list[level-1]);
        can.drawShape(n_Tri);

        if (level != 1) {
            // top left triangle n-1
            drawTriangleFractal(n_Tri.getWidth()/2, n_Tri.getHeight()/2, n_Tri.getXPos() 
                - (n_Tri.getWidth()/4), n_Tri.getYPos() - (n_Tri.getHeight()/2), color_list, can, level-1);

            // top right triangle n-1
            drawTriangleFractal(n_Tri.getWidth()/2, n_Tri.getHeight()/2, n_Tri.getXPos() 
                + (n_Tri.getWidth() * 3/4), n_Tri.getYPos() - (n_Tri.getHeight()/2), color_list, can, level-1);

            // bottom triangle n-1
            drawTriangleFractal(n_Tri.getWidth()/2, n_Tri.getHeight()/2, n_Tri.getXPos() 
                + (n_Tri.getWidth()/4), n_Tri.getYPos() + (n_Tri.getHeight()/2), color_list, can, level-1);

        } // recursive case for three triangles "growing" out the sides of its n-1 parent triangle, creating an upside
        // -down Sierpinski fractal.
    } // drawTriangleFractal


    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color[] color_list, double offset, Canvas can,
            int level) {
        double ratio = Math.sqrt(2)/2 + offset; //allows for centering on the edge, and then moving from that
        Circle n_Cir = new Circle(x, y, radius);
        totalArea += n_Cir.calculateArea();
        n_Cir.setColor(color_list[level-1]);
        can.drawShape(n_Cir);
        if (level != 1) { // draws a circle at level n, then four circles at half the radius of the circle at level n-1
            drawCircleFractal(n_Cir.getRadius()/2, n_Cir.getXPos() - n_Cir.getRadius()*ratio, n_Cir.getYPos() 
                - n_Cir.getRadius()*ratio, color_list, offset, can, level-1); // top left circle level n-1

            drawCircleFractal(n_Cir.getRadius()/2, n_Cir.getXPos() + n_Cir.getRadius()*ratio, n_Cir.getYPos() 
                - n_Cir.getRadius()*ratio, color_list, offset, can, level-1); // top right circle level n-1

            drawCircleFractal(n_Cir.getRadius()/2, n_Cir.getXPos() - n_Cir.getRadius()*ratio, n_Cir.getYPos() 
                + n_Cir.getRadius()*ratio, color_list, offset, can, level-1); // bottom left circle level n-1

            drawCircleFractal(n_Cir.getRadius()/2, n_Cir.getXPos() + n_Cir.getRadius()*ratio, n_Cir.getYPos() 
                + n_Cir.getRadius()*ratio, color_list, offset, can, level-1); // bottom right circle level n-1
        } // recursive cases for four circles, each with half the radius of its n-1 parent
    } // drawCircleFractal


    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color[] color_list, double offset,
            Canvas can, int level) {
        Rectangle n_Rec = new Rectangle(width, height, x, y);
        totalArea += n_Rec.calculateArea();
        n_Rec.setColor(color_list[level-1]);
        can.drawShape(n_Rec);
        if (level != 1) {
            drawRectangleFractal(n_Rec.getWidth()/2, n_Rec.getHeight()/2, n_Rec.getXPos()+(1+offset)*n_Rec.getWidth(),
                    n_Rec.getYPos()+(1+offset)*n_Rec.getHeight(), color_list, offset, can, level-1);
            drawRectangleFractal(n_Rec.getWidth()/2, n_Rec.getHeight()/2, n_Rec.getXPos()+(1+offset)*n_Rec.getWidth(),
                    n_Rec.getYPos()-(1-offset)*n_Rec.getHeight(), color_list, offset, can, level-1);
            drawRectangleFractal(n_Rec.getWidth()/2, n_Rec.getHeight()/2, n_Rec.getXPos()-(1-offset)*n_Rec.getWidth(),
                    n_Rec.getYPos()+(1+offset)*n_Rec.getHeight(), color_list, offset, can, level-1);
            drawRectangleFractal(n_Rec.getWidth()/2, n_Rec.getHeight()/2, n_Rec.getXPos()-(1-offset)*n_Rec.getWidth(),
                    n_Rec.getYPos()-(1-offset)*n_Rec.getHeight(), color_list, offset, can, level-1);
        } // recursive calls to create four rectangles, each with half the dimensions of its n-1 level parent, with an
            // offset position from the corners
    } // drawRectangleFractal


    // main should ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        FractalDrawer fD = new FractalDrawer();

        System.out.println("What shape fractal would you like to print? Choose from \"triangle,\" \"rectangle,\" or \"circle\".");
        String input = sc.nextLine();

        while (!(input.equals("triangle") | input.equals("rectangle") | input.equals("circle"))) {
            System.out.println(fD.drawFractal(input));
            System.out.println("What shape fractal would you like to print? Choose from \"triangle,\" \"rectangle,\" or \"circle\".");
            input = sc.nextLine();
        } // validation while loop

        System.out.println("The total area of your " + input + " fractal is " + fD.drawFractal(input) + " units.");
    } // main
} // FractalDrawer.java