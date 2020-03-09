import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Square extends Rectangle {
  // constructors

  public Square(
      Point refPoint,
      Point defPoint,
      Color borderColor,
      Color figureColor) {
    super(refPoint, defPoint, borderColor, figureColor);
    FigureUtils.relocateDefPoint(refPoint,defPoint);
  }
}
