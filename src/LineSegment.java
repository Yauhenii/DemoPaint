import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class LineSegment extends Figure1D {
  // constructors

  public LineSegment(Point refPoint, Point defPoint, Color borderColor) {
    super(refPoint, defPoint, borderColor);
  }

  // methods

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(getBorderColor());
    g.drawLine(0,0,getDefPoint().x - getRefPoint().x,getDefPoint().y - getRefPoint().y);
    g.setColor(getBorderColor());
    g.drawRect(
        0,
        0,
        Math.abs(getDefPoint().x - getRefPoint().x),
        Math.abs(getDefPoint().y - getRefPoint().y));
  }
}
