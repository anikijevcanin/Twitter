package com.twitter.poruke;

/** Predstavlja jednu Twitter poruku
  *@author Anisja Kijevcanin
  *@version 0.1
  **/
public class TwitterPoruka {
	/** Atribut klase String koji se odnosi na korisnika profila na Twitter-u*/
	private String korisnik; 
	/** Atribut klase String koji se odnosi na poruku koju korisnik postavlja na Twitter-u*/
	private String poruka;  
	
	/** Metoda koja vraca atribut korisnik 
	 * @return Ime korisnika kao String*/
	public String getKorisnik() { 
		return korisnik; 
	} 
	/** Metoda koja postavlja ime korisnika 
	 * @param Ime novog korisnika*/
	 public void setKorisnik(String korisnik) { 
		 if (korisnik==null || korisnik.equals("")) throw new RuntimeException( "Ime korisnika mora biti uneto");  
		 	this.korisnik = korisnik; 
	} 
	 /** Metoda koja vraca atribut poruka 
		 * @return Sadrzaj poruke kao String .*/ 
	public String getPoruka() { 
		return poruka; 
	}  
	/** Metoda koja vraca atribut korisnik 
	 * @param sadrzaj nove poruke*/
	public void setPoruka(String poruka) { 
		if (poruka==null || poruka.length()>140) 
			throw new RuntimeException( "Poruka mora biti uneta i mora imati najvise 140 znakova");  
		this.poruka = poruka; 
	}  
	/** Overwritten metoda toString koja ispisuje ime korisnika i njegovu poruku 
	 * @return korisnik i poruka kao String*/
	public String toString(){ 
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka; 
	}  
}
