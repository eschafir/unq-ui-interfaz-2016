package unq_ui.interfaz_LoginWindows;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.PasswordField;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import unq_ciu.gatoEncerrado.AppModel.GatoEncerradoAppModel;
import unq_ciu.gatoEncerrado.AppModel.LoginAppModel;
import unq_ciu.gatoEncerrado.Juego;
import unq_ciu.gatoEncerrado.Login.Usuario;
import unq_ciu.gatoEncerrado_DummyData.DummyData;
import unq_ui.interfaz_ventanaPrincipal.GatoEncerradoWindow;

@SuppressWarnings("all")
public class LoginWindows extends SimpleWindow<LoginAppModel> {
  public LoginWindows(final WindowOwner parent, final LoginAppModel model) {
    super(parent, model);
    this.setTaskDescription("Gato Encerrado 2.0");
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Inicio de Sesión");
    Label _label = new Label(mainPanel);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Ingrese sus credenciales");
        it.setFontSize(15);
        it.setHeight(30);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    this.crearPanelLogin(mainPanel);
    this.crearBotonera(mainPanel);
  }
  
  /**
   * Este método genera la interfaz del login.
   */
  public PasswordField crearPanelLogin(final Panel owner) {
    PasswordField _xblockexpression = null;
    {
      final Panel panelHeader = new Panel(owner);
      ColumnLayout _columnLayout = new ColumnLayout(2);
      panelHeader.setLayout(_columnLayout);
      Label _label = new Label(panelHeader);
      _label.setText("Usuario:");
      TextBox _textBox = new TextBox(panelHeader);
      final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
        public void apply(final TextBox it) {
          it.setWidth(70);
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          _value.<Object>bindToProperty("usuarioIngresado.username");
        }
      };
      ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
      Label _label_1 = new Label(panelHeader);
      final Procedure1<Label> _function_1 = new Procedure1<Label>() {
        public void apply(final Label it) {
          it.setText("Contraseña:");
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function_1);
      PasswordField _passwordField = new PasswordField(panelHeader);
      final Procedure1<PasswordField> _function_2 = new Procedure1<PasswordField>() {
        public void apply(final PasswordField it) {
          it.setWidth(70);
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          _value.<Object>bindToProperty("claveIngresada");
        }
      };
      _xblockexpression = ObjectExtensions.<PasswordField>operator_doubleArrow(_passwordField, _function_2);
    }
    return _xblockexpression;
  }
  
  /**
   * Este método genera los 2 botones "Login" y "Cancelar" de la pantalla de credenciales.
   * Si se verifica el usuario correctamente, al pulsar sobre login se abre una pantalla principal de Gato Encerrado.
   */
  public Button crearBotonera(final Panel owner) {
    Button _xblockexpression = null;
    {
      final Panel botonera = new Panel(owner);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      botonera.setLayout(_horizontalLayout);
      Button _button = new Button(botonera);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Login");
          it.setWidth(65);
          final Action _function = new Action() {
            public void execute() {
              GatoEncerradoAppModel _gatoEncerradoAppModel = new GatoEncerradoAppModel();
              final Procedure1<GatoEncerradoAppModel> _function = new Procedure1<GatoEncerradoAppModel>() {
                public void apply(final GatoEncerradoAppModel it) {
                  DummyData _dummyData = new DummyData();
                  Juego _crearJuegoDummy = _dummyData.crearJuegoDummy();
                  it.setJuego(_crearJuegoDummy);
                  LoginAppModel _modelObject = LoginWindows.this.getModelObject();
                  Usuario _usuarioIngresado = _modelObject.getUsuarioIngresado();
                  it.setUsuario(_usuarioIngresado);
                }
              };
              final GatoEncerradoAppModel modelo = ObjectExtensions.<GatoEncerradoAppModel>operator_doubleArrow(_gatoEncerradoAppModel, _function);
              LoginAppModel _modelObject = LoginWindows.this.getModelObject();
              _modelObject.validarUsuarioYClave();
              GatoEncerradoWindow _gatoEncerradoWindow = new GatoEncerradoWindow(LoginWindows.this, modelo);
              _gatoEncerradoWindow.open();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
      Button _button_1 = new Button(botonera);
      final Procedure1<Button> _function_1 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Cancelar");
          it.setWidth(65);
          final Action _function = new Action() {
            public void execute() {
              LoginWindows.this.close();
            }
          };
          it.onClick(_function);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
    }
    return _xblockexpression;
  }
}
