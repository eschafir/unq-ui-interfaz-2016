package unq_ui.interfaz_gatoEncerrado_2016.Consecuencias

import unq_ciu.gatoEncerrado.Consecuencias.AgregarAccionDeUsarUnElementoConsecuenciaAppModel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import unq_ciu.gatoEncerrado.Laberinto
import unq_ciu.gatoEncerrado.Habitacion
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.bindings.PropertyAdapter
import unq_ciu.gatoEncerrado.Item
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.HorizontalLayout

class WindowAgregarAccionDeUsarUnElementoConsecuencia extends Dialog<AgregarAccionDeUsarUnElementoConsecuenciaAppModel> {

	new(WindowOwner owner, Laberinto lab, Habitacion hab, Item item) {
		super(owner, new AgregarAccionDeUsarUnElementoConsecuenciaAppModel(hab, item, lab))

	}

	override protected createFormPanel(Panel mainPanel) {
		this.title = this.modelObject.itemUtilizado.nombre + " - Consecuencia: Usar otro elemento."

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
					this.modelObject.validarItem(this.modelObject.itemSeleccionado)
					new WindowAgregarAccionConsecuencia(this, this.modelObject.laberinto,
						this.modelObject.habitacion, this.modelObject.itemSeleccionado).open
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
				this.modelObject.agregarAccion
				this.close
			]
		]
	}
}
