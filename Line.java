package As8;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Vishal Thumar
 */
public class Line extends Shapes {

    /**
     * variable declaration for starting location of x by getting x from super class
     */
    private double xStart = super.getX();

    /**
     * variable declaration for starting location of y by getting y from super class
     */
    private double yStart = super.getY();

    /**
     * variable declaration for ending location of x
     */
    private double xEnd;

    /**
     * variable declaration for ending location of x
     */
    private double yEnd;

    /**
     * constructor to create a model for Line class
     * @param xStart
     * @param yStart
     * @param xEnd
     * @param yEnd
     */
    public Line(double xStart, double yStart, double xEnd, double yEnd) {
        super(xStart, yStart);
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    /**
     * returns starting location of x
     * @return
     */
    public double getX() {
        return xStart;
    }

    /**
     * returns starting location of y
     * @return
     */
    public double getY() {
        return yStart;
    }

    /**
     * returns ending location of x
     * @return
     */
    public double getXx() {
        return xEnd;
    }

    /**
     * set ending location of x
     * @param xEnd
     */
    public void setXx(double xEnd) {
        this.xEnd = xEnd;
    }

    /**
     * returns ending location of y
     * @return
     */
    public double getYy() {
        return yEnd;
    }

    /**
     * set ending location of x
     * @param yEnd
     */
    public void setYy(double yEnd) {
        this.yEnd = yEnd;
    }

    /**
     * draw method to draw lines
     * @param gc
     */
    public void draw(GraphicsContext gc) {
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(5.0);
        gc.strokeLine(xStart, yStart, xEnd, yEnd);
    }
}
