package charges.util;

/** A vector that can be represented by integral cartesian coordinates. */
public interface Vector2D {

  /**
   * Returns the x component of the vector.
   *
   * @return the x component as a int
   */
  double getX();

  /**
   * Returns the y component of the vector.
   *
   * @return the y component as a int
   */
  double getY();

  boolean lessThan(Vector2D other);

  double distanceTo(Vector2D other);

  Vector2D displacementTo(Vector2D other);
}
