import drawing.JavaFxDrawApi;
import graph.Graph;
import graph.AdjMatrixGraph;
import graph.ListEdgesGraph;
import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFxApplication extends Application implements DrawingApplication {

    @Override
    public void start(Stage primaryStage) {
        JavaFxDrawApi api = new JavaFxDrawApi(primaryStage,
                ParsedProperties.getWIDTH(),
                ParsedProperties.getHEIGHT());
        Graph graph;
        if (ParsedProperties.getGraphType() == ParsedProperties.GraphType.ADJ) {
            graph = new AdjMatrixGraph(api, AdjMatrixGraph.generateAdjMatrix());
        } else {
            graph = new ListEdgesGraph(api, ListEdgesGraph.generateListEdges(), 8);
        }
        graph.drawGraph();
    }

    public void startApplication() {
        launch(this.getClass());
    }
}
