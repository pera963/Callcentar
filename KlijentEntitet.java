package Entity;

public class KlijentEntitet {

	private int ID;
	private String ime;
	private String prezime;
	private String telefon;
	private String email;

	public KlijentEntitet(int iD, String ime, String prezime, String telefon,String email) {
		super();
		ID = iD;
		this.ime = ime;
		this.prezime = prezime;
		this.telefon = telefon;
		this.email = email;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return  ime + " "+ prezime + " " + telefon + " " + email;
	}
	
	
}
