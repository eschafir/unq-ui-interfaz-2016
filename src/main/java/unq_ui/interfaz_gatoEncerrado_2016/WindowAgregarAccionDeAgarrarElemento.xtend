package unq_ui.interfaz_gatoEncerrado_2016

import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import unq_ciu.gatoEncerrado.Habitacion
import org.uqbar.arena.widgets.TextBox
import unq_ciu.gatoEncerrado.AppModel.AgregarAccionDeAgarrarElementoAppModel

class WindowAgregarAccionDeAgarrarElemento extends Dialog<AgregarAccionDeAgarrarElementoAppModel> {

	new(WindowOwner owner, Habitacion hab) {
		super(owner, new AgregarAccionDeAgarrarElementoAppModel(hab))
	}

	override protected createFormPanel(Panel mainPanel) {
		this.title = "Agarrar un elemento"
		this.minHeight = 200

		//No es necesario, el layout default es el vertical
		mainPanel.layout = new VerticalLayout
		mainPanel.width = 3000

		new Label(mainPanel) => [
			text = "Indicar el item que se puede agarrar en: " + this.modelObject.habitacion.nombre + "."
		]

		new TextBox(mainPanel) => [
			value.bindToProperty("item.nombre")
		]

		val accionesPanel = new Panel(mainPanel)
		accionesPanel.layout = new HorizontalLayout

		new Button(accionesPanel) => [
			caption = "Aceptar"
			height = 30
			width = 150
			onClick [|
				this.modelObject.agregarAcccionAgarrar
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
