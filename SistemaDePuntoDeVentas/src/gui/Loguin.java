package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

//import net.miginfocom.swing.MigLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import clases.BaseDeDatos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Loguin {

	private JFrame frame;
	private JTextField textUsuario;
	private JPasswordField passClave;
	private BaseDeDatos bd = null;
	private ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loguin window = new Loguin();
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
	public Loguin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsuario = new JLabel("Usuario");
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave");
		
		passClave = new JPasswordField();
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean respuesta = false;
				bd = new BaseDeDatos();
				String usuario = textUsuario.getText();
				String clave = new String(passClave.getPassword());
				String sql = "SELECT * FROM tblUsuario WHERE idUser= '" +usuario +"'"+"ADN claveUsuario='"+clave+"'"; 
				
					try {
						
						rs = bd.consultar(sql);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				try
				{
					while(rs.next()) 
					{
						respuesta = true;
					}
					if(respuesta)
					{
						ventanaPrincipal nueva = new ventanaPrincipal();
						nueva.main(null);
					}
					else{
						JOptionPane.showMessageDialog(null, "Usuario y Contrasenia No Coinciden");
					}
				}
				catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(null, "No se conecto");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "No se conecto nada");
				}
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblClave))
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passClave)
								.addComponent(textUsuario)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(76)
							.addComponent(btnAceptar)))
					.addContainerGap(217, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblClave)
						.addComponent(passClave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addComponent(btnAceptar)
					.addContainerGap(71, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
