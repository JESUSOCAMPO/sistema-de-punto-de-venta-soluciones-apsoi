package gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import clases.Articulo;
import clases.conexionBD;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JTable;

import java.awt.Button;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class PanelArticulos extends JPanel {
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JTextField txtCosto;
	private JTextField txtPrecio;
	static String codigo;
	static double costo;
	static double precio;
	static String descripcion;
	private Button btnGuardar;
	private Button btnCerrar;
	private Button btnNuevo;
	private Button btnAyuda;

	/**
	 * Create the panel.
	 */
	public PanelArticulos() {
		setLayout(new MigLayout("", "[59px][][][10px][6px][][11px][29px][][][306px]", "[24px][21px][24px][21px][21px][23px][]"));
		
		btnNuevo = new Button("Nuevo");
		add(btnNuevo, "cell 8 0,alignx right,aligny top");
		btnNuevo.setForeground(new Color(0, 128, 0));
		btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		//precio = Double.parseDouble(txtPrecio.getText());
		
		btnNuevo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtCodigo.setEnabled(true);
				txtDescripcion.setEnabled(true);
				txtCosto.setEnabled(true);
				txtPrecio.setEnabled(true);
				txtCodigo.requestFocus();			
				
			}
		});
		
		btnAyuda = new Button("Ayuda");
		add(btnAyuda, "cell 9 0,alignx left,aligny bottom");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			  try 
			  {
	 	            Runtime obj = Runtime.getRuntime();
	  	            obj.exec("notepad "+System.getProperty("user.dir")+"\\Registro de Articulos.txt");
			  } 
			  catch (IOException ex) 
			  {
	  	             System.out.println("IOException "+ex.getMessage());
	          }

			}
		});
		btnAyuda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblCodigo = new JLabel("Codigo");
		add(lblCodigo, "cell 1 1,alignx right,aligny center");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtCodigo = new JTextField();
		add(txtCodigo, "cell 3 1 8 1,growx,aligny top");
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodigo.setColumns(10);
		txtCodigo.setEnabled(false);
		
		//codigo = Integer.parseInt(txtCodigo.getText());
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		add(lblDescripcion, "cell 0 2 2 1,alignx right,aligny center");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtDescripcion = new JTextField();
		add(txtDescripcion, "cell 3 2 8 1,growx,aligny bottom");
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDescripcion.setColumns(10);
		descripcion = txtDescripcion.getText();
		txtDescripcion.setEnabled(false);
		
		JLabel lblCosto = new JLabel("Costo");
		add(lblCosto, "cell 1 3,alignx right,aligny center");
		lblCosto.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtCosto = new JTextField();
		add(txtCosto, "cell 3 3 8 1,growx,aligny top");
		txtCosto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				int letra = (int) e.getKeyChar(); 
				if (letra >= 97 && letra <= 122 || letra >= 65 && letra <= 90) 
				{ 
					e.consume();
					JOptionPane.showMessageDialog(null, "No puede ingresar Letras", "Error Datos", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		txtCosto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCosto.setColumns(10);
		//costo =Double.parseDouble(txtCosto.getText());
		txtCosto.setEnabled(false);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setVerticalAlignment(SwingConstants.BOTTOM);
		add(lblPrecio, "cell 1 4,alignx right,aligny center");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtPrecio = new JTextField();
		add(txtPrecio, "cell 3 4 8 1,growx,aligny top");
		txtPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				int letra = (int) e.getKeyChar(); 
				if (letra >= 97 && letra <= 122 || letra >= 65 && letra <= 90) 
				{ 
					e.consume();
					JOptionPane.showMessageDialog(null, "No puede ingresar Letras", "Error Datos", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPrecio.setColumns(10);
		txtPrecio.setEnabled(false);
		
		btnGuardar = new Button("Guardar");
		add(btnGuardar, "cell 8 5,alignx left,aligny top");
		btnGuardar.setForeground(new Color(0, 0, 139));
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				conexionBD conexion = new conexionBD();
				Articulo a = new Articulo();
				
				if(txtCodigo.getText().equals("") || txtDescripcion.getText().equals("") || txtCosto.getText().equals("") || txtPrecio.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos para guardar");
					return;
				}
				try{/*
					codigo = txtCodigo.toString();
					descripcion = txtDescripcion.toString();
					costo = Double.parseDouble(txtCosto.toString());
					precio = Double.parseDouble(txtPrecio.toString());*/
					
					//a.seleccionarDatos("tbarticulo", "codigoArticulo", "codigoArticulo='" + txtCodigo.getText() +"'");
					/*if(a.getCodigoArticulo()!="")
					{*/
						conexion.insertarDatos("tbarticulo", "'" + txtCodigo.getText() + "','" + txtDescripcion.getText() + "'," + txtCosto.getText() + "," + txtPrecio.getText());
						JOptionPane.showMessageDialog(null, "Datos guardados");
					/*}else{
						JOptionPane.showMessageDialog(null, "El articulo ya existe, debe ingresar un nuevo articulo");
						return;
					}*/
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, ex);
				}
				//Articulo a = new Articulo(codigo,costo,precio,descripcion);
				//a.guardarDatosBD();
				//JOptionPane.showMessageDialog(null, "no retorno");
			}
		});
		
		btnCerrar = new Button("Cerrar");
		add(btnCerrar, "cell 9 5,alignx left,aligny top");
		btnCerrar.setForeground(new Color(255, 0, 0));
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnCerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PanelArticulos.this.setVisible(false);
				ventanaPrincipal vp = new ventanaPrincipal();
				vp.panelCentro.setVisible(true);
				/*
				Articulo a = new Articulo();
				try {
					a.seleccionarDatos("tbarticulo", "*", "codigoArticulo='096213'");
					//JOptionPane.showMessageDialog(null, "prueba");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txtCodigo.setText(a.getCodigoArticulo());
				//JOptionPane.showMessageDialog(null, "prueba1");
				txtDescripcion.setText(a.getDescripcionArticulo());/*
				txtCosto.setText(a.getCostoArticulo());
				txtPrecio.setText(a.getPrecioArticulo());*/
			}
		});
	}
}
