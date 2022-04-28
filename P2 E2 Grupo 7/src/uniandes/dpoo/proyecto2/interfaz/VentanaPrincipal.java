package uniandes.dpoo.proyecto2.interfaz;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame{

	public VentanaPrincipal()
	{
		setTitle("Registro Proyecto :)");
		setLayout(new BorderLayout());
		
		JLabel arriba = new JLabel ("Nombre proyecto:" +"\n Fecha");
		
		JButton izquierda = new JButton ("Agregar Participantes");
		JButton centro = new JButton ("Agregar Actividad");
		JButton derecha = new JButton ("Generar Reporte");
		
		JLabel abajo = new JLabel ("Aqui va a ir la linea del tiempo");
		
		add(izquierda, BorderLayout.WEST);
		add(centro, BorderLayout.CENTER);
		add(derecha, BorderLayout.EAST);
		add (arriba, BorderLayout.NORTH);
		add (abajo, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200,500);
		setVisible(true);
	}




	public static void main(String[] args)
	{
		new VentanaPrincipal();
	}

}