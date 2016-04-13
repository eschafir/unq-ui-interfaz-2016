package unq_ui.interfaz_gatoEncerradoApplication

import org.uqbar.arena.Application
import unq_ui.interfaz_LoginWindows.LoginWindows
import unq_ciu.gatoEncerrado.AppModel.LoginAppModel
import unq_ciu.gatoEncerrado.Login.Login
import unq_ciu.gatoEncerrado.Login.Usuario

class LoginApplication extends Application {

	override protected createMainWindow() {

		val Usuario ui = new Usuario("ui2016", "123456")
		val login = new Login()
		login.agregarUsuario(ui)

		val modelo = new LoginAppModel(login)

		new LoginWindows(this, modelo)
	}

	def static main(String[] args) {

		new LoginApplication().start
	}

}
