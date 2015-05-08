package ficheros.ejemplos.basico;

import java.io.File;
import java.util.Scanner;

public class PruebaFicheros {

	/** Programa de inicio a los ficheros, te permite navegar, ver carpetas y subcarpetas 
	 * @param args
	 * @author Alberto_Vivas
	 */
	
	
	/**
	 * Con esta funcion puedo imprimir cualquier String
	 * @param cadena
	 */
	private static void MostrarCadena(String [] cadena) {
		int longitud = cadena.length;
		for (int i = 0; i < longitud; i++) {
			System.out.println(cadena[i]);
		}
	}
	
	/** 
	 * Similar al dir de msdos
	 * @param direccion
	 */
	private static void dir(String direccion){
		File directorio = new File(direccion);
		String [] cddir = null;
		cddir = directorio.list();
		MostrarCadena(cddir);
	}
	
	/**
	 * Abre el Scanner y lee por teclado. Acepta el siguiente String
	 * @return
	 */
	private static String PedirCadena() {
		String rpta = null;
		Scanner sc= new Scanner(System.in);
		rpta = sc.next();
		return rpta;
	}
	
	/**
	 * Una mejora del dir anterior, solo que accede a la raiz y subcarpetas
	 * @param direccion
	 */
	private static void dirPunto(String direccion){
		File directorio = new File(direccion);
		File directorio2 = null;
		String [] cddir = null;
		String [] cddir2 = null;
		cddir = directorio.list();
		
		for (int i = 0; i < cddir.length; i++) {
			directorio2 = new File (cddir[i]);
			cddir2 = directorio2.list();
			System.out.println(cddir[i]);
			if (directorio2.isDirectory()){
				
				for (int j = 0; j < cddir2.length; j++) {
					dirPunto(cddir2[j]);
				//	System.out.println("       "+cddir2[j]);
				}
			}	
		}
	}
	/**
	 * mejora de el dir punto con uso recursivo 
	 * @param direccion
	 * @param cadspace
	 */
	
	private void dirPuntov2( String direccion , String cadspace){
		File directorio = new File(direccion);
		String [] cddir = null;
		
		
		System.out.println(cadspace+directorio.getName());
		if (directorio.isDirectory()) {
			cddir = directorio.list();
			for (String cad : cddir ) {
				dirPuntov2(direccion+"\\"+cad, cadspace+"   ");
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		boolean exit = false;
		String direccion = null;
		PruebaFicheros pruebaFicheros = new PruebaFicheros();
		do {
			System.out.println("Introducir directorio a acceder");
			direccion = PedirCadena();
			if (direccion.equals(".")) {
				//dirPunto(direccion);
				pruebaFicheros.dirPuntov2(".","");
			} else {
				if (direccion.equals("exit")){
					exit = true;
					}else{dir(direccion);
					}
				}
		} while (!exit);
		
		System.out.println("fin....");
	}

}
