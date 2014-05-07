package gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

//import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

import clases.Cliente;
import clases.conexionBD;
import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ScrollPaneConstants;

public class PanelFactura extends JPanel {
	private JTextField txtnoFactura;
	private JTextField txtcodigoCliente;
	private JTextField txtnombreCliente;
	private JTextField txtdireccionCliente;
	private JTextField txttelefonoCliente;
	private JTextField txtnfc;
	private JComboBox cbcondicion;
	private JTextField txtPlazo;
	private JButton btnTraerDatos;
	final  JTable table;
	private JTextField txtTotal;
	
	

	/**
	 * Create the panel.
	 */
	public PanelFactura() {
		/*String[] columnas = { "Codigo","Cantidad","Descripcion","Precio","ITBIS","Valor"};
		Object[][] datos = {};*/
		Object[][] datos = {};
		//array de String's con los títulos de las columnas
		String[] columnNames = {"Codigo","Cantidad","Descripcion","Precio","ITBIS","Valor"};
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(7, 0, 932, 49);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtcodigoCliente.setEnabled(true);
				txtdireccionCliente.setEnabled(true);
				txtnfc.setEnabled(true);
				txtnoFactura.setEnabled(true);
				txtnombreCliente.setEnabled(true);
				txttelefonoCliente.setEnabled(true);
				cbcondicion.setEnabled(true);
				txtPlazo.setEnabled(true);
				txtnoFactura.setEnabled(true);
				btnTraerDatos.setEnabled(true);
				table.setEnabled(true);
				
			}
		});
		btnNuevo.setBounds(10, 11, 79, 23);
		btnNuevo.setForeground(new Color(0, 128, 0));
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(782, 14, 140, 14);
		
		Date fechaActual = new Date(); 
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
		String cadenaFecha = formato.format(fechaActual);
		lblFecha.setText(cadenaFecha);	
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(17, 60, 932, 179);
		panel_3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 49, 376, 90);
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		//table.addColumn(null);
		//JTable table = new 
		panel_1.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		JLabel lblNewLabel_2 = new JLabel("Condicion");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblNewLabel_2, "cell 0 0");
		
		 cbcondicion = new JComboBox();
		cbcondicion.setEnabled(false);
		panel_1.add(cbcondicion, "cell 1 0,growx");
		
		JLabel lblPlazo = new JLabel("Plazo");
		lblPlazo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblPlazo, "cell 0 1,alignx trailing");
		
		 txtPlazo = new JTextField();
		txtPlazo.setEnabled(false);
		panel_1.add(txtPlazo, "cell 1 1,growx");
		
		JLabel lblNcf = new JLabel("NCF");
		panel_1.add(lblNcf, "cell 0 2,alignx trailing");
		
		txtnfc = new JTextField();
		txtnfc.setEnabled(false);
		panel_1.add(txtnfc, "cell 1 2,growx");
		txtnfc.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(424, 25, 508, 108);
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
		
		JLabel label = new JLabel("Codigo");
		label.setForeground(new Color(160, 82, 45));
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(label, "cell 0 0,alignx trailing");
		
		txtcodigoCliente = new JTextField();
		txtcodigoCliente.setEnabled(false);
		txtcodigoCliente.setColumns(10);
		panel.add(txtcodigoCliente, "flowx,cell 1 0,growx");
		
		JLabel label_1 = new JLabel("Nombre");
		label_1.setForeground(new Color(160, 82, 45));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(label_1, "cell 0 1,alignx trailing");
		
		txtnombreCliente = new JTextField();
		txtnombreCliente.setEnabled(false);
		txtnombreCliente.setColumns(10);
		panel.add(txtnombreCliente, "cell 1 1,growx");
		
		JLabel label_2 = new JLabel("Direccion");
		label_2.setForeground(new Color(160, 82, 45));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(label_2, "cell 0 2,alignx trailing");
		
		txtdireccionCliente = new JTextField();
		txtdireccionCliente.setEnabled(false);
		txtdireccionCliente.setColumns(10);
		panel.add(txtdireccionCliente, "cell 1 2,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Telefono");
		lblNewLabel_1.setForeground(new Color(160, 82, 45));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNewLabel_1, "cell 0 3,alignx trailing");
		
		txttelefonoCliente = new JTextField();
		txttelefonoCliente.setEnabled(false);
		panel.add(txttelefonoCliente, "cell 1 3,growx");
		txttelefonoCliente.setColumns(10);
		
		JLabel lblDetalles = new JLabel("Detalles");
		lblDetalles.setBounds(17, 251, 42, 15);
		lblDetalles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		//se crea la Tabla
		  table = new JTable(datos, columnNames);
		  table.addKeyListener(new KeyAdapter() {
		  	@Override
		  	public void keyPressed(KeyEvent arg0) {
		  		
	 	          
		  	}
		  	@Override
		  	public void keyTyped(KeyEvent arg0) {
		
		  		 Connection miConexion=(Connection) conexionBD.GetConnection();
	 			  ResultSet consulta = null;
	 			   Statement statement = null;
	 			  int columna1=0, columna2=0, columna3=0, columna4=0;
	 				String id=null, descripcion=null;
					Double costo=0.0, precio=0.0;
		 			   boolean lleno;
				try {
					statement = (Statement) miConexion.createStatement();
					 consulta = statement.executeQuery("select codigoArticulo, nombreArticulo, costoArticulo, precioArticulo from tbarticulo where codigoArticulo='" + table.getValueAt(table.getSelectedRow() - 1, 0) +"';");
					 
					 columna1 = consulta.findColumn("codigoArticulo");
					 columna2 = consulta.findColumn("nombreArticulo");
			 		 columna3= consulta.findColumn("costoArticulo");
			 		 columna4 = consulta.findColumn("precioArticulo");
			 	
			 		lleno = consulta.next();
					 while (lleno){
			 			    id = consulta.getString(columna1);
			 			    descripcion = consulta.getString(columna2);
			 			    costo = consulta.getDouble(columna3);
			 			    precio = consulta.getDouble(columna4);
			 			   
			 			   lleno = consulta.next(); //se verifica si hay otro registro
					 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 			  
	 			   //statement.execute("select " + campos + " from " + nombreTabla + " where " + condicion +";");

	 			  
	 			   //table.setValueAt(id, 0, 1);
	 			   table.setValueAt(descripcion, table.getSelectedRow() - 1, 2);
	 			   table.setValueAt(precio, table.getSelectedRow() - 1, 3);
	 			  
	 			  /* codigoArticulo = id;
	 			   descripcionArticulo = descripcion;
	 			   costoArticulo = costo;
	 			   precioArticulo = precio;*/
	 			  
	 	           //JOptionPane.showMessageDialog(null, "codigo: " + id + " nombre: " + descripcion + " costo: " + costo);
	 			  
	 	           try {
					statement.close();
					 miConexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 	           
	 	          DefaultTableModel miTableModel = (DefaultTableModel) table.getModel();
	 	          Object nuevaFila[]= {"","",""}; 
	 	          miTableModel.addRow(nuevaFila);
	 	         
		  	}
		  });
		  table.addInputMethodListener(new InputMethodListener() {
		  	public void caretPositionChanged(InputMethodEvent arg0) {
		  	}
		  	public void inputMethodTextChanged(InputMethodEvent arg0) {
	 			  
		  		
		  	}
		  });
		 table.setModel(new DefaultTableModel(
		 	new Object[][] {
		 		{null, null, null, null, null, null},
		 		{null, null, null, null, null, null},
		 	},
		 	new String[] {
		 		"Codigo", "Cantidad", "Descripcion", "Precio", "ITBIS", "Valor"
		 	}
		 ) {
		 	boolean[] columnEditables = new boolean[] {
		 		true, true, false, false, false, false
		 	};
		 	public boolean isCellEditable(int row, int column) {
		 		return columnEditables[column];
		 	}
		 });
		 table.setEnabled(false);
		 table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		 
		 		JScrollPane scrollPane = new JScrollPane(table);
		 		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		 		scrollPane.setBounds(7, 277, 932, 121);
		 		setLayout(null);
		 		add(panel_2);
		 		panel_2.setLayout(null);
		 		panel_2.add(btnNuevo);
		 		panel_2.add(lblFecha);
		 		
		 		JButton btnCerrar = new JButton("Cerrar");
		 		btnCerrar.addActionListener(new ActionListener() {
		 			public void actionPerformed(ActionEvent arg0) {
		 				/*PanelFactura.this.setVisible(false);
		 				
		 				ventanaPrincipal vp = new ventanaPrincipal();
						vp.panelCentro.setVisible(true);*/
		 				//table.addRowSelectionInterval(3,6);
		 				table.add((Component) table.getModel(), 3);
		 			}
		 		});
		 		btnCerrar.setForeground(Color.RED);
		 		btnCerrar.setBounds(109, 11, 79, 23);
		 		panel_2.add(btnCerrar);
		 		add(panel_3);
		 		panel_3.setLayout(null);
		 		panel_3.add(panel);
		 		
		 		 btnTraerDatos = new JButton("Traer Datos");
		 		 btnTraerDatos.setEnabled(false);
		 		btnTraerDatos.addActionListener(new ActionListener() {
		 			public void actionPerformed(ActionEvent arg0) {
		 				
		 				VentanaParaTraerLosDatosDelCliente ventanaClientes = new VentanaParaTraerLosDatosDelCliente();
		 				ventanaClientes.show();
		 			
		 				/*
		 				Cliente cliente = new Cliente();
		 				try
		 				{
		 					if(!cliente.seleccionarDatos("tbpersona p, tbcliente c", "p.Nombre,p.Direccion,p.Telefono", "p.idPersona=c.idPersona and c.codigoCliente='" + txtcodigoCliente.getText() +"'"))
		 						JOptionPane.showMessageDialog(null, "El cliente no ha sido registrado");
		 					else
		 					{
		 						txtnombreCliente.setText(cliente.getNombre());
		 						txtdireccionCliente.setText(cliente.getDireccion());
		 						txttelefonoCliente.setText(cliente.getTelefono());
		 					}
		 				}
		 				catch (SQLException e) 
		 				{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
		 			}
		 		});
		 		btnTraerDatos.setToolTipText("Ingrese el codigo del cliente y presione para completar los datos");
		 		panel.add(btnTraerDatos, "cell 1 0");
		 		panel_3.add(panel_1);
		 		
		 		JLabel lblComentario = new JLabel("Comentario");
		 		lblComentario.setBounds(20, 148, 62, 15);
		 		panel_3.add(lblComentario);
		 		lblComentario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 		
		 		JTextArea txtcomentario = new JTextArea();
		 		txtcomentario.setBounds(92, 144, 814, 22);
		 		panel_3.add(txtcomentario);
		 		
		 		JLabel lblCliente = new JLabel("CLIENTE:");
		 		lblCliente.setBounds(424, 11, 53, 15);
		 		panel_3.add(lblCliente);
		 		lblCliente.setForeground(new Color(160, 82, 45));
		 		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		 		
		 		JLabel lblNewLabel = new JLabel("No. Factura");
		 		lblNewLabel.setBounds(10, 23, 69, 15);
		 		panel_3.add(lblNewLabel);
		 		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		 		
		 		txtnoFactura = new JTextField();
		 		txtnoFactura.setEnabled(false);
		 		txtnoFactura.setBounds(84, 18, 52, 20);
		 		panel_3.add(txtnoFactura);
		 		txtnoFactura.setColumns(10);
		 		add(lblDetalles);
		 		add(scrollPane);
		 		
		 		txtTotal = new JTextField();
		 		txtTotal.setBounds(834, 426, 86, 20);
		 		add(txtTotal);
		 		txtTotal.setColumns(10);
		 		

	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
