import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class WindowApp extends JFrame {
  //consts

  public static final int WINDOW_WIDTH=1200;
  public static final int WINDOW_HEIGHT=700;

  //fields

  private JPanel mainPanel;
  private JPanel drawingPane;

  public WindowApp(){
    // mainPanel
    mainPanel=new JPanel();
    mainPanel.setLayout(new BorderLayout());
    // drawingPane
    drawingPane=new DrawingPane();
    mainPanel.add(drawingPane,BorderLayout.NORTH);
    //window
    setWindowProperties();
  }

  private void setWindowProperties(){
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setResizable(false);
    setContentPane(mainPanel);
    setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
  }
}

