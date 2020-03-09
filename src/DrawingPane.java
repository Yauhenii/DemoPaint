import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class DrawingPane extends JLayeredPane {
  // consts

  private final int FIGURES_PANEL_ROWS_NUM = 7;
  private final int FIGURES_PANEL_COLS_NUM = 2;

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

  private ArrayList<JButton> figureButtons;

  private JPanel figuresPanel;

  private JButton borderColorButton;
  private JButton figureColorButton;
  private JButton deleteFigureButton;

  private Color curBorderColor = new Color(236, 103, 81);
  private Color curFigureColor = new Color(10, 100, 100);


  ArrayList<Point> clickedPoints;

  FigureMotionAdapter motionAdapter;
  FigureMouseAdapter mouseAdapter;

  // constructors

  public DrawingPane() {
    initToolsPanelButtons();
    initFiguresPanel();
    initAdapters();

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

    borderColorButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            curBorderColor = JColorChooser.showDialog(null, "Choose border color", curBorderColor);
            borderColorButton.setForeground(curBorderColor);
          }
        });
    figureColorButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            curFigureColor = JColorChooser.showDialog(null, "Choose figure color", curFigureColor);
            figureColorButton.setForeground(curFigureColor);
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

  private void initDrawingPanel() {

  }

  private void initAdapters() {
    motionAdapter = new FigureMotionAdapter();
    mouseAdapter = new FigureMouseAdapter(this);
  }

  public void initFiguresPanel() {
    figureButtons = new ArrayList<>();
    figuresPanel = new JPanel(new GridLayout(FIGURES_PANEL_ROWS_NUM, FIGURES_PANEL_COLS_NUM));
    JButton figureButton;
    for (FigureType figureType : FigureType.values()) {
      figureButton = new JButton(figureType.name());
      figuresPanel.add(figureButton);
      figureButtons.add(figureButton);
    }

    figuresPanel.add(deleteFigureButton);
    figuresPanel.add(borderColorButton);
    figuresPanel.add(figureColorButton);

    figuresPanel.setBackground(new Color(10, 10, 10));
    figuresPanel.setBounds(0, 0, WINDOW_WIDTH / 5, WINDOW_HEIGHT);
    add(figuresPanel);
  }

  private void initToolsPanelButtons() {
    borderColorButton = new JButton("Border");
    figureColorButton = new JButton("Figure");
    deleteFigureButton = new JButton("Delete");

    borderColorButton.setForeground(curBorderColor);
    figureColorButton.setForeground(curFigureColor);
  }
}
