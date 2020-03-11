package com.yauhenii;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FigureUtils {
  // consts
  public enum ToolsType {
    DELETE,
    BORDER_COLOR,
    FIGURE_COLOR,
    VERTEX
  }

  public enum FigureType {
    POLYLINE,
    LINE_SEGMENT,
    RAY,
    STRAIGHT_LINE,
    OVAL,
    CIRCLE,
    POLYGON,
    REGULAR_POLYGON,
    RHOMBUS,
    TRIANGLE,
    RECTANGLE,
    SQUARE
  }

  public static final HashMap<FigureType, String> figuresNamesMap =
      new HashMap<FigureType, String>() {
        {
          put(FigureType.POLYLINE, "Polyline");
          put(FigureType.LINE_SEGMENT, "Line segment");
          put(FigureType.RAY, "Ray");
          put(FigureType.STRAIGHT_LINE, "Straight line");
          put(FigureType.OVAL, "Oval");
          put(FigureType.CIRCLE, "Circle");
          put(FigureType.POLYGON, "Polygon");
          put(FigureType.REGULAR_POLYGON, "Regular polygon");
          put(FigureType.RHOMBUS, "Rhombus");
          put(FigureType.TRIANGLE, "Triangle");
          put(FigureType.RECTANGLE, "Rectangle");
          put(FigureType.SQUARE, "Square");
        }
      };

  public static final HashMap<FigureType, String> figuresFileNamesMap =
      new HashMap<FigureType, String>() {
        {
          put(FigureType.POLYLINE, "resources/Polyline.png");
          put(FigureType.LINE_SEGMENT, "resources/LineSegment.png");
          put(FigureType.RAY, "resources/Ray.png");
          put(FigureType.STRAIGHT_LINE, "resources/StraightLine.png");
          put(FigureType.OVAL, "resources/Oval.png");
          put(FigureType.CIRCLE, "resources/Circle.png");
          put(FigureType.POLYGON, "resources/Polygon.png");
          put(FigureType.REGULAR_POLYGON, "resources/RegularPolygon.png");
          put(FigureType.RHOMBUS, "resources/Rhombus.png");
          put(FigureType.TRIANGLE, "resources/Triangle.png");
          put(FigureType.RECTANGLE, "resources/Rectangle.png");
          put(FigureType.SQUARE, "resources/Square.png");
        }
      };

  public static final HashMap<FigureType, String> twoPoints1DFiguresMap =
      new HashMap<FigureType, String>() {
        {
          put(FigureType.LINE_SEGMENT, "com.yauhenii.LineSegment");
          put(FigureType.RAY, "com.yauhenii.Ray");
          put(FigureType.STRAIGHT_LINE, "com.yauhenii.StraightLine");
        }
      };

  public static final HashMap<FigureType, String> twoPoints2DFiguresMap =
      new HashMap<FigureType, String>() {
        {
          put(FigureType.OVAL, "com.yauhenii.Oval");
          put(FigureType.CIRCLE, "com.yauhenii.Circle");
          put(FigureType.RHOMBUS, "com.yauhenii.Rhombus");
          put(FigureType.RECTANGLE, "com.yauhenii.Rectangle");
          put(FigureType.SQUARE, "com.yauhenii.Square");
        }
      };

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
