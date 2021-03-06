package drawing;

import geometry.objects.Circle;
import geometry.objects.Point;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaFxDrawApi implements DrawingApi {
    private final Stage stage;
    private final int width;
    private final int height;

    private final Canvas canvas;
    private final GraphicsContext gc;

    public JavaFxDrawApi(Stage stage, int width, int height) {
        this.stage = stage;
        this.width = width;
        this.height = height;
        this.canvas = new Canvas(width, height);
        this.gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.GREEN);
    }

    public int getDrawingAreaWidth() {
        return width;
    }

    public int getDrawingAreaHeight() {
        return height;
    }

    public void drawCircle(Circle circle) {
        Point upperLeftCorner = new Point(circle.getCenter().getX() - circle.getR(),
                circle.getCenter().getY() - circle.getR());
        int w;
        int h;
        w = h = circle.getR() * 2;
        gc.fillOval(upperLeftCorner.getX(), upperLeftCorner.getY(), w, h);
    }

    public void drawLine(Point from, Point to) {
        gc.strokeLine(from.getX(), from.getY(), to.getX(), to.getY());
    }

    public void show() {
        Group group = new Group();
        group.getChildren().add(canvas);
        stage.setScene(new Scene(group, Color.WHITE));
        stage.setResizable(false);
        stage.show();
    }
}
