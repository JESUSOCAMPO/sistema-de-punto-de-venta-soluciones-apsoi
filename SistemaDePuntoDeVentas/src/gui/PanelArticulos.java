package gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

//import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import clases.Articulo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JTable;

import java.awt.Button;
import java.sql.SQLException;
import java.awt.Color;

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
	private Button btnModificar;

	/**
	 * Create the panel.
	 */
	public PanelArticulos() {
		//setLayout(new MigLayout("", "[][grow]", "[][][][][][grow][]"));
		
		btnNuevo = new Button("Nuevo");
		btnNuevo.setForeground(new Color(0, 128, 0));
		btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(btnNuevo, "flowx,cell 1 0");
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblCodigo, "cell 0 1,alignx trailing");
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodigo.setColumns(10);
		add(txtCodigo, "cell 1 1,growx");
		txtCodigo.setEnabled(false);
		
		//codigo = Integer.parseInt(txtCodigo.getText());
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblDescripcion, "cell 0 2,alignx trailing");
		
		txtDescripcion = new JTextField();
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDescripcion.setColumns(10);
		add(txtDescripcion, "cell 1 2,growx");
		descripcion = txtDescripcion.getText();
		txtDescripcion.setEnabled(false);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblCosto, "cell 0 3,alignx trailing");
		
		txtCosto = new JTextField();
		txtCosto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCosto.setColumns(10);
		add(txtCosto, "cell 1 3,growx");
		//costo =Double.parseDouble(txtCosto.getText());
		txtCosto.setEnabled(false);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblPrecio, "cell 0 4,alignx trailing");
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPrecio.setColumns(10);
		add(txtPrecio, "cell 1 4,growx");
		txtPrecio.setEnabled(false);
		
		btnGuardar = new Button("Guardar");
		btnGuardar.setForeground(new Color(0, 0, 139));
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(btnGuardar, "flowx,cell 1 6");
		
		btnCerrar = new Button("Cerrar");
		btnCerrar.setForeground(new Color(255, 0, 0));
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(btnCerrar, "cell 1 6");
		
		btnModificar = new Button("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(btnModificar, "cell 1 0");
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
		
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(txtCodigo.getText().equals("") || txtDescripcion.getText().equals("") || txtCosto.getText().equals("") || txtPrecio.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos para guardar");
					return;
				}
				try{
					codigo = txtCodigo.toString();
					descripcion = txtDescripcion.toString();
					costo = Double.parseDouble(txtCosto.toString());
					precio = Double.parseDouble(txtPrecio.toString());
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, ex);
				}
				Articulo a = new Articulo(codigo,costo,precio,descripcion);
				a.guardarDatosBD();
				
			}
		});
		
		btnCerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			/*	PanelArticulos.this.setVisible(false);
				ventanaPrincipal vp = new ventanaPrincipal();
				vp.panelCentro.setVisible(true);*/
				
				Articulo a = new Articulo();
				try {
					a.seleccionarDatos("tbarticulo", "*", "codigoArticulo='Albaro'");
					JOptionPane.showMessageDialog(null, "prueba");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txtCodigo.setText(a.getCodigoArticulo());
				JOptionPane.showMessageDialog(null, "prueba1");
				txtDescripcion.setText(a.getDescripcionArticulo());/*
				txtCosto.setText(a.getCostoArticulo());
				txtPrecio.setText(a.getPrecioArticulo());*/
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
