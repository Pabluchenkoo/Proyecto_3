package uniandes.dpoo.proyecto2.interfaz;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.proyecto2.modelo.Actividad;
import uniandes.dpoo.proyecto2.modelo.Proyecto;

public class LineaTiempo extends JPanel{
	private Proyecto proyecto;
	@Override
	public void paint(Graphics g) {
		ArrayList<Actividad> listaActividades = proyecto.getActividades();
		
		super.paint(g);
		g.drawLine(25,100,675,100);
		for (int pos = 0; pos < listaActividades.size(); pos++)
		{	
			String nombreAct = listaActividades.get(pos).getTitulo();
			int x1 = 40+(40*pos);
			int y1 = 100;
			int x2 = 40+(40*pos);
			int y2 = 25;
			g.drawLine(x1, y1, x2, y2);
			g.drawString(nombreAct, x1, 105);
		}
	}
	public static void main(String[] args) {
		JFrame ventana = new JFrame("Linea del tiempo");
		LineaTiempo objeto = new LineaTiempo();
		ventana.add(objeto);
		ventana.setSize(700,250);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
