import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class FigureMouseAdapter extends MouseAdapter {
  // fields

  private JLayeredPane layeredPane;
  // constructor

  public FigureMouseAdapter(JLayeredPane layeredPane) {
    this.layeredPane = layeredPane;
  }

  // methods

  @Override
  public void mousePressed(MouseEvent e) {
    super.mouseClicked(e);
    layeredPane.setLayer((JPanel) e.getSource(), 3, 1);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    super.mouseReleased(e);
    layeredPane.setLayer((JPanel) e.getSource(), 2, 0);
  }
}
