package charges.setup.model;

import charges.simulation.model.Component;
import charges.simulation.model.IChargeSimulation;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

/**
 * An editable container for all of the components in a given simulation. Components can be added,
 * deleted, moved, etc, and finally a runnable simulation can be built once creation is finished.
 */
public interface IChargeSetup {

  Dimension2D getBounds();

  void addComponent(Component component, Point2D position);

  void deleteComponent(Component component);

  void moveComponent(Component component, Point2D newPosition);

  Component getComponentAt(Point2D position);

  IChargeSimulation buildSimulation();

  void setPlayerPosition(Point2D position);

  void setPlayerCharge(double value);

  void setPlayerVelocity(Point2D velocity);

  Point2D getPlayerPosition();
}
