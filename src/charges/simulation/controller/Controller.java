package charges.simulation.controller;

import charges.setup.controller.SetupFeatures;
import charges.setup.model.IChargeSetup;
import charges.setup.controller.ISetupFeatures;
import charges.setup.view.ISetupView;

public abstract class Controller implements IChargeController {
  private ISetupView setupView;
  private IChargeSetup setupModel;
  private ISetupFeatures setupFeatures;
  private ISimulationFeatures simFeatures;

  public Controller(ISetupView setupView, IChargeSetup setupModel) {
    this.setupView = setupView;
    this.setupModel = setupModel;
    this.setupFeatures = new SetupFeatures(setupView, setupModel);
    this.simFeatures = new SimulationFeatures();

    this.setupView.setFeatures(this.setupFeatures);
  }

  @Override
  public void begin() {}
}
