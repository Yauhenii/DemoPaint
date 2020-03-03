import java.awt.Color;
import java.awt.Point;

public class Rhombus extends Polygon {
  // consts

  public static final int TOPS_NUMBER = 4;

  // constructors

  public Rhombus(Point firstpoint, Point secondPoint, Color borderColor, Color figureColor) {
    super(firstpoint, secondPoint, borderColor, figureColor);
  }

  public Rhombus(Rhombus rhombus) {
    super(rhombus);
  }

  // methods

  public void draw() {
    System.out.println("Drawing the rhombus...");
  }

  public void move() {
    System.out.println("Moving the rhombus...");
  }
}