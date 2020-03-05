import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class RegularPolygon extends Polygon {
  // constructors

  public RegularPolygon(
      Point refPoint,
      Point defPoint,
      ArrayList<Point> auxiliaryPoints,
      Color borderColor,
      Color figureColor) {
    super(refPoint, defPoint, auxiliaryPoints, borderColor, figureColor);
  }

  public RegularPolygon(RegularPolygon regularPolygon) {
    super(regularPolygon);
  }

  // methods

  public void draw() {
    System.out.println("Drawing the regular polygon...");
  }
}
