import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Figure {
  // fields

  protected Point refPoint;

  protected Color borderColor;

  // constructors

  public Figure(Point firstPoint, Color borderColor) {
    this.refPoint = firstPoint;
    this.borderColor = borderColor;
  }

  public Figure(Figure figure) {
    this.refPoint = new Point(figure.refPoint);
    this.borderColor = new Color(figure.borderColor.getRGB());
  }

  // methods

  public abstract void draw();

  public abstract void move();

  public ArrayList<Point> location() {
    return new ArrayList<Point>(Arrays.asList(refPoint));
  }

  // getters and setters

  public Point getRefPoint() {
    return refPoint;
  }

  public void setRefPoint(Point refPoint) {
    this.refPoint = refPoint;
  }

  public Color getBorderColor() {
    return borderColor;
  }

  public void setBorderColor(Color borderColor) {
    this.borderColor = borderColor;
  }
}
