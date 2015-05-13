/**
 * 
 */
package ficheros.ejemplos.basico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

/**
 * Hacer una clase para almacenar en memoria un fichero de texto. 
 * Concretamente, en un array de Strings Además, la clase debe aportar 
 * otro método, para volcar el contenido en memoria a un fichero de texto.
 * @author Alberto Vivas
 */
public class EscribirFicheros {

	/**
	 * Funcion para escribir en un fichero
	 * Function to write a file with a String
	 * @param nombreArchivo
	 * @param contenido
	 * @throws IOException
	 */
	private void EscribirAFicheros(String nombreArchivo, String [] contenido) throws IOException{
		FileWriter writer = null;
		BufferedWriter bw = null;
		try {
		
			writer = new FileWriter(nombreArchivo);
			bw = new BufferedWriter(writer);
			
			for (int i = 0; i < contenido.length; i++) {
				bw.write(contenido[i]);
				bw.newLine();
			}
			
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error al escribir el fichero: "+nombreArchivo);
		}finally {
			try {
				if (bw != null){
				bw.flush();
				bw.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("Error al cerrar el buffer");
			}
		} 
	}
	/**
	 * Funcion que nos crea un archivo segun el nombre dado
	 * Function that create a new file with a given name
	 * @param nombreFichero
	 * @throws IOException
	 */
	private void CrearFichero(String nombreFichero) throws IOException{
		File file = new File(nombreFichero); //creamos file
		file.createNewFile();		//creamos el objeto
	}
	
	/**
	 * Funcion que permite leer un fichero
	 * Function that allow to read a file 
	 * @param nombreFichero
	 * @return String
	 * @throws IOException
	 */
	private String[] LeerFichero(String nombreFichero) throws IOException{
		FileReader fr = null;
		BufferedReader br = null;
		String contenidoArchivo [] = null;
		
		try {
		fr = new FileReader(nombreFichero);
		br = new BufferedReader(fr);
		
		String linea = null;
		int i = 0;
		contenidoArchivo = new String [ContarLineasFichero(nombreFichero)];
		//System.out.println("Lineas:   "+ContarLineasFichero(nombreFichero));
		
		
		while ((linea = br.readLine())!= null) {
			contenidoArchivo[i]=linea;
			//System.out.println(linea);
			i++;
		}
		
		//br.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error al leer el fichero: "+nombreFichero);
		}finally {
			try {
				if (br != null){
				br.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("Error al cerrar el buffer");
			}
		} 
		return contenidoArchivo;
	}
	
	/**
	 * Funcion para mostrar un fichero
	 * Function that print a file
	 * @param nombreFichero
	 * @throws IOException
	 */
	private void MostrarFichero(String nombreFichero) throws IOException{
		String [] array = null;
		
		array = LeerFichero(nombreFichero);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		
	}
	
	/**
	 * Funcion que cuenta las lineas de un fichero
	 * Function that gives the amount of lines in a file
	 * @param nombreFichero
	 * @throws IOException 
	 */
	private int ContarLineasFichero(String nombreFichero) throws IOException {
		int numeroDeLineas = 0;
		// TODO Auto-generated method stub
		FileReader archivo = new FileReader(nombreFichero);
		BufferedReader br = new BufferedReader (archivo);
		
		while ((br.readLine())!= null) {
			numeroDeLineas++;
			
		}
		
		//br.lines().count(); //con esto se cuenta el numero de lineas facilmente
		return numeroDeLineas;
	}

	
//hacer un metodo que copie un fichero de bites
	//fileimputstream
	//fileoutputstream

	private void LeerFicheroBin(String direccion) throws IOException{
		File file =null;
		FileInputStream fis = null;
		
		try {
			file = new File(direccion);
			fis = new FileInputStream(file);
			
			System.out.println("El archivo "+direccion+" tiene "+fis.available()+" bytes");//numero de bytes del archivo
			
			int contenido =0;
			while ((contenido= fis.read() )!= -1) {
				System.out.print((char) contenido);
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error al leer el fichero: "+direccion);
		}finally {
			try {
				if (fis != null){
				fis.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("Error al cerrar el buffer");
			}
		}
		
	}
	private void EscribirFicheroBin() {
		
	}
	
	private void CopiarFicheroBin(String direccion) throws IOException{
		File file =null;
		File fileNew =null;
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		
		try {
			file = new File(direccion);
			fileNew = new File("Copia de "+direccion);
			fileInputStream = new FileInputStream(file);
			fileNew.createNewFile();
			fileOutputStream = new FileOutputStream(fileNew);
			
			int contenido =0;
			while ((contenido= fileInputStream.read() )!= -1) {
				fileOutputStream.write(contenido); 
				
			}
			
			
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error al leer el fichero: "+direccion);
		}finally {
			try {
				if (fileInputStream != null){
				fileInputStream.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("Error al cerrar el buffer");
			}
		}
		
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		
		try {
			EscribirFicheros fichero = new EscribirFicheros();
			String nombreFichero = "prueba1.txt";
			String [] contenido = new String []{"esto\n", "es\n", "una\n","prueba\n"};
			
			
			fichero.CrearFichero(nombreFichero);
			fichero.EscribirAFicheros(nombreFichero, contenido);
			fichero.MostrarFichero(nombreFichero);
			fichero.MostrarFichero("caca.txt");
			
			System.out.println("BIN!!!");
			
			fichero.LeerFicheroBin("caca.txt");
			
			fichero.CopiarFicheroBin("java.pdf");
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ //Se haya producido o no una excepción, finally se ejecutará, de modo que nos 		         
			//aseguramos de cerrar el fichero
			try{
					if( null!= br ){
						br.close();}
					}catch (Exception e2){
						e2.printStackTrace();
						}
			}

		
		
		
		
	}

}
