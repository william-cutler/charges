package charges.setup.model;

import charges.util.Vector2D;

public interface Component {
  Vector2D getPosition();

  void setPosition(Vector2D position);

  <T> T accept(ComponentVisitor<T> v);
}
