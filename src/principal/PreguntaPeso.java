package principal;

/***
 * Ejercicio 4B
 * Este programa pregunta al usuario por el dni y nuevo peso del personaje.
 * Actualiza el peso del personaje y responde con la difrencia con el peso anterior
 * Usa y actualiza el fichero creado en la clase GuardaDatos, si se quiere resetear el fichero ejecutar dicha clase
 */

import java.io.*;
import java.util.*;

public class PreguntaPeso {

	public static void main(String[] args) {
		File fic = new File("Marvel.dat");

		Scanner leerTeclado = new Scanner(System.in);
		System.out.println("Introduzca el DNI (con letra) del personaje para control de peso:");
		String dniTeclado = leerTeclado.next();
		System.out.println("Introduzca su peso actual:");
		int pesoTeclado = leerTeclado.nextInt();
		
		
		
		try {
			RandomAccessFile file = new RandomAccessFile(fic, "rw");
			int peso, posicion;
			char[] dni = new char[9];
			char[] nombre = new char[10];
			boolean encontrado = false;
			//Añado los bytes del primer int (id)
			posicion = 4;
			
			while(posicion < file.length() && !encontrado) {
				file.seek(posicion);
				
				for(int i = 0; i < dni.length; i++) {
					dni[i] = file.readChar();
				}
				String dniCompleto = new String(dni);
				
				for(int i = 0; i < nombre.length; i++) {
					nombre[i] = file.readChar();
				}
				String nombreCompleto = new String(nombre);
				
				// Añado los bytes de los 4 strings
				posicion += (9*2) + (10*2) + (20*2) + (10*2);
				file.seek(posicion);
				peso = file.readInt();
				
				if(dniTeclado.equalsIgnoreCase(dniCompleto)) {
					if(pesoTeclado > peso) {
						System.out.println(nombreCompleto + " ha engordado " + (pesoTeclado - peso) + " kilos");
					}else if(pesoTeclado < peso) {
						System.out.println(nombreCompleto + " ha adelgazado " + (peso - pesoTeclado) + " kilos");
					}else {
						System.out.println(nombreCompleto + " se mantiene en su peso anterior");
					}
					file.seek(posicion);
					file.writeInt(pesoTeclado);
					encontrado = true;
				}
				// Añado los bytes de los 3 ints(peso, altura e id)
				posicion += 4 + 4 + 4;
			}
			
			if(!encontrado) {
				System.out.println("Error: el dni no se corresponde a ningun personaje");
			}
			
			file.close();	
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
