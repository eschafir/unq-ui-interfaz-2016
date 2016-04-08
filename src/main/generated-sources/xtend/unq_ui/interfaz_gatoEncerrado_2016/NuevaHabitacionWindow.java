package unq_ui.interfaz_gatoEncerrado_2016;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
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
    _label.setText("Nombre:");
    TextBox _textBox = new TextBox(mainPanel);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        _value.<Object>bindToProperty("habitacion.nombre");
        it.setWidth(200);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            CrearHabitacionAppModel _modelObject = NuevaHabitacionWindow.this.getModelObject();
            _modelObject.agregarHabitacion();
            NuevaHabitacionWindow.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
  }
}