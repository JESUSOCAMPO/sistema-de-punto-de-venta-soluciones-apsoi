package gui;

import java.awt.EventQueue;

import clases.Articulo;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RootPaneContainer;

import java.awt.BorderLayout;

//import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * @author Heidy Alba
 *
 */
public class ventanaPrincipal {

	private JFrame frame;
	private JPanel panelIzquierdo;
	protected JPanel panelCentro;
	private JButton btnUsuario;
	private JButton btnEmpleado;
	private JButton btnCliente;
	private JButton btnArticulo;
	private JButton btnFactura;
	private JButton btnDevolucion;
	private JButton btnInforme;
	private JPanel panel;
	private int panelMostrandose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaPrincipal window = new ventanaPrincipal();
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
	public ventanaPrincipal() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		
		panelIzquierdo = new JPanel();
		frame.getContentPane().add(panelIzquierdo, BorderLayout.WEST);
		//panelIzquierdo.setLayout(new MigLayout("", "[]", "[][][][][][][][][]"));
		
		final PanelArticulos pa = new PanelArticulos();
		final PanelFactura pf = new PanelFactura();
		final PanelUsuarios pu = new PanelUsuarios();
		
		btnUsuario = new JButton("");
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMostrandose = 7;
				if(panelMostrandose != 7 || panelMostrandose ==7)
				{
					pf.setVisible(false);
					panelCentro.remove(pf);
					pu.setVisible(true);
					pu.show();
				}
			}
		});
		btnUsuario.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Imagenes/Uasuarios.png")));
		panelIzquierdo.add(btnUsuario, "cell 0 0");
		
		btnEmpleado = new JButton("New button");
		btnEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMostrandose = 1;
				if(panelMostrandose != 1 || panelMostrandose == 1)
				{
					
				}
			}
		});
		panelIzquierdo.add(btnEmpleado, "cell 0 1");
		
		btnCliente = new JButton("New button");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMostrandose = 2;
				if(panelMostrandose != 2 || panelMostrandose == 2)
				{
					
				}
			}
		});
		panelIzquierdo.add(btnCliente, "cell 0 2");
		
		btnArticulo = new JButton("");
		btnArticulo.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Imagenes/Articulos.png")));
		panelIzquierdo.add(btnArticulo, "cell 0 3");
	
		btnFactura = new JButton("");
		btnFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelMostrandose = 3;
				//PanelFactura pf = new PanelFactura();
				if(panelMostrandose != 3 || panelMostrandose == 3)
				{	
					
				panelCentro.setVisible(false);
				frame.getContentPane().add(pf, BorderLayout.CENTER);
				pf.show();
				}
				
				
			}
		});
		btnFactura.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Imagenes/Factura.png")));
		panelIzquierdo.add(btnFactura, "cell 0 4");
		
		btnDevolucion = new JButton("New button");
		btnDevolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMostrandose = 4;
				if(panelMostrandose != 4 || panelMostrandose == 4)
				{
					
				}
			}
		});
		btnDevolucion.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Imagenes/Devolucion.png")));
		btnDevolucion.setText("");
		panelIzquierdo.add(btnDevolucion, "cell 0 5");
		
		btnInforme = new JButton("New button");
		btnInforme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMostrandose = 5;
				if(panelMostrandose != 5 || panelMostrandose == 5)
				{
					
				}
			}
		});
		btnInforme.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Imagenes/Informe.png")));
		btnInforme.setText("");
		panelIzquierdo.add(btnInforme, "cell 0 6");
		
		panelCentro = new JPanel();
		frame.getContentPane().add(panelCentro, BorderLayout.SOUTH);
		/*
		panel = new JPanel();
		panel.setBackground(Color.RED);
		panelCentro.add(panel);*/
		
		panelCentro.setVisible(true);
		
		btnArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMostrandose = 6;
				panelCentro.setVisible(false);
				if(panelMostrandose != 4 || panelMostrandose == 4)
				{
				PanelArticulos articulo = new PanelArticulos();
				frame.getContentPane().add(articulo, BorderLayout.CENTER);
				articulo.show();
				}
				
				
				
				//JOptionPane.showMessageDialog(null,"ddddd");
				//Articulo articulo = new Articulo(codigo, costo, precio, descripcion);
				/*PanelArticulos p = new PanelArticulos();
				panelCentro.setVisible(false);
				//panelCentro.remove(panelCentro);
				p.setVisible(true);
				panelCentro.add(p, BorderLayout.CENTER);
				*/
				//ventanaArticulos articulo = new ventanaArticulos();
				
			}
		});
		
		//Articulo a = new Articulo(4.90,7.60,54.00,"prueba");
		//System.out.print(a.getDescripcionArticulo());
		//JOptionPane.showMessageDialog(null, a.getDescripcionArticulo());
	}

	
}
