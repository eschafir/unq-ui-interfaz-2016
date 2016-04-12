package unq_ui.interfaz_gatoEncerradoApplication
import org.uqbar.arena.Application
import unq_ui.interfaz_LoginWindows.LoginWindows
import unq_ciu.gatoEncerrado.AppModel.LoginAppModel

class LoginApplication extends Application {
	
	override protected createMainWindow() {
		
		val modelo = new LoginAppModel
		
		new LoginWindows(this, modelo)
	}
	
	def static main(String[] args) {
		new LoginApplication().start
	}
	
}