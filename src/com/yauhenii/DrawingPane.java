package com.yauhenii;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DrawingPane extends JLayeredPane {
  // consts

  private final int DEFAULT_VERTEX_NUMBER = 6;
  private final int WINDOW_WIDTH = 800;
  private final int WINDOW_HEIGHT = 800;

  // fields

  private int vertexNum = DEFAULT_VERTEX_NUMBER;

  private Color curBorderColor = new Color(10, 100, 100);
  private Color curFigureColor = new Color(236, 103, 81);
  private int xCurr;
  private int yCurr;
  private int xPrev;
  private int yPrev;

  ArrayList<Point> clickedPoints;

  FigureMotionAdapter motionAdapter;
  FigureMouseAdapter mouseAdapter;

  private ArrayList<JButton> figureButtons;
  private ArrayList<JButton> toolButtons;
  private JList<Figure> figureJList;
  private DefaultListModel<Figure> figureJListModel;

  private Figure selectedFigure; // for moving selected figure

  private WindowApp owner;

  // constructors

  public DrawingPane(WindowApp owner) {
    // Window app
    this.owner = owner;
    // Jlist
    figureJList = owner.getFigureJList();
    figureJListModel = (DefaultListModel) figureJList.getModel();
    // buttons
    figureButtons = owner.getFigureButtons();
    toolButtons = owner.getToolButtons();
    toolButtons.get(FigureUtils.ToolsType.BORDER_COLOR.ordinal()).setForeground(curFigureColor);
    toolButtons.get(FigureUtils.ToolsType.FIGURE_COLOR.ordinal()).setForeground(curBorderColor);
    // mouse
    motionAdapter = new FigureMotionAdapter();
    mouseAdapter = new FigureMouseAdapter(this);
    // this panel
    setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
    setLayout(null);
    setVisible(true);
    // listeners
    addFigureButtonsListeners();
    addToolButtonsListeners();
    addFigureJListListeners();
    addMouseListeners();
  }

  private void addFigureButtonsListeners() {
    for (HashMap.Entry<FigureUtils.FigureType, String> entry :
        FigureUtils.twoPoints1DFiguresMap.entrySet()) {
      figureButtons
          .get(entry.getKey().ordinal())
          .addActionListener(
              new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                  if (clickedPoints != null) {
                    if (clickedPoints.size() < 2) {
                      JOptionPane.showMessageDialog(
                          DrawingPane.this,
                          new String[] {
                            "You set less than two points",
                            "There should be two points to draw this figure",
                          },
                          "Warning",
                          JOptionPane.WARNING_MESSAGE);
                    } else {
                      if (clickedPoints.size() > 2) {
                        JOptionPane.showMessageDialog(
                            DrawingPane.this,
                            new String[] {
                              "You set more than two points",
                              " This figure will be drawn by the first two points you set",
                            },
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                      }
                      try {
                        Constructor constructor =
                            Class.forName(entry.getValue())
                                .getConstructor(Point.class, Point.class, Color.class);
                        Figure figure =
                            (Figure)
                                constructor.newInstance(
                                    clickedPoints.get(0), clickedPoints.get(1), curBorderColor);
                        add(figure);
                        figureJListModel.addElement(figure);
                        figure.display();
                        figure.addMouseListener(mouseAdapter);
                        figure.addMouseMotionListener(motionAdapter);
                        repaint();
                        clickedPoints = null;
                      } catch (Exception exception) {
                        System.out.println(exception.getStackTrace());
                      }
                    }
                  } else {
                    clickedPoints = new ArrayList<>();
                  }
                }
              });
    }
    for (HashMap.Entry<FigureUtils.FigureType, String> entry :
        FigureUtils.twoPoints2DFiguresMap.entrySet()) {
      figureButtons
          .get(entry.getKey().ordinal())
          .addActionListener(
              new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  if (clickedPoints != null) {
                    if (clickedPoints.size() < 2) {
                      JOptionPane.showMessageDialog(
                          DrawingPane.this,
                          new String[] {
                            "You set less than two points",
                            "There should be two points to draw this figure",
                          },
                          "Warning",
                          JOptionPane.WARNING_MESSAGE);
                    } else {
                      if (clickedPoints.size() > 2) {
                        JOptionPane.showMessageDialog(
                            DrawingPane.this,
                            new String[] {
                              "You set more than two points",
                              "This figure will be drawn by the first two points you set",
                            },
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                      }
                      try {
                        Constructor constructor =
                            Class.forName(entry.getValue())
                                .getConstructor(Point.class, Point.class, Color.class, Color.class);
                        Figure figure =
                            (Figure)
                                constructor.newInstance(
                                    clickedPoints.get(0),
                                    clickedPoints.get(1),
                                    curBorderColor,
                                    curFigureColor);
                        add(figure);
                        figureJListModel.addElement(figure);
                        figure.display();
                        figure.addMouseListener(mouseAdapter);
                        figure.addMouseMotionListener(motionAdapter);
                        repaint();
                        clickedPoints = null;
                      } catch (Exception exception) {
                        System.out.println(exception.getStackTrace());
                      }
                    }

                  } else {
                    clickedPoints = new ArrayList<>();
                  }
                }
              });
    }
    figureButtons
        .get(FigureUtils.FigureType.POLYGON.ordinal())
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {
                JButton button = (JButton) event.getSource();
                if (clickedPoints != null) {
                  if (clickedPoints.size() < 3) {
                    JOptionPane.showMessageDialog(
                        DrawingPane.this,
                        new String[] {
                          "You set less than three points",
                          "There should be three or more points to draw this figure",
                        },
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
                  } else {
                    ArrayList<Point> rectPoints =
                        FigureUtils.getСircumscribedRectPoints(clickedPoints);
                    Figure polygon =
                        new Polygon(
                            rectPoints.get(0),
                            rectPoints.get(1),
                            clickedPoints,
                            curBorderColor,
                            curFigureColor);
                    add(polygon);
                    figureJListModel.addElement(polygon);
                    polygon.display();
                    polygon.addMouseListener(mouseAdapter);
                    polygon.addMouseMotionListener(motionAdapter);
                    repaint();
                    clickedPoints = null;
                    button.setForeground(Color.BLACK);
                  }
                } else {
                  clickedPoints = new ArrayList<>();
                  button.setForeground(Color.RED);
                }
              }
            });
    figureButtons
        .get(FigureUtils.FigureType.TRIANGLE.ordinal())
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {
                JButton button = (JButton) event.getSource();
                if (clickedPoints != null) {
                  if (clickedPoints.size() < 3) {
                    JOptionPane.showMessageDialog(
                        DrawingPane.this,
                        new String[] {
                          "You set less than three points",
                          "There should be three points to draw this figure",
                        },
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
                  } else {
                    if (clickedPoints.size() > 3) {
                      JOptionPane.showMessageDialog(
                          DrawingPane.this,
                          new String[] {
                            "You set more than three points",
                            "This figure will be drawn by the first three points you set",
                          },
                          "Warning",
                          JOptionPane.WARNING_MESSAGE);
                    }
                    ArrayList<Point> rectPoints =
                        FigureUtils.getСircumscribedRectPoints(clickedPoints);
                    Figure triangle =
                        new Triangle(
                            rectPoints.get(0),
                            rectPoints.get(1),
                            new ArrayList<>(clickedPoints.subList(0, 3)),
                            curBorderColor,
                            curFigureColor);
                    add(triangle);
                    figureJListModel.addElement(triangle);
                    triangle.display();
                    triangle.addMouseListener(mouseAdapter);
                    triangle.addMouseMotionListener(motionAdapter);
                    repaint();
                    clickedPoints = null;
                    button.setForeground(Color.BLACK);
                  }

                } else {
                  clickedPoints = new ArrayList<>();
                  button.setForeground(Color.RED);
                }
              }
            });

    figureButtons
        .get(FigureUtils.FigureType.REGULAR_POLYGON.ordinal())
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {
                if (clickedPoints != null) {
                  if (clickedPoints.size() < 2) {
                    JOptionPane.showMessageDialog(
                        DrawingPane.this,
                        new String[] {
                          "You set more than two points",
                          " There should be two points to draw this figure",
                        },
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
                  } else {
                    if (clickedPoints.size() > 2) {
                      JOptionPane.showMessageDialog(
                          DrawingPane.this,
                          new String[] {
                            "You set more than two points",
                            " This figure will be drawn by the first two points you set",
                          },
                          "Warning",
                          JOptionPane.WARNING_MESSAGE);
                    }
                    Figure regularPolygon =
                        new RegularPolygon(
                            clickedPoints.get(0),
                            clickedPoints.get(1),
                            vertexNum,
                            curBorderColor,
                            curFigureColor);
                    add(regularPolygon);
                    figureJListModel.addElement(regularPolygon);
                    regularPolygon.display();
                    regularPolygon.addMouseListener(mouseAdapter);
                    regularPolygon.addMouseMotionListener(motionAdapter);
                    repaint();
                    clickedPoints = null;
                  }
                } else {
                  clickedPoints = new ArrayList<>();
                }
              }
            });

    figureButtons
        .get(FigureUtils.FigureType.POLYLINE.ordinal())
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {
                JButton button = (JButton) event.getSource();
                if (clickedPoints != null) {
                  if (clickedPoints.size() < 3) {
                    JOptionPane.showMessageDialog(
                        DrawingPane.this,
                        new String[] {
                          "You set less than two points",
                          "There should be two or more points to draw this figure",
                        },
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
                  } else {
                    ArrayList<Point> rectPoints =
                        FigureUtils.getСircumscribedRectPoints(clickedPoints);
                    Figure polyline =
                        new Polyline(
                            rectPoints.get(0), rectPoints.get(1), clickedPoints, curBorderColor);
                    add(polyline);
                    figureJListModel.addElement(polyline);
                    polyline.display();
                    polyline.addMouseListener(mouseAdapter);
                    polyline.addMouseMotionListener(motionAdapter);
                    repaint();
                    clickedPoints = null;
                    button.setForeground(Color.BLACK);
                  }
                } else {
                  clickedPoints = new ArrayList<>();
                  button.setForeground(Color.RED);
                }
              }
            });
  }

  private void addToolButtonsListeners() {
    toolButtons
        .get(FigureUtils.ToolsType.DELETE.ordinal())
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                int i = figureJList.getSelectedIndex();
                if (i != -1) {
                  Figure figure = figureJList.getSelectedValue();
                  figureJListModel.remove(i);
                  remove(figure);
                  repaint();
                }
              }
            });
    toolButtons
        .get(FigureUtils.ToolsType.BORDER_COLOR.ordinal())
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                curFigureColor =
                    JColorChooser.showDialog(null, "Choose border color", curFigureColor);
                ((JButton) e.getSource()).setForeground(curFigureColor);
              }
            });
    toolButtons
        .get(FigureUtils.ToolsType.FIGURE_COLOR.ordinal())
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                curBorderColor =
                    JColorChooser.showDialog(null, "Choose figure color", curBorderColor);
                ((JButton) e.getSource()).setForeground(curBorderColor);
              }
            });
    toolButtons
        .get(FigureUtils.ToolsType.VERTEX.ordinal())
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                VertexDialog vertexDialog = new VertexDialog(owner, vertexNum);
                vertexDialog.setVisible(true);
                vertexNum = vertexDialog.getVertexNum();
              }
            });
  }

  private void addFigureJListListeners() {
    figureJList.addListSelectionListener(
        new ListSelectionListener() {
          @Override
          public void valueChanged(ListSelectionEvent e) {
            if (selectedFigure != null) {
              setLayer(selectedFigure, 2, 0);
            }
            if (figureJList.getSelectedValue() != null) {
              setLayer(figureJList.getSelectedValue(), 3, 1);
              selectedFigure = figureJList.getSelectedValue();
            }
          }
        });
    figureJList.setCellRenderer(
        new DefaultListCellRenderer() {
          public Component getListCellRendererComponent(
              JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c =
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            c.setBackground(((Figure) value).getBorderColor());
            return c;
          }
        });
  }

  private void addMouseListeners() {
    addMouseListener(
        new MouseAdapter() {
          @Override
          public void mousePressed(MouseEvent e) {
            if (clickedPoints != null) {
              clickedPoints.add(new Point(e.getX(), e.getY()));
              xPrev = clickedPoints.get(0).x;
              yPrev = clickedPoints.get(0).y;
            }
          }
        });
    addMouseMotionListener(
        new MouseMotionAdapter() {
          @Override
          public void mouseMoved(MouseEvent e) {
            super.mouseMoved(e);
            xCurr = e.getX();
            yCurr = e.getY();
            repaint();
          }
        });
  }

  //    @Override
  //    protected void paintComponent(Graphics g) {
  //      super.paintComponent(g);
  //      if(xPrev!=0 && yPrev!=0){
  //        g.drawRect(xPrev,yPrev,xCurr,yCurr);
  //      }
  //    }

  // getters and setters

  public Figure getSelectedFigure() {
    return selectedFigure;
  }

  public ArrayList<Point> getClickedPoints() {
    return clickedPoints;
  }
}
