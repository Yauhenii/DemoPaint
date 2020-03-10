import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Rhombus extends Polygon {
  // constructors

  public Rhombus(Point refPoint, Point defPoint, Color borderColor, Color figureColor) {
    super(refPoint, defPoint, null, borderColor, figureColor);
    setAuxiliaryPoints(calculateAuxiliaryPoints(refPoint, defPoint));
  }

  // methods

  private ArrayList<Point> calculateAuxiliaryPoints(Point refPoint, Point defPoint) {
    ArrayList<Point> auxiliaryPoints = new ArrayList<>();

    int dX = defPoint.x - refPoint.x;
    int dY = defPoint.y - refPoint.y;

    auxiliaryPoints.add(new Point(refPoint.x + dX / 2, refPoint.y));
    auxiliaryPoints.add(new Point(defPoint.x, refPoint.y + dY / 2));
    auxiliaryPoints.add(new Point(refPoint.x + dX / 2, defPoint.y));
    auxiliaryPoints.add(new Point(refPoint.x, refPoint.y + dY / 2));
    return auxiliaryPoints;
  }

  @Override
  public String toString() {
    return "Rhombus";
  }
}
