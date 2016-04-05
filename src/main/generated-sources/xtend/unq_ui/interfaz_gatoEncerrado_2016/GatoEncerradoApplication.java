package unq_ui.interfaz_gatoEncerrado_2016;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import unq_ciu.gatoEncerrado.AppModel.AgregarAccionAppModel;
import unq_ciu.gatoEncerrado.Habitacion;
import unq_ciu.gatoEncerrado.Laberinto;
import unq_ui.interfaz_gatoEncerrado_2016.WindowAgregarAccion;

@SuppressWarnings("all")
public class GatoEncerradoApplication extends Application {
  protected Window<?> createMainWindow() {
    WindowAgregarAccion _xblockexpression = null;
    {
      final Habitacion living = new Habitacion("Living", false, false);
      final Habitacion cocina = new Habitacion("Cocina", false, false);
      final Habitacion patio = new Habitacion("Patio", false, false);
      final Laberinto laberinto = new Laberinto("Casa");
      laberinto.agregarHabitacion(living);
      laberinto.agregarHabitacion(cocina);
      laberinto.agregarHabitacion(patio);
      final AgregarAccionAppModel model = new AgregarAccionAppModel();
      _xblockexpression = new WindowAgregarAccion(this, model);
    }
    return _xblockexpression;
  }
  
  public static void main(final String[] args) {
    GatoEncerradoApplication _gatoEncerradoApplication = new GatoEncerradoApplication();
    _gatoEncerradoApplication.start();
  }
}
