package Controlador;

import Modelo.Conexion;
import Vista.Gestion;

public class Controlador {
	private Conexion conexion;
	private Gestion gestion;

	public void setconexionygestion(Conexion conexion, Gestion gestion) {
		this.conexion = conexion;
		this.gestion = gestion;
	}
//
//	public void cargarDatos() {
//		conexion.consultaGestion();
//	}

	public void cargardatos() {
	conexion.cargardatos();
		
	}

//	public void establecerini() {
//		conexion.establecerini();
//	}

//	public void comprobacion(String text, String contra) {
//		conexion.comprobacion(text, contra);
//	}
	
}