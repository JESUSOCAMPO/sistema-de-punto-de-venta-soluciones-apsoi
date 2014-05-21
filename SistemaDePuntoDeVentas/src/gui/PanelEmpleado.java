package gui;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.miginfocom.swing.MigLayout;

import javax.swing.ComboBoxEditor;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clases.conexionBD;
import clases.Empleado;

import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelEmpleado extends JPanel {
        private JTextField txtnombre;
        private JTextField txtapellido;
        private JTextField txtdireccion;
        private JTextField txtcedula;
        private JTextField txttelefono;
        private JTextField txtcodigoEmpleado;
        private JTextField txtsueldoEmpleado;
        private JComboBox comBoxEmpleado;
        private JTextArea txtAyuda;


        /**
         * Create the panel.
         */
        public PanelEmpleado() {
setLayout(new MigLayout("", "[67px][67px,grow][][]", "[23px][][][][][][][][][][][grow]"));
                
				txtAyuda = new JTextArea();
				txtAyuda.setFont(new Font("Tahoma", Font.PLAIN, 16));
				add(txtAyuda, "cell 1 11,grow");
				txtAyuda.setVisible(false);
				
                JButton btnAyuda = new JButton("Ayuda");
                btnAyuda.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent arg0) {
                		
                		txtAyuda.setText("En esta sección puede registrar los datos de los empleados. Para esto siga los siguientes pasos: \n1.Click a nuevo \n2.Digite todos los datos solicitados por el sistema \n3.Click a guardar \nNota: Solo puede registrar empleados que no hayan sido registrados con anterioridad.\nNo se permite modificar los datos ya guardados.");
        				txtAyuda.setVisible(true);
                	}
                });
                btnAyuda.setFont(new Font("Tahoma", Font.PLAIN, 12));
                add(btnAyuda, "flowx,cell 1 0 2 1,alignx left,aligny top");
                
                JButton btnNuevo = new JButton("Nuevo");
                btnNuevo.setToolTipText("Presione para registrar un nuevo Empleado");
                btnNuevo.setForeground(new Color(0, 128, 0));
                btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 12));
                add(btnNuevo, "cell 1 0 2 1,alignx left,aligny top");
                
                JLabel label = new JLabel("Nombre");
                label.setFont(new Font("Tahoma", Font.BOLD, 12));
                add(label, "cell 0 1,alignx trailing");
                
                txtnombre = new JTextField();
                txtnombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
                txtnombre.setEnabled(false);
                add(txtnombre, "cell 1 1,growx");
                
                JLabel label_1 = new JLabel("Apellido");
                label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
                add(label_1, "cell 0 2,alignx trailing");
                
                txtapellido = new JTextField();
                txtapellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
                txtapellido.setEnabled(false);
                txtapellido.setColumns(10);
                add(txtapellido, "cell 1 2,growx");
                
                JLabel label_2 = new JLabel("Direcci\u00F3n");
                label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
                add(label_2, "cell 0 3,alignx trailing");
                
                txtdireccion = new JTextField();
                txtdireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
                txtdireccion.setEnabled(false);
                txtdireccion.setColumns(10);
                add(txtdireccion, "cell 1 3,growx");
                
                JLabel label_3 = new JLabel("C\u00E9dula");
                label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
                add(label_3, "cell 0 4,alignx trailing");
                
                txtcedula = new JTextField();
                txtcedula.setFont(new Font("Tahoma", Font.PLAIN, 12));
                txtcedula.setEnabled(false);
                txtcedula.setColumns(10);
                add(txtcedula, "cell 1 4,growx");
                
                JLabel label_4 = new JLabel("Tel\u00E9fono");
                label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
                add(label_4, "cell 0 5,alignx trailing");
                
                txttelefono = new JTextField();
                txttelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
                txttelefono.setEnabled(false);
                txttelefono.setColumns(10);
                add(txttelefono, "cell 1 5,growx");
                
                JLabel label_5 = new JLabel("Sexo");
                label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
                add(label_5, "cell 0 6,alignx trailing");
                
                final JComboBox cboxsexo = new JComboBox();
                cboxsexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
                cboxsexo.setEnabled(false);
                add(cboxsexo, "cell 1 6,growx");
                cboxsexo.addItem("F");
                cboxsexo.addItem("M");
                
                JLabel label_6 = new JLabel("C\u00F3digo del Empleado");
                label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
                add(label_6, "cell 0 7,alignx trailing");
                
                txtcodigoEmpleado = new JTextField();
                txtcodigoEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 12));
                txtcodigoEmpleado.setEnabled(false);
                txtcodigoEmpleado.setColumns(10);
                add(txtcodigoEmpleado, "cell 1 7,growx");
                
                JLabel label_7 = new JLabel("Cargo del Empleado");
                label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
                add(label_7, "cell 0 8,alignx trailing");
                
                comBoxEmpleado = new JComboBox();
                comBoxEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 12));
                comBoxEmpleado.setEnabled(false);
                add(comBoxEmpleado, "cell 1 8,growx");
                comBoxEmpleado.addItem("Supervisor");
                comBoxEmpleado.addItem("Administrador");
                comBoxEmpleado.addItem("Digitador");
                comBoxEmpleado.addItem("Cajero");
                
                
                JLabel label_8 = new JLabel("Sueldo del Empleado");
                label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
                add(label_8, "cell 0 9,alignx trailing");
                
                txtsueldoEmpleado = new JTextField();
                txtsueldoEmpleado.addKeyListener(new KeyAdapter() {
                	@Override
                	public void keyTyped(KeyEvent e) {
                		
                		int letra = (int) e.getKeyChar(); 
        				if (letra >= 97 && letra <= 122 || letra >= 65 && letra <= 90) 
        				{ 
        					e.consume();
        					JOptionPane.showMessageDialog(null, "No puede ingresar Letras", "Error Datos", JOptionPane.ERROR_MESSAGE);
        				}
                	}
                });
                txtsueldoEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 12));
                txtsueldoEmpleado.setEnabled(false);
                txtsueldoEmpleado.setColumns(10);
                add(txtsueldoEmpleado, "cell 1 9,growx");
                
                JButton btnGuardar = new JButton("Guardar");
                btnGuardar.setForeground(new Color(0, 0, 128));
                btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
                add(btnGuardar, "flowx,cell 1 10");
                
                
                btnGuardar.addActionListener(new ActionListener()                   
                {
                        public void actionPerformed(ActionEvent e) {    
                      
                        	String cedula_empleado="";
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
            		 				   cedula_empleado = consulta.getString(columna1);
            		 			   
            				} catch (SQLException e1) {
            					e1.printStackTrace();
            				}
                        	
                        if(txtnombre.getText().equals("") || txtapellido.getText().equals("") || txtcedula.getText().equals("") || txtdireccion.getText().equals("") || txttelefono.getText().equals("") || txtcodigoEmpleado.getText().equals(""))
                        {
                                JOptionPane.showMessageDialog(null,"Debe ingresar todos los datos para poder guardar");
                                return;
                        } 
                        
                        if(cedula_empleado.equals(txtcedula.getText()))
        				{
        					JOptionPane.showMessageDialog(null, "El empleado ya ha sido registrado. Registre un nuevo empleado");
        					return;
        				} 
        				else 
        				{
	                        try
	                        {
	                                miConexion=(Connection) conexionBD.GetConnection();
	                                statement=(Statement) miConexion.createStatement();
	                                statement.executeUpdate("insert into tbpersona values(null,'" + txtnombre.getText() + "','" + txtapellido.getText() + "','" + txtdireccion.getText() + "','" + txtcedula.getText() + "','" + txttelefono.getText() + "','" +  cboxsexo.getSelectedItem() + "')", Statement.RETURN_GENERATED_KEYS);
	                                ResultSet conjuntoResultado =statement.getGeneratedKeys();
	                            conjuntoResultado.next();
	                            int idPersona = conjuntoResultado.getInt(1);
	                            statement.executeUpdate(" insert into tbempleado values(null," + idPersona  + "," + txtsueldoEmpleado.getText()  + ",'" + comBoxEmpleado.getSelectedItem() +"')");                            
	                            JOptionPane.showMessageDialog(null, "Datos guardados");
	                                txtnombre.setText("");
	                                txtapellido.setText("");
	                                txtdireccion.setText("");
	                                txtcedula.setText("");
	                                txttelefono.setText("");
	                                txtcodigoEmpleado.setText("");
	                                txtsueldoEmpleado.setText("");
	                                
	                        } 
	                        catch (Exception ex)
	                        {
	                                ex.printStackTrace();
	                                JOptionPane.showMessageDialog(null, ex);
	                        }
        				}
	        
                }
        });     
        
        btnNuevo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                        txtnombre.setEnabled(true);
                        txtapellido.setEnabled(true);
                        txtdireccion.setEnabled(true);
                        txtcedula.setEnabled(true);
                        txttelefono.setEnabled(true);
                        txtcodigoEmpleado.setEnabled(true);
                
                        txtsueldoEmpleado.setEnabled(true);
                        cboxsexo.setEnabled(true);
                        comBoxEmpleado.setEnabled(true);
                        txtnombre.requestFocus();               
                        
                }
        });
        
        
        }}

