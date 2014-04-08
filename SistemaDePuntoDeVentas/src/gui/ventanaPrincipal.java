package gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Rectangle;

import clases.Articulo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.RootPaneContainer;

import java.awt.BorderLayout;

//import net.miginfocom.swing.MigLayout;





import javax.swing.JButton;
import javax.swing.text.IconView;

import net.miginfocom.swing.MigLayout;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dialog.ModalExclusionType;

/**
 * @author Heidy Alba
 *
 */
public class ventanaPrincipal {

	
	private JFrame frame;
	private JPanel barraDeHerramientas;
	protected JTabbedPanePersonalized panelCentro;
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
		frame.setBounds(100, 100, 1036, 652);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		
		barraDeHerramientas = new JPanel();
		frame.getContentPane().add(barraDeHerramientas, BorderLayout.NORTH);
		
		final PanelArticulos pa = new PanelArticulos();
		final PanelFactura pf = new PanelFactura();
		//final PanelUsuarios pu = new PanelUsuarios();
		
		btnUsuario = new JButton("");
		btnUsuario.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
		
					
				//TODO: VALIDAR QUE REALMENTE SE QUIERA SALIR DEL FORMULARIO ACTUAL
				PanelUsuarios usuarios = new PanelUsuarios();
					agregarPanelAlCentro("Usuarios", usuarios, null);
			}
		});
		barraDeHerramientas.setLayout(new GridLayout(0, 7, 0, 0));
		btnUsuario.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Imagenes/Uasuarios.png")));
		barraDeHerramientas.add(btnUsuario);
		
		btnEmpleado = new JButton("");
		btnEmpleado.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Imagenes/Empleados2.png")));
		btnEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMostrandose = 1;
				if(panelMostrandose != 1 || panelMostrandose == 1)
				{
					
				}
			}
		});
		barraDeHerramientas.add(btnEmpleado);
		
		btnCliente = new JButton("");
		btnCliente.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Imagenes/Clientes2.png")));
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				PanelClientes panelClientes = new PanelClientes();				
				agregarPanelAlCentro("Clientes", panelClientes, null);	
			}
		});
		barraDeHerramientas.add(btnCliente);
		
		btnArticulo = new JButton("");
		btnArticulo.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Imagenes/Articulos.png")));
		barraDeHerramientas.add(btnArticulo);
	
		btnFactura = new JButton("");
		btnFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PanelFactura pf = new PanelFactura();
				agregarPanelAlCentro("Factura" , pf, null);
			}
		});
		btnFactura.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Imagenes/Factura.png")));
		barraDeHerramientas.add(btnFactura);
		
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
		barraDeHerramientas.add(btnDevolucion);
		
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
		barraDeHerramientas.add(btnInforme);
		
		panelCentro = new JTabbedPanePersonalized(JTabbedPane.TOP);
		frame.getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		/*
		panel = new JPanel();
		panel.setBackground(Color.RED);
		panelCentro.add(panel);*/
		
		//panelCentro.setVisible(true);
		
		btnArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					PanelArticulos articulo = new PanelArticulos();
					agregarPanelAlCentro("Articulo", articulo, null);
				
				
				
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
	
	
	private void agregarPanelAlCentro(String titulo, JPanel panel, CloseTabIcon icon) {
		panelCentro.addTab( titulo, panel);
		panelCentro.setSelectedIndex( panelCentro.getTabCount() - 1);
	}
	
}
