package unq_ui.interfaz_gatoEncerrado_2016

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import unq_ciu.gatoEncerrado.Juego
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import unq_ciu.gatoEncerrado.AppModel.CrearLaberintoAppModel
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.HorizontalLayout

class NuevoLaberintoWindow extends Dialog<CrearLaberintoAppModel> {

	new(WindowOwner owner, Juego model) {
		super(owner, new CrearLaberintoAppModel(model))
	}

	override protected createFormPanel(Panel mainPanel) {
		title = "Nuevo Laberinto"
		mainPanel.layout = new VerticalLayout

		new Label(mainPanel) => [
			text = "Ingrese el nombre del laberinto"
			height = 30
			fontSize = 10
		]
		new TextBox(mainPanel) => [
			value.bindToProperty("laberinto.nombre")
			width = 200
		]

		val botonera = new Panel(mainPanel)
		botonera.layout = new HorizontalLayout

		new Button(botonera) => [
			caption = "Aceptar"
			onClick [|
				this.modelObject.agregarLaberinto
				this.close
			]
		]

		new Button(botonera) => [
			caption = "Cancelar"
			onClick [this.close]
		]
	}

}
