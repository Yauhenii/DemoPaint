import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class RegularPolygon extends Polygon {
  // constructors

  public RegularPolygon(
      Point firstPoint, Point secondPoint, int n, Color borderColor, Color figureColor) {
    super(firstPoint, secondPoint, null, borderColor, figureColor);
    int radius =
        (int)
            Math.sqrt(
                (firstPoint.x - secondPoint.x) * (firstPoint.x - secondPoint.x)
                    + (firstPoint.y - secondPoint.y) * (firstPoint.y - secondPoint.y));
    setRefPoint(new Point(firstPoint.x - radius, firstPoint.y - radius));
    setDefPoint(new Point(firstPoint.x + radius, firstPoint.y + radius));
    setAuxiliaryPoints(calculateAuxiliaryPoints(firstPoint, secondPoint, n));
  }

  // methods

  private ArrayList<Point> calculateAuxiliaryPoints(Point firstPoint, Point secondPoint, int n) {
    ArrayList<Point> auxiliaryPoints = new ArrayList<>();

    int radius =
        (int)
            Math.sqrt(
                (firstPoint.x - secondPoint.x) * (firstPoint.x - secondPoint.x)
                    + (firstPoint.y - secondPoint.y) * (firstPoint.y - secondPoint.y));
    double angle;
    if (firstPoint.y >= secondPoint.y) {
      angle = Math.acos((double) (firstPoint.x - secondPoint.x) / (double) radius);
    } else {
      angle = -Math.acos((double) (firstPoint.x - secondPoint.x) / (double) radius);
    }
    double angleIncrement = 2.0 * Math.PI / n;
    for (int i = 0; i < n; i++) {
      auxiliaryPoints.add(
          new Point(
              firstPoint.x + (int) (radius * Math.cos(angle)),
              firstPoint.y + (int) (radius * Math.sin(angle))));
      angle += angleIncrement;
    }
    return auxiliaryPoints;
  }

  @Override
  public String toString() {
    return "Regular polygon";
  }
}
