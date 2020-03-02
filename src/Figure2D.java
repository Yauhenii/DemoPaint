import java.awt.Color;
import java.awt.Point;

public abstract class Figure2D extends Figure {
  //
  private Color BorderColor;
  //
  Figure2D(Point point1, Point point2, Color color){
    super(point1,color);

  }
  //
  public abstract void draw();
}
