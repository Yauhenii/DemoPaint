import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class LineSegment extends Figure1D {
  //fields

  protected Point defPoint;

  //constructors

  public LineSegment(Point firstPoint, Point secondPoint, Color borderColor) {
    super(firstPoint,borderColor);
    this.defPoint=secondPoint;
  }

  public LineSegment(LineSegment lineSegment) {
    super(lineSegment);
    this.defPoint = new Point(lineSegment.defPoint);
  }

  //methods

  public void draw(){
    System.out.println("Drawing the line segment...");
  }

  public void move(){
    System.out.println("Moving the line segment...");
  }

  public ArrayList<Point> location(){
    return new ArrayList<Point>(Arrays.asList(refPoint,defPoint));
  }

  //getters and setters

  public Point getDefPoint() {
    return defPoint;
  }

  public void setDefPoint(Point defPoint) {
    this.defPoint = defPoint;
  }
}
