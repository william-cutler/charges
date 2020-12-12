package charges.util;

import java.util.Objects;

/** Represents an integral cartesian position coordinate. */
public class Posn implements Vector2D {
  private final double x;
  private final double y;

  public Posn() {
    this(0, 0);
  }

  /**
   * Directly initializes fields as given.
   *
   * @param x the x position.
   * @param y the y position.
   */
  public Posn(double x, double y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public double getX() {
    return this.x;
  }

  @Override
  public double getY() {
    return this.y;
  }

  @Override
  public boolean lessThan(Vector2D other) {
    return this.x < other.getX() && this.y < other.getY();
  }

  @Override
  public double distanceTo(Vector2D other) {
      return Math.sqrt(Math.pow(other.getX() - this.x, 2) + Math.pow(other.getY() - this.y, 2));
  }

  @Override
  public Vector2D displacementTo(Vector2D other) {
    return new Posn(other.getX() - this.getX(), other.getY() - this.getY());
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Posn) {
      Posn pos = (Posn) obj;
      return Math.abs(pos.getX() - this.getX()) < .01 && Math.abs(pos.getY() - this.getY()) < .01;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.x, this.y);
  }

  @Override
  public String toString() {
    return String.format("(%s, %s)", this.x, this.y);
  }
}
