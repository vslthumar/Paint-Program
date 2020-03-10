package As8;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Vishal Thumar
 */
public class Rectangle extends Shapes {

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
     * constructor to create a model for Rectangle class
     * @param radius
     * @param x
     * @param y
     */
    public Rectangle(double radius, double x, double y) {
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
     * draw method to draw rectangles
     * @param gc
     */
    public void draw(GraphicsContext gc) {
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLUE);
        gc.setLineWidth(5.0);
        double r = radius / 2;
        gc.fillRect(x - r, y - r, radius * 2, radius * 2);
        gc.strokeRect(x - r, y - r, radius * 2, radius * 2);
    }
}
