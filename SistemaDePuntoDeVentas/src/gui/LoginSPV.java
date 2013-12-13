package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ImageIcon;

//import clases.BaseDeDatos;
import clases.conexionBD;


@SuppressWarnings({ "serial", "unused" })
public class LoginSPV extends JFrame 
{
	

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtTre;
	private JPasswordField passwordField;
	private Connection conexion = null;
	//private BaseDeDatos bd = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		 ventanaPrincipal prueba = new ventanaPrincipal();
	   // prueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		//Dimension tamFrame=this.getSize();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Domingo A. Garcia\\Desktop\\usuarios\\usuario.jpg"));
		setResizable(false);
		setTitle("Autentificacion de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Dimension tamFrame = this.getSize();
		Dimension tamPantalla=Toolkit.getDefaultToolkit().getScreenSize(); 
		setLocation((tamPantalla.width-tamFrame.width)/2, (tamPantalla.height-tamFrame.height)/2);
		
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
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				boolean respuesta = false;
				//bd = new BaseDeDatos();
		//		String 
				
				
				
				
			/*
				try
				{
					if(txtTre.getText().length()  > 0 && passwordField.getPassword().hashCode()> 0)
					{
						// el if para validar el usuario 
						if(ValidarUsuario( txtTre.getText(), passwordField.getPassword() ) )
						{
							
							setVisible(false);
						    ventanaPrincipal ventana = new ventanaPrincipal();
							ventana.main(null);
							//crear el el aceso a la bnetana prinsipal
							//setVisible(false);
							//VentanaPrincipal  ventana = new VentanaPrincipal ();
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
							
							//Esto es de prueba para ver si funciona la ventana principal
							   // setVisible(false);
							   // Casa ventana = new Casa();
								//ventana.mostrar();
								//ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				*/	
			}
			
			
			//private boolean ValidarUsuario(String text, char[] password) {
				// TODO Auto-generated method stub
				//return false;
			//}
		};
		//Escucha el boton Aceptar
		btnAceptar.addActionListener(escuchadorbtnAceptar);
		
		//Agregando el escuchador del boton cancelar
		ActionListener escuchadorbtnCancelar = new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
			 //Terminar Proceso
			System.exit(0);
				
				
			}
		};
		//Escuchador del boton Cancelar
		btnCancelar.addActionListener(escuchadorbtnCancelar);
		   
	}
	
     private boolean ValidarUsuario(String id, char[] password ) throws IOException
	{
		try
		{/*
			 Class.forName("com.mysql.jdbc.Driver");
             String servidor = "jdbc:mysql://localhost/dbspvapsoi";
             String usuarioDB="root";
             String passwordDB="root";
             conexion = DriverManager.getConnection(servidor,usuarioDB,passwordDB);*/
         
			
            
			Connection miConexion=(Connection) conexionBD.GetConnection();
  		   Statement statement=(Statement)miConexion.createStatement();
  		    ResultSet consulta = ((java.sql.Statement) statement).executeQuery("select idUser, claveUsuario from tbusuario");
  		   String campos;
		//statement.execute("select " + campos + " from " + nombreTabla + " where " + condicion +";");
  		   
  		  // int columna1 = consulta.findColumn("idUsuario");
  		   int columna2 = consulta.findColumn("idUser");
  		   int columna4= consulta.findColumn("claveUsuario");

  		   boolean lleno = consulta.next();
  		   
  		   //while (lleno)
  		   //{
  		  //int id1 = consulta.getInt(columna1);
  		//   String nombre = consulta.getString(columna2);
  		 // int edad = consulta.getInt(columna3);
  		   
  		  // lleno = consulta.next(); //se verifica si hay otro registro
  		  
             //JOptionPane.showMessageDialog(null, "codigo: " + id + " nombre: " + nombre + " tarifa: " + edad);
  		  }catch (Exception SPV)
          
  		{
          SPV.printStackTrace();
          return false;
  		   

  		  
			
			
			
		}
		return false;
		
		
	}
		
    }
        
	//return false;
		// TODO Auto-generated method stub

		/**try
		{
			
			
			
			
		}catch (Exception SPV)
        {
            SPV.printStackTrace();
            
        }
		return false;*/



