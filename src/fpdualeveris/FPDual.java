package fpdualeveris;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import variables.Developer;

public class FPDual {

	/**
	 * metodo principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		variablesChallenge();
		/* Descomentar la siguiente linea y comentar la anterior para probar otra manera de realizar el desafio */
//		 variablesChallengeALT();
	}

	/**
	 * metodo con las intrucciones del desafio
	 */
	private static void variablesChallenge() {
		
		/* Creamos 4 nuevos programadores */
		Developer d1 = new Developer("Manu");
		Developer d2 = new Developer("Javi");
		Developer d3 = new Developer("Andres", 4);
		Developer d4 = new Developer("Raquel");

		/* Mostramos total de empleados desde dos instancias */
		System.out.println("Numero total de empleados accediendo desde el primer programador: " + d1.getTotalEmpleados());
		System.out.println("Numero total de empleados accediendo desde el cuarto programador: " + d4.getTotalEmpleados());
		/* ambas son equivalentes a Developer.getTotalEmpleados(), pero esta ultima es mas correcta*/
		
		/* Mostramos los numeros de empleado de cada programador */
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
		
		/* Creamos 4 nuevos programadores */
		Developer d1 = new Developer("Manu");
		Developer d2 = new Developer("Javi");
		Developer d3 = new Developer("Andres", 4);
		Developer d4 = new Developer("Raquel");
		
		/* Creo una lista con los objetos creados */
		List <Developer> developers = Arrays.asList(d1, d2, d3, d4);
		/*  (Alternativa con API Stream)*/
		//List<Developer> developers = Stream.of(d1, d2, d3, d4).collect(Collectors.toList());
		
		/* Mostramos total de empleados desde todas las instancias y todas deberian dar lo mismo */
		developers.forEach(
		        dev -> System.out.println("Numero total de empleados accediendo desde el programador " + dev.getNombre() + ": " + dev.getTotalEmpleados()));

		/* Mostramos los numeros de empleado de cada programador */
		developers.forEach(
				dev -> System.out.println("Numero de empleado del programador " + dev.getNombre() + ": " + dev.getNumEmpleado()));

		/* Disminuimos en dos dias las vacaciones del empleado 2 */
		developers.get(1).disminuirVacaciones(2);
		
		/* Mostramos los dias de vacaciones de cada programador */
		developers.forEach(
				dev -> System.out.println("Dias de vaciones del programador " + dev.getNombre() + ": " + dev.getDiasVacaciones()));

	}

}
