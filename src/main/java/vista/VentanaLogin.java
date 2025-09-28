package vista;

import controlador.ControladorVentanaLogin;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaLogin extends Application {

	private Label lblTitulo = new Label("¡¡Bienvenido a Gestion de Nóminas!!");
	private Label lblUsuario = new Label("Usuario: ");
	private Label lblContrasenya = new Label("Contraseña: ");

	private TextField txtUsuario = new TextField();
	private PasswordField txtContrasenya = new PasswordField();

	private Button btnEntrar = new Button("Acceder");
	

	@Override
	public void start(Stage primaryStage) throws Exception {

		ControladorVentanaLogin ctrl = new ControladorVentanaLogin(this, primaryStage);
		ctrl.prepararControlador();

		txtUsuario.setPromptText("Tu nombre");
		txtUsuario.setMaxWidth(200);

		txtContrasenya.setPromptText("Contraseña");
		txtContrasenya.setMaxWidth(200);

		btnEntrar.setPrefWidth(120);

		HBox tituloCentrado = new HBox(lblTitulo);
		tituloCentrado.setAlignment(Pos.CENTER);

		VBox camposCentrados = new VBox(10, lblUsuario, txtUsuario, lblContrasenya, txtContrasenya);
		camposCentrados.setAlignment(Pos.CENTER);

		HBox botonCentrado = new HBox(btnEntrar);
		botonCentrado.setAlignment(Pos.CENTER);
		botonCentrado.setSpacing(10);

		BorderPane layoutPrincipal = new BorderPane();
		layoutPrincipal.setTop(tituloCentrado);
		layoutPrincipal.setCenter(camposCentrados);

		layoutPrincipal.setBottom(botonCentrado);
		BorderPane.setMargin(botonCentrado, new Insets(0, 0, 20, 0));

		Scene scene = new Scene(layoutPrincipal, 400, 300);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Ventana Login");
		primaryStage.show();

	}

	public Label getLblTitulo() {
		return lblTitulo;
	}

	public Label getLblUsuario() {
		return lblUsuario;
	}

	public Label getLblContrasenya() {
		return lblContrasenya;
	}

	public TextField getTxtUsuario() {
		return txtUsuario;
	}

	public PasswordField getTxtContrasenya() {
		return txtContrasenya;
	}

	public Button getBtnEntrar() {
		return btnEntrar;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
