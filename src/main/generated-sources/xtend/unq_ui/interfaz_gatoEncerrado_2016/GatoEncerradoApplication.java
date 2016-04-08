package unq_ui.interfaz_gatoEncerrado_2016;

import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import unq_ciu.gatoEncerrado.AppModel.GatoEncerradoAppModel;
import unq_ciu.gatoEncerrado.Juego;
import unq_ciu.gatoEncerrado_DummyData.DummyData;
import unq_ui.interfaz_ventanaPrincipal.GatoEncerradoWindow;

@SuppressWarnings("all")
public class GatoEncerradoApplication extends Application {
  protected Window<?> createMainWindow() {
    GatoEncerradoWindow _xblockexpression = null;
    {
      GatoEncerradoAppModel _gatoEncerradoAppModel = new GatoEncerradoAppModel();
      final Procedure1<GatoEncerradoAppModel> _function = new Procedure1<GatoEncerradoAppModel>() {
        public void apply(final GatoEncerradoAppModel it) {
          DummyData _dummyData = new DummyData();
          Juego _crearJuegoDummy = _dummyData.crearJuegoDummy();
          it.setJuego(_crearJuegoDummy);
        }
      };
      final GatoEncerradoAppModel modelo = ObjectExtensions.<GatoEncerradoAppModel>operator_doubleArrow(_gatoEncerradoAppModel, _function);
      _xblockexpression = new GatoEncerradoWindow(this, modelo);
    }
    return _xblockexpression;
  }
  
  public static void main(final String[] args) {
    GatoEncerradoApplication _gatoEncerradoApplication = new GatoEncerradoApplication();
    _gatoEncerradoApplication.start();
  }
}
