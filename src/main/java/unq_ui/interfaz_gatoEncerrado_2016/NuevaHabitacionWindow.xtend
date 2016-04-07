package unq_ui.interfaz_gatoEncerrado_2016

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import unq_ciu.gatoEncerrado.AppModel.CrearHabitacionAppModel
import unq_ciu.gatoEncerrado.Laberinto

class NuevaHabitacionWindow extends Dialog<CrearHabitacionAppModel> {

	new(WindowOwner owner, Laberinto model) {
		super(owner, new CrearHabitacionAppModel(model))
	}

	override protected createFormPanel(Panel mainPanel) {
		title = "Nueva Habitacion"
		mainPanel.layout = new VerticalLayout

		new Label(mainPanel).text = "Nombre:"
		new TextBox(mainPanel) => [
			value.bindToProperty("habitacion.nombre")
			width = 200
		]
		new Button(mainPanel) => [
			caption = "Aceptar"
			onClick [|
				this.modelObject.agregarHabitacion
				this.close
			]
		]
	}

}
