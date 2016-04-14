package unq_ui.interfaz_gatoEncerrado_2016

import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import unq_ciu.gatoEncerrado.AppModel.AgregarAccionDeUsarElementoAppModel
import unq_ciu.gatoEncerrado.Habitacion
import unq_ciu.gatoEncerrado.Laberinto
import unq_ui.interfaz_gatoEncerrado_2016.Consecuencias.WindowAgregarAccionConsecuencia
import unq_ciu.gatoEncerrado.Item

class WindowAgregarAccionDeUsarElemento extends Dialog<AgregarAccionDeUsarElementoAppModel> {

	new(WindowOwner owner, Laberinto lab, Habitacion hab) {
		super(owner, new AgregarAccionDeUsarElementoAppModel(lab, hab))
	}

	override protected createFormPanel(Panel mainPanel) {
		this.title = "Usar un elemento"

		new Label(mainPanel) => [
			text = "Seleccione el elemento que puede ser usado"
			height = 30
		]

		new Selector(mainPanel) => [
			allowNull(false)
			value.bindToProperty("itemSeleccionado")
			(items.bindToProperty("itemsDisponibles")).adapter = new PropertyAdapter(Item, "nombre")
			new Label(mainPanel) => [
				height = 20
			]
			new Button(mainPanel) => [
				caption = "Definir acción consecuencia"
				height = 30
				width = 40
				onClick [|
					this.modelObject.validarItem
					new WindowAgregarAccionConsecuencia(this, this.modelObject.laberinto, this.modelObject.habitacion,
						this.modelObject.itemSeleccionado).open
				]
			]
		]
		val accionPanel = new Panel(mainPanel)
		accionPanel.layout = new HorizontalLayout
		new Button(accionPanel) => [
			caption = "Aceptar"
			height = 30
			width = 150
			onClick [|
				this.close
			]
		]

	}
}
