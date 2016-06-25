package appPull;

import model.UsuarioDao;
import controller.ControllerLogin;
import view.ViewLogin;

public class AppMain {
	public static void main(String[] args) {
		ViewLogin viewLogin = new ViewLogin();
		UsuarioDao usuarioDao = new UsuarioDao();
		ControllerLogin controllerLogin = new ControllerLogin(viewLogin, usuarioDao);
		viewLogin.setVisible(true);
	
	}
}
