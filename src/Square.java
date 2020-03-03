import java.awt.Color;
import java.awt.Point;

public class Square extends Rectangle {
  // consts

  public static final int TOPS_NUMBER = 4;

  // constructors

  public Square(Point firstpoint, Point secondPoint, Color borderColor, Color figureColor) {
    super(firstpoint, secondPoint, borderColor, figureColor);
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
