package Forme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAL.KlijentDAL;
import Entity.KlijentEntitet;

import javax.swing.JTabbedPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class FormaKlijent extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public String[] koloneTabele = { "Ime", "Prezime", "Telefon", "Email" };
	public DefaultTableModel tblModel;
	public JList listaPrikaz;
	private JButton btnDelete;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaKlijent frame = new FormaKlijent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	//ovde popunjavamo listu iz baze.
	public void popuniListuSaPodacima() throws SQLException {
		
		//kreiramo DAL
		KlijentDAL dal=new KlijentDAL();
		
		//uzimam listu klijenata iz dala
		ArrayList<KlijentEntitet> listatemp=dal.dajSveKlijente();	//  neznam kako ovo???????
		//sluzi nam za punjenje Jliste
		DefaultListModel listModel = new DefaultListModel();
		
		//ovde prelazimo preko liste i punimo model iz liste klienata
		for(int i=0; i<listatemp.size();i++) {
			
			listModel.addElement(listatemp.get(i));
			
		}
		//postavljamo podatke na Jlistu klijenata
		listaPrikaz.setModel(listModel);
		
	}
	
	public FormaKlijent() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Dodaj novog klijenta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				FormaDodavanjeKlijenta frm=new FormaDodavanjeKlijenta();
				frm.setVisible(true);
			
			}
		});
		btnNewButton.setBounds(10, 11, 131, 23);
		contentPane.add(btnNewButton);
		
	    listaPrikaz = new JList();
		listaPrikaz.setBounds(26, 79, 407, 272);
		contentPane.add(listaPrikaz);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormaIzbrisiKlijenta fik=new FormaIzbrisiKlijenta();
			    fik.setVisible(true);
			}
		});
		btnDelete.setBounds(151, 11, 100, 23);
		contentPane.add(btnDelete);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			FormaIzmeniKlijenta izk=new FormaIzmeniKlijenta();
			izk.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(261, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		popuniListuSaPodacima();
		
	//	tblModel=new DefaultTableModel();
	//	tblModel.setColumnIdentifiers(koloneTabele);
	//	table = new JTable();
	//	table.setModel(tblModel);
		//table.setBounds(10, 65, 445, 347);
	//	contentPane.add(table);
	}
}
