package view;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ViewAddUser extends JFrame{
private Container c = getContentPane();
	
	private JLabel lbUser = new JLabel("Usuario");
	private JTextField txtUser = new JTextField();
	private JLabel lbPass = new JLabel("Password");
	private JPasswordField txtPass = new JPasswordField();
	private JButton btnAdd = new JButton("Agregar");
	private JButton btnBack = new JButton("Regresar");
	
	public ViewAddUser() {
		super.setTitle("Usuario");
		super.setSize(200, 300);
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		c.setLayout(null);
		contenido();
	}
	
	private void contenido() {
		lbUser.setBounds(10, 10, 180, 20);
		txtUser.setBounds(10, 35, 180, 25);
		lbPass.setBounds(10, 80, 180, 20);
		txtPass.setBounds(10, 105, 180, 25);
		btnAdd.setBounds(10, 170, 180, 35);
		btnBack.setBounds(10, 220, 180, 35);
		
		
		c.add(lbUser);
		c.add(txtUser);
		c.add(lbPass);
		c.add(txtPass);
		c.add(btnAdd);
		c.add(btnBack);
		
	}

	public String getTxtUser() {
		return txtUser.getText();
	}

	public String getTxtPass() {
		return new String(txtPass.getPassword());
	}


	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(ActionListener e) {
		this.btnAdd.addActionListener(e);
	}

	
	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(ActionListener e) {
		this.btnBack.addActionListener(e);
	}

	public void setError(String error){
		JOptionPane.showMessageDialog(this, error, "Titulo", JOptionPane.ERROR_MESSAGE);
	}
	

}
