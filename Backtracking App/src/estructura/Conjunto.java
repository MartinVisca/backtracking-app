package estructura;

import impresor.Impresor;

public class Conjunto extends Estructura {
     /**
     *  Estructura predefinida que modela o representa conjuntos de objetos.
     **/
    
    private Object[] estructura;
    private Object valorPorDefecto;
    private int tamano;

    public Conjunto(){}

    public Conjunto(Object valorPorDefecto, int tamano, Impresor impresor){
        this.tamano = tamano;
        this.valorPorDefecto = valorPorDefecto;
        this.estructura = new Object[tamano];
        this.inicializar();
        this.impresor = impresor;
    }

    public Object getValorPorDefecto() {
        return valorPorDefecto;
    }

    public void setValorPorDefecto(Object valorPorDefecto) {
        this.valorPorDefecto = valorPorDefecto;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    @Override
    public Object[] getEstructura() {
        return estructura.clone();
    }

    @Override
    public void agregarElemento(Object elemento, int... posicion) {
        if (!this.hayElemento(posicion[0]))
            this.estructura[posicion[0]] = elemento;
        else
            System.out.println("Ya existe un elemento en la posición indicada.");
    }

    @Override
    public void borrarElemento(int... posicion) {
        if (hayElemento(posicion[0]))
            this.estructura[posicion[0]] = this.valorPorDefecto;
    }

    @Override
    protected void inicializar() {
        for (int i = 0; i < this.tamano; i++)
            this.estructura[i] = this.valorPorDefecto;
    }

    @Override
    public boolean hayElemento(int... posicion) {
        return this.getElemento(posicion[0]) != this.valorPorDefecto;
    }

    @Override
    public Object getElemento(int... posicion) {
        return this.estructura[posicion[0]];
    }
}
