package com.yauhenii;

import java.awt.Color;
import java.awt.Point;

public class Square extends Rectangle {
  // constructors

  public Square(Point refPoint, Point defPoint, Color borderColor, Color figureColor) {
    super(refPoint, defPoint, borderColor, figureColor);
    FigureUtils.relocateDefPoint(getRefPoint(), getDefPoint());
  }

  // methods

  @Override
  public String toString() {
    return "Square";
  }
}
