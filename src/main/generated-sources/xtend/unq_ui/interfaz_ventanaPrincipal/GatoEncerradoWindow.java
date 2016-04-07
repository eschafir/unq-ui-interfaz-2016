package unq_ui.interfaz_ventanaPrincipal;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableItems;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import unq_ciu.gatoEncerrado.AppModel.GatoEncerradoAppModel;
import unq_ciu.gatoEncerrado.Juego;
import unq_ciu.gatoEncerrado.Laberinto;
import unq_ui.interfaz_gatoEncerrado_2016.NuevoLaberintoWindow;

@SuppressWarnings("all")
public class GatoEncerradoWindow extends SimpleWindow<GatoEncerradoAppModel> {
  public GatoEncerradoWindow(final WindowOwner parent, final GatoEncerradoAppModel model) {
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
  
  public Button crearListadoDeLaberintos(final Panel owner) {
    Button _xblockexpression = null;
    {
      Label _label = new Label(owner);
      _label.setText("Laberintos");
      List<Laberinto> _list = new List<Laberinto>(owner);
      final Procedure1<List<Laberinto>> _function = new Procedure1<List<Laberinto>>() {
        public void apply(final List<Laberinto> it) {
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          _value.<Object>bindToProperty("laberintoSeleccionado");
          ObservableItems<Selector<Laberinto>, Laberinto, ListBuilder<Laberinto>> _items = it.items();
          Binding<Object, Selector<Laberinto>, ListBuilder<Laberinto>> _bindToProperty = _items.<Object>bindToProperty("juego.laberintos");
          PropertyAdapter _propertyAdapter = new PropertyAdapter(Laberinto.class, "nombre");
          _bindToProperty.setAdapter(_propertyAdapter);
        }
      };
      ObjectExtensions.<List<Laberinto>>operator_doubleArrow(_list, _function);
      Button _button = new Button(owner);
      final Procedure1<Button> _function_1 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Agregar Laberinto");
          final Action _function = new Action() {
            public void execute() {
              GatoEncerradoAppModel _modelObject = GatoEncerradoWindow.this.getModelObject();
              Juego _juego = _modelObject.getJuego();
              NuevoLaberintoWindow _nuevoLaberintoWindow = new NuevoLaberintoWindow(GatoEncerradoWindow.this, _juego);
              _nuevoLaberintoWindow.open();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
      Button _button_1 = new Button(owner);
      final Procedure1<Button> _function_2 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Quitar Laberinto");
          final Action _function = new Action() {
            public void execute() {
              GatoEncerradoAppModel _modelObject = GatoEncerradoWindow.this.getModelObject();
              _modelObject.eliminarLaberinto();
            }
          };
          it.onClick(_function);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_2);
    }
    return _xblockexpression;
  }
  
  public Binding<Object, Control, ControlBuilder> crearEdicionDeLaberintoSeleccionado(final Panel owner) {
    Binding<Object, Control, ControlBuilder> _xblockexpression = null;
    {
      final Panel header = new Panel(owner);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      header.setLayout(_horizontalLayout);
      Label _label = new Label(header);
      _label.setText("Habitaciones de:");
      Label _label_1 = new Label(header);
      ObservableValue<Control, ControlBuilder> _value = _label_1.<ControlBuilder>value();
      _xblockexpression = _value.<Object>bindToProperty("laberintoSeleccionado.nombre");
    }
    return _xblockexpression;
  }
}
