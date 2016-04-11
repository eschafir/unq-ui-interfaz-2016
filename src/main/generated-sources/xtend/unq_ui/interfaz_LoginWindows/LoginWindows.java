package unq_ui.interfaz_LoginWindows;

import java.awt.Color;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import unq_ciu.gatoEncerrado.Login.Login;

@SuppressWarnings("all")
public class LoginWindows extends SimpleWindow<Login> {
  public LoginWindows(final WindowOwner parent, final Login model) {
    super(parent, model);
  }
  
  protected void addActions(final Panel actionsPanel) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
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
  }
}
