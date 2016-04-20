package unq_ui.interfaz_gatoEncerrado_2016.Consecuencias

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import unq_ciu.gatoEncerrado.Item
import unq_ciu.gatoEncerrado.Habitacion
import unq_ciu.gatoEncerrado.Laberinto
import unq_ciu.gatoEncerrado.Consecuencias.AgregarAccionDeIrAOtraHabitacionConsecuenciaAppModel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button

class WindowAgregarAccionDeIrAOtraHabitacionConsecuencia extends Dialog<AgregarAccionDeIrAOtraHabitacionConsecuenciaAppModel> {

	new(WindowOwner owner, Laberinto lab, Habitacion hab, Item item) {
		super(owner, new AgregarAccionDeIrAOtraHabitacionConsecuenciaAppModel(lab, hab, item))
		this.taskDescription = "Consecuencia de usar " + this.modelObject.item.nombre + " en " +
			this.modelObject.habitacion.nombre
	}

	override protected createFormPanel(Panel mainPanel) {
		this.title = this.modelObject.item.nombre + " - Consecuencia: Ir a otra habitacion"

		this.minHeight = 200

		new Label(mainPanel) => [
			text = this.modelObject.habitacion.nombre + " -> ir hacia:"
			width = 200
		]

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
				this.modelObject.agregarAccion
				this.close
			]
		]
		new Button(accionesPanel) => [
			caption = "Cancelar"
			onClick [|this.close]
		]
	}

}
