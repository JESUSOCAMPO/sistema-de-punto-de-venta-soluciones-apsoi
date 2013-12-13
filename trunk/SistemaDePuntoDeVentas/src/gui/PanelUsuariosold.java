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

import javax.swing.JPasswordField;

public class PanelUsuariosold extends JPanel {
	private JTextField txtnombre;
	private JTextField txtdireccion;
	private JTextField txtapellido;
	private JTextField txtcedula;
	private JTextField txttelefono;
	private JTextField txtidUsuario;
	private JPasswordField txtclave;
	private JPasswordField txtconfirmarClave;


	/**
	 * Create the panel.
	 */
	public PanelUsuariosold() {
		setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][][]"));
		
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
		cbtipoUsuario.addItem("");
		cbtipoUsuario.addItem("Administrador");
		cbtipoUsuario.addItem("Supervisor de Caja");
		cbtipoUsuario.addItem("Dijitador");
		cbtipoUsuario.addItem("Cajero");
		
		JButton btnAyuda = new JButton("Ayuda");
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
		
		txtclave = new JPasswordField();
		txtclave.setEnabled(false);
		add(txtclave, "cell 1 9,growx");
		
		JLabel lblNewLabel_9 = new JLabel("Confirmar Contrase\u00F1a");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_9, "cell 0 10,alignx trailing");
		
		txtconfirmarClave = new JPasswordField();
		txtconfirmarClave.setEnabled(false);
		add(txtconfirmarClave, "cell 1 10,growx");
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtclave.getPassword()!= txtconfirmarClave.getPassword())
				{
					JOptionPane.showMessageDialog(null, "La contraseña no coincide, vuelva a dijitarla" + txtclave.getPassword() + " " + txtconfirmarClave.getPassword());
					txtconfirmarClave.setText("");
					txtconfirmarClave.requestFocus();
					return;
				}
			}
		});
		add(btnGuardar, "flowx,cell 1 11");
		
		JButton btnCerrar = new JButton("Cerrar");
		add(btnCerrar, "cell 1 11");
		
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

}
