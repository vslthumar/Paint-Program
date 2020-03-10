package As8;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * this class is a model class to create circles
 * @author Vishal Thumar
 */
public class Circle extends Shapes {

    /**
     * declaration of radius variable
     */
    private double radius;

    /**
     * declaration of x variable by getting x from super class
     */
    private double x = super.getX();

    /**
     * declaration of y variable by getting y from super class
     */
    private double y = super.getY();

    /**
     * constructor to create a model for Circle class
     * @param radius
     * @param x
     * @param y
     */
    public Circle(double radius, double x, double y) {
        super(x, y);
        this.radius = radius;
    }

    /**
     * returns x
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     * returns y
     * @return
     */
    public double getY() {
        return y;
    }

    /**
     * returns radius
     * @return
     */
    public double getRadius() {
        return radius;
    }

    /**
     * set radius
     * @param newR
     */
    public void setRadius(double newR) {
        radius = newR;
    }

    /**
     * draw method to draw circles
     * @param gc
     */
    public void draw(GraphicsContext gc) {
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.RED);
        gc.setLineWidth(5.0);
        double r = radius / 2;
        gc.fillOval(x - r, y - r, radius * 2, radius * 2);
        gc.strokeOval(x - r, y - r, radius * 2, radius * 2);
    }
}
