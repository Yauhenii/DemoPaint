import java.awt.Color;
import java.awt.Point;

public abstract class Figure1D extends Figure {
  // constructors

  public Figure1D(Point refPoint, Color borderColor) {
    super(refPoint, borderColor);
  }

  public Figure1D(Figure1D figure1D) {
    super(figure1D);
  }
}
