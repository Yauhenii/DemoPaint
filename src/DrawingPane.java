import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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

  private JButton borderColorButton;
  private JButton figureColorButton;
  private JButton deleteFigureButton;

  private Color curBorderColor = new Color(236, 103, 81);
  private Color curFigureColor = new Color(10, 100, 100);

  private JPanel figuresPanel;

  ArrayList<Point> clickedPoints;

  FigureMotionAdapter motionAdapter;
  FigureMouseAdapter mouseAdapter;

  // constructors

  public DrawingPane() {
    // figuresPanel
    initToolsPanelButtons();
    initFiguresPanel();
    initAdapters();

    //
    setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
    setLayout(null);
    setVisible(true);

    ActionListener twoPointsFigureListener= new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (clickedPoints != null) {
          Figure oval =
              new Oval(
                  clickedPoints.get(0), clickedPoints.get(1), curBorderColor, curFigureColor);
          add(oval);
          oval.display();
          oval.addMouseListener(mouseAdapter);
          oval.addMouseMotionListener(motionAdapter);
          repaint();
          clickedPoints = null;
        } else {
          clickedPoints = new ArrayList<>();
        }
      }
    };

    figureButtons.get(FigureType.OVAL.ordinal()).addActionListener(twoPointsFigureListener);


    figureButtons.get(FigureType.CIRCLE.ordinal()).addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            if (clickedPoints != null) {
              Figure circle =
                  new Circle(
                      clickedPoints.get(0), clickedPoints.get(1), curBorderColor, curFigureColor);
              add(circle);
              circle.display();
              circle.addMouseListener(mouseAdapter);
              circle.addMouseMotionListener(motionAdapter);
              repaint();
              clickedPoints = null;
            } else {
              clickedPoints = new ArrayList<>();
            }
          }
        });

    figureButtons.get(FigureType.RECTANGLE.ordinal()).addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            if (clickedPoints != null) {
              Figure rectangle =
                  new Rectangle(
                      clickedPoints.get(0), clickedPoints.get(1), curBorderColor, curFigureColor);
              add(rectangle);
              rectangle.display();
              rectangle.addMouseListener(mouseAdapter);
              rectangle.addMouseMotionListener(motionAdapter);
              repaint();
              clickedPoints = null;
            } else {
              clickedPoints = new ArrayList<>();
            }
          }
        });

    figureButtons.get(FigureType.RHOMBUS.ordinal()).addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            if (clickedPoints != null) {
              Figure rhombus =
                  new Rhombus(
                      clickedPoints.get(0), clickedPoints.get(1), curBorderColor, curFigureColor);
              add(rhombus);
              rhombus.display();
              rhombus.addMouseListener(mouseAdapter);
              rhombus.addMouseMotionListener(motionAdapter);
              repaint();
              clickedPoints = null;
            } else {
              clickedPoints = new ArrayList<>();
            }
          }
        });

    figureButtons.get(FigureType.LINE_SEGMENT.ordinal()).addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            if (clickedPoints != null) {
              Figure lineSegment =
                  new LineSegment(
                      clickedPoints.get(0), clickedPoints.get(1), curBorderColor);
              add(lineSegment);
              lineSegment.display();
              lineSegment.addMouseListener(mouseAdapter);
              lineSegment.addMouseMotionListener(motionAdapter);
              repaint();
              clickedPoints = null;
            } else {
              clickedPoints = new ArrayList<>();
            }
          }
        });

    figureButtons.get(FigureType.POLYGON.ordinal()).addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent event) {
            JButton button=(JButton)event.getSource();
            if (clickedPoints != null) {
              ArrayList<Point> rectPoints = FigureUtils.getСircumscribedRectPoints(clickedPoints);
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

  private void initAdapters() {
    motionAdapter=new FigureMotionAdapter();
    mouseAdapter=new FigureMouseAdapter(this);
  }

  public void initFiguresPanel() {
    figureButtons=new ArrayList<>();
    figuresPanel = new JPanel(new GridLayout(FIGURES_PANEL_ROWS_NUM, FIGURES_PANEL_COLS_NUM));
    JButton figureButton;
    for(FigureType figureType : FigureType.values()){
      figureButton=new JButton(figureType.name());
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


