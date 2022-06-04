package uniandes.dpoo.proyecto2.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reporte {

	public Reporte()
	{		
	}


	public ArrayList<String> ejecutarReporte(int id, ArrayList<Actividad> actividades, ArrayList <String> tipoActividades, ArrayList<Participante> participantes)
	{	
		Map<Integer,Integer> mapaTipoAct = new HashMap<>();
		ArrayList<String> fechas = new ArrayList<>();
		int total=0;
		for (int i=0;i<tipoActividades.size();i++)
		{
			mapaTipoAct.put(i, 0);
		}
		for  ( Actividad laActividad: actividades)
		{
			if (id == laActividad.getParticipanteID())
			{ 
				int duracion = laActividad.getDuracion();
				total = total + duracion;
				int duracionAcumulado = mapaTipoAct.get(laActividad.getTipoID());
				mapaTipoAct.replace(laActividad.getTipoID(), duracionAcumulado+duracion);
				if ((fechas.contains(laActividad.getFecha()))==false)
				{
					fechas.add(laActividad.getFecha());
				}
			}

		}
		int numeroFechas=fechas.size();
		double tiempoPorDia = total/numeroFechas;
		String printNombre = (participantes.get(id).getNombre());
		String printReporte = "Reporte para el participante "+ printNombre 
				+ "\n Tiempo total invertido: " + total
				+"\n Tiempo promedio por dia: " + tiempoPorDia;
		System.out.println(printReporte);
		System.out.println("\n Tiempo por actividad:");
		ArrayList<String> printFinal = new ArrayList<>();
		printFinal.add(printReporte);
		for (Integer idTipo: mapaTipoAct.keySet())
		{
			String infoAct = "Tipo De actividad: "+tipoActividades.get(idTipo) + ", Tiempo:" + mapaTipoAct.get(idTipo);
			System.out.println("Tipo De actividad: "+tipoActividades.get(idTipo) + ", Tiempo:" + mapaTipoAct.get(idTipo));
			printFinal.add(infoAct);
		}
		return (printFinal);
	}

}

