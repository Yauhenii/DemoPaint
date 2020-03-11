package com.yauhenii;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FigureMouseAdapter extends MouseAdapter {
  // fields

  DrawingPane owner;

  // constructors

  public FigureMouseAdapter(DrawingPane owner) {
    this.owner = owner;
  }

  // methods
  @Override
  public void mousePressed(MouseEvent e) {
    super.mouseClicked(e);
    Figure figure = (Figure) e.getComponent();
    if (owner.getClickedPoints() != null) {
      owner.getClickedPoints().add(new Point(figure.getX() + e.getX(), figure.getY() + e.getY()));
    }
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    super.mouseReleased(e);
    //    JLayeredPane layeredPane = (JLayeredPane) e.getComponent().getParent();
    //    layeredPane.setLayer((JPanel) e.getSource(), 2, 0);
  }
}
