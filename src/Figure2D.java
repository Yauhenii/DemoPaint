import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Figure2D extends Figure {
  // fields

  private Point defPoint;

  private Color figureColor;

  //

  public Figure2D(Point firstpoint, Point secondPoint, Color borderColor, Color figureColor) {
    super(firstpoint, borderColor);
    this.defPoint = secondPoint;
    this.figureColor = figureColor;
  }

  public Figure2D(Figure2D figure2D) {
    super(figure2D);
    this.defPoint = new Point(figure2D.defPoint);
    this.figureColor = new Color(figure2D.figureColor.getRGB());
  }

  // methods

  public ArrayList<Point> location() {
    return new ArrayList<Point>(Arrays.asList(getRefPoint(), defPoint));
  }

  // getters and setters

  public Point getDefPoint() {
    return defPoint;
  }

  public void setDefPoint(Point defPoint) {
    this.defPoint = defPoint;
  }

  public Color getFigureColor() {
    return figureColor;
  }

  public void setFigureColor(Color figureColor) {
    this.figureColor = figureColor;
  }
}
