package charges.util;

/** A width and height dimension represented by positive values for x and y respectively. */
public class Dimension extends Posn {
  /*
  INVARIANT: x and y coordinates are always positive.
   */

  /**
   * Initializes this dimension with the given values.
   *
   * @param x the width of the dimension.
   * @param y the height of the dimension.
   * @throws IllegalArgumentException if either quantity is not positive.
   */
  public Dimension(int x, int y) {
    super(x, y);
    if (x <= 0 || y <= 0) {
      throw new IllegalArgumentException("Dimensions must be positive.");
    }
  }
}
