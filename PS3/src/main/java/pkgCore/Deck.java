package pkgCore;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class Deck {

	private ArrayList<Card> cardsInDeck;

	public Deck() {
		cardsInDeck = new ArrayList<Card>();
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() {
		try {

			return cardsInDeck.remove(0);
		} catch (Exception e) {

			System.out.println("No cards left!");
			throw e;
		}
	}

	public Card Draw(eSuit eSuit) {

		for (Card c : this.cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		return null;
	}

	public Card Draw(eRank eRank) {

		for (Card c : this.cardsInDeck) {
			if (c.geteRank() == eRank) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		return null;
	}

	public int Count(eSuit eSuit) {
		ArrayList<Card> cardsInSuit = cardsInDeck.stream().filter(p -> p.geteSuit() == eSuit)
				.collect(Collectors.toCollection(ArrayList::new));
		return cardsInSuit.size();

	}

	public int Count(eRank eRank) {
		ArrayList<Card> cardsInRank = cardsInDeck.stream().filter(p -> p.geteRank() == eRank)
				.collect(Collectors.toCollection(ArrayList::new));
		return cardsInRank.size();

	}

	public int Count(Card c) {
		ArrayList<Card> cardsInRank = cardsInDeck.stream().filter(p -> p.geteRank() == c.geteRank())
				.collect(Collectors.toCollection(ArrayList::new));
		ArrayList<Card> cardsInSuit = cardsInRank.stream().filter(p -> p.geteSuit() == c.geteSuit())
				.collect(Collectors.toCollection(ArrayList::new));
		return cardsInSuit.size();

	}

}
