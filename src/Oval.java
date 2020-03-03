import java.awt.Color;
import java.awt.Point;

public class Oval extends Figure2D {
  // constructors

  public Oval(Point firstpoint, Point secondPoint, Color borderColor, Color figureColor) {
    super(firstpoint, secondPoint, borderColor, figureColor);
  }

  public Oval(Oval oval) {
    super(oval);
  }

  // methods

  public void draw() {
    System.out.println("Drawing the oval...");
  }

  public void move() {
    System.out.println("Moving the oval...");
  }
}
