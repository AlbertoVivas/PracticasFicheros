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
 * @author Val
 *
 *El código de esta clase, es un poco misterioso. Algún programador Clase "C", no ha usado
 *nombres descriptivos y ahora, nos toca pegarnos y descubrir qué narices hace este código, 
 *para poder usarlo en nuestro proyecto.
 *
 *
 *Se pide:
 */

/**
 *1) Adivinar la funcionalidad del método adivinaQueHace
 */

/**
 *2) Una vez descubierto, aplicar un nombre apropiado al método y a la clase
 */

/**
 *3) Idear un método equivalente, pero distinto. Es decir, crear un método 
 *que haga lo mismo que adivinaQueHace, pero de otra manera.
 */

/**
 *4) EXTRA: Sólo si resolviste los puntos anteriores, implementa una versión
 * recursiva
 *
 */
public class AdivinaQueHaceSolucion {

	/**
	 *1) Adivinar la funcionalidad del método adivinaQueHace
	 */
	
	/**
	 * Su funcionalidad es averiguar si una palabra se lee igual de 
	 * izquierdas como de derechas, es decir que la palabra es un :
	 *  Palindromo
	 * 
	 */
	
	
	/**
	 *2) Una vez descubierto, aplicar un nombre apropiado al método y a la clase
	 *
	 *private static boolean adivinaQueHace (String cad)
	{
		boolean bd = true;
		
		int i = 0;
		int j = cad.length()-1;
		
		while ((i<=j)&&(bd))
		{
			bd = cad.charAt(i)==cad.charAt(j);
			i++;
			j--;
		}
		
		
		return bd;
	}
	 */
	
	
	private static boolean esPalabraPalindromo (String cad)
	{
		boolean respuesta = true;
		
		int i = 0;
		int j = cad.length()-1;
		
		while ((i<=j)&&(respuesta))
		{
			respuesta = cad.charAt(i)==cad.charAt(j);
			i++;
			j--;
		}
		
		
		return respuesta;
	}
	
	/**
	 *3) Idear un método equivalente, pero distinto. Es decir, crear un método 
	 *que haga lo mismo que adivinaQueHace, pero de otra manera.
	 */
	
	private static String volteameElString(String cadena){
		String respuesta = "";
		int longitud = cadena.length()-1;
		for (int i = 0; i <= longitud; i++) {
			respuesta += cadena.charAt(longitud-i);
		}
		return respuesta;
	}
	
	private static boolean esPalabraPalindromov2(String cadena){
		return cadena.equals(volteameElString(cadena));
	}
	/**
	 *4) EXTRA: Sólo si resolviste los puntos anteriores, 
	 *implementa una versión recursiva
	 *
	 *
	 *Para este metodo la clase base es si la cadena tiene una longitud
	 *de 1 o 2, de modo que si es 1 es palindroma, y si es 2 es palindroma
	 *cuando los caracteres son iguales
	 *
	 *para el caso recursivo, comparo la primera con la ultima, 
	 *y si son iguales, vuelvo a invocar el metodo.
	 *
	 */
	
	private static boolean palindromaRecursiva(String cadena){
		boolean respuesta = false;
		
		if(cadena.length()==1){ // cadena de un solo caracter 1er caso
			respuesta = true;	// de nuestro caso base
		}else{
			if((cadena.length()==2)&&(cadena.charAt(0)==cadena.charAt(1))){
				//System.out.println("2.-"+(cadena.charAt(0)==cadena.charAt(1)));
				respuesta = true; //Si son 2 caracteres e iguales (Y)
			}else{
				if ((cadena.charAt(0)==cadena.charAt(cadena.length()-1))) {
					//System.out.println("3.-"+(cadena.charAt(0)==cadena.charAt(cadena.length()-1)));
					//System.out.println(cadena.substring(1, cadena.length()-1));
					respuesta=palindromaRecursiva(cadena.substring(1, cadena.length()-1));
					
				}
				
				
				
			}
		}		
		return respuesta;
	}
	
	private static void imprimirPalindroma(String nombre, boolean b) {
		if(b){
			System.out.println("La palabra: > "+nombre+" < es palindroma!!!");
		}else{
			System.out.println("La palabra: > "+nombre+" < no es palindroma");
		}
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("normal");
		imprimirPalindroma("Alberto",esPalabraPalindromo("Alberto"));
		System.out.println("v2.0");
		imprimirPalindroma("Alberto",esPalabraPalindromov2("Alberto"));
		System.out.println("recursiva");
		imprimirPalindroma("orro", palindromaRecursiva("orro"));
		imprimirPalindroma("oro", palindromaRecursiva("oro"));
		
	}

}
