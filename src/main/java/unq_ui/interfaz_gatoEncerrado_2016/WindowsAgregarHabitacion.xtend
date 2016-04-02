package unq_ui.interfaz_gatoEncerrado_2016

import unq_ciu.gatoEncerrado.Juego
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import unq_ciu.gatoEncerrado.Habitacion
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.layout.HorizontalLayout

class WindowsAgregarHabitacion extends MainWindow<Juego> {
	
	new() {
		super(new Juego)
	}
	
	override createContents(Panel mainPanel) {
		this.title = "Agregar acción de ir a otra habitación"
		
		//No es necesario, el layout default es el vertical
		mainPanel.layout = new VerticalLayout
		
		new Label(mainPanel).text = "Selecciona una habitación"
		
		new Button(mainPanel) => [ caption = "Cancelar"
			
			//Hay que ver que hace el cancelar
			onClick [ | this.modelObject.laberinto.agregarHabitacion(null) ]
		]
		
		//mainPanel.layout = new HorizontalLayout
		
		new Button(mainPanel) => [ caption = "Agregar"
			
			//En agregarHabitacion va a ir el parámetro de las opciones de habitaciones que el jugador elija
			onClick [ | this.modelObject.laberinto.agregarHabitacion(null) ]
		]
	}
	
	def static main(String[] args) {
		new WindowsAgregarHabitacion().startApplication
	}
	
}