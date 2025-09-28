package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import excepciones.EmpleadoDataException;
import excepciones.FormatoDniException;
import excepciones.FormatoSexoException;
import excepciones.PersonaDataException;
import laboral.Empleado;
import modelos.EmpleadoModelo;

public class GestorFicherosEmpleados {

	public List<Empleado> leerEmpleadosTxt() {
		List<Empleado> listaEmpleados = new ArrayList<>();
		String ruta = "data/empleados.txt";
		String separador = ";";

		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
			String linea = br.readLine(); // Leemos la primera linea que es la cabecera

			// Ahora el while empieza desde la segunda linea
			while ((linea = br.readLine()) != null) {
				if (linea.isBlank())
					continue;

				String[] partes = linea.split(separador);

				String dni = partes[0].trim();
				String nombre = partes[1].trim();
				char sexo = partes[2].trim().charAt(0);
				int categoria = Integer.parseInt(partes[3].trim());
				int anyos = Integer.parseInt(partes[4].trim());

				try {
					Empleado e = new Empleado(nombre, dni, sexo, categoria, anyos);
					listaEmpleados.add(e);
				} catch (PersonaDataException | FormatoDniException | FormatoSexoException | EmpleadoDataException e) {
					System.out.println("Error creando empleado " + dni + ": " + e.getMessage());
				}
			}
		} catch (IOException ex) {
			System.out.println("Error al leer el fichero: " + ex.getMessage());
		}

		return listaEmpleados;
	}
	
	public List<EmpleadoModelo> leerEmpleadosNuevosTxt() {
		List<EmpleadoModelo> listaEmpleados = new ArrayList<>();
		String ruta = "data/empleadosNuevos.txt";
		String separador = ";";

		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
			String linea = br.readLine(); // Leemos la primera linea que es la cabecera

			// Ahora el while empieza desde la segunda linea
			while ((linea = br.readLine()) != null) {
				if (linea.isBlank())
					continue;

				String[] partes = linea.split(separador);

				String dni = partes[0].trim();
				String nombre = partes[1].trim();
				char sexo = partes[2].trim().charAt(0);
				int categoria = Integer.parseInt(partes[3].trim());
				int anyos = Integer.parseInt(partes[4].trim());

				try {
					EmpleadoModelo e = new EmpleadoModelo(dni, nombre, sexo, categoria, anyos);
					listaEmpleados.add(e);
				} catch (FormatoDniException | FormatoSexoException | EmpleadoDataException e) {
					System.out.println("Error creando empleado " + dni + ": " + e.getMessage());
				}
			}
		} catch (IOException ex) {
			System.out.println("Error al leer el fichero: " + ex.getMessage());
		}

		return listaEmpleados;
	}

	public int actualizarEmpleadosTxt(List<Empleado> empleados) {
		String ruta = "data/empleados.txt";
		String cabecera = "dni;nombre;sexo;categoria;anyos";
		int filasEscritas = 0;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {

			bw.write(cabecera);
			bw.newLine();

			for (Empleado e : empleados) {
				String dni = e.dni;
				String nombre = e.nombre;
				String sexo = String.valueOf(e.sexo);
				String categoria = String.valueOf(e.getCategoria());
				String anyos = String.valueOf(e.anyos);

				bw.write(dni + ";" + nombre + ";" + sexo + ";" + categoria + ";" + anyos);
				filasEscritas++;
				bw.newLine();
			}
			
			return filasEscritas;

		} catch (IOException e) {
			System.out.println("Error al escribir el fichero: " + e.getMessage());
			return filasEscritas;
		}
	}
	
	public int actualizarEmpleadosModeloTxt(List<EmpleadoModelo> empleados) {
		String ruta = "data/empleados.txt";
		String cabecera = "dni;nombre;sexo;categoria;anyos";
		int filasEscritas = 0;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {

			bw.write(cabecera);
			bw.newLine();

			for (EmpleadoModelo e : empleados) {
				String dni = e.getDni();
				String nombre = e.getNombre();
				String sexo = String.valueOf(e.getSexo());
				String categoria = String.valueOf(e.getCategoria());
				String anyos = String.valueOf(e.getAnyos());

				bw.write(dni + ";" + nombre + ";" + sexo + ";" + categoria + ";" + anyos);
				filasEscritas++;
				bw.newLine();
			}
			
			System.out.println("Archivo " + ruta + " creado correctamente.");
			return filasEscritas;

		} catch (IOException e) {
			System.out.println("Error al escribir el fichero: " + e.getMessage());
			return filasEscritas;
		}
	}

}
