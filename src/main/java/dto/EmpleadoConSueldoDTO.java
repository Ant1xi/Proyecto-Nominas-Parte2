package dto;

/*
 * He creado esta clase principalmente para llenar la lista de 'VentanaRecalcularSueldoEmpleado' 
 * para poder mostrar el sueldo conjunto a los datos del empleado, 
 * para que así se pueda ver si el sueldo ha sido modificado al refrescar la ventana
 * */

public class EmpleadoConSueldoDTO {

	private String dni;
	private String nombre;
	private Character sexo;
	private Integer categoria;
	private Integer anyos;
	private Double sueldo;

	public EmpleadoConSueldoDTO(String dni, String nombre, Character sexo, Integer categoria, Integer anyos,
			Double sueldo) {

		this.dni = dni;
		this.nombre = nombre;
		this.sexo = sexo;
		this.categoria = categoria;
		this.anyos = anyos;
		this.sueldo = sueldo;
	}

	public EmpleadoConSueldoDTO(String nombre, Character sexo, Integer categoria, Integer anyos, Double sueldo) {

		this.nombre = nombre;
		this.sexo = sexo;
		this.categoria = categoria;
		this.anyos = anyos;
		this.sueldo = sueldo;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public Character getSexo() {
		return sexo;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public Integer getAnyos() {
		return anyos;
	}

	public Double getSueldo() {
		return sueldo;
	}

	@Override
	public String toString() {
		String sexoPalabra = "sin sexo asignado";

		if (sexo.equals('M')) {
			sexoPalabra = "Hombre";
		} else if (sexo.equals('F')) {
			sexoPalabra = "Mujer";
		}

		return nombre + ", " + sexoPalabra + ", Categoría: " + categoria + ", Años trabajados: " + anyos + ", Sueldo: "
				+ sueldo;
	}

}
