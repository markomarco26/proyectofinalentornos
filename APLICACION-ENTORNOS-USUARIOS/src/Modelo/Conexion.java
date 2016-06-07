package Modelo;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Principal;
import java.sql.*;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;
import Vista.AnadirModulo;
import Vista.AnadirProfesor;
import Vista.Gestion;
import Vista.Gestion;

public class Conexion {



	private Component panel;
	private DefaultTableModel dtm;
	private AnadirProfesor anadirprofesor;
	private AnadirModulo anadirmodulo;
	private Gestion gestion;
	private String[] combo;
	private Principal principal;
	private Controlador controlador;
	public String bdNick;
	public String bdPass;
	private String mi_url = "jdbc:oracle:thin:@localhost:1521:XE";
	private int contador;
	private Connection conexion;
	private String bd, login, pwd, url;
	private String[][] tabla;


	public Conexion() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "madrid8015jn");
			System.out.println("-- Conexión establecida --");
		} catch (ClassNotFoundException e) {
			System.out.println("No tengo el driver cargado");
		} catch (SQLException e) {
			System.out.println("Falla la conexión");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void Consulta(String query) {
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {

				bdNick = rset.getString(2);
				bdPass = rset.getString(6);

			}

		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void insertInto(String query) {
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeQuery(query);

		} catch (Exception e) {

			System.out.println("No se ha insertado1");
		}

	}

	public int numeroUsuarios(String query) {
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {

				contador = contador + 1;
			}

		} catch (Exception e) {

			System.out.println("No se ha insertado2");
		}
		return contador;

	}

	public void validaUsuario(String query) {
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {

				bdNick = rset.getString(2);
				System.out.println(bdNick);
			}

		} catch (SQLException s) {
			System.out.println("Fallo");
		}
	}

	public String getNick(String query) {
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {

				bdNick = rset.getString(2);

			}

		} catch (SQLException s) {
			s.printStackTrace();
		}
		return bdNick;
	}
//	public void consultaGestion() {
//		// CONSULTA DATOS TABLA Profesores
//		try {
//			String nfilas = "Select count(*) from PROYECTO_Entornos.PROFES";
//			Statement stmt = conexion.createStatement();
//			ResultSet rset = stmt.executeQuery(nfilas);
//			rset.next();
//			int f = rset.getInt(1);
//			String query = "SELECT  NOMBRE_PROFE, APELLIDO_PROFE FROM PROYECTO_Entornos.PROFES";
//			stmt = conexion.createStatement();
//			rset = stmt.executeQuery(query);
//			ResultSetMetaData rsmd = rset.getMetaData();
//			int c = rsmd.getColumnCount();
//			int i = 0;
//			tabla = new String[f][c];
//			while (rset.next()) {
//				tabla[i][0] = rset.getString(1);
//				tabla[i][1] = rset.getString(2);
//				i++;
//			}
//			rset.close();
//			stmt.close();
//		} catch (SQLException s) {
//			s.printStackTrace();
//		}
//		gestion.rellenarTablaprofesor();
//		
//		// CONSULTA DATOS TABLA Notas
//				try {
//					String nfilas = "Select count(*) from PROYECTO_Entornos.notas";
//					Statement stmt = conexion.createStatement();
//					ResultSet rset = stmt.executeQuery(nfilas);
//					rset.next();
//					int f = rset.getInt(1);
//					String query = "SELECT  NOMBRE_alumno, nombre_modulo, nota FROM PROYECTO_Entornos.alumnos, PROYECTO_Entornos.modulos, PROYECTO_Entornos.notas where notas.ALUMNOS_COD_ALUMNO = alumnos.COD_ALUMNO and notas.MODULOS_COD_MODULO = modulos.COD_MODULO";
//					stmt = conexion.createStatement();
//					rset = stmt.executeQuery(query);
//					ResultSetMetaData rsmd = rset.getMetaData();
//					int c = rsmd.getColumnCount();
//					int i = 0;
//					tabla = new String[f][c];
//					while (rset.next()) {
//						tabla[i][0] = rset.getString(1);
//						tabla[i][1] = rset.getString(2);
//						i++;
//					}
//					rset.close();
//					stmt.close();
//				} catch (SQLException s) {
//					s.printStackTrace();
//				}
//				gestion.rellenarTablanotas();
//		
//		// CONSULTA DATOS TABLA Alumnos
//
//		try {
//			String nfilas = "Select count(*) from PROYECTO_Entornos.alumnos";
//			Statement stmt = conexion.createStatement();
//			ResultSet rset = stmt.executeQuery(nfilas);
//			rset.next();
//			int f = rset.getInt(1);
//			String query = "SELECT NOMBRE_ALUMNO, NICK, APELLIDOS, EMAIL, CONTRASENA from PROYECTO_Entornos.alumnos";
//			stmt = conexion.createStatement();
//			rset = stmt.executeQuery(query);
//			ResultSetMetaData rsmd = rset.getMetaData();
//			int c = rsmd.getColumnCount();
//			int i = 0;
//			tabla = new String[f][c];
//			while (rset.next()) {
//				tabla[i][0] = rset.getString(1);
//				tabla[i][1] = rset.getString(2);
//				tabla[i][2] = rset.getString(3);
//				tabla[i][3] = rset.getString(4);
//				tabla[i][4] = rset.getString(5);
//				i++;
//			}
//			rset.close();
//			stmt.close();
//		} catch (SQLException s) {
//			s.printStackTrace();
//		}
//		gestion.rellenarTableAlumnos();
//		
//		// CONSULTA DATOS TABLA MODULOS
//
//		try {
//			String nfilas = "Select count(*) from PROYECTO_Entornos.MODULOS";
//			Statement stmt = conexion.createStatement();
//			ResultSet rset = stmt.executeQuery(nfilas);
//			rset.next();
//			int f = rset.getInt(1);
//			String query = "SELECT  NOMBRE_MODULO, HORAS_SEMANA, NOMBRE_PROFE FROM PROYECTO_Entornos.MODULOS, PROYECTO_Entornos.PROFES WHERE MODULOS.PROFES_COD_PROFE = PROFES.COD_PROFE";
//			stmt = conexion.createStatement();
//			rset = stmt.executeQuery(query);
//			ResultSetMetaData rsmd = rset.getMetaData();
//			int c = rsmd.getColumnCount();
//			int i = 0;
//			tabla = new String[f][c];
//			while (rset.next()) {
//				tabla[i][0] = rset.getString(1);
//				tabla[i][1] = rset.getString(2);
//				tabla[i][2] = rset.getString(3);
//				i++;
//			}
//			rset.close();
//			stmt.close();
//		} catch (SQLException s) {
//			s.printStackTrace();
//		}
//		gestion.rellenarTablamodulos();
//		// CONSULTA DATOS COMBOBOX ALUMNOS
//
//		try {
//			String nfilas = "Select count(*) from Proyecto_entornos.alumnos";
//			Statement stmt = conexion.createStatement();
//			ResultSet rset = stmt.executeQuery(nfilas);
//			rset.next();
//			int f = rset.getInt(1);
//			String query = "SELECT Nombre_alumno FROM Proyecto_entornos.alumnos";
//			stmt = conexion.createStatement();
//			rset = stmt.executeQuery(query);
//			ResultSetMetaData rsmd = rset.getMetaData();
//			int i = 0;
//			combo = new String[f];
//			while (rset.next()) {
//				combo[i] = rset.getString(1);
//				i++;
//			}
//			rset.close();
//			stmt.close();
//		} catch (SQLException s) {
//			s.printStackTrace();
//		}
//		gestion.rellenarComboBoxAlumnos();
//		// CONSULTA DATOS COMBOBOX MODULOS
//
//		try {
//			String nfilas = "Select count(*) from Proyecto_entornos.MODULOS";
//			Statement stmt = conexion.createStatement();
//			ResultSet rset = stmt.executeQuery(nfilas);
//			rset.next();
//			int f = rset.getInt(1);
//			String query = "SELECT Nombre_MODULO FROM Proyecto_entornos.MODULOS";
//			stmt = conexion.createStatement();
//			rset = stmt.executeQuery(query);
//			ResultSetMetaData rsmd = rset.getMetaData();
//			int i = 0;
//			combo = new String[f];
//			while (rset.next()) {
//				combo[i] = rset.getString(1);
//				i++;
//			}
//			rset.close();
//			stmt.close();
//		} catch (SQLException s) {
//			s.printStackTrace();
//		}
//		gestion.rellenarComboBoxModulos();
//		
//		}

	public String[][] getMateriales() {
		return tabla;
	}

	public String[] getComboBox() {
		return combo;
	}

	public void setMateriales(Gestion gestion) {
		this.gestion = gestion;
	}


//	public void comprobacion(String usuario, String contrasena) {
////		Consulta("select * from  PROYECTO_ENTORNOS.ALUMNOS where nick='" + usuario + "' and password='" + contrasena + "'");
//		if (usuario.equals(bdNick) && contrasena.equals(bdPass))
//			gestion.setVisible(true);
//		else if (!usuario.equals(bdNick) || (!contrasena.equals(bdPass))) {
//			contador++;
//			if (contador >= 3)
//				System.exit(0);
//		}
//	}

	public void setgestion(Gestion gestion) {
		this.gestion = gestion;
	}

	public void cargardatos() {
		try {
			String nfilas = "Select count(*) from PROYECTO_ENTORNOS.ALUMNOS";
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(nfilas);
			rset.next();
			int f = rset.getInt(1);
			String query = "SELECT NOMBRE_ALUMNO, NICK, APELLIDOS, EMAIL, CONTRASENA from PROYECTO_Entornos.alumnos";
			stmt = conexion.createStatement();
			rset = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rset.getMetaData();
			int c = rsmd.getColumnCount();
			int i = 0;
			tabla = new String[f][c];
			while (rset.next()) {
				tabla[i][0] = rset.getString(1);
				tabla[i][1] = rset.getString(2);
				tabla[i][2] = rset.getString(3);
				tabla[i][3] = rset.getString(4);
				tabla[i][4] = rset.getString(5);
				i++;
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		gestion.rellenarTablaAlumno();
		try {
			String nfilas = "Select count(*) from PROYECTO_ENTORNOS.PROFES";
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(nfilas);
			rset.next();
			int f = rset.getInt(1);
			String query = "SELECT NOMBRE_PROFE, APELLIDOS_PROFE from PROYECTO_Entornos.PROFES";
			stmt = conexion.createStatement();
			rset = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rset.getMetaData();
			int c = rsmd.getColumnCount();
			int i = 0;
			tabla = new String[f][c];
			while (rset.next()) {
				tabla[i][0] = rset.getString(1);
				tabla[i][1] = rset.getString(2);
				i++;
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		gestion.rellenarTablaProfe();
		
		try {
			String nfilas = "Select count(*) from proyecto_entornos.alumnos";
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(nfilas);
			rset.next();
			int f = rset.getInt(1);
			String query = "SELECT nombre_alumno FROM proyecto_entornos.alumnos";
			stmt = conexion.createStatement();
			rset = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rset.getMetaData();
			int i = 0;
			combo = new String[f];
			while (rset.next()) {
				combo[i] = rset.getString(1);
				i++;
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		gestion.rellenarComboBoxAlumno();
		
//		try {
//			String nfilas = "Select count(*) from PROYECTO_ENTORNOS.notas";
//			Statement stmt = conexion.createStatement();
//			ResultSet rset = stmt.executeQuery(nfilas);
//			rset.next();
//			int f = rset.getInt(1);
//			String query = "SELECT NOMBRE_Alumno, NOMBRE_PROFE, nota from PROYECTO_Entornos.alumnos, PROYECTO_Entornos.PROFES, PROYECTO_Entornos.notas where notas.ALUMNOS_COD_ALUMNO = alumnos.COD_ALUMNO and notas.MODULOS_COD_MODULO=modulos.COD_MODULO";
//			stmt = conexion.createStatement();
//			rset = stmt.executeQuery(query);
//			ResultSetMetaData rsmd = rset.getMetaData();
//			int c = rsmd.getColumnCount();
//			int i = 0;
//			tabla = new String[f][c];
//			while (rset.next()) {
//				tabla[i][0] = rset.getString(1);
//				tabla[i][1] = rset.getString(2);
//				tabla[i][2] = rset.getString(3);
//				i++;
//			}
//			rset.close();
//			stmt.close();
//		} catch (SQLException s) {
//			s.printStackTrace();
//		}
//		gestion.rellenarTablaNota();
		
//		try {
//			String nfilas = "Select count(*) from PROYECTO_ENTORNOS.modulos";
//			Statement stmt = conexion.createStatement();
//			ResultSet rset = stmt.executeQuery(nfilas);
//			rset.next();
//			int f = rset.getInt(1);
//			String query = "SELECT NOMBRE_modulo, horas_semana, nombre_profe from PROYECTO_Entornos.modulos where modulos.PROFES_COD_PROFE = profes.COD_PROFE";
//			stmt = conexion.createStatement();
//			rset = stmt.executeQuery(query);
//			ResultSetMetaData rsmd = rset.getMetaData();
//			int c = rsmd.getColumnCount();
//			int i = 0;
//			tabla = new String[f][c];
//			while (rset.next()) {
//				tabla[i][0] = rset.getString(1);
//				tabla[i][1] = rset.getString(2);
//				tabla[i][2] = rset.getString(3);
//				i++;
//			}
//			rset.close();
//			stmt.close();
//		} catch (SQLException s) {
//			s.printStackTrace();
//		}
//		gestion.rellenarTablaModulo();
		

		
		try {
			String nfilas = "Select count(*) from proyecto_entornos.modulos";
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(nfilas);
			rset.next();
			int f = rset.getInt(1);
			String query = "SELECT nombre_modulo FROM proyecto_entornos.modulos";
			stmt = conexion.createStatement();
			rset = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rset.getMetaData();
			int i = 0;
			combo = new String[f];
			while (rset.next()) {
				combo[i] = rset.getString(1);
				i++;
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		gestion.rellenarComboBoxModulo();
		
	}
	

}
