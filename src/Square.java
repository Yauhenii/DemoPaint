import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Square extends Rectangle {
  // constructors

  public Square(
      Point refPoint,
      Point defPoint,
      ArrayList<Point> auxiliaryPoints,
      Color borderColor,
      Color figureColor) {
    super(refPoint, defPoint, auxiliaryPoints, borderColor, figureColor);
  }

  public Square(Square square) {
    super(square);
  }

  // methods

  public void draw() {
    System.out.println("Drawing the square...");
  }
}
