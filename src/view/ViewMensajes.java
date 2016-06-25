package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Font;

import javax.swing.ScrollPaneConstants;


public class ViewMensajes extends JFrame{
	
	
	
	
	private Container c = getContentPane();
	
	//JPanel borderlaoutpanel = new JPanel();
    //JPanel columnpanel = new JPanel();
	private JMenuBar menuBar = new JMenuBar();    
    private JMenu mnFile = new JMenu("File");
    
	private JLabel lbMensaje = new JLabel("Mensaje");
	private JScrollPane scroll;
	private JTextArea txtAreaMess = new JTextArea();
	private JTextArea txtAreapull = new JTextArea();
	private JButton btnAddMessage = new JButton("Enviar");
	private final JMenuItem mntmCerrarSeson = new JMenuItem("Cerrar sesión");
	private final JMenuItem mntmSalir = new JMenuItem("Salir");
	
	
	public ViewMensajes() {
		super.setSize(320,480);
		super.setTitle("User");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		
		
		contenido();
	}


	private void contenido() {
		c.setLayout(null);
		
		menuBar.setBounds(0, 0, 320, 20);
        menuBar.add(mnFile);
        mntmCerrarSeson.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.ALT_MASK));
        mnFile.add(mntmCerrarSeson);
        mnFile.add(mntmSalir);
        c.add(menuBar);
        
		lbMensaje.setBounds(10,31, 100, 20);
		c.add(lbMensaje);
		
		scroll = new JScrollPane();
		scroll.setBounds(10, 50, 295, 60);
		scroll.setViewportView(txtAreaMess);
		c.add(scroll);
		
		btnAddMessage.setBounds(205,120,100,25);
		c.add(btnAddMessage);
		
		
		scroll = new JScrollPane();
		scroll.setEnabled(false);
		txtAreapull.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtAreapull.setForeground(Color.DARK_GRAY);
		scroll.setViewportView(txtAreapull);
		txtAreapull.setEditable(false);
		scroll.setBounds(10, 171, 295, 270);
		c.add(scroll);
		
		/*
		scroll = new JScrollPane();
		scroll.setBounds(10, 171, 295, 270);
		c.add(scroll);
		
		borderlaoutpanel = new JPanel();
		scroll.setViewportView(borderlaoutpanel);
        borderlaoutpanel.setLayout(new BorderLayout(0, 0));
       
        columnpanel = new JPanel();
        borderlaoutpanel.add(columnpanel,BorderLayout.NORTH);
        columnpanel.setLayout(new GridLayout(0, 1, 0, 1));
        columnpanel.setBackground(Color.gray);
                
        int a = 0;
		int b = 20;
		
        for (int i = 0; i < 10; i++) {
        	JPanel rowPanel = new JPanel();
			rowPanel.setPreferredSize(new Dimension(275,90));
			columnpanel.add(rowPanel);
            rowPanel.setLayout(null);
				
			JLabel abc = new JLabel("Jesusxpv");//nombre
			abc.setBounds(10, 5, 100, 20);
			rowPanel.add(abc);
			
			JLabel abc2 = new JLabel("fecha");//marca
			abc2.setBounds(100, 5, 50, 20);
			rowPanel.add(abc2);
			
			JLabel abc3 = new JLabel("hora");//precio
			abc3.setBounds(150, 5, 50, 20);
			rowPanel.add(abc3);
			
			scroll = new JScrollPane();
			scroll.setBounds(10, 25, 255, 50);
			
			JTextArea txtArea = new JTextArea();
			scroll.setViewportView(txtArea);
			rowPanel.add(scroll);
			
			if(i%2==0)
               rowPanel.setBackground(SystemColor.inactiveCaptionBorder);
		}
		*/
	}

	
	public String getTxtAreaMess() {
		return txtAreaMess.getText().trim();
	}

	public void clearTxtAreaPull(){
		this.txtAreapull.removeAll();
	}
	public void setTxtAreapull(String txtAreapull) {
		this.txtAreapull.append(txtAreapull+" \n\n");
	}

	public JButton getBtnAddMessage() {
		return btnAddMessage;
	}

	public void setBtnAddMessage(ActionListener e) {
		this.btnAddMessage.addActionListener(e);
	}

	public JMenuItem getBtnLogOut() {
		return mntmCerrarSeson;
	}
	public void setBtnLogOut(ActionListener e) {
		mntmCerrarSeson.addActionListener(e);
	}

	public JMenuItem getBtnSalir() {
		return mntmSalir;
	}

	public void setBtnSalir(ActionListener e) {
		mntmSalir.addActionListener(e);
	}
	
	public void setError(String error){
		JOptionPane.showMessageDialog(this, error, "Titulo", JOptionPane.ERROR_MESSAGE);
	}
	
	
	

}