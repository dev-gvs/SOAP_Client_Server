package soap;

import java.io.Serializable;

public class Result implements Serializable {

    private double y;

    public Result() {
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Result{" + "y=" + y + '}';
    }

}
