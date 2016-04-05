package unq_ui.interfaz_gatoEncerrado_2016

import org.uqbar.arena.Application
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Window
import unq_ciu.gatoEncerrado.AppModel.AgregarAccionAppModel
import unq_ciu.gatoEncerrado.Laberinto

class WindowAgregarAccionD extends Window<AgregarAccionAppModel> {

	new(Application app, Laberinto laberinto) {
		super(app, new AgregarAccionAppModel(laberinto))
	}

	override createContents(Panel mainPanel) {
		this.title = "Agregar acción"
		this.minHeight = 200
		
		//No es necesario, el layout default es el vertical
		mainPanel.layout = new VerticalLayout
		mainPanel.width = 3000
		
		new Label(mainPanel).text = "Selecciona una acción a agregar"

		val accionesPanel = new Panel(mainPanel)
		accionesPanel.layout = new HorizontalLayout

		val otrahabitacion = new Button(accionesPanel)
		otrahabitacion.caption = "Agregar acción de ir a otra habitación"
		otrahabitacion.height = 30
		otrahabitacion.width = 70
		
		val agarrar = new Button(accionesPanel)
		agarrar.caption = "Agregar acción de Agarrar un elemento"
		agarrar.height = 30
		agarrar.width = 70
		
		val usar = new Button(accionesPanel)
		usar.caption = "Agregar acción de Usar un elemento"
		usar.height = 30
		usar.width = 70
	}
}