package beans;

import classes.Point;
import java.util.ArrayList;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import static java.lang.Math.pow;

public class PointBean implements Serializable {
  private double x;
  private double y = -3;
  private double r = 1.0;
  private String result;
  private ArrayList<Point> points = new ArrayList<Point>();

  public void add() {
    check();

    if (result != null) {
      Point point = new Point(getSessionId(), this.x, this.y, this.r, this.result);
      DataBean.addPoint(point);
      points.add(point);
    }
  }

  public void update() {
    for (int i = 0; i < points.size(); i++) {
      Point point = points.get(i);

      point.setR(r);
      x = points.get(i).getX();
      y = points.get(i).getY();
      check();
      point.setResult(result);

      DataBean.updatePoint(point);
      points.set(i, point);
    }
  }

  public void updateTable() {
    DataBean.updatePoint(points.get(0));
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

  public double getX()
  {
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

  public ArrayList<Point> getPoints() {
    return points;
  }

  private int getSessionId() {
    FacesContext fCtx = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
    return session.getId().hashCode();
  }
}

