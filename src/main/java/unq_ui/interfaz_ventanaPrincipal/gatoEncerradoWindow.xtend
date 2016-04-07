package unq_ui.interfaz_ventanaPrincipal

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import unq_ciu.gatoEncerrado.AppModel.gatoEncerradoAppModel
import org.uqbar.arena.widgets.Label
import unq_ciu.gatoEncerrado.Laberinto
import java.util.List
import org.uqbar.arena.bindings.PropertyAdapter

class gatoEncerradoWindow extends SimpleWindow<gatoEncerradoAppModel> {

	new(WindowOwner parent, gatoEncerradoAppModel model) {
		super(parent, model)
	}

	override protected addActions(Panel actionsPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override protected createFormPanel(Panel mainPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override createMainTemplate(Panel mainPanel) {

		this.title = "Acá hay gato encerrado..."
		new Label(mainPanel).text = "Acá hay gato encerrado..."

		this.crearListadoDeLaberintos(mainPanel)
		this.crearEdicionDeLaberintoSeleccionado(mainPanel)

	}

	def crearListadoDeLaberintos(Panel owner) {
		new Label(owner).text = "Laberintos"
		new List<Laberinto>(owner) => [
			//value.
			//value bind "laberintoSeleccionado"
			//(items <=> "juego.laberintos").adapter = new PropertyAdapter(Laberinto, "nombre")
		]
	}

	def crearEdicionDeLaberintoSeleccionado(Panel panel) {
	}

}
