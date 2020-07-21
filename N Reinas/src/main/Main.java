package main;

import accion.Accion;
import acciones.ColocarReina;
import backtracking.Backtracking;
import estado.EstadoNReinas;
import estructura.Tablero;
import poda.PodaNReinas;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Main {

    public static void main (String [] args){
        int filas = 4;
        int columnas = 4;

        Tablero tablero = new Tablero("-", filas, columnas);

        List<Accion> acciones = new ArrayList<>();
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                acciones.add(new ColocarReina(i, j));

        EstadoNReinas inicial = new EstadoNReinas(tablero, acciones);
        PodaNReinas poda = new PodaNReinas();

        Backtracking backtracking = new Backtracking(inicial, poda);
        backtracking.iniciar();
    }
}
