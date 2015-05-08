/**
 * 
 */
package ficheros.ejemplos.basico;

/**
 * @author Alberto Vivas
 *
 * 
 */
/**
 * 
 * 
 * @author Vale
 * 
 * 
 * La siguiente clase contiene un pequeño ejemplo del empleo de Expresiones regulares en Java
 * La expresiones regulares son un mecanismo potente que nos permite prototipar palabras, de forma abreviada.
 * Descrita una expresión regular, la clase String, provee de métodos que ayuda a operar fácilmente con las cadenas
 * que coinciden con la expresión regular.
 * 
 * Siendo cadena un String, puedo aplicar:
 * 
 *cadena.matches("regex")	Devuelve TRUE si cadena, es descrita totalmente por la expresión regular pasada
 *cadena.split("regex")	Me devuelve un array de subcadenas de cadena, usando la expresión regular como separador. "regex" no está incluída en el resultado
 *cadena.replaceFirst("regex"), "replacement") Sustituye la primera aparición de la expresión regular en cadena, con el replacement dado
 *cadena.replaceAll("regex"), "replacement") Sustituye todas las apariciones de la expresión regular, con el replacement dado
 */
public class ExpresionRegularAlberto {
	
	
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String linea = "///asfadfbjp349iu'***hola@madrid.org///0sdg99sdg***";
		
		String expresion_regular_no_mails = "/{3}[\\S\\s]*[\\*\\*\\*]{1}";
		
		System.out.println(linea.matches((expresion_regular_no_mails)));
		String[] devolucion = linea.split(expresion_regular_no_mails);
		
		
		if (devolucion != null)
		{
			for (int i = 0; i < devolucion.length; i++) {
				System.out.println("" + i + " = " +devolucion[i]);
				
			}
		}
		
		
		
	}

}
