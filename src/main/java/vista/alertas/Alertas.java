package vista.alertas;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Alertas {
	public static void mostrarAdvertencia(String header, String contenido) {
		Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Advertencia");
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
	}
	
	public static void mostrarError(String header, String contenido) {
		Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
	}
	
	public static Optional<ButtonType> mostrarConfirmacion(String header, String contenido) {
	    Alert alert = new Alert(AlertType.CONFIRMATION);
	    alert.setTitle("Confirmación");
	    alert.setHeaderText(header);
	    alert.setContentText(contenido);
	    return alert.showAndWait();
	}

}
