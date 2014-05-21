package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import clases.Cliente;
import clases.Persona;
import clases.conexionBD;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaParaTraerLosDatosDelCliente extends JFrame {
        private JTable table;
        private JTextField txtBuscarCliente;
        private JComboBox comboBuscarPor;

        /**
         * Launch the application.
         */
        public static void main(String[] args) {
                EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        VentanaParaTraerLosDatosDelCliente frame = new VentanaParaTraerLosDatosDelCliente();
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
        public VentanaParaTraerLosDatosDelCliente() {
                addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowOpened(WindowEvent arg0) {
                        	
                        	Connection miConexion;
                    		try {
                    			 //Para establecer el modelo al JTable
                    			 DefaultTableModel modelo = new DefaultTableModel();
                    			 table.setModel(modelo);
                    			 //Para conectarnos a nuestra base de datos
                    			 miConexion=(Connection) conexionBD.GetConnection();
                    			 //Para ejecutar la consulta
                    			 Statement s = miConexion.createStatement();
                    			 //Ejecutamos la consulta que escribimos en la caja de texto
                    			 //y los datos lo almacenamos en un ResultSet
                    			 ResultSet rs = s.executeQuery("select c.codigoCliente as C�digo,concat(p.Nombre,' ',p.Apellido) as Nombre,p.Cedula from tbpersona p, tbcliente c where p.idPersona=c.idPersona");
                    			 //Obteniendo la informacion de las columnas que estan siendo consultadas
                    			 ResultSetMetaData rsMd = rs.getMetaData();
                    			 //La cantidad de columnas que tiene la consulta
                    			 int cantidadColumnas = rsMd.getColumnCount();
                    			 //Establecer como cabezeras el nombre de las colimnas
                    			 for (int i = 1; i <= cantidadColumnas; i++) {
                    			  modelo.addColumn(rsMd.getColumnLabel(i));
                    			 }
                    			 //Creando las filas para el JTable
                    			 while (rs.next()) {
                    			  Object[] fila = new Object[cantidadColumnas];
                    			  for (int i = 0; i < cantidadColumnas; i++) {
                    			    fila[i]=rs.getObject(i+1);
                    			  }
                    			  modelo.addRow(fila);
                    			 }
                    			 rs.close();
                    			 miConexion.close();
                    			} catch (Exception ex) {
                    			 ex.printStackTrace();
                    			}
                            
                                
                        }
                });
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setBounds(100, 100, 450, 300);
                getContentPane().setLayout(null);
                
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(0, 58, 434, 204);
                getContentPane().add(scrollPane);
                
                table = new JTable();
                table.addMouseListener(new MouseAdapter() {
                	@Override
                	public void mouseClicked(MouseEvent arg0) {

                	}
                });
                table.setModel(new DefaultTableModel(
                        new Object[][] {
                                {null, null, null},
                        },
                        new String[] {
                                "Codigo", "Nombre", "Cedula"
                        }
                ));
                scrollPane.setViewportView(table);
                
                txtBuscarCliente = new JTextField();
                txtBuscarCliente.setBounds(109, 23, 179, 20);
                getContentPane().add(txtBuscarCliente);
                txtBuscarCliente.setColumns(10);
                
                JButton btnBuscar = new JButton("Buscar");
                btnBuscar.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent arg0) {
                		
                		String condicionFiltro = comboBuscarPor.getSelectedItem().toString();
                		String condicionBusqueda = "";
                		
                		if(condicionFiltro.equals("Codigo"))
                			condicionBusqueda = "c.codigoCliente";
                		else
                			if(condicionFiltro.equals("Nombre"))
                    			condicionBusqueda = "p.Nombre";
                			else
                				if(condicionFiltro.equals("Cedula"))
                        			condicionBusqueda = "p.Cedula";
                			
                	
                		Connection miConexion;
                		try {

                			 DefaultTableModel modelo = new DefaultTableModel();
                			 table.setModel(modelo);
                			 miConexion=(Connection) conexionBD.GetConnection();

                			 Statement s = miConexion.createStatement();
                			 ResultSet rs = s.executeQuery("select c.codigoCliente as C�digo,concat(p.Nombre,' ',p.Apellido) as Nombre,p.Cedula from tbpersona p, tbcliente c where p.idPersona=c.idPersona and "+ condicionBusqueda +" like '%"+txtBuscarCliente.getText()+"%'");
                			 ResultSetMetaData rsMd = rs.getMetaData();
                			 int cantidadColumnas = rsMd.getColumnCount();
                			 for (int i = 1; i <= cantidadColumnas; i++) {
                			  modelo.addColumn(rsMd.getColumnLabel(i));
                			 }

                			 while (rs.next()) {
                			  Object[] fila = new Object[cantidadColumnas];
                			  for (int i = 0; i < cantidadColumnas; i++) {
                			    fila[i]=rs.getObject(i+1);
                			  }
                			  modelo.addRow(fila);
                			 }
                			 rs.close();
                			 miConexion.close();
                			} catch (Exception ex) {
                			 ex.printStackTrace();
                			}
                	}
                });
                btnBuscar.setBounds(298, 22, 89, 23);
                getContentPane().add(btnBuscar);
                
                comboBuscarPor = new JComboBox();
                comboBuscarPor.setModel(new DefaultComboBoxModel(new String[] {"Codigo", "Nombre", "Cedula"}));
                comboBuscarPor.setBounds(26, 23, 73, 20);
                getContentPane().add(comboBuscarPor);
                
                centrar(this);
        }
        

public void centrar(Window ventana)
{
        Dimension tamanioPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Point centroPantalla = new Point(tamanioPantalla.width/2, tamanioPantalla.height/2);
        
        ventana.setLocation(centroPantalla.x - ventana.getWidth()/2, centroPantalla.y - ventana.getHeight()/2);
}
}


