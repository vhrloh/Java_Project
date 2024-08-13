import java.util.Scanner;
import java.io.File;
import java.io.IOException;

enum Gender {Male, Female}

class Date
{
	// Declare variables
	int day, year;
	String month;
	
	// other constructor
	public Date(int day, String month, int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	// accessor method
	public int getDay()
	{
		return day;
	}
	
	public String getMonth()
	{
		return month;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public String getDateString()
	{
		return day + " " + month +", " + year;
	}
}

class HeightInfo
{
	// declare variables
	int feet, inches;
	
	// other constructor
	public HeightInfo(int feet, int inches)
	{
		this.feet = feet;
		this.inches = inches;
	}
	
	// copy constructor
	public HeightInfo(HeightInfo hi)
	{
		this (hi.feet, hi.inches);
	}
	
	// accessor method
	public int getFeet()
	{
		return feet;
	}
	
	public int getInches()
	{
		return inches;
	}
	
	// mutator method
	public void setHeightInfo(int feet, int inches)
	{
		this.feet = feet;
		this.inches = inches;
	}
	
	// compute height in cm
	public double getHeight()
	{
		double cm = (feet * 30.48) + (inches * 2.54);
		return cm;
	}
}

class HealthProfile
{
	// declare variables
	private String firstName, lastName;
	private Date dob;
	private HeightInfo hi;
	private Gender g;
	private double weight;
	
	// default constructor
	public HealthProfile()
	{
		
	}
	
	//other constructor
	public HealthProfile(String firstName, String lastName, Date dob, 
								HeightInfo hi, Gender g, double weight)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.hi = hi;
		this.g = g;
		this.weight = weight;
	}
	
	// copy constructor
	public HealthProfile(HealthProfile hp)
	{
		this(hp.firstName, hp.lastName, hp.dob, hp.hi, hp.g, hp.weight);
	}
	
	// accessor method
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public Date getDOB()
	{
		return dob;
	}
	
	public HeightInfo getHeightInfo()
	{
		return hi;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	// compute BMI
	private double computeBMI()
	{
		double height = hi.getHeight() / 100;
		double bmi = getWeight() / (height * height);
		return bmi;
	}
	
	// return BMI
	public double getBMI()
	{
		return computeBMI();
	}
	
	// mutator method
	public void setInfo(String firstName, String lastName, Date dob, 
								HeightInfo height, Gender g, double weight)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.hi = hi;
		this.g = g;
		this.weight = weight;
	}
	
	// display the patient
	public void printProfile()
	{
		System.out.printf("Name : %s %s%n", getFirstName(), getLastName());
		System.out.printf("Date of birth : %s%n", dob.getDateString());
		System.out.printf("Height : %d feet %d inches%n", hi.getFeet(), hi.getInches());
		System.out.printf("Height (in cm) : %.2f%n", hi.getHeight());
		System.out.printf("Gender : %s%n", g);
		System.out.printf("Weight : %.1f kilo%n", getWeight());
		System.out.printf("Your BMI : %.2f%n", getBMI());
	}
}

class VincentLoh_A2
{
	// main method
	public static void main(String [] args) throws IOException
	{
		// define scanner class object
		Scanner input = new Scanner (new File ("info.txt"));
		
		// declare variables
		String firstName, lastName, month;
		int day, year, feet, inches;
		Gender g;
		double weight;
		
		// extract first information from text tile
		System.out.println("Patient 1");
		firstName = input.nextLine();
		lastName = input.nextLine();
		day = input.nextInt();
		month = input.next();
		year = input.nextInt();
		feet = input.nextInt();
		inches = input.nextInt();
		g = Gender.valueOf(input.next());
		weight = input.nextDouble();
		
		// constructing first set of objects
		HeightInfo hi = new HeightInfo(feet, inches);
		Date dob = new Date (day, month, year);
		HealthProfile hp = new HealthProfile (firstName, lastName, dob, hi, g, weight);
		
		// display HealthProfile object
		hp.printProfile();
		
		input.nextLine(); // clearing buffer
		System.out.println();
		
		// extract second information from text tile
		System.out.println("Patient 2");
		firstName = input.nextLine();
		lastName = input.nextLine();
		day = input.nextInt();
		month = input.next();
		year = input.nextInt();
		feet = input.nextInt();
		inches = input.nextInt();
		g = Gender.valueOf(input.next());
		weight = input.nextDouble();
		
		// constructing second set of objects
		HeightInfo hi1 = new HeightInfo(feet, inches);
		Date dob1 = new Date (day, month, year);
		HealthProfile hp1 = new HealthProfile (firstName, lastName, dob1, hi1, g, weight);
		
		// display HealthProfile object
		hp1.printProfile();
	}
}