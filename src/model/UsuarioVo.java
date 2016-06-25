package model;

public class UsuarioVo {
	
	private static int idUser;
	private String nomUser;
	private static String nomUserArea;
	private String passUser;
	private String fecha;
	private String hora;
	private String mensaje;
	
	public UsuarioVo(){}
	
	public UsuarioVo(String nomUser, String mensaje, String fecha, String hora) {
		this.nomUser = nomUser;
		this.fecha = fecha;
		this.hora = hora;
		this.mensaje = mensaje;
	}
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNomUser() {
		return nomUser;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	public String getNomUserArea() {
		return nomUserArea;
	}

	public void setNomUserArea(String nomUserArea) {
		this.nomUserArea = nomUserArea;
	}
	public String getPassUser() {
		return passUser;
	}
	public void setPassUser(String passUser) {
		this.passUser = passUser;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
