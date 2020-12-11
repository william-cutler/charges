import charges.setup.controller.SetupFeatures;
import charges.setup.view.ISetupView;
import charges.setup.view.SetupView;

public class Main {
  public static void main(String[] args) {
    new SetupFeatures(new SetupView("Caption"));
  }
}
