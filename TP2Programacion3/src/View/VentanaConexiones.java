package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import Model.Tupla;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaConexiones {

	private JFrame frame;
	private Interfaz interfaz;
	private JScrollPane scrollPaneEstacionConocidas;
	private JScrollPane scrollPaneEstacionesVecinas;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConexiones window = new VentanaConexiones();
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
	public VentanaConexiones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dibujarFrame();
		dibujarLabels();
		dibujarTablaEstacionesConocidas();
		dibujarTablaEstacionesVecinas();
		dibujaBotones();
	}

	private void dibujarLabels() {
		JLabel lblEstacionesVecinas = new JLabel("Estaciones Vecinas");
		lblEstacionesVecinas.setBounds(32, 42, 120, 14);
		frame.getContentPane().add(lblEstacionesVecinas);	
		JLabel lblEstacionesConocidas = new JLabel("Estaciones Conocidas");
		lblEstacionesConocidas.setBounds(350, 42, 120, 14);
		frame.getContentPane().add(lblEstacionesConocidas);
	}

	private void dibujaBotones() {
		JButton btnCargarEstacionVecina = new JButton("Cargar");
		btnCargarEstacionVecina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String impactoAmbiental = JOptionPane.showInputDialog("Impacto Ambiental: ");
			}
		});
		btnCargarEstacionVecina.setBounds(451, 348, 89, 23);
		frame.getContentPane().add(btnCargarEstacionVecina);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnFinalizar.setBounds(290, 378, 89, 23);
		frame.getContentPane().add(btnFinalizar);		
	}

	private void dibujarTablaEstacionesVecinas() {
		JScrollPane scrollPaneEstacionVecina = new JScrollPane();
		scrollPaneEstacionVecina.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPaneEstacionVecina.setBounds(27, 80, 272, 247);
		frame.getContentPane().add(scrollPaneEstacionVecina);
		
	}

	private void dibujarFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 708, 463);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.getContentPane().setLayout(null);
		this.interfaz = new Interfaz();
	}
	
	private void dibujarTablaEstacionesConocidas() {
		scrollPaneEstacionConocidas = new JScrollPane();
		scrollPaneEstacionConocidas.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPaneEstacionConocidas.setBounds(350, 80, 272, 247);
		frame.getContentPane().add(scrollPaneEstacionConocidas);		
	}

	private void cargarEstaciones(ArrayList<Tupla<String, Coordinate>> coordenadas) {
	}

	public void abrirVentana() {
		this.frame.setVisible(true);
	}
}
