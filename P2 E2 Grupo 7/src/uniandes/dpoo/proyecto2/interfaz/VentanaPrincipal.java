package uniandes.dpoo.proyecto2.interfaz;

import java.awt.BorderLayout;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.proyecto2.controlador.Controlador;


@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame
{

	
	private VentanaNuevoProyecto ventanaProyecto;

	Controlador controlador = new Controlador();

	private panelParticipantes panelParticipantes;


	public VentanaPrincipal(Boolean existe )
	{
		if (existe ==false)
		{
			ventanaProyecto = new VentanaNuevoProyecto(this);
		}
		else
		{
		
		setTitle("Registro Proyecto :)");
		setLayout(new BorderLayout());

		JLabel arriba = new JLabel (" Agregar y consultar participantes");

		panelParticipantes = new panelParticipantes(this);
		JButton centro = new JButton ("Agregar Actividad");
		JButton derecha = new JButton ("Generar Reporte");

		JLabel abajo = new JLabel ("Aqui va a ir la linea del tiempo");

		add(panelParticipantes, BorderLayout.WEST);
		add(centro, BorderLayout.CENTER);
		add(derecha, BorderLayout.EAST);
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
		Controlador controlador = new Controlador();

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
			int nActividades)
	{
		// TODO Auto-generated method stub
		
	}
	


}