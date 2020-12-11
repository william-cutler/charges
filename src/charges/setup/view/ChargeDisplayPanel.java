package charges.setup.view;

import charges.setup.model.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class ChargeDisplayPanel extends JPanel {
  private List<Component> components;

  public ChargeDisplayPanel() {
    super();
    this.setPreferredSize(new Dimension(500, 500));
    this.setVisible(true);
    this.components = new ArrayList<>();
  }

  public void setComponents(List<Component> components) {
    this.components = components;
  }

  /** Renders each shape at the current tick. */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D canvas = (Graphics2D) g;
    for(Component c : this.components) {

      canvas.fillOval(250, 250, 50, 50);
    }
  }


}
