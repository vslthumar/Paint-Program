/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package As8;

import javafx.scene.canvas.GraphicsContext;

/**
 * This is the shape model class to describe parameters
 * @author Vishal Thumar
 */
public class Shapes {

    /**
     * x location of center/beginning of the shape
     */
    private double x,

    /**
     * x location of center/beginning of the shape
     */
    y;

    /**
     * constructor of the class to set parameters 
     * @param x
     * @param y
     */
    public Shapes(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * return x
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     * return y
     * @return
     */
    public double getY() {
        return y;
    }

    /**
     * empty draw method to call other's card method
     * @param gc
     */
    public void draw(GraphicsContext gc) {
    }
}
