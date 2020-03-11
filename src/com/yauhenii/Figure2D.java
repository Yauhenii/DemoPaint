package com.yauhenii;

import java.awt.Color;
import java.awt.Point;

public abstract class Figure2D extends Figure {
  // fields

  private Color figureColor;

  // constructor

  public Figure2D(Point refPoint, Point defPoint, Color borderColor, Color figureColor) {
    super(refPoint, defPoint, borderColor);
    this.figureColor = figureColor;
  }

  // getters and setters

  public Color getFigureColor() {
    return figureColor;
  }

  public void setFigureColor(Color figureColor) {
    this.figureColor = figureColor;
  }
}
