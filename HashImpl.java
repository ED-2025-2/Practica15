import java.util.LinkedList;

/**
 * Implementación de tabla hash con manejo de colisiones por encadenamiento
 * @param <K> Tipo de las claves
 * @param <V> Tipo de los valores
 */
public class HashImpl<K, V> implements HashInterfaz<K, V> {
    private static final int CAPACIDAD_INICIAL = 16;
    private static final double FACTOR_CARGA = 0.75;
    
    private LinkedList<ParClaveValor<K, V>>[] tabla;
    private int tamaño;
    private FuncionDispersion funcionDispersion;
    

    /**
     * Constructor que recibe la función de dispersión a utilizar.
     * @param funcionDispersion Función para calcular el índice de cada clave.
     */
    @SuppressWarnings("unchecked")
    public HashImpl(FuncionDispersion funcionDispersion) {
        this.tabla = new LinkedList[CAPACIDAD_INICIAL];
        this.tamaño = 0;
        this.funcionDispersion = funcionDispersion;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void agregar(K clave, V valor) {
        if (clave == null) {
            throw new IllegalArgumentException("La clave no puede ser null");
        }
        //AQUI VA SU CODIGO
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public V obtener(K clave) {
        if (clave == null) return null;
        
        //AQUI VA SU CODIGO
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean eliminar(K clave) {
        if (clave == null) return false;
        
        //AQUI VA SU CODIGO
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int tamanio() {
        return tamaño;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean estaVacio() {
        //AQUI VA SU CODIGO
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void vaciar() {
        //AQUI VA SU CODIGO
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean sustituir(K clave, V valor) {
        if (clave == null) return false;
        
        //AQUI VA SU CODIGO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existeValor(V valor) {
        Iterador<ParClaveValor<K, V>> it = iterador();
        while (it.hasNext()) {
            if (it.next().valor.equals(valor)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int codigoHash() {
        int hash = 0;
        for (LinkedList<ParClaveValor<K, V>> lista : tabla) {
            if (lista != null) {
                for (ParClaveValor<K, V> par : lista) {
                    hash += par.clave.hashCode() ^ par.valor.hashCode();
                }
            }
        }
        return hash;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Iterador<ParClaveValor<K, V>> iterador() {
        return new IteradorHash<>(tabla);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Iterador<V> iteradorValores() {
        return new IteradorValoresWrapper<>(iterador());
    }
    
    /**
     * Calcula el índice para una clave utilizando la función de dispersión.
     * @param clave La clave a dispersar
     * @return El índice correspondiente en la tabla
     */
    private int calcularIndice(K clave) {
        return funcionDispersion.dispersar(clave, tabla.length);
    }
    
    /**
     * Redimensiona la tabla hash cuando se supera el factor de carga.
     * Duplica la capacidad y reubica todos los elementos.
     */
    @SuppressWarnings("unchecked")
    private void redimensionar() {
        LinkedList<ParClaveValor<K, V>>[] tablaVieja = tabla;
        tabla = new LinkedList[tabla.length * 2];
        tamaño = 0;
        
        for (LinkedList<ParClaveValor<K, V>> lista : tablaVieja) {
            if (lista != null) {
                for (ParClaveValor<K, V> par : lista) {
                    agregar(par.clave, par.valor);
                }
            }
        }
    }
    
    /**
     * Clase interna que convierte un iterador de pares clave-valor
     * en un iterador de solo valores.
     * @param <K> Tipo de la clave
     * @param <V> Tipo del valor
     */
    private static class IteradorValoresWrapper<K, V> implements Iterador<V> {
        
        private final Iterador<ParClaveValor<K, V>> iterador;
        
        /**
         * Constructor del wrapper.
         * @param iterador Iterador sobre pares clave-valor
         */
        public IteradorValoresWrapper(Iterador<ParClaveValor<K, V>> iterador) {
            this.iterador = iterador;
        }
        
        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return iterador.hasNext();
        }
        
        /**
         * {@inheritDoc}
         */
        @Override
        public V next() {
            return iterador.next().valor;
        }
    }
}