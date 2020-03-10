import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DrawingPane extends JLayeredPane {
  // consts

  enum ToolsType {
    DELETE,
    BORDER_COLOR,
    FIGURE_COLOR,
    VERTEX
  }

  enum FigureType {
    POLYLINE,
    LINE_SEGMENT,
    RAY,
    STRAIGHT_LINE,
    OVAL,
    CIRCLE,
    POLYGON,
    REGULAR_POLYGON,
    RHOMBUS,
    TRIANGLE,
    RECTANGLE,
    SQUARE
  }

  private final int DEFAULT_VERTEX_NUMBER=6;

  private final int WINDOW_WIDTH = 1000;
  private final int WINDOW_HEIGHT = 600;

  private final HashMap<FigureType, String> twoPoints1DFiguresMap =
      new HashMap<FigureType, String>() {
        {
          put(FigureType.LINE_SEGMENT, "LineSegment");
          put(FigureType.RAY, "Ray");
          put(FigureType.STRAIGHT_LINE, "StraightLine");
        }
      };

  private final HashMap<FigureType, String> twoPoints2DFiguresMap =
      new HashMap<FigureType, String>() {
        {
          put(FigureType.OVAL, "Oval");
          put(FigureType.CIRCLE, "Circle");
          put(FigureType.RHOMBUS, "Rhombus");
          put(FigureType.RECTANGLE, "Rectangle");
          put(FigureType.SQUARE, "Square");
        }
      };

  // fields

  private int vertexNum=DEFAULT_VERTEX_NUMBER;

  private Color curBorderColor = new Color(10, 100, 100);
  private Color curFigureColor = new Color(236, 103, 81);

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

  public DrawingPane(
      WindowApp owner,
      ArrayList<JButton> figureButtonsList,
      ArrayList<JButton> toolButtonsList,
      JList<Figure> jList) {
    // Window app
    this.owner=owner;
    // Jlist
    figureJList = jList;
    figureJListModel = (DefaultListModel) figureJList.getModel();
    // buttons
    figureButtons = figureButtonsList;
    toolButtons = toolButtonsList;
    toolButtons.get(ToolsType.BORDER_COLOR.ordinal()).setForeground(curFigureColor);
    toolButtons.get(ToolsType.FIGURE_COLOR.ordinal()).setForeground(curBorderColor);
    // mouse
    motionAdapter = new FigureMotionAdapter();
    mouseAdapter = new FigureMouseAdapter();
    //
    setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
    setLayout(null);
    setVisible(true);

    for (HashMap.Entry<FigureType, String> entry : twoPoints2DFiguresMap.entrySet()) {
      figureButtons
          .get(entry.getKey().ordinal())
          .addActionListener(
              new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  if (clickedPoints != null) {
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
                  } else {
                    clickedPoints = new ArrayList<>();
                  }
                }
              });
    }

    for (HashMap.Entry<FigureType, String> entry : twoPoints1DFiguresMap.entrySet()) {
      figureButtons
          .get(entry.getKey().ordinal())
          .addActionListener(
              new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                  if (clickedPoints != null) {
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
                  } else {
                    clickedPoints = new ArrayList<>();
                  }
                }
              });
    }

    for (HashMap.Entry<FigureType, String> entry : twoPoints2DFiguresMap.entrySet()) {}

    figureButtons
        .get(FigureType.POLYGON.ordinal())
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {
                JButton button = (JButton) event.getSource();
                if (clickedPoints != null) {
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
                } else {
                  clickedPoints = new ArrayList<>();
                  button.setForeground(Color.RED);
                }
              }
            });
    figureButtons
        .get(FigureType.TRIANGLE.ordinal())
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {
                JButton button = (JButton) event.getSource();
                if (clickedPoints != null) {
                  ArrayList<Point> rectPoints =
                      FigureUtils.getСircumscribedRectPoints(clickedPoints);
                  Figure triangle =
                      new Triangle(
                          rectPoints.get(0),
                          rectPoints.get(1),
                          clickedPoints,
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
                } else {
                  clickedPoints = new ArrayList<>();
                  button.setForeground(Color.RED);
                }
              }
            });

    figureButtons
        .get(FigureType.REGULAR_POLYGON.ordinal())
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {
                JButton button = (JButton) event.getSource();
                if (clickedPoints != null) {
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
                } else {
                  clickedPoints = new ArrayList<>();
                }
              }
            });

    figureButtons
        .get(FigureType.POLYLINE.ordinal())
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {
                JButton button = (JButton) event.getSource();
                if (clickedPoints != null) {
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
                } else {
                  clickedPoints = new ArrayList<>();
                  button.setForeground(Color.RED);
                }
              }
            });

    toolButtons
        .get(ToolsType.DELETE.ordinal())
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
        .get(ToolsType.BORDER_COLOR.ordinal())
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
        .get(ToolsType.FIGURE_COLOR.ordinal())
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                curBorderColor =
                    JColorChooser.showDialog(null, "Choose figure color", curBorderColor);
                ((JButton) e.getSource()).setForeground(curBorderColor);
              }
            });
    toolButtons.get(ToolsType.VERTEX.ordinal())
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                VertexDialog vertexDialog=new VertexDialog(owner,vertexNum);
                vertexDialog.setVisible(true);
                vertexNum=vertexDialog.getVertexNum();
              }
            });
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
    figureJList.setCellRenderer(new DefaultListCellRenderer(){
      public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
        Component c = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );
        c.setBackground(((Figure)value).getBorderColor());
        return c;
      }
    });
    addMouseListener(
        new MouseAdapter() {
          @Override
          public void mousePressed(MouseEvent e) {
            if (clickedPoints != null) {
              clickedPoints.add(new Point(e.getX(), e.getY()));
            }
          }
        });
  }

  // getters and setters


  public Figure getSelectedFigure() {
    return selectedFigure;
  }
}
