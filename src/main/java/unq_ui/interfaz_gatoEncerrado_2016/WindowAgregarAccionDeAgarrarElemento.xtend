package unq_ui.interfaz_gatoEncerrado_2016

import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import unq_ciu.gatoEncerrado.AppModel.AgregarAccionDeAgarrarElementoAppModel
import unq_ciu.gatoEncerrado.Habitacion
import org.uqbar.arena.widgets.TextBox

class WindowAgregarAccionDeAgarrarElemento extends Dialog<AgregarAccionDeAgarrarElementoAppModel> {

	new(WindowOwner owner, Habitacion hab) {
		super(owner, new AgregarAccionDeAgarrarElementoAppModel(hab))
	}

	override protected createFormPanel(Panel mainPanel) {
		this.title = "Agregar acción de Agarrar un elemento"
		this.minHeight = 200

		//No es necesario, el layout default es el vertical
		mainPanel.layout = new VerticalLayout
		mainPanel.width = 3000

		new Label(mainPanel).text = "Escriba el elemento que aparecerá en la habitación"

		new TextBox(mainPanel) => [
			value
			bindValueToProperty("item.nombre")
		]

		val accionesPanel = new Panel(mainPanel)
		accionesPanel.layout = new HorizontalLayout

		new Button(accionesPanel) => [
			caption = "Cancelar"
			height = 30
			width = 150
			onClick [|this.close]
		]

		new Button(accionesPanel) => [
			caption = "Agregar"
			height = 30
			width = 150
			onClick [|
				this.modelObject.agregarAcccionAgarrar
				this.close
			]
		]
	}
}
