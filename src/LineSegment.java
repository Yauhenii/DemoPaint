import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class LineSegment extends Figure1D {
  // fields

  private Point defPoint;

  // constructors

  public LineSegment(Point refPoint, Point defPoint, Color borderColor) {
    super(refPoint, borderColor);
    this.defPoint = defPoint;
  }

  public LineSegment(LineSegment lineSegment) {
    super(lineSegment);
    this.defPoint = new Point(lineSegment.defPoint);
  }

  // methods

  public void draw() {
    System.out.println("Drawing the line segment...");
  }

  public void move(Point newRefPoint) {
    System.out.println("Moving the line segment...");
  }

  // getters and setters

  public Point getDefPoint() {
    return defPoint;
  }

  public void setDefPoint(Point defPoint) {
    this.defPoint = defPoint;
  }
}
