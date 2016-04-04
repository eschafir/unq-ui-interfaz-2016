package unq_ui.interfaz_gatoEncerrado_2016

import org.uqbar.arena.Application
import unq_ciu.gatoEncerrado.Habitacion
import unq_ciu.gatoEncerrado.Laberinto

class GatoEncerradoApplication extends Application {

	override protected createMainWindow() {
		val hab1 = new Habitacion("Living", false, false)
		val hab2 = new Habitacion("Cocina", false, false)

		val laberinto = new Laberinto("Casa")
		laberinto.agregarHabitacion(hab1)
		laberinto.agregarHabitacion(hab2)

		new WindowsAgregarAccionDeIrAOtraHabitacion(this, laberinto)

	}

	def static main(String[] args) {

		new GatoEncerradoApplication().start
	}

}
