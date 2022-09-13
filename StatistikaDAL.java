package DAL;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class StatistikaDAL {

	//Ova metoda brise klijenta
		public void IzbrisiStatistiku(int IDStatistika) throws SQLException {
			
			Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
			Connection con=Konekcija.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("delete from statistika where ID=?");
			ps.setInt(1, IDStatistika);
			
			ps.executeUpdate(); //kada dodajemo, brisemo ili menjamo radimo execute update
			
			con.close();
					
		}
		// Dodavanje statistike
		public void DodajStatistiku(int Broj_Prihvacenih,int Broj_Poziva,int IDOperatera) throws SQLException {
			
			Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
			Connection con=Konekcija.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into statistika(broj_prihvacenih, broj_poziva, idoperatera)values (?,?,?)"); 
					
			ps.setInt(1,Broj_Prihvacenih);
			ps.setInt(2,Broj_Poziva);
			ps.setInt(3,IDOperatera);
			
			
			ps.executeUpdate();
		    con.close();
			
		}
		
		//Izmena ili Update Klijenata
		
		public void IzmenaStatistike (int ID,int Broj_Prihvacenih,int Broj_Poziva,int IDOperatera) throws SQLException
		{
			Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
			Connection con=Konekcija.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("update  statistika broj_prihvacenih=?,broj_poziva=?,idoperatera=? where id=?");
			ps.setInt(1,Broj_Prihvacenih);
			ps.setInt(2,Broj_Poziva);
			ps.setInt(3,IDOperatera);
			ps.setInt(4,ID);
			
			ps.executeUpdate();
		    con.close();
		}
		

}
