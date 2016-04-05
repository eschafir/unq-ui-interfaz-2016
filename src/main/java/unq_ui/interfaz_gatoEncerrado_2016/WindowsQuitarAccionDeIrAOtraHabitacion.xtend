package unq_ui.interfaz_gatoEncerrado_2016

import org.uqbar.arena.windows.MainWindow
import unq_ciu.gatoEncerrado.Juego
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Selector
import unq_ciu.gatoEncerrado.Habitacion

class WindowsQuitarAccionDeIrAOtraHabitacion extends MainWindow<Juego> {

	new() {
		super(new Juego)
	}

	override createContents(Panel mainPanel) {

		this.title = "Quitar acción de ir a otra habitación"

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

		val quitar = new Button(accionesPanel)
		quitar.caption = "Quitar"

		//Se le tiene que pasar por parámetro la habitación que se elija
		quitar.onClick(null)
	}

	def static main(String[] args) {
		new WindowsQuitarAccionDeIrAOtraHabitacion().startApplication
	}
}
