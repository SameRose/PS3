package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class DeckTest {

	@Test
	public void TestEmptyDeck() {
		
		Deck d = new Deck();
		for (int x = 1; x<=53; x++) {
			d.Draw();
			System.out.println("card number " + x);
			
			
		}
	}
	
	@Test
	public void TestDrawSuit() {
		
		
		Deck d = new Deck();
		for(int x = 1; x<=13; x++) {
		assertEquals(d.Draw(eSuit.HEARTS).geteSuit(), new Card(eSuit.HEARTS, eRank.TWO).geteSuit());}
	}
	
	@Test
	public void TestDrawRank() {
		
		Deck d = new Deck();
		for(int x = 1; x<=4; x++) {
		assertEquals(d.Draw(eRank.SEVEN).geteRank(), new Card(eSuit.HEARTS, eRank.SEVEN).geteRank());
		}
	}
	@Test
	public void TestDeckRankCount() {
		
		Deck d = new Deck();
		for(int x = 4; x>0; x--) {
		
		assertEquals(d.Count(eRank.SEVEN), x);
		d.Draw(eRank.SEVEN);}
	}
	@Test
	public void TestDeckSuitCount() {
		
		Deck d = new Deck();
		for(int x = 13; x>0; x--) {
			
			assertEquals(d.Count(eSuit.HEARTS), x);
			d.Draw(eSuit.HEARTS);}
		}
	

	@Test
	public void TestDeckCardCount() {

		Deck d = new Deck();
		assertEquals(d.Count(new Card(eSuit.CLUBS, eRank.EIGHT)), 1);
		for(int x = 4; x>0; x--) {
		d.Draw(eRank.EIGHT);}
		assertEquals(d.Count(new Card(eSuit.CLUBS, eRank.EIGHT)), 0);
		
	}
	
	
	
}
