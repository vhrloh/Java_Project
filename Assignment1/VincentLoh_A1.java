import java.util.Scanner;

class VincentLoh_A1
{
	// Declare a line constant
	private static String Line = "----------";
	
	public static void main (String [] args)
	{
		// Construct a scanner class object
		Scanner input = new Scanner(System.in);
		
		// Construct title
		System.out.println("Welcome to Motorcycle Helmet online service");
		System.out.println(Line + Line + Line + Line + Line);
			
		// Declare variables
		String i1, i2, i3;
		int q1, q2, q3;
		double p1, p2, p3;
		int qo1, qo2, qo3;
		
		
		//--------------------------------------Task 1-----------------------------------------//
		
		// Construct instruction and read user input
		System.out.println("Enter three items to be sold");
		System.out.printf("1. ");
		i1 = input.nextLine ();
		System.out.printf("2. ");
		i2 = input.nextLine ();
		System.out.printf("3. ");
		i3 = input.nextLine ();
		
		//--------------------------------------Task 2-----------------------------------------//
		
		// Allow user enter quantities and cost for each items
		System.out.println();
		System.out.printf("Enter the quantities and price of " + i1 + ": ");
		q1 = input.nextInt ();
		p1 = input.nextDouble ();
		
		System.out.printf("Enter the quantities and price of " + i2 + ": ");
		q2 = input.nextInt ();
		p2 = input.nextDouble ();
		
		System.out.printf("Enter the quantities and price of " + i3 + ": ");
		q3 = input.nextInt ();
		p3 = input.nextDouble ();
		
		// Display summary
		System.out.println();
		System.out.println("Summary of items");
		System.out.println(Line + Line);
		
		// Display table
		System.out.println();
		System.out.printf("%-20s%-15s%-10s%n", 
											 "Brand", "Quantity", "Price");
		System.out.println(Line + Line + Line + Line);
		System.out.printf("%-20s%-15d%-10.2f%n",
												 i1, q1, p1);	// Item 1
		System.out.printf("%-20s%-15d%-10.2f%n", 
												 i2, q2, p2);	// Item 2
		System.out.printf("%-20s%-15d%-10.2f%n", 
												 i3, q3, p3);	// Item 3
		System.out.println(Line + Line + Line + Line);
		
		//--------------------------------------Task 3-----------------------------------------//
		
		// Display summary after swap
		System.out.println();
		System.out.println("Summary of items after the swaps");
		System.out.println(Line + Line + Line + Line);
		
		// Construct swap
		String temp1 = i1;
		i1 = i2;
		i2 = temp1;
		
		int temp2 = q1;
		q1 = q2;
		q2 = temp2;
		
		double temp3 = p1;
		p1 = p2;
		p2 = temp3;
		
		// Display table
		System.out.println();
		System.out.printf("%-20s%-15s%-10s%n", 
											 "Brand", "Quantity", "Price");
		System.out.println(Line + Line + Line + Line);
		System.out.printf("%-20s%-15d%-10.2f%n",
												 i1, q1, p1);	// Item 1
		System.out.printf("%-20s%-15d%-10.2f%n",
												 i2, q2, p2);	// Item 2
		System.out.printf("%-20s%-15d%-10.2f%n", 
												 i3, q3, p3);	// Item 3
		System.out.println(Line + Line + Line + Line);
		
		//--------------------------------------Task 4(a)-----------------------------------------//
		
		// Display title
		System.out.println();
		System.out.println("Please place your order");
		System.out.println(Line + Line + Line);
		
		// Allow user to enter quantity of order
		System.out.printf("No of " + i1 + ": ");
		qo1 = input.nextInt();
		System.out.printf("No of " + i2 + ": ");
		qo2 = input.nextInt();
		System.out.printf("No of " + i3 + ": ");
		qo3 = input.nextInt();
		
		//--------------------------------------Task 4(b)-----------------------------------------//
		
		// Declare variables
		double t1, t2, t3, subtotal, gst, totalcost;
		
		// Display summary
		System.out.println();
		System.out.println("Summary of report of orders");
		System.out.println(Line + Line + Line);
		
		// Construct cost calculation
		t1 = qo1 * p1;
		t2 = qo2 * p2;
		t3 = qo3 * p3;
		
		// Construct subtotal calculation
		subtotal = t1 + t2 + t3;
		
		// Construct GST calculation
		gst = (subtotal / 100) * 7;
		
		// Construct Totalcost calculation
		totalcost = subtotal + gst;
		
		// Display summary table
		System.out.println();
		System.out.printf("%-20s%-10s%10s%n", 
											 "Brand", "Quantity", "Cost");
		System.out.println(Line + Line + Line + Line);
		System.out.printf("%-20s%-10d%10.2f%n",
											 i1, qo1, t1);	// Item 1
		System.out.printf("%-20s%-10d%10.2f%n",
											 i2, qo2, t2);	// Item 2
		System.out.printf("%-20s%-10d%10.2f%n",
											 i3, qo3, t3);	// Item 3
		System.out.println(Line + Line + Line + Line);
		System.out.printf("%-30s%10.2f%n",
										 "Subtotal :", subtotal);	// Subtotal
		System.out.printf("%-30s%10.2f%n",
										 "GST (7%) :", gst);	// GST (7%)
		System.out.printf("%-30s%10.2f%n",
										 "Total cost :", totalcost);	// Totalcost
		System.out.println(Line + Line + Line + Line);

		//--------------------------------------Task 5-----------------------------------------//
		
		// Display balance report
		System.out.println();
		System.out.println("Balance report");
		System.out.println(Line + Line);
		
		// Declare variables
		int bal1, bal2, bal3;
		
		// Construct balance
		bal1 = q1 - qo1;
		bal2 = q2 - qo2;
		bal3 = q3 - qo3;
		
		// Display balance report table
		System.out.println();
		System.out.printf("%-20s%-10s%-10s%-10s%n", 
													 "Brand", "Quantity", "Sold", "Balance");
		System.out.println(Line + Line + Line + Line + Line);
		System.out.printf("%-20s%-10d%-10d%-10d%n",
											 i1, q1, qo1, bal1);	// Item 1
		System.out.printf("%-20s%-10d%-10d%-10d%n",
											 i2, q2, qo2, bal2);	// Item 2
		System.out.printf("%-20s%-10d%-10d%-10d%n",
											 i3, q3, qo3, bal3);	// Item 3
		System.out.println(Line + Line + Line + Line + Line);
	}
}