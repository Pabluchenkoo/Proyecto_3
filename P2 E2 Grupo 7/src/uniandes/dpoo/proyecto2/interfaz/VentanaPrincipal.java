package uniandes.dpoo.proyecto2.interfaz;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame{

	public VentanaPrincipal()
	{
		setTitle("Registro Proyecto :)");
		setLayout(new BorderLayout());
		
		JButton izquierda = new JButton ("Agregar Participantes");
		JButton centro = new JButton ("Agregar Actividad");
		JButton derecha = new JButton ("Generar Reporte");
		
		add(izquierda, BorderLayout.WEST);
		add(centro, BorderLayout.CENTER);
		add(derecha, BorderLayout.EAST);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,1200);
		setVisible(true);
	}




	public static void main(String[] args)
	{
		new VentanaPrincipal();
	}

}