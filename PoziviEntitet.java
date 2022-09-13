package Entity;

public class PoziviEntitet {

	private int ID;
	private int IDOperatera;
	private int IDKlijenta;
	private String Odgovor_Klijenta;
	private String Datum_Poziva;
	
	public PoziviEntitet(int iD, int iDOperatera, int iDKlijenta, String odgovor_Klijenta, String datum_Poziva) {
		super();
		ID = iD;
		IDOperatera = iDOperatera;
		IDKlijenta = iDKlijenta;
		Odgovor_Klijenta = odgovor_Klijenta;
		Datum_Poziva = datum_Poziva;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getIDOperatera() {
		return IDOperatera;
	}

	public void setIDOperatera(int iDOperatera) {
		IDOperatera = iDOperatera;
	}

	public int getIDKlijenta() {
		return IDKlijenta;
	}

	public void setIDKlijenta(int iDKlijenta) {
		IDKlijenta = iDKlijenta;
	}

	public String getOdgovor_Klijenta() {
		return Odgovor_Klijenta;
	}

	public void setOdgovor_Klijenta(String odgovor_Klijenta) {
		Odgovor_Klijenta = odgovor_Klijenta;
	}

	public String getDatum_Poziva() {
		return Datum_Poziva;
	}

	public void setDatum_Poziva(String datum_Poziva) {
		Datum_Poziva = datum_Poziva;
	}

	@Override
	public String toString() {
		return IDOperatera + " " + IDKlijenta + " " + Odgovor_Klijenta + " " + Datum_Poziva ;
	}
	




}
