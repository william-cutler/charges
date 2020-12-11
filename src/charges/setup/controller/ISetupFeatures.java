package charges.setup.controller;

import charges.setup.model.Component;
import charges.util.Posn;
import charges.util.Vector2D;
import java.awt.geom.Point2D;

public interface ISetupFeatures {

  void selectComponentAt(Vector2D position);

  void removeActiveComponent();

  void addComponent(Component toAdd);

  void addCharge(Vector2D position, double charge);

  void moveActiveComponent(Vector2D newPosition);

  void setPlayerPosition(Vector2D position);

  void setPlayerCharge(double value);

  void setPlayerVelocity(Vector2D velocity);
}
