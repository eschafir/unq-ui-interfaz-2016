package unq_ui.interfaz_gatoEncerrado_2016

import org.uqbar.arena.Application
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.Window
import unq_ciu.gatoEncerrado.AppModel.AgregarAccionDeAgarrarElementoAppModel
import unq_ciu.gatoEncerrado.Laberinto

class WindowAgregarAccionDeAgarrarElemento extends Window<AgregarAccionDeAgarrarElementoAppModel> {

	new(Application app, Laberinto laberinto) {
		super(app, new AgregarAccionDeAgarrarElementoAppModel(laberinto))
	}

	override createContents(Panel mainPanel) {
		this.title = "Agregar acción de Agarrar un elemento"
		this.minHeight = 200
		
		//No es necesario, el layout default es el vertical
		mainPanel.layout = new VerticalLayout
		mainPanel.width = 3000
		
		new Label(mainPanel).text = "Escriba el elemento que aparecerá en la habitación"

		new TextBox(mainPanel).bindValueToProperty("")

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
}
