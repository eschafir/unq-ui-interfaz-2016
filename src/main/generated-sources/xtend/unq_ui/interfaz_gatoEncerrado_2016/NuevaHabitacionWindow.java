package unq_ui.interfaz_gatoEncerrado_2016;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import unq_ciu.gatoEncerrado.AppModel.CrearHabitacionAppModel;
import unq_ciu.gatoEncerrado.Laberinto;

@SuppressWarnings("all")
public class NuevaHabitacionWindow extends Dialog<CrearHabitacionAppModel> {
  public NuevaHabitacionWindow(final WindowOwner owner, final Laberinto model) {
    super(owner, new CrearHabitacionAppModel(model));
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    CrearHabitacionAppModel _modelObject = this.getModelObject();
    Laberinto _laberinto = _modelObject.getLaberinto();
    String _nombre = _laberinto.getNombre();
    String _plus = (_nombre + ": agregar habitacion");
    this.setTitle(_plus);
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    Label _label = new Label(mainPanel);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Ingrese el nombre de la habitacion");
        it.setHeight(30);
        it.setFontSize(10);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    TextBox _textBox = new TextBox(mainPanel);
    final Procedure1<TextBox> _function_1 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        _value.<Object>bindToProperty("habitacion.nombre");
        it.setWidth(200);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function_1);
    final Panel inicialFinal = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    inicialFinal.setLayout(_horizontalLayout);
    final Panel inicialCheck = new Panel(inicialFinal);
    HorizontalLayout _horizontalLayout_1 = new HorizontalLayout();
    inicialCheck.setLayout(_horizontalLayout_1);
    CheckBox _checkBox = new CheckBox(inicialCheck);
    ObservableValue<Control, ControlBuilder> _value = _checkBox.<ControlBuilder>value();
    _value.<Object>bindToProperty("habitacion.esInicial");
    Label _label_1 = new Label(inicialCheck);
    _label_1.setText("¿Es Inicial?");
    final Panel finalCheck = new Panel(inicialFinal);
    HorizontalLayout _horizontalLayout_2 = new HorizontalLayout();
    finalCheck.setLayout(_horizontalLayout_2);
    CheckBox _checkBox_1 = new CheckBox(finalCheck);
    ObservableValue<Control, ControlBuilder> _value_1 = _checkBox_1.<ControlBuilder>value();
    _value_1.<Object>bindToProperty("habitacion.esFinal");
    Label _label_2 = new Label(finalCheck);
    _label_2.setText("¿Es Final?");
    final Panel botonera = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout_3 = new HorizontalLayout();
    botonera.setLayout(_horizontalLayout_3);
    Button _button = new Button(botonera);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            CrearHabitacionAppModel _modelObject = NuevaHabitacionWindow.this.getModelObject();
            _modelObject.verificar();
            CrearHabitacionAppModel _modelObject_1 = NuevaHabitacionWindow.this.getModelObject();
            _modelObject_1.agregarHabitacion();
            NuevaHabitacionWindow.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_2);
    Button _button_1 = new Button(botonera);
    final Procedure1<Button> _function_3 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Cancelar");
        final Action _function = new Action() {
          public void execute() {
            NuevaHabitacionWindow.this.cancel();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_3);
  }
}
