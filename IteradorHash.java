import java.util.Iterator;
import java.util.LinkedList;

/**
 * Implementación del iterador para la tabla hash
 * @param <K> Tipo de las claves
 * @param <V> Tipo de los valores
 */
public class IteradorHash<K, V> implements Iterador<ParClaveValor<K, V>> {
    private final LinkedList<ParClaveValor<K, V>>[] tabla;
    private int indiceActual;
    private Iterator<ParClaveValor<K, V>> iteradorActual;
    
    public IteradorHash(LinkedList<ParClaveValor<K, V>>[] tabla) {
        this.tabla = tabla;
        this.indiceActual = 0;
        avanzarHastaSiguienteNoVacio();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() {
        //AQUI VA SU CODIGO
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public ParClaveValor<K, V> next() {
        if (!hasNext()) {
            throw new IllegalStateException("No hay más elementos");
        }
        
        //AQUI VA SU CODIGO
        //HINT: UTILIZA EL METODO AUXILIAR avanzarHastaSiguienteNoVacio()
    }
    
    private void avanzarHastaSiguienteNoVacio() {
        while (indiceActual < tabla.length && 
              (tabla[indiceActual] == null || tabla[indiceActual].isEmpty())) {
            indiceActual++;
        }
        
        if (indiceActual < tabla.length) {
            iteradorActual = tabla[indiceActual].iterator();
        } else {
            iteradorActual = null;
        }
    }
}