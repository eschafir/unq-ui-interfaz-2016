package unq_ui.interfaz_gatoEncerrado_2016.Consecuencias;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import unq_ciu.gatoEncerrado.Accion;
import unq_ciu.gatoEncerrado.Consecuencias.AgregarAccionDeUsarUnElementoConsecuenciaAppModel;
import unq_ciu.gatoEncerrado.Habitacion;
import unq_ciu.gatoEncerrado.Item;
import unq_ciu.gatoEncerrado.Laberinto;

@SuppressWarnings("all")
public class WindowAgregarAccionDeUsarUnElementoConsecuencia extends Dialog<AgregarAccionDeUsarUnElementoConsecuenciaAppModel> {
  public WindowAgregarAccionDeUsarUnElementoConsecuencia(final WindowOwner owner, final Laberinto lab, final Habitacion hab, final Item item, final Accion acc) {
    super(owner, new AgregarAccionDeUsarUnElementoConsecuenciaAppModel(hab, item, acc));
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Usar un elemento");
    Label _label = new Label(mainPanel);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Seleccione el elemento que puede ser usado");
        it.setHeight(30);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Definir acción consecuencia");
        it.setHeight(30);
        it.setWidth(40);
        final Action _function = new Action() {
          public void execute() {
            AgregarAccionDeUsarUnElementoConsecuenciaAppModel _modelObject = WindowAgregarAccionDeUsarUnElementoConsecuencia.this.getModelObject();
            _modelObject.agregarAccionUsar();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
    final Panel accionPanel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    accionPanel.setLayout(_horizontalLayout);
    Button _button_1 = new Button(accionPanel);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        it.setHeight(30);
        it.setWidth(150);
        final Action _function = new Action() {
          public void execute() {
            WindowAgregarAccionDeUsarUnElementoConsecuencia.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_2);
  }
}
