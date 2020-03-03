import java.awt.Color;
import java.awt.Point;

public class Rectangle extends Polygon {
  // consts

  public static final int TOPS_NUMBER = 4;

  // constructors

  public Rectangle(Point firstpoint, Point secondPoint, Color borderColor, Color figureColor) {
    super(firstpoint, secondPoint, borderColor, figureColor);
  }

  public Rectangle(Rectangle rectangle) {
    super(rectangle);
  }

  // methods

  public void draw() {
    System.out.println("Drawing the rectangle...");
  }

  public void move() {
    System.out.println("Moving the rectangle...");
  }
}
