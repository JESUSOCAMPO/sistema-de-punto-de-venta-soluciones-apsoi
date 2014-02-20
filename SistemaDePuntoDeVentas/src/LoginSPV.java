import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import org.hamcrest.SelfDescribing;

import java.awt.Dialog.ModalExclusionType;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


@SuppressWarnings({ "serial", "unused" })
public class LoginSPV extends JFrame 
{

	private JPanel contentPane;
	private JTextField txtTre;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSPV frame = new LoginSPV();
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
	public LoginSPV()
	{
		setAutoRequestFocus(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Domingo A. Garcia\\Desktop\\usuarios\\usuario.jpg"));
		setResizable(false);
		setTitle("Autentificacion de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("Escriba el nombre del usuario");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(63, 46, 76, 14);
		contentPane.add(label);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		
		lblUsuario.setBounds(78, 46, 46, 14);
		contentPane.add(lblUsuario);
		
		txtTre = new JTextField();
		txtTre.setToolTipText("Escriba el nombre del Usuario");
		txtTre.setBounds(149, 43, 86, 20);
		contentPane.add(txtTre);
		txtTre.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("CLAVE");
		lblContrasenia.setBounds(78, 89, 46, 14);
		contentPane.add(lblContrasenia);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setToolTipText("Escriba la contrasenia");
		passwordField.setBounds(149, 86, 86, 20);
		contentPane.add(passwordField);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(null);
		btnAceptar.setBounds(78, 136, 92, 28);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(191, 136, 92, 27);
		contentPane.add(btnCancelar);
		
		ActionListener escuchadorbtnAceptar = new ActionListener() 
		{
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
			
				try
				{
					if(txtTre.getText().length()  > 0 && passwordField.getPassword().hashCode()> 0)
					{
						// el if para validar el usuario 
						if(ValidarUsuario( txtTre.getText(),passwordField.getPassword()) )
						{
							//crear el el aceso a la bnetana prinsipal
							// setVisible(true);
							//VentanaPrincipal ventana = new VentanaPrincipal();
							//ventana.mostrar();
							
							
						}
						
						else
						{
							JOptionPane.showMessageDialog(null,"El nombre de usuario y/o contrasenia no son validos.");
							//JOptionPane.showMessageDialog(null,txtTre.getText()+""+passwordField.getPassword());
							//limpia los campos
							txtTre.setText("");
							passwordField.setText("");
							
							txtTre.requestFocusInWindow();
							
							//crear el el aceso a la bnetana prinsipal
							
							setVisible(false);
							//VentanaPrincipal ventana = new VentanaPrincipal();
							//ventana.mostrar();
							//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
							
							
							
						}
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "NO puede dejar ningun campo vacio");
								
						
					}
						
				} catch(Exception SPV)
				{
					SPV.printStackTrace();
				}
				
			}

		};
		//Escucha el boton Aceptar
		btnAceptar.addActionListener(escuchadorbtnAceptar);
		
		//Agregando el escuchador del boton cancelar
		ActionListener escuchadorbtnCancelar = new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// Terminar Proceso
				System.exit(0);
				
				
			}
		};
		//Escuchador del boton Cancelar
		btnCancelar.addActionListener(escuchadorbtnCancelar);
	}
	
	private boolean ValidarUsuario(String text, char[] cs) {
		// TODO Auto-generated method stub
		return false;
	}
	
	 /// A qui sera colocada la base de datos para validar los Usuarios
	/** try
	 {    // para poner la direcion donde esta la base de datos
		 Connection Conexion = DriverManager.getConnection(getName());
		 
		 Statement instruccionSQL = Conexion.createStatement();
		 // a qui se colocara la consulta sql
		 ResultSet consultas = instruccionSQL.executeQuery(getName());
		 
		 if(consultas.first() )
		       return true;
			else
		      return false;
	 	 
		 
		 
	 }
	 catch (Exception SPV)
	 {
		 SPV.printStackTrace();
		 return false;
	 }*/
	}

