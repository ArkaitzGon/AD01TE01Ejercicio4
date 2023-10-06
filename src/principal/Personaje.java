package principal;

/***
 * Clase creada para manejar mejor los datos del ejercicio 4C
 */
public class Personaje {
	private int peso, altura;
	private String dni, nombre, identidad, tipo;
	
	// Constructor
	public Personaje(String dni, String nombre, String identidad, String tipo, int peso, int altura) {
		this.dni = dni;
		this.nombre = nombre;
		this.identidad = identidad;
		this.tipo = tipo;
		this.peso = peso;
		this.altura = altura;
	}
	
	@Override
	public String toString() {
		return "Personaje [dni=" + this.dni + ", nombre=" + this.nombre + ", identidad=" + identidad + 
				", tipo=" + tipo + ", peso=" + peso + ", altura=" + altura +"]";
	}
}
