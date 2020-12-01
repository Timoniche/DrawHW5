package graph;

import drawing.DrawingApi;
import geometry.objects.Circle;
import geometry.objects.Point;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListEdgesGraph extends Graph {
    private final List<Edge> listEdges;
    private final Point windowCenter;
    double rCircleNodes;
    double rNode;
    int n;

    public ListEdgesGraph(DrawingApi drawingApi, List<Edge> listEdges, int n) {
        super(drawingApi);
        this.listEdges = listEdges;
        this.n = n;
        int w = drawingApi.getDrawingAreaWidth();
        int h = drawingApi.getDrawingAreaHeight();
        windowCenter = new Point(w / 2, h / 2);
        rCircleNodes = 0.7 * (double) (Math.min(w, h) / 2);
        rNode = Math.sqrt(Math.min(w, h));
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
        for (Edge e : listEdges) {
            int index1 = e.getFrom().getNum();
            int index2 = e.getTo().getNum();
            drawingApi.drawLine(countNodeCenter(index1), countNodeCenter(index2));
        }
    }

    private Point countNodeCenter(int i) {
        double rotate = 2 * Math.PI * i / n;
        int x = (int) (windowCenter.getX() + rCircleNodes * Math.cos(rotate));
        int y = (int) (windowCenter.getY() + rCircleNodes * Math.sin(rotate));
        return new Point(x, y);
    }

    public static List<Edge> generateListEdges() {
        Random rand = new Random();
        int nodes = 8;
        List<Edge> listEdges = new ArrayList<Edge>();

        for (int i = 0; i < rand.nextInt(nodes) + 1; i++) {
            int fst = rand.nextInt(nodes);
            int snd = rand.nextInt(nodes);
            if (fst == snd) {
                fst = (fst + 1) % nodes;
            }
            listEdges.add(new Edge(new Node(fst), new Node(snd)));
            System.out.println(fst + " " + snd);
        }

        return listEdges;
    }
}

class Node {
    @Getter @Setter private int num;

    public Node(int num) {
        this.num = num;
    }
}

class Edge {
    @Getter @Setter private Node from;
    @Getter @Setter private Node to;

    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
    }
}
