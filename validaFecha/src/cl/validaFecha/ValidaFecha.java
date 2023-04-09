package cl.validaFecha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ValidaFecha {
	static boolean validado;

	public static void main(String[] args) {
		String fecha1, fecha2, fecha1OK, fecha2OK;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("PERSONA 1 \nIngrese fecha de nacimiento, 'dd/mm/yyyy'");
			fecha1 = sc.nextLine();

			fecha1OK = validaFormatoFecha(fecha1);

		} while (!validado);

		System.out.println(fecha1OK + "  FECHA VALIDADA CORRECTAMENTE");	
		do {
			System.out.println("\nPERSONA 2 \nIngrese fecha de nacimiento, 'dd/mm/yyyy'");
			fecha2 = sc.nextLine();

			fecha2OK = validaFormatoFecha(fecha2);

		} while (!validado);

		System.out.println(fecha2OK + "  FECHA VALIDADA CORRECTAMENTE");

		sc.close();
	}

//	METODO VALIDACION DE FECHA
	private static String validaFormatoFecha(String fechaIngresada) {

		validado = false;
		String fechaValidada = "";

		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy");
		formatoFecha.setLenient(false);
		/*
		 * El método setLenient(boolean leniency) en la clase DateFormat se usa para
		 * especificar si la interpretación de la fecha y la hora de este objeto
		 * DateFormat debe ser indulgente o no.
		 */
		try {
			Date fecha = formatoFecha.parse(fechaIngresada);

			SimpleDateFormat nuevoFormatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			fechaValidada = nuevoFormatoFecha.format(fecha);
			validado = true;

		} catch (ParseException e) {
			System.out.println("dato incorrecto!\n");

		}
		return fechaValidada;
	}

}
