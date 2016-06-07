package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AnadirModulo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNuevoModulo;
	private JComboBox comboBoxProfesor;
	private Gestion gestion;
	private JTextField textFieldNuevoModuloHoras;

	public void setNewMaterial(Gestion gestion) {
		this.gestion = gestion;

	}

	public AnadirModulo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 329);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNuevoModulo = new JLabel("NUEVO M\u00D3DULO");
		lblNuevoModulo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNuevoModulo.setForeground(Color.BLACK);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));

		textFieldNuevoModulo = new JTextField();
		textFieldNuevoModulo.setColumns(10);

		JLabel lblF = new JLabel("Profesor");
		lblF.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));

		comboBoxProfesor = new JComboBox();
		comboBoxProfesor.setModel(new DefaultComboBoxModel(new String[] {"David Alvarez", "David Perez", "Hernesto", "Pedro"}));

		JButton btnAadirModulo = new JButton("A\u00F1adir Modulo");
		btnAadirModulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textFieldNuevoModulo.getText();
				String horas = textFieldNuevoModuloHoras.getText();
				String profe = (String) comboBoxProfesor.getSelectedItem();
				gestion.nuevomodulo(nombre, horas, profe);
				setVisible(false);
				gestion.setVisible(true);
				gestion.setEnabled(true);				

			}
		});
		
		textFieldNuevoModuloHoras = new JTextField();
		textFieldNuevoModuloHoras.setColumns(10);
		
		JLabel labelHoras = new JLabel("Horas Semanales");
		labelHoras.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNombre)
									.addGap(21))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblF)
										.addComponent(labelHoras))
									.addGap(18)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldNuevoModuloHoras, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldNuevoModulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxProfesor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(164)
							.addComponent(btnAadirModulo))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(130)
							.addComponent(lblNuevoModulo)))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addComponent(lblNuevoModulo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textFieldNuevoModulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldNuevoModuloHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelHoras, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblF)
						.addComponent(comboBoxProfesor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(btnAadirModulo)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void setNewModulo(Gestion gestion2) {
		// TODO Auto-generated method stub
		
	}
}