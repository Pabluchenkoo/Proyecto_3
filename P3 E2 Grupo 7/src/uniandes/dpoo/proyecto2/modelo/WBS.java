package uniandes.dpoo.proyecto2.modelo;

import java.util.HashMap;

public class WBS {

    private PaqueteTrabajo paqueteTrabajo;
    
    public WBS(PaqueteTrabajo paqueteTrabajo)
    {
        this.paqueteTrabajo = paqueteTrabajo;
    }

    public PaqueteTrabajo getPaqueteTrabajo() {
        return paqueteTrabajo;
    }

    public void setPaqueteTrabajo(PaqueteTrabajo paqueteTrabajo) {
        this.paqueteTrabajo = paqueteTrabajo;
    }
    
}
