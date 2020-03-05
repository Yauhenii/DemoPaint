import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Figure {
  // fields

  private Point refPoint;

  private Color borderColor;

  // constructors

  public Figure(Point refPoint, Color borderColor) {
    this.refPoint = refPoint;
    this.borderColor = borderColor;
  }

  public Figure(Figure figure) {
    this.refPoint = new Point(figure.refPoint);
    this.borderColor = new Color(figure.borderColor.getRGB());
  }

  // methods

  public abstract void draw();

  public abstract void move(Point newRefPoint);

  public Point location() {
    return refPoint;
  }

  // getters and setters

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
