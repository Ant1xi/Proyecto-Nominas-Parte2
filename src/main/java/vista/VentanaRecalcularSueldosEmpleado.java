package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaRecalcularSueldosEmpleado {

	private Label lblPregunta = new Label("¿Está seguro de que quiere realizar la siguiente operación?");
	private Label lblAdvertencia = new Label("No será posible deshacer los cambios");
	private Button btnConfirmar = new Button("Confirmar");
	private Button btnCancelar = new Button("Volver atrás");
	private Stage stageVentanaRecalcularSueldosEmpleado;

	public VentanaRecalcularSueldosEmpleado() {
		stageVentanaRecalcularSueldosEmpleado = new Stage();

		VBox mensajes = new VBox(20, lblPregunta, lblAdvertencia);
		mensajes.setAlignment(Pos.CENTER);

		HBox botones = new HBox(20, btnConfirmar, btnCancelar);
		botones.setAlignment(Pos.CENTER);

		BorderPane layoutPrincipal = new BorderPane();

		layoutPrincipal.setTop(mensajes);
		BorderPane.setAlignment(mensajes, Pos.TOP_CENTER);
		BorderPane.setMargin(mensajes, new Insets(20, 20, 0, 20));

		layoutPrincipal.setBottom(botones);
		BorderPane.setAlignment(botones, Pos.CENTER);
		BorderPane.setMargin(botones, new Insets(20, 0, 20, 0));

		Scene scene = new Scene(layoutPrincipal);
		stageVentanaRecalcularSueldosEmpleado.setScene(scene);
		stageVentanaRecalcularSueldosEmpleado.setTitle("Recalcular todos los sueldos");
		stageVentanaRecalcularSueldosEmpleado.show();
		
	}

	public Label getLblPregunta() {
		return lblPregunta;
	}

	public Label getLblAdvertencia() {
		return lblAdvertencia;
	}

	public Button getBtnConfirmar() {
		return btnConfirmar;
	}

	public Button getBtnCancelar() {
		return btnCancelar;
	}

	public Stage getStageVentanaRecalcularSueldosEmpleado() {
		return stageVentanaRecalcularSueldosEmpleado;
	}

}
