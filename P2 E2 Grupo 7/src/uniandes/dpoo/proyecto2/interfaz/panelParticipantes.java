package uniandes.dpoo.proyecto2.interfaz;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.util.*;

public class panelParticipantes extends JPanel implements ListSelectionListener
{

    private static final long serialVersionUID = 1L;

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

    private JButton btnConsultar;

    private JButton btnEscoger;

    public panelParticipantes(VentanaPrincipal principal)
    {
        setPreferredSize(new Dimension(250, 200));
        ventanaPrincipal = principal;
        setLayout( new BorderLayout( ) );
        setBackground(Color.LIGHT_GRAY);

        // ---------------------------------------------------------------------------
        // Panel Lista de proyectos -------------------------------------------------
        // ---------------------------------------------------------------------------


        JPanel panelProyectos = new JPanel();
        panelProyectos.setLayout( new GridLayout(3, 1 ) );
        panelProyectos.setPreferredSize(new Dimension(250, 200));
        panelProyectos.setBackground(Color.LIGHT_GRAY);
        this.add(panelProyectos, BorderLayout.NORTH);

        JLabel lblProyectos = new JLabel("Lista de Proyectos:");
        lblProyectos.setFont(new Font("Arial", Font.BOLD, 18));
        panelProyectos.add(lblProyectos);

        listaProyectos = new JList( );
        listaProyectos.addListSelectionListener( this );
        scrollProyectos = new JScrollPane( listaProyectos );
        scrollProyectos.setPreferredSize( new Dimension( 250, 240 ) );
        panelProyectos.add( scrollProyectos );

        btnEscoger = new JButton( "Escoger" );
        // btnEscoger.addActionListener( ventanaPrincipal );
        btnEscoger.setPreferredSize(new Dimension(20,20));
        panelProyectos.add( btnEscoger);

        // ---------------------------------------------------------------------------
        //Panel Participantes-----------------------------------------------------
        //---------------------------------------------------------------------------


        JPanel panelParticipantes = new JPanel();
        panelParticipantes.setLayout( new GridLayout(2, 1 ) );
        panelParticipantes.setPreferredSize(new Dimension(250, 50));
        panelParticipantes.setBackground(Color.LIGHT_GRAY);
        this.add(panelParticipantes, BorderLayout.CENTER);

        JLabel lblParticipantes = new JLabel("Lista de Participantes:");
        lblProyectos.setFont(new Font("Arial", Font.BOLD, 18));
        lblProyectos.setPreferredSize(new Dimension(250, 5));
        panelParticipantes.add(lblParticipantes);

        listaParticipantes = new JList( );
        listaParticipantes.addListSelectionListener( this );
        scrollParticipantes = new JScrollPane( listaParticipantes );
        scrollParticipantes.setPreferredSize( new Dimension( 250, 1 ) );
        panelParticipantes.add( scrollParticipantes );
        
        
        // ---------------------------------------------------------------------------
        //Panel botones-----------------------------------------------------
        // ---------------------------------------------------------------------------


        JPanel panel = new JPanel( );
        panel.setLayout( new GridLayout( 3, 2 ) );
        panel.setPreferredSize( new Dimension( 250, 110 ) );
        panel.setBackground(Color.LIGHT_GRAY);
        add( panel, BorderLayout.SOUTH );


        lblNombre = new JLabel( "Nombre:" );
        lblNombre.setPreferredSize(new Dimension(20,20));
        panel.add( lblNombre );

        txtNombre = new JTextField( );
        txtNombre.setPreferredSize(new Dimension(20,10));
        panel.add( txtNombre);

        lblCorreo = new JLabel( "Correo:" );
        lblCorreo.setPreferredSize(new Dimension(20,20));
        panel.add( lblCorreo );

        txtCorreo = new JTextField( );
        txtCorreo.setPreferredSize(new Dimension(20,20));
        panel.add( txtCorreo );
        
        btnAgregar = new JButton( "Agregar" );
        btnAgregar.setPreferredSize(new Dimension(20,20));
        panel.add( btnAgregar);

        btnConsultar = new JButton( "Consultar" );
        btnConsultar.setPreferredSize(new Dimension(20,20));
        panel.add( btnConsultar );

        setVisible(true);

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // TODO Auto-generated method stub
        
    }


}
