import java.awt.Color;
import java.awt.Point;

public class StraightLine extends Ray {
  // constructors

  public StraightLine(Point refPoint, Point defPoint, Color borderColor) {
    super(refPoint, defPoint, borderColor);
  }

  // methods
  public void draw() {
    System.out.println("Drawing the straight line...");
  }
}
