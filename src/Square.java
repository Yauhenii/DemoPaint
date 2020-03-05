import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Square extends Rectangle {
  // consts

  public static final int TOPS_NUMBER = 4;

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

  public void move() {
    System.out.println("Moving the square...");
  }
}
