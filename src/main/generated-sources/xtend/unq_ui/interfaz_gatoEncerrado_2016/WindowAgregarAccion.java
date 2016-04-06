package unq_ui.interfaz_gatoEncerrado_2016;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import unq_ciu.gatoEncerrado.AppModel.AgregarAccionAppModel;
import unq_ciu.gatoEncerrado.Habitacion;
import unq_ui.interfaz_gatoEncerrado_2016.WindowAgregarAccionDeAgarrarElemento;
import unq_ui.interfaz_gatoEncerrado_2016.WindowsAgregarAccionDeIrAOtraHabitacion;

@SuppressWarnings("all")
public class WindowAgregarAccion extends SimpleWindow<AgregarAccionAppModel> {
  public WindowAgregarAccion(final WindowOwner parent, final AgregarAccionAppModel model) {
    super(parent, model);
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Agregar acciones a la habitacion");
    this.setMinHeight(200);
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    mainPanel.setWidth(3000);
    Label _label = new Label(mainPanel);
    _label.setText("Selecciona una acción a agregar");
    final Panel accionesPanel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    accionesPanel.setLayout(_horizontalLayout);
    Button _button = new Button(accionesPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Ir a otra habitación");
        it.setHeight(30);
        it.setWidth(150);
        final Action _function = new Action() {
          public void execute() {
            AgregarAccionAppModel _modelObject = WindowAgregarAccion.this.getModelObject();
            Habitacion _habitacionActual = _modelObject.getHabitacionActual();
            WindowsAgregarAccionDeIrAOtraHabitacion _windowsAgregarAccionDeIrAOtraHabitacion = new WindowsAgregarAccionDeIrAOtraHabitacion(WindowAgregarAccion.this, _habitacionActual);
            _windowsAgregarAccionDeIrAOtraHabitacion.open();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(accionesPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Agarrar un elemento");
        it.setHeight(30);
        it.setWidth(150);
        final Action _function = new Action() {
          public void execute() {
            AgregarAccionAppModel _modelObject = WindowAgregarAccion.this.getModelObject();
            Habitacion _habitacionActual = _modelObject.getHabitacionActual();
            WindowAgregarAccionDeAgarrarElemento _windowAgregarAccionDeAgarrarElemento = new WindowAgregarAccionDeAgarrarElemento(WindowAgregarAccion.this, _habitacionActual);
            _windowAgregarAccionDeAgarrarElemento.open();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
    Button _button_2 = new Button(accionesPanel);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Usar un elemento");
        it.setHeight(30);
        it.setWidth(150);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_2);
    Button _button_3 = new Button(mainPanel);
    final Procedure1<Button> _function_3 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Cancelar");
        final Action _function = new Action() {
          public void execute() {
            WindowAgregarAccion.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_3, _function_3);
  }
}