import drawing.AwtDrawApi;
import graph.AdjMatrixGraph;
import graph.Graph;
import graph.ListEdgesGraph;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtApplication extends Frame implements DrawingApplication {
    @Override
    public void startApplication() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setSize(ParsedProperties.getWIDTH(), ParsedProperties.getHEIGHT());
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.clearRect(0, 0, ParsedProperties.getWIDTH(), ParsedProperties.getHEIGHT());
        AwtDrawApi api = new AwtDrawApi(graphics2D, ParsedProperties.getWIDTH(), ParsedProperties.getHEIGHT());
        Graph graph;
        if (ParsedProperties.getGraphType() == ParsedProperties.GraphType.ADJ) {
            graph = new AdjMatrixGraph(api, AdjMatrixGraph.generateAdjMatrix());
        } else {
            graph = new ListEdgesGraph(api, ListEdgesGraph.generateListEdges(), 8);
        }
        graph.drawGraph();
    }
}
