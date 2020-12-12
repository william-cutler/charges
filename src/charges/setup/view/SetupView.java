package charges.setup.view;

import charges.setup.controller.ISetupFeatures;
import charges.setup.model.Component;
import charges.setup.model.PointCharge;
import charges.simulation.controller.Features;
import charges.util.Posn;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SetupView extends JFrame implements ISetupView {

  private ISetupFeatures features;

  private final ChargeDisplayPanel chargeDisplayPanel;
  private final JButton addChargeButton;
  private final JButton deleteSelectedChargeButton;
  private final JButton simulateButton;
  private JRadioButton createPositive;
  private JRadioButton createNegative;
  private ButtonGroup chargeTypeGroup;

  public SetupView(String caption) {
    this.setLayout(new BorderLayout());
    this.chargeDisplayPanel = new ChargeDisplayPanel();

    JPanel buttonPanel = new JPanel();

    createNegative = new JRadioButton("Negative", true);
    createPositive = new JRadioButton("Positive");
    chargeTypeGroup = new ButtonGroup();
    chargeTypeGroup.add(createNegative);
    chargeTypeGroup.add(createPositive);
    buttonPanel.add(createNegative);
    buttonPanel.add(createPositive);

    this.addChargeButton = new JButton("Add");
    this.deleteSelectedChargeButton = new JButton("Delete");
    this.simulateButton = new JButton("Simulate");
    buttonPanel.add(this.addChargeButton);
    buttonPanel.add(this.deleteSelectedChargeButton);
    buttonPanel.add(this.simulateButton);
    buttonPanel.setVisible(true);

    this.add(chargeDisplayPanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.PAGE_END);
    this.setSize(new Dimension(1000, 1000));
    this.setTitle(caption);
    this.setVisible(true);
    this.pack();
  }

  @Override
  public void setFeatures(ISetupFeatures features) {
    this.features = features;

    this.addChargeButton.addActionListener((evt) -> this.addCharge());
    this.deleteSelectedChargeButton.addActionListener(
        (evt) -> this.features.removeActiveComponent());
    this.simulateButton.addActionListener((evt) -> System.out.println("Begin simulation."));
    this.chargeDisplayPanel.setFeatures(features);
  }

  @Override
  public void displayComponents(List<? extends Component> components) {
    this.chargeDisplayPanel.setComponents(components);
    this.chargeDisplayPanel.repaint();
  }

  @Override
  public void selectComponent(Component c) {
    this.chargeDisplayPanel.setActive(c);
    this.chargeDisplayPanel.repaint();
  }

  private void addCharge() {
    int charge;
    if (this.createPositive.isSelected()) {
      charge = 1;
    } else if (this.createNegative.isSelected()) {
      charge = -1;
    } else {
      throw new IllegalStateException("Bad radio button state for charge creation.");
    }
    this.features.addCharge(new Posn(0, 0), charge);
  }
}
