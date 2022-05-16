package uniandes.dpoo.proyecto2.interfaz;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.IOException;


public class PanelActividades extends JPanel implements ActionListener {
    
    private static final long serialVersionUID = 1L;

    private static final String AGREGAR = "AGREGAR"; 

    private static final String ELIMINAR = "ELIMINAR";

    private VentanaPrincipal ventanaPrincipal;

    /**
     * Lista de archivos
     */
    private JList listaActividades;

    /**
     * Scroll para la lista
     */
    private JScrollPane scrollParticipantes;


    private JLabel lblTitulo;

    private JLabel lblDescripcion;

    private JLabel lblTipoID;

    private JLabel lblFecha;

    private JLabel lblHoraInicio;

    private JLabel lblHoraFin;

    private JLabel lblDuracion;

    private JLabel lblParticipanteID;

    private JTextField txtTitulo;

    private JTextField txtDescripcion;

    private JTextField txtTipoID;

    private JTextField txtFecha;

    private JTextField txtHoraInicio;

    private JTextField txtHoraFin;

    private JTextField txtDuracion;

    private JTextField txtParticipanteID;

    private JButton btnAgregar;

    private JButton btnEliminar;



    // private String titulo;
	// private String descripccion;
	// private int tipoID;
	// private String fecha;
	// private String horaInicio;
	// private String horaFin;
	// private int duracion;
	// private int participanteID;

    DefaultListModel listaActividadesModel = new DefaultListModel();


    public PanelActividades(VentanaPrincipal principal) {


        ventanaPrincipal = principal;
        setPreferredSize(new Dimension(250, 200));
        ventanaPrincipal = principal;
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        cargarParticipantes();

        JPanel panelParticipantes = new JPanel();
        panelParticipantes.setLayout(new BorderLayout());
        panelParticipantes.setPreferredSize(new Dimension(250, 150));
        panelParticipantes.setBackground(Color.LIGHT_GRAY);
        this.add(panelParticipantes, BorderLayout.NORTH);

        JLabel lblParticipantes = new JLabel("Lista de Actividades:");
        lblParticipantes.setFont(new Font("Arial", Font.BOLD, 18));
        lblParticipantes.setPreferredSize(new Dimension(100, 20));
        listaActividadesModel.addElement("Actividad1");
        panelParticipantes.add(lblParticipantes, BorderLayout.NORTH);

        listaActividades = new JList(listaActividadesModel);
        listaActividades.setModel(listaActividadesModel);

        scrollParticipantes = new JScrollPane(listaActividades);
        scrollParticipantes.setPreferredSize(new Dimension(250, 120));
        panelParticipantes.add(listaActividades, BorderLayout.CENTER);

        // ---------------------------------------------------------------------------
        // Panel botones-----------------------------------------------------
        // ---------------------------------------------------------------------------

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));
        panel.setPreferredSize(new Dimension(250, 10));
        panel.setBackground(Color.LIGHT_GRAY);
        add(panel, BorderLayout.CENTER);

        lblTitulo = new JLabel("Nombre:");
        lblTitulo.setPreferredSize(new Dimension(20, 20));
        panel.add(lblTitulo);

        txtTitulo = new JTextField();
        txtTitulo.setPreferredSize(new Dimension(20, 10));
        panel.add(txtTitulo);

        lblDescripcion = new JLabel("Correo:");
        lblDescripcion.setPreferredSize(new Dimension(20, 20));

        panel.add(lblDescripcion);

        txtDescripcion = new JTextField();
        txtDescripcion.setPreferredSize(new Dimension(20, 20));
        panel.add(txtDescripcion);


        lblTipoID = new JLabel("Tipo ID:");
        lblTipoID.setPreferredSize(new Dimension(20, 20));
        panel.add(lblTipoID);

        txtTipoID = new JTextField();
        txtTipoID.setPreferredSize(new Dimension(20, 20));
        panel.add(txtTipoID);

        lblFecha = new JLabel("Fecha:");
        lblFecha.setPreferredSize(new Dimension(20, 20));
        panel.add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setPreferredSize(new Dimension(20, 20));
        panel.add(txtFecha);

        lblHoraInicio = new JLabel("Hora Inicio:");
        lblHoraInicio.setPreferredSize(new Dimension(20, 20));
        panel.add(lblHoraInicio);

        txtHoraInicio = new JTextField();
        txtHoraInicio.setPreferredSize(new Dimension(20, 20));
        panel.add(txtHoraInicio);

        lblHoraFin = new JLabel("Hora Fin:");
        lblHoraFin.setPreferredSize(new Dimension(20, 20));
        panel.add(lblHoraFin);

        txtHoraFin = new JTextField();
        txtHoraFin.setPreferredSize(new Dimension(20, 20));
        panel.add(txtHoraFin);

        lblDuracion = new JLabel("Duracion:");
        lblDuracion.setPreferredSize(new Dimension(20, 20));
        panel.add(lblDuracion);

        txtDuracion = new JTextField();
        txtDuracion.setPreferredSize(new Dimension(20, 20));
        panel.add(txtDuracion);

        lblParticipanteID = new JLabel("Participante ID:");
        lblParticipanteID.setPreferredSize(new Dimension(20, 20));
        panel.add(lblParticipanteID);

        txtParticipanteID = new JTextField();
        txtParticipanteID.setPreferredSize(new Dimension(20, 20));
        panel.add(txtParticipanteID);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2));
        panelBotones.setPreferredSize(new Dimension(250, 35));
        panelBotones.setBackground(Color.LIGHT_GRAY);
        add(panelBotones, BorderLayout.SOUTH);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setPreferredSize(new Dimension(20, 20));
        btnAgregar.setActionCommand(AGREGAR);
        btnAgregar.addActionListener(this);
        panelBotones.add(btnAgregar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setPreferredSize(new Dimension(20, 20));
        btnEliminar.setActionCommand(ELIMINAR);
        btnEliminar.addActionListener(this);
        panelBotones.add(btnEliminar);

        setVisible(true);

    }

    public void cargarParticipantes()
    {
        LinkedList<String> persistentes = ventanaPrincipal.getControlador().cargarParticipantes();

        for(int i =0; i< persistentes.size();i++)
        {
            String participante = persistentes.get(i);
            String[] partes = participante.split(" ");
            String nombre = partes[0];
            String correo = partes[1];
            listaActividadesModel.addElement(nombre + "-" + correo);

        }

    }    
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        String comando = e.getActionCommand();
        if (comando.equals(AGREGAR) ) {

            String titulo = txtTitulo.getText();
            String descrip = txtDescripcion.getText();
            String tipoID = txtTipoID.getText();
            String fecha = txtFecha.getText();
            String horaInicio = txtHoraInicio.getText();
            String horaFin = txtHoraFin.getText();
            String duracion = txtDuracion.getText();
            String participanteID = txtParticipanteID.getText();

            listaActividadesModel.addElement(titulo + "--" + descrip 
            + "--" + tipoID + "--" + fecha + "--" 
            + horaInicio + "--" + horaFin + "--" 
            + duracion + "--" + participanteID);
            
            try {
                ventanaPrincipal.getControlador().addActividad(titulo, descrip, 
                tipoID, fecha, horaInicio, horaFin, duracion, participanteID);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            

        }
        else if (comando.equals(ELIMINAR))
        {

            int index = listaActividades.getSelectedIndex();
            if (index != -1) {
                listaActividadesModel.remove(index);
            }

        }

    }
}
