package unq_ui.interfaz_gatoEncerrado_2016.Consecuencias;

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
import unq_ciu.gatoEncerrado.Accion;
import unq_ciu.gatoEncerrado.Consecuencias.AgregarAccionDeUsarUnElementoConsecuenciaAppModel;
import unq_ciu.gatoEncerrado.Habitacion;
import unq_ciu.gatoEncerrado.Item;
import unq_ciu.gatoEncerrado.Laberinto;

@SuppressWarnings("all")
public class WindowAgregarAccionDeUsarUnElementoConsecuencia extends Dialog<AgregarAccionDeUsarUnElementoConsecuenciaAppModel> {
  public WindowAgregarAccionDeUsarUnElementoConsecuencia(final WindowOwner owner, final Laberinto lab, final Habitacion hab, final Item item, final Accion acc) {
    super(owner, new AgregarAccionDeUsarUnElementoConsecuenciaAppModel(hab, item, acc, lab));
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
    Selector<Object> _selector = new Selector<Object>(mainPanel);
    final Procedure1<Selector<Object>> _function_1 = new Procedure1<Selector<Object>>() {
      public void apply(final Selector<Object> it) {
        it.allowNull(false);
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        _value.<Object>bindToProperty("itemSeleccionado");
        ObservableItems<Selector<Object>, Object, ListBuilder<Object>> _items = it.items();
        Binding<Object, Selector<Object>, ListBuilder<Object>> _bindToProperty = _items.<Object>bindToProperty("laberinto.itemsDisponibles");
        PropertyAdapter _propertyAdapter = new PropertyAdapter(Item.class, "nombre");
        _bindToProperty.setAdapter(_propertyAdapter);
        Label _label = new Label(mainPanel);
        final Procedure1<Label> _function = new Procedure1<Label>() {
          public void apply(final Label it) {
            it.setHeight(20);
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
      }
    };
    ObjectExtensions.<Selector<Object>>operator_doubleArrow(_selector, _function_1);
    final Panel accionPanel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    accionPanel.setLayout(_horizontalLayout);
    Button _button = new Button(accionPanel);
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
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_2);
  }
}
