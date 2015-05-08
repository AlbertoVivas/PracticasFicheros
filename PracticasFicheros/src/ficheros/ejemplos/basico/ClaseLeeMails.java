/**
 * 
 */
package ficheros.ejemplos.basico;

/**
 * @author Alberto Vivas
 *
 * 
 */

//	package val.examples.basic.regexp;
	import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


	public class ClaseLeeMails {
		
		private static final String INICIO_MAIL = "***";
		private static final String FIN_MAIL = "///";
		private static final String MAIL_LEIDO = "*/*";
		
		private static String procesarLinea (String linea_actual)
		{
			String mails_de_linea_actual = "";
			
			
			//TODO este es el método más difícil...recibiré una línea y tendré que extraer de ella todos correos
			//e irlos concatenando en un String de salida
			//Pista---> Sabemos la longuitud de la linea, sabemos que un Email viene encerrado entre símbolos clave...
			// Paciencia y a pensar como si lo estuvieras cogiendo con las manos...ve declarando todas las condiciones, variables y bucles que necesites!!!
			//Poco a poco...El lápiz y papel, ayudan siempre un montón!
			
			linea_actual.indexOf(INICIO_MAIL); //posicion en la que esta ***
			linea_actual.indexOf(FIN_MAIL);	  //posicion de los ///
			
			//while(((linea_actual.indexOf(INICIO_MAIL))&(linea_actual.indexOf(FIN_MAIL)))!= -1){//si hay un mail en la linea
			//while((linea_actual.indexOf(INICIO_MAIL))!= -1){//si hay un mail en la linea
				if((linea_actual.indexOf(INICIO_MAIL))!= -1) {				
				mails_de_linea_actual += linea_actual.substring(linea_actual.indexOf(INICIO_MAIL)+3, linea_actual.indexOf(FIN_MAIL)+1);//almaceno mail con /
				//linea_actual.replaceFirst("[\\*\\*\\*]{1}", MAIL_LEIDO); //Machaco el string que me indica que empieza un mail
				//linea_actual.replaceFirst("/{3}", MAIL_LEIDO);	//Machaco el string que me indica que termina un mail
				
			}
				
			return mails_de_linea_actual;
		}
		
		
		/**
		 * Este métdo ya viene hecho!
		 * En él, recorro el fichero y devuelvo un String, que estará compuesto por todos
		 * los mails que aparecen en el fichero separados por /
		 * 
		 * Por ejemplo, para este fichero: 
		 * 
		 * vxscavsdfgv***susana@kelly.org///asv afsvasczx xcvasdf'ow048t09q38r`0gf9uq nw9eru`	wefu8ioW´`EO
		 * qer`kgq`pegiq3'5oyq'3'oaae'5oy'q35oy'q35oygadkfbbASKLF,B`R,BEPÈD,FVA´PSF,DVÑ,AFS`BKAFSÇKBAFDÑS
	     * AOBRJ KQG'¡3KGP`KVASF***francesco@hp.es///BLALÑDFBMMA
	     * 
	     * debería devolver un String que fuera susana@kelly.org/francesco@hp.es
	     * 
	     * Para simplificar el proceso, cada línea obtenida del fichero, la voy
	     * a procesar aparte, en el método procesarLinea; siguiendo así una máxima en programación:
	     * Si una cosa es muy larga o complicada....LA DIVIDO!
		 * 
		 * @param br
		 * @return
		 * @throws IOException
		 */
		private static String obtenerEmails (BufferedReader br) throws IOException
		{
			String lista_mails = "";
			String linea = null;
		
			boolean final_fichero = false;
			
			while (!final_fichero)
			{
				linea = br.readLine();
				if (linea == null)
				{
					final_fichero = true;
				} else 
					{
						lista_mails = lista_mails + procesarLinea (linea);
					
					}
			}
			
			return lista_mails;
			
		}
		
		private static BufferedReader abrirYPrepararFichero (String nombre) throws FileNotFoundException
		{
			BufferedReader br = null;
			
			//TODO Abrir y preparar la lectura de un fichero de texto
			FileReader file = new FileReader(nombre);
			
			br = new BufferedReader(file); 
			
			return br;
		}
		
		private static String [] hacerArrayDeMails (String lista_mails)
		{
			String [] array_mails = null;
			
			array_mails = lista_mails.split("/");
			//Recibo un String que contiene TODOS los mails, separados por una / ej: mail1/mail2/
			//Tengo que separarlos y devolver un array de Mails PISTA --> método split de la clase String
			
			return array_mails;
		}
		
		private static void mostrarMails (String [] lista_mails)
		{
			//TODO Recorrer la lista de mails. Sólo para comprobar que ha ido bien
			System.out.println("mails!!!");
			for (int i = 0; i < lista_mails.length; i++) {
				System.out.println(lista_mails[i]);
			}
			
			
		}
		
		private static void ordenarMails (String [] array_mails)
		{
			//TODO OPCIONAL Tengo que ordenar el array de Strings y devolverlo
			Arrays.sort(array_mails);
			
		}
		
		private static void cerrarFichero (BufferedReader br) throws IOException
		{
			//TODO Recibo un fichero y lo devuelvo cerrado
			br.close();
		}
		

		/**
		 * NOTA Todos los métodos de la clase son static, para facilitar su uso sin tener
		 * que instanciar un Objeto. Si no fueran static, con declarar un objeto de la clase
		 * ya podría llamar a los métodos, por ejempleo
		 * 	
		 * 	ClaseLeeMails clm = new ClaseLeeMails();
		 *  clm.ababrirYPrepararFichero ... etc 
		 *  
		 *  OK????
		 * 	 
		 * */
		
		public static void main(String[] args) throws IOException {
			
			String nombre = "emails.txt";//el nombre del fichero de entrada
			String lista_mails = null; //aquí guardaré los mails, separados por la el símbolo /
			String [] array_mails = null; //aquí guardaer los mails, cada uno en su posición!
			BufferedReader br = null; // Objeto para leer un fichero de texto por líneas!
			
					
			br = abrirYPrepararFichero(nombre);
			lista_mails = obtenerEmails(br);
			cerrarFichero (br);
			array_mails =  hacerArrayDeMails(lista_mails);
			ordenarMails (array_mails); // Este método es opcional, aunque luego veremos que es muy fácil de hacer!
			mostrarMails(array_mails);
			
			String prueba = "asdfasdfvbasbdvasdckjasdcf***caca@kk.com///sadhfgbasbflasbdfasdfkjasdfkjasfba";
			System.out.println(prueba);
			System.out.println(procesarLinea(prueba));
			
		}
		
	}