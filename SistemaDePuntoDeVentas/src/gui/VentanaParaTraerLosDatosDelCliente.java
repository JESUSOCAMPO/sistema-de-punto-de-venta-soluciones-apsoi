package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import clases.Cliente;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class VentanaParaTraerLosDatosDelCliente extends JFrame {
	private JTable table;
	private JTextField txtBuscarCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaParaTraerLosDatosDelCliente frame = new VentanaParaTraerLosDatosDelCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaParaTraerLosDatosDelCliente() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				//JOptionPane.showMessageDialog(null, "Lo que sea");
				Cliente cliente = new Cliente();
 				try
 				{
 					//if(!cliente.seleccionarDatos("tbpersona p, tbcliente c", "c.codigoCliente,concat(p.Nombre,' ',p.Apellido),p.Cedula", "p.idPerona=c.idPersona"))
 						//JOptionPane.showMessageDialog(null, "No hay clientes registrados");
 					//else
 					{
 						cliente.seleccionarDatos("tbpersona p, tbcliente c", "c.codigoCliente,concat(p.Nombre,' ',p.Apellido) as nombre,p.Cedula", "p.idPerona=c.idPersona");
 						for(int i =0; i < table.getRowCount(); i++)
 						{
 							table.setValueAt(cliente.getNombre() + " " + cliente.getApellido(), table.getSelectedRow(), 2);
 							
 						}
 					}
 				}
 				catch (SQLException e) 
 				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 58, 434, 204);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Codigo", "Nombre", "Cedula"
			}
		));
		scrollPane.setViewportView(table);
		
		txtBuscarCliente = new JTextField();
		txtBuscarCliente.setBounds(109, 23, 179, 20);
		getContentPane().add(txtBuscarCliente);
		txtBuscarCliente.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(298, 22, 89, 23);
		getContentPane().add(btnBuscar);
		
		JComboBox comboBuscarPor = new JComboBox();
		comboBuscarPor.setModel(new DefaultComboBoxModel(new String[] {"Codigo", "Nombre", "Cedula"}));
		comboBuscarPor.setBounds(26, 23, 73, 20);
		getContentPane().add(comboBuscarPor);
		
		centrar(this);
	}
	

public void centrar(Window ventana)
{
	Dimension tamanioPantalla = Toolkit.getDefaultToolkit().getScreenSize();
	Point centroPantalla = new Point(tamanioPantalla.width/2, tamanioPantalla.height/2);
	
	ventana.setLocation(centroPantalla.x - ventana.getWidth()/2, centroPantalla.y - ventana.getHeight()/2);
}
}
