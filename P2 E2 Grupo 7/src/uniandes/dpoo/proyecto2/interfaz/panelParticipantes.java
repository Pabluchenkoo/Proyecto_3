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

public class panelParticipantes extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    private static final String AGREGAR = "AGREGAR"; 

    private static final String ELIMINAR = "ELIMINAR";

    private VentanaPrincipal ventanaPrincipal;

    /**
     * Lista de archivos
     */
    private JList listaParticipantes;

    /**
     * Scroll para la lista
     */
    private JScrollPane scrollParticipantes;

    /**
     * Lista de archivos
     */
    private JList listaProyectos;

    /**
     * Scroll para la lista
     */
    private JScrollPane scrollProyectos;

    private JLabel lblNombre;

    private JLabel lblCorreo;

    private JTextField txtNombre;

    private JTextField txtCorreo;

    private JButton btnAgregar;

    private JButton btnEliminar;

    private JButton btnEscoger;

    DefaultListModel listaParticipantesModel = new DefaultListModel();


    public panelParticipantes(VentanaPrincipal principal) {
        ventanaPrincipal = principal;
        setPreferredSize(new Dimension(250, 200));
        ventanaPrincipal = principal;
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        // // ---------------------------------------------------------------------------
        // // Panel Lista de proyectos -------------------------------------------------
        // // ---------------------------------------------------------------------------

        // JPanel panelProyectos = new JPanel();
        // panelProyectos.setLayout(new BorderLayout());
        // panelProyectos.setPreferredSize(new Dimension(250, 200));
        // panelProyectos.setBackground(Color.LIGHT_GRAY);
        // this.add(panelProyectos, BorderLayout.NORTH);

        // JLabel lblProyectos = new JLabel("Lista de Proyectos:");
        // lblProyectos.setFont(new Font("Arial", Font.BOLD, 18));
        // panelProyectos.add(lblProyectos, BorderLayout.NORTH);

        // listaProyectos = new JList();
        // DefaultListModel listaProyectosModel = new DefaultListModel();
        // listaProyectos.setModel(listaProyectosModel);
        // listaProyectosModel.addElement("Proyecto1");
        

        // scrollProyectos = new JScrollPane(listaProyectos);
        // scrollProyectos.setPreferredSize(new Dimension(250, 240));
        // panelProyectos.add(scrollProyectos, BorderLayout.CENTER);

        // btnEscoger = new JButton("Escoger");
        // // btnEscoger.addActionListener( ventanaPrincipal );
        // btnEscoger.setPreferredSize(new Dimension(20, 40));
        // panelProyectos.add(btnEscoger, BorderLayout.SOUTH);

        // ---------------------------------------------------------------------------
        // Panel Participantes-----------------------------------------------------
        // ---------------------------------------------------------------------------

        JPanel panelParticipantes = new JPanel();
        panelParticipantes.setLayout(new BorderLayout());
        panelParticipantes.setPreferredSize(new Dimension(250, 30));
        panelParticipantes.setBackground(Color.LIGHT_GRAY);
        this.add(panelParticipantes, BorderLayout.CENTER);

        JLabel lblParticipantes = new JLabel("Lista de Participantes:");
        lblParticipantes.setFont(new Font("Arial", Font.BOLD, 18));
        lblParticipantes.setPreferredSize(new Dimension(100, 20));
        listaParticipantesModel.addElement("Participante1");
        panelParticipantes.add(lblParticipantes, BorderLayout.NORTH);

        listaParticipantes = new JList(listaParticipantesModel);
        listaParticipantes.setModel(listaParticipantesModel);

        scrollParticipantes = new JScrollPane(listaParticipantes);
        scrollParticipantes.setPreferredSize(new Dimension(250, 25));
        panelParticipantes.add(listaParticipantes, BorderLayout.CENTER);

        // ---------------------------------------------------------------------------
        // Panel botones-----------------------------------------------------
        // ---------------------------------------------------------------------------

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.setPreferredSize(new Dimension(250, 110));
        panel.setBackground(Color.LIGHT_GRAY);
        add(panel, BorderLayout.SOUTH);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setPreferredSize(new Dimension(20, 20));
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setPreferredSize(new Dimension(20, 10));
        panel.add(txtNombre);

        lblCorreo = new JLabel("Correo:");
        lblCorreo.setPreferredSize(new Dimension(20, 20));

        panel.add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setPreferredSize(new Dimension(20, 20));
        panel.add(txtCorreo);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setPreferredSize(new Dimension(20, 20));
        btnAgregar.setActionCommand(AGREGAR);
        btnAgregar.addActionListener(this);
        panel.add(btnAgregar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setPreferredSize(new Dimension(20, 20));
        btnEliminar.setActionCommand(ELIMINAR);
        btnEliminar.addActionListener(this);
        panel.add(btnEliminar);

        setVisible(true);

    }

    
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        String comando = e.getActionCommand();
        if (comando.equals(AGREGAR) ) {

            String nombre = txtNombre.getText();
            String correo = txtCorreo.getText();
            
            try {
                ventanaPrincipal.getControlador().addParticipante(nombre + " " + correo);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            listaParticipantesModel.addElement(nombre + "--" + correo);

        }
        else if (comando.equals(ELIMINAR))
        {

            int index = listaParticipantes.getSelectedIndex();
            if (index != -1) {
                listaParticipantesModel.remove(index);
            }

        }

    }

}
