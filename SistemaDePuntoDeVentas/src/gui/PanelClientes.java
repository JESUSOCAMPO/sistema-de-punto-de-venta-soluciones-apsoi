package gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPasswordField;

import clases.conexionBD;

public class PanelClientes extends JPanel {
	private JTextField txtnombre;
	private JTextField txtdireccion;
	private JTextField txtapellido;
	private JTextField txtcedula;
	private JTextField txttelefono;
	private JTextField txtcodigoCliente;


	/**
	 * Create the panel.
	 */
	public PanelClientes() {
		setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][][]"));
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setToolTipText("Presione para registrar un nuevo Cliente");
		btnNuevo.setForeground(new Color(0, 128, 0));
		btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(btnNuevo, "flowx,cell 1 0");
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel, "cell 0 1,alignx trailing");
		
		txtnombre = new JTextField();
		txtnombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtnombre.setEnabled(false);
		add(txtnombre, "cell 1 1,growx");
		txtnombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_1, "cell 0 2,alignx trailing");
		
		txtapellido = new JTextField();
		txtapellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtapellido.setEnabled(false);
		add(txtapellido, "cell 1 2,growx");
		txtapellido.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Direcci\u00F3n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_2, "cell 0 3,alignx trailing");
		
		txtdireccion = new JTextField();
		txtdireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtdireccion.setEnabled(false);
		add(txtdireccion, "cell 1 3,growx");
		txtdireccion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("C\u00E9dula");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_3, "cell 0 4,alignx trailing");
		
		txtcedula = new JTextField();
		txtcedula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtcedula.setEnabled(false);
		add(txtcedula, "cell 1 4,growx");
		txtcedula.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tel\u00E9fono");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_4, "cell 0 5,alignx trailing");
		
		txttelefono = new JTextField();
		txttelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txttelefono.setEnabled(false);
		add(txttelefono, "cell 1 5,growx");
		txttelefono.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_5, "cell 0 6,alignx trailing");
		
		final JComboBox cbsexo = new JComboBox();
		cbsexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbsexo.setEnabled(false);
		add(cbsexo, "cell 1 6,growx");
		cbsexo.addItem("F");
		cbsexo.addItem("M");
		
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(btnAyuda, "cell 1 0");
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGuardar.setForeground(new Color(0, 0, 128));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			
				if(txtnombre.getText().equals("") || txtapellido.getText().equals("") || txtcedula.getText().equals("") || txtdireccion.getText().equals("") || txttelefono.getText().equals("") || txtcodigoCliente.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Debe ingresar todos los datos para poder guardar");
					return;
				}		
				try
				{
					conexionBD conexion = new conexionBD();
					Connection miConexion=(Connection) conexionBD.GetConnection();
					Statement statement=(Statement) miConexion.createStatement();
					statement.executeUpdate("insert into tbpersona values(null,'" + txtnombre.getText() + "','" + txtapellido.getText() + "','" + txtdireccion.getText() + "','" + txtcedula.getText() + "','" + txttelefono.getText() + "','" +  cbsexo.getSelectedItem() + "')", Statement.RETURN_GENERATED_KEYS);
					ResultSet conjuntoResultado =statement.getGeneratedKeys();
				    conjuntoResultado.next();
				    int idPersona = conjuntoResultado.getInt(1);
				    statement.executeUpdate(" insert into tbcliente values(null,'" + txtcodigoCliente.getText() + "'," + idPersona + ")");				
				    JOptionPane.showMessageDialog(null, "Datos guardados");
				} 
				catch (Exception ex)
				{
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, ex);
				}
		
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("C\u00F3digo del Cliente");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_6, "cell 0 7,alignx trailing");
		
		txtcodigoCliente = new JTextField();
		txtcodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtcodigoCliente.setEnabled(false);
		add(txtcodigoCliente, "cell 1 7,growx");
		txtcodigoCliente.setColumns(10);
		add(btnGuardar, "flowx,cell 1 8");
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCerrar.setForeground(new Color(255, 0, 0));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PanelClientes.this.setVisible(false);
				ventanaPrincipal vp = new ventanaPrincipal();
				vp.panelCentro.setVisible(true);
				
			}
		});
		add(btnCerrar, "cell 1 8");
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtnombre.setEnabled(true);
				txtapellido.setEnabled(true);
				txtdireccion.setEnabled(true);
				txtcedula.setEnabled(true);
				txttelefono.setEnabled(true);
				txtcodigoCliente.setEnabled(true);
				cbsexo.setEnabled(true);
				txtnombre.requestFocus();
				
			}
		});
		
		}

}
