package unq_ui.interfaz_gatoEncerradoApplication

import org.uqbar.arena.Application
import unq_ui.interfaz_LoginWindows.LoginWindows
import unq_ciu.gatoEncerrado.AppModel.LoginAppModel
import unq_ciu.gatoEncerrado.Login.Usuario
import unq_ciu.gatoEncerrado_DummyData.DummyData

class LoginApplication extends Application {

	override protected createMainWindow() {

		val model = new LoginAppModel => [
			login = new DummyData().crearLoginDummy
			usuarioIngresado = new Usuario()
		]

		new LoginWindows(this, model)
	}

	def static main(String[] args) {

		new LoginApplication().start
	}

}
