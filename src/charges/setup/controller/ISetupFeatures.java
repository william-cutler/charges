package charges.setup.controller;

import charges.simulation.model.Component;
import java.awt.geom.Point2D;

public interface ISetupFeatures {

  void selectComponentAt(Point2D position);

  void removeActiveComponent();

  void addComponent(Component toAdd, Point2D position);

  void moveActiveComponent(Point2D newPosition);

  void setPlayerPosition(Point2D position);

  void setPlayerCharge(double value);

  void setPlayerVelocity(Point2D velocity);
}
