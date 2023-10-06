package principal;
/**
 * Ejercicio 4C
 * Este programa imprime en consola una lista de los personajes del tipo deseado
 * Usa el fichero creado en la clase GuardaDatos, si se quiere resetear el fichero ejecutar dicha clase
 */
import java.io.*;
import java.util.*;
public class VisualizaPersonaje {

	public static void main(String[] args) {
		File fic = new File("Marvel.dat");
		
		Scanner leerTeclado = new Scanner(System.in);
		System.out.println("Introduce un tipo de personaje: ");
		String tipoTeclado = leerTeclado.nextLine();
		leerTeclado.close();
		
		char[] dniChar = new char[9];
		char[] nombreChar = new char[10];
		char[] tipoChar = new char[10];
		char[] identidadChar = new char[20];
		
		int peso, altura;
		ArrayList<Personaje> lista = new ArrayList<Personaje>();
		// Nos situamos despues del primer int(id)
		int posicion = 4;
		int cantidad = 0;
		
		try {
			RandomAccessFile file = new RandomAccessFile(fic, "r");
			
			while(file.getFilePointer() != file.length()) {
				file.seek(posicion);

				String dni = leeString(dniChar, file);
				String nombre = leeString(nombreChar, file);
				String identidad = leeString(identidadChar, file);
				String tipo = leeString(tipoChar, file);
				peso = file.readInt();
				altura = file.readInt();

				if(tipoTeclado.equalsIgnoreCase(tipo)) {
					Personaje personaje = new Personaje(dni, nombre, identidad, tipo, peso, altura);
					cantidad++;
					lista.add(personaje);
				}

				posicion += 110;
			}
			
			if(cantidad > 1) {
				System.out.println("Se han encontrado " + cantidad + " " + tipoTeclado + "s.");
			}else if(cantidad == 1) {
				System.out.println("Se ha encontrado " + cantidad + " " + tipoTeclado + ".");
			}else {
				System.out.println("No existen " + tipoTeclado + "s en el fichero.");
			}
			
			for(Personaje persona : lista) {
				System.out.println(persona.toString());
			}
			
			file.close();
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}	
	}
	
	/**
	 * Metodo que rellena los arrays de char del fichero para convertirlos en un String
	 * @param array con el array que queremos rellenar
	 * @param file con un RandomAccesFile que queremos usar
	 * @return con el String formateado sin espacios
	 */
	public static String leeString(char[] array, RandomAccessFile file) {
		try {
			for(int i = 0; i < array.length; i++) {
				array[i] = file.readChar();
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}

		return new String(array).trim();
	}
}



