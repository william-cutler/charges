package charges.setup.controller;

import charges.setup.model.Component;
import charges.setup.model.IChargeSetup;
import charges.setup.model.PointCharge;
import charges.setup.view.ISetupView;
import charges.util.Posn;
import charges.util.Vector2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SetupFeatures implements ISetupFeatures {

  ISetupView view;
  IChargeSetup model;
  Component selectedComponent;

  public SetupFeatures(ISetupView view, IChargeSetup model) {
    Objects.requireNonNull(view);
    Objects.requireNonNull(model);

    this.view = view;
    this.view.setFeatures(this);

    this.model = model;
    this.model.addStationaryCharge(new Posn(50, 50), 1.0);
    this.model.addStationaryCharge(new Posn(100, 100), -1.0);

    this.refresh();
  }

  @Override
  public void removeActiveComponent() {
    if(this.selectedComponent != null) {
      this.model.deleteComponent(this.selectedComponent);
    }
  }

  @Override
  public void addComponent(Component toAdd) {

  }

  @Override
  public void addCharge(Vector2D position, double charge) {
    System.out.println("Add charge " + charge);
    this.model.addStationaryCharge(position, charge);
    this.refresh();
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

  @Override
  public void registerClick(MouseEvent me) {
    Vector2D clickPos = new Posn(me.getX(), me.getY());
    System.out.println("Mouse clicked at " + clickPos);

    if(me.getButton() == MouseEvent.BUTTON1) {
      if(this.selectedComponent != null) {
        this.model.moveComponentTo(this.selectedComponent, clickPos);
      } else {
        this.selectedComponent = this.model.getStationaryChargeAt(clickPos);
        this.view.selectComponent(this.selectedComponent);
      }
    } else if (me.getButton() == MouseEvent.BUTTON3) {
      this.selectedComponent = null;
      this.view.selectComponent(null);
      System.out.println("Deselect");
    }
    this.refresh();
  }

  private void refresh() {
    this.view.displayComponents(this.model.getComponents());
  }
}
