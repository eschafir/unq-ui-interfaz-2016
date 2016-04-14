package unq_ui.interfaz_LoginWindows

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import unq_ciu.gatoEncerrado.AppModel.LoginAppModel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.HorizontalLayout
import unq_ui.interfaz_ventanaPrincipal.GatoEncerradoWindow
import unq_ciu.gatoEncerrado.AppModel.GatoEncerradoAppModel
import unq_ciu.gatoEncerrado_DummyData.DummyData
import org.uqbar.arena.widgets.PasswordField

class LoginWindows extends SimpleWindow<LoginAppModel> {

	new(WindowOwner parent, LoginAppModel model) {
		super(parent, model)
		this.taskDescription = "Gato Encerrado 2.0"
	}

	override protected addActions(Panel actionsPanel) {}

	override protected createFormPanel(Panel mainPanel) {
		this.title = "Inicio de Sesión"

		new Label(mainPanel) => [
			text = "Ingrese sus credenciales"
			fontSize = 15
			height = 30
		]

		crearPanelLogin(mainPanel)
		crearBotonera(mainPanel)
	}

	/**
	 * Este método genera la interfaz del login.
	 */
	def crearPanelLogin(Panel owner) {

		val panelHeader = new Panel(owner)
		panelHeader.layout = new ColumnLayout(2)

		new Label(panelHeader).text = "Usuario:"

		new TextBox(panelHeader) => [
			width = 70
			value.bindToProperty("usuarioIngresado.username")
		]

		new Label(panelHeader) => [
			text = "Contraseña:"
		]

		new PasswordField(panelHeader) => [
			width = 70
			value.bindToProperty("claveIngresada")
		]

	}

	/**
	 * Este método genera los 2 botones "Login" y "Cancelar" de la pantalla de credenciales.
	 * Si se verifica el usuario correctamente, al pulsar sobre login se abre una pantalla principal de Gato Encerrado.
	 */
	def crearBotonera(Panel owner) {
		val botonera = new Panel(owner)
		botonera.layout = new HorizontalLayout

		new Button(botonera) => [
			caption = "Login"
			width = 65
			onClick [|
				val modelo = new GatoEncerradoAppModel => [
					juego = new DummyData().crearJuegoDummy
					usuario = this.modelObject.usuarioIngresado
				]
				this.modelObject.validarUsuarioYClave
				new GatoEncerradoWindow(this, modelo).open
			]
		]

		new Button(botonera) => [
			caption = "Cancelar"
			width = 65
			onClick [|
				this.close
			]
		]
	}
}
