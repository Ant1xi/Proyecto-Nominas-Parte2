package vista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SubVentanaModificarEmpleado {

	private Label lblTitulo = new Label("Modifica los datos");
	private Label lblNombre = new Label("Nombre: ");
	private Label lblDni = new Label("DNI: ");
	private Label lblSexo = new Label("Sexo: ");
	private Label lblCategoria = new Label("Categoría: ");
	private Label lblAnyos = new Label("Años: ");
	private TextField txtNombre = new TextField();
	private TextField txtDni = new TextField();
	private TextField txtSexo = new TextField();
	private ComboBox<String> cmbCategoria = new ComboBox<String>();
	private ObservableList<String> items;
	private TextField txtAnyos = new TextField();
	private Button btnGuardar = new Button("Guardar cambios");

	private Stage stageSubVentanaModificarEmpleados;

	public SubVentanaModificarEmpleado() {

		stageSubVentanaModificarEmpleados = new Stage();

		items = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
		cmbCategoria.setItems(items);

		txtDni.setEditable(false);

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setAlignment(Pos.CENTER);

		grid.add(lblNombre, 0, 0);
		grid.add(txtNombre, 1, 0);

		grid.add(lblDni, 0, 1);
		grid.add(txtDni, 1, 1);

		grid.add(lblSexo, 0, 2);
		grid.add(txtSexo, 1, 2);

		grid.add(lblCategoria, 0, 3);
		grid.add(cmbCategoria, 1, 3);

		grid.add(lblAnyos, 0, 4);
		grid.add(txtAnyos, 1, 4);

		BorderPane layoutPrincipal = new BorderPane();

		layoutPrincipal.setTop(lblTitulo);
		BorderPane.setAlignment(lblTitulo, Pos.CENTER);
		BorderPane.setMargin(lblTitulo, new Insets(20, 0, 20, 0));

		layoutPrincipal.setCenter(grid);
		BorderPane.setAlignment(grid, Pos.CENTER);
		BorderPane.setMargin(grid, new Insets(20, 20, 20, 20));

		layoutPrincipal.setBottom(btnGuardar);
		BorderPane.setAlignment(btnGuardar, Pos.CENTER);
		BorderPane.setMargin(btnGuardar, new Insets(20, 0, 20, 0));

		Scene scene = new Scene(layoutPrincipal, 420, 400);
		stageSubVentanaModificarEmpleados.setScene(scene);
		stageSubVentanaModificarEmpleados.setTitle("Formulario Modificable");
		stageSubVentanaModificarEmpleados.show();

	}

	public Label getLblTitulo() {
		return lblTitulo;
	}

	public Label getLblNombre() {
		return lblNombre;
	}

	public Label getLblDni() {
		return lblDni;
	}

	public ObservableList<String> getItems() {
		return items;
	}

	public Button getBtnGuardar() {
		return btnGuardar;
	}

	public Label getLblSexo() {
		return lblSexo;
	}

	public Label getLblCategoria() {
		return lblCategoria;
	}

	public Label getLblAnyos() {
		return lblAnyos;
	}

	public TextField getTxtNombre() {
		return txtNombre;
	}

	public TextField getTxtDni() {
		return txtDni;
	}

	public TextField getTxtSexo() {
		return txtSexo;
	}

	public ComboBox<String> getCmbCategoria() {
		return cmbCategoria;
	}

	public TextField getTxtAnyos() {
		return txtAnyos;
	}

	public Stage getStageSubVentanaModificarEmpleados() {
		return stageSubVentanaModificarEmpleados;
	}

}
