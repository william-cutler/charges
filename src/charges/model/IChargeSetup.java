package charges.model;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

/**
 * An editable container for all of the components in a given simulation. Components can be added,
 * deleted, moved, etc, and finally a runnable simulation can be built once creation is finished.
 */
public interface IChargeSetup<T> {

  Dimension2D getBounds();

  void addComponent(T component, Point2D position);

  void deleteComponent(T component);
  void moveComponent(T component, Point2D newPosition);

  IChargeSimulation<T> buildSimulation();

  void setPlayerPosition(Point2D position);

  void setPlayerCharge(double value);

  void setPlayerVelocity(Point2D velocity);

  Point2D getPlayerPosition();
}
