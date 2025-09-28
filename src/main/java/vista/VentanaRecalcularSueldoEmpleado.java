package vista;

import dto.EmpleadoConSueldoDTO;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VentanaRecalcularSueldoEmpleado {
	private Label lblTitulo = new Label("Listado de empleados");
	private Stage stageVentanaModificarEmpleados;
	private ListView<EmpleadoConSueldoDTO> lista = new ListView<>();
	private Button btnActualizarSueldo = new Button("Recalcular y Actualizar sueldo");

	public VentanaRecalcularSueldoEmpleado() {
		stageVentanaModificarEmpleados = new Stage();

		BorderPane layoutPrincipal = new BorderPane();

		layoutPrincipal.setTop(lblTitulo);
		BorderPane.setAlignment(lblTitulo, Pos.CENTER);
		BorderPane.setMargin(lblTitulo, new Insets(20, 0, 20, 0));

		layoutPrincipal.setCenter(lista);
		BorderPane.setMargin(lista, new Insets(20, 0, 20, 0));

		layoutPrincipal.setBottom(btnActualizarSueldo);
		BorderPane.setMargin(btnActualizarSueldo, new Insets(20, 0, 20, 0));
		BorderPane.setAlignment(btnActualizarSueldo, Pos.CENTER);

		Scene scene = new Scene(layoutPrincipal, 500, 400);

		stageVentanaModificarEmpleados.setScene(scene);
		stageVentanaModificarEmpleados.setTitle("Listado de empleados");
		stageVentanaModificarEmpleados.show();
	}

	public void setEmpleados(ObservableList<EmpleadoConSueldoDTO> listaEmpleados) {
		lista.setItems(listaEmpleados);
	}

	public Label getLblTitulo() {
		return lblTitulo;
	}

	public Stage getStageVentanaModificarEmpleados() {
		return stageVentanaModificarEmpleados;
	}

	public ListView<EmpleadoConSueldoDTO> getLista() {
		return lista;
	}

	public Button getBtnModificar() {
		return btnActualizarSueldo;
	}
}
