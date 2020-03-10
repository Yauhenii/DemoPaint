import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Ray extends LineSegment {
  // consts

  private final int WINDOW_WIDTH = 800;
  private final int WINDOW_HEIGHT = 800;

  // constructors

  public Ray(Point refPoint, Point defPoint, Color borderColor) {
    super(refPoint, defPoint, borderColor);
    setRefPoint(new Point(0, 0));
    setDefPoint(new Point(WINDOW_WIDTH, WINDOW_HEIGHT));
  }

  // methods

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    int dX = 10 * (getSecondPoint().x - getFirstPoint().x);
    int dY = 10 * (getSecondPoint().y - getFirstPoint().y);
    g.setColor(getBorderColor());
    g.drawLine(
        getFirstPoint().x, getFirstPoint().y, getSecondPoint().x + dX, getSecondPoint().y + dY);
    g.setColor(getBorderColor());
    g.drawRect(
        0,
        0,
        Math.abs(getDefPoint().x - getRefPoint().x),
        Math.abs(getDefPoint().y - getRefPoint().y));
  }

  @Override
  public String toString() {
    return "Ray";
  }
}
