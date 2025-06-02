/**
 * Interfaz para funciones de dispersión
 */
public interface FuncionDispersion {
    /**
     * Calcula la posición en la tabla hash para una clave
     * @param clave La clave a dispersar
     * @param capacidad Capacidad actual de la tabla
     * @return La posición calculada
     */
    int dispersar(Object clave, int capacidad);
}