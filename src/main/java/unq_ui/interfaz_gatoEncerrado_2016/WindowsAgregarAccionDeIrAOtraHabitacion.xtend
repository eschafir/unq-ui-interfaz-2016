package unq_ui.interfaz_gatoEncerrado_2016

import unq_ciu.gatoEncerrado.Habitacion
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Selector
import unq_ciu.gatoEncerrado.AppModel.AgregarAccionDeIrAOtraHabitacionAppModel

class WindowsAgregarAccionDeIrAOtraHabitacion extends MainWindow<AgregarAccionDeIrAOtraHabitacionAppModel> {

	new() {
		super(new AgregarAccionDeIrAOtraHabitacionAppModel)
	}

	override createContents(Panel mainPanel) {
		this.title = "Agregar acción de ir a otra habitación"
		this.minHeight = 200

		//No es necesario, el layout default es el vertical
		mainPanel.layout = new VerticalLayout

		new Label(mainPanel).text = "Selecciona una habitación"

		new Selector<Habitacion>(mainPanel) => [
			allowNull(false)
			value.bindToProperty("habitacionSeleccionada")
			val propiedadModelos = bindItemsToProperty("laberinto.habitaciones")
			propiedadModelos.adaptWith(typeof(Habitacion), "nombre")
		]

		val accionesPanel = new Panel(mainPanel)
		accionesPanel.layout = new HorizontalLayout

		val cancelar = new Button(accionesPanel)
		cancelar.caption = "Cancelar"
		cancelar.height = 30
		cancelar.width = 70

		//¿Cuando se clickea Cancelar que se hace?
		cancelar.onClick(null)

		val agregar = new Button(accionesPanel)
		agregar.caption = "Agregar"
		agregar.height = 30
		agregar.width = 70

		//Se le tiene que pasar por parámetro la habitación que se elija
		agregar.onClick(null)

	}

	def static main(String[] args) {
		new WindowsAgregarAccionDeIrAOtraHabitacion().startApplication
	}

}
