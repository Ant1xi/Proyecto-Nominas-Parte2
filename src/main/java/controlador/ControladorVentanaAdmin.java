package controlador;

import javafx.stage.Stage;
import vista.VentanaAdmin;
import vista.VentanaConsultarSalario;
import vista.VentanaCopiaSeguridadFicheros;
import vista.VentanaListarEmpleados;
import vista.VentanaModificarDatosEmpleado;
import vista.VentanaRecalcularSueldoEmpleado;
import vista.VentanaRecalcularSueldosEmpleado;

/**
 * ControladorVentanaAdmin Gestiona todos los eventos que ocurren al presionar
 * cada una de las opciones, basicamente crea las ventanas y a sus respectivos
 * controladores que reciben esa ventana que se ha creado
 */
public class ControladorVentanaAdmin {

	private final VentanaAdmin vista;

	public ControladorVentanaAdmin(VentanaAdmin vista, Stage stage) {
		this.vista = vista;
	}

	public void prepararControlador() {
		vista.getBtnListarEmpleados().setOnAction(e -> abrirVentanaListarEmpleados());
		vista.getBtnConsultarSalario().setOnAction(e -> abrirVentanaConsultarSalario());
		vista.getBtnModificarDatos().setOnAction(e -> abrirVentanaModicarDatos());
		vista.getBtnRecalcularSueldoByDni().setOnAction(e -> abrirVentanaRecalcularSueldoByDni());
		vista.getBtnRecalcularSueldoTodos().setOnAction(e -> abrirVentanaRecalcularSueldoTodos());
		vista.getBtnCopiaSeguridadFicheros().setOnAction(e -> abrirVentanaCopiaSeguridadFicheros());
	}

	public void abrirVentanaListarEmpleados() {
		VentanaListarEmpleados vistaListarEmpleados = new VentanaListarEmpleados();
		ControladorVentanaListarEmpleados ctrlListarEmpleados = new ControladorVentanaListarEmpleados(
				vistaListarEmpleados, vistaListarEmpleados.getStageVentanaListarEmpleados());

		ctrlListarEmpleados.prepararControlador();
	}

	public void abrirVentanaConsultarSalario() {
		VentanaConsultarSalario vistaConsultarSalario = new VentanaConsultarSalario();
		ControladorVentanaConsultarSalario ctrlConsultarSalario = new ControladorVentanaConsultarSalario(
				vistaConsultarSalario, vistaConsultarSalario.getStageVentanaConsultarSalario());

		ctrlConsultarSalario.prepararControlador();
	}

	public void abrirVentanaModicarDatos() {
		VentanaModificarDatosEmpleado vistaModificarDatosEmpleado = new VentanaModificarDatosEmpleado();
		ControladorVentanaModificarDatosEmpleados ctrlModificarDatosEmpleado = new ControladorVentanaModificarDatosEmpleados(
				vistaModificarDatosEmpleado, vistaModificarDatosEmpleado.getStageVentanaModificarEmpleados());

		ctrlModificarDatosEmpleado.prepararControlador();
	}

	public void abrirVentanaRecalcularSueldoByDni() {
		VentanaRecalcularSueldoEmpleado vistaRecalcularSueldo = new VentanaRecalcularSueldoEmpleado();
		ControladorVentanaRecalcularSueldoEmpleado ctrlRecalcularSueldo = new ControladorVentanaRecalcularSueldoEmpleado(
				vistaRecalcularSueldo, vistaRecalcularSueldo.getStageVentanaModificarEmpleados());

		ctrlRecalcularSueldo.prepararControlador();
	}

	public void abrirVentanaRecalcularSueldoTodos() {
		VentanaRecalcularSueldosEmpleado vistaRecalcularTodosSueldos = new VentanaRecalcularSueldosEmpleado();
		ControladorRecalcularSueldosEmpleados ctrlRecalcularTodosSueldos = new ControladorRecalcularSueldosEmpleados(
				vistaRecalcularTodosSueldos, vistaRecalcularTodosSueldos.getStageVentanaRecalcularSueldosEmpleado());

		ctrlRecalcularTodosSueldos.prepararControlador();
	}

	public void abrirVentanaCopiaSeguridadFicheros() {
		VentanaCopiaSeguridadFicheros vistaCopiaSeguridadFicheros = new VentanaCopiaSeguridadFicheros();
		ControladorVentanaCopiaSeguridadFicheros ctrlCopiaSeguridadFicheros = new ControladorVentanaCopiaSeguridadFicheros(
				vistaCopiaSeguridadFicheros, vistaCopiaSeguridadFicheros.getStageVentanaRecalcularSueldosEmpleado());

		ctrlCopiaSeguridadFicheros.prepararControlador();
	}

}
