package gui;

import java.awt.Font;
import java.awt.RenderingHints.Key;

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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.JPasswordField;

import clases.conexionBD;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.TextField;

import javax.swing.JTextArea;

public class PanelUsuarios extends JPanel {
	private JTextField txtnombre;
	private JTextField txtdireccion;
	private JTextField txtapellido;
	private JTextField txtcedula;
	private JTextField txttelefono;
	private JTextField txtidUsuario;
	private JTextArea txtAyuda;

	/**
	 * Create the panel.
	 */
	public PanelUsuarios() {
		setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][][][grow]"));
		
		JButton btnNuevo = new JButton("Nuevo");
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
		
		JLabel lblNewLabel_6 = new JLabel("Tipo de Usuario");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_6, "cell 0 7,alignx trailing");
		
		final JComboBox cbtipoUsuario = new JComboBox();
		cbtipoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbtipoUsuario.setEnabled(false);
		add(cbtipoUsuario, "cell 1 7,growx");
		cbtipoUsuario.insertItemAt("Administrador",0);
		cbtipoUsuario.insertItemAt("Supervisor de Caja",1);
		cbtipoUsuario.insertItemAt("Dijitador",2);
		cbtipoUsuario.insertItemAt("Cajero",3);
		cbtipoUsuario.setSelectedIndex(3);
		
		txtAyuda = new JTextArea();
		txtAyuda.setText("Ayuda");
		txtAyuda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAyuda.setEditable(false);
		add(txtAyuda, "flowx,cell 1 12");
		txtAyuda.setVisible(false);
		
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtAyuda.setText("En esta sección puede registrar los datos de los usuarios del sistema. Para esto siga los siguientes pasos: \n1.Click a nuevo \n2.Digite todos los datos solicitados por el sistema \n3.Click a guardar \nNota: Solo puede registrar nuevos usuarios, no se permite modificar los datos ya guardados.");
				txtAyuda.setVisible(true);
			}
		});
		btnAyuda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(btnAyuda, "cell 1 0");
		
		JLabel lblNewLabel_7 = new JLabel("ID de Usuario");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_7, "cell 0 8,alignx trailing");
		
		txtidUsuario = new JTextField();
		txtidUsuario.setEnabled(false);
		add(txtidUsuario, "cell 1 8,growx");
		txtidUsuario.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Contrase\u00F1a");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_8, "cell 0 9,alignx trailing");
		
		final JPasswordField txtclave = new JPasswordField();
		//txtclave.setEchoChar('*');
		txtclave.setEnabled(false);
		add(txtclave, "cell 1 9, growx");
		
		JLabel lblNewLabel_9 = new JLabel("Confirmar Contrase\u00F1a");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_9, "cell 0 10,alignx trailing");
		
		final JPasswordField txtconfirmarClave = new JPasswordField();
		//txtclave.setEchoChar('*');
		txtconfirmarClave.setEnabled(false);
		add(txtconfirmarClave, "cell 1 10, growx");
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGuardar.setForeground(new Color(0, 0, 128));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				String cedula_usuario="";
				Connection miConexion;
				Statement statement;
				ResultSet consulta = null;
				try {
				
					miConexion=(Connection) conexionBD.GetConnection();
					statement=(Statement) miConexion.createStatement();
					consulta = statement.executeQuery("select Cedula from tbpersona where Cedula=" + txtcedula.getText() +";");
					int columna1 = consulta.findColumn("Cedula");

		 			   boolean lleno = consulta.next();

		 			   if(lleno)
		 				   cedula_usuario = consulta.getString(columna1);
		 			   
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(hayCamposVacios())
				{
					JOptionPane.showMessageDialog(null,"Debe ingresar todos los datos para poder guardar");
					return;
				}
				if(!validadorDeCedula(txtcedula.getText()))
				{
					JOptionPane.showMessageDialog(null, "La Cédula ingresada es Incorrecta, por favor vuelva a dijitarla");
					return;
				}				

				
				if( !sonIguales( txtclave.getPassword(), txtconfirmarClave.getPassword() ) ) 
				{
					JOptionPane.showMessageDialog(null, "La contraseña no coincide, vuelva a dijitarla" + txtclave.getText() + " " + txtconfirmarClave.getText());
					txtclave.setText("");
					txtconfirmarClave.setText("");
					txtclave.requestFocusInWindow();
					return;
				}
				
				if(cedula_usuario.equals(txtcedula.getText()))
				{
					JOptionPane.showMessageDialog(null, "El usuario ya ha sido registrado. Registre un nuevo usuario");
					return;
				} 
				else 
				{
					try
					{
						
						miConexion=(Connection) conexionBD.GetConnection();
						statement=(Statement) miConexion.createStatement();
						statement.executeUpdate("insert into tbpersona values(null,'" + txtnombre.getText() + "','" + txtapellido.getText() + "','" + txtdireccion.getText() + "','" + txtcedula.getText() + "','" + txttelefono.getText() + "','" + cbsexo.getSelectedItem() + "')", Statement.RETURN_GENERATED_KEYS);
						ResultSet conjuntoResultado =statement.getGeneratedKeys();
					    conjuntoResultado.next();
					    int idPersona = conjuntoResultado.getInt(1);
					    statement.executeUpdate(" insert into tbusuario values(null,'" + txtidUsuario.getText() + "'," + idPersona + ",'" + txtclave.getText() + "',0)");
					    JOptionPane.showMessageDialog(null, "Datos guardados");
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}
			}
		});
		add(btnGuardar, "flowx,cell 1 11");
		
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtnombre.setEnabled(true);
				txtapellido.setEnabled(true);
				txtdireccion.setEnabled(true);
				txtcedula.setEnabled(true);
				txttelefono.setEnabled(true);
				cbsexo.setEnabled(true);
				cbtipoUsuario.setEnabled(true);
				txtidUsuario.setEnabled(true);
				txtclave.setEnabled(true);
				txtconfirmarClave.setEnabled(true);
				txtnombre.requestFocus();
				
			}
		});
		
		}
	
	protected boolean sonIguales(char[] clave, char[] confirmacion) {
		/*boolean valorRetorno = true;
		
		if(clave.length == confirmacion.length)
		{
			for (int i = 0; i < clave.length; i++)
			{
				if(clave[i] != confirmacion[i])
				{
					valorRetorno = false;
					break;
				}				
			}
		}
		
		return valorRetorno;
		*/
		
		return new String(clave).equals( new String(confirmacion) );
		
	}

	//////////////////////////////////////////////////
	boolean validadorDeCedula(String ced) 
	{
		int suma = 0;
		int division = 0;
		int digito = 0;
		int mul = 0;
		String peso = "1212121212";
		
		if (ced == null || ced.length() != 11) 
			return false;
		
		for(int i = 0; i < 10; i++) 
		{
			mul = (ced.charAt(i)-'0') * (peso.charAt(i)-'0');
			
			while(mul > 0) 
			{
				suma += mul%10;
				mul /= 10;
			}
		}
		
		division = (suma / 10) * 10;
		
		if (division < suma) 
			division += 10;
		
		digito = division - suma;
		
		if (digito != ced.charAt(10) - '0') 
			return false;
		
		return true;
	}
	//////////////////////////////////////////////////

	private boolean hayCamposVacios() {
		return txtnombre.getText().equals("") || txtapellido.getText().equals("") || txtcedula.getText().equals("") || txtdireccion.getText().equals("") || txttelefono.getText().equals("");
	}
	
	
}
