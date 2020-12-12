package charges.setup.model;

import charges.util.Vector2D;

public class PointCharge implements ICharge {
  private double charge;
  private Vector2D position;

  public PointCharge(Vector2D position, double charge) {
    this.charge = charge;
    this.position = position;
  }

  @Override
  public Vector2D getPosition() {
    return this.position;
  }

  @Override
  public void setPosition(Vector2D position) {
    this.position = position;
  }

  @Override
  public <T> T accept(ComponentVisitor<T> v) {
    return v.visitCharge(this);
  }

  @Override
  public double getNetCharge() {
    return this.charge;
  }

  @Override
  public void setCharge(double charge) {
    this.charge = charge;
  }
}
