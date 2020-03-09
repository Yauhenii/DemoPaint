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
    g.setColor(getFigureColor());
    g.fillOval(
        0,
        0,
        Math.abs(getDefPoint().x - getRefPoint().x),
        Math.abs(getDefPoint().y - getRefPoint().y));
    g.setColor(getBorderColor());
    g.drawRect(
        0,
        0,
        Math.abs(getDefPoint().x - getRefPoint().x),
        Math.abs(getDefPoint().y - getRefPoint().y));
  }
}
