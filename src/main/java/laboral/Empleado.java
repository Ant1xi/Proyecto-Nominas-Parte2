package laboral;

import excepciones.EmpleadoDataException;
import excepciones.FormatoDniException;
import excepciones.FormatoSexoException;
import excepciones.PersonaDataException;

/**
 * Clase Empleado que hereda de Persona.
 * <p>
 * Guarda la categoría y los años trabajados de un empleado. Tiene validaciones
 * para que esos valores no sean incorrectos.
 */
public class Empleado extends Persona {

	/** Categoría del empleado (de 1 a 10). */
	private Integer categoria;

	/** Años trabajados por el empleado. */
	public Integer anyos;

	/**
	 * Constructor básico de empleado. La categoría empieza en 1 y los años en 0.
	 *
	 * @param nombre nombre del empleado
	 * @param dni    dni del empleado
	 * @param sexo   sexo del empleado ('M' o 'F')
	 * @throws PersonaDataException si hay campos nulos o vacíos
	 * @throws FormatoDniException  si el dni no cumple el formato
	 * @throws FormatoSexoException si el sexo no es 'M' o 'F'
	 */
	public Empleado(String nombre, String dni, Character sexo)
			throws PersonaDataException, FormatoDniException, FormatoSexoException {

		super(nombre, dni, sexo);
		this.categoria = 1;
		this.anyos = 0;
	}

	/**
	 * Constructor con todos los datos. Comprueba que la categoría y los años sean
	 * válidos antes de asignarlos.
	 *
	 * @param nombre    nombre del empleado
	 * @param dni       dni del empleado
	 * @param sexo      sexo del empleado ('M' o 'F')
	 * @param categoria categoría laboral (1 a 10)
	 * @param anyos     años trabajados (0 a 99)
	 * @throws PersonaDataException  si hay campos nulos o inválidos
	 * @throws FormatoDniException   si el dni no cumple el formato
	 * @throws FormatoSexoException  si el sexo no es 'M' o 'F'
	 * @throws EmpleadoDataException si la categoría o los años no cumplen las
	 *                               reglas
	 */
	public Empleado(String nombre, String dni, Character sexo, Integer categoria, Integer anyos)
			throws PersonaDataException, FormatoDniException, FormatoSexoException, EmpleadoDataException {

		super(nombre, dni, sexo);
		comprobarCategoria(categoria);
		comprobarAnyos(anyos);
		this.categoria = categoria;
		this.anyos = anyos;
	}

	/**
	 * Devuelve la categoría del empleado.
	 *
	 * @return categoría laboral (1 a 10)
	 */
	public Integer getCategoria() {
		return categoria;
	}

	/**
	 * Cambia la categoría del empleado.
	 *
	 * @param categoria nueva categoría (1 a 10)
	 */
	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	/** Suma un año trabajado al empleado. */
	public void incrAnyo() {
		this.anyos++;
	}

	/**
	 * Comprueba que la categoría esté entre 1 y 10.
	 *
	 * @param categoria categoría a validar
	 * @throws EmpleadoDataException si es nula o no está en el rango válido
	 */
	public void comprobarCategoria(Integer categoria) throws EmpleadoDataException {
		if (categoria == null) {
			throw new EmpleadoDataException("La categoría no puede ser un valor nulo");
		}
		if (categoria < 1 || categoria > 10) {
			throw new EmpleadoDataException("La categoría debe estar entre 1 y 10");
		}
	}

	/**
	 * Comprueba que los años estén en un rango válido (0 a 99).
	 *
	 * @param anyos años a validar
	 * @throws EmpleadoDataException si son nulos, negativos o demasiado altos
	 */
	public void comprobarAnyos(Integer anyos) throws EmpleadoDataException {
		if (anyos == null) {
			throw new EmpleadoDataException("Los años no pueden ser un valor nulo");
		}
		if (anyos < 0 || anyos > 99) {
			throw new EmpleadoDataException("Los años no pueden ser negativos ni excesivos");
		}
	}

	/** Muestra por consola los datos del empleado. */
	public void imprime() {
		System.out.println(super.nombre + ", " + super.dni + ", " + super.sexo + ", " + categoria + ", " + anyos
				+ " años trabajados.");
	}
}
