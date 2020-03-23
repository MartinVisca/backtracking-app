package estructura;

import impresor.Impresor;

public class Tablero extends Estructura {
    /**Estructura predefinida que pretende modelar el tablero de un juego dividido en casillas, simil ajedrez. **/

    private Object[][] estructura;
    private Object valorPorDefecto;
    private int filas;
    private int columnas;

    public Tablero(){}

    public Tablero(Object valorPorDefecto, int filas, int columnas, Impresor impresor){
        this.estructura = new Object[filas][columnas];
        this.filas = filas;
        this.columnas = columnas;
        this.valorPorDefecto = valorPorDefecto;
        this.cantidadElementos = 0;
        this.inicializar();
        this.impresor = impresor;
    }

    @Override
    public Object[][] getEstructura() {
        return estructura.clone();
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public Object getValorPorDefecto() {
        return valorPorDefecto;
    }

    public void setValorPorDefecto(Object valorPorDefecto) {
        this.valorPorDefecto = valorPorDefecto;
    }

    @Override
    protected void inicializar() {
        for (int i = 0; i < this.filas; i++)
            for (int j = 0; j < this.columnas; j++)
                this.estructura[i][j] = this.valorPorDefecto;
    }

    @Override
    public boolean hayElemento(int... posicion) {
        return (this.estructura[posicion[0]][posicion[1]] != this.valorPorDefecto);
    }

    @Override
    public void agregarElemento(Object elemento, int... posicion) {
        if (!this.hayElemento(posicion[0], posicion[1])) {
            this.estructura[posicion[0]][posicion[1]] = elemento;
            this.cantidadElementos++;
        }
        else
            System.out.println("Ya hay un elemento en la posición indicada.");
    }

    @Override
    public void borrarElemento(int... posicion) {
        if (this.hayElemento(posicion[0], posicion[1])) {
            this.estructura[posicion[0]][posicion[1]] = this.valorPorDefecto;
            this.cantidadElementos--;
        }
    }

    @Override
    public Object getElemento(int... posicion) {
        return this.estructura[posicion[0]][posicion[1]];
    }
}
