package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BoxLayout;

import java.awt.Component;
import java.awt.Font;

import javax.swing.SwingConstants;
//import static biblioteca.FuncionesDeVentanas.*;


public class Ventas extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas frame = new Ventas();
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
	public Ventas() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Venta");
		setBounds(100, 100, 779, 541);
		getContentPane().setLayout(null);
		
		//quitarBotonEsquinaIzquierdaJInternalFrame(this);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel.setBounds(10, 0, 743, 39);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(109, 11, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNumeroFactura = new JLabel("Numero Factura");
		lblNumeroFactura.setBounds(10, 14, 97, 14);
		panel.add(lblNumeroFactura);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(207, 14, 86, 14);
		panel.add(lblUsuario);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(254, 11, 86, 20);
		panel.add(textField_1);
		
		JLabel lblterminalNo = new JLabel("Terminal No.");
		lblterminalNo.setBounds(352, 14, 86, 14);
		panel.add(lblterminalNo);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(427, 11, 37, 20);
		panel.add(textField_2);
		
		JLabel lblUltimaFactura = new JLabel("Ultima Factura");
		lblUltimaFactura.setBounds(476, 14, 91, 14);
		panel.add(lblUltimaFactura);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(565, 11, 86, 20);
		panel.add(textField_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_1.setBounds(10, 50, 349, 138);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFechas = new JLabel("Fecha");
		lblFechas.setBounds(70, 13, 39, 17);
		panel_1.add(lblFechas);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(113, 11, 63, 20);
		panel_1.add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(113, 34, 63, 20);
		panel_1.add(formattedTextField_1);
		
		JLabel lblNumeroDeCliente = new JLabel("Numero de Cliente");
		lblNumeroDeCliente.setBounds(6, 37, 113, 14);
		panel_1.add(lblNumeroDeCliente);
		
		JButton button = new JButton("...");
		button.setBounds(180, 33, 33, 23);
		panel_1.add(button);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setBounds(218, 34, 103, 20);
		panel_1.add(formattedTextField_2);
		
		JLabel lblRnccedula = new JLabel("RNC/Cedula");
		lblRnccedula.setBounds(218, 13, 83, 14);
		panel_1.add(lblRnccedula);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(61, 63, 48, 14);
		panel_1.add(lblNombre);
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setBounds(113, 60, 208, 20);
		panel_1.add(formattedTextField_3);
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		formattedTextField_4.setBounds(113, 87, 208, 20);
		panel_1.add(formattedTextField_4);
		
		JLabel lblDireccion = new JLabel(" Direccion");
		lblDireccion.setBounds(51, 89, 58, 14);
		panel_1.add(lblDireccion);
		
		JFormattedTextField formattedTextField_5 = new JFormattedTextField();
		formattedTextField_5.setBounds(113, 112, 208, 20);
		panel_1.add(formattedTextField_5);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(61, 115, 48, 14);
		panel_1.add(lblTelefono);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_2.setBounds(379, 50, 374, 138);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblVendedor = new JLabel("Nota");
		lblVendedor.setBounds(10, 39, 58, 14);
		panel_2.add(lblVendedor);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 64, 354, 63);
		panel_2.add(editorPane);
		
		JLabel lblTerminos = new JLabel("Terminos");
		lblTerminos.setBounds(10, 11, 58, 16);
		panel_2.add(lblTerminos);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Contado", "Credito"}));
		comboBox.setBounds(70, 9, 114, 20);
		panel_2.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_3.setBounds(10, 200, 743, 175);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		DefaultTableModel modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Columna1");
		modeloTabla.addColumn("Columna2");
		modeloTabla.addColumn("Columna3");
		
		
		table = new JTable(modeloTabla);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 6, 731, 163);
		panel_3.add(scrollPane);

		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_4.setBounds(6, 387, 308, 63);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Aceptar");
		btnNewButton_2.setBounds(10, 0, 75, 28);
		panel_4.add(btnNewButton_2);
		
		JButton btnContador = new JButton("Contado");
		btnContador.setBounds(10, 29, 75, 28);
		panel_4.add(btnContador);
		
		JButton btnNewButton_4 = new JButton("Credito");
		btnNewButton_4.setBounds(87, 29, 89, 28);
		panel_4.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Anular Fact");
		btnNewButton_3.setBounds(87, 0, 89, 28);
		panel_4.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Borrar Articulo");
		btnNewButton_1.setBounds(181, 0, 105, 28);
		panel_4.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Retornar");
		btnNewButton.setBounds(181, 29, 105, 28);
		panel_4.add(btnNewButton);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
		panel_5.setBounds(326, 387, 427, 68);
		getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_4.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 47));
		textField_4.setEditable(false);
		textField_4.setText("0.00");
		textField_4.setBounds(108, 0, 319, 68);
		panel_5.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblValorBruto = new JLabel("Valor Bruto ==>");
		lblValorBruto.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 13));
		lblValorBruto.setBounds(6, 22, 126, 16);
		panel_5.add(lblValorBruto);
		
	}
}
