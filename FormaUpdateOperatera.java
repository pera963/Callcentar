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

public class FormaUpdateOperatera extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaUpdateOperatera frame = new FormaUpdateOperatera();
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
	public FormaUpdateOperatera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(32, 41, 280, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(32, 123, 280, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(32, 209, 280, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("UPDATE OPERATERA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
	 String ime=textField.getText();
	 String prezime=textField_1.getText();
	 String telefon=textField_2.getText();
	 String ID=textField_3.getText();
	 		
	
	
	                //pravimo DAL klasu u kojoj se nalazi metoda koja dodaje operatera u bazu
					CallOperaterDAL dal=new CallOperaterDAL();	
					//pozivamo metoodu koja dodaje operatea, i dajemo joj vrednosti iz text polja
					//ovde  nisu korišæene promenljive da bi se uzela vrednost jer smo vrednost direkno stavljali 
					//konstruktor bez korišæenih promenjivih
					dal.Izmena(ID,ime,prezime,telefon);
				
				
					
					
					JOptionPane.showMessageDialog(null, "Uspesno dodato u bazu");
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			
			
			}
		});
		btnNewButton.setBounds(32, 355, 280, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("ime operatera");
		lblNewLabel.setBounds(32, 11, 280, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("prezime operatera");
		lblNewLabel_1.setBounds(32, 95, 280, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("telefon operatera");
		lblNewLabel_2.setBounds(32, 177, 280, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID operatera");
		lblNewLabel_3.setBounds(32, 263, 280, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(32, 298, 280, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}
}
