package unq_ui.interfaz_gatoEncerrado_2016.Consecuencias

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import unq_ciu.gatoEncerrado.Laberinto
import unq_ciu.gatoEncerrado.Habitacion
import unq_ciu.gatoEncerrado.Item
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.HorizontalLayout
import unq_ciu.gatoEncerrado.Consecuencias.AgregarAccionDeAgarrarUnElementoConsecuenciaAppModel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox

class WindowAgregarAccionDeAgarrarUnElementoConsecuencia extends Dialog<AgregarAccionDeAgarrarUnElementoConsecuenciaAppModel> {

	new(WindowOwner owner, Laberinto lab, Habitacion hab, Item item) {
		super(owner, new AgregarAccionDeAgarrarUnElementoConsecuenciaAppModel(hab, item))
		this.taskDescription = "Consecuencia de usar " + this.modelObject.itemUtilizado.nombre + " en " +
			this.modelObject.habitacion.nombre
	}

	override protected createFormPanel(Panel mainPanel) {
		this.title = this.modelObject.itemUtilizado.nombre + " - Consecuencia: Agarrar elemento."
		this.minHeight = 200
		mainPanel.width = 3000

		new Label(mainPanel) => [
			text = "Indicar el item que se puede agarrar en: " + this.modelObject.habitacion.nombre + "."
		]

		new TextBox(mainPanel) => [
			value.bindToProperty("itemDisponibleComoConsecuencia.nombre")
		]

		val accionesPanel = new Panel(mainPanel)
		accionesPanel.layout = new HorizontalLayout

		new Button(accionesPanel) => [
			caption = "Aceptar"
			height = 30
			width = 150
			onClick [|
				this.modelObject.agregarAccion
				this.close
			]
		]

		new Button(accionesPanel) => [
			caption = "Cancelar"
			height = 30
			width = 150
			onClick [|this.close]
		]
	}
}
