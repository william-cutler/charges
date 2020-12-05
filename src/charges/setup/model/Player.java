package charges.setup.model;

import charges.Vector2D;

public class Player extends PointCharge implements IPlayer {
  private Vector2D velocity;

  public Player(Vector2D position, double charge, Vector2D velocity) {
    super(charge, position);
    this.velocity = velocity;
  }

  @Override
  public Vector2D getVelocity() {
    return this.velocity;
  }

  @Override
  public void setVelocity(Vector2D velocity) {
    this.velocity = velocity;
  }
}
