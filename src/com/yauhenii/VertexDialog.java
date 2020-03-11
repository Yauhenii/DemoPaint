package com.yauhenii;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VertexDialog extends JDialog {
  // consts

  private final int PANEL_ROWS_NUM = 3;
  private final int PANEL_COLS_NUM = 1;

  // fields

  JPanel mainPanel;
  JButton okButton;
  JTextArea textArea;

  int vertexNum;

  // constructors

  VertexDialog(WindowApp owner, int vertexNum) {
    super(owner, "Vertex dialog", true);
    // main panel
    mainPanel = new JPanel(new GridLayout(PANEL_ROWS_NUM, PANEL_COLS_NUM));
    // label
    mainPanel.add(new JLabel("Type vertex number"));
    // text area
    this.vertexNum = vertexNum;
    textArea = new JTextArea(Integer.toString(vertexNum));
    mainPanel.add(textArea);
    // button
    okButton = new JButton("OK");
    mainPanel.add(okButton);
    // window
    setResizable(false);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setContentPane(mainPanel);
    pack();
    // listeners
    okButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            try {
              VertexDialog.this.vertexNum = Integer.parseInt(textArea.getText());
            } catch (IllegalArgumentException exception) {
              JOptionPane.showMessageDialog(
                  VertexDialog.this,
                  "Check input format.",
                  "Inane warning",
                  JOptionPane.WARNING_MESSAGE);
            }
          }
        });
  }

  // getters and setters

  public int getVertexNum() {
    return vertexNum;
  }
}
