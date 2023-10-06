package principal;
/***
 * Ejercicio 4A
 * Este programa carga en un fichero la informacion proporcionada en los arrays
 */
import java.io.*;
public class GuardaDatos {

	public static void main(String[] args) {
		File fic = new File("Marvel.dat");

		int [] ids= {1, 2, 3, 4, 5, 6, 7};
		String[] dnis= {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
		String[] noms= {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
		String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe","James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
		String[] tipos = {"heroe","villano","heroe","heroe","villano","heroe","villano"};
		int[] pesos = {76,84,66,136,78,102,70};
		int[] alturas = {178,183,156,152,177,182,188};
		
		try {
			RandomAccessFile file = new RandomAccessFile(fic, "rw");
			
			StringBuffer bufDni, bufNombre, bufIden, bufTipo = null;
			
			for(int i = 0; i < ids.length; i++) {
				file.writeInt(ids[i]);
				
				bufDni = new StringBuffer(dnis[i]);
				bufDni.setLength(9);
				file.writeChars(bufDni.toString());
				
				bufNombre = new StringBuffer(noms[i]);
				bufNombre.setLength(10);
				file.writeChars(bufNombre.toString());
				
				bufIden = new StringBuffer(identidades[i]);
				bufIden.setLength(20);
				file.writeChars(bufIden.toString());
				
				bufTipo = new StringBuffer(tipos[i]);
				bufTipo.setLength(10);
				file.writeChars(bufTipo.toString());
				
				file.writeInt(pesos[i]);
				file.writeInt(alturas[i]);
			}
			System.out.println("La carga de los personajes ha terminado correctamente");
			file.close();
		}catch(IOException ioe) {
			System.out.println("Error al cargar los personajes");
			ioe.printStackTrace();
		}
	}

}
