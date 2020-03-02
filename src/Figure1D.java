import java.awt.Color;
import java.awt.Point;

public abstract class Figure1D extends Figure {
  //fields

  //constructors

  public Figure1D(Point firstPoint, Color borderColor) {
    super(firstPoint,borderColor);
  }

  public Figure1D(Figure1D figure1D) {
    super(figure1D);
  }

  //methods
}
