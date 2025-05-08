package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;


import Model.Tupla;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Interfaz {

	private JFrame frame;
	private JPanel panelMapa;
	private JPanel panelControles;
	private JMapViewer mapa;
	private VentanaConexiones ventanaConexiones;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dibujarFrame();
		dibujarPanelMapa();
		
		
		panelControles = new JPanel();
		panelControles.setBounds(457, 11, 242, 446);
		frame.getContentPane().add(panelControles);		
		panelControles.setLayout(null);
		
		mapa = new JMapViewer();
		mapa.setDisplayPosition(new Coordinate(-34.521, -58.7008), 15);
				
		panelMapa.add(mapa);

		detectarCoordenadas();
	}
	
	private void dibujarPanelMapa() {
		panelMapa = new JPanel();
		panelMapa.setBounds(10, 11, 437, 446);
		frame.getContentPane().add(panelMapa);
	}

	private void dibujarFrame() {
		frame = new JFrame();
		frame.setBounds(500, 20, 1200, 1020);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}

	private void detectarCoordenadas() 
	{
		mapa.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
			if (e.getButton() == MouseEvent.BUTTON1)
			{
				Coordinate coordenada = (Coordinate)mapa.getPosition(e.getPoint());
				String nombre = JOptionPane.showInputDialog("Nombre: ");
				mapa.addMapMarker(new MapMarkerDot(coordenada));
				abrirVentanaConexiones();
			}}

			private void abrirVentanaConexiones() {
				ventanaConexiones = new VentanaConexiones();
				ventanaConexiones.abrirVentana();
			}
		});
	}


}


