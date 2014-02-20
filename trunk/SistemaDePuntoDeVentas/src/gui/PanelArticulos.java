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
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(10, 50, 430, 195);
		add(panel);
		panel.setLayout(new MigLayout("", "[69px][49px][4px][6px][4px][266px]", "[23px][21px][21px][21px][21px][23px]"));
		
		JLabel lblCodigo = new JLabel("Codigo");
		panel.add(lblCodigo, "cell 0 1,alignx right,aligny center");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		//codigo = Integer.parseInt(txtCodigo.getText());
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		panel.add(lblDescripcion, "cell 0 2,alignx left,aligny center");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCosto = new JLabel("Costo");
		panel.add(lblCosto, "cell 0 3,alignx right,aligny center");
		lblCosto.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblPrecio = new JLabel("Precio");
		panel.add(lblPrecio, "cell 0 4,alignx right,aligny center");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnGuardar = new Button("Guardar");
		panel.add(btnGuardar, "cell 1 5 3 1,alignx left,aligny top");
		btnGuardar.setForeground(new Color(0, 0, 139));
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnCerrar = new Button("Cerrar");
		panel.add(btnCerrar, "cell 5 5,alignx left,aligny top");
		btnCerrar.setForeground(new Color(255, 0, 0));
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnNuevo = new Button("Nuevo");
		panel.add(btnNuevo, "cell 1 0,alignx left,aligny top");
		btnNuevo.setForeground(new Color(0, 128, 0));
		btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnAyuda = new Button("Ayuda");
		panel.add(btnAyuda, "cell 3 0 3 1,alignx left,aligny top");
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
		
		txtCodigo = new JTextField();
		panel.add(txtCodigo, "cell 1 1 5 1,growx,aligny top");
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodigo.setColumns(10);
		txtCodigo.setEnabled(false);
		
		txtDescripcion = new JTextField();
		panel.add(txtDescripcion, "cell 1 2 5 1,growx,aligny top");
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDescripcion.setColumns(10);
		descripcion = txtDescripcion.getText();
		txtDescripcion.setEnabled(false);
		
		txtCosto = new JTextField();
		panel.add(txtCosto, "cell 1 3 5 1,growx,aligny top");
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
		
		txtPrecio = new JTextField();
		panel.add(txtPrecio, "cell 1 4 5 1,growx,aligny top");
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
	}
}
