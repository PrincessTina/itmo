package beans;

import classes.Point;

import java.util.ArrayList;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import static java.lang.Math.pow;

@ManagedBean(name = "point")
@SessionScoped
public class PaintBean implements Serializable {
  private double x;
  private double y = -3;
  private double r = 1.0;
  private String result;
  private static final ArrayList<Point> paints = new ArrayList<>();

  public void add() {
    check();

    if (result != null) {
      paints.add(new Point(this.x, this.y, this.r, this.result));
    }
  }

  private void check() {
    if (checkParams(x, y, r)) {
      if (checkPoint(x, y, r)) {
        result = "Point is in the scope";
      } else {
        result = "Point is out of the scope";
      }
    } else {
      result = null;
    }
  }

  private boolean checkPoint(double x, double y, double r) {
    if ((pow(x, 2) + pow(y, 2) <= pow(r, 2)) && (x <= 0) && (y >= 0)) {
      return true;
    }

    if ((x <= r) && (x >= 0) && (y >= 0) && (y <= r/2)) {
      return true;
    }

    if ((y >= -r/2 - x) && (x <= 0) && (y <= 0)) {
      return true;
    }

    return false;
  }

  private boolean checkParams(double x, double y, double r) {
    return !((x >= 5) || (x <= -3) || (r > 3) || (r < 1) || (y > 5) || (y < -3) ||
        (!String.valueOf(x).matches("^-?\\d+\\.?\\d*$")) || (!String.valueOf(y).matches("^-?\\d+\\.?\\d*$")) ||
        (!String.valueOf(r).matches("^-?\\d+\\.?\\d*$")));
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double getR() {
    return r;
  }

  public void setR(double r) {
    this.r = r;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getString() {
    StringBuilder answer = new StringBuilder();

    for (int i = 0; i < paints.size(); i++) {
      Point paint = paints.get(i);

      if (i > 0) {
        answer.append("; ");
      }

      answer.append(paint.getX());
      answer.append(", ");
      answer.append(paint.getY());
      answer.append(", ");
      answer.append(paint.getR());
      answer.append(", ");
      answer.append(paint.getResult());
    }

    return answer.toString();
  }

  public ArrayList<Point> getPaints() {
    return paints;
  }
}
