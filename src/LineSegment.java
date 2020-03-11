import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class LineSegment extends Figure1D {
  // fields

  private Point firstPoint;

  private Point secondPoint;
  // constructors

  public LineSegment(Point firstPoint, Point secondPoint, Color borderColor) {
    super(firstPoint, secondPoint, borderColor);
    this.firstPoint = firstPoint;
    this.secondPoint = secondPoint;
  }

  // methods

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(getBorderColor());
    g.drawLine(
        firstPoint.x - getRefPoint().x,
        firstPoint.y - getRefPoint().y,
        secondPoint.x - getRefPoint().x,
        secondPoint.y - getRefPoint().y);
    g.setColor(getBorderColor());
//    g.drawRect(
//        0,
//        0,
//        Math.abs(getDefPoint().x - getRefPoint().x),
//        Math.abs(getDefPoint().y - getRefPoint().y));
  }

  @Override
  public String toString() {
    return "Line segment";
  }

  // getters and setters

  public Point getFirstPoint() {
    return firstPoint;
  }

  public Point getSecondPoint() {
    return secondPoint;
  }
}

