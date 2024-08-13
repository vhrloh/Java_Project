import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

enum Zodiac
{
    Rat 		("RAT", "1948"),
	Ox 		    ("OX", "1949"),
	Tiger 		("TIGER", "1950"),
	Rabbit 		("RABBIT", "1951"),
	Dragon 		("DRAGON", "1952"),
	Snake 		("SNAKE", "1953"),
	Horse 		("HORSE", "1954"),
	Goat 	    ("GOAT", "1955"),
	Monkey      ("MONKEY", "1956"),
	Rooster 	("ROOSTER", "1957"),
	Dog 	    ("DOG", "1958"),
	Pig 		("PIG", "1959");

    // final instance variables
    private final String abbreviation;
    private final String year;

    // constructor
    Zodiac(String abbreviation, String year)
    {
        this.abbreviation = abbreviation;
        this.year = year;
    }

    // accessor methods
    public String getAbbreviation()
    {
        return abbreviation;
    }

    public String getYear()
    {
        return year;
    }
}

class Set
{
    // creating ArrayList for Zodiac
    private ArrayList <Zodiac> s;

    // default constructor
    public Set()
    {
        this.s = new ArrayList <> ();
    }

    // copy constructor
    public Set(Set otherSet)
    {
        this.s = new ArrayList <> ();

        for (Zodiac z : otherSet.s)
        {
            s.add(z);
        }
    }

    // method to check if set is empty
    public boolean isEmpty()
    {
        return s.isEmpty();
    }

    // method to return the number of elements in the set
    public int cardinality()
    {
        return s.size();
    }

    // method to check if the element is in the set
    public boolean belongTo(Zodiac element)
    {
        return s.contains(element);
    }

    // method to add new element without duplication
    public void addElement(Zodiac element)
    {
        if(!belongTo(element))
        {
            s.add(element);
        }
    }

    // method to check if sets are subjects of each other
    public boolean subset(Set otherSet)
    {
        return otherSet.s.containsAll(s);
    }

    // method to find the union of 2 sets
    public void union(Set otherSet)
    {
        for(Zodiac z : otherSet.s)
        {
            if(!s.contains(z))
            {
                s.add(z);
            }
        }
    }

    // method to find the intersection of 2 sets
    public void intersection(Set otherSet)
    {
        s.retainAll(otherSet.s);
    }

    // method to find the difference of 2 sets
    public void difference(Set otherSet)
    {
        for(Zodiac z : otherSet.s)
        {
            if(s.contains(z))
            {
                s.remove(z);
            }
        }
    }

    // method to get the complement of a set
    public Set complement()
    {
        Set a = new Set();

        for(Zodiac z : Zodiac.values())
        {
            if(!s.contains(z))
            {
                a.addElement(z);
            }
        }
        return a;
    }

    // method to check the equality of 2 sets
    public boolean equality(Set otherSet)
    {
        if((subset(otherSet)) && (s.containsAll(otherSet.s)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getEnumFormat()
    {
        String start = "{";
        String end = "}";
        String comma = ", ";
        String names = start;

        if(s.isEmpty())
        {
            names += end;
        }
        else
        {
            for(int i = 0; i < s.size(); i++)
            {
                names = names + s.get(i).name();

                if(!(i == (s.size() - 1)))
                {
                    names = names + comma;
                }
                else
                {
                    names = names + end;
                }
            }
        }
        return names;
    }

    public String getYearFormat()
    {
        String start = "{";
        String end = "}";
        String comma = ", ";
        String names = start;

        if(s.isEmpty())
        {
            names += end;
        }
        else
        {
            for(int i = 0; i < s.size(); i++)
            {
                names = names + s.get(i).getYear();

                if(!(i == (s.size() - 1 )))
                {
                    names = names + comma;
                }
                else
                {
                    names = names + end;
                }
            }
        }
        return names;
    }

    // to override the enumformat as default to toString method
    @Override

    public String toString()
    {
        String start = "{";
        String end = "}";
        String comma = ", ";
        String names = start;

        if(s.isEmpty())
        {
            names += end;
        }
        else
        {
            for(int i = 0; i < s.size(); i++)
            {
                names = names + s.get(i).getAbbreviation();

                if(!(i == (s.size() - 1 )))
                {
                    names = names + comma;
                }
                else
                {
                    names = names + end;
                }
            }
        }
        return names;
    }
}

class VincentLoh_A1
{
    // declare variable
    private static Scanner input;

    // method to display universal set
    private static void displayZodiacInfo()
    {
        System.out.println();
        System.out.println("Universal set info");
        System.out.println();

        System.out.printf("%-15s%-15s%-15s%n", 
								"Zodiac Sign", "Known as", "For example");
        
        for(Zodiac z : Zodiac.values())
        {
            System.out.printf("%-15s%-15sYear %-15s%n",
                                z, z.getAbbreviation(), z.getYear());
        }
        System.out.println();
    }

    // method to get a random element
    private static Zodiac getAnElement()
    {
        int ranElement = new Random().nextInt(Zodiac.values().length);
        return Zodiac.values()[ranElement];
    }

    // method to generate random set
    private static Set getASet()
    {
        Random rand;
        rand = new Random();
        int i = rand.nextInt(12);
        Set randomSet = new Set();

        for(int a = 0; a < i; a++)
        {
            Zodiac z = getAnElement();

            if(randomSet.isEmpty())
            {
                randomSet.addElement(z);
            }
            if(!randomSet.belongTo(z))
            {
                randomSet.addElement(z);
            }
        }
        return randomSet;
    }

    private static void displayMenu()
    {
        System.out.println("Welcome to SIM Set Theory Lesson");
		System.out.println();
		System.out.println("0: Properties of set");
		System.out.println("1. Union example");
		System.out.println("2. Intersection example");
		System.out.println("3. Subset example");
		System.out.println("4. Difference example");
		System.out.println("5. Complement example");
		System.out.println("6. Sets equality example");
		System.out.println("7. Distributive Law 1");
        System.out.println("8. Distributive Law 2");
		System.out.println("9. Quit");
		System.out.println();
    }

    private static void unionExample()
    {
        Set a = getASet();
        Set b = getASet();

        System.out.println("Given sets");
        System.out.printf("\tA = %s%n", a);
        System.out.printf("\tB = %s%n", b);

        a.union(b);

        System.out.printf("\tUnion of A and B = %s%n", a);
        System.out.println("-----------------------------------");
        System.out.println();
    }

    // method to generate an intersection example
    private static void intersectionExample()
    {
        Set a = getASet();
		Set b = getASet();
		
		System.out.println("Given sets");
		System.out.printf("\tA = %s%n", a);
		System.out.printf("\tB = %s%n", b);
		
		a.intersection(b);
		
		System.out.printf("\tIntersection of A and B = %s%n", a);
		System.out.println("--------------------------------");
		System.out.println();
    }

    // method to generate a subset example
    private static void subsetExample()
    {
        Set a = getASet();
		Set b = getASet();
		
		System.out.println("Given sets");
		System.out.printf("\tA = %s%n", a);
		System.out.printf("\tB = %s%n", b);
		System.out.println();
		
		System.out.println("Conclusion");
		System.out.printf("\tA subset of B: %s%n", a.subset (b));
        System.out.printf("\tB subset of A: %s%n", b.subset (a));
		System.out.println("--------------------------------");
		System.out.println();
    }

    // method to generate a difference example
    private static void differenceExample()
    {
        Set a = getASet();
		Set b = getASet();
		
		System.out.println("Given sets");
		System.out.printf("\tA = %s%n", a);
		System.out.printf("\tB = %s%n", b);
		System.out.println();
		
		a.difference (b);
		
		System.out.printf("\tA - B = %s%n", a);
		System.out.println("--------------------------------");
		System.out.println();
    }

    // method to generate a complement example
    private static void complementExample()
    {
        Set a = getASet();
		System.out.println("Given sets");
		System.out.printf("\tA = %s%n", a);
		System.out.println();
		System.out.printf("\tA' = %s%n", a.complement ());
		System.out.println("--------------------------------");
		System.out.println();
    }

    // method to generate an equality example
    private static void equalityExample()
    {
        Set a = getASet();
		Set b = getASet();
		
		System.out.println("Given sets");
		System.out.printf("\tA = %s%n", a);
		System.out.printf("\tB = %s%n", b);
		System.out.println();
		System.out.println("Analysis");
		System.out.printf("\tA subset of B: %s%n", a.subset (b));
        System.out.printf("\tB subset of A: %s%n", b.subset (a));
		System.out.println();
		System.out.println("Conclusion");
		System.out.printf("\tA equals to B: %s%n", a.equality (b));
		System.out.println ("--------------------------------");
		System.out.println ();
    }

    // method to show distributive law example
    private static void distributiveLaw()
    {
        Set aL = getASet();
		Set bL = getASet();
		Set cL = getASet(); //LHS variables
		
		Set aR = new Set(aL);
		Set bR = new Set(bL);
		Set cR = new Set(cL); //RHS variables
		
		System.out.println("We wish to prove: A U (B I C) = (A U B) I (A U C)");
		System.out.println();
		System.out.println("Given sets");
		System.out.printf("\tA = %s%n", aL);
		System.out.printf("\tB = %s%n", bL);
		System.out.printf("\tC = %s%n", cL);
		System.out.println();
		
        // method for B intersection C
		bL.intersection(cL);
        // method for A union (B I C)
		aL.union(bL);
		
		System.out.println("LHS analysis");
		System.out.printf("\tLHS = %s%n", aL); //LHS final
		System.out.println();
		
        // method for B union A / A union B
		bR.union(aR);
        // method for A union C
		aR.union(cR);
        // method for (A U B) I (A U C)
		aR.intersection(bR);
		
		System.out.println("RHS analysis");
		System.out.printf("\tRHS = %s%n", aR); //final RHS
		System.out.println();
		System.out.println("Conclusion");
		System.out.printf("\tLHS = RHS is %s%n", aL.equality (aR));
		System.out.println("--------------------------------");
		System.out.println();
    }

    public static void distributiveLaw2()
    {
        Set aL = getASet();
        Set bL = getASet();
        Set cL = getASet(); // LHS variables

        Set aR = new Set(aL);
        Set bR = new Set(bL);
        Set cR = new Set(cL); // RHS variables

        System.out.println("We wish to prove: A I (B U C) = (A I B) U (A I C)");
        System.out.println();
        System.out.println("Given sets");
        System.out.printf("\tA = %s%n", aL);
		System.out.printf("\tB = %s%n", bL);
		System.out.printf("\tC = %s%n", cL);
		System.out.println();

        // method for B union C
        bL.union(cL);
        // method for A I (B U C)
        aL.intersection(bL);

        System.out.println("LHS analysis");
		System.out.printf("\tLHS = %s%n", aL); //LHS final
		System.out.println();

        // method for A union B / B union A
        bR.intersection(aR);
        // method for A U C
        aR.intersection(cR);
        // method for (A U B) I (A U C)
        aR.union(bR);

        System.out.println("RHS analysis");
		System.out.printf("\tRHS = %s%n", aR); //final RHS
		System.out.println();
		System.out.println("Conclusion");
		System.out.printf("\tLHS = RHS is %s%n", aL.equality (aR));
		System.out.println("--------------------------------");
		System.out.println();
    }

    public static void displaySubmenu()
    {
        System.out.println("Some basic operations in set");
		System.out.println("\t1. Add an element");
		System.out.println("\t2. Check an element");
		System.out.println("\t3. Cardinality");
		System.out.println("\t4. Enum format");
        System.out.println("\t5. Year format");
		System.out.println("\t9. Quit");
		System.out.println();
    }

    public static void anExample()
    {
        input = new Scanner(System.in);
		
		Set a = getASet();
		
		System.out.println("Here is an example of set");
		System.out.printf("\tA = %s%n", a);
		System.out.println("\tAll elements in set are distinct and random order");
		System.out.println();
		displaySubmenu();
		System.out.print("Enter your option: ");
		int sub = input.nextInt();
		System.out.println();
		
		while (sub != 9)
		{
			switch (sub)
			{
				case 1:
				System.out.print("Enter an element: ");
				Zodiac toAdd = Zodiac.valueOf(input.next());
				
				a.addElement(toAdd);
				
				System.out.printf("A = %s%n", a);
				System.out.println("--------------------------------");
				System.out.println();
				break;
				
				case 2:
				System.out.print("Enter an element: ");
				Zodiac toCheck = Zodiac.valueOf(input.next());
				
				if (a.belongTo(toCheck))
					{
						System.out.printf("Element %s is in set%n", toCheck);
						System.out.println("--------------------------------");
						System.out.println();
					}
				else
					{
						System.out.printf("Element %s is not in set%n", toCheck);
						System.out.println("--------------------------------");
						System.out.println();
					}
				break;
				
				case 3:
				System.out.printf("No of elements in set is %d%n", a.cardinality());
				System.out.println("--------------------------------");
				System.out.println();
				break;
				
				case 4:
				System.out.println("Notation in enum format");
				System.out.printf("\tA = %s%n", a.getEnumFormat());
				System.out.println("--------------------------------");
				System.out.println();
				break;
				
                case 5:
                System.out.println("Notation in year format");
                System.out.printf("\tA = %s%n", a.getYearFormat());
                System.out.println("--------------------------------");
                System.out.println();
                break;

				case 9:
				input.close();
			}
			
			displaySubmenu();
			System.out.print("Enter your option: ");
			sub = input.nextInt();
			System.out.println();
		}
    }

    public static void main(String [] args)
    {
        input = new Scanner(System.in);
		
		displayZodiacInfo();
		displayMenu();
		System.out.print("Your option: ");
		int main = input.nextInt();
		System.out.println();
		
		while(main != 9)
		{
			switch(main)
			{
				case 0:
				anExample();
				break;
				
				case 1:
				unionExample();
				break;
				
				case 2:
				intersectionExample();
				break;
				
				case 3:
				subsetExample();
				break;
				
				case 4:
				differenceExample();
				break;
				
				case 5:
				complementExample();
				break;
				
				case 6:
				equalityExample();
				break;
				
				case 7:
				distributiveLaw();
				break;

                case 8:
                distributiveLaw();
                break;
				
				case 9:
				input.close();
			}
			
			displayMenu();
			System.out.print("Your option: ");
			main = input.nextInt();
			System.out.println();
		}
    }
}