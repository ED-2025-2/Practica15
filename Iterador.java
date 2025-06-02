/**
 * Interfaz para un iterador simple
 * @param <T> Tipo de los elementos a iterar
 */
public interface Iterador<T> {
    /**
     * @return true si hay más elementos por iterar, false si no
     */
    boolean hasNext();
    
    /**
     * @return El siguiente elemento en la iteración
     * @throws IllegalStateException si no hay más elementos
     */
    T next();
}