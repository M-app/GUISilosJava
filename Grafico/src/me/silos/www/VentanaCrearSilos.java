package me.silos.www;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaCrearSilos extends JFrame implements ActionListener{
	JPanel pnlContenido = new JPanel(null); 
	JButton btnSiloCreado; 
	JLabel lblNombreSilo; 
	JLabel lblExistenciaSilo;
	JTextField txtNombreSilo; 
	Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	
	VentanaPrincipal ventanaPrincipal; 
	
	public static String nombreSilo1, nombreSilo2; 
	public static int existenciaSilo1, existenciaSilo2; 
	
	public VentanaCrearSilos()
	{
		setTitle("Creación de Silos");
		setSize(pantalla.width/2,pantalla.height/2);
		setLocation(pantalla.width/2 - (pantalla.width/4),pantalla.height/2 - (pantalla.height/4));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		lblNombreSilo = new JLabel("Nombre del Silo"); 
		lblExistenciaSilo = new JLabel("La existencia es 20"); 
		txtNombreSilo = new JTextField(40);
		btnSiloCreado = new JButton("Crear Nuevo Silo");
		lblNombreSilo.setBounds(150, 10, 150, 20);
		lblExistenciaSilo.setBounds(225, 50, 300, 20);
		txtNombreSilo.setBounds(300, 10, 200, 20);
		btnSiloCreado.setBounds(275,150,150,30);
		pnlContenido.add(lblNombreSilo);
		pnlContenido.add(lblExistenciaSilo);
		pnlContenido.add(txtNombreSilo);
		pnlContenido.add(btnSiloCreado);
		btnSiloCreado.addActionListener(this);
		setContentPane(pnlContenido);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSiloCreado && VentanaPrincipal.contadorSilosCreados == 1)
		{
			nombreSilo1 = txtNombreSilo.getText(); 
			existenciaSilo1 = 20; 
			JOptionPane.showMessageDialog(null, "Silo creado correctamente");
			this.setVisible(false);
		}
		else if(e.getSource() == btnSiloCreado && VentanaPrincipal.contadorSilosCreados == 2)
		{
			nombreSilo2 = txtNombreSilo.getText(); 
			existenciaSilo2 = 20; 
			JOptionPane.showMessageDialog(null, "Silo creado correctamente");
			this.setVisible(false);
		}
		
	}
}
