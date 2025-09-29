package vista;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelos.EmpleadoModelo;

public class VentanaModificarDatosEmpleado {

	private Label lblTitulo = new Label("Listado de empleados");
	private Stage stageVentanaModificarEmpleados;
	private ListView<EmpleadoModelo> lista = new ListView<>();
	private Button btnModificar = new Button("Modificar");

	public VentanaModificarDatosEmpleado() {
		stageVentanaModificarEmpleados = new Stage();

		BorderPane layoutPrincipal = new BorderPane();

		layoutPrincipal.setTop(lblTitulo);
		BorderPane.setAlignment(lblTitulo, Pos.CENTER);
		BorderPane.setMargin(lblTitulo, new Insets(20, 0, 20, 0));

		layoutPrincipal.setCenter(lista);
		BorderPane.setMargin(lista, new Insets(20, 0, 20, 0));

		layoutPrincipal.setBottom(btnModificar);
		BorderPane.setMargin(btnModificar, new Insets(20, 0, 20, 0));
		BorderPane.setAlignment(btnModificar, Pos.CENTER);

		Scene scene = new Scene(layoutPrincipal, 350, 400);

		stageVentanaModificarEmpleados.setScene(scene);
		stageVentanaModificarEmpleados.setTitle("Listado de empleados");
		stageVentanaModificarEmpleados.show();
	}

	// Este método lo he creado para poder cargar la lista desde el controlador
	// cuando se abra la ventana
	public void setEmpleados(ObservableList<EmpleadoModelo> listaEmpleados) {
		lista.setItems(listaEmpleados);
	}

	public Label getLblTitulo() {
		return lblTitulo;
	}

	public Stage getStageVentanaModificarEmpleados() {
		return stageVentanaModificarEmpleados;
	}

	public ListView<EmpleadoModelo> getLista() {
		return lista;
	}

	public Button getBtnModificar() {
		return btnModificar;
	}

}
