package me.silos.www;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.*;

public class VentanaDespacharArina extends JFrame implements ActionListener{
	
	
	public static int cantidadPedido; 
	public static String cantidadArinaPedido; 
	public static int cantidadFaltante; 
	
	JPanel pnlContenido = new JPanel(null); 
	JLabel lblCantidadArina; 
	JTextField txtCantidadArina; 
	JButton btnDespacharArina; 
	
	Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	public VentanaDespacharArina()
	{
		setTitle("Despachar Arina"); 
		setSize(pantalla.width / 2, pantalla.height /2); 
		setLocation(pantalla.width/2 - (pantalla.width/4),pantalla.height/2 - (pantalla.height/4));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lblCantidadArina = new JLabel("Cantidad del pedido"); 
		txtCantidadArina = new JTextField(); 
		btnDespacharArina = new JButton("Listo");
		lblCantidadArina.setBounds(20, 20, 120, 20);
		txtCantidadArina.setBounds(170, 20, 100, 20);
		btnDespacharArina.setBounds(150, 80, 120, 30);
		btnDespacharArina.addActionListener(this);
		pnlContenido.add(lblCantidadArina);
		pnlContenido.add(txtCantidadArina);
		pnlContenido.add(btnDespacharArina);
		setContentPane(pnlContenido);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnDespacharArina)
		{
			cantidadArinaPedido = txtCantidadArina.getText(); 
			cantidadPedido = Integer.parseInt(cantidadArinaPedido); 
			if(VentanaPrincipal.contadorSilosCreados == 1)
			{
				if(cantidadPedido > VentanaCrearSilos.existenciaSilo1)
				{
					JOptionPane.showMessageDialog(null, "Arina insuficiente, debes crear otro silo");
				}
				else if(cantidadPedido <= VentanaCrearSilos.existenciaSilo1)
				{
					VentanaCrearSilos.existenciaSilo1 -= cantidadPedido; 
					JOptionPane.showMessageDialog(null, "Pedido realizado satisfactoriamente");
				}
			}
			else if(VentanaPrincipal.contadorSilosCreados == 2)
			{
				if(cantidadPedido > VentanaCrearSilos.existenciaSilo1 + VentanaCrearSilos.existenciaSilo2)
				{
					JOptionPane.showMessageDialog(null, "Arina insuficiente");
				}
				else
				{
					if(cantidadPedido <= VentanaCrearSilos.existenciaSilo1)
					{
						VentanaCrearSilos.existenciaSilo1 -= cantidadPedido; 
						JOptionPane.showMessageDialog(null, "Pedido realizado satisfactoriamente");
					}
					else if(cantidadPedido > VentanaCrearSilos.existenciaSilo1) 
					{
						cantidadFaltante = cantidadPedido - VentanaCrearSilos.existenciaSilo1; 
						VentanaCrearSilos.existenciaSilo1 = 0; 
						VentanaCrearSilos.existenciaSilo2 -= cantidadFaltante; 
						JOptionPane.showMessageDialog(null, "Pedido realizado satisfactoriamente");
					}
				}
			}
			setVisible(false);
		}
		
	}

}
