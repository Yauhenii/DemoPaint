import java.awt.Color;
import java.awt.Point;

public class Ray extends LineSegment {
  // constructors

  public Ray(Point firstPoint, Point secondPoint, Color borderColor) {
    super(firstPoint, secondPoint, borderColor);
  }

  public Ray(Ray ray) {
    super(ray);
  }

  // methods

  public void draw() {
    System.out.println("Drawing the ray...");
  }
}
