package me.silos.www;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class VentanaPrincipal extends JFrame implements ActionListener{

	JPanel pnlContenido; 
	JLabel lblTituloPrograma; 
	JButton btnCrearSilo, btnVerExistencia, btnDespacharArina; 
	public static int contadorSilosCreados = 0; 
	public VentanaPrincipal()
	{
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int anchoPantalla = pantalla.width; 
		int altoPantalla = pantalla.height;
		setTitle("Empresa de Silos"); 
		setSize(pantalla.width,pantalla.height); // asigna a el tamaño del JFrame a todo el ancho de la pantalla
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pnlContenido = new JPanel(null);
		lblTituloPrograma = new JLabel("Silos");
		btnCrearSilo = new JButton("Crear Silo"); 
		btnVerExistencia = new JButton("Ver Existencia");
		btnDespacharArina = new JButton("Despachar Arina");
		lblTituloPrograma.setBounds(anchoPantalla/2-25, 100, 50, 50);
		btnCrearSilo.setBounds(anchoPantalla/2-75, 200, 150, 30);
		btnVerExistencia.setBounds(anchoPantalla/2-75, 280, 150, 30);
		btnDespacharArina.setBounds(anchoPantalla/2-75, 360, 150, 30);
		pnlContenido.add(lblTituloPrograma);
		pnlContenido.add(btnCrearSilo);
		pnlContenido.add(btnVerExistencia);
		pnlContenido.add(btnDespacharArina); 
		btnCrearSilo.addActionListener(this);
		btnVerExistencia.addActionListener(this);
		btnDespacharArina.addActionListener(this);
		setContentPane(pnlContenido);
		setVisible(true);
	}
	public int NumeroDeSilosCreados()
	{
		return contadorSilosCreados;
	}
	
	public static void main(String[] args) {
	 VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCrearSilo && contadorSilosCreados == 0)
		{
			VentanaCrearSilos ventanaCrearSilos = new VentanaCrearSilos(); 
			contadorSilosCreados++; 
		}
		else if(e.getSource() == btnCrearSilo && contadorSilosCreados == 1)
		{
			VentanaCrearSilos ventanaCrearSilos = new VentanaCrearSilos(); 
			contadorSilosCreados++; 
		}
		else if(e.getSource() == btnCrearSilo && contadorSilosCreados == 2)
		{
			JOptionPane.showMessageDialog(null, "No puedes crear silos");
		}
		else if(e.getSource() == btnVerExistencia && contadorSilosCreados == 0)
		{
			JOptionPane.showMessageDialog(null, "Debes crear un silo");
		}
		else if(e.getSource() == btnVerExistencia && contadorSilosCreados > 0)
		{
			VentanaVerExistencia ventanaVerExistencia = new VentanaVerExistencia();
		}
		else if(e.getSource() == btnDespacharArina && contadorSilosCreados == 0)
		{
			JOptionPane.showMessageDialog(null, "No hay silos creados");
		}
		else if(e.getSource() == btnDespacharArina && contadorSilosCreados == 1 )
		{
			VentanaDespacharArina ventanaDespacharArina = new VentanaDespacharArina();
		}
		else if(e.getSource() == btnDespacharArina && contadorSilosCreados == 2 )
		{
			VentanaDespacharArina ventanaDespacharArina = new VentanaDespacharArina();
		}
		
	}

}
