package charges.setup.model;

import charges.util.Dimension;
import charges.util.ListUtil;
import charges.util.Posn;
import charges.util.Vector2D;
import charges.simulation.model.IChargeSimulation;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ChargeSetup implements IChargeSetup {
  private final Vector2D dimensions;
  private final double selectionTolerance;

  private final IPlayer player;
  private final List<ICharge> environment;

  public ChargeSetup(int windowWidth, int windowHeight, double selectionTolerance) {
    this.dimensions = new Dimension(windowWidth, windowHeight);
    this.selectionTolerance = selectionTolerance;
    this.player = new Player(new Posn(), 0, new Posn());
    this.environment = new ArrayList<>();
  }

  @Override
  public Vector2D getBounds() {
    return this.dimensions;
  }

  @Override
  public void addStationaryCharge(Vector2D position, double charge) {
    this.verifyPosition(position);
    this.environment.add(new PointCharge(position, charge));
  }

  @Override
  public void deleteComponent(Component c) {
    this.environment.remove(c);
  }

  @Override
  public void moveComponentTo(Component c, Vector2D newPosition) {
    this.verifyPosition(newPosition);
    c.setPosition(newPosition);
  }

  @Override
  public ICharge getStationaryChargeAt(Vector2D selectedPosition) {
    int indexOfCharge = this.chargeIndexAtPosition(selectedPosition);
    if(indexOfCharge == -1) {
      return null;
    }
    return this.environment.get(indexOfCharge);
  }

  @Override
  public IChargeSimulation buildSimulation() {
    return null;
  }

  @Override
  public void setPlayerPosition(Posn position) {
    this.verifyPosition(position);
    this.player.setPosition(position);
  }

  @Override
  public void setPlayerCharge(double value) {
    this.player.setCharge(value);
  }

  @Override
  public void setPlayerVelocity(Posn velocity) {
    this.player.setVelocity(velocity);
  }

  @Override
  public IPlayer getPlayer() {
    return new Player(this.player.getPosition(), this.player.getNetCharge(), this.player.getVelocity());
  }

  @Override
  public List<ICharge> getComponents() {
    return new ArrayList<>(this.environment);
  }

  /**
   * Ensure position is within bounds of (0, 0) and this model's dimensions.
   * @param pos the position in question.
   * @throws IllegalArgumentException if the position is not within the proper bounds.
   */
  private void verifyPosition(Vector2D pos) throws IllegalArgumentException {
    if(! new Posn(-1, -1).lessThan(pos) && pos.lessThan(this.dimensions)) {
      throw new IllegalArgumentException("Position: " + pos + " is out of bounds.");
    }
  }

  /**
   * Retrieves index of the first charge selected by the given position.
   * @param pos the position in question.
   * @throws IllegalArgumentException if the position does not correspond to a charge in the environment.
   */
  private int chargeIndexAtPosition(Vector2D pos) throws IllegalArgumentException {
//    int indexOfCharge = ListUtil.indexSatisfying(this.environment, new PositionWithinTolerance(pos));
//    if(indexOfCharge < 0) {
//      return null;
//      throw new IllegalArgumentException("No charge at position.");
//    } else {
//      return indexOfCharge;
//    }
    return ListUtil.indexSatisfying(this.environment, new PositionWithinTolerance(pos));
  }

  /**
   * A predicate function object that determines if the position is within the selection tolerance of
   * the charge's position that this predicate is tested on.
   */
  private class PositionWithinTolerance implements Predicate<ICharge> {
    private final Vector2D position;

    PositionWithinTolerance(Vector2D position) {
      this.position = position;
    }

    @Override
    public boolean test(ICharge charge) {
      Vector2D chargePosition = charge.getPosition();
      return inclusiveBetween(chargePosition.getX(), position.getX(), chargePosition.getX() + selectionTolerance)
          && inclusiveBetween(chargePosition.getY(), position.getY(), chargePosition.getY() + selectionTolerance);
    }

    private boolean inclusiveBetween(double low, double med, double high) {
      return (low <= med && med <= high);
    }
  }
}
