import lombok.Getter;
import lombok.Setter;

public class ParsedProperties {
    enum GraphType {
        ADJ, LIST
    }

    enum DrawerType {
        FX, AWT
    }

    @Getter @Setter
    private static GraphType graphType;
    @Getter @Setter private static DrawerType drawerType;

}
