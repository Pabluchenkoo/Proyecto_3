package uniandes.dpoo.proyecto2.interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.dpoo.proyecto2.controlador.Controlador;

@SuppressWarnings("serial")
public class VentanaNuevoProyecto extends JFrame implements ActionListener{

	private static final String ENTER = "ENTER";

	private static final String AGREGAR = "AGREGAR";

	private ArrayList <String> tipoActividades;
	
	private Controlador aControlador;

	private JLabel labelN1;
	private JTextField textN1;

	private JLabel labelN2;
	private JTextField textN2;

	private JLabel labelS1;
	private JTextField textS1;

	private JLabel labelS2;
	private JTextField textS2;

	private JLabel labelS3;
	private JTextField textS3;

	private JButton btnEnter;

	private JButton btnAgregar;

	private VentanaPrincipal padre;

	public VentanaNuevoProyecto(VentanaPrincipal papa, Controlador elControlador)
	{
		padre = papa;

		tipoActividades = new ArrayList<>();
		
		aControlador = elControlador;

		setTitle("Nuevo Proyecto");

		setLayout(new BorderLayout());

		labelN1 = new JLabel("Nombre:");
		textN1 = new JTextField();
		JPanel auxN1 = new JPanel();
		auxN1.setLayout(new BorderLayout());
		auxN1.add(labelN1, BorderLayout.WEST);
		auxN1.add(textN1, BorderLayout.CENTER);

		labelN2 = new JLabel("Descripccion:");
		textN2 = new JTextField();
		JPanel auxN2 = new JPanel();
		auxN2.setLayout(new BorderLayout());
		auxN2.add(labelN2, BorderLayout.WEST);
		auxN2.add(textN2, BorderLayout.CENTER);

		JPanel auxNT = new JPanel();
		auxNT.setLayout(new BorderLayout());
		auxNT.add(auxN1, BorderLayout.NORTH);
		auxNT.add(auxN2, BorderLayout.SOUTH);

		labelS1 = new JLabel("Fecha inicio (DD/MM/AAAA):");
		textS1 = new JTextField();
		JPanel auxS1 = new JPanel();
		auxS1.setLayout(new BorderLayout());
		auxS1.add(labelS1, BorderLayout.WEST);
		auxS1.add(textS1, BorderLayout.CENTER);

		labelS2 = new JLabel("Fecha fin (DD/MM/AAAA):");
		textS2 = new JTextField();
		JPanel auxS2 = new JPanel();
		auxS2.setLayout(new BorderLayout());
		auxS2.add(labelS2, BorderLayout.WEST);
		auxS2.add(textS2, BorderLayout.CENTER);

		JPanel auxSDate = new JPanel();
		auxSDate.setLayout(new BorderLayout());
		auxSDate.add(auxS1, BorderLayout.NORTH);
		auxSDate.add(auxS2, BorderLayout.SOUTH);

		btnEnter = new JButton("Enter");
		btnEnter.setActionCommand(ENTER);
		btnEnter.addActionListener(this);

		JPanel auxSButton = new JPanel();
		auxSButton.setLayout(new BorderLayout());
		auxSButton.add(btnEnter, BorderLayout.NORTH);

		JPanel auxST = new JPanel();
		auxST.setLayout(new BorderLayout());
		auxST.add(auxSDate, BorderLayout.NORTH);
		auxST.add(auxSButton, BorderLayout.SOUTH);


		add(auxNT, BorderLayout.CENTER);
		add(auxST, BorderLayout.SOUTH);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setActionCommand(AGREGAR);
		btnAgregar.addActionListener(this);


		labelS3 = new JLabel("Numero de actividades tipo:");
		textS3 = new JTextField();
		JPanel auxS3 = new JPanel();
		auxS3.setLayout(new BorderLayout());
		auxS3.add(labelS3, BorderLayout.WEST);
		auxS3.add(textS3, BorderLayout.CENTER);

		JPanel auxST2 = new JPanel();
		auxST2.setLayout(new BorderLayout());
		auxST2.add(auxS3, BorderLayout.NORTH);
		auxST2.add(btnAgregar, BorderLayout.SOUTH);

		add(auxST2, BorderLayout.NORTH);


		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500,300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();

		if (grito.equals(AGREGAR))
		{
			try
			{

				String numactividadesTipo = textS3.getText();
				int nActividades = Integer.parseInt(numactividadesTipo);
				for (int pos = 0; pos < nActividades; pos++)
				{
					new VentanaTipoActividad(this);
				}

			}
			catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Falta dato", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}

		if (grito.equals(ENTER))
		{
			try
			{
				String nombre = textN1.getText();
				String descripccion = textN2.getText();
				String fechaInicio = textS1.getText();
				String fechaFin = textS2.getText();
			
				padre.crearProyecto(nombre, descripccion, fechaInicio, fechaFin, tipoActividades, aControlador);
			    /*cerrar ventana*/
				
			}
			catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Falta dato", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}


	}

	public void agregarTipoActividad(String actividad)
	{
		tipoActividades.add(actividad);
	}

}
