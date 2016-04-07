package unq_ui.interfaz_gatoEncerrado_2016

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import unq_ciu.gatoEncerrado.Juego
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import unq_ciu.gatoEncerrado.AppModel.CrearLaberintoAppModel
import org.uqbar.arena.widgets.Button

class NuevoLaberintoWindow extends Dialog<CrearLaberintoAppModel> {

	new(WindowOwner owner, Juego model) {
		super(owner, new CrearLaberintoAppModel(model))
	}

	override protected createFormPanel(Panel mainPanel) {
		title = "Nuevo Laberinto"
		mainPanel.layout = new VerticalLayout

		new Label(mainPanel).text = "Nombre:"
		new TextBox(mainPanel) => [
			value.bindToProperty("laberinto.nombre")
			width = 200
		]
		new Button(mainPanel) => [
			caption = "Aceptar"
			onClick [|
				this.modelObject.agregarLaberinto
				this.close
			]
		]
	}

}
