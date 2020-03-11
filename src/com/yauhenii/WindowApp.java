package com.yauhenii;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;

public class WindowApp extends JFrame {
  // consts

  public static final int WINDOW_WIDTH = 1200;
  public static final int WINDOW_HEIGHT = 800;

  private final int FIGURES_PANEL_ROWS_NUM = 8;
  private final int FIGURES_PANEL_COLS_NUM = 2;

  // fields

  private ArrayList<JButton> figureButtons;
  private ArrayList<JButton> toolButtons;

  private JPanel mainPanel;
  private JLayeredPane drawingPane;
  private JPanel figuresToolsPanel;
  private JPanel toolsPanel;

  private JList<Figure> figureJList;
  private DefaultListModel<Figure> figureJListModel;

  public WindowApp() {
    // main panel
    mainPanel = new JPanel(new BorderLayout());
    // tools pane
    initFiguresToolsPanel();
    // drawing Pane
    drawingPane = new DrawingPane(this);
    mainPanel.add(drawingPane, BorderLayout.EAST);
    // window
    setWindowProperties();
  }

  public void initFiguresToolsPanel() {
    toolsPanel = new JPanel(new BorderLayout());
    // jlist
    figureJListModel = new DefaultListModel<>();
    figureJList = new JList<>(figureJListModel);
    figureJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    figureJList.setPreferredSize(new Dimension(WINDOW_WIDTH / 10, WINDOW_HEIGHT));
    toolsPanel.add(figureJList, BorderLayout.EAST);
    // figures and tools
    figuresToolsPanel = new JPanel(new GridLayout(FIGURES_PANEL_ROWS_NUM, FIGURES_PANEL_COLS_NUM));
    // figures
    figureButtons = new ArrayList<>();
    JButton figureButton;
    try {
      Icon icon;
      for (FigureUtils.FigureType figureType : FigureUtils.FigureType.values()) {
        figureButton = new JButton(); // FigureUtils.figuresNamesMap.get(figureType)
        figuresToolsPanel.add(figureButton);
        icon = new ImageIcon(FigureUtils.figuresFileNamesMap.get(figureType));
        figureButton.setIcon(icon);
        figureButtons.add(figureButton);
      }
    } catch (Exception exception) {
      System.out.println(exception.getStackTrace());
    }
    // tools
    toolButtons = new ArrayList<>();
    toolButtons.add(new JButton("Delete"));
    toolButtons.add(new JButton("Border"));
    toolButtons.add(new JButton("Figure"));
    toolButtons.add(new JButton("Vertex"));
    for (JButton button : toolButtons) {
      figuresToolsPanel.add(button);
    }
    //
    toolsPanel.add(figuresToolsPanel, BorderLayout.WEST);
    //
    mainPanel.add(toolsPanel, BorderLayout.WEST);
  }

  private void setWindowProperties() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setResizable(false);
    setContentPane(mainPanel);
  }

  // getters and setters

  public ArrayList<JButton> getFigureButtons() {
    return figureButtons;
  }

  public ArrayList<JButton> getToolButtons() {
    return toolButtons;
  }

  public JList<Figure> getFigureJList() {
    return figureJList;
  }
}
