package ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import laboral.Empleado;
import laboral.Nomina;
import modelos.EmpleadoModelo;

public class GestorFicheroSueldo {

	public int escribirSueldosDat(List<Empleado> empleados) {
		String ruta = "data/sueldos.dat";
		int filasEscritas = 0;

		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(ruta))) {

			for (Empleado e : empleados) {
				dos.writeUTF(e.dni);
				dos.writeDouble(Nomina.sueldo(e));
				filasEscritas++;
			}

			System.out.println("Archivo " + ruta + " creado correctamente.");
			return filasEscritas;

		} catch (IOException ex) {
			System.out.println("Error al escribir sueldos.dat: " + ex.getMessage());
			return filasEscritas;
		}
	}

	// He creado este método principalmente porque en laparte 5 se trabaja con
	// 'EmpleadoModelo'
	// podría haber evitado crear metodos iguales para distintos objetos, habiendo
	// creado un metodo que convierta un empleado en EmpladoModelo
	// pero he preferido hacerlo de esta manera para no llamar a un metodo de
	// conversion todo el tiempo practicamente.
	public int escribirSueldosDatEmpleadosModelo(List<EmpleadoModelo> empleados) {
		String ruta = "data/sueldos.dat";
		int filasEscritas = 0;

		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(ruta))) {

			for (EmpleadoModelo e : empleados) {
				dos.writeUTF(e.getDni());
				dos.writeDouble(Nomina.sueldo(e));
				filasEscritas++;
			}

			System.out.println("Archivo " + ruta + " creado correctamente.");
			return filasEscritas;

		} catch (IOException ex) {
			System.out.println("Error al escribir sueldos.dat: " + ex.getMessage());
			return filasEscritas;
		}
	}

	public void leerSueldosDat() {
		String ruta = "data/sueldos.dat";

		try (DataInputStream dis = new DataInputStream(new FileInputStream(ruta))) {

			while (dis.available() > 0) {
				String dni = dis.readUTF();
				double sueldo = dis.readDouble();
				System.out.println(dni + " -> " + sueldo);
			}

		} catch (IOException e) {
			System.out.println("Error al leer sueldos.dat: " + e.getMessage());
		}
	}

}
