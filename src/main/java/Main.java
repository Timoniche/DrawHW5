import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    private static void fillFromConfig() {
        String graphType = "list";
        String drawType = "fx";

        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            graphType = property.getProperty("graph");
            drawType = property.getProperty("draw");
        } catch (IOException e) {
            System.err.println("no property file");
        }
        switchStringTypes(graphType, drawType);
    }

    private static void switchStringTypes(String arg0, String arg1) throws IllegalArgumentException {
        if (arg0.equals("list")) {
            ParsedProperties.setGraphType(ParsedProperties.GraphType.LIST);
        } else if (arg0.equals("adj")) {
            ParsedProperties.setGraphType(ParsedProperties.GraphType.ADJ);
        } else {
            throw new IllegalArgumentException("Wrong args[0], [list|adj]");
        }

        if (arg1.equals("fx")) {
            ParsedProperties.setDrawerType(ParsedProperties.DrawerType.FX);
        } else if (arg1.equals("awt")) {
            ParsedProperties.setDrawerType(ParsedProperties.DrawerType.AWT);
        } else {
            throw new IllegalArgumentException("Wrong args[1], [fx|awt]");
        }
    }

    public static void main(String[] args) {
        System.out.println("Hi!");

        //assert(args.length == 2) : "[list|adj] [fx|awt]";
        //switchStringTypes(args[0], args[1]);
        fillFromConfig();

        System.out.println(ParsedProperties.getGraphType());
        System.out.println(ParsedProperties.getDrawerType());

        DrawingApplication app = new JavaFxApplication();
        app.startApplication();
    }
}
