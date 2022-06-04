package uniandes.dpoo.proyecto2.modelo;

import java.util.ArrayList;
import java.util.LinkedList;

public class Proyecto {
	
	private String nombre;
	private String descripccion;
	private String fechaInicio;
	private String fechaFin;
	private ArrayList <String> tipoActividades;
	private ArrayList<Participante> participantes;
	private ArrayList<Actividad> actividades;
	Reporte elReporte = new Reporte();
	private WBS elWBS;
	
	
	public Proyecto(String nombre, String descripccion, String fechaInicio, String fechaFin, ArrayList <String> listaTiposActividades)
	{
		this.nombre = nombre;
		this.descripccion = descripccion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tipoActividades = listaTiposActividades;
		this.participantes = new ArrayList<>();
		this.actividades = new ArrayList<>();
		
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public String getDescripccion() 
	{
		return descripccion;
	}
	
	public String getFechaInicio() 
	{
		return fechaInicio;
	}
	
	public String getFechaFin() 
	{
		return fechaFin;
	}

	public ArrayList <String> getTipoActividades() 
	{
		return tipoActividades;
	}
	
	public ArrayList<Participante> getParticipantes()
	{
		return participantes;
	}
	
	public ArrayList<Actividad> getActividades()
	{
		return actividades;
	}

	public WBS getElWBS() {
		return elWBS;
	}

	
	
	public void cargarParticipante(String participante, String correo)
	{
		Participante elParticipante = new Participante (participante, correo);
		participantes.add(elParticipante);
	}
	
	public void cargarActividad(String titulo, String descripccion, int tipoID, String fecha, String horaInicio,
			String horaFin, int duracion , int participanteID)
	{
		//aqui hacen falta los "defaults" en caso que el input sea vacio.
		
		Actividad laActividad = new Actividad (titulo, descripccion, tipoID, fecha,
				horaInicio, horaFin, duracion, participanteID);
		actividades.add(laActividad);
	}
	
	
	
	public ArrayList<String> ejecutarReporte(int id)
	{
		
		return elReporte.ejecutarReporte(id, actividades, tipoActividades, participantes);
	}

	public void crearWBS(String pNombre, String pDescrip)
	{
		LinkedList <Tarea> pTareas = new LinkedList<>();
		PaqueteTrabajo nuevoPaquete = new PaqueteTrabajo(nombre, pDescrip, pTareas);
		elWBS = new WBS(nuevoPaquete);
	}



}
