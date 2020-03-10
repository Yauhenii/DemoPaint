import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

public class FigureUtils {
  // methods
  public static ArrayList<Point> getСircumscribedRectPoints(ArrayList<Point> points) {
    ArrayList<Point> rectPoints = new ArrayList<>();

    ArrayList<Integer> xList = new ArrayList<>();
    ArrayList<Integer> yList = new ArrayList<>();

    for (Point point : points) {
      xList.add(point.x);
      yList.add(point.y);
    }

    rectPoints.add(new Point(Collections.max(xList), Collections.max(yList))); // defPoint
    rectPoints.add(new Point(Collections.min(xList), Collections.min(yList))); // refPoint

    return rectPoints;
  }

  public static void relocateDefPoint(Point refPoint, Point defPoint) {

    int dX = defPoint.x - refPoint.x;
    int dY = defPoint.y - refPoint.y;
    if (dX <= dY) {
      defPoint.y = refPoint.y + dX;
    } else {
      defPoint.x = refPoint.x + dY;
    }
  }
}
