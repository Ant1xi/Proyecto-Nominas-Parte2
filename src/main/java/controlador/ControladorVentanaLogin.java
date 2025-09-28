package controlador;

import javafx.stage.Stage;
import vista.VentanaAdmin;
import vista.VentanaLogin;
import vista.alertas.Alertas;

public class ControladorVentanaLogin {
	private final VentanaLogin vista;
	private final Stage stage;

	public ControladorVentanaLogin(VentanaLogin vista, Stage stage) {
		this.vista = vista;
		this.stage = stage;
	}

	public void prepararControlador() {
		vista.getBtnEntrar().setOnAction(e -> comprobarLogin());
	}

	private void comprobarLogin() {
		String usuario = vista.getTxtUsuario().getText().trim();
		String contrasenya = vista.getTxtContrasenya().getText().trim();

		if (usuario.isBlank() || contrasenya.isBlank()) {
			Alertas.mostrarAdvertencia("Campos incompletos", "Se deben rellenar ambos campos de manera obligatoria");
			return;
		}

		if (!usuario.matches("^[A-ZÁÉÍÓÚÑ][a-zñáéíóú]+(?: [A-ZÁÉÍÓÚÑ][a-zñáéíóú]+)*$")) {
			Alertas.mostrarAdvertencia("Formato de nombre inválido",
					"El nombre debe comenzar por mayúscula y seguir con minúsculas (se admiten nombres compuestos).");
			return;
		}

		if (contrasenya.equals("fdellea600")) {
			VentanaAdmin vistaAdmin = new VentanaAdmin(usuario);
			stage.close();
			ControladorVentanaAdmin ctrlAdmin = new ControladorVentanaAdmin(vistaAdmin,
					vistaAdmin.getStageVentanaAdmin());
			ctrlAdmin.prepararControlador();
		} else {
			Alertas.mostrarAdvertencia("Acceso denegado", "Contraseña incorrecta.");
		}

	}
}
