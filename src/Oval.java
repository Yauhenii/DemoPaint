import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Oval extends Figure2D {
  // constructors

  public Oval(Point refPoint, Point defPoint, Color borderColor, Color figureColor) {
    super(refPoint, defPoint, borderColor, figureColor);
  }

  // methods

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(getBorderColor());
    g.fillOval(
        0,
        0,
        Math.abs(getDefPoint().x - getRefPoint().x),
        Math.abs(getDefPoint().y - getRefPoint().y));
    g.setColor(getFigureColor());
    g.drawOval(
        0,
        0,
        Math.abs(getDefPoint().x - getRefPoint().x),
        Math.abs(getDefPoint().y - getRefPoint().y));
//    g.drawRect(
//        0,
//        0,
//        Math.abs(getDefPoint().x - getRefPoint().x),
//        Math.abs(getDefPoint().y - getRefPoint().y));
  }

  @Override
  public String toString() {
    return "Oval";
  }
}
