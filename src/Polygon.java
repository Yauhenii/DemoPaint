import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class Polygon extends Figure2D {
  // fields

  ArrayList<Point> auxiliaryPoints;

  // constructors

  public Polygon(
      Point refPoint,
      Point defPoint,
      ArrayList<Point> auxiliaryPoints,
      Color borderColor,
      Color figureColor) {
    super(refPoint, defPoint, borderColor, figureColor);
    this.auxiliaryPoints = auxiliaryPoints;
  }

  public Polygon(Polygon polygon) {
    super(polygon);
  }

  // methods

  public void draw() {
    System.out.println("Drawing the polygon...");
  }

  // getters and setters

  public ArrayList<Point> getAuxiliaryPoints() {
    return auxiliaryPoints;
  }

  public void setAuxiliaryPoints(ArrayList<Point> auxiliaryPoints) {
    this.auxiliaryPoints = auxiliaryPoints;
  }
}
