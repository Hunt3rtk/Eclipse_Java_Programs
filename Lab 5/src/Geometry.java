import java.util.Scanner;

/**
This program demonstrates static methods
*/

public class Geometry {
	
	public static void main(String[] args) {
	
		int choice;	// The user's choice
		
		double value = 0; // The method's return value
		
		char letter;	// The user's Y or N decision
		
		double radius;   // The radius of the circle
		
		double length;   // The length of the rectangle
		
		double width;	// The width of the rectangle
		
		double height;   // The height of the triangle
		
		double base;	// The base of the triangle
		
		double side1;	// The first side of the triangle
		
		double side2;	// The second side of the triangle
		
		double side3;	// The third side of the triangle
		
		
		Scanner keyboard = new Scanner(System.in);
		// Create a scanner object to read from the keyboard Scanner keyboard = new Scanner(System.in);
		
		// The do loop allows the menu to be displayed first do
		{
		// TASK #1 Call the printMenu method choice = keyboard.nextInt();
			
			printMenu();
			
			choice = keyboard.nextInt();
		
			switch (choice)
			{
			case 1:
			System.out.print("Enter the radius of " +
			"the circle: ");
			radius = keyboard.nextDouble();
		
			// TASK #3 Call the circleArea method and // store the result in the value variable
			
			value = circleArea(radius);
		
			System.out.println("The area of the " +
			"circle is " + value);
			break;
			case 2:
			System.out.print("Enter the length of " +
			"the rectangle: "); length = keyboard.nextDouble(); System.out.print("Enter the width of " +
			"the rectangle: ");
			width = keyboard.nextDouble();
			
			value = rectangleArea(length,width);
		
			// TASK #3 Call the rectangleArea method and // store the result in the value variable
		
			System.out.println("The area of the " +
			"rectangle is " + value);
			break;
			case 3:
			System.out.print("Enter the height of " +
			"the triangle: "); height = keyboard.nextDouble(); System.out.print("Enter the base of " +
			"the triangle: ");
			base = keyboard.nextDouble();
			
			value = triangleArea(base,height);
		
			// TASK #3 Call the triangleArea method and // store the result in the value variable
		
			System.out.println("The area of the " +
			"triangle is " + value);
			break;
			case 4:
			System.out.print("Enter the radius of " +
			"the circle: ");
			radius = keyboard.nextDouble();
			
			value = circleCircumference(radius);
		
			// TASK #3 Call the circumference method and // store the result in the value variable
		
			System.out.println("The circumference " + "of the circle is " + value);
			break;
			case 5:
			System.out.print("Enter the length of " +
			"the rectangle: "); length = keyboard.nextDouble(); System.out.print("Enter the width of " +
			"the rectangle: ");
			width = keyboard.nextDouble();
			
			value = rectanglePerimeter(length,width);
		
			// TASK #3 Call the perimeter method and // store the result in the value variable
		
			System.out.println("The perimeter of " + "the rectangle is " + value);
			break;
			case 6:
			System.out.print("Enter the length of " + "side 1 of the " + "triangle: ");
			side1 = keyboard.nextDouble();
			System.out.print("Enter the length of " + "side 2 of the " + "triangle: ");
			side2 = keyboard.nextDouble();
			System.out.print("Enter the length of " + "side 3 of the " + "triangle: ");
			side3 = keyboard.nextDouble();
			
			
			value = trianglePerimeter(side1,side2,side3);
		
			// TASK #3 Call the perimeter method and // store the result in the value variable
		
			System.out.println("The perimeter of " + "the triangle is " + value);
			break;
			default:
			System.out.println("You did not enter " +
			"a valid choice.");
		
			}
			
			keyboard.nextLine(); // Consume the new line
		
			System.out.println("Do you want to exit " +
			"the program (Y/N)?: ");
			String answer = keyboard.nextLine(); letter = answer.charAt(0);
		
			} while(letter != 'Y' && letter != 'y');
		
			}
		
		// TASK #1 Create the printMenu method here
	/**
	 *This method asks the user which calculator they want to use.
	 *It requires nothing to operate but it needs the different calculators to not confuse the user.
	 *@return It returns a printed message asking which calculator is needed 
	 */
	public static void printMenu() {
		
		System.out.print
			(
				"This is a geometry calculator\r\n" + 
				"Choose what you would like to calculate\r\n" + 
				"1. Find the area of a circle\r\n" + 
				"2. Find the area of a rectangle\r\n" + 
				"3. Find the area of a triangle\r\n" + 
				"4. Find the circumference of a circle\r\n" + 
				"5. Find the perimeter of a rectangle\r\n" + 
				"6. Find the perimeter of a triangle\r\n" +
				"Enter the number of your choice:\r\n"
			);
	
	}

		// TASK #2 Create the value-returning methods here // TASK #4 Write javadoc comments for each method
	
	
	/**
	 *This method calculates the area of a circle.
	 *It requires the radius so it can compute and then return the area.
	 *@param radius the radius of the circle
	 *@return It returns the computed area of the given circle 
	 */
	public static double circleArea(double radius)
	{
		double area = 3.14*(radius*radius);
		
		return area;
		
	}
	
	/**
	 *This method calculates the area of a rectangle.
	 *It requires the length and width so it can compute and then return the area.
	 *@param length the length of the rectangle
	 *@param width the width of the rectangle
	 *@return It returns the computed area of the given rectangle 
	 */
	public static double rectangleArea(double length, double width)
	{
		double area = length*width;
		
		return area;
	}
	
	/**
	 *This method calculates the area of a triangle.
	 *It requires the base and height so it can compute and then return the area.
	 *@param base the base of the triangle
	 *@param height the height of the triangle
	 *@return It returns the computed area of the given triangle 
	 */
	public static double triangleArea(double base, double height)
	{
		double area = .5*base*height;
		
		return area;
	}
	
	/**
	 *This method calculates the circumference of a circle.
	 *It requires the radius so it can compute and then return the circumference.
	 *@param radius the radius of the circle
	 *@return It returns the computed circumference of the given circle 
	 */
	public static double circleCircumference(double radius)
	{
		double circumference = 6.28*radius;
		
		return circumference;
	}
	
	/**
	 *This method calculates the perimeter of a rectangle.
	 *It requires the length and width so it can compute and then return the perimeter.
	 *@param length the length of the rectangle
	 *@param width the width of the rectangle
	 *@return It returns the computed perimeter of the given rectangle 
	 */
	public static double rectanglePerimeter(double length, double width)
	{
		double perimeter = 2*length+2*width;
		
		return perimeter;
	}
	
	/**
	 *This method calculates the perimeter of a triangle.
	 *It requires the base, height and hypotenuse so it can compute and then return the perimeter.
	 *@param base the base of the triangle(any side works as long as each one is unique)
	 *@param height the height of the triangle(any side works as long as each one is unique)
	 *@param hypotenuse the hypotenuse of the triangle(any side works as long as each one is unique)
	 *@return It returns the computed perimeter of the given triangle 
	 */
	public static double trianglePerimeter(double base, double height, double hypotenuse)
	{
		double perimeter = hypotenuse+base+height;
		
		return perimeter;
	}

	}
