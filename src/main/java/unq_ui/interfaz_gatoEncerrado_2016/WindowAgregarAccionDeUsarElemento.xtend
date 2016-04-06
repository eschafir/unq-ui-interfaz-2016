package unq_ui.interfaz_gatoEncerrado_2016

import unq_ciu.gatoEncerrado.AppModel.AgregarAccionDeUsarElementoAppModel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Button
import unq_ciu.gatoEncerrado.AppModel.AgregarAccionAppModel
import unq_ciu.gatoEncerrado.Habitacion
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.layout.HorizontalLayout

class WindowAgregarAccionDeUsarElemento extends Dialog<AgregarAccionDeUsarElementoAppModel> {

	new(WindowOwner owner, Habitacion hab) {
		super(owner, new AgregarAccionDeUsarElementoAppModel(hab))
	}

	override protected createFormPanel(Panel mainPanel) {
		this.title = "Agregar acción de Usar un elemento"

		new Label(mainPanel) => [
			text = "Seleccione el elemento que puede ser usado"
			height = 30
		]

		new Selector(mainPanel) => [
			allowNull(false)
			/**
			 * TODO
			 */
		]

		new Label(mainPanel).text = "Cree la acción a realizar"

		new Button(mainPanel) => [
			caption = "Agregar acción"
			height = 30
			width = 40
			onClick [|
				val model = new AgregarAccionAppModel(this.modelObject.habitacion)
				new WindowAgregarAccion(this, model).open
			]
		]

		val accionPanel = new Panel(mainPanel)
		accionPanel.layout = new HorizontalLayout

		new Button(accionPanel) => [
			caption = "Cancelar"
			height = 30
			width = 150
			onClick [|
				this.close
			]
		]

		new Button(accionPanel) => [
			caption = "Agregar"
			height = 30
			width = 150
			onClick [|
				/**
				 * TODO
				 */	
			]
		]
	}

}
