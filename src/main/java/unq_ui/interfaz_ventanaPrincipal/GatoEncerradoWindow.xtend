package unq_ui.interfaz_ventanaPrincipal

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import unq_ciu.gatoEncerrado.Laberinto
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Button
import unq_ui.interfaz_gatoEncerrado_2016.NuevoLaberintoWindow
import org.uqbar.arena.layout.HorizontalLayout
import unq_ciu.gatoEncerrado.AppModel.GatoEncerradoAppModel
import org.uqbar.arena.layout.ColumnLayout
import unq_ciu.gatoEncerrado.Habitacion
import unq_ui.interfaz_gatoEncerrado_2016.NuevaHabitacionWindow
import org.uqbar.arena.widgets.CheckBox
import unq_ciu.gatoEncerrado.Accion
import unq_ui.interfaz_gatoEncerrado_2016.WindowAgregarAccion
import org.uqbar.arena.widgets.TextBox
import java.awt.Color

class GatoEncerradoWindow extends SimpleWindow<GatoEncerradoAppModel> {

	new(WindowOwner parent, GatoEncerradoAppModel model) {
		super(parent, model)
	}

	override protected addActions(Panel actionsPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override protected createFormPanel(Panel mainPanel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override createMainTemplate(Panel mainPanel) {

		this.title = "Acá hay gato encerrado..."

		/**
 		* TITULO DE LA VENTANA
 		*/
		new Label(mainPanel) => [
			text = "Acá hay gato encerrado..."
			fontSize = 20
			//background = Color.BLACK
			foreground = Color.GRAY
		]

		val panelPrincipal = new Panel(mainPanel)
		panelPrincipal.layout = new ColumnLayout(3)

		/**
		 * LADO IZQUIERDO DE LA PANTALLA PRINCIPAL
		 */
		val panelIzquierdo = new Panel(panelPrincipal)
		panelIzquierdo.width = 300
		this.crearListadoDeLaberintos(panelIzquierdo)

		/**
		 * CENTRO DE LA PANTALLA PRINCIPAL
		 */
		val panelCentral = new Panel(panelPrincipal)
		panelCentral.width = 300
		this.crearEdicionDeLaberintoSeleccionado(panelCentral)

		/**
		 * LADO DERECHO DE LA PANTALLA PRINCIPAL
		 */
		val panelDerecho = new Panel(panelPrincipal)
		panelDerecho.width = 300
		this.crearEdicionDeHabitacionSeleccionada(panelDerecho)

	}

	def crearListadoDeLaberintos(Panel owner) {

		/*
		 * LISTA DE LABERINTOS
		 */
		new Label(owner) => [
			text = "Laberintos"
			fontSize = 12
		]

		new List<Laberinto>(owner) => [
			value.bindToProperty("laberintoSeleccionado")
			(items.bindToProperty("juego.laberintos")).adapter = new PropertyAdapter(Laberinto, "nombre")
			height = 150
		]

		/*
		 * BOTONES
		 */
		val botonera = new Panel(owner)
		botonera.layout = new HorizontalLayout

		new Button(botonera) => [
			caption = "Agregar Laberinto"
			onClick [|new NuevoLaberintoWindow(this, this.modelObject.juego).open]
		]

		new Button(botonera) => [
			caption = "Quitar Laberinto"
			onClick [|this.modelObject.eliminarLaberinto]
		]
	}

	def crearEdicionDeLaberintoSeleccionado(Panel owner) {
		val header = new Panel(owner)
		header.layout = new HorizontalLayout

		/*
		 * ENCABEZADO DE HABITACIONES
		 */
		val panelHeader = new Panel(owner)
		panelHeader.layout = new ColumnLayout(2)

		new Label(panelHeader).text = "Habitaciones de:"
		new Label(panelHeader).value.bindToProperty("laberintoSeleccionado.nombre")

		new Label(panelHeader).text = "Laberinto seleccionado:"
		new TextBox(panelHeader) => [
			value.bindToProperty("laberintoSeleccionado.nombre")
			width = 100
		]

		/*
		 * LISTA DE HABITACIONES
		 */
		new List<Habitacion>(owner) => [
			value.bindToProperty("habitacionSeleccionada")
			(items.bindToProperty("laberintoSeleccionado.habitaciones")).adapter = new PropertyAdapter(Habitacion,
				"nombre")
			height = 150
		]

		/*
		 * BOTONES
		 */
		val botonera = new Panel(owner)
		botonera.layout = new HorizontalLayout
		new Button(botonera) => [
			caption = "Nueva Habitacion"
			onClick [|new NuevaHabitacionWindow(this, this.modelObject.laberintoSeleccionado).open]
		]

		new Button(botonera) => [
			caption = "Eliminar Habitacion"
			onClick [|this.modelObject.eliminarHabitacion]
		]

	}

	def crearEdicionDeHabitacionSeleccionada(Panel owner) {
		val header = new Panel(owner)
		header.layout = new HorizontalLayout

		/*
		 * ENCABEZADO DE HABITACION SELECCIONADA
		 */
		val panelHeader = new Panel(owner)
		panelHeader.layout = new ColumnLayout(2)

		new Label(panelHeader).text = "Habitacion seleccionada:"
		new Label(panelHeader).value.bindToProperty("habitacionSeleccionada.nombre")

		new Label(panelHeader) => [
			text = "Nombre:"
			width = 150
		]
		new TextBox(panelHeader) => [
			value.bindToProperty("habitacionSeleccionada.nombre")
			width = 100
		]

		/*
		 * CHECKBOX INICIAL
		 */
		val inicialCheck = new Panel(owner)
		inicialCheck.layout = new HorizontalLayout
		new CheckBox(inicialCheck).value.bindToProperty("habitacionSeleccionada.esInicial")
		new Label(inicialCheck).text = "¿Es Inicial?"

		/*
		 * CHECKBOX FINAL
		 */
		val finalCheck = new Panel(owner)
		finalCheck.layout = new HorizontalLayout
		new CheckBox(finalCheck).value.bindToProperty("habitacionSeleccionada.esFinal")
		new Label(finalCheck) => [
			text = "¿Es Final?"
			height = 23
		]

		/*
		 * LISTA DE ACCIONES DE LA HABITACION SELECCIONADA
		 */
		new Label(owner).text = "Acciones"
		new List<Accion>(owner) => [
			value.bindToProperty("accionSeleccionada")
			(items.bindToProperty("habitacionSeleccionada.acciones")).adapter = new PropertyAdapter(Accion, "nombre")
			height = 73
		]

		/*
		 * BOTONES
		 */
		val botonera = new Panel(owner)
		botonera.layout = new HorizontalLayout

		new Button(botonera) => [
			caption = "Agregar Accion"
			onClick [|
				new WindowAgregarAccion(this, this.modelObject.laberintoSeleccionado,
					this.modelObject.habitacionSeleccionada).open]
		]

		new Button(botonera) => [
			caption = "Quitar Accion"
			onClick [|this.modelObject.quitarAccion]
		]
	}
}
