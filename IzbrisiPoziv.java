package Forme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAL.CallOperaterDAL;
import DAL.KlijentDAL;
import DAL.PoziviDAL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class IzbrisiPoziv extends JFrame {

	private JPanel contentPane;
	private JTextField textIDPoziva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzbrisiPoziv frame = new IzbrisiPoziv();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IzbrisiPoziv() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIDPoziva = new JLabel("ID Poziva");
		lblIDPoziva.setBounds(31, 11, 140, 14);
		contentPane.add(lblIDPoziva);
		
		textIDPoziva = new JTextField();
		textIDPoziva.setBounds(26, 36, 161, 20);
		contentPane.add(textIDPoziva);
		textIDPoziva.setColumns(10);
		
		JButton btnIzbrisiPoziv = new JButton("IZBRISI POZIV");
		btnIzbrisiPoziv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					
			String ID=textIDPoziva.getText();
			PoziviDAL dal=new PoziviDAL();
			dal.IzbrisiPoziva(ID);
			
			JOptionPane.showMessageDialog(null, "Uspesno dodato u bazu");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
				
			
			
			}
		});
		btnIzbrisiPoziv.setBounds(31, 176, 156, 23);
		contentPane.add(btnIzbrisiPoziv);
	}
}
