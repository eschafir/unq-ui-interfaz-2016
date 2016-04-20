package unq_ui.interfaz_gatoEncerrado_2016.Consecuencias;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import unq_ciu.gatoEncerrado.Consecuencias.AgregarAccionConsecuenciaAppModel;
import unq_ciu.gatoEncerrado.Habitacion;
import unq_ciu.gatoEncerrado.Item;
import unq_ciu.gatoEncerrado.Laberinto;
import unq_ui.interfaz_gatoEncerrado_2016.Consecuencias.WindowAgregarAccionDeAgarrarUnElementoConsecuencia;
import unq_ui.interfaz_gatoEncerrado_2016.Consecuencias.WindowAgregarAccionDeIrAOtraHabitacionConsecuencia;
import unq_ui.interfaz_gatoEncerrado_2016.Consecuencias.WindowAgregarAccionDeUsarUnElementoConsecuencia;

@SuppressWarnings("all")
public class WindowAgregarAccionConsecuencia extends SimpleWindow<AgregarAccionConsecuenciaAppModel> {
  public WindowAgregarAccionConsecuencia(final WindowOwner parent, final Laberinto lab, final Habitacion hab, final Item item) {
    super(parent, new AgregarAccionConsecuenciaAppModel(lab, hab, item));
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    AgregarAccionConsecuenciaAppModel _modelObject = this.getModelObject();
    Habitacion _habitacion = _modelObject.getHabitacion();
    String _nombre = _habitacion.getNombre();
    String _plus = (_nombre + ": agregar accion consecuencia.");
    this.setTitle(_plus);
    this.setMinHeight(200);
    mainPanel.setWidth(3000);
    Label _label = new Label(mainPanel);
    _label.setText("Selecciona una acción consecuencia");
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
            AgregarAccionConsecuenciaAppModel _modelObject = WindowAgregarAccionConsecuencia.this.getModelObject();
            Laberinto _laberinto = _modelObject.getLaberinto();
            AgregarAccionConsecuenciaAppModel _modelObject_1 = WindowAgregarAccionConsecuencia.this.getModelObject();
            Habitacion _habitacion = _modelObject_1.getHabitacion();
            AgregarAccionConsecuenciaAppModel _modelObject_2 = WindowAgregarAccionConsecuencia.this.getModelObject();
            Item _item = _modelObject_2.getItem();
            WindowAgregarAccionDeIrAOtraHabitacionConsecuencia _windowAgregarAccionDeIrAOtraHabitacionConsecuencia = new WindowAgregarAccionDeIrAOtraHabitacionConsecuencia(WindowAgregarAccionConsecuencia.this, _laberinto, _habitacion, _item);
            _windowAgregarAccionDeIrAOtraHabitacionConsecuencia.open();
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
            AgregarAccionConsecuenciaAppModel _modelObject = WindowAgregarAccionConsecuencia.this.getModelObject();
            Laberinto _laberinto = _modelObject.getLaberinto();
            AgregarAccionConsecuenciaAppModel _modelObject_1 = WindowAgregarAccionConsecuencia.this.getModelObject();
            Habitacion _habitacion = _modelObject_1.getHabitacion();
            AgregarAccionConsecuenciaAppModel _modelObject_2 = WindowAgregarAccionConsecuencia.this.getModelObject();
            Item _item = _modelObject_2.getItem();
            WindowAgregarAccionDeAgarrarUnElementoConsecuencia _windowAgregarAccionDeAgarrarUnElementoConsecuencia = new WindowAgregarAccionDeAgarrarUnElementoConsecuencia(WindowAgregarAccionConsecuencia.this, _laberinto, _habitacion, _item);
            _windowAgregarAccionDeAgarrarUnElementoConsecuencia.open();
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
        final Action _function = new Action() {
          public void execute() {
            AgregarAccionConsecuenciaAppModel _modelObject = WindowAgregarAccionConsecuencia.this.getModelObject();
            Laberinto _laberinto = _modelObject.getLaberinto();
            AgregarAccionConsecuenciaAppModel _modelObject_1 = WindowAgregarAccionConsecuencia.this.getModelObject();
            Habitacion _habitacion = _modelObject_1.getHabitacion();
            AgregarAccionConsecuenciaAppModel _modelObject_2 = WindowAgregarAccionConsecuencia.this.getModelObject();
            Item _item = _modelObject_2.getItem();
            WindowAgregarAccionDeUsarUnElementoConsecuencia _windowAgregarAccionDeUsarUnElementoConsecuencia = new WindowAgregarAccionDeUsarUnElementoConsecuencia(WindowAgregarAccionConsecuencia.this, _laberinto, _habitacion, _item);
            _windowAgregarAccionDeUsarUnElementoConsecuencia.open();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_2);
    Button _button_3 = new Button(mainPanel);
    final Procedure1<Button> _function_3 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            WindowAgregarAccionConsecuencia.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_3, _function_3);
  }
}
