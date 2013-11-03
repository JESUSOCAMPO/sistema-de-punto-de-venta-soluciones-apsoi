import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;



import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;


public class Login extends JFrame 
{
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnAceptar, btnCancelar;
	

	public Login() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Domingo A. Garcia\\Desktop\\usuarios\\usuario.jpg"));
		setTitle("Regristrar Usuario");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setToolTipText("Escriba su nombre de usuario");  
		lblNewLabel.setBounds(10, 11, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setToolTipText("Escriba su contrasenia");  
		lblNewLabel_1.setBounds(10, 47, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(66, 8, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(66, 41, 86, 20);
		getContentPane().add(passwordField);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(10, 91, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(109, 91, 89, 23);
		getContentPane().add(btnCancelar);
		
		 ActionListener pursarbtnAceptar = new ActionListener()
	        {
	            public void actionPerformed(ActionEvent evt)
	            {
	                try
	                {                    
	                    //campo para escribir la passwor y el usuario
	                    if (textField.getText().length() > 0 && textField.getText().length() > 0 )
	                    {
	                       
	 
	                    }
	                    else
	                    {
	                        JOptionPane.showMessageDialog(null, "Debe escribir nombre de usuario y contrasenia.\n" +
	                            "NO puede dejar ningun campo vacio");
	                    }
	 
	                } 
	                catch (Exception e)
	                {
	                    e.printStackTrace();
	                }
	                 
	            }
	        };
	        
	        btnAceptar.addActionListener(pursarbtnAceptar);  

	}
	
	 public static void main(String[] args)
	    {
		    Login user = new Login();
	        user.setDefaultCloseOperation(user.EXIT_ON_CLOSE);
	    } 
}


