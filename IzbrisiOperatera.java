package Forme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAL.CallOperaterDAL;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class IzbrisiOperatera extends JFrame {

	private JPanel contentPane;
	private JTextField textIDOperatera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzbrisiOperatera frame = new IzbrisiOperatera();
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
	public IzbrisiOperatera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textIDOperatera = new JTextField();
		textIDOperatera.setBounds(46, 37, 121, 20);
		contentPane.add(textIDOperatera);
		textIDOperatera.setColumns(10);
		
		JLabel lbl = new JLabel("ID OPERATERA");
		lbl.setBounds(46, 11, 121, 14);
		contentPane.add(lbl);
		
		JButton btnDelete = new JButton("IZBRI\u0160I OPERATERA");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		try {	
				String ID=textIDOperatera.getText();
				
				CallOperaterDAL dal=new CallOperaterDAL();	
				
				dal.IzbrisiKoloperatera(ID);
			
			
				
				
				JOptionPane.showMessageDialog(null, "Uspesno dodato u bazu");
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}		
		});
		btnDelete.setBounds(46, 135, 191, 23);
		contentPane.add(btnDelete);
	}
}
