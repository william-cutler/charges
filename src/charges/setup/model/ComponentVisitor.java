package charges.setup.model;

public interface ComponentVisitor<T> {
  T apply(Component c);

  T visitCharge(ICharge c);

  T visitPlayer(IPlayer p);
}
