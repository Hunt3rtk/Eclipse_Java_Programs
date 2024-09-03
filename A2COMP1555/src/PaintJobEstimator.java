import java.util.Scanner;
//importing scanner


public class PaintJobEstimator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		// Create a scanner object to read from the keyboard Scanner keyboard = new Scanner(System.in);
		
		int rooms;
		float paintPerGallon;
		int squareFeet;
		//declaring variables
		
		System.out.print("Enter the number of rooms being painted:");
		//asking for number of rooms being painted
		rooms = keyboard.nextInt();
		//getting the number of rooms being painted
		
		System.out.print("Enter the paint per gallon price:");
		//asking for the paint per gallon price
		paintPerGallon = keyboard.nextFloat();
		//getting the paint per gallon price
		
		System.out.print("Enter the wall square feet per room:");
		//asking for the wall square feet per room
		squareFeet = keyboard.nextInt();
		//getting the wall square feet per room
		
		
		//Printing out the results
		System.out.println("The gallons of paint required is:" + gallonsRequired(rooms,squareFeet));
		
		System.out.println("The hours of labour required is:" + labourHours(rooms,squareFeet));
		
		System.out.println("The cost of paint is:" + paintCost(rooms,squareFeet,paintPerGallon));
		
		System.out.println("The cost of labour is:" + labourCharges(rooms,squareFeet));
		
		System.out.println("The total cost is:" + totalCost(rooms,squareFeet,paintPerGallon));
		//Printing out the results
		
		
	}
	
	//method to calculate the gallons required
	public static double gallonsRequired(int rooms, int squarefeet)
	{
		double gallonsRequired = (rooms*squarefeet)/115;
		
		return gallonsRequired;
	}
	
	//method to calculate the labour hours
	public static double labourHours(int rooms, int squarefeet)
	{
		double labourHours = ((rooms*squarefeet)/115)*8;
		
		return labourHours;
	}
	
	//method to calculate the cost of paint
	public static double paintCost(int rooms, int squarefeet, float paintPerGallon)
	{
		double paintCost = ((rooms*squarefeet)/115)*paintPerGallon;
		
		return paintCost;
	}
	
	//method to calculate the cost of labour
	public static double labourCharges(int rooms, int squarefeet)
	{
		double labourCharges = (((rooms*squarefeet)/115)*8)*18;
		
		return labourCharges;
	}
	
	//method to calculate the total cost
	public static double totalCost(int rooms, int squarefeet, float paintPerGallon)
	{
		double labourCharges = (((rooms*squarefeet)/115)*8)*18;
		
		double paintCost = ((rooms*squarefeet)/115)*paintPerGallon;
		
		double totalCost = labourCharges + paintCost;
		
		return totalCost;
	}
	
	

}
