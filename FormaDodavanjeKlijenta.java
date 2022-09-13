package Forme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAL.KlijentDAL;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FormaDodavanjeKlijenta extends JFrame {

	private JPanel contentPane;
	private JTextField textIme;
	private JTextField textPrezime;
	private JTextField textTelefon;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaDodavanjeKlijenta frame = new FormaDodavanjeKlijenta();
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
	public FormaDodavanjeKlijenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textIme = new JTextField();
		textIme.setBounds(59, 31, 234, 20);
		contentPane.add(textIme);
		textIme.setColumns(10);
		
		textPrezime = new JTextField();
		textPrezime.setBounds(59, 115, 234, 20);
		contentPane.add(textPrezime);
		textPrezime.setColumns(10);
		
		textTelefon = new JTextField();
		textTelefon.setBounds(59, 204, 234, 20);
		contentPane.add(textTelefon);
		textTelefon.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(59, 291, 234, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("DODAJ  KLIJENTA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	 try {
		 
		 String ime=textIme.getText();
		 String prezime=textPrezime.getText();
		 String telefon=textTelefon.getText();
		 String email=textEmail.getText();
		 
		 KlijentDAL dal= new KlijentDAL(); // pravljenje Objekta KlijentDAL,kako bismo mogli da pozovemo metodu za dodavanje klijenta 
	     dal.DodajKlijenta(ime, prezime, telefon, email);//poziva metodu za dodavanje klijenta i klijenti su automatski dodati u bazu
		
		 JOptionPane.showMessageDialog(null, "Uspešno dodato u bazu");
		 } catch (SQLException e1) {
			
			e1.printStackTrace();
		}
				 
			
			}
		});
		btnNewButton.setBounds(59, 392, 234, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Ime klijenta");
		lblNewLabel.setBounds(59, 11, 234, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prezime klijenta");
		lblNewLabel_1.setBounds(59, 91, 234, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefon klijenta");
		lblNewLabel_2.setBounds(59, 175, 234, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("E - mail  klijenta");
		lblNewLabel_3.setBounds(59, 266, 234, 14);
		contentPane.add(lblNewLabel_3);
	}
}
