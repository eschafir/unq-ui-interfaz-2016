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
		new Label(mainPanel).text = "Acá hay gato encerrado..."

		this.crearListadoDeLaberintos(mainPanel)
		this.crearEdicionDeLaberintoSeleccionado(mainPanel)

	}

	def crearListadoDeLaberintos(Panel owner) {
		new Label(owner).text = "Laberintos"
		new List<Laberinto>(owner) => [
			value.bindToProperty("laberintoSeleccionado")
			(items.bindToProperty("juego.laberintos")).adapter = new PropertyAdapter(Laberinto, "nombre")
		]
		new Button(owner) => [
			caption = "Agregar Laberinto"
			onClick [|new NuevoLaberintoWindow(this, this.modelObject.juego).open]
		]

		new Button(owner) => [
			caption = "Quitar Laberinto"
			onClick [
				this.modelObject.eliminarLaberinto
			]
		]
	}

	def crearEdicionDeLaberintoSeleccionado(Panel owner) {
		val header = new Panel(owner)
		header.layout = new HorizontalLayout

		new Label(header).text = "Habitaciones de:"
		new Label(header).value.bindToProperty("laberintoSeleccionado.nombre")

	}

}
