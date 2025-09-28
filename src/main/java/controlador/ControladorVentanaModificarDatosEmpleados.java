package controlador;

import java.util.List;

import dao.EmpleadoDAO;
import excepciones.EmpleadoDataException;
import excepciones.FormatoDniException;
import excepciones.FormatoSexoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import modelos.EmpleadoModelo;
import vista.SubVentanaModificarEmpleado;
import vista.VentanaModificarDatosEmpleado;
import vista.alertas.Alertas;

public class ControladorVentanaModificarDatosEmpleados {
	private VentanaModificarDatosEmpleado ventana;

	public ControladorVentanaModificarDatosEmpleados(VentanaModificarDatosEmpleado ventana, Stage stage) {
		super();
		this.ventana = ventana;
	}

	public void prepararControlador() {
		ventana.setEmpleados(obtenerTablaEmpleados());
		ventana.getBtnModificar().setOnAction(e -> abrirSubVentanaModificarEmpleados());
	}

	public void abrirSubVentanaModificarEmpleados() {

		EmpleadoModelo empleado = ventana.getLista().getSelectionModel().getSelectedItem();

		if (empleado != null) {

			SubVentanaModificarEmpleado vistaSubModificarEmpleado = new SubVentanaModificarEmpleado();
			ControladorSubVentanaModificarEmpleado ctrlSubVentanaModificarEmpleado = new ControladorSubVentanaModificarEmpleado(
					vistaSubModificarEmpleado, vistaSubModificarEmpleado.getStageSubVentanaModificarEmpleados(),
					ventana.getLista());

			ctrlSubVentanaModificarEmpleado.prepararControlador(empleado);

		} else {
			Alertas.mostrarAdvertencia("Sin elementos",
					"Debes de seleccionar antes el empleado que quieres modificar.");
		}

	}

	public ObservableList<EmpleadoModelo> obtenerTablaEmpleados() {
		List<EmpleadoModelo> listaEmpleados = null;
		ObservableList<EmpleadoModelo> obs = null;

		try {
			listaEmpleados = new EmpleadoDAO().getAll();
			obs = FXCollections.observableArrayList(listaEmpleados);

		} catch (FormatoDniException | EmpleadoDataException | FormatoSexoException e) {
			Alertas.mostrarError("Error al cargar la lista", e.getMessage());
			e.printStackTrace();
		}

		return obs;
	}

}
