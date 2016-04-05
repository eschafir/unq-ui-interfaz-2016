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
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import unq_ciu.gatoEncerrado.Habitacion;
import unq_ciu.gatoEncerrado.Juego;

@SuppressWarnings("all")
public class WindowsQuitarAccionDeIrAOtraHabitacion extends MainWindow<Juego> {
  public WindowsQuitarAccionDeIrAOtraHabitacion() {
    super(new Juego());
  }
  
  public void createContents(final Panel mainPanel) {
    this.setTitle("Quitar acción de ir a otra habitación");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    Label _label = new Label(mainPanel);
    _label.setText("Selecciona una habitación");
    Selector<Habitacion> _selector = new Selector<Habitacion>(mainPanel);
    final Procedure1<Selector<Habitacion>> _function = new Procedure1<Selector<Habitacion>>() {
      public void apply(final Selector<Habitacion> it) {
        it.allowNull(false);
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        _value.<Object>bindToProperty("habitacionSeleccionada");
        final Binding<?, Selector<Habitacion>, ListBuilder<Habitacion>> propiedadModelos = it.bindItemsToProperty("laberinto.habitaciones");
        propiedadModelos.adaptWith(Habitacion.class, "nombre");
      }
    };
    ObjectExtensions.<Selector<Habitacion>>operator_doubleArrow(_selector, _function);
    final Panel accionesPanel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    accionesPanel.setLayout(_horizontalLayout);
    final Button cancelar = new Button(accionesPanel);
    cancelar.setCaption("Cancelar");
    final Button quitar = new Button(accionesPanel);
    quitar.setCaption("Quitar");
    quitar.onClick(null);
  }
  
  public static void main(final String[] args) {
    WindowsQuitarAccionDeIrAOtraHabitacion _windowsQuitarAccionDeIrAOtraHabitacion = new WindowsQuitarAccionDeIrAOtraHabitacion();
    _windowsQuitarAccionDeIrAOtraHabitacion.startApplication();
  }
}
