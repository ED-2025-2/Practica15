/**
 * Interfaz que define las operaciones básicas de una tabla hash
 * @param <K> Tipo de las claves
 * @param <V> Tipo de los valores
 */
public interface HashInterfaz<K, V> {
    /**
     * Agrega un par clave-valor a la tabla hash
     * @param clave La clave a agregar
     * @param valor El valor asociado a la clave
     */
    void agregar(K clave, V valor);
    
    /**
     * Obtiene el valor asociado a una clave
     * @param clave La clave a buscar
     * @return El valor asociado o null si no existe
     */
    V obtener(K clave);
    
    /**
     * Elimina un elemento de la tabla hash por su clave
     * @param clave La clave del elemento a eliminar
     * @return true si se eliminó, false si no existía
     */
    boolean eliminar(K clave);
    
    /**
     * @return El número de elementos en la tabla hash
     */
    int tamanio();
    
    /**
     * @return true si la tabla hash está vacía, false si no
     */
    boolean estaVacio();
    
    /**
     * Vacía la tabla hash
     */
    void vaciar();
    
    /**
     * Sustituye el valor asociado a una clave
     * @param clave La clave a sustituir
     * @param valor El nuevo valor
     * @return true si se sustituyó, false si no existía la clave
     */
    boolean sustituir(K clave, V valor);

    /**
     * Verifica si existe un valor en la tabla hash
     * @param valor El valor a buscar
     * @return true si existe, false si no
     */
    boolean existeValor(V valor);
    
    /**
     * @return El código hash de la tabla hash
     */
    int codigoHash();
    
    /**
     * @return Un iterador sobre los pares clave-valor de la tabla
     */
    Iterador<ParClaveValor<K, V>> iterador();
    
    /**
     * @return Un iterador sobre los valores de la tabla
     */
    Iterador<V> iteradorValores();
}

/**
 * Clase auxiliar para representar pares clave-valor
 * @param <K> Tipo de la clave
 * @param <V> Tipo del valor
 */
class ParClaveValor<K, V> {
    public final K clave;
    public V valor;
    
    public ParClaveValor(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }
}