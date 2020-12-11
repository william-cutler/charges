package charges.setup.controller;

import charges.setup.model.Component;
import charges.setup.model.PointCharge;
import charges.setup.view.ISetupView;
import charges.util.Vector2D;
import java.util.ArrayList;
import java.util.List;

public class SetupFeatures implements ISetupFeatures {

  List<Component> componentList;
  ISetupView view;

  public SetupFeatures(ISetupView view) {
    this.componentList = new ArrayList<>();
    this.view = view;
    view.setFeatures(this);
  }
  @Override
  public void selectComponentAt(Vector2D position) {

  }

  @Override
  public void removeActiveComponent() {

  }

  @Override
  public void addComponent(Component toAdd) {

  }

  @Override
  public void addCharge(Vector2D position, double charge) {
    System.out.println("Add charge " + charge);
    this.componentList.add(new PointCharge(position, charge));
    this.view.displayComponents(this.componentList);
  }

  @Override
  public void moveActiveComponent(Vector2D newPosition) {

  }

  @Override
  public void setPlayerPosition(Vector2D position) {

  }

  @Override
  public void setPlayerCharge(double value) {

  }

  @Override
  public void setPlayerVelocity(Vector2D velocity) {

  }
}
