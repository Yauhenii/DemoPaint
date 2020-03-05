

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawingPane extends JPanel {
  JButton jb;

  List<JPanel> mypanels = new ArrayList<JPanel>();

  public DrawingPane() {
    jb = new JButton("Add Panel");
    jb.setBounds(10, 10, 100, 50);
    setPreferredSize(new Dimension(1000, 600));
    setSize(new Dimension(1000, 600));
    setLayout(null);
    add(jb);
    setVisible(true);
    jb.addActionListener(
        new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            JPanel panel = new JPanel(){

              @Override
              public void paintComponent(Graphics g) {
                g.setColor(new Color(65, 68, 236));
                g.fillOval(0,0,100,50);
              }
            };
            panel.setBounds(150, 150, 200, 200);
//            panel.setBackground(Color.black);

            mypanels.add(panel);
            add(panel);
            repaint();
            handleDrag();
          }
        });
  }

  public void handleDrag() {
    for (int i = 0; i < mypanels.size(); i++) {
      final int j = i;
      mypanels
          .get(i)
          .addMouseMotionListener(
              new MouseMotionAdapter() {

                @Override
                public void mouseDragged(MouseEvent me) {
                  me.translatePoint(
                      me.getComponent().getLocation().x, me.getComponent().getLocation().y);
                  mypanels.get(j).setLocation(me.getX(), me.getY());
                }
              });
    }
  }
}
