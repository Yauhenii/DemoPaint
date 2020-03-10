import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FigureMouseAdapter extends MouseAdapter {
  @Override
  public void mousePressed(MouseEvent e) {
    super.mouseClicked(e);
//    JLayeredPane layeredPane = (JLayeredPane) e.getComponent().getParent();
//    layeredPane.setLayer((JPanel) e.getSource(), 3, 1);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    super.mouseReleased(e);
//    JLayeredPane layeredPane = (JLayeredPane) e.getComponent().getParent();
//    layeredPane.setLayer((JPanel) e.getSource(), 2, 0);
  }
}
