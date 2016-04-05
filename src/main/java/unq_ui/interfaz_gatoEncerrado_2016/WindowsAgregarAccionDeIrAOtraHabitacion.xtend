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

class WindowsAgregarAccionDeIrAOtraHabitacion extends Dialog<AgregarAccionDeIrAOtraHabitacionAppModel> {

	new(WindowOwner owner, Habitacion hab) {
		super(owner, new AgregarAccionDeIrAOtraHabitacionAppModel(hab))
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
			val propiedadModelos = bindItemsToProperty("laberinto.habitaciones")
			propiedadModelos.adaptWith(typeof(Habitacion), "nombre")
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
				//this.modelObject.agregarAccion
				this.close
			]
		]
	}

}
