package com.twitter;

import java.util.LinkedList;

import com.twitter.poruke.TwitterPoruka;
/**
 * Predstavlja skladiste svih korisnickih poruka koje unesemo.
 * @author Anisja Kijevcanin
 * @version 0.1
 *
 */
public class Twitter {
	/**
	 * Lista poruka koja nije ogranicena brojem unetih poruka. Unose se objekti klase TwitterPoruka.
	 */
	 private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>(); 
	 /**
	  * Metoda koja vraca sve poruke iz liste poruka
	  * @return lista objekata TwitterPoruka
	  */
	 public LinkedList<TwitterPoruka> vratiSvePoruke() { 
		 	return poruke; 
		 }
	 /**
	  * Metoda kojom se unosi nova TwitterPoruka u listu svih poruka
	  * na poslednje mesto
	  * @param korisnik koji pise poruku
	  * @param poruka koju je napisao korisnik
	  */
	 public void unesi(String korisnik, String poruka) { 
		 if(korisnik == null || korisnik =="" || poruka == null || poruka == "")
			 throw new RuntimeException("Korisnik i poruka ne smeju biti null ili prazan String");
		 TwitterPoruka tp = new TwitterPoruka(); 
		 tp.setKorisnik(korisnik); 
		 tp.setPoruka(poruka);
		 for (int i = 0; i < poruke.size(); i++) {
			if(poruke.get(i).getKorisnik() == korisnik && poruke.get(i).getPoruka() == poruka)
				throw new RuntimeException("Data poruka vec postoji u listi.");
		}
		 poruke.addLast(tp);
		 }  
	 /**
	  * Metoda koja vraca novi niz objekata TwitterPoruka,
	  * velicine unetog maksimalnog broja, koji sadrze samo poruke sa unetim tagom
	  * @param maxBroj je kapacitet novog niza poruka
	  * @param tag je String koji zelimo da se javi u svakoj poruci novog niza
	  * @return niz objekata TwitterPoruka koji ispunjavaju date parametre
	  */
	 public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		 if (tag==null || tag.isEmpty()) throw new RuntimeException("Morate uneti tag"); 
		 if (maxBroj<=0) maxBroj = 100;     
		 int brojac = 0;
		 TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		 for (int i = 0; i < poruke.size(); i++) 
		 if (poruke.get(i).getPoruka().indexOf(tag)!=-1) 
			 if (brojac < maxBroj) { 
				 rezultat[brojac]=poruke.get(i); 
				 brojac++; 
				 } else break;  
		 return rezultat;
		 } 
}
