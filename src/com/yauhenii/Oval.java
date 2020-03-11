package com.yauhenii;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Oval extends Figure2D {
  // constructors

  public Oval(Point refPoint, Point defPoint, Color borderColor, Color figureColor) {
    super(refPoint, defPoint, borderColor, figureColor);
  }

  // methods

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(getBorderColor());
    g.fillOval(
        0,
        0,
        Math.abs(getDefPoint().x - getRefPoint().x),
        Math.abs(getDefPoint().y - getRefPoint().y));
    g.setColor(getFigureColor());
    ((Graphics2D) g).setStroke(new BasicStroke(getBorderWidth()));
    g.drawOval(
        1,
        1,
        Math.abs(getDefPoint().x - getRefPoint().x - getBorderWidth() + 1),
        Math.abs(getDefPoint().y - getRefPoint().y - getBorderWidth() + 1));
    //    g.drawRect(
    //        0,
    //        0,
    //        Math.abs(getDefPoint().x - getRefPoint().x),
    //        Math.abs(getDefPoint().y - getRefPoint().y));
  }

  @Override
  public String toString() {
    return "Oval";
  }
}
