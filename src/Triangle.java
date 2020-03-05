import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Triangle extends Polygon {
  // consts

  public static final int TOPS_NUMBER = 3;

  // constructors

  public Triangle(
      Point refPoint,
      Point defPoint,
      ArrayList<Point> auxiliaryPoints,
      Color borderColor,
      Color figureColor) {
    super(refPoint, defPoint, auxiliaryPoints, borderColor, figureColor);
  }

  public Triangle(Triangle triangle) {
    super(triangle);
  }

  // methods

  public void draw() {
    System.out.println("Drawing the triangle...");
  }
}
