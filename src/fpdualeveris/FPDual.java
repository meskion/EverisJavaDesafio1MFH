package fpdualeveris;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import variables.Developer;

/**
 * Clase principal
 * 
 * @author mferndel
 *
 */
public class FPDual {

	/** Ruta del archivo de nombres */
	private static final Path NAMESPATH = Path.of("names.txt");
	/** Objeto random para generar aleatoriedad */
	private static final Random RAND = new Random();
	/** Minimo numero de devs a generar */
	private static final int MINDEVS = 10;
	/** Maximo numero de devs a generar */
	private static final int MAXDEVS = 20;

	/**
	 * metodo principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		variablesChallenge();
		/* Descomentar la siguiente linea y comentar la anterior para probar otra manera de realizar el desafio */
		// variablesChallengeALT();
	}

	/**
	 * Metodo con las intrucciones del desafio
	 */
	private static void variablesChallenge() {

		/* Creamos 4 nuevos programadores */
		final Developer d1 = new Developer("Manu");
		final Developer d2 = new Developer("Javi");
		final Developer d3 = new Developer("Andres", 4);
		final Developer d4 = new Developer("Raquel");

		/* Mostramos total de empleados desde dos instancias */
		System.out.println("Numero total de empleados accediendo desde el primer programador: " + d1.getTotalEmpleados());
		System.out.println("Numero total de empleados accediendo desde el cuarto programador: " + d4.getTotalEmpleados());
		/* ambas son equivalentes a Developer.getTotalEmpleados(), pero esta ultima es mas correcta */

		/* numeros de empleado de cada programador */
		System.out.println("Numero de empleado del programador 1: " + d1.getNumEmpleado());
		System.out.println("Numero de empleado del programador 2: " + d2.getNumEmpleado());
		System.out.println("Numero de empleado del programador 3: " + d3.getNumEmpleado());
		System.out.println("Numero de empleado del programador 4: " + d4.getNumEmpleado());

		/* Disminuimos en dos dias las vacaciones del empleado 2 */
		d2.disminuirVacaciones(2);

		/* Mostramos los dias de vacaciones de cada programador */
		System.out.println("Dias de vaciones del programador 1: " + d1.getDiasVacaciones());
		System.out.println("Dias de vaciones del programador 2: " + d2.getDiasVacaciones());
		System.out.println("Dias de vaciones del programador 3: " + d3.getDiasVacaciones());
		System.out.println("Dias de vaciones del programador 4: " + d4.getDiasVacaciones());

	}

	/**
	 * Quería hacer un poquito extra asi que he rehecho el metodo pero reduciendo un poco el codigo usando una lista y programacion funcional.
	 */
	private static void variablesChallengeALT() {
		List<Developer> developers = null;
		int numDev = RAND.nextInt(MAXDEVS - MINDEVS) + MINDEVS;
		try {
			/*
			 * (Esta linea tellez la tengo formateada por el ctrl-F pero los Streams tan largos te los separaria en mas lineas) Genera una lista de Developers a
			 * partir de un archivo que contiene nombres.
			 */
			developers = Files.lines(NAMESPATH).parallel().limit(numDev).map(n -> new Developer(n, RAND.nextInt(22))).collect(Collectors.toList());

		} catch (IOException e) {
			System.err.println("ERROR: Archivo de nombres no encontrado");
		}

		/* total de empleados desde todas las instancias y todas deberian dar lo mismo */
		developers.forEach(
		        dev -> System.out.println("Numero total de empleados accediendo desde el programador " + dev.getNombre() + ": " + dev.getTotalEmpleados()));

		/* Numeros de empleado de cada programador */
		developers.forEach(dev -> System.out.println("Numero de empleado del programador " + dev.getNombre() + ": " + dev.getNumEmpleado()));

		/* Disminucion en dos dias las vacaciones de un empleado aleatorio */
		developers.get(RAND.nextInt(numDev)).disminuirVacaciones(2);

		/* Mostramos los dias de vacaciones de cada programador */
		developers.forEach(dev -> System.out.println("Dias de vaciones del programador " + dev.getNombre() + ": " + dev.getDiasVacaciones()));

	}

}
