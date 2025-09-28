package controlador;

import java.util.List;

import dao.EmpleadoDAO;
import excepciones.EmpleadoDataException;
import excepciones.FormatoDniException;
import excepciones.FormatoSexoException;
import ficheros.GestorFicheroSueldo;
import ficheros.GestorFicherosEmpleados;
import javafx.stage.Stage;
import modelos.EmpleadoModelo;
import vista.VentanaCopiaSeguridadFicheros;
import vista.alertas.Alertas;

public class ControladorVentanaCopiaSeguridadFicheros {

	private VentanaCopiaSeguridadFicheros ventana;
	private Stage stage;

	public ControladorVentanaCopiaSeguridadFicheros(VentanaCopiaSeguridadFicheros ventana, Stage stage) {

		this.ventana = ventana;
		this.stage = stage;
	}

	public void prepararControlador() {
		ventana.getBtnConfirmar().setOnAction(e -> confirmarOperacion());
		ventana.getBtnCancelar().setOnAction(e -> cancelarOperacion());
	}

	public void confirmarOperacion() {
		ventana.getBtnConfirmar().setVisible(false);
		ventana.getBtnCancelar().setVisible(false);

		try {
			List<EmpleadoModelo> listaEmpleados = new EmpleadoDAO().getAll();
			int empleadosRecogidos = listaEmpleados.size();

			GestorFicherosEmpleados gfe = new GestorFicherosEmpleados();
			int empleadosEscritos = gfe.actualizarEmpleadosModeloTxt(listaEmpleados);

			GestorFicheroSueldo gfs = new GestorFicheroSueldo();
			int sueldosEscritos = gfs.escribirSueldosDatEmpleadosModelo(listaEmpleados);

			if ((empleadosRecogidos == empleadosEscritos) && (sueldosEscritos == empleadosRecogidos)) {
				Alertas.mostrarConfirmacion("Copia de seguridad realizada con éxito",
						"Se han modificado los ficheros correctamente con todos los datos de la BBDD");

				ventana.getBtnConfirmar().setVisible(true);
				ventana.getBtnCancelar().setVisible(true);
			} else {
				Alertas.mostrarError("Error al realizar copia de seguridad",
						"Fallo en ficheros: \n" + "Empleados recogidos -> " + empleadosRecogidos + " \n"
								+ "Empleados escritos -> " + empleadosEscritos + " \n" + "Sueldos escritos -> "
								+ sueldosEscritos + " \n" + "No se han escrito "
								+ (empleadosRecogidos - empleadosEscritos) + " empleados \n" + "No se han escrito "
								+ (empleadosRecogidos - sueldosEscritos) + " sueldos");
				ventana.getBtnCancelar().setVisible(true);
			}

		} catch (FormatoDniException | EmpleadoDataException | FormatoSexoException e) {
			Alertas.mostrarError("Error en el traspaso al regoer empleados desde la BBDD ", e.getMessage());
			ventana.getBtnCancelar().setVisible(true);
			e.printStackTrace();
		}
	}

	public void cancelarOperacion() {
		stage.close();
	}
}
