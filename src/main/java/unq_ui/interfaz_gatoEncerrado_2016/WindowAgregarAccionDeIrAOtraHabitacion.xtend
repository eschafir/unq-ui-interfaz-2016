package unq_ui.interfaz_gatoEncerrado_2016

import unq_ciu.gatoEncerrado.Habitacion
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Selector
import unq_ciu.gatoEncerrado.AppModel.AgregarAccionDeIrAOtraHabitacionAppModel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.bindings.PropertyAdapter
import unq_ciu.gatoEncerrado.Laberinto

class WindowAgregarAccionDeIrAOtraHabitacion extends Dialog<AgregarAccionDeIrAOtraHabitacionAppModel> {

	new(WindowOwner owner, Laberinto lab,  Habitacion hab) {
		super(owner, new AgregarAccionDeIrAOtraHabitacionAppModel(lab,hab))
	}

	override protected createFormPanel(Panel mainPanel) {
		this.title = "Agregar acción de ir a otra habitación"
		this.minHeight = 200

		//No es necesario, el layout default es el vertical
		mainPanel.layout = new VerticalLayout
		mainPanel.width = 30000

		new Label(mainPanel).text = "Selecciona una habitación"

		new Selector<Habitacion>(mainPanel) => [
			allowNull(false)
			value.bindToProperty("habitacionSeleccionada")
			(items.bindToProperty("laberinto.habitaciones")).adapter = new PropertyAdapter(Habitacion,
				"nombre")
		]

		val accionesPanel = new Panel(mainPanel)
		accionesPanel.layout = new HorizontalLayout

		new Button(mainPanel) => [
			caption = "Cancelar"
			onClick [|this.close]
		]

		new Button(mainPanel) => [
			caption = "Agregar"
			onClick [|
				this.modelObject.agregarAccion
				this.close
			]
		]
	}

}
