import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Polyline extends Figure1D {
  // fields

  private ArrayList<LineSegment> lineSegments;

  // constructors

  public Polyline(Point refPoint, ArrayList<LineSegment> lineSegments, Color borderColor) {
    super(refPoint, null,  borderColor);
    this.lineSegments = lineSegments;
  }

  // methods

  public void draw() {
    System.out.println("Drawing the polyline...");
  }

  // getters and setters

  public ArrayList<LineSegment> getLineSegments() {
    return lineSegments;
  }
}
