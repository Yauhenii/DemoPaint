import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

public class FigureMotionAdapter extends MouseMotionAdapter {
    @Override
    public void mouseDragged(MouseEvent e) {
      e.translatePoint(e.getComponent().getLocation().x, e.getComponent().getLocation().y);
      ((JPanel) e.getSource()).setLocation(e.getX(), e.getY());
    }
}
