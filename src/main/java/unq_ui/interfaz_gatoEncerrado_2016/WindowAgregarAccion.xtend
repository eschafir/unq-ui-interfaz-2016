package unq_ui.interfaz_gatoEncerrado_2016

import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import unq_ciu.gatoEncerrado.AppModel.AgregarAccionAppModel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner

class WindowAgregarAccion extends SimpleWindow<AgregarAccionAppModel> {

	new(WindowOwner parent, AgregarAccionAppModel model) {
		super(parent, model)
	}

	override protected addActions(Panel actionsPanel) {
		//No utilizamos este template.
	}

	override protected createFormPanel(Panel mainPanel) {
		this.title = "Agregar acciones a la habitacion"
		this.minHeight = 200

		//No es necesario, el layout default es el vertical
		mainPanel.layout = new VerticalLayout
		mainPanel.width = 3000

		new Label(mainPanel).text = "Selecciona una acción a agregar"

		val accionesPanel = new Panel(mainPanel)
		accionesPanel.layout = new HorizontalLayout

		new Button(accionesPanel) => [
			caption = "Ir a otra habitación"
			height = 30
			width = 150
			onClick [|
				new WindowAgregarAccionDeIrAOtraHabitacion(this, this.modelObject.habitacionActual).open
			]
		]

		new Button(accionesPanel) => [
			caption = "Agarrar un elemento"
			height = 30
			width = 150
			onClick [|
				new WindowAgregarAccionDeAgarrarElemento(this, this.modelObject.habitacionActual).open
			]
		]

		new Button(accionesPanel) => [
			caption = "Usar un elemento"
			height = 30
			width = 150
			onClick [|
				new WindowAgregarAccionDeUsarElemento(this, this.modelObject.habitacionActual).open
			]
		]

		new Button(mainPanel) => [
			caption = "Cancelar"
			onClick [|this.close]
		]
	}

}
