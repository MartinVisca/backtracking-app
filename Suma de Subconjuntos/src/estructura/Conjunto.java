package estructura;

import java.util.Vector;

/**
 * Estructura predefinida que modela o representa conjuntos de objetos.
 */
@SuppressWarnings("all")
public class Conjunto extends Estructura<Vector<Object>> {

    private Vector<Object> estructura;
    private Object valorPorDefecto;

    public Conjunto(){}

    public Conjunto(Object valorPorDefecto) {
        this.valorPorDefecto = valorPorDefecto;
        this.estructura = new Vector<>();
        this.inicializar();
    }

    public Object getValorPorDefecto() {
        return valorPorDefecto;
    }

    public void setValorPorDefecto(Object valorPorDefecto) {
        this.valorPorDefecto = valorPorDefecto;
    }

    public void agregarElemento(Object elemento) {
        if (!this.estructura.contains(elemento))
            this.estructura.add(elemento);
        else
            System.out.println("Ya existe un elemento en la posición indicada.");
    }

    public void borrarElemento(Object elemento) {
        if (this.estructura.contains(elemento))
            this.estructura.remove(elemento);
    }

    public Object getElemento(int posicion) {
        return this.estructura.get(posicion);
    }

    public int getSumaElementos() {
        int suma = 0;

        for (int i = 0; i < this.estructura.size(); i++)
            suma += Integer.valueOf(this.getElemento(i).toString());

        return suma;
    }

    public int size() {
        return this.estructura.size();
    }

    public boolean tieneElemento(Object elemento) {
        return this.estructura.contains(elemento);
    }

    @Override
    public Conjunto getEstructuraPorCopia() {
        Conjunto nuevoConjunto = new Conjunto(this.getValorPorDefecto());

        for (int i = 0; i < this.estructura.size(); i++) {
            nuevoConjunto.agregarElemento(this.getElemento(i));
        }

        return nuevoConjunto;
    }

    @Override
    protected void inicializar() {}

    @Override
    public void setEstructura(Vector<Object> nuevaEstructura) {
        this.estructura = nuevaEstructura;
    }

}
