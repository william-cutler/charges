package charges.setup.model;

import charges.util.Posn;
import charges.util.Vector2D;
import charges.simulation.model.IChargeSimulation;
import java.util.List;

/**
 * An editable container for all of the components in a given simulation. Components can be added,
 * deleted, moved, etc, and finally a runnable simulation can be built once creation is finished.
 */
public interface IChargeSetup {

  Vector2D getBounds();

  void addStationaryCharge(Vector2D position, double charge);

  void deleteComponent(Component c);

  void moveComponentTo(Component c, Vector2D newPosition);

  ICharge getStationaryChargeAt(Vector2D position);

  IChargeSimulation buildSimulation();

  void setPlayerPosition(Posn position);

  void setPlayerCharge(double value);

  void setPlayerVelocity(Posn velocity);

  IPlayer getPlayer();

  List<ICharge> getComponents();
}
