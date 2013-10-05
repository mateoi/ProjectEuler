package p_051_to_060;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class P054 {

	public static class Card {
		public int value; // 11, 12, 13 for J, Q, K; 14 for A.
		public String suit;

		Card(int value, String suit) {
			this.value = value;
			this.suit = suit.toUpperCase();
		}

		Card(String s) {
			this.suit = s.substring(1, 2).toUpperCase();
			
			switch (s.charAt(0)) {
			case 'T' : {this.value = 10; return;}
			case 'J' : {this.value = 11; return;}
			case 'Q' : {this.value = 12; return;}
			case 'K' : {this.value = 13; return;}
			case 'A' : {this.value = 14; return;}
			default  : this.value = (s.charAt(0) - 48);
			}
		}

		@Override
		public String toString() {
			return value + suit;
		}
	}

	public static class Hand {
		public Card[] cards;

		public Hand(Card... cards) {
			boolean sorted = false;
			do {
				sorted = true;
				for (int i = 0; i < cards.length - 1; i++) {
					if (cards[i].value > cards[i + 1].value) {
						Card temp = cards[i];
						cards[i] = cards[i + 1];
						cards[i + 1] = temp;
						sorted = false;
					}
				}
			} while (!sorted);

			this.cards = cards;
		}
		
		@Override
		public String toString() {
			String s = "";
			for (Card c : cards) {
				s = s.concat(c.toString() + ", ");
			}
			return s;
		}
	}

	public static Hand[] player1 = new Hand[1000];
	public static Hand[] player2 = new Hand[1000];

	public static void populateHands(String filename) throws IOException {
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		for (int i = 0; i < 1000; i++) {
			String s = br.readLine();
			Card[] game = new Card[10];
			for (int j = 0; j < 10; j++) {
				game[j] = new Card(s.substring(3 * j, (3 * j) + 2));
			}
			
			Hand hand1 = new Hand(game[0], game[1], game[2], game[3], game[4]);
			Hand hand2 = new Hand(game[5], game[6], game[7], game[8], game[9]);
			
			player1[i] = hand1;
			player2[i] = hand2;
		}
		

		br.close();
		fr.close();
	}


	public static int hasRoyalFlush(Hand hand) {
		int total = 0;
		String suit = hand.cards[0].suit;
		for (Card c : hand.cards) {
			if (!suit.equals(c.suit)) return 0;
			total += c.value;
		}

		return total == 60 ? 10 : 0;

	}

	public static int hasStraightFlush(Hand hand) {
		Card ini = hand.cards[0];
		for (int i = 1; i < hand.cards.length; i++) {
			if (hand.cards[i].value != ini.value + i || !hand.cards[i].suit.equals(ini.suit)) {
				return 0;
			}
		}

		return ini.value;
	}

	public static int hasFourOfAKind(Hand hand) {
		Card[] cs = hand.cards;

		if (cs[0].value == cs[3].value) {
			return cs[0].value;
		}

		if (cs[1].value == cs[4].value) {
			return cs[1].value;
		}

		return 0;
	}

	public static int hasFullHouse(Hand hand) {
		Card[] cs = hand.cards;
		if (cs[0].value == cs[1].value && cs[2].value == cs[4].value) {
			return cs[2].value;
		}
		
		if (cs[0].value == cs[2].value && cs[3].value == cs[4].value) {
			return cs[2].value;
		}
		
		return 0;
	}

	public static int hasFlush(Hand hand) {
		String suit = hand.cards[0].suit;
		for (Card c : hand.cards) {
			if (!c.suit.equals(suit)) return 0;
		}

		return highCard(hand);
	}

	public static int hasStraight(Hand hand) {
		Card ini = hand.cards[0];
		for (int i = 1; i < hand.cards.length; i++) {
			if (hand.cards[i].value != ini.value + i) {
				return 0;
			}
		}

		return ini.value;
	}

	public static int hasThreeOfAKind(Hand hand) {
		Card[] cs = hand.cards;

		if (cs[0].value == cs[2].value) {
			return cs[0].value;
		}

		if (cs[1].value == cs[3].value) {
			return cs[1].value;
		}

		if (cs[2].value == cs[4].value) {
			return cs[2].value;
		}

		return 0;
	}

	public static int hasTwoPairs(Hand hand) {
		Card[] cs = hand.cards;

		if (cs[0].value == cs[1].value && cs[2].value == cs[3].value) {
			return cs[2].value;
		}

		if (cs[1].value == cs[2].value && cs[3].value == cs[4].value) {
			return cs[3].value;
		}

		if (cs[0].value == cs[1].value && cs[3].value == cs[4].value) {
			return cs[3].value;
		}

		return 0;
	}

	public static int hasOnePair(Hand hand) {
		Card[] cs = hand.cards;

		if (cs[0].value == cs[1].value) {
			return cs[0].value;
		}

		if (cs[1].value == cs[2].value) {
			return cs[1].value;
		}

		if (cs[2].value == cs[3].value) {
			return cs[2].value;
		}

		if (cs[3].value == cs[4].value) {
			return cs[3].value;
		}

		return 0;
	}

	public static int highCard(Hand hand) {
		return hand.cards[4].value;
	}

	public static int play(Hand h1, Hand h2) {
		
		int hi1 = highCard(h1);
		int hi2 = highCard(h2);
		
		int rf1 = hasRoyalFlush(h1);
		int rf2 = hasRoyalFlush(h2);
		if (rf1 != rf2) {
			int winner = rf1 > rf2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on Royal Flush");
			return winner;
		}
		if (rf1 == rf2 && rf1 != 0) {
			int winner = hi1 > hi2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on High card after Royal Flush");
			return winner;
		}
		
		int sf1 = hasStraightFlush(h1);
		int sf2 = hasStraightFlush(h2);
		if (sf1 != sf2) {
			int winner = sf1 > sf2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on Straight Flush");
			return winner;
		}
		if (sf1 == sf2 && sf1 != 0) {
			int winner = hi1 > hi2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on High card after Straight Flush");
			return winner;
		}
		
		int fok1 = hasFourOfAKind(h1);
		int fok2 = hasFourOfAKind(h2);
		if (fok1 != fok2) {
			int winner = fok1 > fok2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on Four-of-a-kind");
			return winner;
		}
		if (fok1 == fok2 && fok1 != 0) {
			int winner = hi1 > hi2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on High card after Four-of-a-kind");
			return winner;
		}
		
		int fh1 = hasFullHouse(h1);
		int fh2 = hasFullHouse(h2);
		if (fh1 != fh2) {
			int winner = fh1 > fh2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on Full House");
			return winner;
		}
		if (fh1 == fh2 && fh1 != 0) {
			int winner = hi1 > hi2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on High card after Full House");
			return winner;
		}
		
		int f1 = hasFlush(h1);
		int f2 = hasFlush(h2);
		if (f1 != f2) {
			int winner = f1 > f2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on Flush");
			return winner;
		}
		if (f1 == f2 && f1 != 0) {
			int winner = hi1 > hi2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on High card after Flush");
			return winner;
		}
		
		int s1 = hasStraight(h1);
		int s2 = hasStraight(h2);
		if (s1 != s2) {
			int winner = s1 > s2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on Straight");
			return winner;
		}
		if (s1 == s2 && s1 != 0) {
			int winner = hi1 > hi2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on High card after Straight");
			return winner;
		}
		
		int tok1 = hasThreeOfAKind(h1);
		int tok2 = hasThreeOfAKind(h2);
		if (tok1 != tok2) {
			int winner = tok1 > tok2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on Three-of-a-kind");
			return winner;
		}
		if (tok1 == tok2 && tok1 != 0) {
			int winner = hi1 > hi2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on High card after Three-of-a-kind");
			return winner;
		}
		
		int tp1 = hasTwoPairs(h1);
		int tp2 = hasTwoPairs(h2);
		if (tp1 != tp2) {
			int winner = tp1 > tp2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on Two Pairs");
			return winner;
		}
		if (tp1 == tp2 && tp1 != 0) {
			int winner = hi1 > hi2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on High card after Two Pairs");
			return winner;
		}
		
		int p1 = hasOnePair(h1);
		int p2 = hasOnePair(h2);
		if (p1 != p2) {
			int winner = p1 > p2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on Pair");
			return winner;
		}
		if (p1 == p2 && p1 != 0) {
			int winner = hi1 > hi2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on High card after Pair");
			return winner;
		}
		
		
		if (hi1 != hi2) {
			int winner = hi1 > hi2 ? 1 : 2;
			System.out.println("Player " + winner + " wins on High card");
			return winner;
		}
		
		return 0;
		
	}
	
	public static void main(String[] args) {
		System.out.println("start!");

		try {
			populateHands("P054 - poker.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int p1w = 0;
		
		for (int i = 0; i < 1000; i++) {
			System.out.println("Player 1: " + player1[i].toString() + "\tPlayer 2: " + player2[i].toString());
			if (play(player1[i], player2[i]) == 1) p1w++;
			System.out.println();
		}
		
		System.out.println(p1w);
	}

}
