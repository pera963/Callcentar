package Forme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAL.CallOperaterDAL;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FormaDodavanjeOperatera extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel content;
	private JTextField txtime;
	private JTextField textPrezime;
	private JTextField textTelefon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaDodavanjeOperatera frame = new FormaDodavanjeOperatera();
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
	public FormaDodavanjeOperatera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 409);
		content = new JPanel();
		content.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(content);
		content.setLayout(null);
		
		txtime = new JTextField();
		txtime.setBounds(48, 56, 259, 20);
		content.add(txtime);
		txtime.setColumns(10);
		
		JButton btnDodaj_Operatera = new JButton("DODAJ OPERATERA");
		btnDodaj_Operatera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//pravimo DAL klasu u kojoj se nalazi metoda koja dodaje operatera u bazu
					CallOperaterDAL dal=new CallOperaterDAL();	
					//pozivamo metoodu koja dodaje operatea, i dajemo joj vrednosti iz text polja
					//ovde  nisu korišæene promenljive da bi se uzela vrednost jer smo vrednost direkno stavljali 
					//konstruktor bez korišæenih promenjivih
					dal.DodajOperatera(txtime.getText(), textPrezime.getText(), textTelefon.getText());
				
					JOptionPane.showMessageDialog(null, "Uspesno dodato u bazu");
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnDodaj_Operatera.setBounds(48, 322, 265, 23);
		content.add(btnDodaj_Operatera);
		
		textPrezime = new JTextField();
		textPrezime.setBounds(48, 142, 259, 20);
		content.add(textPrezime);
		textPrezime.setColumns(10);
		
		textTelefon = new JTextField();
		textTelefon.setBounds(48, 234, 259, 20);
		content.add(textTelefon);
		textTelefon.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ime operatera");
		lblNewLabel.setBounds(48, 34, 259, 14);
		content.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prezime operatera");
		lblNewLabel_1.setBounds(48, 119, 259, 14);
		content.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefon operatera");
		lblNewLabel_2.setBounds(48, 211, 259, 14);
		content.add(lblNewLabel_2);
	}
}
