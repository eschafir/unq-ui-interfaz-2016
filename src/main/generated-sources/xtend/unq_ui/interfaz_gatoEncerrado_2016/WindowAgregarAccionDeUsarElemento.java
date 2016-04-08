package unq_ui.interfaz_gatoEncerrado_2016;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import unq_ciu.gatoEncerrado.AppModel.AgregarAccionDeUsarElementoAppModel;
import unq_ciu.gatoEncerrado.Habitacion;
import unq_ciu.gatoEncerrado.Laberinto;
import unq_ui.interfaz_gatoEncerrado_2016.WindowAgregarAccion;

@SuppressWarnings("all")
public class WindowAgregarAccionDeUsarElemento extends Dialog<AgregarAccionDeUsarElementoAppModel> {
  public WindowAgregarAccionDeUsarElemento(final WindowOwner owner, final Laberinto lab, final Habitacion hab) {
    super(owner, new AgregarAccionDeUsarElementoAppModel(lab, hab));
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Agregar acción de Usar un elemento");
    Label _label = new Label(mainPanel);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Seleccione el elemento que puede ser usado");
        it.setHeight(30);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    Selector<Object> _selector = new Selector<Object>(mainPanel);
    final Procedure1<Selector<Object>> _function_1 = new Procedure1<Selector<Object>>() {
      public void apply(final Selector<Object> it) {
        it.allowNull(false);
      }
    };
    ObjectExtensions.<Selector<Object>>operator_doubleArrow(_selector, _function_1);
    Label _label_1 = new Label(mainPanel);
    _label_1.setText("Cree la acción a realizar");
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Agregar acción");
        it.setHeight(30);
        it.setWidth(40);
        final Action _function = new Action() {
          public void execute() {
            AgregarAccionDeUsarElementoAppModel _modelObject = WindowAgregarAccionDeUsarElemento.this.getModelObject();
            Laberinto _laberinto = _modelObject.getLaberinto();
            AgregarAccionDeUsarElementoAppModel _modelObject_1 = WindowAgregarAccionDeUsarElemento.this.getModelObject();
            Habitacion _habitacion = _modelObject_1.getHabitacion();
            WindowAgregarAccion _windowAgregarAccion = new WindowAgregarAccion(WindowAgregarAccionDeUsarElemento.this, _laberinto, _habitacion);
            _windowAgregarAccion.open();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_2);
    final Panel accionPanel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    accionPanel.setLayout(_horizontalLayout);
    Button _button_1 = new Button(accionPanel);
    final Procedure1<Button> _function_3 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Cancelar");
        it.setHeight(30);
        it.setWidth(150);
        final Action _function = new Action() {
          public void execute() {
            WindowAgregarAccionDeUsarElemento.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_3);
    Button _button_2 = new Button(accionPanel);
    final Procedure1<Button> _function_4 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Agregar");
        it.setHeight(30);
        it.setWidth(150);
        final Action _function = new Action() {
          public void execute() {
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_4);
  }
}
