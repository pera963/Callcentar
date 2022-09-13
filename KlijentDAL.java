package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Entity.KlijentEntitet;

public class KlijentDAL {

	
	//Ova metoda brise klijenta
	public void IzbrisiKlijenta(String IDKlijenta) throws SQLException {
		
		Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
		Connection con=Konekcija.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("delete from klijent where ID=?");
		ps.setString(1, IDKlijenta);
		
		ps.executeUpdate(); //kada dodajemo, brisemo ili menjamo radimo execute update
		
		con.close();
				
	}
	// Dodavanje klijenta
	public void DodajKlijenta(String Ime,String Prezime,String Telefon,String EMail) throws SQLException {
		
		Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
		Connection con=Konekcija.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into klijent(ime,prezime,telefon,email)values (?,?,?,?)");
		ps.setString(1,Ime);
		ps.setString(2,Prezime);
		ps.setString(3,Telefon);
		ps.setString(4,EMail);		
		
		ps.executeUpdate();
	    con.close();
		
	}
	
	//Izmena ili Update Klijenata
	
	public void Izmena (String ID,String Ime,String Prezime,String Telefon,String EMail) throws SQLException
	{
		Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
		Connection con=Konekcija.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("update klijent set ime=?,prezime=?,telefon=?,email=? where id=?");
		ps.setString(1,Ime);
		ps.setString(2,Prezime);
		ps.setString(3,Telefon);
		ps.setString(4,EMail);
		ps.setString(5,ID);
		
		ps.executeUpdate();
	    con.close();
	}
	
public ArrayList<KlijentEntitet> dajSveKlijente() throws SQLException{
		
		//ovde treba da izvucemo sve podatke o operaterima iz baze, da napunimo listu sa tim podacima
		//i da tu listuu vratimo (return)
		
		//ovo je prazna lista koju cemo da napunimo
		ArrayList<KlijentEntitet> novaLista=new ArrayList<KlijentEntitet>();
		
		Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
		Connection con=Konekcija.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from klijent");
		// nema znaka ? jer mi ne unosimo nikakve podatke ,nema setString,veæ getString uzima iz baze. 
		ResultSet rs=ps.executeQuery();
		
		//ovde citamo jedan po jedan podatak iz baze i punimo listu
		while(rs.next()) {
			
		int ID=rs.getInt("ID");
		String ime=rs.getString("ime");
		String prezime=rs.getString("prezime");
		String telefon=rs.getString("telefon");
		String email=rs.getString("email");	
		
		KlijentEntitet kl=new KlijentEntitet(ID, ime, prezime, telefon,email);
		novaLista.add(kl); //objekat kl dodajemo u listu
					
		}
		
		return novaLista;
		
	}
}

