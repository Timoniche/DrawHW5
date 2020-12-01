package graph;

import drawing.DrawingApi;
import geometry.objects.Circle;
import geometry.objects.Point;

import java.util.ArrayList;
import java.util.Random;

public class AdjMatrixGraph extends Graph {
    private final ArrayList<ArrayList<Boolean>> adjMatrix;
    private final Point windowCenter;
    double rCircleNodes;
    double rNode;
    int n;

    public AdjMatrixGraph(DrawingApi drawingApi, ArrayList<ArrayList<Boolean>> adjMatrix) {
        super(drawingApi);
        this.adjMatrix = adjMatrix;
        int w = drawingApi.getDrawingAreaWidth();
        int h = drawingApi.getDrawingAreaHeight();
        windowCenter = new Point(w / 2, h / 2);
        rCircleNodes = 0.7 * (double) (Math.min(w, h) / 2);
        rNode = Math.sqrt(Math.min(w, h));
        n = adjMatrix.size();
    }

    @Override
    public void drawGraph() {
        for (int i = 0; i < n; i++) {
            drawingApi.drawCircle(new Circle(countNodeCenter(i), (int) rNode));
        }
        drawEdges();
        drawingApi.show();
    }

    private void drawEdges() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjMatrix.get(i).get(j)) {
                    drawingApi.drawLine(countNodeCenter(i), countNodeCenter(j));
                }
            }
        }
    }

    private Point countNodeCenter(int i) {
        double rotate = 2 * Math.PI * i / this.n;
        int x = (int) (windowCenter.getX() + rCircleNodes * Math.cos(rotate));
        int y = (int) (windowCenter.getY() + rCircleNodes * Math.sin(rotate));
        return new Point(x, y);
    }

    public static ArrayList<ArrayList<Boolean>> generateAdjMatrix() {
        Random rand = new Random();
        int nodes = 8;
        ArrayList<ArrayList<Boolean>> adjMatrix = new ArrayList<ArrayList<Boolean>>();
        for (int i = 0; i < nodes; i++) {
            adjMatrix.add(new ArrayList<Boolean>());
        }

        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                boolean nextBool = rand.nextBoolean();
                adjMatrix.get(i).add(nextBool);
                System.out.print(nextBool + " ");
            }
            System.out.println();
        }
        return adjMatrix;
    }
}
