package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.UsuarioDao;
import model.UsuarioVo;
import view.ViewAddUser;
import view.ViewLogin;
import view.ViewMensajes;

public class ControllerLogin implements ActionListener{
	
	private ControllerLogin controllerLogin;
	private ViewLogin viewLogin = new ViewLogin();
	private ViewAddUser viewAddUser = new ViewAddUser();
	private ViewMensajes viewMensajes =new ViewMensajes();
	private UsuarioVo usuarioVo = new UsuarioVo();
	private UsuarioDao usuarioDao = new UsuarioDao();
	
	public ControllerLogin() {}
	
	public ControllerLogin(ViewLogin viewLogin, UsuarioDao usuarioDao) {
		this.viewLogin = viewLogin;
		this.usuarioDao = usuarioDao;
		
		viewLogin.setBtnAcceder(this);
		viewLogin.setBtnRegistrar(this);
	}
	
	public ControllerLogin(ViewAddUser viewAddUser) {
		this.viewAddUser = viewAddUser;
		
		viewAddUser.setBtnAdd(this);
		viewAddUser.setBtnBack(this);
	}
	
	public ControllerLogin(ViewMensajes viewMensajes) {
		this.viewMensajes = viewMensajes;
		
		this.viewMensajes.setBtnAddMessage(this);
		this.viewMensajes.setBtnLogOut(this);
		this.viewMensajes.setBtnSalir(this);
		viewMensajes.setTitle(usuarioVo.getNomUserArea());
		viewMensajes();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object btn = arg0.getSource();
		
		if (btn == viewLogin.getBtnAcceder()){
			String user = viewLogin.getTxtUser().trim();
			String pass = viewLogin.getTxtPass().trim();
			if (user.equals("") || pass.equals("")) {
				viewLogin.setError("Campos vacios");
			} else {
				usuarioVo.setNomUser(user);
				usuarioVo.setPassUser(pass);
				if(usuarioDao.verifyUser(usuarioVo)){
					viewLogin.dispose();
					controllerLogin = new ControllerLogin(viewMensajes);
					viewMensajes.setVisible(true);
				} else {
					viewLogin.setError("Usuario o password incorrectos");
				}
				
			}
		} else if (btn == viewLogin.getBtnRegistrar()) {
			viewLogin.dispose();
			controllerLogin = new ControllerLogin(viewAddUser);
			viewAddUser.setVisible(true);
			
			
		} else if (btn == viewAddUser.getBtnAdd()) {
			String user = viewAddUser.getTxtUser().trim();
			String pass = viewAddUser.getTxtPass().trim();
			if (user.equals("") || pass.equals("")) {
				viewAddUser.setError("Campos vacios");
			} else {
				usuarioVo.setNomUser(user);
				usuarioVo.setPassUser(pass);
				if(usuarioDao.addUser(usuarioVo)){
					JOptionPane.showMessageDialog(viewLogin, "Agregado");
				} else {
					viewLogin.setError("Usuario o password incorrectos");
				}
			}
			
		} else if (btn == viewAddUser.getBtnBack()) {
			viewAddUser.dispose();
			controllerLogin = new ControllerLogin(viewLogin, usuarioDao);
			viewLogin.setVisible(true);
			
		} else if (btn == viewMensajes.getBtnLogOut()){
			viewMensajes.dispose();
			controllerLogin = new ControllerLogin(viewLogin, usuarioDao);
			viewLogin.setVisible(true);
			
		} else if (btn == viewMensajes.getBtnSalir()) {
			System.exit(0);		
			
		} else if (btn == viewMensajes.getBtnAddMessage()) {
			String messaje = viewMensajes.getTxtAreaMess();
			if (messaje.equals("")) {
				viewMensajes.setError("Mensaje vacio");
			}else {	
				usuarioVo.setMensaje(messaje);
				usuarioDao.hora(usuarioVo);
				usuarioDao.fecha(usuarioVo);
				if (usuarioDao.addMessaje(usuarioVo)) {
					viewMensajes.setTxtAreapull(String.format("%s %s %s \n %s", usuarioVo.getNomUserArea(),usuarioVo.getFecha(),usuarioVo.getHora(),usuarioVo.getMensaje()));
				}	
			}				
		}
	}
	
	public void viewMensajes(){
		//viewMensajes.clearTxtAreaPull();
		ArrayList<UsuarioVo> bd = usuarioDao.mensajesbd();
		for (int i = 0; i <  bd.size(); i++) {
			viewMensajes.setTxtAreapull(String.format("%s %s %s \n %s", bd.get(i).getNomUser(),bd.get(i).getFecha(),bd.get(i).getHora(),bd.get(i).getMensaje()));
		}
	}

}
