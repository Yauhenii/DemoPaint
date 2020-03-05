import java.awt.Color;
import java.awt.Point;

public class Ray extends LineSegment {
  // constructors

  public Ray(Point refPoint, Point defPoint, Color borderColor) {
    super(refPoint, defPoint, borderColor);
  }

  public Ray(Ray ray) {
    super(ray);
  }

  // methods

  public void draw() {
    System.out.println("Drawing the ray...");
  }
}
