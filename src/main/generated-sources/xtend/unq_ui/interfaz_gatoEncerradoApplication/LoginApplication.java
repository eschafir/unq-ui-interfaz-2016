package unq_ui.interfaz_gatoEncerradoApplication;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import unq_ciu.gatoEncerrado.AppModel.LoginAppModel;
import unq_ciu.gatoEncerrado.Login.Login;
import unq_ui.interfaz_LoginWindows.LoginWindows;

@SuppressWarnings("all")
public class LoginApplication extends Application {
  protected Window<?> createMainWindow() {
    LoginWindows _xblockexpression = null;
    {
      Login _login = new Login();
      final LoginAppModel modelo = new LoginAppModel(_login);
      _xblockexpression = new LoginWindows(this, modelo);
    }
    return _xblockexpression;
  }
  
  public static void main(final String[] args) {
    LoginApplication _loginApplication = new LoginApplication();
    _loginApplication.start();
  }
}
