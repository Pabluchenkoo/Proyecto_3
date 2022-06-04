package uniandes.dpoo.proyecto2.interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import uniandes.dpoo.proyecto2.controlador.Controlador;


@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame implements ActionListener
{

	
	private VentanaNuevoProyecto ventanaProyecto;
	private VentanaElegirParticipante ventanaReporte;
	private static final String ENTER = "ENTER";
	private JButton btnReporte;


	private static Controlador controlador = new Controlador();

	private PanelParticipantes panelParticipantes;

	private PanelActividades panelActividades;

	public Controlador getControlador()
	{
		return controlador;
	}

	public VentanaPrincipal(Boolean existe )
	{
		if (existe ==false)
		{
			ventanaProyecto = new VentanaNuevoProyecto(this);
		}
		else
		{
		
		// controlador.cargarProyectoInterfaz();
			
		setTitle("Registro Proyecto :)");
		setLayout(new BorderLayout());

		JLabel arriba = new JLabel (" Agregar y consultar participantes");

		panelParticipantes = new PanelParticipantes(this);
		panelActividades = new PanelActividades(this);
		JButton centro = new JButton ("Agregar Actividad");

		btnReporte = new JButton("Generar reporte");
		btnReporte.setActionCommand(ENTER);
		btnReporte.addActionListener(this);
		
		JLabel abajo = new JLabel ("linea tiempo");

		add(panelParticipantes, BorderLayout.WEST);
		add(panelActividades, BorderLayout.CENTER);
		add(btnReporte, BorderLayout.EAST);
		add (arriba, BorderLayout.NORTH);
		add (abajo, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200,800);
		setVisible(true);
		}
	}


	public static void main(String[] args) throws IOException
	{

		/*Boolean, verificacion*/
		/*if False:
		 * 			 llama a VentanaNuevoProyecto, crear proyecto (crear proyecto llama a controlador setProyect
		 * 			llama a VentanaNuevoParticipante, crear participante (llama a controlador addParticipante*/
		/*if True:
		 * 			 llama a VentanaNuevoProyecto, crear proyecto (crear proyecto llama a controlador setProyect
		 * 			llama a VentanaNuevoParticipante, crear participante (llama a controlador addParticipante*/
		controlador = new Controlador();

		if (controlador.verificarProy()==false)
		{
			System.out.println((LocalDateTime.now()).toLocalDate());
			new VentanaPrincipal(false);
		}
		else
		{
			new VentanaPrincipal(true);
		}
	}


	public void crearProyecto(String nombre, String descripccion, String fechaInicio, String fechaFin,
			int Actividades, Controlador controlador) throws IOException
	{
		// TODO Auto-generated method stub
		controlador.setProyecto(nombre, descripccion, fechaInicio, fechaFin, Actividades);
	}
	
	public void generarReporte(int id, Controlador controlador)
	{
		
		ArrayList<String> reporte = controlador.cargarReporte(id);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		if (grito.equals(ENTER))
		{
			System.out.println("Ejecutando generar reporte");
			
			ventanaReporte = new VentanaElegirParticipante(this, controlador);
			
		}
		
	}


}