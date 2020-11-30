import graph.Graph;
import graph.MatrixGraph;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

public class JavaFxApplication extends Application implements DrawingApplication {

    @Override
    public void start(Stage primaryStage) throws Exception {
        JavaFxDrawingApi api = new JavaFxDrawingApi(primaryStage, 600, 400);

        int n = 8;
        ArrayList<ArrayList<Boolean>> adjMatrix = new ArrayList<ArrayList<Boolean>>();
        for (int i = 0; i < n; i++) {
            adjMatrix.add(new ArrayList<Boolean>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix.get(i).add(true);
            }
        }
        Graph graph = new MatrixGraph(api, adjMatrix);
        graph.drawGraph();
    }

    public void startApplication() {
        launch(this.getClass());
    }}
