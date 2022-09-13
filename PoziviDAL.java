package DAL;

import java.sql.Date;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PoziviDAL {

	//Ova metoda brise Poziv
		public void IzbrisiPoziva(String iD) throws SQLException 
		{
			
			Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
			Connection con=Konekcija.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("delete from pozivi where ID=?");
			ps.setString(1, iD);
			
			ps.executeUpdate(); //kada dodajemo,brisemo ili menjamo radimo execute update
			
			con.close();
		}
			// Dodavanje Poziva
			public void DodajPoziv(String iDOperatera,String iDKlijenta,String Odgovor_Klijenata,String datum_Poziva) throws SQLException 
			{
				
				Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
				Connection con=Konekcija.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
				PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into operater(idoperatera,idklijenta,odgovor_klijenata,datum_poziva)values (?,?,?,?)");
				ps.setString(1,iDOperatera);
				ps.setString(2,iDKlijenta);
				ps.setString(3,Odgovor_Klijenata);
				ps.setString(4,datum_Poziva);
				
				ps.executeUpdate();
			    con.close();
				
			}
			
			//Izmena ili Update Poziva			
	public void Izmena (String ID,String IDOperatera,String IDKlijenta,String Odgovor_Klijenata,Date Datum_Poziva) throws SQLException
			{
				Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
				Connection con=Konekcija.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
				PreparedStatement ps=(PreparedStatement) con.prepareStatement("update klijent set idoperatera=?,idklijenta=?,odgovor_klijenata=?,datum_poziva=? where id=?");
				ps.setString(1,IDOperatera);
				ps.setString(2,IDKlijenta);
				ps.setString(3,Odgovor_Klijenata);
				ps.setDate(4,Datum_Poziva);
				ps.setString(5,ID);
				
				ps.executeUpdate();
			    con.close();
			}
	

}
