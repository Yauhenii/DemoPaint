package com.yauhenii;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class Polygon extends Figure2D {
  // fields

  private ArrayList<Point> auxiliaryPoints;
  private int[] x, y;
  private int size;

  // constructors

  public Polygon(
      Point refPoint,
      Point defPoint,
      ArrayList<Point> auxiliaryPoints,
      Color borderColor,
      Color figureColor) {
    super(refPoint, defPoint, borderColor, figureColor);
    setAuxiliaryPoints(auxiliaryPoints);
  }

  // methods

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(getBorderColor());
    g.fillPolygon(x, y, size);
    g.setColor(getFigureColor());

    int[] xP = new int[x.length + 1];
    int[] yP = new int[y.length + 1];
    for (int i = 0; i < x.length; i++) {
      xP[i] = x[i];
      yP[i] = y[i];
    }
    xP[x.length] = x[0];
    yP[y.length] = y[0];
    for (int i = 0; i < x.length + 1; i++) {
      while (xP[i] > getDefPoint().x - getRefPoint().x - 1) {
        xP[i]--;
      }
      while (yP[i] > getDefPoint().y - getRefPoint().y - 1) {
        yP[i]--;
      }
      while (xP[i] < 0) {
        xP[i]++;
      }
      while (yP[i] < 0) {
        yP[i]++;
      }
    }
    ((Graphics2D) g).setStroke(new BasicStroke(getBorderWidth()));
    g.drawPolyline(xP, yP, size + 1);
    //    g.drawRect(
    //        0,
    //        0,
    //        Math.abs(getDefPoint().x - getRefPoint().x),
    //        Math.abs(getDefPoint().y - getRefPoint().y));
  }

  // getters and setters

  public ArrayList<Point> getAuxiliaryPoints() {
    return auxiliaryPoints;
  }

  public void setAuxiliaryPoints(ArrayList<Point> auxiliaryPoints) {
    this.auxiliaryPoints = auxiliaryPoints;
    if (auxiliaryPoints != null) {
      setXY();
    }
  }

  private void setXY() {
    if (auxiliaryPoints != null) {
      size = auxiliaryPoints.size();
      x = new int[size];
      y = new int[size];
      for (int i = 0; i < size; i++) {
        x[i] = auxiliaryPoints.get(i).x - getRefPoint().x;
        y[i] = auxiliaryPoints.get(i).y - getRefPoint().y;
      }
    }
  }

  @Override
  public String toString() {
    return "Polygon";
  }
}
