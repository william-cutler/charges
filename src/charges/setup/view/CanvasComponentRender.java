package charges.setup.view;

import charges.setup.model.Component;
import charges.setup.model.ComponentVisitor;
import charges.setup.model.ICharge;
import charges.setup.model.IPlayer;
import charges.util.Vector2D;
import java.awt.Color;
import java.awt.Graphics2D;

public class CanvasComponentRender implements ComponentVisitor<Void> {

  private final Graphics2D graphics;
  private final Component selected;

  private static final Color SELECTION_COLOR = new Color(220, 120, 0);
  private static final int CHARGE_RADIUS = 10;

  public CanvasComponentRender(Graphics2D graphics, Component selected) {
    this.graphics = graphics;
    this.selected = selected;
  }

  @Override
  public Void apply(Component c) {
    return c.accept(this);
  }

  @Override
  public Void visitCharge(ICharge c) {
    // Draw selection aura
    this.graphics.setColor(SELECTION_COLOR);
    if(c.equals(this.selected)) {
      this.graphics.fillOval((int) c.getPosition().getX() - 3, (int) c.getPosition().getY() - 3, CHARGE_RADIUS * 2 + 6, CHARGE_RADIUS * 2 + 6);
    }

    // Render actual charge
    Color color;
    if(c.getNetCharge() == -1) {
      color = Color.blue;
    } else if(c.getNetCharge() == 1) {
      color = Color.RED;
    } else {
      color = Color.BLACK;
    }
    this.drawChargeWithColor(color, c.getPosition());
    return null;
  }

  @Override
  public Void visitPlayer(IPlayer p) {
    this.drawChargeWithColor(Color.GREEN, p.getPosition());
    return null;
  }

  private void drawChargeWithColor(Color color, Vector2D pos) {
    this.graphics.setColor(color);
    this.graphics.fillOval((int) pos.getX(), (int) pos.getY(), CHARGE_RADIUS * 2, CHARGE_RADIUS * 2);
  }
}
