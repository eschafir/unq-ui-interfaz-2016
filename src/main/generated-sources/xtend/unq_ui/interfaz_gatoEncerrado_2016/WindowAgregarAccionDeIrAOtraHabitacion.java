package unq_ui.interfaz_gatoEncerrado_2016;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableItems;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
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
import unq_ciu.gatoEncerrado.Laberinto;

@SuppressWarnings("all")
public class WindowAgregarAccionDeIrAOtraHabitacion extends Dialog<AgregarAccionDeIrAOtraHabitacionAppModel> {
  public WindowAgregarAccionDeIrAOtraHabitacion(final WindowOwner owner, final Laberinto lab, final Habitacion hab) {
    super(owner, new AgregarAccionDeIrAOtraHabitacionAppModel(lab, hab));
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Ir a otra habitación");
    this.setMinHeight(300);
    Label _label = new Label(mainPanel);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        AgregarAccionDeIrAOtraHabitacionAppModel _modelObject = WindowAgregarAccionDeIrAOtraHabitacion.this.getModelObject();
        Habitacion _habitacion = _modelObject.getHabitacion();
        String _nombre = _habitacion.getNombre();
        String _plus = (_nombre + " -> ir hacia:");
        it.setText(_plus);
        it.setWidth(300);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    Selector<Habitacion> _selector = new Selector<Habitacion>(mainPanel);
    final Procedure1<Selector<Habitacion>> _function_1 = new Procedure1<Selector<Habitacion>>() {
      public void apply(final Selector<Habitacion> it) {
        it.allowNull(false);
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        _value.<Object>bindToProperty("habitacionSeleccionada");
        ObservableItems<Selector<Habitacion>, Habitacion, ListBuilder<Habitacion>> _items = it.items();
        Binding<Object, Selector<Habitacion>, ListBuilder<Habitacion>> _bindToProperty = _items.<Object>bindToProperty("laberinto.habitaciones");
        PropertyAdapter _propertyAdapter = new PropertyAdapter(Habitacion.class, "nombre");
        _bindToProperty.setAdapter(_propertyAdapter);
      }
    };
    ObjectExtensions.<Selector<Habitacion>>operator_doubleArrow(_selector, _function_1);
    final Panel accionesPanel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    accionesPanel.setLayout(_horizontalLayout);
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
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
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_2);
    Button _button_1 = new Button(mainPanel);
    final Procedure1<Button> _function_3 = new Procedure1<Button>() {
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
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_3);
  }
}
