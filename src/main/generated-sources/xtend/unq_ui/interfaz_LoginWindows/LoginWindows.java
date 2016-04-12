package unq_ui.interfaz_LoginWindows;

import java.awt.Color;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
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
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from String to GatoEncerradoAppModel");
  }
}
