package vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaConsultarSalario {
	
	private Label lblTitulo = new Label("Consulta el salario de un emplado con su DNI");
	private Label lblDni = new Label("Introducir DNI: ");
	private Label lblSalarioObtenido = new Label("Salario: 0€");
	private TextField txtDni = new TextField();
	private Button btnConsultar = new Button("Consultar salario");
	private Stage stageVentanaConsultarSalario;
	
	public VentanaConsultarSalario() {
		stageVentanaConsultarSalario = new Stage();
		
		txtDni.setPromptText("12345678A");
		
		HBox tituloCentrado = new HBox(lblTitulo);
		tituloCentrado.setAlignment(Pos.CENTER);
		
		HBox btnCentrado = new HBox(btnConsultar);
		btnCentrado.setAlignment(Pos.CENTER);
		
		HBox camposCentrados = new HBox(10, lblDni, txtDni);
		camposCentrados.setAlignment(Pos.CENTER);
		
		HBox salarioCentrado = new HBox(10, lblSalarioObtenido);
		salarioCentrado.setAlignment(Pos.CENTER);
		
		VBox contenedorCampos = new VBox(20, camposCentrados, salarioCentrado, btnCentrado);
		contenedorCampos.setAlignment(Pos.CENTER);
		
		BorderPane layoutPrincipal = new BorderPane();
		layoutPrincipal.setTop(tituloCentrado);
		
		layoutPrincipal.setCenter(contenedorCampos);
		
		Scene scene = new Scene(layoutPrincipal, 400, 200);
		
		stageVentanaConsultarSalario.setScene(scene);
		stageVentanaConsultarSalario.setTitle("Ventana Consultar Salario");
		stageVentanaConsultarSalario.show();
	}

	public Label getLblTitulo() {
		return lblTitulo;
	}

	public Label getLblDni() {
		return lblDni;
	}

	public TextField getTxtDni() {
		return txtDni;
	}

	public Button getBtnConsultar() {
		return btnConsultar;
	}

	public Label getLblSalarioObtenido() {
		return lblSalarioObtenido;
	}

	public Stage getStageVentanaConsultarSalario() {
		return stageVentanaConsultarSalario;
	}
	
	
}
