package unq_ui.interfaz_gatoEncerrado_2016

import org.uqbar.arena.Application
import unq_ciu.gatoEncerrado.Habitacion
import unq_ciu.gatoEncerrado.Laberinto
import unq_ciu.gatoEncerrado.Juego
import unq_ciu.gatoEncerrado.AppModel.GatoEncerradoAppModel
import unq_ui.interfaz_ventanaPrincipal.GatoEncerradoWindow

class GatoEncerradoApplication extends Application {

	override protected createMainWindow() {

		val living = new Habitacion("Living", true, false)
		val cocina = new Habitacion("Cocina", false, false)
		val patio = new Habitacion("Patio", false, false)

		val laberinto = new Laberinto("Casa")

		val juego = new Juego()
		laberinto.agregarHabitacion(living)
		laberinto.agregarHabitacion(cocina)
		laberinto.agregarHabitacion(patio)
		juego.agregarLaberinto(laberinto)

		//val model = new AgregarAccionAppModel(living)
		//new WindowAgregarAccion(this, model)
		
		val model = new GatoEncerradoAppModel(juego)
		new GatoEncerradoWindow(this, model)

	}

	def static main(String[] args) {

		new GatoEncerradoApplication().start
	}

}
