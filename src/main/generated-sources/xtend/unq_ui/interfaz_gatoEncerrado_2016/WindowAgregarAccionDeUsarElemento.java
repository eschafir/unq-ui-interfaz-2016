package unq_ui.interfaz_gatoEncerrado_2016;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import unq_ciu.gatoEncerrado.AppModel.AgregarAccionDeUsarElementoAppModel;
import unq_ciu.gatoEncerrado.Habitacion;
import unq_ciu.gatoEncerrado.Laberinto;

@SuppressWarnings("all")
public class WindowAgregarAccionDeUsarElemento extends Dialog<AgregarAccionDeUsarElementoAppModel> {
  public WindowAgregarAccionDeUsarElemento(final WindowOwner owner, final Laberinto lab, final Habitacion hab) {
    super(owner, new AgregarAccionDeUsarElementoAppModel(lab, hab));
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    throw new Error("Unresolved compilation problems:"
      + "\nmissing \']\' at \'}\'"
      + "\nThe method itemSeleccinado is undefined for the type WindowAgregarAccionDeUsarElemento"
      + "\nInvalid number of arguments. The constructor WindowAgregarAccionConsecuencia(WindowOwner, AgregarAccionDeUsarElementoAppModel) is not applicable for the arguments (WindowAgregarAccionDeUsarElemento,Laberinto,Habitacion,Object)"
      + "\nType mismatch: cannot convert from Laberinto to AgregarAccionDeUsarElementoAppModel");
  }
}
