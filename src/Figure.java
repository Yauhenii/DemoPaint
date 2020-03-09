import java.awt.Color;
import java.awt.Point;
import javax.swing.JPanel;

public abstract class Figure extends JPanel {
  // fields

  private Point refPoint;

  private Point defPoint;

  private Color borderColor;

  // constructors

  public Figure(Point refPoint, Point defPoint, Color borderColor) {
    this.refPoint = refPoint;
    this.defPoint = defPoint;
    this.borderColor = borderColor;

    relocatePoints();
    setOpaque(false);
  }

  // methods

  public void display() {
    setBounds(
        getRefPoint().x,
        getRefPoint().y,
        Math.abs(getDefPoint().x - getRefPoint().x),
        Math.abs(getDefPoint().y - getRefPoint().y));
  }

  private void relocatePoints() {
    if (getRefPoint().x >= getDefPoint().x) {
      int x = getRefPoint().x;
      getRefPoint().x = getDefPoint().x;
      getDefPoint().x = x;
    }
    if (getRefPoint().y >= getDefPoint().y) {
      int x = getRefPoint().y;
      getRefPoint().y = getDefPoint().y;
      getDefPoint().y = x;
    }
  }

  // getters and setters

  public Point getRefPoint() {
    return refPoint;
  }

  public void setRefPoint(Point refPoint) {
    this.refPoint = refPoint;
  }

  public Point getDefPoint() {
    return defPoint;
  }

  public void setDefPoint(Point defPoint) {
    this.defPoint = defPoint;
  }

  public Color getBorderColor() {
    return borderColor;
  }

  public void setBorderColor(Color borderColor) {
    this.borderColor = borderColor;
  }
}
