package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JWindow;

import clases.conexionBD;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.ComponentOrientation;
import javax.swing.DropMode;

import clases.conexionBD;

import java.awt.TextArea;

public class Login2 extends JWindow {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private conexionBD bd = null;
	private ResultSet rs = null;
	private JButton btnEntrar;
	private JButton btnCancelar;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaPrincipal prueba = new ventanaPrincipal();
					Login2 window = new Login2(prueba);
					
					
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login2(ventanaPrincipal ventanaPadre) {
		super();
		//setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsuario.setBounds(45, 55, 75, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblClave.setBounds(68, 95, 75, 14);
		contentPane.add(lblClave);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(148, 55, 201, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(148, 95, 201, 20);
		contentPane.add(txtClave);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean datosValidados = false;
						
				
				bd = new conexionBD();
				String usuario = txtUsuario.getText();
				String clave = new String(txtClave.getPassword());
				String sql = "SELECT * FROM login WHERE usuario = '" + usuario + "' AND clave = '" + clave + "'" ;
				rs = bd.consultar(sql);
				try{
					while(rs.next())
					{
						datosValidados = true;
												
					}
					if(datosValidados)
					{
					  ventanaPrincipal ventana = new ventanaPrincipal();	
			//TODO:		  ventana.setVisible(true);
					  Login2.this.dispose();
					  
					}else{
						txtUsuario.setText("");
						txtClave.setText("");
						JOptionPane.showMessageDialog(null, "Usuario y/o Clave Incorrectas", null, JOptionPane.ERROR_MESSAGE);
					}
				}catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(null, "No se logro la conexion", null, JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "No se logro la conexion", null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEntrar.setBounds(127, 146, 124, 45);
		contentPane.add(btnEntrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Login2.this.dispose();
			System.out.println(Login2.this.isFocusable());
			Login2.this.setFocusable(true);
			mostrarStatus();
				
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelar.setBounds(272, 146, 124, 45);
		contentPane.add(btnCancelar);
		//TODO  Agregar la etiqueta Imagen de fondo
		/*JLabel etiquetaImagenDeFondo = new JLabel("New label");
		etiquetaImagenDeFondo.setIcon(new ImageIcon(Login2.class.getResource("/Imagenes/key.png")));
		etiquetaImagenDeFondo.setBounds(192, 11, 235, 259);
		contentPane.add(etiquetaImagenDeFondo);*/
		
		centrar(this);
		//this.setComponentZOrder(etiquetaImagenDeFondo, 0);
	}
	
	public void centrar(Window ventana)
	{
		Dimension tamanioPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Point centroPantalla = new Point(tamanioPantalla.width/2, tamanioPantalla.height/2);
		
		ventana.setLocation(centroPantalla.x - ventana.getWidth()/2, centroPantalla.y - ventana.getHeight()/2);
		
	}
	
	public void mostrarStatus()
	{
		System.out.println("Clave :"+txtClave.isFocusable() + " Usuario:" + txtUsuario.isFocusable() );
		System.out.println("Boton Enter: " + btnEntrar.isFocusable() + "Boton Cancelar: " + btnCancelar.isFocusable());
	}
}
