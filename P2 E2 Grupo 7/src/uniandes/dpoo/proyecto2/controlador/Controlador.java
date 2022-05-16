package uniandes.dpoo.proyecto2.controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

import uniandes.dpoo.proyecto2.consola.Aplicacion;
import uniandes.dpoo.proyecto2.modelo.Proyecto;
import uniandes.dpoo.proyecto2.modelo.Registro;

public class Controlador {

	private static  Aplicacion aplicacion = new Aplicacion();

	public void setRegistro(Registro registro) {
		aplicacion.setRegistro(registro);
	}
	
	public Boolean verificarProy() throws IOException
	{
		
		return aplicacion.getRegistro().verificarProyecto();
	}

	public void ejecutarAplicacion() throws IOException 
	{
		aplicacion.ejecutarAplicacion();
	}

	public void ejecutarCronometro() throws IOException 
	{
		aplicacion.ejecutarCronometro();
	}

	public void setProyecto(String pNombreProyecto, String pDescripcionProyecto, String pFechaInicioProyecto,
	String pFechaFinalizacionProyecto, int pNumeroActividades) throws IOException
	{
		aplicacion.setProyectoInterfaz(pNombreProyecto,pDescripcionProyecto,pFechaInicioProyecto,
		pFechaFinalizacionProyecto,pNumeroActividades);

	}
	
	public void addParticipante(String pParticipante) throws IOException
	{
		aplicacion.addParticipante(pParticipante);
	}
	
	public void addActividad(String titulo, String descrip, 
	String tipoID, String fecha, String horaInicio, String horaFin, 
	String duracion, String participanteID) throws IOException
	{
		aplicacion.addActividad(titulo, descrip, 
		tipoID, fecha, horaInicio, horaFin, duracion, participanteID);
	}

	public void addActividadInterfaz(String pTitulo,String pDescripcion, int pTipoActividad, String pFecha, String pHoraInicio
	,String pHoraFin)throws IOException 
	{
		aplicacion.addActividadInterfaz(pTitulo,pDescripcion,pTipoActividad,pFecha,pHoraInicio,pHoraFin);
	}

	public LinkedList<String> cargarParticipantes() {
		return aplicacion.cargarParticipantes();
	}

}