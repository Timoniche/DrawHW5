package graph;

import drawing.DrawingApi;
import geometry.objects.Circle;
import geometry.objects.Point;

import java.util.ArrayList;

public class MatrixGraph extends Graph {
    private final ArrayList<ArrayList<Boolean>> adjMatrix;

    public MatrixGraph(DrawingApi drawingApi, ArrayList<ArrayList<Boolean>> adjMatrix) {
        super(drawingApi);
        this.adjMatrix = adjMatrix;
    }

    @Override
    public void drawGraph() {
        int w = drawingApi.getDrawingAreaWidth();
        int h = drawingApi.getDrawingAreaHeight();
        int xCenter = w / 2;
        int yCenter = h / 2;
        Point windowCenter = new Point(xCenter, yCenter);

        double rCircleNodes = 0.9 * (double) (Math.min(w, h) / 2);
        double rNode = Math.sqrt((double) Math.min(w, h));
        int n = adjMatrix.size();

        for (int i = 0; i < n; i++) {
            drawingApi.drawCircle(new Circle(countNodeCenter(windowCenter, i, rCircleNodes, n), (int) rNode));
        }

        //edges todo: to function
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjMatrix.get(i).get(j)) {
                    // todo: to global fields
                    drawingApi.drawLine(countNodeCenter(windowCenter, i, rCircleNodes, n),
                            countNodeCenter(windowCenter, j, rCircleNodes, n));
                }
            }
        }

        drawingApi.show();
    }

    private Point countNodeCenter(Point center, int i, double rCircleNodes, int n) {
        double rotate = 2 * Math.PI * i / n;
        int x = (int) (center.getX() + rCircleNodes * Math.cos(rotate));
        int y = (int) (center.getY() + rCircleNodes * Math.sin(rotate));
        return new Point(x, y);
    }
}
