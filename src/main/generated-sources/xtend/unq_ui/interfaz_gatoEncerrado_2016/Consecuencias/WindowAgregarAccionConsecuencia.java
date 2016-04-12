package unq_ui.interfaz_gatoEncerrado_2016.Consecuencias;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import unq_ciu.gatoEncerrado.Consecuencias.AgregarAccionConsecuenciaAppModel;
import unq_ciu.gatoEncerrado.Habitacion;
import unq_ciu.gatoEncerrado.Item;
import unq_ciu.gatoEncerrado.Laberinto;

@SuppressWarnings("all")
public class WindowAgregarAccionConsecuencia extends SimpleWindow<AgregarAccionConsecuenciaAppModel> {
  public WindowAgregarAccionConsecuencia(final WindowOwner parent, final Laberinto lab, final Habitacion hab, final Item item) {
    super(parent, new AgregarAccionConsecuenciaAppModel(lab, hab, item));
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    throw new Error("Unresolved compilation problems:"
      + "\nWindowAgregarAccionDeAgarrarElementoConsecuencia cannot be resolved."
      + "\nWindowAgregarAccionDeUsarElementoConsecuencia cannot be resolved."
      + "\nopen cannot be resolved"
      + "\nopen cannot be resolved");
  }
}
