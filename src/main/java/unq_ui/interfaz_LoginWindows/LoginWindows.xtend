package unq_ui.interfaz_LoginWindows

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import java.awt.Color
import unq_ciu.gatoEncerrado.AppModel.LoginAppModel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.HorizontalLayout

class LoginWindows extends SimpleWindow<LoginAppModel> {

	new(WindowOwner parent, LoginAppModel model) {
		super(parent, model)
		this.taskDescription = "Bienvenido al Gato Encerrado 2.0"
	}
	

	override protected addActions(Panel actionsPanel) {}

	override protected createFormPanel(Panel mainPanel) {
		this.title = "Acá hay gato encerrado - Inicio de Sesión"

		new Label(mainPanel) => [
			text = "Acá hay gato encerrado..."
			fontSize = 20
			foreground = Color.GRAY
		]
	
		val panelPrincipal = new Panel(mainPanel)
		panelPrincipal.layout = new ColumnLayout(1)
		
		crearPanelLogin(panelPrincipal)
	}
	
	def crearPanelLogin(Panel owner) {
		
		val panelHeader = new Panel(owner)
		panelHeader.layout = new ColumnLayout(2)

		new Label(panelHeader).text = "Username:"

		new TextBox(panelHeader) => [
			width = 50
		]
		
		new Label(panelHeader) => [ 
			text = "Password:"
		]	
		
		new TextBox(panelHeader) => [
			width = 50
		]
		
		//Botones Cancel y Login
		val botonera = new Panel(owner)
		botonera.layout = new HorizontalLayout
		
		new Button(botonera) => [
			caption = "Cancel"
			width = 65
			onClick [|
				this.close
			]
		]
		
		
		new Button(botonera) => [
			caption = "Login"
			width = 65
			onClick [|
				this.modelObject.validarUsuario()
				//this.modelObject.quitarAccion
			]
		]
		
		}
	}
