package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaAdmin {

	private Button btnListarEmpleados = new Button("LISTAR EMPLEADOS");
	private Button btnConsultarSalario = new Button("CONSULTAR SALARIO DE UN EMPLEADO");
	private Button btnModificarDatos = new Button("MODIFICAR DATOS EMPLEADOS");
	private Button btnRecalcularSueldoByDni = new Button("RECALCULAR SUELDO DE UN EMPLEADO");
	private Button btnRecalcularSueldoTodos = new Button("RECALCULAR SUELDO DE TODOS LOS EMPLEADOS");
	private Button btnCopiaSeguridadFicheros = new Button("REALIZAR COPIA DE SEGURIDAD");
	private Stage stageVentanaAdmin;

	public VentanaAdmin(String usuario) {

		stageVentanaAdmin = new Stage();

		Label lblTitulo = new Label("¡¡Bienvenido " + usuario + "!!");

		Button[] botones = { btnListarEmpleados, btnConsultarSalario, btnModificarDatos, btnRecalcularSueldoByDni,
				btnRecalcularSueldoTodos, btnCopiaSeguridadFicheros };

		for (var b : botones) {
			b.setPrefWidth(300);
		}

		VBox contenerdorBotones = new VBox(10, botones);
		contenerdorBotones.setAlignment(Pos.CENTER);
		contenerdorBotones.setPadding(new Insets(20));

		BorderPane layoutPrincipal = new BorderPane();
		layoutPrincipal.setTop(lblTitulo);
		BorderPane.setAlignment(lblTitulo, Pos.CENTER);
		BorderPane.setMargin(lblTitulo, new Insets(20, 0, 20, 0));

		layoutPrincipal.setCenter(contenerdorBotones);

		Scene scene = new Scene(layoutPrincipal, 400, 400);

		stageVentanaAdmin.setScene(scene);
		stageVentanaAdmin.setTitle("Ventana Admin");
		stageVentanaAdmin.show();

	}

	public Stage getStageVentanaAdmin() {
		return stageVentanaAdmin;
	}

	public Button getBtnListarEmpleados() {
		return btnListarEmpleados;
	}

	public Button getBtnConsultarSalario() {
		return btnConsultarSalario;
	}

	public Button getBtnModificarDatos() {
		return btnModificarDatos;
	}

	public Button getBtnRecalcularSueldoByDni() {
		return btnRecalcularSueldoByDni;
	}

	public Button getBtnRecalcularSueldoTodos() {
		return btnRecalcularSueldoTodos;
	}

	public Button getBtnCopiaSeguridadFicheros() {
		return btnCopiaSeguridadFicheros;
	}

}
