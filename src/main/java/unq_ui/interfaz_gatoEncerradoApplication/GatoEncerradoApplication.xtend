package unq_ui.interfaz_gatoEncerradoApplication

import org.uqbar.arena.Application
import unq_ciu.gatoEncerrado.AppModel.GatoEncerradoAppModel
import unq_ui.interfaz_ventanaPrincipal.GatoEncerradoWindow
import unq_ciu.gatoEncerrado_DummyData.DummyData

class GatoEncerradoApplication extends Application {

	override protected createMainWindow() {

		val modelo = new GatoEncerradoAppModel => [
			juego = new DummyData().crearJuegoDummy
		]

		new GatoEncerradoWindow(this, modelo)
	}

	def static main(String[] args) {
		new GatoEncerradoApplication().start
	}
}
