package charges.setup.model;

import charges.util.Vector2D;

public interface IPlayer extends ICharge {
  Vector2D getVelocity();

  void setVelocity(Vector2D velocity);
}
