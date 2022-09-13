package Forme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAL.CallOperaterDAL;
import DAL.KlijentDAL;
import Entity.KlijentEntitet;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FormaIzmeniKlijenta extends JFrame {

	private JPanel contentPane;
	private JTextField textIme;
	private JTextField textPrezime;
	private JTextField textTelefon;
	private JTextField textEmail;
	private JTextField textIDKlijenta;
	private JLabel lblIme;
	private JLabel lblPrezime;
	private JLabel lblTelefon;
	private JLabel lblEmail;
	private JLabel lblIDKlijenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaIzmeniKlijenta frame = new FormaIzmeniKlijenta();
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
	public FormaIzmeniKlijenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textIme = new JTextField();
		textIme.setBounds(29, 40, 238, 20);
		contentPane.add(textIme);
		textIme.setColumns(10);
		
		textPrezime = new JTextField();
		textPrezime.setBounds(29, 109, 238, 20);
		contentPane.add(textPrezime);
		textPrezime.setColumns(10);
		
		textTelefon = new JTextField();
		textTelefon.setBounds(29, 174, 238, 20);
		contentPane.add(textTelefon);
		textTelefon.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(29, 247, 238, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textIDKlijenta = new JTextField();
		textIDKlijenta.setBounds(29, 318, 238, 20);
		contentPane.add(textIDKlijenta);
		textIDKlijenta.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					 String ime=textIme.getText();
					 String prezime=textPrezime.getText();
					 String telefon=textTelefon.getText();
					 String email=textEmail.getText();
					 String ID=textIDKlijenta.getText();
					 		
					
					
					                //pravimo DAL klasu u kojoj se nalazi metoda koja dodaje operatera u bazu
					KlijentDAL dal=new KlijentDAL();	
									//pozivamo metoodu koja dodaje operatea, i dajemo joj vrednosti iz text polja
									//ovde  nisu korišæene promenljive da bi se uzela vrednost jer smo vrednost direkno stavljali 
									//konstruktor bez korišæenih promenjivih
					dal.Izmena(ID,ime,prezime,telefon,email);
								
								
									
									
									JOptionPane.showMessageDialog(null, "Uspesno dodato u bazu");
								
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							
							
							
			}
		});
		btnUpdate.setBounds(29, 397, 238, 34);
		contentPane.add(btnUpdate);
		
		lblIme = new JLabel("Ime");
		lblIme.setBounds(29, 15, 238, 14);
		contentPane.add(lblIme);
		
		lblPrezime = new JLabel("Prezime");
		lblPrezime.setBounds(29, 83, 238, 14);
		contentPane.add(lblPrezime);
		
		lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(29, 150, 238, 14);
		contentPane.add(lblTelefon);
		
		lblEmail = new JLabel("E mail");
		lblEmail.setBounds(29, 223, 238, 14);
		contentPane.add(lblEmail);
		
		lblIDKlijenta = new JLabel("ID Klijenta");
		lblIDKlijenta.setBounds(29, 293, 238, 14);
		contentPane.add(lblIDKlijenta);
	}
}
