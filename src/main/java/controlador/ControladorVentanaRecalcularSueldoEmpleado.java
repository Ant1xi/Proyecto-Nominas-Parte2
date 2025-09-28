package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dao.EmpleadoDAO;
import dao.NominaDAO;
import dto.EmpleadoConSueldoDTO;
import excepciones.EmpleadoDataException;
import excepciones.FormatoDniException;
import excepciones.FormatoSexoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import laboral.Nomina;
import modelos.EmpleadoModelo;
import vista.VentanaRecalcularSueldoEmpleado;
import vista.alertas.Alertas;

public class ControladorVentanaRecalcularSueldoEmpleado {

	private VentanaRecalcularSueldoEmpleado ventana;

	public ControladorVentanaRecalcularSueldoEmpleado(VentanaRecalcularSueldoEmpleado ventana, Stage stage) {

		this.ventana = ventana;

	}

	public void prepararControlador() {
		ventana.getBtnModificar().setOnAction(e -> recalcularActualizarSueldo());
		ventana.setEmpleados(obtenerLista());
	}

	public void recalcularActualizarSueldo() {
		EmpleadoConSueldoDTO empleadoSeleccionado = ventana.getLista().getSelectionModel().getSelectedItem();

		if (empleadoSeleccionado != null) {

			String dni = empleadoSeleccionado.getDni();
			String nombre = empleadoSeleccionado.getNombre();
			Character sexo = empleadoSeleccionado.getSexo();
			Integer categoria = empleadoSeleccionado.getCategoria();
			Integer anyos = empleadoSeleccionado.getAnyos();
			Double sueldoEmpladoSeleccionado = empleadoSeleccionado.getSueldo();

			try {
				EmpleadoModelo empleado = new EmpleadoModelo(dni, nombre, sexo, categoria, anyos);

				Double sueldoRegistrado = new NominaDAO().recogerSueldoEmpleado(empleado);

				if (sueldoRegistrado != null) {
					if (sueldoEmpladoSeleccionado.equals(sueldoRegistrado)) {
						Alertas.mostrarAdvertencia("Operación innecesaria",
								"Este emplado ya tiene el sueldo actualizado");
					} else {
						int filas = new NominaDAO().actualizarSueldoEmpleado(empleado);

						if (filas == 1) {
							Alertas.mostrarConfirmacion("Éxito", "Sueldo actualizado correctamente");
						}
					}
				} else {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Confirmación");
					alert.setHeaderText("Empleado sin Nómina");
					alert.setContentText("¿Desea crear una nómina ahora para poder registra y actualizar su sueldo?");
					Optional<ButtonType> resultado = alert.showAndWait();

					if (resultado.get() == ButtonType.OK) {
						boolean isCreada = new NominaDAO().crearNominaEmpleado(dni, sueldoEmpladoSeleccionado);

						if (isCreada == true) {
							Alertas.mostrarConfirmacion("Éxito", "Nómina creada correctamente");
						} else {
							Alertas.mostrarError("Error al crear nómina",
									"No se ha podido crear la nómina del emplado " + dni);
						}
					}
				}

			} catch (FormatoDniException | EmpleadoDataException | FormatoSexoException e) {
				Alertas.mostrarError("Error al recoger emplado seleccionado", e.getMessage());
			}

		} else {
			Alertas.mostrarAdvertencia("Ningún empleado seleccionado",
					"Debe de seleccionar un emplado para poder continuar.");
			return;
		}
	}

	public ObservableList<EmpleadoConSueldoDTO> obtenerLista() {
		List<EmpleadoConSueldoDTO> listaEmpleadosConSueldo = new ArrayList<EmpleadoConSueldoDTO>();
		try {
			List<EmpleadoModelo> listaEmpleados = new EmpleadoDAO().getAll();

			for (EmpleadoModelo empleado : listaEmpleados) {
				listaEmpleadosConSueldo.add(new EmpleadoConSueldoDTO(empleado.getDni(), empleado.getNombre(),
						empleado.getSexo(), empleado.getCategoria(), empleado.getAnyos(), Nomina.sueldo(empleado)));
			}

		} catch (FormatoDniException | EmpleadoDataException | FormatoSexoException e) {
			Alertas.mostrarError("Error al cargar lista desde la BBDD", e.getMessage());
		}

		return FXCollections.observableArrayList(listaEmpleadosConSueldo);

	}

}
