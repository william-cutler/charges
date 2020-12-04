package charges.simulation.model;

import java.util.List;

/**
 * Contains information about the positions and velocities of simulated charges to simulate the
 * dynamics of a system of charged particles. Calculates electrostatic interactions to produce the
 * next state of the system.
 */
public interface IChargeSimulation {

  boolean simulationOver();

  void advance();

  List<Component> getComponents();


}
