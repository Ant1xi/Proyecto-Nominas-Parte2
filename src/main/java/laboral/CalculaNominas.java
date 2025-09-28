package laboral;

import java.util.List;

import dao.EmpleadoDAO;
import excepciones.EmpleadoDataException;
import excepciones.FormatoDniException;
import excepciones.FormatoSexoException;
import excepciones.PersonaDataException;
import ficheros.GestorFicherosEmpleados;
import modelos.EmpleadoModelo;

public class CalculaNominas {

	public static void main(String[] args) {

//		List<Empleado> listaEmpleados = new GestorFicherosEmpleados().leerEmpleadosTxt();
//
//		Empleado e1 = listaEmpleados.get(0);
//		Empleado e2 = listaEmpleados.get(1);
//
//		escribe(e1, e2);
//
//		e2.incrAnyo();
//		e1.setCategoria(9);
//
//		new GestorFicherosEmpleados().actualizarEmpleadosTxt(listaEmpleados);
//
//		escribe(e1, e2);
//
//		new GestorFicheroSueldo().escribirSueldosDat(listaEmpleados);
//		new GestorFicheroSueldo().leerSueldosDat();

		try {
			
			List<EmpleadoModelo> listaEmpleados = new EmpleadoDAO().getAll();

			EmpleadoModelo e1 = listaEmpleados.get(0);
			EmpleadoModelo e2 = listaEmpleados.get(1);

			boolean isAnyosIncrementados = new EmpleadoDAO().incrementarAnyos(e2.getDni());

			if (isAnyosIncrementados == true) {
				System.out.println("Éxito al incrementar los años del emplado: " + e2.getDni());
			}

			boolean isCategoriaCambiada = new EmpleadoDAO().actualizarCategoria(e1.getDni(), 9);

			if (isCategoriaCambiada == true) {
				System.out.println("Éxito al modificar la categorís del emplado: " + e1.getDni());
			}

		} catch (FormatoDniException | EmpleadoDataException | FormatoSexoException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		
		List<EmpleadoModelo> listaEmpleadosNuevos = new GestorFicherosEmpleados().leerEmpleadosNuevosTxt();
		
		int empleadosCreados = new EmpleadoDAO().altaEmpleado(listaEmpleadosNuevos);
		
		if (empleadosCreados > 0) {
			System.out.println("Se han creado "+empleadosCreados+" emplados.");
		} else {
			System.out.println("No se ha podido crear ningún empleado");
		}
	}

	public static Empleado crearEmpleadoCompleto(String nombre, String dni, Character sexo, Integer categoria,
			Integer anyos) {
		try {
			Empleado e = new Empleado(nombre, dni, sexo, categoria, anyos);
			return e;
		} catch (PersonaDataException | FormatoDniException | FormatoSexoException | EmpleadoDataException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public static Empleado crearEmpleadoSimple(String nombre, String dni, Character sexo) {
		try {
			Empleado e = new Empleado(nombre, dni, sexo);
			return e;
		} catch (PersonaDataException | FormatoDniException | FormatoSexoException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

//	private static void escribe(Empleado e1, Empleado e2) {
//
//		if (e1 != null) {
//			Double sueldoEmpleado1 = Nomina.sueldo(e1);
//			String sueldoEmplado1Validado = imprimirSueldo(sueldoEmpleado1);
//
//			System.out.println("Empleado 1: \n" + "   - Nombre: " + e1.nombre + "\n" + "   - DNI: " + e1.dni + "\n"
//					+ "   - Sexo: " + e1.sexo + "\n" + "   - Categoría: " + e1.getCategoria() + "\n"
//					+ "   - Años trabajados: " + e1.anyos + "\n" + "   - Sueldo: " + sueldoEmplado1Validado + "\n");
//		} else {
//			System.out.println("Empleado 1: no se pudo crear.\n");
//		}
//
//		if (e2 != null) {
//			Double sueldoEmpleado2 = Nomina.sueldo(e2);
//			String sueldoEmplado2Validado = imprimirSueldo(sueldoEmpleado2);
//
//			System.out.println("Empleado 2: \n" + "   - Nombre: " + e2.nombre + "\n" + "   - DNI: " + e2.dni + "\n"
//					+ "   - Sexo: " + e2.sexo + "\n" + "   - Categoría: " + e2.getCategoria() + "\n"
//					+ "   - Años trabajados: " + e2.anyos + "\n" + "   - Sueldo: " + sueldoEmplado2Validado + "\n");
//		} else {
//			System.out.println("Empleado 2: no se pudo crear.\n");
//		}
//	}

	public static String imprimirSueldo(Double sueldo) {
		String sueldoEmplado = "No se ha podido calcular el sueldo";

		if (sueldo != 0) {
			sueldoEmplado = sueldo + "€";
		}

		return sueldoEmplado;
	}
}
