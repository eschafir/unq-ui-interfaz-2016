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

class WindowAgregarAccionDeUsarElemento extends Dialog<AgregarAccionDeUsarElementoAppModel> {

	new(WindowOwner owner, Laberinto lab, Habitacion hab) {
		super(owner, new AgregarAccionDeUsarElementoAppModel(lab, hab))
	}

	override protected createFormPanel(Panel mainPanel) {
		this.title = "Agregar acción de Usar un elemento"

		new Label(mainPanel) => [
			text = "Seleccione el elemento que puede ser usado"
			height = 30
		]

		new Selector(mainPanel) => [
			allowNull(false)
			value.bindToProperty("itemSeleccionado")
			(items.bindToProperty("laberinto.itemsDisponibles")).adapter = new PropertyAdapter(Laberinto, "nombre")
			new Label(mainPanel).text = "Cree la acción a realizar"
			new Button(mainPanel) => [
				caption = "Agregar acción"
				height = 30
				width = 40
				onClick [|
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
