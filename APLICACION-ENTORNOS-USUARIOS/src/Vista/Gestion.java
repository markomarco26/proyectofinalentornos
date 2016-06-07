package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;
import Modelo.Conexion;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class Gestion extends JFrame {
	private AnadirModulo anadirmodulo;
	private AnadirProfesor anadirprofesor;
	private Controlador controlador;
	private Conexion conexion;
	private JPanel contentPane;
	private Principal principal;
	private Registro registro;
	private JTabbedPane tabbedPane;
	private JPanel panel_usuarios;
	private JPanel panel_profesores;
	private JButton btnAnadirProfesor;
	private JTable table_usuarios;
	private JTable table_profesor;
	private JButton btnSalir;
	private JButton button;
	private JTextField textFieldModificaNombre;
	private JTextField textFieldModificaNick;
	private JTextField textFieldModificaApellidos;
	private JTextField textFieldModificaNombreProfe;
	private JTextField textFieldModificaApellidosProfe;
	private JButton btnModificar_Profesores;
	private JButton buttonBorrar_Profesores;
	private JLabel lblNombreAModificar;
	private JLabel lblNickModificar;
	private JLabel lblSubfamiliaAModificar;
	private JLabel lblApellidosProfeModificar;
	private JLabel lblNombreProfeModificar;
	private JTable table_modulos;
	private JTextField textField_ModificarModulo;
	private DefaultTableModel dtm;
	private JTextField textFieldModificaEmail;
	private JTextField textFieldModificaContraseña;
	private JButton btnAadirModulo;
	private JTextField textField_ModificarHoras;
	private JTextField textField_ModificarProfesor;
	private JTextField textFieldNota;
	private JTable table_Notas;
	private JTextField textField_NotaAlumno;
	private JTextField textField_NotaModulo;
	private JTextField textField_NotaNota;
	private JLabel lblAlumnoMod;
	private JLabel lblModuloMod;
	private JLabel lblNotasMod;
	private JButton button_BorrarNota;
	private JButton button_ModificarNota;
	private JComboBox comboBox_Alumnos;
	private JComboBox comboBox_Modulo;
	private JButton btnModificarModulo;
	private JButton btnBorrar_Modulo;
	private JButton btnAadirNota;
	private JButton button_BorrarUsuario;
	private JButton button_ModificarUsuario;

//	public void rellenarTableAlumnos() {
//		String[][] tabla = conexion.getMateriales();
//		DefaultTableModel modelo = (DefaultTableModel) table_usuarios.getModel();
//		for (int i = 0; i < tabla.length; i++) {
//			modelo.addRow(tabla[i]);
//		}
//	}
//
//	public void rellenarTablaprofesor() {
//		String[][] tabla = conexion.getMateriales();
//		DefaultTableModel modelo = (DefaultTableModel) table_profesor.getModel();
//		for (int i = 0; i < tabla.length; i++) {
//			modelo.addRow(tabla[i]);
//		}
//	}
//
//	public void rellenarTablamodulos() {
//		String[][] tabla = conexion.getMateriales();
//		DefaultTableModel modelo = (DefaultTableModel) table_modulos.getModel();
//		for (int i = 0; i < tabla.length; i++) {
//			modelo.addRow(tabla[i]);
//		}
//	}
//	public void rellenarTablanotas() {
//		String[][] tabla = conexion.getMateriales();
//		DefaultTableModel modelo = (DefaultTableModel) table_Notas.getModel();
//		for (int i = 0; i < tabla.length; i++) {
//			modelo.addRow(tabla[i]);
//		}
//	}
//
//	public void rellenarComboBoxAlumnos() {
//		String[] combo = conexion.getComboBox();
//		DefaultComboBoxModel modelo = (DefaultComboBoxModel) comboBox_Alumnos.getModel();
//		for (int i = 0; i < combo.length; i++) {
//			modelo.addElement(combo[i]);
//		}
//	}
//	public void rellenarComboBoxModulos() {
//		String[] combo = conexion.getComboBox();
//		DefaultComboBoxModel modelo = (DefaultComboBoxModel) comboBox_Modulo.getModel();
//		for (int i = 0; i < combo.length; i++) {
//			modelo.addElement(combo[i]);
//		}
//	}
	public void settodo(Principal principal, 
			Conexion conexion, Controlador controlador, AnadirModulo anadirmodulo, AnadirProfesor anadirprofesor) {
		this.principal = principal;
		this.anadirmodulo = anadirmodulo;
		this.anadirprofesor = anadirprofesor;
		this.conexion = conexion;
		this.controlador = controlador;
	}
	
	public void nuevomodulo(String text, String text2, String text3) {
		   DefaultTableModel modelo = (DefaultTableModel) table_modulos.getModel();
		  String[] fila = new String[3];
		  fila[0] = text;
		  fila[1] = text2;
		  fila[2] = text3;
		  modelo.addRow(fila);
		  table_modulos.setModel(modelo);}
	
	public void nuevoprofesor(String text, String text2) {
		   DefaultTableModel modelo = (DefaultTableModel) table_profesor.getModel();
		  String[] fila = new String[2];
		  fila[0] = text;
		  fila[1] = text2;
		  modelo.addRow(fila);
		  table_profesor.setModel(modelo);}
	
	public void nuevanota(String text, String text2, String text3) {
		   DefaultTableModel modelo = (DefaultTableModel) table_Notas.getModel();
		  String[] fila = new String[3];
		  fila[0] = text;
		  fila[1] = text2;
		  fila[2] = text3;
		  modelo.addRow(fila);
		  table_Notas.setModel(modelo);}

	public Gestion() {

		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowActivated(WindowEvent arg0) {
//				controlador.cargarDatos();
//			}
			@Override
			public void windowOpened(WindowEvent arg0) {
				controlador.cargardatos();
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 556);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(173, 216, 230));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 627, GroupLayout.PREFERRED_SIZE)
					.addGap(4294))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
				panel_usuarios = new JPanel();
				panel_usuarios.setBackground(new Color(173, 216, 230));
				tabbedPane.addTab("Usuarios", null, panel_usuarios, null);
				
						JScrollPane scrollPane_usuarios = new JScrollPane();
						
								btnSalir = new JButton("Salir");
								btnSalir.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										setVisible(false);
										principal.setVisible(true);
									}
								});
								
										textFieldModificaNombre = new JTextField();
										textFieldModificaNombre.setColumns(10);
										
												textFieldModificaNick = new JTextField();
												textFieldModificaNick.setColumns(10);
												
														textFieldModificaApellidos = new JTextField();
														textFieldModificaApellidos.setColumns(10);
														
																lblNombreAModificar = new JLabel("Nombre Mod");
																
																		lblNickModificar = new JLabel("Nick Mod");
																		
																				lblSubfamiliaAModificar = new JLabel("Apellidos Mod");
																				
																				textFieldModificaEmail = new JTextField();
																				textFieldModificaEmail.setColumns(10);
																				
																				JLabel labelEmailModificiar = new JLabel("Email Mod");
																				
																				textFieldModificaContraseña = new JTextField();
																				textFieldModificaContraseña.setColumns(10);
																				
																				JLabel lblContrasenaMod = new JLabel("Contrase\u00F1a Mod");
																				
																				button_BorrarUsuario = new JButton("Borrar");
																				button_BorrarUsuario.addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {
																						dtm = (DefaultTableModel) table_usuarios.getModel();
																						int a = table_usuarios.getSelectedRow();
																						dtm.removeRow(a);
																						button_ModificarUsuario.setEnabled(false);
																						button_BorrarUsuario.setEnabled(false);
																						textFieldModificaNombre.setText("");
																						textFieldModificaNick.setText("");
																						textFieldModificaApellidos.setText("");
																						textFieldModificaEmail.setText("");	
																						textFieldModificaContraseña.setText("");
																					}
																				});
																				
																				
																				button_ModificarUsuario = new JButton("Modificar");
																				button_ModificarUsuario.addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent arg0) {
																						table_usuarios.setValueAt(textFieldModificaNombre.getText(), table_usuarios.getSelectedRow(), 0);
																						table_usuarios.setValueAt(textFieldModificaNick.getText(), table_usuarios.getSelectedRow(), 1);
																						table_usuarios.setValueAt(textFieldModificaApellidos.getText(), table_usuarios.getSelectedRow(), 2);
																						table_usuarios.setValueAt(textFieldModificaEmail.getText(), table_usuarios.getSelectedRow(), 3);
																						table_usuarios.setValueAt(textFieldModificaContraseña.getText(), table_usuarios.getSelectedRow(), 4);
																						
																					}
																				});
																				
																						GroupLayout gl_panel_usuarios = new GroupLayout(panel_usuarios);
																						gl_panel_usuarios.setHorizontalGroup(
																							gl_panel_usuarios.createParallelGroup(Alignment.LEADING)
																								.addGroup(Alignment.TRAILING, gl_panel_usuarios.createSequentialGroup()
																									.addContainerGap()
																									.addGroup(gl_panel_usuarios.createParallelGroup(Alignment.LEADING)
																										.addGroup(gl_panel_usuarios.createSequentialGroup()
																											.addComponent(button_BorrarUsuario, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
																											.addGap(18)
																											.addComponent(button_ModificarUsuario, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
																										.addGroup(gl_panel_usuarios.createSequentialGroup()
																											.addGroup(gl_panel_usuarios.createParallelGroup(Alignment.LEADING)
																												.addComponent(scrollPane_usuarios, GroupLayout.PREFERRED_SIZE, 593, GroupLayout.PREFERRED_SIZE)
																												.addComponent(textFieldModificaNombre, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
																												.addGroup(gl_panel_usuarios.createSequentialGroup()
																													.addGap(10)
																													.addComponent(lblNombreAModificar)
																													.addGap(24)
																													.addGroup(gl_panel_usuarios.createParallelGroup(Alignment.LEADING)
																														.addGroup(gl_panel_usuarios.createSequentialGroup()
																															.addGap(24)
																															.addComponent(lblNickModificar, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
																															.addGap(52)
																															.addComponent(lblSubfamiliaAModificar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
																															.addGap(41)
																															.addComponent(labelEmailModificiar, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
																															.addPreferredGap(ComponentPlacement.RELATED))
																														.addGroup(Alignment.TRAILING, gl_panel_usuarios.createSequentialGroup()
																															.addComponent(textFieldModificaNick, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																															.addPreferredGap(ComponentPlacement.UNRELATED)
																															.addComponent(textFieldModificaApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																															.addPreferredGap(ComponentPlacement.RELATED)
																															.addComponent(textFieldModificaEmail, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
																															.addPreferredGap(ComponentPlacement.RELATED)))
																													.addGroup(gl_panel_usuarios.createParallelGroup(Alignment.LEADING)
																														.addComponent(textFieldModificaContraseña, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
																														.addGroup(gl_panel_usuarios.createSequentialGroup()
																															.addGap(10)
																															.addComponent(lblContrasenaMod)))
																													.addGap(13))
																												.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
																											.addContainerGap(456, Short.MAX_VALUE))))
																						);
																						gl_panel_usuarios.setVerticalGroup(
																							gl_panel_usuarios.createParallelGroup(Alignment.LEADING)
																								.addGroup(gl_panel_usuarios.createSequentialGroup()
																									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																									.addComponent(scrollPane_usuarios, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
																									.addGap(15)
																									.addGroup(gl_panel_usuarios.createParallelGroup(Alignment.LEADING)
																										.addGroup(gl_panel_usuarios.createSequentialGroup()
																											.addGroup(gl_panel_usuarios.createParallelGroup(Alignment.BASELINE)
																												.addComponent(textFieldModificaContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																												.addComponent(textFieldModificaNick, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																												.addComponent(textFieldModificaApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																												.addComponent(textFieldModificaEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																											.addPreferredGap(ComponentPlacement.RELATED)
																											.addGroup(gl_panel_usuarios.createParallelGroup(Alignment.BASELINE)
																												.addComponent(labelEmailModificiar)
																												.addComponent(lblContrasenaMod)
																												.addComponent(lblNickModificar)
																												.addComponent(lblSubfamiliaAModificar)))
																										.addGroup(gl_panel_usuarios.createSequentialGroup()
																											.addComponent(textFieldModificaNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																											.addGroup(gl_panel_usuarios.createParallelGroup(Alignment.LEADING)
																												.addGroup(gl_panel_usuarios.createSequentialGroup()
																													.addGap(71)
																													.addGroup(gl_panel_usuarios.createParallelGroup(Alignment.BASELINE)
																														.addComponent(button_BorrarUsuario)
																														.addComponent(button_ModificarUsuario)))
																												.addGroup(gl_panel_usuarios.createSequentialGroup()
																													.addPreferredGap(ComponentPlacement.RELATED)
																													.addComponent(lblNombreAModificar)))
																											.addPreferredGap(ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
																											.addComponent(btnSalir)))
																									.addContainerGap())
																						);
																						
																								table_usuarios = new JTable();
																								table_usuarios.addMouseListener(new MouseAdapter() {

																									public void mouseClicked(MouseEvent e) {
																										int filaSelect = table_usuarios.getSelectedRow();
																										textFieldModificaNombre.setText(table_usuarios.getValueAt(filaSelect, 0).toString());
																										textFieldModificaNick.setText(table_usuarios.getValueAt(filaSelect, 1).toString());
																										textFieldModificaApellidos.setText(table_usuarios.getValueAt(filaSelect, 2).toString());
																										textFieldModificaEmail.setText(table_usuarios.getValueAt(filaSelect, 3).toString());
																										textFieldModificaContraseña.setText(table_usuarios.getValueAt(filaSelect, 4).toString());

																									}
																								});
																								
																										table_usuarios
																												.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Nick", "Apellidos", "Email", "Contraseña" }));
																										scrollPane_usuarios.setViewportView(table_usuarios);
																										panel_usuarios.setLayout(gl_panel_usuarios);

		panel_profesores = new JPanel();
		panel_profesores.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Profesores", null, panel_profesores, null);

		btnAnadirProfesor = new JButton("A\u00F1adir Profesor");
		btnAnadirProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirprofesor.setVisible(true);
				setEnabled(false);
			}
		});

		JScrollPane scrollPane_profesores = new JScrollPane();

		button = new JButton("Salir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				principal.setVisible(true);
			}
		});

		textFieldModificaNombreProfe = new JTextField();
		textFieldModificaNombreProfe.setColumns(10);

		textFieldModificaApellidosProfe = new JTextField();
		textFieldModificaApellidosProfe.setColumns(10);

		btnModificar_Profesores = new JButton("Modificar");
		btnModificar_Profesores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_profesor.setValueAt(textFieldModificaNombreProfe.getText(), table_profesor.getSelectedRow(), 0);
				table_profesor.setValueAt(textFieldModificaApellidosProfe.getText(), table_profesor.getSelectedRow(), 1);

			}
		});

		buttonBorrar_Profesores = new JButton("Borrar");
		buttonBorrar_Profesores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm = (DefaultTableModel) table_profesor.getModel();
				int a = table_profesor.getSelectedRow();
				dtm.removeRow(a);
				btnModificar_Profesores.setEnabled(false);
				buttonBorrar_Profesores.setEnabled(false);
				textFieldModificaNombreProfe.setText("");
				textFieldModificaApellidosProfe.setText("");

			}
		});

		lblApellidosProfeModificar = new JLabel("Apellidos Mod");

		lblNombreProfeModificar = new JLabel("Nombre Mod");

		table_profesor = new JTable();
		table_profesor.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int filaSelect = table_profesor.getSelectedRow();
				textFieldModificaNombreProfe.setText(table_profesor.getValueAt(filaSelect, 0).toString());
				textFieldModificaApellidosProfe.setText(table_profesor.getValueAt(filaSelect, 1).toString());
				

			}
		});
		table_profesor
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Apellidos" }));
		scrollPane_profesores.setViewportView(table_profesor);
		GroupLayout gl_panel_profesores = new GroupLayout(panel_profesores);
		gl_panel_profesores.setHorizontalGroup(
			gl_panel_profesores.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_profesores.createSequentialGroup()
					.addGroup(gl_panel_profesores.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_profesores.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_panel_profesores.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAnadirProfesor)
								.addGroup(gl_panel_profesores.createSequentialGroup()
									.addGap(9)
									.addGroup(gl_panel_profesores.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_profesores.createSequentialGroup()
											.addGap(10)
											.addComponent(lblNombreProfeModificar))
										.addGroup(gl_panel_profesores.createSequentialGroup()
											.addComponent(textFieldModificaNombreProfe, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
											.addGap(62)
											.addComponent(textFieldModificaApellidosProfe, 174, 174, 174))))
								.addGroup(gl_panel_profesores.createSequentialGroup()
									.addGap(231)
									.addComponent(lblApellidosProfeModificar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_profesores.createSequentialGroup()
							.addContainerGap()
							.addComponent(buttonBorrar_Profesores, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnModificar_Profesores, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_profesores.createSequentialGroup()
							.addContainerGap()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_profesores.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_profesores, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(676, Short.MAX_VALUE))
		);
		gl_panel_profesores.setVerticalGroup(
			gl_panel_profesores.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_profesores.createSequentialGroup()
					.addGap(13)
					.addComponent(btnAnadirProfesor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_profesores, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(gl_panel_profesores.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldModificaNombreProfe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldModificaApellidosProfe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_profesores.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidosProfeModificar)
						.addComponent(lblNombreProfeModificar))
					.addGap(30)
					.addGroup(gl_panel_profesores.createParallelGroup(Alignment.BASELINE)
						.addComponent(buttonBorrar_Profesores)
						.addComponent(btnModificar_Profesores))
					.addGap(124)
					.addComponent(button)
					.addContainerGap())
		);
		panel_profesores.setLayout(gl_panel_profesores);
		
		JPanel panel_notas = new JPanel();
		panel_notas.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Notas", null, panel_notas, null);
		
		comboBox_Alumnos = new JComboBox();
		comboBox_Alumnos.setModel(new DefaultComboBoxModel(new String[] {"alumno1", "alumno2", "alumno3", "alumno4", "alumno5"}));
		
		JLabel lblAlumnos = new JLabel("Alumnos");
		
		comboBox_Modulo = new JComboBox();
		comboBox_Modulo.setModel(new DefaultComboBoxModel(new String[] {"Sistemas Informaticos", "Entornos", "Lenguajes", "Bases de Datos", "Programacion"}));
		
		JLabel labelModulo = new JLabel("Modulo");
		
		JLabel lblNota = new JLabel("Nota");
		
		textFieldNota = new JTextField();
		textFieldNota.setColumns(10);
		
		btnAadirNota = new JButton("A\u00F1adir Nota");
		btnAadirNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String alumno = (String) comboBox_Alumnos.getSelectedItem();
				String modulo = (String) comboBox_Modulo.getSelectedItem();
				String nota = textFieldNota.getText();
				nuevanota(alumno, modulo, nota);
			}
		});
		
		JScrollPane scrollPaneNota = new JScrollPane();
		
		textField_NotaAlumno = new JTextField();
		textField_NotaAlumno.setColumns(10);
		
		textField_NotaModulo = new JTextField();
		textField_NotaModulo.setColumns(10);
		
		textField_NotaNota = new JTextField();
		textField_NotaNota.setColumns(10);
		
		lblAlumnoMod = new JLabel("Alumno Mod");
		
		lblModuloMod = new JLabel("Modulo Mod");
		
		lblNotasMod = new JLabel("Notas Mod");
		
		button_BorrarNota = new JButton("Borrar");
		button_BorrarNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm = (DefaultTableModel) table_Notas.getModel();
				int a = table_Notas.getSelectedRow();
				dtm.removeRow(a);
				button_ModificarNota.setEnabled(false);
				button_BorrarNota.setEnabled(false);
				textField_NotaAlumno.setText("");
				textField_NotaModulo.setText("");
				textField_NotaNota.setText("");
			}
		});
		
		button_ModificarNota = new JButton("Modificar");
		button_ModificarNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_Notas.setValueAt(textField_NotaAlumno.getText(), table_Notas.getSelectedRow(), 0);
				table_Notas.setValueAt(textField_NotaModulo.getText(), table_Notas.getSelectedRow(), 1);
				table_Notas.setValueAt(textField_NotaNota.getText(), table_Notas.getSelectedRow(), 2);
			}
		});
		
		JButton button_3 = new JButton("Salir");
		GroupLayout gl_panel_notas = new GroupLayout(panel_notas);
		gl_panel_notas.setHorizontalGroup(
			gl_panel_notas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_notas.createSequentialGroup()
					.addGroup(gl_panel_notas.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_notas.createSequentialGroup()
							.addGroup(gl_panel_notas.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_notas.createSequentialGroup()
									.addGap(90)
									.addComponent(comboBox_Alumnos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_notas.createSequentialGroup()
									.addGap(99)
									.addComponent(lblAlumnos)))
							.addGroup(gl_panel_notas.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_notas.createSequentialGroup()
									.addGap(79)
									.addComponent(labelModulo, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_notas.createSequentialGroup()
									.addGap(34)
									.addComponent(comboBox_Modulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(43)
							.addGroup(gl_panel_notas.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_notas.createSequentialGroup()
									.addComponent(textFieldNota, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addGap(29)
									.addComponent(btnAadirNota, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNota)))
						.addGroup(gl_panel_notas.createSequentialGroup()
							.addGap(25)
							.addComponent(scrollPaneNota, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_notas.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_panel_notas.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_notas.createSequentialGroup()
									.addComponent(button_BorrarNota, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(button_ModificarNota, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_notas.createSequentialGroup()
									.addComponent(lblAlumnoMod, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addGap(64)
									.addComponent(lblModuloMod, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addGap(48)
									.addComponent(lblNotasMod, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_notas.createSequentialGroup()
									.addComponent(textField_NotaAlumno, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_NotaModulo, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addComponent(textField_NotaNota, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_notas.createSequentialGroup()
							.addContainerGap()
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		gl_panel_notas.setVerticalGroup(
			gl_panel_notas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_notas.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_notas.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAlumnos)
						.addComponent(labelModulo)
						.addComponent(lblNota))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_notas.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_Alumnos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_Modulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAadirNota))
					.addGap(24)
					.addComponent(scrollPaneNota, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_notas.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_notas.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_NotaModulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_NotaAlumno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_NotaNota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_notas.createParallelGroup(Alignment.LEADING)
						.addComponent(lblModuloMod)
						.addComponent(lblAlumnoMod)
						.addComponent(lblNotasMod))
					.addGap(31)
					.addGroup(gl_panel_notas.createParallelGroup(Alignment.LEADING)
						.addComponent(button_BorrarNota)
						.addComponent(button_ModificarNota))
					.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
					.addComponent(button_3)
					.addContainerGap())
		);
		
		table_Notas = new JTable();
		table_Notas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int filaSelect = table_Notas.getSelectedRow();
				textField_NotaAlumno.setText(table_Notas.getValueAt(filaSelect, 0).toString());
				textField_NotaModulo.setText(table_Notas.getValueAt(filaSelect, 1).toString());
				textField_NotaNota.setText(table_Notas.getValueAt(filaSelect, 2).toString());
			}
		});
		table_Notas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Alumnos", "Modulos", "Notas"
			}
		));
		scrollPaneNota.setViewportView(table_Notas);
		panel_notas.setLayout(gl_panel_notas);

		JPanel panel_modulos = new JPanel();

		panel_modulos.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("M\u00F3dulos", null, panel_modulos, null);

		JScrollPane scrollPane_Modulos = new JScrollPane();
		scrollPane_Modulos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		btnModificarModulo = new JButton("Modificar");
		btnModificarModulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_modulos.setValueAt(textField_ModificarModulo.getText(), table_modulos.getSelectedRow(), 0);
				table_modulos.setValueAt(textField_ModificarHoras.getText(), table_modulos.getSelectedRow(), 1);
				table_modulos.setValueAt(textField_ModificarProfesor.getText(), table_modulos.getSelectedRow(), 2);
				 
			}
		});

		btnBorrar_Modulo = new JButton("Borrar");
		btnBorrar_Modulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm = (DefaultTableModel) table_modulos.getModel();
				int a = table_modulos.getSelectedRow();
				dtm.removeRow(a);
				btnModificarModulo.setEnabled(false);
				btnBorrar_Modulo.setEnabled(false);
				textField_ModificarModulo.setText("");
				textField_ModificarHoras.setText("");
				textField_ModificarProfesor.setText("");
				 

			}
		});

		textField_ModificarModulo = new JTextField();
		textField_ModificarModulo.setColumns(10);
		
		btnAadirModulo = new JButton("A\u00F1adir Modulo");
		btnAadirModulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirmodulo.setVisible(true);
				setEnabled(false);
			}
		});
		
		textField_ModificarHoras = new JTextField();
		textField_ModificarHoras.setColumns(10);
		
		textField_ModificarProfesor = new JTextField();
		textField_ModificarProfesor.setColumns(10);
		
		JButton button_4 = new JButton("Salir");
		GroupLayout gl_panel_modulos = new GroupLayout(panel_modulos);
		gl_panel_modulos.setHorizontalGroup(
			gl_panel_modulos.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_modulos.createSequentialGroup()
					.addGroup(gl_panel_modulos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_modulos.createSequentialGroup()
							.addGap(21)
							.addComponent(btnAadirModulo, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_modulos.createSequentialGroup()
							.addGap(44)
							.addGroup(gl_panel_modulos.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_Modulos, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_modulos.createSequentialGroup()
									.addGroup(gl_panel_modulos.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel_modulos.createSequentialGroup()
											.addComponent(btnBorrar_Modulo)
											.addGap(18)
											.addComponent(btnModificarModulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(gl_panel_modulos.createSequentialGroup()
											.addComponent(textField_ModificarModulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(30)
											.addComponent(textField_ModificarHoras, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
									.addGap(26)
									.addComponent(textField_ModificarProfesor, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))))
					.addGap(596))
				.addGroup(Alignment.LEADING, gl_panel_modulos.createSequentialGroup()
					.addContainerGap()
					.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(960, Short.MAX_VALUE))
		);
		gl_panel_modulos.setVerticalGroup(
			gl_panel_modulos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_modulos.createSequentialGroup()
					.addGap(20)
					.addComponent(btnAadirModulo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_Modulos, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_modulos.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_ModificarModulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_ModificarHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_ModificarProfesor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel_modulos.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBorrar_Modulo)
						.addComponent(btnModificarModulo))
					.addPreferredGap(ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
					.addComponent(button_4)
					.addContainerGap())
		);

		table_modulos = new JTable();
		table_modulos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaSelect = table_modulos.getSelectedRow();
				textField_ModificarModulo.setText(table_modulos.getValueAt(filaSelect, 0).toString());
				textField_ModificarHoras.setText(table_modulos.getValueAt(filaSelect, 1).toString());
				textField_ModificarProfesor.setText(table_modulos.getValueAt(filaSelect, 2).toString());

			}
		});
		table_modulos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Modulo", "Horas Semanales", "Profesores"
			}
		));
		table_modulos.getColumnModel().getColumn(1).setPreferredWidth(80);
		table_modulos.getColumnModel().getColumn(1).setMinWidth(22);
		dtm = new DefaultTableModel(new Object[][] {

		}, new String[] { "Modulo", "Horas Semanales", "Profesores" });
		table_modulos.setModel(dtm);
		scrollPane_Modulos.setViewportView(table_modulos);
		panel_modulos.setLayout(gl_panel_modulos);
		scrollPane_Modulos.setViewportView(table_modulos);
		panel_modulos.setLayout(gl_panel_modulos);
		contentPane.setLayout(gl_contentPane);
	}

	public void setCtrl(Controlador ctrl) {
		this.controlador = ctrl;

	}

	public void setBd(Conexion bd) {
		this.conexion = bd;
	}

	public void rellenarTablaAlumno() {
		String[][] tabla = conexion.getMateriales();
		DefaultTableModel modelo = (DefaultTableModel) table_usuarios.getModel();
		for (int i = 0; i < tabla.length; i++) {
			modelo.addRow(tabla[i]);
		}
	}

	public void rellenarTablaProfe() {
		String[][] tabla = conexion.getMateriales();
		DefaultTableModel modelo = (DefaultTableModel) table_profesor.getModel();
		for (int i = 0; i < tabla.length; i++) {
			modelo.addRow(tabla[i]);
		}
		
	}
		
	}
