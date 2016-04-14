package unq_ui.interfaz_gatoEncerrado_2016.Consecuencias

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import unq_ciu.gatoEncerrado.Laberinto
import unq_ciu.gatoEncerrado.Habitacion
import unq_ciu.gatoEncerrado.Item
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.bindings.PropertyAdapter
import unq_ciu.gatoEncerrado.Consecuencias.AgregarAccionDeAgarrarUnElementoConsecuenciaAppModel

class WindowAgregarAccionDeAgarrarUnElementoConsecuencia extends Dialog<AgregarAccionDeAgarrarUnElementoConsecuenciaAppModel> {

	new(WindowOwner owner, Laberinto lab, Habitacion hab, Item item) {
		super(owner, new AgregarAccionDeAgarrarUnElementoConsecuenciaAppModel(lab, hab, item))
		this.taskDescription = "Consecuencia de agarrar " + this.modelObject.item.nombre + " en " +
			this.modelObject.habitacion.nombre
	}

	override protected createFormPanel(Panel mainPanel) {
		this.title = "Consecuencia - Agarrar un elemento"
		this.minHeight = 200


		new Selector<Habitacion>(mainPanel) => [
			allowNull(false)
			value.bindToProperty("habitacionSeleccionada")
			(items.bindToProperty("habitacionesDisponibles")).adapter = new PropertyAdapter(Habitacion, "nombre")
		]

		val accionesPanel = new Panel(mainPanel)
		accionesPanel.layout = new HorizontalLayout

		new Button(accionesPanel) => [
			caption = "Aceptar"
			onClick [|
				this.modelObject.agregarConsecuencia
				this.close
			]
		]
		
		new Button(accionesPanel) => [
			caption = "Cancelar"
			onClick [|this.close]
		]
	}
}
