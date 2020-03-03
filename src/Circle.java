import java.awt.Color;
import java.awt.Point;

public class Circle extends Oval {
  // constructors

  public Circle(Point firstpoint, Point secondPoint, Color borderColor, Color figureColor) {
    super(firstpoint, secondPoint, borderColor, figureColor);
  }

  public Circle(Circle circle) {
    super(circle);
  }

  // methods

  public void draw() {
    System.out.println("Drawing the circle...");
  }

  public void move() {
    System.out.println("Moving the circle...");
  }
}
