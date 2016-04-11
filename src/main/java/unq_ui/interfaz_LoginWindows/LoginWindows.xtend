package unq_ui.interfaz_LoginWindows

import unq_ciu.gatoEncerrado.Login.Login
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import java.awt.Color

class LoginWindows extends SimpleWindow<Login> {

	new(WindowOwner parent, Login model) {
		super(parent, model)
	}

	override protected addActions(Panel actionsPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override protected createFormPanel(Panel mainPanel) {
		this.title = "Acá hay gato encerrado - Inicio de Sesión"

		new Label(mainPanel) => [
			text = "Acá hay gato encerrado..."
			fontSize = 20
			foreground = Color.GRAY
		]

	}

}
