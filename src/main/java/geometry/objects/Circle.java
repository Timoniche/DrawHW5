package geometry.objects;

import lombok.Getter;
import lombok.Setter;

public class Circle {
    @Getter @Setter private Point center;
    @Getter @Setter private int r;

    public Circle(Point center, int r) {
        this.center = center;
        this.r = r;
    }
}
