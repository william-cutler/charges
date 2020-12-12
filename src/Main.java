import charges.setup.controller.SetupFeatures;
import charges.setup.model.ChargeSetup;
import charges.setup.view.SetupView;

public class Main {
  public static void main(String[] args) {
    new SetupFeatures(new SetupView("Charge Simulator"), new ChargeSetup(500, 500, 20));
  }
}
