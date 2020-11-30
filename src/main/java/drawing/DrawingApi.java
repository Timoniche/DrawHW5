package drawing;

import geometry.objects.Circle;
import geometry.objects.Point;

public interface DrawingApi {
    public int getDrawingAreaWidth();
    public int getDrawingAreaHeight();
    public void drawCircle(Circle circle);
    public void drawLine(Point from, Point to);
    public void show();
}
