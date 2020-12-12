package charges.setup.view;

import charges.setup.controller.ISetupFeatures;
import charges.setup.model.Component;
import charges.setup.model.ComponentVisitor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

class ChargeDisplayPanel extends JPanel {
  private List<? extends Component> components;
  private Component selectedComponent;

  ChargeDisplayPanel() {
    super();
    this.setPreferredSize(new Dimension(500, 500));
    this.setVisible(true);
    this.components = new ArrayList<>();
    this.selectedComponent = null;
  }

  void setComponents(List<? extends Component> components) {
    this.components = components;
  }

  void setActive(Component c) {
    this.selectedComponent = c;
  }

  void setFeatures(ISetupFeatures f) {
    this.addMouseListener(new OnClick(f));
  }

  /** Renders each shape at the current tick. */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D canvas = (Graphics2D) g;
    ComponentVisitor<Void> renderer = new CanvasComponentRender(canvas, selectedComponent);
    for(Component c : this.components) {
      c.accept(renderer);
    }
  }


  private static class OnClick implements MouseListener {

    private ISetupFeatures f;

    OnClick(ISetupFeatures f) {
      this.f = f;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      this.f.registerClick(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
  }
}
