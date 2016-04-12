package unq_ui.interfaz_gatoEncerrado_2016

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import unq_ciu.gatoEncerrado.AppModel.AgregarAccionConsecuenciaAppModel
import unq_ciu.gatoEncerrado.Laberinto
import unq_ciu.gatoEncerrado.Habitacion
import unq_ciu.gatoEncerrado.Item
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button

class WindowAgregarAccionConsecuencia extends SimpleWindow<AgregarAccionConsecuenciaAppModel> {

	new(WindowOwner parent, Laberinto lab, Habitacion hab, Item item) {
		super(parent, new AgregarAccionConsecuenciaAppModel(lab, hab, item))
	}

	override protected addActions(Panel actionsPanel) {
	}

	override protected createFormPanel(Panel mainPanel) {
		this.title = this.modelObject.habitacion.nombre + ": agregar accion consecuencia."
		this.minHeight = 200
		mainPanel.width = 3000

		new Label(mainPanel).text = "Selecciona una acción consecuencia"

		val accionesPanel = new Panel(mainPanel)
		accionesPanel.layout = new HorizontalLayout

		new Button(accionesPanel) => [
			caption = "Ir a otra habitación"
			height = 30
			width = 150
			onClick [|
				new WindowAgregarAccionDeIrAOtraHabitacionConsecuencia(this, this.modelObject.laberinto,
					this.modelObject.habitacion, this.modelObject.item).open
			]
		]

		new Button(accionesPanel) => [
			caption = "Agarrar un elemento"
			height = 30
			width = 150
			onClick [|
				new WindowAgregarAccionDeAgarrarElementoConsecuencia(this, this.modelObject.habitacion,
					this.modelObject.item).open
			]
		]

		new Button(accionesPanel) => [
			caption = "Usar un elemento"
			height = 30
			width = 150
			onClick [|
				new WindowAgregarAccionDeUsarElementoConsecuencia(this, this.modelObject.laberinto,
					this.modelObject.habitacion, this.modelObject.item).open
			]
		]

		new Button(mainPanel) => [
			caption = "Aceptar"
			onClick [this.close]
		]

	}

}
