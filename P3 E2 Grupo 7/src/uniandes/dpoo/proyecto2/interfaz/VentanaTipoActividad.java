package uniandes.dpoo.proyecto2.interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class VentanaTipoActividad extends JFrame implements ActionListener {
	
	private static final String ENTER = "ENTER";
	private JButton btnEnter;
	
	private JLabel labelN1;
	private JTextField textN1;
	private VentanaNuevoProyecto papa;
	
	public VentanaTipoActividad(VentanaNuevoProyecto padre)
	{
		papa = padre;

		setTitle("Agregar nuevo tipo de actividad");

		setLayout(new BorderLayout());
		
		labelN1 = new JLabel("Nombre:");
		textN1 = new JTextField();
		JPanel auxN1 = new JPanel();
		auxN1.setLayout(new BorderLayout());
		auxN1.add(labelN1, BorderLayout.WEST);
		auxN1.add(textN1, BorderLayout.CENTER);
		
		btnEnter = new JButton("Enter");
		btnEnter.setActionCommand(ENTER);
		btnEnter.addActionListener(this);
		
		add(auxN1, BorderLayout.NORTH);
		add(btnEnter, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500,300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		if (grito.equals(ENTER))
		{
			String n1Str = textN1.getText();
			papa.agregarTipoActividad(n1Str);
			dispose();
		}
		
	}

}
