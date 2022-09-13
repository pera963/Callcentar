package Forme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAL.CallOperaterDAL;
import DAL.KlijentDAL;
import Entity.CallOperaterEntitet;
import Entity.KlijentEntitet;

import javax.swing.JTabbedPane;
import javax.swing.DefaultListModel;

import javax.swing.JTable;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class FormaCallOperateri extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public String[] koloneTabele = { "Ime", "Prezime", "Telefon" };
	public DefaultTableModel tblModel;
	public JList listaPrikaz2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaCallOperateri frame = new FormaCallOperateri();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

public void popuniListuSaPodacima() throws SQLException {
		
		//kreiramo DAL
	CallOperaterDAL dal=new CallOperaterDAL ();
		
		//uzimam listu klijenata iz dala
		ArrayList<CallOperaterEntitet> listatemp=dal.dajSveOperatere();	//nestvara novu tj,new listu veæ vrši deklaraciju liste 
		//i toj listi dodeljuje veæ godtovu lidtu iz DALa
		//sluzi nam za punjenje Jliste
		DefaultListModel<CallOperaterEntitet> listModel = new DefaultListModel<CallOperaterEntitet>();
		
		//ovde prelazimo preko liste i punimo model iz liste klienata
		for(int i=0; i<listatemp.size();i++) {
			
			listModel.addElement(listatemp.get(i));
			
		}
		listaPrikaz2.setModel(listModel);
}
	
	
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public FormaCallOperateri() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDodavanjeNovog = new JButton("Dodaj novog operatera");
		btnDodavanjeNovog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormaDodavanjeOperatera frm=new FormaDodavanjeOperatera();
				frm.setVisible(true);
			}
		});
		btnDodavanjeNovog.setBounds(10, 11, 145, 23);
		contentPane.add(btnDodavanjeNovog);
		
		
		
		
		
		listaPrikaz2 = new JList();
		listaPrikaz2.setBounds(10, 56, 647, 341);
		contentPane.add(listaPrikaz2);
		
		JButton btnUpdate = new JButton("UPDATE \r\n");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			FormaUpdateOperatera fro=new FormaUpdateOperatera();
			fro.setVisible(true);
			}
		});
		btnUpdate.setBounds(165, 11, 75, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzbrisiOperatera izo=new IzbrisiOperatera();
			izo.setVisible(true);
			}
		});
		btnDelete.setBounds(250, 11, 89, 23);
		contentPane.add(btnDelete);
	
		popuniListuSaPodacima();
	}
}
