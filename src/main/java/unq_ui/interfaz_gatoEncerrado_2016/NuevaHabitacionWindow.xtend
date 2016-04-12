package unq_ui.interfaz_gatoEncerrado_2016

import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import unq_ciu.gatoEncerrado.AppModel.CrearHabitacionAppModel
import unq_ciu.gatoEncerrado.Laberinto
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.windows.Dialog

class NuevaHabitacionWindow extends Dialog<CrearHabitacionAppModel> {

	new(WindowOwner owner, Laberinto model) {
		super(owner, new CrearHabitacionAppModel(model))
	}

	override protected createFormPanel(Panel mainPanel) {

		title = this.modelObject.laberinto.nombre + ": agregar habitacion"
		mainPanel.layout = new VerticalLayout

		new Label(mainPanel) => [
			text = "Ingrese el nombre de la habitacion"
			height = 30
			fontSize = 10
		]

		new TextBox(mainPanel) => [
			value.bindToProperty("habitacion.nombre")
			width = 200
		]

		val inicialFinal = new Panel(mainPanel)
		inicialFinal.layout = new HorizontalLayout

		val inicialCheck = new Panel(inicialFinal)
		inicialCheck.layout = new HorizontalLayout
		new CheckBox(inicialCheck).value.bindToProperty("habitacion.esInicial")
		new Label(inicialCheck).text = "¿Es Inicial?"

		val finalCheck = new Panel(inicialFinal)
		finalCheck.layout = new HorizontalLayout
		new CheckBox(finalCheck).value.bindToProperty("habitacion.esFinal")
		new Label(finalCheck).text = "¿Es Final?"

		val botonera = new Panel(mainPanel)
		botonera.layout = new HorizontalLayout

		new Button(botonera) => [
			caption = "Aceptar"
			onClick [|
				this.modelObject.verificar
				this.modelObject.agregarHabitacion
				this.close
			]
		]

		new Button(botonera) => [
			caption = "Cancelar"
			onClick [|
				this.cancel
			]
		]
	}

}
