package unq_ui.interfaz_gatoEncerradoApplication;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import unq_ciu.gatoEncerrado.AppModel.LoginAppModel;
import unq_ciu.gatoEncerrado.Login.Login;
import unq_ciu.gatoEncerrado.Login.Usuario;
import unq_ciu.gatoEncerrado_DummyData.DummyData;
import unq_ui.interfaz_LoginWindows.LoginWindows;

@SuppressWarnings("all")
public class LoginApplication extends Application {
  protected Window<?> createMainWindow() {
    LoginWindows _xblockexpression = null;
    {
      LoginAppModel _loginAppModel = new LoginAppModel();
      final Procedure1<LoginAppModel> _function = new Procedure1<LoginAppModel>() {
        public void apply(final LoginAppModel it) {
          DummyData _dummyData = new DummyData();
          Login _crearLoginDummy = _dummyData.getCrearLoginDummy();
          it.setLogin(_crearLoginDummy);
          Usuario _usuario = new Usuario();
          it.setUsuarioIngresado(_usuario);
        }
      };
      final LoginAppModel model = ObjectExtensions.<LoginAppModel>operator_doubleArrow(_loginAppModel, _function);
      _xblockexpression = new LoginWindows(this, model);
    }
    return _xblockexpression;
  }
  
  public static void main(final String[] args) {
    LoginApplication _loginApplication = new LoginApplication();
    _loginApplication.start();
  }
}
