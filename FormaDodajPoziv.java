package Forme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAL.KlijentDAL;
import DAL.PoziviDAL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FormaDodajPoziv extends JFrame {

	private JPanel contentPane;
	private JTextField textIDOperatera;
	private JTextField textIDKlijenta;
	private JTextField textOdgovor_Klijenata;
	private JTextField textDatum_Poziva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaDodajPoziv frame = new FormaDodajPoziv();
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
	public FormaDodajPoziv() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIDOperatera = new JLabel("ID Operatera");
		lblIDOperatera.setBounds(22, 22, 192, 14);
		contentPane.add(lblIDOperatera);
		
		JLabel lblIDKlijenta = new JLabel("ID Klijenta");
		lblIDKlijenta.setBounds(22, 106, 192, 14);
		contentPane.add(lblIDKlijenta);
		
		JLabel lblNewLabel_2 = new JLabel("Odgovor Klijenata");
		lblNewLabel_2.setBounds(22, 205, 192, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Datum Poziva");
		lblNewLabel_3.setBounds(22, 299, 192, 14);
		contentPane.add(lblNewLabel_3);
		
		textIDOperatera = new JTextField();
		textIDOperatera.setBounds(22, 42, 243, 20);
		contentPane.add(textIDOperatera);
		textIDOperatera.setColumns(10);
		
		textIDKlijenta = new JTextField();
		textIDKlijenta.setBounds(22, 131, 243, 20);
		contentPane.add(textIDKlijenta);
		textIDKlijenta.setColumns(10);
		
		textOdgovor_Klijenata = new JTextField();
		textOdgovor_Klijenata.setBounds(22, 230, 243, 20);
		contentPane.add(textOdgovor_Klijenata);
		textOdgovor_Klijenata.setColumns(10);
		
		textDatum_Poziva = new JTextField();
		textDatum_Poziva.setBounds(22, 324, 243, 20);
		contentPane.add(textDatum_Poziva);
		textDatum_Poziva.setColumns(10);
		
		JButton btnDodajPoziv = new JButton("DODAJ  POZIV");
		btnDodajPoziv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					 
					 String IDOperatera=textIDOperatera.getText();
					 String IDKlijenta=textIDKlijenta.getText();
					 String Odgovor_Klijenata=textOdgovor_Klijenata.getText();
					 String Datum_Poziva=textDatum_Poziva.getText();
					 
					PoziviDAL poz= new PoziviDAL(); // pravljenje Objekta KlijentDAL,kako bismo mogli da pozovemo metodu za dodavanje klijenta 
				     poz.DodajPoziv(IDOperatera, IDKlijenta, Odgovor_Klijenata, Datum_Poziva);//poziva metodu za dodavanje klijenta i klijenti su automatski dodati u bazu
					
					 JOptionPane.showMessageDialog(null, "Uspešno dodato u bazu");
					 } catch (SQLException e1) {
						
						e1.printStackTrace();
					}
			
			}
		});
		btnDodajPoziv.setBounds(22, 383, 243, 23);
		contentPane.add(btnDodajPoziv);
	}

}
