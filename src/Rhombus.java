import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Rhombus extends Polygon {
  // consts

  public static final int TOPS_NUMBER = 4;

  // constructors

  public Rhombus(
      Point refPoint,
      Point defPoint,
      ArrayList<Point> auxiliaryPoints,
      Color borderColor,
      Color figureColor) {
    super(refPoint, defPoint, auxiliaryPoints, borderColor, figureColor);
  }

  public Rhombus(Rhombus rhombus) {
    super(rhombus);
  }

  // methods

  public void draw() {
    System.out.println("Drawing the rhombus...");
  }
}
