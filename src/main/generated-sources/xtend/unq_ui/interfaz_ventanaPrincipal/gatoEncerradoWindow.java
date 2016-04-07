package unq_ui.interfaz_ventanaPrincipal;

import java.util.List;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import unq_ciu.gatoEncerrado.AppModel.gatoEncerradoAppModel;
import unq_ciu.gatoEncerrado.Laberinto;

@SuppressWarnings("all")
public class gatoEncerradoWindow extends SimpleWindow<gatoEncerradoAppModel> {
  public gatoEncerradoWindow(final WindowOwner parent, final gatoEncerradoAppModel model) {
    super(parent, model);
  }
  
  protected void addActions(final Panel actionsPanel) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    this.setTitle("Acá hay gato encerrado...");
    Label _label = new Label(mainPanel);
    _label.setText("Acá hay gato encerrado...");
    this.crearListadoDeLaberintos(mainPanel);
    this.crearEdicionDeLaberintoSeleccionado(mainPanel);
  }
  
  public List<Laberinto> crearListadoDeLaberintos(final Panel owner) {
    throw new Error("Unresolved compilation problems:"
      + "\nCannot instantiate the interface type List");
  }
  
  public Object crearEdicionDeLaberintoSeleccionado(final Panel panel) {
    return null;
  }
}
