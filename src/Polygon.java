import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Polygon extends Figure2D {
  // fields

  private ArrayList<Point> auxiliaryPoints;
  private int[] x, y;
  private int size;

  // constructors

  public Polygon(
      Point refPoint,
      Point defPoint,
      ArrayList<Point> auxiliaryPoints,
      Color borderColor,
      Color figureColor) {
    super(refPoint, defPoint, borderColor, figureColor);
    setAuxiliaryPoints(auxiliaryPoints);
  }

  // methods

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(getBorderColor());
    g.fillPolygon(x, y, size);
    g.setColor(getFigureColor());
    g.drawRect(
        0,
        0,
        Math.abs(getDefPoint().x - getRefPoint().x),
        Math.abs(getDefPoint().y - getRefPoint().y));
  }

  // getters and setters

  public ArrayList<Point> getAuxiliaryPoints() {
    return auxiliaryPoints;
  }

  public void setAuxiliaryPoints(ArrayList<Point> auxiliaryPoints) {
    this.auxiliaryPoints = auxiliaryPoints;
    if (auxiliaryPoints != null) {
      setXY();
    }
  }

  private void setXY() {
    if (auxiliaryPoints != null) {
      size = auxiliaryPoints.size();
      x = new int[size];
      y = new int[size];
      for (int i = 0; i < size; i++) {
        x[i] = auxiliaryPoints.get(i).x - getRefPoint().x;
        y[i] = auxiliaryPoints.get(i).y - getRefPoint().y;
      }
    }
  }

  @Override
  public String toString() {
    return "Polygon";
  }
}
