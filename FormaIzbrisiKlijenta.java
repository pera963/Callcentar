package Forme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAL.KlijentDAL;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FormaIzbrisiKlijenta extends JFrame {

	
	private JPanel contentPane;
	private JTextField textIDKlijenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaIzbrisiKlijenta frame = new FormaIzbrisiKlijenta();
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
	public FormaIzbrisiKlijenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textIDKlijenta = new JTextField();
		textIDKlijenta.setBounds(40, 46, 165, 20);
		contentPane.add(textIDKlijenta);
		textIDKlijenta.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID Klijenta");
		lblNewLabel.setBounds(40, 21, 165, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnIzbrisiKlijenta = new JButton("IZBRI\u0160I KLIJENTA");
		btnIzbrisiKlijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		
					String ID=textIDKlijenta.getText();
			KlijentDAL dal=new KlijentDAL();
			dal.IzbrisiKlijenta(ID);
			
			JOptionPane.showMessageDialog(null, "Uspesno dodato u bazu");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnIzbrisiKlijenta.setBounds(40, 181, 165, 23);
		contentPane.add(btnIzbrisiKlijenta);
	}

}
