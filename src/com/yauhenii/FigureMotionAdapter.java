package com.yauhenii;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

public class FigureMotionAdapter extends MouseMotionAdapter {
  @Override
  public void mouseDragged(MouseEvent e) {
    Figure figure = (Figure) e.getComponent();
    int dX = (figure.getDefPoint().x - figure.getRefPoint().x) / 2;
    int dY = (figure.getDefPoint().y - figure.getRefPoint().y) / 2;
    Component component = e.getComponent().getParent();
    if (((DrawingPane) component).getSelectedFigure() == e.getComponent()) {
      e.translatePoint(e.getComponent().getX(), e.getComponent().getY());
      ((JPanel) e.getSource()).setLocation(e.getX() - dX, e.getY() - dY);
    }
  }
}
