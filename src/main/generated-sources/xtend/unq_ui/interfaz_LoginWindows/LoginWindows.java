package unq_ui.interfaz_LoginWindows;

import java.awt.Color;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import unq_ciu.gatoEncerrado.AppModel.LoginAppModel;

@SuppressWarnings("all")
public class LoginWindows extends SimpleWindow<LoginAppModel> {
  public LoginWindows(final WindowOwner parent, final LoginAppModel model) {
    super(parent, model);
    this.setTaskDescription("Bienvenido al Gato Encerrado 2.0");
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Acá hay gato encerrado - Inicio de Sesión");
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
    ColumnLayout _columnLayout = new ColumnLayout(1);
    panelPrincipal.setLayout(_columnLayout);
    this.crearPanelLogin(panelPrincipal);
  }
  
  public Button crearPanelLogin(final Panel owner) {
    Button _xblockexpression = null;
    {
      final Panel panelHeader = new Panel(owner);
      ColumnLayout _columnLayout = new ColumnLayout(2);
      panelHeader.setLayout(_columnLayout);
      Label _label = new Label(panelHeader);
      _label.setText("Username:");
      TextBox _textBox = new TextBox(panelHeader);
      final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
        public void apply(final TextBox it) {
          it.setWidth(50);
        }
      };
      ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
      Label _label_1 = new Label(panelHeader);
      final Procedure1<Label> _function_1 = new Procedure1<Label>() {
        public void apply(final Label it) {
          it.setText("Password:");
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function_1);
      TextBox _textBox_1 = new TextBox(panelHeader);
      final Procedure1<TextBox> _function_2 = new Procedure1<TextBox>() {
        public void apply(final TextBox it) {
          it.setWidth(50);
        }
      };
      ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_1, _function_2);
      final Panel botonera = new Panel(owner);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      botonera.setLayout(_horizontalLayout);
      Button _button = new Button(botonera);
      final Procedure1<Button> _function_3 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Cancel");
          it.setWidth(65);
          final Action _function = new Action() {
            public void execute() {
              LoginWindows.this.close();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function_3);
      Button _button_1 = new Button(botonera);
      final Procedure1<Button> _function_4 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Login");
          it.setWidth(65);
          final Action _function = new Action() {
            public void execute() {
              LoginAppModel _modelObject = LoginWindows.this.getModelObject();
              _modelObject.validarUsuario();
            }
          };
          it.onClick(_function);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_4);
    }
    return _xblockexpression;
  }
}
