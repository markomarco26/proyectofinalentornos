package Main;

import Controlador.Controlador;
import Modelo.Conexion;
import Vista.*;

public class Main {

	public static void main(String[] args) {

		// co nfiguracion configuracion = new configuracion();
		// Conexion conn = null;
		Conexion conn = new Conexion();
		Controlador controlador = new Controlador();
		Gestion gestion = new Gestion();
		Principal principal = new Principal();
		Registro registro = new Registro();
		AnadirProfesor anadirprofesor = new AnadirProfesor();
		AnadirModulo anadirmodulo = new AnadirModulo();
		Bienvenida bienvenida = new Bienvenida();

		conn.setgestion(gestion);
		controlador.setconexionygestion(conn, gestion);

		// desde singin se accede a principal y al material
		principal.setconexionygestionyregistroycontrolador(conn, gestion, registro, controlador);
		// desde registro se accede a principal y al mantenimiento
		registro.setprincipalygestion(principal, gestion);
		// desde el material se accede al principal, a la nueva propiedad, a la
		// nuevo formato y nuevo material.
		gestion.settodo(principal, conn, controlador, anadirmodulo, anadirprofesor);
		bienvenida.setprincipal(principal);
		// desde la pagina nueva propiedad se accede a gestion
		anadirmodulo.setNewMaterial(gestion);
		// desde la pagina nuevo formato se accede a mantenimiento
		anadirprofesor.setNewMaterial(gestion);
		
	

//		ini.setprincipal(principal);
//		gestion.setVisible(true);
		bienvenida.setVisible(true);

	}

}