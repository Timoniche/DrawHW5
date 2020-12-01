package drawing;

import geometry.objects.Circle;
import geometry.objects.Point;

public interface DrawingApi {
    int getDrawingAreaWidth();
    int getDrawingAreaHeight();
    void drawCircle(Circle circle);
    void drawLine(Point from, Point to);
    void show();
}
