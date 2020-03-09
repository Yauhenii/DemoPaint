import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Rectangle extends Polygon {
  // constructors

  public Rectangle(
      Point refPoint,
      Point defPoint,
      Color borderColor,
      Color figureColor) {
    super(refPoint, defPoint, null , borderColor, figureColor);
    setAuxiliaryPoints(calculateAuxiliaryPoints(refPoint,defPoint));
  }

  //methods

  private ArrayList<Point> calculateAuxiliaryPoints(Point refPoint,Point defPoint){
    ArrayList<Point> auxiliaryPoints=new ArrayList<>();
    auxiliaryPoints.add(refPoint);
    auxiliaryPoints.add(new Point(refPoint.x,defPoint.y));
    auxiliaryPoints.add(defPoint);
    auxiliaryPoints.add(new Point(defPoint.x,refPoint.y));
    return auxiliaryPoints;
  }

}
