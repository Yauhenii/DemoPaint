package com.yauhenii;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JPanel;

public abstract class Figure extends JPanel {
  // fields

  private Point refPoint;

  private Point defPoint;

  private Color borderColor;

  private int borderWidth = 3;

  // constructors

  public Figure(Point refPoint, Point defPoint, Color borderColor) {
    this.refPoint = new Point(refPoint);
    this.defPoint = new Point(defPoint);
    this.borderColor = borderColor;

    relocatePoints();
    setOpaque(false);
  }

  // methods

  private void relocatePoints() {
    if (getRefPoint().x >= getDefPoint().x) {
      int x = getRefPoint().x;
      getRefPoint().x = getDefPoint().x;
      getDefPoint().x = x;
    }
    if (getRefPoint().y >= getDefPoint().y) {
      int x = getRefPoint().y;
      getRefPoint().y = getDefPoint().y;
      getDefPoint().y = x;
    }
  }

  public void display() {
    setBounds(
        getRefPoint().x,
        getRefPoint().y,
        Math.abs(getDefPoint().x - getRefPoint().x),
        Math.abs(getDefPoint().y - getRefPoint().y));
  }

  // getters and setters

  public Point getRefPoint() {
    return refPoint;
  }

  public void setRefPoint(Point refPoint) {
    this.refPoint = refPoint;
  }

  public Point getDefPoint() {
    return defPoint;
  }

  public void setDefPoint(Point defPoint) {
    this.defPoint = defPoint;
  }

  public Color getBorderColor() {
    return borderColor;
  }

  public void setBorderColor(Color borderColor) {
    this.borderColor = borderColor;
  }

  public int getBorderWidth() {
    return borderWidth;
  }

  public void setBorderWidth(int borderWidth) {
    this.borderWidth = borderWidth;
  }
}
