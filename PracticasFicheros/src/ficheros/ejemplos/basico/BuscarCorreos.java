/**
 * 
 */
package ficheros.ejemplos.basico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.naming.LimitExceededException;

/**
 * recibido un txt
 * 
 * buscar emails
 * volcarlo en un String
 * ordenar el String
 * 
 * @author Alberto Vivas
 *
 * 
 */
public class BuscarCorreos {

	
	private String[] encuentraBarra(String direccion){
	
		FileReader fr=null;
		BufferedReader br = null;
		String correo [] = new String [15];
		int bit =0;
		
		formatearString(correo);
		
		try {
			fr = new FileReader(direccion);
			br = new BufferedReader(fr);
			int i = 0;
			//char[] c_a = new char[1];
			
			while (bit!= -1){//mientras no se ha terminado el fichero
				
				
				//br.read(c_a, 0, 1);
				bit=br.read();
				char letra = (char)bit;
				//char letra= (char) br.read(c_a, 0, 1);
				//System.out.println((char)br.read());
				if(letra == '*'){
					correo[i]="";
					letra=(char)br.read();//  \
					letra=(char)br.read();//  |
					letra=(char)br.read();//  |-- elimino los 3*
					letra=(char)br.read();//  |
					letra=(char)br.read();//  |
					letra=(char)br.read();//  /
					while(letra!= '/'){
						//System.out.println(letra);
						correo[i]+=letra;
						//System.out.println("--------------"+letra);
						letra=(char)br.read();//elimino el bit basura
						letra=(char)br.read();
						//letra= (char) br.read(c_a, 0, 1);
								
					}
					//System.out.println(correo[i]);
					i++;
					
					
				}
				
				
				
				
			}
			
			
			
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error al escribir el fichero: "+direccion);
		}finally {
			try {
				if (br != null){
				br.close();
				//return correo;
				}
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("Error al cerrar el buffer");
			}
		} 
		
		
		
		return correo;
	}
	
	/*private int ContarLineasFichero(String nombreFichero) throws IOException {
		int numeroDeLineas = 0;
		// TODO Auto-generated method stub
		FileReader archivo = new FileReader(nombreFichero);
		BufferedReader br = new BufferedReader (archivo);
		
		while ((br.readLine())!= null) {
			numeroDeLineas++;
			
		}
		
		//br.lines().count(); //con esto se cuenta el numero de lineas facilmente
		return numeroDeLineas;
	}*/

	private static void formatearString(String [] cadena){
		
		for (int i = 0; i < cadena.length; i++) {
			cadena[i]="";
		}
	}

	private static int contarNoBlancos(String [] cadena){
		int respuesta=0;
		
		for (int i = 0; i < cadena.length; i++) {
			if(!cadena[i].equals("")){
				respuesta++;
			}
		}
		
		return respuesta;
	}
	
	private static String [] cadenaLimpia(String [] cadena){
		String [] respuesta = new String [contarNoBlancos(cadena)];
		formatearString(respuesta);
			
		for (int i = 0; i < contarNoBlancos(cadena); i++) {
			respuesta[i]=cadena[i];
		}
		return respuesta;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String correos [] = null;
		String correoslimpios [] = null;
		BuscarCorreos texto = new BuscarCorreos();
		
	
		
		correos = texto.encuentraBarra("emails.txt"); //Proceso el txt y obtengo los correos en cada posicion del array
		correoslimpios = new String[contarNoBlancos(correos)];
		correoslimpios=cadenaLimpia(correos);//El array de correos lo pulo creo uno del tamaño adecuado
		Arrays.sort(correoslimpios);//ordeno los correos por orden alfabetico
		System.out.println("correos Limpios!!!!");
		for (int i = 0; i < correoslimpios.length; i++) {//  \
			if(correos[i]!= null){						 //  |--- Imprimo los mails :)
			System.out.println(correoslimpios[i]);		 //  |
			}										     //  /
		}
	
		
		
	}

}