package charges.setup.view;

import charges.setup.controller.ISetupFeatures;
import charges.setup.model.Component;
import java.util.List;

public interface ISetupView {

  void setFeatures(ISetupFeatures features);

  void displayComponents(List<Component> components);

  void selectComponent(Component c);

}
