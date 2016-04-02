package unq_ui.interfaz_gatoEncerrado_2016

import org.uqbar.arena.windows.MainWindow
import unq_ciu.gatoEncerrado.Juego
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.VerticalLayout

class WindowsQuitarHabitacion extends MainWindow<Juego> {
	
	new() {
		super(new Juego)
	}
	
	override createContents(Panel mainPanel) {
		this.title = "Quitar acción de ir a otra habitación"
		
		//No es necesario, el layout default es el vertical
		mainPanel.layout = new VerticalLayout
		
		new Button(mainPanel) => [ caption = "Quitar"
			
			//En agregarHabitacion va a ir el parámetro de las opciones de habitaciones que el jugador elija
			onClick [ | this.modelObject.laberinto.agregarHabitacion(null) ]
		]
	}
	
	def static main(String[] args) {
		new WindowsQuitarHabitacion().startApplication
		}
	}
	
