package com.yauhenii;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Triangle extends Polygon {
  // constructors

  public Triangle(
      Point refPoint,
      Point defPoint,
      ArrayList<Point> auxiliaryPoints,
      Color borderColor,
      Color figureColor) {
    super(refPoint, defPoint, auxiliaryPoints, borderColor, figureColor);
  }

  // methods

  @Override
  public String toString() {
    return "Triangle";
  }
}
