package controlador;

import dao.EmpleadoDAO;
import excepciones.EmpleadoDataException;
import excepciones.FormatoDniException;
import excepciones.FormatoSexoException;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelos.EmpleadoModelo;
import vista.SubVentanaModificarEmpleado;
import vista.alertas.Alertas;

public class ControladorSubVentanaModificarEmpleado {

	private SubVentanaModificarEmpleado ventana;
	private Stage stage;
	private ListView<EmpleadoModelo> lista;

	public ControladorSubVentanaModificarEmpleado(SubVentanaModificarEmpleado ventana, Stage stage,
			ListView<EmpleadoModelo> lista) {

		this.ventana = ventana;
		this.stage = stage;
		this.lista = lista;
	}

	public void prepararControlador(EmpleadoModelo emplado) {

		llenarFormulario(emplado);
		ventana.getBtnGuardar().setOnAction(e -> guardarCambios());

	}

	public void llenarFormulario(EmpleadoModelo e) {

		TextField txtNombre = ventana.getTxtNombre();
		TextField txtDni = ventana.getTxtDni();
		TextField txtSexo = ventana.getTxtSexo();
		ComboBox<String> cmbCategoria = ventana.getCmbCategoria();
		TextField txtAnyos = ventana.getTxtAnyos();

		txtNombre.setText(e.getNombre());
		txtDni.setText(e.getDni());
		txtSexo.setText(String.valueOf(e.getSexo()));
		cmbCategoria.setValue(String.valueOf(e.getCategoria()));
		txtAnyos.setText(String.valueOf(e.getAnyos()));

	}

	public void guardarCambios() {

		String nombre = ventana.getTxtNombre().getText().trim();
		String dni = ventana.getTxtDni().getText().trim();
		Character sexo = ventana.getTxtSexo().getText().trim().charAt(0);
		Integer categoria = Integer.parseInt(ventana.getCmbCategoria().getValue().trim());
		Integer anyos = Integer.parseInt(ventana.getTxtAnyos().getText().trim());

		try {
			EmpleadoModelo e = new EmpleadoModelo(dni, nombre, sexo, categoria, anyos);
			int filasModificadas = new EmpleadoDAO().actualizarDatosEmpleado(e, e.getDni());

			if (filasModificadas > 0) {

				int index = lista.getSelectionModel().getSelectedIndex();

				if (index >= 0) {
					lista.getItems().set(index, e);
				} else {
					lista.refresh();
				}

				Alertas.mostrarConfirmacion("Emplado guardado correctamente",
						"Se han modificado " + filasModificadas + " en la BBDD");

				stage.close();
			} else {
				Alertas.mostrarError("Error al guardar emplado", "No se ha realizado ningún cambio en la bbdd");
			}

		} catch (FormatoDniException | EmpleadoDataException | FormatoSexoException e) {
			Alertas.mostrarAdvertencia("Error al guardar", e.getMessage());
			e.printStackTrace();
		}
	}

}
