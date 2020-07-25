package main;

import accion.Accion;
import accion.AgregarEntero;
import backtracking.Backtracking;
import estado.EstadoSumaSubconjuntos;
import estructura.Conjunto;
import poda.PodaSumaSubconjuntos;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        int target = 5;
        HashSet<Integer> elementos = new HashSet<>();
        elementos.add(1);
        elementos.add(2);
        elementos.add(3);
        elementos.add(5);
        elementos.add(4);

        Conjunto conjunto = new Conjunto(0);

        List<Accion> acciones = new ArrayList<>();
        for (Integer elemento : elementos)
            acciones.add(new AgregarEntero(elemento));

        EstadoSumaSubconjuntos inicial = new EstadoSumaSubconjuntos(conjunto, acciones, target, elementos);
        PodaSumaSubconjuntos poda = new PodaSumaSubconjuntos();

        Backtracking backtracking = new Backtracking(inicial, poda);
        backtracking.iniciar();
    }

}
