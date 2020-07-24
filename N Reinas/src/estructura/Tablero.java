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

    public Tablero() {}

    public Tablero(Object valorPorDefecto, int filas, int columnas) {
        this.estructura = new Object[filas][columnas];
        this.filas = filas;
        this.columnas = columnas;
        this.valorPorDefecto = valorPorDefecto;
        this.inicializar();
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

    public boolean hayElemento(int fila, int columna) {
        return this.estructura[fila][columna] != this.valorPorDefecto;
    }

    public void agregarElemento(Object elemento, int fila, int columna) {
        if (!this.hayElemento(fila, columna))
            this.estructura[fila][columna] = elemento;
    }

    public void borrarElemento(int fila, int columna) {
        if (this.hayElemento(fila, columna)) {
            this.estructura[fila][columna] = this.valorPorDefecto;
        }
    }

    public Object getElemento(int fila, int columna) {
        return this.estructura[fila][columna];
    }

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
    protected void inicializar() {
        for (int i = 0; i < this.filas; i++)
            for (int j = 0; j < this.columnas; j++)
                this.estructura[i][j] = this.valorPorDefecto;
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

}
