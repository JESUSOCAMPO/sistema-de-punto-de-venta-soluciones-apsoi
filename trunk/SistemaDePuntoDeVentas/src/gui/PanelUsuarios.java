package gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelUsuarios extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	/**
	 * Create the panel.
	 */
	public PanelUsuarios() {
	//	setLayout(new MigLayout("", "[][grow]", "[][][][][][][][]"));
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setForeground(new Color(0, 128, 0));
		btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(btnNuevo, "flowx,cell 1 0");
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel, "cell 0 1,alignx trailing");
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setEnabled(false);
		add(textField, "cell 1 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_1, "cell 0 2,alignx trailing");
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_2.setEnabled(false);
		add(textField_2, "cell 1 2,growx");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Direcci\u00F3n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_2, "cell 0 3,alignx trailing");
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setEnabled(false);
		add(textField_1, "cell 1 3,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("C\u00E9dula");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_3, "cell 0 4,alignx trailing");
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_3.setEnabled(false);
		add(textField_3, "cell 1 4,growx");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tel\u00E9fono");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_4, "cell 0 5,alignx trailing");
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_4.setEnabled(false);
		add(textField_4, "cell 1 5,growx");
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_5, "cell 0 6,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setEnabled(false);
		add(comboBox, "cell 1 6,growx");
		
		JLabel lblNewLabel_6 = new JLabel("Tipo de Usuario");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel_6, "cell 0 7,alignx trailing");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_1.setEnabled(false);
		add(comboBox_1, "cell 1 7,growx");
		
		JButton btnModificar = new JButton("New button");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(btnModificar, "cell 1 0");
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		}

}
