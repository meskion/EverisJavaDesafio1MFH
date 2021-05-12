package variables;

/**
 * Representa un programador de la empresa Everis
 * 
 * @author mferndel
 *
 */
public class Developer {
	/* Constantes y de clase */

	/** Empresa de los programadores */
	public static final String EMPRESA = "EVERIS";
	/** Maximo numero de empleados */
	public static final byte MAXEMPLEADOS = 127;
	/** Maximos dias de vacaciones */
	public static final byte MAXVACACIONES = 21;
	/** Numero total de empleados en la empresa */
	private static byte totalEmpleados = 0;
	/** nombre del empleado */
	private String nombre;
	/** Codigo interno del empleado */
	private byte numEmpleado;
	/** Dias de vacaciones del empleado */
	private byte diasVacaciones;
	
	/**
	 * Constructor que recibe el nombre del empleado
	 * 
	 * @param nombre
	 *            nombre del empleado
	 */
	public Developer(String nombre) {
		if (totalEmpleados == MAXEMPLEADOS)
			throw new DevLimitException("Limite de programadores sobrepasado");
		
		this.nombre = nombre;
		this.diasVacaciones = MAXVACACIONES;
		this.numEmpleado = totalEmpleados++;
	}

	/**
	 * Sobrecarga del constructor que permite inicializar los dias de vacaciones en un valor entre 0 y MAXVACACIONES
	 * 
	 * @param nombre
	 *            nombre del empleado
	 * @param diasVacaciones
	 */
	public Developer(String nombre, int diasVacaciones) {
		this(nombre);
		if (diasVacaciones < MAXVACACIONES && diasVacaciones >= 0) {
			this.diasVacaciones = (byte) diasVacaciones;
		}
	}

	/**
	 * @return the totalEmpleados
	 */
	public static byte getTotalEmpleados() {
		return totalEmpleados;
	}

	/**
	 * @return el nombre del empleado
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return numero del Empleado
	 */
	public byte getNumEmpleado() {
		return numEmpleado;
	}

	/**
	 * @return dias de vacaciones restantes
	 */
	public byte getDiasVacaciones() {
		return diasVacaciones;
	}

	/**
	 * Resta a los dias de vacaciones el valor absoluto de la cantidad pasada por paramentro. asi los dias solo podrán disminuir. No he controlado que los dias
	 * de vacaciones alcancen valores negativos, pues me parece bien, representando dias que el empleado le debe a la empresa.
	 * 
	 * @param diasUtilizados
	 */
	public void disminuirVacaciones(int diasUtilizados) {
		diasVacaciones = (byte) (diasVacaciones - Math.abs(diasUtilizados));

	}

	/**
	 * Version del metodo en el que no permito que los dias lleguen a valores negativos, dejando el 0 como valor mínimo de los dias de vacaciones.
	 * Deprecado pues no es la implementación que quiero que se use.
	 * @param diasUtilizados
	 */
	@Deprecated
	public void disminuirVacacionesAlt(int diasUtilizados) {
		int diasRestantes = diasVacaciones - Math.abs(diasUtilizados);
		diasVacaciones = (diasRestantes >= 0) ? (byte) (diasRestantes) : 0;

	}

}
