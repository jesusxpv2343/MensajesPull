package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;



public class UsuarioDao {
	private String consulta = null;
	private PreparedStatement pstmt = null;
	private ResultSet resultado = null;
	private boolean verificacion = false;
	
	Calendar calendario;
	
	
	private ArrayList<UsuarioVo> datosBD = new ArrayList<UsuarioVo>();
	Conexion conex = Conexion.getConexion();
	
	public UsuarioDao() {}
	
	
	
	public boolean verifyUser(UsuarioVo usuarioVo){
		try {
			verificacion = false;
			consulta = "select * from usuario where nomUSer = ? and passUser = ?";
			pstmt = conex.getConex().prepareStatement(consulta);
			pstmt.setString(1, usuarioVo.getNomUser());
			pstmt.setString(2, usuarioVo.getPassUser());
			resultado = pstmt.executeQuery();
			while (resultado.next()) {
				if(resultado.getString(2).equals(usuarioVo.getNomUser()) && resultado.getString(3).equals(usuarioVo.getPassUser())){
					usuarioVo.setIdUser(resultado.getInt(1));
					usuarioVo.setNomUserArea(resultado.getString(2));
					verificacion = true;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()+" Verify user");
			verificacion = false;
		}	
		return verificacion;
	}
	
	public boolean addUser(UsuarioVo usuarioVo){
		try {
			consulta = "insert into usuario values(null,?,?)";
			pstmt = conex.getConex().prepareStatement(consulta);
			pstmt.setString(1, usuarioVo.getNomUser());
			pstmt.setString(2, usuarioVo.getPassUser());
			if(pstmt.executeUpdate() == 1){
				verificacion = true;
			}else{
				verificacion = false;			
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()+" addUser");
			verificacion = false;
		}
		return verificacion;
	}
	
	public boolean addMessaje(UsuarioVo usuarioVo){
		try {
			consulta = "insert into mensajes values(null, ?, ?, ?, ? )";
			pstmt = conex.getConex().prepareStatement(consulta);
			pstmt.setString(1, usuarioVo.getMensaje());
			pstmt.setString(2, usuarioVo.getFecha());
			pstmt.setString(3, usuarioVo.getHora());
			pstmt.setInt(4, usuarioVo.getIdUser());
			if(pstmt.executeUpdate() == 1){
				verificacion = true;
			}else{
				verificacion = false;			
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()+" add mensaje");
		}
		return verificacion;
	}
	
	public ArrayList<UsuarioVo> mensajesbd(){
		try {
			consulta = "select nomUser,mensaje,fecha,hora from usuario inner join mensajes where usuario.idUser=mensajes.idUser order by fecha asc,hora asc";
			pstmt = conex.getConex().prepareStatement(consulta);
			resultado = pstmt.executeQuery();
			while (resultado.next()) {
				datosBD.add(new UsuarioVo(resultado.getString(1),resultado.getString(2),resultado.getString(3), resultado.getString(4) ));				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()+"datos generales bd");
		}
		return datosBD;
	}
	
	public void fecha(UsuarioVo usuarioVo){
		calendario =  Calendar.getInstance();
		String dia = Integer.toString(calendario.get(Calendar.DATE));
		String mes = Integer.toString(calendario.get(Calendar.MONTH)+1);
		String anio = Integer.toString(calendario.get(Calendar.YEAR));
		usuarioVo.setFecha(String.format("%s-%s-%s", anio,mes, dia));
	}
	
	public void hora(UsuarioVo usuarioVo){
		calendario =  Calendar.getInstance();
		String hora = Integer.toString(calendario.get(Calendar.HOUR_OF_DAY));
		String min = Integer.toString(calendario.get(Calendar.MINUTE));
		String seg = Integer.toString(calendario.get(Calendar.SECOND));
		usuarioVo.setHora(String.format("%s:%s:%s", hora,min, seg));	
	}
	
}
