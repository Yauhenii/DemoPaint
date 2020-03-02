import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class StraightLine extends Ray {
  //constructors

  public StraightLine(Point firstPoint, Point secondPoint, Color borderColor) {
    super(firstPoint,secondPoint,borderColor);
  }

  public StraightLine(Ray ray){
    super(ray);
  }

  //methods
  public void draw(){
    System.out.println("Drawing the straight line...");
  }
}
