import java.awt.Color;
import java.awt.Point;

public class Triangle extends Polygon {
  // consts

  public static final int TOPS_NUMBER = 3;

  // constructors

  public Triangle(Point firstpoint, Point secondPoint, Color borderColor, Color figureColor) {
    super(firstpoint, secondPoint, borderColor, figureColor);
  }

  public Triangle(Triangle triangle) {
    super(triangle);
  }

  // methods

  public void draw() {
    System.out.println("Drawing the triangle...");
  }

  public void move() {
    System.out.println("Moving the triangle...");
  }
}
