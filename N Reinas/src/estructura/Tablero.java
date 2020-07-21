package estructura;

/**
 * Estructura predefinida que pretende modelar el tablero de un juego dividido en casillas, simil ajedrez.
 */
@SuppressWarnings("all")
public class Tablero extends Estructura<Object[][]> {

    private Object[][] estructura;
    private Object valorPorDefecto;
    private int filas;
    private int columnas;

    private final static int PRIMER_ELEMENTO = 0;
    private final static int SEGUNDO_ELEMENTO = 1;

    public Tablero(){}

    public Tablero(Object valorPorDefecto, int filas, int columnas) {
        this.estructura = new Object[filas][columnas];
        this.filas = filas;
        this.columnas = columnas;
        this.valorPorDefecto = valorPorDefecto;
        this.inicializar();
    }

    @Override
    public void setEstructura(Object[][] nuevaEstructura) {
        this.estructura = nuevaEstructura;
    }

    @Override
    public Tablero getEstructuraPorCopia() {
        Tablero tablero = new Tablero(this.getValorPorDefecto(), this.getFilas(), this.getColumnas());

        for (int i = 0; i < this.filas; i++)
            for (int j = 0; j < this.columnas; j++)
                tablero.agregarElemento(this.getElemento(i, j), i, j);

        return tablero;
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

    public boolean hayElementoEnRecta(int fila, int columna) {
        for (int i = 0; i < this.filas; i++){
            for (int j = 0; j < this.columnas; j++){
                if (this.hayElemento(i, j))
                    if ((fila == i || columna == j) && (fila != i || columna != j))
                        return true;
            }
        }

        return false;
    }

    public boolean hayElementoEnDiagonal(int fila, int columna) {
        for (int i = 0; i < this.filas; i++){
            for (int j = 0; j < this.columnas; j++){
                if (this.hayElemento(i, j))
                    if (fila != i && columna != j && Math.abs(fila - i) == Math.abs(columna - j))
                        return true;
            }
        }

        return false;
    }

    @Override
    protected void inicializar() {
        for (int i = 0; i < this.filas; i++)
            for (int j = 0; j < this.columnas; j++)
                this.estructura[i][j] = this.valorPorDefecto;
    }

    @Override
    public int getCantidadElementos() {
        int cantidad = 0;

        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++)
                if (this.hayElemento(i, j))
                    cantidad += 1;
        }

        return cantidad;
    }

    @Override
    public boolean hayElemento(int... posicion) {
        return this.estructura[posicion[PRIMER_ELEMENTO]][posicion[SEGUNDO_ELEMENTO]] != this.valorPorDefecto;
    }

    @Override
    public void agregarElemento(Object elemento, int... posicion) {
        if (!this.hayElemento(posicion[PRIMER_ELEMENTO], posicion[SEGUNDO_ELEMENTO]))
            this.estructura[posicion[PRIMER_ELEMENTO]][posicion[SEGUNDO_ELEMENTO]] = elemento;
    }

    @Override
    public void borrarElemento(int... posicion) {
        if (this.hayElemento(posicion[PRIMER_ELEMENTO], posicion[SEGUNDO_ELEMENTO])) {
            this.estructura[posicion[PRIMER_ELEMENTO]][posicion[SEGUNDO_ELEMENTO]] = this.valorPorDefecto;
        }
    }

    @Override
    public Object getElemento(int... posicion) {
        return this.estructura[posicion[PRIMER_ELEMENTO]][posicion[SEGUNDO_ELEMENTO]];
    }

}
