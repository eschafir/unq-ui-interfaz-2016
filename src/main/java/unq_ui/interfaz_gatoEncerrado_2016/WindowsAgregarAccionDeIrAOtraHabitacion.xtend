package unq_ui.interfaz_gatoEncerrado_2016

import unq_ciu.gatoEncerrado.Juego
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import unq_ciu.gatoEncerrado.Habitacion
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.layout.HorizontalLayout

class WindowsAgregarAccionDeIrAOtraHabitacion extends MainWindow<Juego> {
	
	new() {
		super(new Juego)
	}
	
	override createContents(Panel mainPanel) {
		this.title = "Agregar acción de ir a otra habitación"
		
		//No es necesario, el layout default es el vertical
		mainPanel.layout = new VerticalLayout
		
		new Label(mainPanel).text = "Selecciona una habitación"
		
		val accionesPanel = new Panel(mainPanel)
		accionesPanel.layout = new HorizontalLayout
		
		val cancelar = new Button(accionesPanel)
		cancelar.caption = "Cancelar"
		
		//¿Cuando se clickea Cancelar que se hace?
		cancelar.onClick(null)

		
		val agregar = new Button(accionesPanel)
		agregar.caption = "Agregar"
		
		//Se le tiene que pasar por parámetro la habitación que se elija
		agregar.onClick(null)
		
	}
	
	def static main(String[] args) {
		new WindowsAgregarAccionDeIrAOtraHabitacion().startApplication
	}
	
}