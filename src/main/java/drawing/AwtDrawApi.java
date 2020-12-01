package drawing;

import geometry.objects.Circle;
import geometry.objects.Point;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AwtDrawApi implements DrawingApi {
    private final Graphics2D ga;
    private final int width;
    private final int height;

    public AwtDrawApi(Graphics2D ga, int width, int height) {
        this.ga = ga;
        this.width = width;
        this.height = height;
    }

    @Override
    public int getDrawingAreaWidth() {
        return width;
    }

    @Override
    public int getDrawingAreaHeight() {
        return height;
    }

    @Override
    public void drawCircle(Circle circle) {
        Point upperLeftCorner = new Point(circle.getCenter().getX() - circle.getR(),
                circle.getCenter().getY() - circle.getR());
        int w;
        int h;
        w = h = circle.getR() * 2;
        ga.setPaint(Color.blue);
        ga.fill(new Ellipse2D.Float(upperLeftCorner.getX(), upperLeftCorner.getY(), w, h));
    }

    @Override
    public void drawLine(Point from, Point to) {
        ga.drawLine(from.getX(), from.getY(), to.getX(), to.getY());
    }

    @Override
    public void show() {

    }
}
