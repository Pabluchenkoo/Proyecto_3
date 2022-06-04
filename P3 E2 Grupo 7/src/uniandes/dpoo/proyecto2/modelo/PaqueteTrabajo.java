package uniandes.dpoo.proyecto2.modelo;

import java.util.ArrayList;
import java.util.LinkedList;

public class PaqueteTrabajo {

    private String nombre;
    private String descripcion;
    private LinkedList <Tarea> paqueteConTareas;

    public PaqueteTrabajo(String nombre, String descripcion, LinkedList <Tarea> paqueteConTareas)
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.paqueteConTareas = paqueteConTareas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LinkedList <Tarea> getPaqueteConTareas() {
        return paqueteConTareas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPaqueteConTareas(Tarea pPaqueteConTareas) {
        paqueteConTareas.addLast(pPaqueteConTareas);
    }
    
}
