import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Polygon extends Figure2D {
  // consts

  public static final int TOPS_NUMBER = 0;

  // fields

  ArrayList<Point> auxiliaryPoints;

  // constructors

  public Polygon(Point firstpoint, Point secondPoint, Color borderColor, Color figureColor) {
    super(firstpoint, secondPoint, borderColor, figureColor);
    auxiliaryPoints = new ArrayList<>();
  }

  public Polygon(Polygon polygon) {
    super(polygon);
  }

  // methods

  public ArrayList<Point> location() {
    return new ArrayList<Point>(Arrays.asList(getRefPoint(), getDefPoint()));
  }

  public ArrayList<Point> extendedLocation() {
    ArrayList<Point> result = new ArrayList<>(Arrays.asList(getRefPoint(), getDefPoint()));
    result.addAll(auxiliaryPoints);
    return result;
  }

  // getters and setters

  public ArrayList<Point> getAuxiliaryPoints() {
    return auxiliaryPoints;
  }

  public void setAuxiliaryPoints(ArrayList<Point> auxiliaryPoints) {
    this.auxiliaryPoints = auxiliaryPoints;
  }
}
