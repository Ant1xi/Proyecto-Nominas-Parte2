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
import vista.VentanaListarEmpleados;
import vista.alertas.Alertas;

public class ControladorVentanaListarEmpleados {

	private VentanaListarEmpleados ventana;

	public ControladorVentanaListarEmpleados(VentanaListarEmpleados ventana, Stage stage) {

		this.ventana = ventana;
	}

	public void prepararControlador() {
		ventana.setEmpleados(obtenerTablaEmpleados());
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
