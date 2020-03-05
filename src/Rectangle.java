import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Rectangle extends Polygon {
  // constructors

  public Rectangle(
      Point refPoint,
      Point defPoint,
      ArrayList<Point> auxiliaryPoints,
      Color borderColor,
      Color figureColor) {
    super(refPoint, defPoint, auxiliaryPoints, borderColor, figureColor);
  }

  public Rectangle(Rectangle rectangle) {
    super(rectangle);
  }

  // methods

  public void draw() {
    System.out.println("Drawing the rectangle...");
  }
}
