package Vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnadirProfesor extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private Gestion gestion;
	private JTextField textFieldApellido;

	public void setNewMaterial(Gestion gestion) {
		this.gestion = gestion;

	}

	public AnadirProfesor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 277);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelNuevoProfesor = new JLabel("NUEVO PROFESOR");
		labelNuevoProfesor.setForeground(Color.BLACK);
		labelNuevoProfesor.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		JLabel labelRango = new JLabel("Apellidos");
		labelRango.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		
		JButton btnAnadirProfesor = new JButton("A\u00F1adir Profesor");
		btnAnadirProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textFieldNombre.getText();
				String apellido = textFieldApellido.getText();
				
				gestion.nuevoprofesor(nombre, apellido);
				setVisible(false);
				gestion.setVisible(true);
				gestion.setEnabled(true);	
			}
		});
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(36, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(labelNombre, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
									.addGap(8))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(labelRango)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addComponent(labelNuevoProfesor)))
					.addContainerGap(177, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(91)
					.addComponent(btnAnadirProfesor)
					.addContainerGap(129, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelNuevoProfesor, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelNombre, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelRango, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(btnAnadirProfesor)
					.addGap(69))
		);
		contentPane.setLayout(gl_contentPane);
	}
}