import java.util.ArrayList;

class Country
{
    private String name, player;
    private int age;

    // other constructor
	public Country(String name, String player, int age)
	{
		this.name = name;
		this.player = player;
		this.age = age;
	}
	
	// accessor method
	public String getName()
	{
		return name;
	}
	
	public String getPlayer()
	{
		return player;
	}
	
	public int getAge()
	{
		return age;
	}
	
	// mutator method
	public void setInfo(String name, String player, int age)
	{
		this.name = name;
		this.player = player;
		this.age = age;
	}
}

class Diving
{
	public static int SIZE = 10;
	private Country name;
	private double [ ] score;
	private double difficulty;
	
	// other constructor
	public Diving(Country name, double difficulty)
	{
		this.name = name;
		this.difficulty = difficulty;
        score = new double [SIZE]; 
        getScore();
	}
	
	// accessor method
	public Country getCountry()
	{
		return name;
	}
	
	public double getDifficulty()
	{
		return difficulty;
	}
	
	// mutator method
	public void setDifficulty(double difficulty)
	{
		this.difficulty = difficulty;
	}
	
	// method to compute score
	private void getScore()
	{
        for(int i = 0; i < score.length; i++)
        {
            score [i] = Math.random() * 10;
        }
	}
	
	// print info
	public void printInfo()
	{
		System.out.printf("%-16s", name.getName());
        for(double judge : score)
        {
            System.out.printf("%-8.1f", judge);
        }
        System.out.printf("%10.1f", getDifficulty());
        System.out.printf("%11.2f", finalScore());
        System.out.println();
	}
	
	// method to compute the higest score
	private double highest()
	{
        double highest = 0.0;

		for(int i = 0; i < score.length; i++)
        {
            if(score [i] > highest)
            {
                highest = score [i];
            }
        }
        return highest;
	}
	
	// method to compute the second highest score
	private double secondHighest()
	{
		double secondHighest = 0.0;

		for(int i = 0; i < score.length; i++)
        {
            if((score [i] > secondHighest) && 
                (score [i] < highest()))
            {
                secondHighest = score [i];
            }
        }
        return secondHighest;
	}
	
	// method to compute the lowest score
	private double lowest()
	{
		double lowest = 0.0;

		for(int i = 0; i < score.length; i++)
        {
            if(score [i] < lowest)
            {
                lowest = score [i];
            }
        }
        return lowest;
	}
	
	// method to compute the second lowest score
	private double secondLowest()
	{
		double secondLowest = 0.0;

		for(int i = 0; i < score.length; i++)
        {
            if((score [i] < secondLowest) && 
                (score [i] > lowest()))
            {
                secondLowest = score [i];
            }
        }
        return secondLowest;
	}
	
	// method to compute the final score
	public double finalScore()
	{
		double total = 0.0;

        for(int i = 0; i < score.length; i++)
        {
            if(score [i] == highest() || score [i] == secondHighest() ||
				score [i] == lowest() || score [i] == secondLowest())
            {
                continue;
            }
            total += score [i];
        }
        return total * getDifficulty();
	}
}

class VincentLoh_A3
{
	// added static so that i can pull from main method using ArrayList
	private static final String [ ] Countries = new String [ ] {"Singapore", "China", "Thailand", "China", "South Korea"
									, "Japan", "USA", "France", "Germany", "Australia"};
	
	public static Country getChampion(ArrayList <Diving> alist)
	{
        Diving champion = alist.get(0);

		for(Diving d : alist)
		{
			if(d.finalScore() > champion.finalScore())
			{
				champion = d;
			}
		}
		return champion.getCountry();
	}
	
	public static Country firstRunnerUp(ArrayList <Diving> alist)
	{
		Diving runnerUp = alist.get(0);

		for(Diving d : alist)
		{
			if(d.finalScore() > runnerUp.finalScore() && d.getCountry() != getChampion(alist))
			{
				runnerUp = d;
			}
		}
		return runnerUp.getCountry();
	}
	
	private static double getDifficulty()
	{
		return Math.random() * (5 - 2) + 2;
	}
	
	private static int getAge()
	{
		double age = Math.random() * (30-15) + 15;
		return (int) age;
	}
	
	private static void displayGameInfo(ArrayList <Diving> alist)
	{
		System.out.printf("%-17s%-15s%-17s%-5s%n","Countries", "Diver", "Age", "Difficulty");

        for (Diving d : alist)
        {
            System.out.printf("%-17s", d.getCountry().getName());
            System.out.printf("%-16s", d.getCountry().getPlayer());
            System.out.printf("%-23s", d.getCountry().getAge());
            System.out.printf("%-10.1f", d.getDifficulty());
            System.out.println();
        }
	}
	
	private static void displayResultInfo(ArrayList <Diving> alist)
	{
		System.out.printf("%-17s", "Countries");
		for (int i = 0; i < 10; i++)
		{
			if(i != 8)
			{
				System.out.printf("%s%-7d", "J", i + 1);
			}
			else
			{
				System.out.printf("%s%-6d", "J", i + 1);
			}
				
		}

		System.out.printf("%-16s%5s", "Difficulty", "Final");
		System.out.println();

        for (Diving d : alist)
        {
            d.printInfo();
        }
	}
	
	// main method
	public static void main(String [ ] args)
	{
        ArrayList <Country> countryList = new ArrayList <Country> ();
		for(int i = 0; i < Countries.length; i++)
		{
			String player = "Name " + (i + 1);
			countryList.add(new Country(Countries[i], player, getAge()));
		}

		ArrayList <Diving> divingList = new ArrayList <Diving> ();
		for(int i = 0; i < Countries.length; i++)
		{
			divingList.add(new Diving (countryList.get(i), getDifficulty()));
		}

		displayGameInfo(divingList);
		System.out.println();
		displayResultInfo(divingList);

		// display champion and first runner up
		System.out.println();
		System.out.printf("The result is%n");
		System.out.printf("The Champion: %s, %s%n", getChampion(divingList).getPlayer(), getChampion(divingList).getName());
		System.out.printf("1st runner up: %s, %s%n", firstRunnerUp(divingList).getPlayer(), firstRunnerUp(divingList).getName());
	}
}