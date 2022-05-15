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
public class VentanaPrincipal extends JFrame implements ActionListener{
	
	private VentanaNuevoProyecto ventanaProyecto;
	private VentanaElegirParticipante ventanaReporte;
	private static final String ENTER = "ENTER";
	private JButton btnReporte;
	private static Controlador controlador;


	public VentanaPrincipal(Boolean existe, Controlador controlador) throws IOException
	{
		if (existe ==false)
		{
			ventanaProyecto = new VentanaNuevoProyecto(this, controlador);
			
		}
		else
		{
		
		controlador.cargarProyectoInterfaz();
			
		setTitle("Registro Proyecto :)");
		setLayout(new BorderLayout());

		JLabel arriba = new JLabel ("Nombre proyecto:" +"\n Fecha");

		JButton izquierda = new JButton ("Agregar Participantes");
		JButton centro = new JButton ("Agregar Actividad");

		btnReporte = new JButton("Generar reporte");
		btnReporte.setActionCommand(ENTER);
		btnReporte.addActionListener(this);
		
		JLabel abajo = new JLabel ("Aqui va a ir la linea del tiempo");

		add(izquierda, BorderLayout.WEST);
		add(centro, BorderLayout.CENTER);
		add(btnReporte, BorderLayout.EAST);
		add (arriba, BorderLayout.NORTH);
		add (abajo, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200,500);
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
			new VentanaPrincipal(false, controlador);
		}
		else
		{
			new VentanaPrincipal(true, controlador);
		}
	}


	public void crearProyecto(String nombre, String descripccion, String fechaInicio, String fechaFin,
			ArrayList<String> Actividades, Controlador controlador) throws IOException
	{
		// TODO Auto-generated method stub
		controlador.setProyectoInterfaz(nombre, descripccion, fechaInicio, fechaFin, Actividades);
	}
	
	public void generarReporte(int id, Controlador controlador)
	{
		
		controlador.cargarReporte(id);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		if (grito.equals(ENTER))
		{
			System.out.println("prueba");
			
			ventanaReporte = new VentanaElegirParticipante(this, controlador);
			
		}
		
	}


}