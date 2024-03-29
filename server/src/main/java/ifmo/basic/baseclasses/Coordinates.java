package ifmo.basic.baseclasses;

import java.io.Serializable;

/**
 * The Coordinates class represents a pair of coordinates (x, y).
 * It implements the Serializable interface, allowing instances to be written to and read from streams.
 *
 * @version 1.0?
 * @since ??.??.????
 */
public class Coordinates implements Serializable {
    private Float x;
    private Double y;

    /**
     * Constructs a new Coordinates object with the given x and y values.
     *
     * @param x the x value of the coordinate
     * @param y the y value of the coordinate
     */
    public Coordinates(Float x, Double y) {
        if (x <= -97 || y <= -480) throw new IllegalArgumentException("Invalid coordinates");
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a new Coordinates object with random x and y values.
     */
    public Coordinates() {
        this.x = (float) (Math.random() * 1000 - 521);
        this.y = (Double) (Math.random() * 256);
    }

    /**
     * Returns the x value of the coordinate.
     *
     * @return the x value of the coordinate
     */
    public Float getX() {
        return x;
    }

    /**
     * Sets the x value of the coordinate.
     *
     * @param x the new x value of the coordinate
     */
    public void setX(Float x) {
        this.x = x;
    }

    /**
     * Returns the y value of the coordinate.
     *
     * @return the y value of the coordinate
     */
    public Double getY() {
        return y;
    }

    /**
     * Sets the y value of the coordinate.
     *
     * @param y the new y value of the coordinate
     */
    public void setY(Double y) {
        this.y = y;
    }

    public boolean equals(Coordinates c) {
        return c.getX().equals(this.x) && c.getY().equals(this.y);
    }

    /**
     * Returns a string representation of the coordinate in the format (x, y).
     *
     * @return a string representation of the coordinate
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
