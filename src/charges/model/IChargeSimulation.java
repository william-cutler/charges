package charges.model;

import java.awt.geom.Point2D;
import java.util.List;

/**
 * Contains information about the positions and velocities of simulated charges to simulate the
 * dynamics of a system of charged particles. Calculates electrostatic interactions to produce the
 * next state of the system.
 */
public interface IChargeSimulation<T> {

  boolean simulationOver();

  void advance();

  List<T> getComponents();

  Point2D getPlayerPosition();
}
