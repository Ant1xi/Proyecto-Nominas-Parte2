package laboral;

import excepciones.FormatoDniException;
import excepciones.FormatoSexoException;
import excepciones.PersonaDataException;

/**
 * Clase Persona que guarda la información básica: nombre, dni y sexo.
 * <p>
 * Incluye validaciones para que los datos tengan el formato correcto.
 */
public class Persona {

	/** Nombre de la persona. */
	public String nombre;

	/** DNI de la persona. */
	public String dni;

	/** Sexo de la persona ('M' o 'F'). */
	public Character sexo;

	/**
	 * Constructor principal de Persona. Comprueba que los valores no sean nulos y
	 * que el formato de nombre, dni y sexo sea correcto.
	 *
	 * @param nombre nombre de la persona
	 * @param dni    dni de la persona
	 * @param sexo   sexo de la persona ('M' o 'F')
	 * @throws PersonaDataException si hay campos nulos o vacíos
	 * @throws FormatoDniException  si el dni no cumple el formato
	 * @throws FormatoSexoException si el sexo no es 'M' o 'F'
	 */
	public Persona(String nombre, String dni, Character sexo)
			throws PersonaDataException, FormatoDniException, FormatoSexoException {

		comprobarCampos(nombre, dni, sexo);
		comprobarNombreSexo(nombre, sexo);
		comprobarDni(dni);

		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
	}

	/**
	 * Constructor alternativo sin dni. Sirve para crear la persona con nombre y
	 * sexo aunque todavía no tenga documento.
	 *
	 * @param nombre nombre de la persona
	 * @param sexo   sexo de la persona ('M' o 'F')
	 * @throws PersonaDataException si hay campos nulos o vacíos
	 * @throws FormatoSexoException si el sexo no es 'M' o 'F'
	 */
	public Persona(String nombre, Character sexo) throws PersonaDataException, FormatoSexoException {

		if (nombre == null || sexo == null) {
			throw new PersonaDataException("Los campos no pueden quedarse como valores nulos");
		}
		comprobarNombreSexo(nombre, sexo);

		this.nombre = nombre;
		this.sexo = sexo;
	}

	/**
	 * Cambia el dni de la persona después de validarlo.
	 *
	 * @param dni nuevo dni
	 * @throws FormatoDniException si el formato del dni no es correcto
	 */
	public void setDni(String dni) throws FormatoDniException {
		comprobarDni(dni);
		this.dni = dni;
	}

	/** Imprime por consola el nombre y el dni. */
	public void imprime() {
		System.out.println(nombre + " " + dni);
	}

	/**
	 * Comprueba que ningún campo esté vacío o nulo.
	 *
	 * @param nombre nombre a validar
	 * @param dni    dni a validar
	 * @param sexo   sexo a validar
	 * @throws PersonaDataException si alguno es nulo o vacío
	 */
	private void comprobarCampos(String nombre, String dni, Character sexo) throws PersonaDataException {
		if (nombre == null || dni == null || sexo == null) {
			throw new PersonaDataException("Los campos no pueden quedarse como valores nulos");
		}

		if (nombre.isBlank() || dni.isBlank() || Character.isWhitespace(sexo)) {
			throw new PersonaDataException("Debes rellenar todos los campos");
		}
	}

	/**
	 * Comprueba que el nombre tenga el formato correcto y que el sexo sea 'M' o
	 * 'F'.
	 *
	 * @param nombre nombre a validar
	 * @param sexo   sexo a validar
	 * @throws PersonaDataException si el nombre está vacío o no cumple el patrón
	 * @throws FormatoSexoException si el sexo no es 'M' o 'F'
	 */
	private void comprobarNombreSexo(String nombre, Character sexo) throws PersonaDataException, FormatoSexoException {

		if (nombre == null || nombre.isBlank() || sexo == null) {
			throw new PersonaDataException("Los campos no pueden quedarse como valores nulos");
		}

		if (!nombre.matches("^[A-ZÁÉÍÓÚÑ][a-zñáéíóú]+(?: [A-ZÁÉÍÓÚÑ][a-zñáéíóú]+)*$")) {
			throw new PersonaDataException(
					"El nombre debe comenzar por mayúscula y seguir con minúsculas (se admiten nombres compuestos).");
		}

		if (sexo != 'M' && sexo != 'F') {
			throw new FormatoSexoException("El sexo debe ser 'M' (hombre) o 'F' (mujer).");
		}
	}

	/**
	 * Comprueba que el dni no esté vacío y cumpla el formato 8 números + letra
	 * mayúscula.
	 *
	 * @param dni dni a validar
	 * @throws FormatoDniException si está vacío o no cumple el formato
	 */
	private void comprobarDni(String dni) throws FormatoDniException {
		if (dni == null || dni.isBlank()) {
			throw new FormatoDniException("El DNI no puede estar vacío.");
		}
		if (!dni.matches("^\\d{8}[A-Z]$")) {
			throw new FormatoDniException("Formato del DNI incorrecto: 8 números seguidos de una letra en mayúscula.");
		}
	}

	/**
	 * Devuelve una representación en texto de la persona.
	 *
	 * @return nombre y dni (si está asignado)
	 */
	@Override
	public String toString() {
		return nombre + " " + (dni == null ? "" : dni);
	}
}
