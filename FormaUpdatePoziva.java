package Forme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAL.KlijentDAL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FormaUpdatePoziva extends JFrame {

	private JPanel contentPane;
	private JTextField textIDOperatera;
	private JTextField textIDKlijenta;
	private JTextField textOdgovor_Klijenata;
	private JTextField textDatum_Poziva;
	private JLabel lblIDPoziva;
	private JTextField textIDPoziva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaUpdatePoziva frame = new FormaUpdatePoziva();
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
	public FormaUpdatePoziva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIDOperatera = new JLabel("IDOperatera");
		lblIDOperatera.setBounds(23, 11, 211, 14);
		contentPane.add(lblIDOperatera);
		
		textIDOperatera = new JTextField();
		textIDOperatera.setBounds(23, 36, 241, 20);
		contentPane.add(textIDOperatera);
		textIDOperatera.setColumns(10);
		
		JLabel lblIDKlijenta = new JLabel("IDKlijenta");
		lblIDKlijenta.setBounds(23, 91, 241, 14);
		contentPane.add(lblIDKlijenta);
		
		textIDKlijenta = new JTextField();
		textIDKlijenta.setBounds(23, 116, 241, 20);
		contentPane.add(textIDKlijenta);
		textIDKlijenta.setColumns(10);
		
		JLabel lblOdgovor_Klijenata = new JLabel("Odgovor Klijenata");
		lblOdgovor_Klijenata.setBounds(23, 175, 241, 14);
		contentPane.add(lblOdgovor_Klijenata);
		
		textOdgovor_Klijenata = new JTextField();
		textOdgovor_Klijenata.setBounds(23, 200, 241, 20);
		contentPane.add(textOdgovor_Klijenata);
		textOdgovor_Klijenata.setColumns(10);
		
		JLabel lblDatum_Poziva = new JLabel("Datum_Poziva");
		lblDatum_Poziva.setBounds(23, 266, 241, 14);
		contentPane.add(lblDatum_Poziva);
		
		textDatum_Poziva = new JTextField();
		textDatum_Poziva.setBounds(20, 291, 244, 20);
		contentPane.add(textDatum_Poziva);
		textDatum_Poziva.setColumns(10);
		
		JButton btnUpdatePoziva = new JButton("UPDATE  POZIVA");
		btnUpdatePoziva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				     String idoperatera=textIDOperatera.getText();
					 String idklijenta=textIDKlijenta.getText();
					 String odgovor_klijenata=textOdgovor_Klijenata.getText();
					 String datum_poziva=textDatum_Poziva.getText();
					 String idpoziva=textIDPoziva.getText();
			          //pravimo DAL klasu u kojoj se nalazi metoda koja dodaje operatera u bazu
					KlijentDAL dal=new KlijentDAL();	
									//pozivamo metoodu koja dodaje operatea, i dajemo joj vrednosti iz text polja
									//ovde  nisu korišæene promenljive da bi se uzela vrednost jer smo vrednost direkno stavljali 
									//konstruktor bez korišæenih promenjivih
					dal.Izmena(idoperatera,idklijenta,odgovor_klijenata,datum_poziva,idpoziva);
													
									JOptionPane.showMessageDialog(null, "Uspesno dodato u bazu");
								
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
		});
		btnUpdatePoziva.setBounds(23, 406, 241, 23);
		contentPane.add(btnUpdatePoziva);
		
		lblIDPoziva = new JLabel("IDPoziva");
		lblIDPoziva.setBounds(23, 341, 241, 14);
		contentPane.add(lblIDPoziva);
		
		textIDPoziva = new JTextField();
		textIDPoziva.setBounds(23, 363, 241, 20);
		contentPane.add(textIDPoziva);
		textIDPoziva.setColumns(10);
	}
}
