package unq_ui.interfaz_gatoEncerrado_2016

import unq_ciu.gatoEncerrado.AppModel.AgregarAccionDeUsarElementoAppModel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Button
import unq_ciu.gatoEncerrado.AppModel.AgregarAccionAppModel
import unq_ciu.gatoEncerrado.Habitacion

class WindowAgregarAccionDeUsarElemento extends Dialog<AgregarAccionDeUsarElementoAppModel> {

	new(WindowOwner owner, Habitacion hab) {
		super(owner, new AgregarAccionDeUsarElementoAppModel(hab))
	}

	override protected createFormPanel(Panel mainPanel) {
		this.title = "Agregar acción de Usar un elemento"
		this.minHeight = 200
		mainPanel.width = 3000

		new Label(mainPanel).text = "Seleccione el elemento que puede ser usado"

		new Label(mainPanel).text = "Cree la acción a realizar"

		new Button(mainPanel) => [
			caption = "Agregar acción"
			height = 30
			width = 150
			onClick [|
				val model = new AgregarAccionAppModel
				new WindowAgregarAccion(this, model).open
			]
		]

		new Button(mainPanel) => [
			caption = "Cancelar"
			height = 30
			width = 150
			onClick [|
				this.close
			]
		]

		new Button(mainPanel) => [
			caption = "Agregar"
			height = 30
			width = 150
			onClick [|
	
			]
		]
	}

}
