package vista;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelos.EmpleadoModelo;

public class VentanaListarEmpleados {

	private Label lblTitulo = new Label("Listado de empleados");
	private Stage stageVentanaListarEmpleados;
	private ListView<EmpleadoModelo> lista = new ListView<>();

	public VentanaListarEmpleados() {

		stageVentanaListarEmpleados = new Stage();

		BorderPane layoutPrincipal = new BorderPane();

		layoutPrincipal.setTop(lblTitulo);
		BorderPane.setAlignment(lblTitulo, Pos.CENTER);
		BorderPane.setMargin(lblTitulo, new Insets(20, 0, 20, 0));

		layoutPrincipal.setCenter(lista);
		BorderPane.setMargin(lista, new Insets(20, 0, 20, 0));

		Scene scene = new Scene(layoutPrincipal, 350, 400);

		stageVentanaListarEmpleados.setScene(scene);
		stageVentanaListarEmpleados.setTitle("Listado de empleados");
		stageVentanaListarEmpleados.show();
	}

	public void setEmpleados(ObservableList<EmpleadoModelo> listaEmpleados) {
		lista.setItems(listaEmpleados);
	}

	public Stage getStageVentanaListarEmpleados() {
		return stageVentanaListarEmpleados;
	}
}
