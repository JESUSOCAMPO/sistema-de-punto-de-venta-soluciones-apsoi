package gui;

import javax.swing.JPanel;

//import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

public class PanelFactura extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	

	/**
	 * Create the panel.
	 */
	public PanelFactura() {
		/*String[] columnas = { "Codigo","Cantidad","Descripcion","Precio","ITBIS","Valor"};
		Object[][] datos = {};*/
		Object[][] datos = {};
		//array de String's con los títulos de las columnas
		String[] columnNames = {"Codigo","Cantidad","Descripcion","Precio","ITBIS","Valor"};
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(7, 0, 932, 49);
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.setBounds(10, 11, 79, 23);
		btnNewButton.setForeground(new Color(0, 0, 128));
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setBounds(827, 20, 52, 14);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(7, 61, 932, 203);
		panel_3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 49, 376, 84);
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		//table.addColumn(null);
		//JTable table = new 
		panel_1.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		JLabel lblNewLabel_2 = new JLabel("Condicion");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblNewLabel_2, "cell 0 0");
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox, "cell 1 0,growx");
		
		JLabel lblPlazo = new JLabel("Plazo");
		lblPlazo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblPlazo, "cell 0 1,alignx trailing");
		
		JComboBox comboBox_1 = new JComboBox();
		panel_1.add(comboBox_1, "cell 1 1,growx");
		
		JLabel lblNcf = new JLabel("NCF");
		panel_1.add(lblNcf, "cell 0 2,alignx trailing");
		
		textField_5 = new JTextField();
		panel_1.add(textField_5, "cell 1 2,growx");
		textField_5.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(424, 25, 508, 108);
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
		
		JLabel label = new JLabel("Codigo");
		label.setForeground(new Color(160, 82, 45));
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(label, "cell 0 0,alignx trailing");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel.add(textField_1, "cell 1 0,growx");
		
		JLabel label_1 = new JLabel("Nombre");
		label_1.setForeground(new Color(160, 82, 45));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(label_1, "cell 0 1,alignx trailing");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel.add(textField_2, "cell 1 1,growx");
		
		JLabel label_2 = new JLabel("Direccion");
		label_2.setForeground(new Color(160, 82, 45));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(label_2, "cell 0 2,alignx trailing");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel.add(textField_3, "cell 1 2,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Telefono");
		lblNewLabel_1.setForeground(new Color(160, 82, 45));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNewLabel_1, "cell 0 3,alignx trailing");
		
		textField_4 = new JTextField();
		panel.add(textField_4, "cell 1 3,growx");
		textField_4.setColumns(10);
		
		JLabel lblDetalles = new JLabel("Detalles");
		lblDetalles.setBounds(7, 275, 42, 15);
		lblDetalles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		//se crea la Tabla
		 final JTable table = new JTable(datos, columnNames);
		 table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		 
		 		JScrollPane scrollPane = new JScrollPane(table);
		 		scrollPane.setBounds(7, 301, 932, 308);
		 		setLayout(null);
		 		add(panel_2);
		 		panel_2.setLayout(null);
		 		panel_2.add(btnNewButton);
		 		panel_2.add(lblFecha);
		 		add(panel_3);
		 		panel_3.setLayout(null);
		 		panel_3.add(panel);
		 		panel_3.add(panel_1);
		 		
		 		JLabel lblComentario = new JLabel("Comentario");
		 		lblComentario.setBounds(36, 162, 62, 15);
		 		panel_3.add(lblComentario);
		 		lblComentario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 		
		 		JTextArea textArea = new JTextArea();
		 		textArea.setBounds(109, 144, 813, 48);
		 		panel_3.add(textArea);
		 		
		 		JLabel lblCliente = new JLabel("CLIENTE:");
		 		lblCliente.setBounds(424, 11, 53, 15);
		 		panel_3.add(lblCliente);
		 		lblCliente.setForeground(new Color(160, 82, 45));
		 		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		 		
		 		JLabel lblNewLabel = new JLabel("No. Factura");
		 		lblNewLabel.setBounds(10, 23, 69, 15);
		 		panel_3.add(lblNewLabel);
		 		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		 		
		 		textField = new JTextField();
		 		textField.setBounds(84, 18, 52, 20);
		 		panel_3.add(textField);
		 		textField.setColumns(10);
		 		add(lblDetalles);
		 		add(scrollPane);

	}
}
