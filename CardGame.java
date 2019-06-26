import java.util.Scanner;
public class CardGame
{
	public static void main(String[]args)
	{
		Scanner reader = new Scanner(System.in);

		int[] card = new int[52];
		String suit[] = new String[52];

		for (int i = 0; i < 52; i++)
		{
			card[i] = i%13 + 1;
			if (i<=12)
				suit[i] = "Clubs";
			else if(i <= 25)
				suit[i] = "Hearts";
			else if(i <= 38)
				suit[i] = "Diamonds";
			else if(i <= 51)
				suit[i] = "Spades";
		}


		//print ordered deck
		System.out.println("Ordered Deck:");

		for (int i = 0; i < 52; i++)
		{
			if (i==0 || i==13 || i==26 || i==39)
				System.out.print("Ace of "+suit[i]+"\t");
			else if (i==10 || i==23 || i==36 || i==49)
				System.out.print("Jack of "+suit[i]+"\t");
			else if (i==11 || i==24 || i==37 || i==50)
				System.out.print("Queen of "+suit[i]+"\t");
			else if (i==12 || i==25 || i== 38|| i==51)
				System.out.print("King of "+suit[i]+"\t");
			else
				System.out.print(card[i]+" of "+suit[i]+"\t");
			if ((i+1)%5 == 0 && i!=0)
				System.out.println();
		}
		System.out.println("\n");



		int p1Points = 0;
		int p2Points = 0;
		int maxPoints = 5;

		while(p1Points != maxPoints && p2Points != maxPoints)
		{

		int[] p1Card = new int[5];
		String[] p1Suit = new String[5];
		int[] p2Card = new int[5];
		String[] p2Suit = new String[5];

		//print ordered deck
		//printOrderedDeck(card, p1Card, p2Card, suit, p1Suit, p2Suit);
		//don't need

		//print shuffled deck
		Shuffle(card, p1Card, p2Card, suit, p1Suit, p2Suit);

		//deal deck
		Deal(card, p1Card, p2Card, suit, p1Suit, p2Suit);

		int p1Val= p1Card[getHighestIndex(p1Card)];
		int p2Val = p2Card[getHighestIndex(p2Card)];

		if(p1Val == 1)
		{
			p1Val = Integer.MAX_VALUE;
		}
		if(p2Val == 1)
		{
			p2Val = Integer.MAX_VALUE;
		}

		if (p1Val > p2Val)
		{
			p1Points++;
			System.out.println("Player 1 wins this round.\n");
		}

		else if (p1Val < p2Val)
		{
			p2Points++;
			System.out.println("Player 2 wins this round.\n");
		}
		else
		{
			System.out.println("Tie this round.\n");
		}


		System.out.println("Player 1 wins: "+p1Points+"\nPlayer 2 wins: "+p2Points+"\n");
	}

		if (p1Points > p2Points)
		{
			System.out.println("\n\nPlayer 1 Wins!");

		}

		else if (p1Points < p2Points)
		{
			System.out.println("\n\nPlayer 2 Wins!");
		}

		else if (p1Points == p2Points)
		{
			System.out.println("\n\nIt's a tie!");
		}


	}//end of public class

	//methods
	public static void Deal(int[]card, int[]p1Card, int[]p2Card, String[] suit, String[]p1Suit, String[]p2Suit)
	{
		int index =0;
		for(int i=0; i < 10; i++)
		{
			p1Card[index] = card[i];
			p1Suit[index] = suit[i++];

			p2Card[index] = card[i];
			p2Suit[index] = suit[i];
			index++;

		}
		System.out.println("\nPlayer 1:");
		for (int i = 0; i<5; i++)
		{
			if (p1Card[i] == 1)
				System.out.print("Ace of "+p1Suit[i]+"\t");
			else if (p1Card[i] == 11)
				System.out.print("Jack of "+p1Suit[i]+"\t");
			else if (p1Card[i] == 12)
				System.out.print("Queen of "+p1Suit[i]+"\t");
			else if (p1Card[i] == 13)
				System.out.print("King of "+p1Suit[i]+"\t");
			else
				System.out.print(p1Card[i]+" of "+p1Suit[i]+"\t");
		}

		System.out.println("\n");

		System.out.println("Player 2:");
		for (int i = 0; i<5; i++)
		{
			if (p2Card[i] == 1)
				System.out.print("Ace of "+p2Suit[i]+"\t");
			else if (p2Card[i] == 11)
				System.out.print("Jack of "+p2Suit[i]+"\t");
			else if (p2Card[i] == 12)
				System.out.print("Queen of "+p2Suit[i]+"\t");
			else if (p2Card[i] == 13)
				System.out.print("King of "+p2Suit[i]+"\t");
			else
				System.out.print(p2Card[i]+" of "+p2Suit[i]+"\t");
		}
		System.out.println("\n");
	}
	public static void printOrderedDeck(int[]card, int[]p1Card, int[]p2Card, String[] suit, String[]p1Suit, String[]p2Suit)
	{
		System.out.println("Ordered Deck:");

		for (int i = 0; i < 52; i++)
		{
			if (i==0 || i==13 || i==26 || i==39)
				System.out.print("Ace of "+suit[i]+"\t");
			else if (i==10 || i==23 || i==36 || i==49)
				System.out.print("Jack of "+suit[i]+"\t");
			else if (i==11 || i==24 || i==37 || i==50)
				System.out.print("Queen of "+suit[i]+"\t");
			else if (i==12 || i==25 || i== 38|| i==51)
				System.out.print("King of "+suit[i]+"\t");
			else
				System.out.print(card[i]+" of "+suit[i]+"\t");
			if ((i+1)%5 == 0 && i!=0)
				System.out.println();
		}
		System.out.println("\n");
	}

	public static void Shuffle(int[]card, int[]p1Card, int[]p2Card, String[] suit, String[]p1Suit, String[]p2Suit)
	{
		for (int i = 0; i<1000; i++)
		{
			int rand1 = (int)((Math.random()*51)+0);
			int rand2 = (int)((Math.random()*51)+0);
			int temp1 = card[rand1];
			card[rand1] = card[rand2];
			card[rand2] = temp1;

			String temp2 = suit[rand1];
			suit[rand1] = suit[rand2];
			suit[rand2] = temp2;

		}

		System.out.println("Shuffled Deck:");

		for (int i = 0; i < 52; i++)
		{
			if (i==0 || i==13 || i==26 || i==39)
				System.out.print("Ace of "+suit[i]+"\t");
			else if (i==10 || i==23 || i==36 || i==49)
				System.out.print("Jack of "+suit[i]+"\t");
			else if (i==11 || i==24 || i==37 || i==50)
				System.out.print("Queen of "+suit[i]+"\t");
			else if (i==12 || i==25 || i== 38|| i==51)
				System.out.print("King of "+suit[i]+"\t");
			else
				System.out.print(card[i]+" of "+suit[i]+"\t");
			if ((i+1)%5 == 0 && i!=0)
				System.out.println();
		}
		System.out.println("\n\n");
	}

	public static int getHighestIndex(int[] cards)
	{
		int highest = Integer.MIN_VALUE;
		int highestIndex = -1;

		for(int i=0; i < cards.length; i++)
		{

			int val = cards[i];

			if(val == 1)
			{
				val = Integer.MAX_VALUE;
			}

			if(highest < val)
			{
				highest = val;
				highestIndex = i;
			}
		}

		return highestIndex;

	}

}