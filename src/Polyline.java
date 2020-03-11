import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Polyline extends Figure1D {
  // fields

  private ArrayList<Point> auxiliaryPoints;
  private int[] x, y;
  private int size;

  // constructors

  public Polyline(
      Point refPoint,
      Point defPoint,
      ArrayList<Point> auxiliaryPoints,
      Color borderColor) {
    super(refPoint, defPoint, borderColor);
    setAuxiliaryPoints(auxiliaryPoints);
  }

  // methods

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(getBorderColor());
    g.drawPolyline(x, y, size);
    g.setColor(getBorderColor());
//    g.drawRect(
//        0,
//        0,
//        Math.abs(getDefPoint().x - getRefPoint().x),
//        Math.abs(getDefPoint().y - getRefPoint().y));
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
    return "Polyline";
  }
}
