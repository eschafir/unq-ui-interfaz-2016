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
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import unq_ciu.gatoEncerrado.AppModel.AgregarAccionDeAgarrarElementoAppModel;
import unq_ciu.gatoEncerrado.Habitacion;

@SuppressWarnings("all")
public class WindowAgregarAccionDeAgarrarElemento extends Dialog<AgregarAccionDeAgarrarElementoAppModel> {
  public WindowAgregarAccionDeAgarrarElemento(final WindowOwner owner, final Habitacion hab) {
    super(owner, new AgregarAccionDeAgarrarElementoAppModel(hab));
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Agarrar un elemento");
    this.setMinHeight(200);
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    mainPanel.setWidth(3000);
    Label _label = new Label(mainPanel);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        AgregarAccionDeAgarrarElementoAppModel _modelObject = WindowAgregarAccionDeAgarrarElemento.this.getModelObject();
        Habitacion _habitacion = _modelObject.getHabitacion();
        String _nombre = _habitacion.getNombre();
        String _plus = ("Indicar el item que se puede agarrar en: " + _nombre);
        String _plus_1 = (_plus + ".");
        it.setText(_plus_1);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    TextBox _textBox = new TextBox(mainPanel);
    final Procedure1<TextBox> _function_1 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        _value.<Object>bindToProperty("item.nombre");
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function_1);
    final Panel accionesPanel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    accionesPanel.setLayout(_horizontalLayout);
    Button _button = new Button(accionesPanel);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Cancelar");
        it.setHeight(30);
        it.setWidth(150);
        final Action _function = new Action() {
          public void execute() {
            WindowAgregarAccionDeAgarrarElemento.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_2);
    Button _button_1 = new Button(accionesPanel);
    final Procedure1<Button> _function_3 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Agregar");
        it.setHeight(30);
        it.setWidth(150);
        final Action _function = new Action() {
          public void execute() {
            AgregarAccionDeAgarrarElementoAppModel _modelObject = WindowAgregarAccionDeAgarrarElemento.this.getModelObject();
            _modelObject.agregarAcccionAgarrar();
            WindowAgregarAccionDeAgarrarElemento.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_3);
  }
}
