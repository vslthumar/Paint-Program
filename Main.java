package As8;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * this class is a main class to apply all methods and create all models and display the output
 * @author Vishal Thumar
 */
public class Main extends Application {

    /**
     * variable declaration for Canvas
     */
    private Canvas c;

    /**
     * variable declaration of GraphicsContext
     */
    private GraphicsContext gc;

    /**
     * Object declaration of Circle
     */
    private Circle circle;

    /**
     * Object declaration of Rectangle
     */
    private Rectangle rect;

    /**
     * Object declaration of Line
     */
    private Line line;

    /**
     * ArrayList declaration for shapes
     */
    private ArrayList<Shapes> sList;

    /**
     * boolean declaration
     */
    private Boolean b,

    /**
     *
     */
    a = false;

    /**
     * variable declaration for output
     */
    private String text = "Line";

    /**
     * method for mouse event when the mouse is pressed
     * @param me
     */
    private void pressHandler(MouseEvent me) {
        if (a) {
            if (b) {
                circle = new Circle(1, me.getX(), me.getY());
            } else if (!b) {
                rect = new Rectangle(1, me.getX(), me.getY());
            }
        } else {
            line = new Line(me.getX(), me.getY(), 1, 1);
        }

    }

    /**
     * method for mouse event when the mouse is dragged
     * @param me
     */
    private void dragHandler(MouseEvent me) {
        double ex = me.getX();
        double ey = me.getY();

        double newR;

        if (a) {
            if (b) {
                newR = Math.sqrt(Math.pow(circle.getX() - ex, 2) + Math.pow(circle.getY() - ey, 2)); //calculatiog radius for circles
                circle.setRadius(newR);

                gc.clearRect(0, 0, 800, 600);
                sList.add(circle); //adding circle object in Array List
                for (Shapes cc : sList) {
                    cc.draw(gc);
                }
                circle.draw(gc);
            } else if (!b) {
                newR = Math.sqrt(Math.pow(rect.getX() - ex, 2) + Math.pow(rect.getY() - ey, 2)); //calculatiog radius for rectangle
                rect.setRadius(newR);

                gc.clearRect(0, 0, 800, 600);

                sList.add(rect); //adding rect object in Array List
                for (Shapes cc : sList) {
                    cc.draw(gc);
                }
                rect.draw(gc);
            }
        } else {
            gc.clearRect(0, 0, 800, 600);
            sList.add(line);

            line.setXx(ex);
            line.setYy(ey);
            for (Shapes cc : sList) {
                cc.draw(gc);
            }
            line.draw(gc);
        }
    }

    /**
     * method for mouse event when the mouse is released
     * @param me
     */
    private void releaseHandler(MouseEvent me) {
        if (a) {
            if (b) {
                sList.add(circle); //adding circle object in Array List
            } else if (!b) {
                sList.add(rect); //adding rect object in Array List
            }
        } else {
            sList.add(line);
        }
    }

    /**
     * method for clearing the screen
     */
    private void clear() {
        sList.clear();
        gc.clearRect(0, 0, 800, 600);

    }

    /**
     * start method to display outputs
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 700); // set the size here
        stage.setTitle("Vishal & Shamik"); // set the window title here
        stage.setScene(scene);

        // creating buttons 
        Button rb1 = new Button("Circle");
        Button rb2 = new Button("Rectangle");
        Button rb3 = new Button("Line");
        Button rb4 = new Button("Clear");

        // configur location and width of buttons
        rb1.setPrefWidth(80);
        rb2.setPrefWidth(80);
        rb3.setPrefWidth(80);
        rb4.setPrefWidth(80);
        rb1.relocate(10, 625);
        rb2.relocate(110, 625);
        rb3.relocate(210, 625);
        rb4.relocate(310, 625);

        // creating and configuring locations, colors and name of labels
        Label l1 = new Label("Instructions:\n\n* Select by left mouse click on the button\n   to decide the shape.\n"
                + "* Left Mouse click and drag to draw objects.");
        l1.relocate(510, 610);
        l1.setTextFill(Color.WHITE);
        Label l2 = new Label("Nothing");
        Label l3 = new Label("Selected:");
        l2.relocate(10, 675);
        l2.setTextFill(Color.WHITE);
        l3.relocate(10, 660);
        l3.setTextFill(Color.WHITE);

        //  Create the model
        sList = new ArrayList<Shapes>();

        // Create the GUI components
        c = new Canvas(800, 700);

        // Adding components to the root
        root.getChildren().addAll(c, rb1, rb2, rb3, rb4, l1, l2, l3);

        // 4. Configure the components (colors, fonts, size, location)
        gc = c.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 800, 600);
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 600, 800, 100);
        
        //setting action events for the buttons
        rb1.setOnAction((ActionEvent e) -> {
            a = true;
            b = true;
            l2.setText("Circle");
        });

        rb2.setOnAction((ActionEvent e) -> {
            a = true;
            b = false;
            l2.setText("Rectangle");
        });
        rb3.setOnAction((ActionEvent e) -> {
            a = false;
            l2.setText("Line");
        });
        rb4.setOnAction((ActionEvent e) -> {
            clear();
            l2.setText("Clear");
        });

        // exception handler and calling the event handlers to display output
        try {
            c.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler);
            c.addEventHandler(MouseEvent.MOUSE_RELEASED, this::releaseHandler);
            c.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::dragHandler);
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "Error").showAndWait();
        }
        // Show the stage
        stage.show();

    }

    /**
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
