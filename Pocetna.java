package Forme;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Pocetna extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pocetna frame = new Pocetna();
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
	public Pocetna() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOperater = new JButton("Call operateri");
		btnOperater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//kada kliknem na dugme, otvaramo novu formu, tj. formu call operateri
				FormaCallOperateri frm;
				try {
					frm = new FormaCallOperateri();
					frm.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnOperater.setBounds(25, 21, 124, 45);
		contentPane.add(btnOperater);
		
		JButton btnKlijent = new JButton("Klijenti");
		btnKlijent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				FormaKlijent fkm;
				try {
					fkm = new FormaKlijent();
					fkm.setVisible(true);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}
		});
		btnKlijent.setBounds(173, 21, 124, 45);
		contentPane.add(btnKlijent);
		
		JButton btnPozivi = new JButton("Pozivi");
		btnPozivi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				FormePozivi poz;
				poz = new FormePozivi();
				poz.setVisible(true);
			
			
			
			}
		});
		btnPozivi.setBounds(315, 21, 124, 45);
		contentPane.add(btnPozivi);
	}
}
