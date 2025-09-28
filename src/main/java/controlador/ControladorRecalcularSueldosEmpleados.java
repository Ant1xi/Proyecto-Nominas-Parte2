package controlador;

import java.util.List;

import dao.EmpleadoDAO;
import dao.NominaDAO;
import excepciones.EmpleadoDataException;
import excepciones.FormatoDniException;
import excepciones.FormatoSexoException;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import laboral.Nomina;
import modelos.EmpleadoModelo;
import vista.VentanaRecalcularSueldosEmpleado;
import vista.alertas.Alertas;

public class ControladorRecalcularSueldosEmpleados {

	private VentanaRecalcularSueldosEmpleado ventana;
	private Stage stage;

	public ControladorRecalcularSueldosEmpleados(VentanaRecalcularSueldosEmpleado ventana, Stage stage) {

		this.ventana = ventana;
		this.stage = stage;
	}

	public void prepararControlador() {
		ventana.getBtnConfirmar().setOnAction(e -> operacionConfirmada());
		ventana.getBtnCancelar().setOnAction(e -> operacionCancelada());
	}

	public void operacionConfirmada() {
		ventana.getBtnConfirmar().setDisable(true);
		ventana.getBtnCancelar().setDisable(true);

		int empleadosTotales = 0;
		int empleadosSinModificar = 0;
		int sueldosActualizados = 0;
		int nominasCreadas = 0;
		int fallos = 0;

		try {
			List<EmpleadoModelo> listaEmpleados = new EmpleadoDAO().getAll();
			empleadosTotales = listaEmpleados.size();

			for (EmpleadoModelo empleado : listaEmpleados) {
				if (empleado != null) {
					Double sueldoRegistrado = new NominaDAO().recogerSueldoEmpleado(empleado);
					Double sueldoEmpleado = Nomina.sueldo(empleado);

					if (sueldoRegistrado != null) {
						if (sueldoEmpleado.equals(sueldoRegistrado)) {
							empleadosSinModificar++;
						} else {
							int filas = new NominaDAO().actualizarSueldoEmpleado(empleado);

							if (filas == 1) {
								sueldosActualizados++;
							} else {
								fallos++;
							}
						}
					} else {
						boolean isNominaCreada = new NominaDAO().crearNominaEmpleado(empleado.getDni(), sueldoEmpleado);

						if (isNominaCreada == true) {
							nominasCreadas++;
						}
					}

				}
			}

			if (sonRegistrosCorrectos(empleadosTotales, sueldosActualizados, empleadosSinModificar, nominasCreadas,
					fallos) == true) {

				// Creo una alerta propia para forzar su tamaño ya que el mensaje es tan grande
				// que no se ve en las alertas generadas con su tamaño por defecto
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Confirmación");
				alert.setHeaderText("Sueldos actualizados corectamente");
				alert.setContentText("Análisis: Se han recogido " + empleadosTotales + " emplados, de los cuales "
						+ empleadosSinModificar + " no han sido modificados, a " + sueldosActualizados
						+ " de ellos se les a actualizado el sueldo y " + nominasCreadas
						+ " no tenían nómina antes de la operación. Fallos: " + fallos);
				alert.getDialogPane().setMinWidth(400);
				alert.getDialogPane().setMinHeight(200);
				alert.showAndWait();

				ventana.getBtnConfirmar().setDisable(false);
				ventana.getBtnCancelar().setDisable(false);

			} else {
				Alertas.mostrarError("Fallo inesperado", "Hubo algún error durante la operación");
				ventana.getBtnCancelar().setDisable(true);

			}

		} catch (FormatoDniException | EmpleadoDataException | FormatoSexoException e) {
			Alertas.mostrarError("Error al obtener empleados desde la BBDD", e.getMessage());
			e.printStackTrace();
		}
	}

	public void operacionCancelada() {
		stage.close();
	}

	public boolean sonRegistrosCorrectos(int empleadosTotales, int sueldosActualizados, int empleadosSinModificar,
			int nominasCreadas, int fallos) {

		boolean sonRegistrosCorrectos = false;
		if ((empleadosTotales) == (sueldosActualizados + empleadosSinModificar + nominasCreadas + fallos)) {
			sonRegistrosCorrectos = true;
		}
		return sonRegistrosCorrectos;
	}
}
