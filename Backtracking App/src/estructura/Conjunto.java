package estructura;

public class Conjunto extends Estructura {
    /**
     *  Estructura predefinida que modela o representa conjuntos de objetos.
     **/

    private final static int PRIMER_ELEMENTO = 0;

    private Object[] estructura;
    private Object valorPorDefecto;
    private int tamano;

    public Conjunto(){}

    public Conjunto(Object valorPorDefecto, int tamano) {
        this.tamano = tamano;
        this.valorPorDefecto = valorPorDefecto;
        this.estructura = new Object[tamano];
        this.inicializar();
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
    public void imprimirEstructura() {
        for (int i = 0; i < this.tamano; i++) {
            System.out.print(this.getElemento(i) + " ");
        }
        System.out.println();
    }

    @Override
    public Estructura getEstructura() {
        Estructura retorno = this;
        retorno.setEstructura(this.estructura.clone());
        return retorno;
    }

    @Override
    public void setEstructura(Object nuevaEstructura) {
        this.estructura = (Object[]) nuevaEstructura;
    }

    @Override
    public void agregarElemento(Object elemento, int... posicion) {
        if (!this.hayElemento(posicion[this.PRIMER_ELEMENTO]))
            this.estructura[posicion[this.PRIMER_ELEMENTO]] = elemento;
        else
            System.out.println("Ya existe un elemento en la posición indicada.");
    }

    @Override
    public void borrarElemento(int... posicion) {
        if (hayElemento(posicion[this.PRIMER_ELEMENTO]))
            this.estructura[posicion[this.PRIMER_ELEMENTO]] = this.valorPorDefecto;
    }

    @Override
    protected void inicializar() {
        for (int i = 0; i < this.tamano; i++)
            this.estructura[i] = this.valorPorDefecto;
    }

    @Override
    public boolean hayElemento(int... posicion) {
        return this.getElemento(posicion[this.PRIMER_ELEMENTO]) != this.valorPorDefecto;
    }

    @Override
    public Object getElemento(int... posicion) {
        return this.estructura[posicion[this.PRIMER_ELEMENTO]];
    }

    @Override
    public int getCantidadElementos() {
        int cantidad = 0;

        for (int i = 0; i < this.tamano; i++){
            if (this.getElemento(i) != this.valorPorDefecto)
                cantidad++;
        }

        return cantidad;
    }

}
