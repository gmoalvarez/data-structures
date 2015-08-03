/**
 * Created by guillermo on 3/5/15.
 */
public class Circle implements Comparable<Circle> {
    protected int radius;

    public Circle(int r) {
        radius = r;
    }

    public int compareTo(Circle c) {
        return radius - c.radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int r) {
        radius = r;
    }

    public String toString() {
        return "I am a circle and my radius is "+getRadius();
    }
}
