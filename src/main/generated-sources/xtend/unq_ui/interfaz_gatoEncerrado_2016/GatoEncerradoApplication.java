package unq_ui.interfaz_gatoEncerrado_2016;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import unq_ciu.gatoEncerrado.AppModel.GatoEncerradoAppModel;
import unq_ciu.gatoEncerrado.Habitacion;
import unq_ciu.gatoEncerrado.Juego;
import unq_ciu.gatoEncerrado.Jugador;
import unq_ciu.gatoEncerrado.Laberinto;
import unq_ciu.gatoEncerrado.acciones.Mover;
import unq_ui.interfaz_ventanaPrincipal.GatoEncerradoWindow;

@SuppressWarnings("all")
public class GatoEncerradoApplication extends Application {
  protected Window<?> createMainWindow() {
    GatoEncerradoWindow _xblockexpression = null;
    {
      final Habitacion living = new Habitacion("Living", true, false);
      final Habitacion cocina = new Habitacion("Cocina", false, false);
      final Habitacion patio = new Habitacion("Patio", false, false);
      final Mover mover = new Mover(cocina);
      final Laberinto laberinto = new Laberinto("Casa Abandonada");
      living.agregarAccion(mover);
      Jugador _jugador = new Jugador("Esteban", living);
      final Juego juego = new Juego(_jugador);
      laberinto.agregarHabitacion(living);
      laberinto.agregarHabitacion(cocina);
      laberinto.agregarHabitacion(patio);
      juego.agregarLaberinto(laberinto);
      final GatoEncerradoAppModel model = new GatoEncerradoAppModel(juego);
      _xblockexpression = new GatoEncerradoWindow(this, model);
    }
    return _xblockexpression;
  }
  
  public static void main(final String[] args) {
    GatoEncerradoApplication _gatoEncerradoApplication = new GatoEncerradoApplication();
    _gatoEncerradoApplication.start();
  }
}
