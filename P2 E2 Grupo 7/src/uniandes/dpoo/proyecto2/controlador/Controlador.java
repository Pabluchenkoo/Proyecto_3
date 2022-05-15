package uniandes.dpoo.proyecto2.controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import uniandes.dpoo.proyecto2.modelo.Participante;
import uniandes.dpoo.proyecto2.modelo.Proyecto;
import uniandes.dpoo.proyecto2.modelo.Registro;

public class Controlador {

	private Registro registro;

	private Proyecto proyecto;

	public void setRegistro(Registro registro) {
		this.registro = new Registro();
	}
	
	public Boolean verificarProy() throws IOException
	{
		setRegistro(registro);
		return(registro.verificarProyecto());
	}

	public void cargarAplicacion() throws IOException 
	{
		System.out.println("***BIENVENIDO APP REGISTRO*** \n");
		setRegistro(registro);
		System.out.println("-Registro creado (nota desarrollo)\n");

		if (registro.verificarProyecto()==true)
		{
			System.out.println("-Cargando proyecto existente... \n");
			cargarProyecto(proyecto);
			if (registro.verificarParticipantes()==true)
			{
				System.out.println("-Cargando participantes existentes... \n");
				BufferedReader br = new BufferedReader(new FileReader("./data/participantes.txt"));
				String linea = br.readLine();
				int contador = 0;
				while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
				{
					System.out.println(contador+" - "+linea);
					String[] partes = linea.split(";");
					String nombreParticipante = partes[0];
					String correoParticipante = partes[1];
					proyecto.cargarParticipante(nombreParticipante, correoParticipante);
					linea = br.readLine();
					contador ++;
				}
				br.close();
				System.out.println("\n-Participantes cargados exitosamente \n");
			}
			else
			{
				System.out.println("***ADVERTENCIA - No se han encontrado participantes en el proyecto existente\n");
			}
		}
		else 
		{
			System.out.println("-Creando proyecto nuevo... \n");
			setProyecto(proyecto);
			if (registro.verificarParticipantes()==false)
			{
				System.out.println("-Creando participante nuevo... \n");
				addParticipante();
			}
		}

		if (registro.verificarActividades()==true)
		{
			System.out.println("-Cargando actividades existentes...\n");
			BufferedReader br = new BufferedReader(new FileReader("./data/actividades.txt"));
			String linea = br.readLine();
			int contador = 0;
			while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
			{
				System.out.println(contador+" - "+linea);
				String[] partes = linea.split(";");
				String titulo = partes[0];
				String descripccion = partes[1];
				int tipoID = Integer.parseInt(partes[2]);
				String fecha = partes[3]; 
				String horaInicio = (partes[4]);
				String horaFin = (partes[5]); 
				int duracion = Integer.parseInt(partes[6]); 
				int participanteID = Integer.parseInt(partes[7]);
				proyecto.cargarActividad(titulo, descripccion, tipoID, fecha, horaInicio, horaFin, duracion, participanteID);
				linea = br.readLine();
				contador ++;
			}
			br.close();
			System.out.println("\n-"+contador +" - Actividades cargadas exitosamente \n");
		}
		else
		{
			System.out.println("\n-Aun no existen actividades \n");
		}
	}
	
	public void cargarProyecto(Proyecto proyecto) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("./data/proyecto.txt"));
		String linea = br.readLine();
		System.out.println(linea);
		String nombreProyecto = linea;
		linea = br.readLine();
		System.out.println(linea);
		String descripccionProyecto = linea;
		linea = br.readLine();
		System.out.println(linea);
		String fechaInicioProyecto = linea;
		linea = br.readLine();
		System.out.println(linea);
		String fechaFinalizacionProyecto = linea;
		System.out.println("\nTipos de actividades existentes: \n");

		ArrayList<String> actividadesTipo = new ArrayList<>();
		int pos = 0;

		linea = br.readLine();
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			System.out.println(pos+" - "+linea);
			actividadesTipo.add(pos, linea);
			linea = br.readLine();
			pos ++;
		}
		this.proyecto = new Proyecto(nombreProyecto, descripccionProyecto, fechaInicioProyecto, fechaFinalizacionProyecto, actividadesTipo);
		br.close();
		System.out.println("\n-Proyecto cargado exitosamente! \n");
	}

	public void setProyecto(Proyecto proyecto) throws IOException
	{
		String nombreProyecto = input("Ingrese nombre de Proyecto: ");
		String descripccionProyecto = input("Ingrese descripccion del Proyecto: ");
		String fechaInicioProyecto = input("Ingrese fecha de inicio (DD/MM/AAAA): ");
		String fechaFinalizacionProyecto = input("Ingrese fecha de finalizacion (DD/MM/AAAA): ");		
		int numeroActividadesTipo = Integer.parseInt(input("Ingrese cuantos tipos de actividad van a existir: "));
		ArrayList<String> actividadesTipo = new ArrayList<>(numeroActividadesTipo);
		for (int pos = 0; pos < numeroActividadesTipo; pos++)
		{
			String actividadTipo = input("Ingrese nombre de Actividad "+pos+": ");
			actividadesTipo.add(pos, actividadTipo);
		}
		this.proyecto = new Proyecto(nombreProyecto, descripccionProyecto, fechaInicioProyecto, fechaFinalizacionProyecto, actividadesTipo);
		registro.escribirProyecto(nombreProyecto, descripccionProyecto, fechaInicioProyecto, fechaFinalizacionProyecto, actividadesTipo);

	}
	
	public void setProyectoInterfaz(String nombreProyecto, String descripccionProyecto, String fechaInicioProyecto, String fechaFinalizacionProyecto,
			ArrayList<String> actividadesTipo) throws IOException
	{
		this.proyecto = new Proyecto(nombreProyecto, descripccionProyecto, fechaInicioProyecto, fechaFinalizacionProyecto, actividadesTipo);
		registro.escribirProyecto(nombreProyecto, descripccionProyecto, fechaInicioProyecto, fechaFinalizacionProyecto, actividadesTipo);

	}
	
	public void addParticipante() throws IOException
	{
		String nombreParticipante = input("Ingrese nombre del Participante: ");
		String correoParticipante = input("Ingrese correo del Participante: ");
		registro.escribirParticipante(nombreParticipante, correoParticipante);
		proyecto.cargarParticipante(nombreParticipante, correoParticipante);
	}
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	public void cargarReporte(){
		ArrayList<Participante> listaParticipantes = proyecto.getParticipantes();
		int posParticipante = 0;
		for (Participante elParticipante:listaParticipantes)
		{
			System.out.println(posParticipante+"- " + elParticipante.getNombre());
			posParticipante++;
		}
		int id = Integer.parseInt(input("Ingrese el ID del participante para el reporte"));
		proyecto.ejecutarReporte(id);
	}

}
