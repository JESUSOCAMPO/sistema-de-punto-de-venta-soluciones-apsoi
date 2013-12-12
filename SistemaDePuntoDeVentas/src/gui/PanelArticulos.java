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
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public PanelArticulos() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(43, 29, 377, 240);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(59, 44, 43, 15);
		panel.add(lblCodigo);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		//codigo = Integer.parseInt(txtCodigo.getText());
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(33, 69, 69, 15);
		panel.add(lblDescripcion);
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(66, 94, 36, 15);
		panel.add(lblCosto);
		lblCosto.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(65, 119, 37, 15);
		panel.add(lblPrecio);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(112, 38, 255, 21);
		panel.add(txtCodigo);
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodigo.setColumns(10);
		txtCodigo.setEnabled(false);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(112, 63, 255, 21);
		panel.add(txtDescripcion);
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDescripcion.setColumns(10);
		descripcion = txtDescripcion.getText();
		txtDescripcion.setEnabled(false);
		
		txtCosto = new JTextField();
		txtCosto.setBounds(112, 88, 255, 21);
		panel.add(txtCosto);
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
		txtPrecio.setBounds(112, 113, 255, 21);
		panel.add(txtPrecio);
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
		btnGuardar.setBounds(122, 159, 59, 23);
		panel.add(btnGuardar);
		btnGuardar.setForeground(new Color(0, 0, 139));
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnCerrar = new Button("Cerrar");
		btnCerrar.setBounds(187, 159, 49, 23);
		panel.add(btnCerrar);
		btnCerrar.setForeground(new Color(255, 0, 0));
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnNuevo = new Button("Nuevo");
		btnNuevo.setBounds(122, 10, 49, 23);
		panel.add(btnNuevo);
		btnNuevo.setForeground(new Color(0, 128, 0));
		btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnAyuda = new Button("Ayuda");
		btnAyuda.setBounds(175, 10, 47, 23);
		panel.add(btnAyuda);
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
	/*
	public static void main(String[] arg) 
    {
			
		Articulo a = new Articulo(45367, 76.85, 99.99, "bandeja");
		a.guardarDatosBD();
    }*/

}
