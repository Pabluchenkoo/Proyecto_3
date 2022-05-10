package uniandes.dpoo.proyecto2.interfaz;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.dpoo.proyecto2.modelo.Participante;

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
        ventanaPrincipal = principal;
        setPreferredSize(new Dimension(250, 200));
        ventanaPrincipal = principal;
        setLayout( new BorderLayout( ) );
        setBackground(Color.LIGHT_GRAY);

        // ---------------------------------------------------------------------------
        // Panel Lista de proyectos -------------------------------------------------
        // ---------------------------------------------------------------------------


        JPanel panelProyectos = new JPanel();
        panelProyectos.setLayout( new BorderLayout() );
        panelProyectos.setPreferredSize(new Dimension(250, 200));
        panelProyectos.setBackground(Color.LIGHT_GRAY);
        this.add(panelProyectos, BorderLayout.NORTH);

        JLabel lblProyectos = new JLabel("Lista de Proyectos:");
        lblProyectos.setFont(new Font("Arial", Font.BOLD, 18));
        panelProyectos.add(lblProyectos, BorderLayout.NORTH);

        listaProyectos = new JList( );
        listaProyectos.addListSelectionListener( this );
        scrollProyectos = new JScrollPane( listaProyectos );
        scrollProyectos.setPreferredSize( new Dimension( 250, 240 ) );
        panelProyectos.add( scrollProyectos, BorderLayout.CENTER );

        btnEscoger = new JButton( "Escoger" );
        // btnEscoger.addActionListener( ventanaPrincipal );
        btnEscoger.setPreferredSize(new Dimension(20,40));
        panelProyectos.add( btnEscoger, BorderLayout.SOUTH );

        // ---------------------------------------------------------------------------
        //Panel Participantes-----------------------------------------------------
        //---------------------------------------------------------------------------


        JPanel panelParticipantes = new JPanel();
        panelParticipantes.setLayout( new BorderLayout() );
        panelParticipantes.setPreferredSize(new Dimension(250, 30));
        panelParticipantes.setBackground(Color.LIGHT_GRAY);
        this.add(panelParticipantes, BorderLayout.CENTER);

        JLabel lblParticipantes = new JLabel("Lista de Participantes:");
        lblParticipantes.setFont(new Font("Arial", Font.BOLD, 18));
        lblParticipantes.setPreferredSize(new Dimension(100, 20));
        panelParticipantes.add(lblParticipantes , BorderLayout.NORTH);

        listaParticipantes = new JList( );
        listaParticipantes.addListSelectionListener( this );
        scrollParticipantes = new JScrollPane( listaParticipantes );
        scrollParticipantes.setPreferredSize( new Dimension( 250, 25 ) );
        panelParticipantes.add( scrollParticipantes, BorderLayout.CENTER );
        

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

   
    /**
     * Actualiza la información de los archivos
     * @param archivos son los archivos nuevos
     */
    public void refrescarParticipantes( Participante[] participantes )
    {
        listaParticipantes.setListData( participantes );
    }

    /**
     * Devuelve el archivo seleccionado. Devuelve null si ningún archivo esta seleccionado
     * @return Archivo seleccionado
     */
    public Participante darArchivoSeleccionado( )
    {
        return ( Participante )listaParticipantes.getSelectedValue( );
    }

    // -----------------------------------------------------------------
    // Eventos
    // -----------------------------------------------------------------

    /**
     * Cambio en la selección de la lista
     * @param e es el evento de cambio
     */
    public void valueChanged( ListSelectionEvent e )
    {
        // Selección en la lista de archivos
        Participante archivo = darArchivoSeleccionado( );
        // Muestra el diálogo del archivo
        // principal.verInfoArchivo( archivo );
    }

}
