package controlador;

import dao.EmpleadoDAO;
import excepciones.EmpleadoDataException;
import excepciones.FormatoDniException;
import excepciones.FormatoSexoException;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import laboral.Nomina;
import modelos.EmpleadoModelo;
import vista.VentanaConsultarSalario;
import vista.alertas.Alertas;

public class ControladorVentanaConsultarSalario {

	private VentanaConsultarSalario ventana;

	public ControladorVentanaConsultarSalario(VentanaConsultarSalario ventana, Stage stage) {

		this.ventana = ventana;
	}

	public void prepararControlador() {
		ventana.getBtnConsultar().setOnAction(e -> buscarSalarioEmpleado());
	}

	public void buscarSalarioEmpleado() {
		TextField txtDni = ventana.getTxtDni();
		Label lblSalario = ventana.getLblSalarioObtenido();

		String dni = txtDni.getText().trim();

		if (dni.isBlank()) {
			Alertas.mostrarAdvertencia("DNI incompleto",
					"Para poder consultar el salario de un empleado primero debes de introducir su correspondiente dni");
			return;
		}

		if (!dni.matches("^\\d{8}[A-Z]$")) {
			Alertas.mostrarAdvertencia("Formato DNI incorrecto",
					"El dni debe estar compuesto por 8 números seguidos de una letra en mayúscula.");
			txtDni.setText("");
			return;
		}

		try {
			EmpleadoModelo e = new EmpleadoDAO().getEmpleadoByDni(dni);

			if (e != null) {
				Double salario = Nomina.sueldo(e);
				lblSalario.setText("Salario: " + salario + "€");
			} else {
				Alertas.mostrarError("Error: ", "No se ha encontrado ningún emplado con dni: " + dni);
				txtDni.setText("");
			}

		} catch (FormatoDniException | EmpleadoDataException | FormatoSexoException e) {
			Alertas.mostrarError("Error al recibir empleado", e.getMessage());
			e.printStackTrace();
		}
	}

}
