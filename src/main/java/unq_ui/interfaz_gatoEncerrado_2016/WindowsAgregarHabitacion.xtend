package unq_ui.interfaz_gatoEncerrado_2016

import unq_ciu.gatoEncerrado.Juego
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import unq_ciu.gatoEncerrado.Habitacion

class WindowsAgregarHabitacion extends MainWindow<Juego> {
	
	new(Juego model) {
		super(model)
	}
	
	override createContents(Panel mainPanel) {
		this.title = "Agregar acción de ir a otra habitación"
		
		//No es necesario, el layout default es el vertical
		mainPanel.layout = new VerticalLayout
		
		new Button(mainPanel) => [ caption = "Agregar"
			
			//En agregarHabitacion va a ir el parámetro de las opciones de habitaciones que el jugador elija
			onClick [ | this.modelObject.laberinto.agregarHabitacion(null) ]
		]
	}
	
}