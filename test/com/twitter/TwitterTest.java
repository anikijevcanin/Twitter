/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Anisja Kijevcanin
 *
 */
public class TwitterTest {

	/**
	 * @throws java.lang.Exception
	 */
	private Twitter twitter;
	@Before
	public void setUp() throws Exception {
		twitter = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		twitter = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		TwitterPoruka tp = new TwitterPoruka(); 
		 tp.setKorisnik("Klementina"); 
		 tp.setPoruka("hm, pih");  
		 twitter.unesi(tp.getKorisnik(), tp.getPoruka());
		 assertEquals(1, twitter.vratiSvePoruke().size());
		 assertEquals(tp.toString(), twitter.vratiSvePoruke().get(0).toString());
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiIstaPoruka() {
		 twitter.unesi("Klementina", "hm, pih");
		 twitter.unesi("Klementina", "hm, pih");	 
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiNullKorisnik() {
		twitter.unesi(null, "...");
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiNullPoruka() {
		twitter.unesi("Silva", null);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiEmptyStringKorisnik() {
		twitter.unesi("", "...");
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiEmptyStringPoruka() {
		twitter.unesi("Dzordz", "");
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		twitter.unesi("a", "vau");
		twitter.unesi("b", "bum");
		twitter.unesi("c", "pom");
		TwitterPoruka[] t = twitter.vratiPoruke(4, "m");
		assertEquals("b", t[0].getKorisnik());
		assertEquals("bum", t[0].getPoruka());
		assertEquals("c", t[1].getKorisnik());
		assertEquals("pom", t[1].getPoruka());
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		twitter.vratiPoruke(5, null);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeEmptyString() {
		twitter.vratiPoruke(-1, "");
	}
	

}
