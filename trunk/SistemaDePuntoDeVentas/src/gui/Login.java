package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPasswordField;

import clases.conexionBD;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.BaseDeDatos;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private BaseDeDatos bd = null;
	private ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuario.setForeground(new Color(0, 128, 0));
		lblUsuario.setBounds(175, 38, 76, 37);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblClave.setForeground(new Color(0, 128, 0));
		lblClave.setBounds(185, 86, 76, 17);
		contentPane.add(lblClave);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(261, 48, 163, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean resultado = false;
				ventanaPrincipal ventana = new ventanaPrincipal();
				ventana.main(null);
				 bd = new BaseDeDatos(); 
				/*
				String usuario =  txtUsuario.getText();
				String clave = new String(txtClave.getPassword());
				String sql = "SELECT * tbUsuario WHERE idUser='"+ usuario +"' AND claveUsuario='"+ clave +"';";
				//String sql = bd.seleccionarDatos("tbUsuario", "*", "idUser='"+ usuario +"' AND claveUsuario='"+ clave +"';");
				
				try {
					rs = bd.consultar(sql);
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
				try{
					
					while(rs.next())
					{
						resultado = true;
					}

					if(resultado)
					{
						ventanaPrincipal ventana = new ventanaPrincipal();
						ventana.show(true);
					}else
					{
						JOptionPane.showMessageDialog(null, "Usuario y COntrasenia NO Coinciden");
					}
					
				}catch(SQLException ex)
				{
					
				}
				*/
			}
			
			
		});
		btnEntrar.setBackground(new Color(0, 128, 0));
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnEntrar.setBounds(261, 136, 163, 37);
		contentPane.add(btnEntrar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/userlogin.png")));
		lblNewLabel.setBounds(0, 0, 257, 262);
		contentPane.add(lblNewLabel);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(261, 86, 163, 20);
		contentPane.add(txtClave);
	}
}
