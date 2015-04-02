package me.silos.www;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.*;

public class VentanaVerExistencia extends JFrame implements ActionListener{
	
	VentanaCrearSilos ventanaCrearSilos; 
	
	JLabel lblnombreSilo1, lblnombreSilo2, lblexistenciaSilo1, lblexistenciaSilo2; 
	JButton btnRegresar;
	PanelDibujo pnlContenido = new PanelDibujo();
	Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	public VentanaVerExistencia()
	{
		setTitle("Ver Existencias"); 
		setSize(pantalla.width/2,pantalla.height/2); 
		setLocation(pantalla.width/2 - (pantalla.width/4),pantalla.height/2 - (pantalla.height/4));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		pnlContenido.setLayout(null);
		lblnombreSilo1 = new JLabel(VentanaCrearSilos.nombreSilo1); 
		lblnombreSilo2 = new JLabel(VentanaCrearSilos.nombreSilo2);
		lblexistenciaSilo1 = new JLabel(Integer.toString(VentanaCrearSilos.existenciaSilo1));
		lblexistenciaSilo2 = new JLabel(Integer.toString(VentanaCrearSilos.existenciaSilo2));
		lblnombreSilo1.setBounds(100, 20, 100, 20);
		lblnombreSilo2.setBounds(425, 20, 100, 20);
		lblexistenciaSilo1.setBounds(220, 20, 40, 20);
		lblexistenciaSilo2.setBounds(550, 20, 40, 20);
		btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(280, 100, 100, 30);
		btnRegresar.addActionListener(this);
		pnlContenido.add(lblnombreSilo1);
		pnlContenido.add(lblnombreSilo2);
		pnlContenido.add(lblexistenciaSilo1);
		pnlContenido.add(lblexistenciaSilo2);
		pnlContenido.add(btnRegresar); 
		setContentPane(pnlContenido);
		setVisible(true);
	}
	
	public class PanelDibujo extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			setBackground(Color.WHITE);
			if(VentanaPrincipal.contadorSilosCreados == 1)
			{
				g.setColor(Color.MAGENTA);
				g.fillRect(100, 75, 30, 150);
			}
			else if(VentanaPrincipal.contadorSilosCreados == 2)
			{
				g.setColor(Color.MAGENTA);
				g.fillRect(100, 75, 30, 150);
				g.setColor(Color.CYAN);
				g.fillRect(425, 75, 30, 150);
			}
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRegresar)
		{
			setVisible(false);
		}
		
	}
	

}
