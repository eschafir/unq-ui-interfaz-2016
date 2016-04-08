package unq_ui.interfaz_ventanaPrincipal;

import java.awt.Color;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableItems;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import unq_ciu.gatoEncerrado.Accion;
import unq_ciu.gatoEncerrado.AppModel.GatoEncerradoAppModel;
import unq_ciu.gatoEncerrado.Habitacion;
import unq_ciu.gatoEncerrado.Juego;
import unq_ciu.gatoEncerrado.Laberinto;
import unq_ui.interfaz_gatoEncerrado_2016.NuevaHabitacionWindow;
import unq_ui.interfaz_gatoEncerrado_2016.NuevoLaberintoWindow;
import unq_ui.interfaz_gatoEncerrado_2016.WindowAgregarAccion;

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
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Acá hay gato encerrado...");
        it.setFontSize(20);
        it.setForeground(Color.GRAY);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    final Panel panelPrincipal = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(3);
    panelPrincipal.setLayout(_columnLayout);
    final Panel panelIzquierdo = new Panel(panelPrincipal);
    panelIzquierdo.setWidth(300);
    this.crearListadoDeLaberintos(panelIzquierdo);
    final Panel panelCentral = new Panel(panelPrincipal);
    panelCentral.setWidth(300);
    this.crearEdicionDeLaberintoSeleccionado(panelCentral);
    final Panel panelDerecho = new Panel(panelPrincipal);
    panelDerecho.setWidth(300);
    this.crearEdicionDeHabitacionSeleccionada(panelDerecho);
  }
  
  public Button crearListadoDeLaberintos(final Panel owner) {
    Button _xblockexpression = null;
    {
      Label _label = new Label(owner);
      final Procedure1<Label> _function = new Procedure1<Label>() {
        public void apply(final Label it) {
          it.setText("Laberintos");
          it.setFontSize(12);
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
      List<Laberinto> _list = new List<Laberinto>(owner);
      final Procedure1<List<Laberinto>> _function_1 = new Procedure1<List<Laberinto>>() {
        public void apply(final List<Laberinto> it) {
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          _value.<Object>bindToProperty("laberintoSeleccionado");
          ObservableItems<Selector<Laberinto>, Laberinto, ListBuilder<Laberinto>> _items = it.items();
          Binding<Object, Selector<Laberinto>, ListBuilder<Laberinto>> _bindToProperty = _items.<Object>bindToProperty("juego.laberintos");
          PropertyAdapter _propertyAdapter = new PropertyAdapter(Laberinto.class, "nombre");
          _bindToProperty.setAdapter(_propertyAdapter);
          it.setHeight(150);
        }
      };
      ObjectExtensions.<List<Laberinto>>operator_doubleArrow(_list, _function_1);
      final Panel botonera = new Panel(owner);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      botonera.setLayout(_horizontalLayout);
      Button _button = new Button(botonera);
      final Procedure1<Button> _function_2 = new Procedure1<Button>() {
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
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function_2);
      Button _button_1 = new Button(botonera);
      final Procedure1<Button> _function_3 = new Procedure1<Button>() {
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
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_3);
    }
    return _xblockexpression;
  }
  
  public Button crearEdicionDeLaberintoSeleccionado(final Panel owner) {
    Button _xblockexpression = null;
    {
      final Panel header = new Panel(owner);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      header.setLayout(_horizontalLayout);
      final Panel panelHeader = new Panel(owner);
      ColumnLayout _columnLayout = new ColumnLayout(2);
      panelHeader.setLayout(_columnLayout);
      Label _label = new Label(panelHeader);
      _label.setText("Habitaciones de:");
      Label _label_1 = new Label(panelHeader);
      ObservableValue<Control, ControlBuilder> _value = _label_1.<ControlBuilder>value();
      _value.<Object>bindToProperty("laberintoSeleccionado.nombre");
      Label _label_2 = new Label(panelHeader);
      _label_2.setText("Laberinto seleccionado:");
      TextBox _textBox = new TextBox(panelHeader);
      final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
        public void apply(final TextBox it) {
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          _value.<Object>bindToProperty("laberintoSeleccionado.nombre");
          it.setWidth(100);
        }
      };
      ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
      List<Habitacion> _list = new List<Habitacion>(owner);
      final Procedure1<List<Habitacion>> _function_1 = new Procedure1<List<Habitacion>>() {
        public void apply(final List<Habitacion> it) {
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          _value.<Object>bindToProperty("habitacionSeleccionada");
          ObservableItems<Selector<Habitacion>, Habitacion, ListBuilder<Habitacion>> _items = it.items();
          Binding<Object, Selector<Habitacion>, ListBuilder<Habitacion>> _bindToProperty = _items.<Object>bindToProperty("laberintoSeleccionado.habitaciones");
          PropertyAdapter _propertyAdapter = new PropertyAdapter(Habitacion.class, 
            "nombre");
          _bindToProperty.setAdapter(_propertyAdapter);
          it.setHeight(150);
        }
      };
      ObjectExtensions.<List<Habitacion>>operator_doubleArrow(_list, _function_1);
      final Panel botonera = new Panel(owner);
      HorizontalLayout _horizontalLayout_1 = new HorizontalLayout();
      botonera.setLayout(_horizontalLayout_1);
      Button _button = new Button(botonera);
      final Procedure1<Button> _function_2 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Nueva Habitacion");
          final Action _function = new Action() {
            public void execute() {
              GatoEncerradoAppModel _modelObject = GatoEncerradoWindow.this.getModelObject();
              Laberinto _laberintoSeleccionado = _modelObject.getLaberintoSeleccionado();
              NuevaHabitacionWindow _nuevaHabitacionWindow = new NuevaHabitacionWindow(GatoEncerradoWindow.this, _laberintoSeleccionado);
              _nuevaHabitacionWindow.open();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function_2);
      Button _button_1 = new Button(botonera);
      final Procedure1<Button> _function_3 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Eliminar Habitacion");
          final Action _function = new Action() {
            public void execute() {
              GatoEncerradoAppModel _modelObject = GatoEncerradoWindow.this.getModelObject();
              _modelObject.eliminarHabitacion();
            }
          };
          it.onClick(_function);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_3);
    }
    return _xblockexpression;
  }
  
  public Button crearEdicionDeHabitacionSeleccionada(final Panel owner) {
    Button _xblockexpression = null;
    {
      final Panel header = new Panel(owner);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      header.setLayout(_horizontalLayout);
      final Panel panelHeader = new Panel(owner);
      ColumnLayout _columnLayout = new ColumnLayout(2);
      panelHeader.setLayout(_columnLayout);
      Label _label = new Label(panelHeader);
      _label.setText("Habitacion seleccionada:");
      Label _label_1 = new Label(panelHeader);
      ObservableValue<Control, ControlBuilder> _value = _label_1.<ControlBuilder>value();
      _value.<Object>bindToProperty("habitacionSeleccionada.nombre");
      Label _label_2 = new Label(panelHeader);
      final Procedure1<Label> _function = new Procedure1<Label>() {
        public void apply(final Label it) {
          it.setText("Nombre:");
          it.setWidth(150);
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label_2, _function);
      TextBox _textBox = new TextBox(panelHeader);
      final Procedure1<TextBox> _function_1 = new Procedure1<TextBox>() {
        public void apply(final TextBox it) {
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          _value.<Object>bindToProperty("habitacionSeleccionada.nombre");
          it.setWidth(100);
        }
      };
      ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function_1);
      final Panel inicialCheck = new Panel(owner);
      HorizontalLayout _horizontalLayout_1 = new HorizontalLayout();
      inicialCheck.setLayout(_horizontalLayout_1);
      CheckBox _checkBox = new CheckBox(inicialCheck);
      ObservableValue<Control, ControlBuilder> _value_1 = _checkBox.<ControlBuilder>value();
      _value_1.<Object>bindToProperty("habitacionSeleccionada.esInicial");
      Label _label_3 = new Label(inicialCheck);
      _label_3.setText("Es Inicial?");
      final Panel finalCheck = new Panel(owner);
      HorizontalLayout _horizontalLayout_2 = new HorizontalLayout();
      finalCheck.setLayout(_horizontalLayout_2);
      CheckBox _checkBox_1 = new CheckBox(finalCheck);
      ObservableValue<Control, ControlBuilder> _value_2 = _checkBox_1.<ControlBuilder>value();
      _value_2.<Object>bindToProperty("habitacionSeleccionada.esFinal");
      Label _label_4 = new Label(finalCheck);
      final Procedure1<Label> _function_2 = new Procedure1<Label>() {
        public void apply(final Label it) {
          it.setText("Es Final?");
          it.setHeight(23);
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label_4, _function_2);
      Label _label_5 = new Label(owner);
      _label_5.setText("Acciones");
      List<Accion> _list = new List<Accion>(owner);
      final Procedure1<List<Accion>> _function_3 = new Procedure1<List<Accion>>() {
        public void apply(final List<Accion> it) {
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          _value.<Object>bindToProperty("accionSeleccionada");
          ObservableItems<Selector<Accion>, Accion, ListBuilder<Accion>> _items = it.items();
          _items.<Object>bindToProperty("habitacionSeleccionada.acciones");
          it.setHeight(73);
        }
      };
      ObjectExtensions.<List<Accion>>operator_doubleArrow(_list, _function_3);
      final Panel botonera = new Panel(owner);
      HorizontalLayout _horizontalLayout_3 = new HorizontalLayout();
      botonera.setLayout(_horizontalLayout_3);
      Button _button = new Button(botonera);
      final Procedure1<Button> _function_4 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Agregar Accion");
          final Action _function = new Action() {
            public void execute() {
              GatoEncerradoAppModel _modelObject = GatoEncerradoWindow.this.getModelObject();
              Laberinto _laberintoSeleccionado = _modelObject.getLaberintoSeleccionado();
              GatoEncerradoAppModel _modelObject_1 = GatoEncerradoWindow.this.getModelObject();
              Habitacion _habitacionSeleccionada = _modelObject_1.getHabitacionSeleccionada();
              WindowAgregarAccion _windowAgregarAccion = new WindowAgregarAccion(GatoEncerradoWindow.this, _laberintoSeleccionado, _habitacionSeleccionada);
              _windowAgregarAccion.open();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function_4);
      Button _button_1 = new Button(botonera);
      final Procedure1<Button> _function_5 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Quitar Accion");
          final Action _function = new Action() {
            public void execute() {
              GatoEncerradoAppModel _modelObject = GatoEncerradoWindow.this.getModelObject();
              _modelObject.quitarAccion();
            }
          };
          it.onClick(_function);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_5);
    }
    return _xblockexpression;
  }
}
