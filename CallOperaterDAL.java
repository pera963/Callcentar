package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Entity.CallOperaterEntitet;

public class CallOperaterDAL {
	
public void IzbrisiKoloperatera(String IDOperatera) throws SQLException {
		
		Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
		Connection con=Konekcija.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("delete from calloperater where ID=?");
		ps.setString(1, IDOperatera);
		
		ps.executeUpdate(); //kada dodajemo, brisemo ili menjamo radimo execute update
		
		con.close();
				
	}
	// Dodavanje klijenta
	public void DodajOperatera(String Ime,String Prezime,String Telefon) throws SQLException {
		
		Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
		Connection con=Konekcija.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into calloperater(ime,prezime,telefon)values (?,?,?)");
		ps.setString(1,Ime);
		ps.setString(2,Prezime);
		ps.setString(3,Telefon);
		
		
		ps.executeUpdate();
	    con.close();
		
	}
	
	//Izmena ili Update Klijenata
	
	public void Izmena (String ID,String Ime,String Prezime,String Telefon) throws SQLException
	{
		Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
		Connection con=Konekcija.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("update calloperater set ime=?,prezime=?,telefon=? where id=?");
		ps.setString(1,Ime);
		ps.setString(2,Prezime);
		ps.setString(3,Telefon);
		ps.setString(4,ID);
		
		ps.executeUpdate();
	    con.close();
	    
	    
	}
	
	public ArrayList<CallOperaterEntitet> dajSveOperatere() throws SQLException{
		
		//ovde treba da izvucemo sve podatke o operaterima iz baze, da napunimo listu sa tim podacima
		//i da tu listuu vratimo (return)
		
		//ovo je prazna lista koju cemo da napunimo
		ArrayList<CallOperaterEntitet> novaLista=new ArrayList<CallOperaterEntitet>();
		
		Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
		Connection con=Konekcija.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from calloperater");
		// nema znaka ? jer mi ne unosimo nikakve podatke ,nema setString,veæ getString uzima iz baze. 
		
		ResultSet rs=ps.executeQuery();
		
		//ovde citamo jedan po jedan podatak iz baze i punimo listu
		while(rs.next()) {
			
		int ID=rs.getInt("ID");
		String ime=rs.getString("ime");
		String prezime=rs.getString("prezime");
		String telefon=rs.getString("telefon");
			
		CallOperaterEntitet operater=new CallOperaterEntitet(ID, ime, prezime, telefon);
		novaLista.add(operater);
					
		}
		
		return novaLista;
		
		
	}
	

}
