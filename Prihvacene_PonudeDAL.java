package DAL;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Prihvacene_PonudeDAL {

	//Ova metoda brise klijenta
		public void IzbrisiPrihvaenePonude(int IDPonude) throws SQLException {
			
			Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
			Connection con=Konekcija.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("delete from prihvacene_ponude where ID=?");
			ps.setInt(1, IDPonude);
			
			ps.executeUpdate(); //kada dodajemo, brisemo ili menjamo radimo execute update
			
			con.close();
					
		}
		// Dodavanje klijenta
		public void DodajPonudu(int IDPoziva,String Opis) throws SQLException {
			
			Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
			Connection con=Konekcija.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into prihvacene_ponude(idpoziva,opis)values (?,?)");
			ps.setInt(1,IDPoziva);
			ps.setString(2,Opis);
				
			
			ps.executeUpdate();
		    con.close();
			
		}
		
		//Izmena ili Update Klijenata
		
		public void IzmenaPonuda (int ID,int IDPoziva,String Opis) throws SQLException
		{
			Konekcija kon=new Konekcija();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
			Connection con=Konekcija.otvoriKonekciju();//Connection to je Javina clasa,con varijabla tipa Connection  
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("update prihvacene_ponude set idpoziva=?,opis=? where id=?");
			ps.setInt(1,IDPoziva);
			ps.setString(2,Opis);
			ps.setInt(3,ID);
			
			ps.executeUpdate();
		    con.close();
		}
		



}
