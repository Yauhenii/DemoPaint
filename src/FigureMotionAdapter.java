import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class FigureMotionAdapter extends MouseMotionAdapter {
  @Override
  public void mouseDragged(MouseEvent e) {
    Component component = e.getComponent().getParent();
    if (((DrawingPane)component).getSelectedFigure() == e.getComponent()) {
      e.translatePoint(e.getComponent().getX(), e.getComponent().getY());
      ((JPanel) e.getSource()).setLocation(e.getX(), e.getY());
    }
  }
}
