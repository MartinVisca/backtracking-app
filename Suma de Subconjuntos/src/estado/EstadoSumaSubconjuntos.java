package estado;

import accion.Accion;
import estructura.Conjunto;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Clase que extiende el comportamiento de Estado para la suma de subconjuntos.
 */
@SuppressWarnings("all")
public class EstadoSumaSubconjuntos extends Estado<Conjunto> {

    private int target;
    Set<Integer> elementos;

    public EstadoSumaSubconjuntos() {

    }

    public EstadoSumaSubconjuntos(Conjunto conjunto, List<Accion> acciones, int target, Set<Integer> elementos) {
        this.acciones = acciones;
        this.estructura = conjunto;
        this.estadosHermanos = new HashMap<>();
        this.estadoPadre = null;
        this.target = target;
        this.elementos = elementos;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public Set<Integer> getElementos() {
        return elementos;
    }

    public void setElementos(Set<Integer> elementos) {
        this.elementos = elementos;
    }

    @Override
    public String toString() {
        StringBuilder solucion = new StringBuilder();

        solucion.append("<html><body>");

        solucion.append("Elementos: " + this.getElementos() + System.getProperty("line.separator") + "<br>");

        solucion.append("Subconjunto: {");
        for (int i = 0; i < this.getEstructura().size(); i++) {
            if (i == this.getEstructura().size() - 1)
                solucion.append(this.getEstructura().getElemento(i));
            else
                solucion.append(this.getEstructura().getElemento(i) + ", ");
        }
        solucion.append("}" + System.getProperty("line.separator") + "<br>");

        solucion.append(System.getProperty("line.separator") + "<br>");

        solucion.append("Target= " + this.getTarget() + System.getProperty("line.separator") + "<br>");
        solucion.append("Suma del subconjunto= " + this.getEstructura().getSumaElementos() + System.getProperty("line.separator") + "<br>");

        solucion.append("</body></html>");
        return solucion.toString();
    }

    @Override
    public Estado getEstadoPorCopia() {
        Conjunto conjunto = this.getEstructura().getEstructuraPorCopia();
        EstadoSumaSubconjuntos estadoSumaSubconjuntos = new EstadoSumaSubconjuntos(conjunto, this.getAcciones(), this.getTarget(), this.getElementos());
        return estadoSumaSubconjuntos;
    }

    @Override
    public boolean esSolucion() {
        return this.estructura.getSumaElementos() == target;
    }
}
