package unq_ui.interfaz_gatoEncerrado_2016;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import unq_ciu.gatoEncerrado.AppModel.AgregarAccionDeIrAOtraHabitacionAppModel;
import unq_ciu.gatoEncerrado.Habitacion;

@SuppressWarnings("all")
public class WindowAgregarAccionDeIrAOtraHabitacion extends Dialog<AgregarAccionDeIrAOtraHabitacionAppModel> {
  public WindowAgregarAccionDeIrAOtraHabitacion(final WindowOwner owner, final Habitacion hab) {
    super(owner, new AgregarAccionDeIrAOtraHabitacionAppModel(hab));
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Agregar acción de ir a otra habitación");
    this.setMinHeight(200);
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    mainPanel.setWidth(30000);
    Label _label = new Label(mainPanel);
    _label.setText("Selecciona una habitación");
    Selector<Habitacion> _selector = new Selector<Habitacion>(mainPanel);
    final Procedure1<Selector<Habitacion>> _function = new Procedure1<Selector<Habitacion>>() {
      public void apply(final Selector<Habitacion> it) {
        it.allowNull(false);
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        _value.<Object>bindToProperty("habitacionSeleccionada");
        final Binding<?, Selector<Habitacion>, ListBuilder<Habitacion>> listaHabitaciones = it.bindItemsToProperty("laberinto.habitaciones");
        listaHabitaciones.adaptWith(Habitacion.class, "nombre");
      }
    };
    ObjectExtensions.<Selector<Habitacion>>operator_doubleArrow(_selector, _function);
    final Panel accionesPanel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    accionesPanel.setLayout(_horizontalLayout);
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Cancelar");
        final Action _function = new Action() {
          public void execute() {
            WindowAgregarAccionDeIrAOtraHabitacion.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
    Button _button_1 = new Button(mainPanel);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Agregar");
        final Action _function = new Action() {
          public void execute() {
            AgregarAccionDeIrAOtraHabitacionAppModel _modelObject = WindowAgregarAccionDeIrAOtraHabitacion.this.getModelObject();
            _modelObject.agregarAccion();
            WindowAgregarAccionDeIrAOtraHabitacion.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_2);
  }
}
