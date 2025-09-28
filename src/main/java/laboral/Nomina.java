package laboral;

import modelos.EmpleadoModelo;

/**
 * Clase Nomina que calcula el sueldo de un empleado.
 * <p>
 * Usa un array con los sueldos base según la categoría y añade un plus por cada
 * año trabajado.
 */
public class Nomina {

	/** Sueldos base para cada categoría (de 1 a 10). */
	private static final int[] SUELDO_BASE = { 50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000,
			230000 };

	/**
	 * Constructor por defecto de Nomina. Se incluye para evitar warnings en la
	 * generación de Javadoc.
	 */
	public Nomina() {
		// Constructor vacío
	}

	/**
	 * Calcula el sueldo total de un empleado.
	 * <p>
	 * Si el empleado es nulo, devuelve 0. Si los años son nulos, se toman como 0.
	 *
	 * @param e empleado del que se quiere calcular el sueldo
	 * @return sueldo total en función de la categoría y los años trabajados
	 */
	public static Double sueldo(Empleado e) {
		if (e == null)
			return 0.0;

		Integer sueldoBase = calcularSueldoBase(e);
		int anyos = (e.anyos == null ? 0 : e.anyos);

		return sueldoBase + 5000.0 * anyos;
	}

	public static Double sueldo(EmpleadoModelo e) {
		if (e == null)
			return 0.0;

		Integer sueldoBase = calcularSueldoBase(e);
		int anyos = (e.getAnyos() == null ? 0 : e.getAnyos());

		return sueldoBase + 5000.0 * anyos;
	}

	/**
	 * Calcula el sueldo base según la categoría del empleado.
	 * <p>
	 * Si la categoría es nula, devuelve 0.
	 *
	 * @param e empleado al que se consulta
	 * @return sueldo base según la categoría (o 0 si no tiene)
	 */
	public static int calcularSueldoBase(Empleado e) {

		int sueldoBase = 0;
		Integer categoria = e.getCategoria();

		if (categoria != null) {
			sueldoBase = SUELDO_BASE[categoria - 1];
		}

		return sueldoBase;
	}

	public static int calcularSueldoBase(EmpleadoModelo e) {
		

		int sueldoBase = 0;
		Integer categoria = e.getCategoria();

		if (categoria != null) {
			sueldoBase = SUELDO_BASE[categoria - 1];
		}

		return sueldoBase;
	}
}
