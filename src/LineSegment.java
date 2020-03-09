import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class LineSegment extends Figure1D {
  // fields

  private Point aPoint;

  private Point bPoint;
  // constructors

  public LineSegment(Point refPoint, Point defPoint, Color borderColor) {
    super(refPoint, defPoint, borderColor);
    if (refPoint.equals(getRefPoint()) || refPoint.equals(defPoint)) {
      aPoint = new Point(0, 0);
      bPoint = new Point(getDefPoint().x - getRefPoint().x, getDefPoint().y - getRefPoint().y);
    } else {
      aPoint = new Point(0, getDefPoint().y - getRefPoint().y);
      bPoint = new Point(getDefPoint().x - getRefPoint().x, 0);
    }
  }

  // methods

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(getBorderColor());
    g.drawLine(aPoint.x, aPoint.y, bPoint.x, bPoint.y);
    g.setColor(getBorderColor());
    g.drawRect(
        0,
        0,
        Math.abs(getDefPoint().x - getRefPoint().x),
        Math.abs(getDefPoint().y - getRefPoint().y));
  }
}

