import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Polyline extends Figure1D {
  // fields

  protected ArrayList<LineSegment> lineSegments;

  // constructors

  public Polyline(Point firstPoint, ArrayList<LineSegment> lineSegments, Color borderColor) {
    super(firstPoint, borderColor);
    this.lineSegments = lineSegments;
  }

  public Polyline(Polyline polyline) {
    super(polyline);
    this.lineSegments = new ArrayList<>(polyline.lineSegments);
  }

  // methods

  public void draw() {
    System.out.println("Drawing the polyline...");
  }

  public void move() {
    System.out.println("Moving the polyline...");
  }

  public ArrayList<Point> location() {
    ArrayList<Point> resultArrayList = new ArrayList<>();
    resultArrayList.add(getRefPoint());
    for (LineSegment lineSegment : lineSegments) {
      resultArrayList.add(lineSegment.location().get(1));
    }
    return resultArrayList;
  }

  // getters and setters

  public ArrayList<LineSegment> getLineSegments() {
    return lineSegments;
  }
}
