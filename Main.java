/**
 * Clase principal para probar la implementación de la tabla hash con Pokémon
 */
public class Main {
    public static void main(String[] args) {
        // Crear tabla hash con función de dispersión por división
        HashInterfaz<String, String> tablaDivision = new HashImpl<>(new FuncionDivision());

        // Crear tabla hash con función de dispersión por corrimiento
        HashInterfaz<String, String> tablaCorrimiento = new HashImpl<>(new FuncionCorrimiento());

        // Pruebas con función de división
        System.out.println("=== Pruebas con función de división (Pokémon) ===");
        probarTablaHash(tablaDivision);

        // Pruebas con función de corrimiento
        System.out.println("\n=== Pruebas con función de corrimiento (Pokémon) ===");
        probarTablaHash(tablaCorrimiento);
    }

    private static void probarTablaHash(HashInterfaz<String, String> tabla) {
        // Agregar Pokémon con su descripción
        tabla.agregar("Pikachu", "Ratón eléctrico");
        tabla.agregar("Charmander", "Lagartija de fuego");
        tabla.agregar("Squirtle", "Tortuga acuática");
        tabla.agregar("Bulbasaur", "Semilla con planta"); // Puede haber colisión

        // Mostrar tamaño
        System.out.println("Tamaño: " + tabla.tamanio());

        // Obtener valores
        System.out.println("Descripción de Pikachu: " + tabla.obtener("Pikachu"));
        System.out.println("Descripción de Bulbasaur: " + tabla.obtener("Bulbasaur"));

        // Verificar existencia
        System.out.println("¿Existe Squirtle? " + (tabla.obtener("Squirtle") != null));
        System.out.println("¿Existe Eevee? " + (tabla.obtener("Eevee") != null));

        // Sustituir valor
        System.out.println("\nActualizando descripción de Charmander...");
        tabla.sustituir("Charmander", "Pokémon tipo fuego");
        System.out.println("Nueva descripción: " + tabla.obtener("Charmander"));

        // Recorrer todos los elementos
        System.out.println("\nPokémon en la tabla:");
        Iterador<ParClaveValor<String, String>> it = tabla.iterador();
        while (it.hasNext()) {
            ParClaveValor<String, String> par = it.next();
            System.out.println("Nombre: " + par.clave + ", Descripción: " + par.valor);
        }

        // Recorrer solo valores
        System.out.println("\nDescripciones en la tabla:");
        Iterador<String> itValores = tabla.iteradorValores();
        while (itValores.hasNext()) {
            System.out.println(itValores.next());
        }

        // Eliminar elemento
        System.out.println("\nEliminando a Squirtle...");
        tabla.eliminar("Squirtle");
        System.out.println("Nuevo tamaño: " + tabla.tamanio());

        // Código hash de la tabla
        System.out.println("Código hash de la tabla: " + tabla.codigoHash());

        // Vaciar tabla
        System.out.println("\nVaciando tabla...");
        tabla.vaciar();
        System.out.println("¿Está vacía? " + tabla.estaVacio());
    }
}
